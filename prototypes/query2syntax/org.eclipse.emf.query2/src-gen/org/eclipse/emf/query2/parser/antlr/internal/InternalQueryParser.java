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

                    if ( (LA10_2==25) ) {
                        alt10=2;
                    }
                    else if ( (LA10_2==22) ) {
                        alt10=1;
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

                if ( (LA10_2==25) ) {
                    alt10=2;
                }
                else if ( (LA10_2==22) ) {
                    alt10=1;
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:968:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_AbstractAliasWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:973:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry )", 19, 0, input);

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
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:985:5: this_AbstractAliasWhereEntry_1= ruleAbstractAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAbstractAliasWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractAliasWhereEntry_in_ruleConcreteWhereEntry2082);
                    this_AbstractAliasWhereEntry_1=ruleAbstractAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AbstractAliasWhereEntry_1; 
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1000:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1000:55: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1001:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2114);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry2124); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1008:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1013:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1014:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1014:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1014:2: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,28,FOLLOW_28_in_ruleParWhereEntry2158); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2180);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,29,FOLLOW_29_in_ruleParWhereEntry2188); 

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


    // $ANTLR start entryRuleAbstractAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1038:1: entryRuleAbstractAliasWhereEntry returns [EObject current=null] : iv_ruleAbstractAliasWhereEntry= ruleAbstractAliasWhereEntry EOF ;
    public final EObject entryRuleAbstractAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractAliasWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1038:65: (iv_ruleAbstractAliasWhereEntry= ruleAbstractAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1039:2: iv_ruleAbstractAliasWhereEntry= ruleAbstractAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractAliasWhereEntry_in_entryRuleAbstractAliasWhereEntry2221);
            iv_ruleAbstractAliasWhereEntry=ruleAbstractAliasWhereEntry();
            _fsp--;

             current =iv_ruleAbstractAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAliasWhereEntry2231); 

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
    // $ANTLR end entryRuleAbstractAliasWhereEntry


    // $ANTLR start ruleAbstractAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1046:1: ruleAbstractAliasWhereEntry returns [EObject current=null] : (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry ) ;
    public final EObject ruleAbstractAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeWhereEntry_0 = null;

        EObject this_ReferenceWhereEntry_1 = null;

        EObject this_AliasWhereEntry_2 = null;

        EObject this_NullWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1051:6: ( (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )
            int alt20=4;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==33) ) {
                    alt20=3;
                }
                else if ( (LA20_1==17) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 33:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                int LA20_9 = input.LA(6);

                                if ( (LA20_9==17) ) {
                                    alt20=1;
                                }
                                else if ( (LA20_9==EOF||LA20_9==RULE_ID||(LA20_9>=26 && LA20_9<=27)||LA20_9==29) ) {
                                    alt20=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 9, input);

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
                                alt20=1;
                                }
                                break;
                            case 32:
                                {
                                alt20=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 5, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 38:
                            {
                            int LA20_6 = input.LA(5);

                            if ( ((LA20_6>=RULE_STRING && LA20_6<=RULE_SINGED_LONG)||(LA20_6>=30 && LA20_6<=31)) ) {
                                alt20=1;
                            }
                            else if ( (LA20_6==32) ) {
                                alt20=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 20:
                        case 21:
                            {
                            alt20=2;
                            }
                            break;
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 39:
                        case 40:
                            {
                            alt20=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1052:1: (this_AttributeWhereEntry_0= ruleAttributeWhereEntry | this_ReferenceWhereEntry_1= ruleReferenceWhereEntry | this_AliasWhereEntry_2= ruleAliasWhereEntry | this_NullWhereEntry_3= ruleNullWhereEntry )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1053:5: this_AttributeWhereEntry_0= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAliasWhereEntryAccess().getAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_ruleAbstractAliasWhereEntry2278);
                    this_AttributeWhereEntry_0=ruleAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_AttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1063:5: this_ReferenceWhereEntry_1= ruleReferenceWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAliasWhereEntryAccess().getReferenceWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceWhereEntry_in_ruleAbstractAliasWhereEntry2305);
                    this_ReferenceWhereEntry_1=ruleReferenceWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1073:5: this_AliasWhereEntry_2= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAliasWhereEntryAccess().getAliasWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_ruleAbstractAliasWhereEntry2332);
                    this_AliasWhereEntry_2=ruleAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AliasWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1083:5: this_NullWhereEntry_3= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAliasWhereEntryAccess().getNullWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_ruleAbstractAliasWhereEntry2359);
                    this_NullWhereEntry_3=ruleNullWhereEntry();
                    _fsp--;

                     
                            current = this_NullWhereEntry_3; 
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
    // $ANTLR end ruleAbstractAliasWhereEntry


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1098:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1098:61: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1099:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2391);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();
            _fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry2401); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1106:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1111:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt21=4;
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

                            if ( (LA21_4==RULE_ID) ) {
                                alt21=4;
                            }
                            else if ( ((LA21_4>=RULE_SIGNED_DOUBLE && LA21_4<=RULE_SINGED_LONG)) ) {
                                alt21=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA21_5 = input.LA(5);

                            if ( ((LA21_5>=RULE_SIGNED_DOUBLE && LA21_5<=RULE_SINGED_LONG)) ) {
                                alt21=1;
                            }
                            else if ( (LA21_5==RULE_ID) ) {
                                alt21=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA21_6 = input.LA(5);

                            if ( ((LA21_6>=RULE_SIGNED_DOUBLE && LA21_6<=RULE_SINGED_LONG)) ) {
                                alt21=1;
                            }
                            else if ( (LA21_6==RULE_ID) ) {
                                alt21=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA21_7 = input.LA(5);

                            if ( ((LA21_7>=RULE_SIGNED_DOUBLE && LA21_7<=RULE_SINGED_LONG)) ) {
                                alt21=1;
                            }
                            else if ( (LA21_7==RULE_ID) ) {
                                alt21=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                                {
                                alt21=2;
                                }
                                break;
                            case 30:
                            case 31:
                                {
                                alt21=3;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt21=1;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt21=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 8, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 38:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                alt21=4;
                                }
                                break;
                            case 30:
                            case 31:
                                {
                                alt21=3;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt21=1;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt21=2;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 9, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 39:
                        case 40:
                            {
                            alt21=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1112:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1113:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2448);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1123:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2475);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1133:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2502);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1143:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2529);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1158:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1158:68: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1159:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2561);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();
            _fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2571); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1166:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1171:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==17) ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 34:
                            {
                            int LA22_4 = input.LA(5);

                            if ( (LA22_4==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else if ( (LA22_4==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA22_5 = input.LA(5);

                            if ( (LA22_5==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else if ( (LA22_5==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA22_6 = input.LA(5);

                            if ( (LA22_6==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else if ( (LA22_6==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA22_7 = input.LA(5);

                            if ( (LA22_7==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else if ( (LA22_7==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                            {
                            int LA22_8 = input.LA(5);

                            if ( (LA22_8==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else if ( (LA22_8==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 38:
                            {
                            int LA22_9 = input.LA(5);

                            if ( (LA22_9==RULE_SIGNED_DOUBLE) ) {
                                alt22=1;
                            }
                            else if ( (LA22_9==RULE_SINGED_LONG) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1172:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1173:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2618);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();
                    _fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1183:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2645);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1198:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1198:58: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1199:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2677);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();
            _fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry2687); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1206:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1211:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1212:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1212:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1212:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1212:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1215:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2734); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleDoubleWhereEntry2746); 

                    createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1232:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1235:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2768); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1248:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1251:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2805);
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1269:2: (lv_value_4= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1271:6: lv_value_4= RULE_SIGNED_DOUBLE
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2831); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1296:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1296:56: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1297:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2872);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();
            _fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry2882); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1304:1: ruleLongWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1309:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1310:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1310:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1310:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1310:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1313:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2929); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleLongWhereEntry2941); 

                    createLeafNode(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1330:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1333:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2963); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1346:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1349:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry3000);
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1367:2: (lv_value_4= RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1369:6: lv_value_4= RULE_SINGED_LONG
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry3026); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1394:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1394:60: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1395:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry3067);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();
            _fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry3077); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1402:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1407:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1408:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1408:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1408:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1408:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1411:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3124); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleVariableWhereEntry3136); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1428:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1431:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3158); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1444:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1447:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3195);
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1465:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1468:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3221); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleVariableWhereEntry3233); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1485:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1488:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3255); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1508:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1508:67: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1509:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3291);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();
            _fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3301); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1516:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_pattern_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1521:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1522:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1522:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1522:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1522:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1525:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3348); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleStringAttributeWhereEntry3360); 

                    createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1542:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1545:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3382); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1558:2: (lv_operator_3= ruleStringOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1561:6: lv_operator_3= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3419);
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1579:2: (lv_pattern_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1581:6: lv_pattern_4= RULE_STRING
            {
            lv_pattern_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3445); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1606:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1606:68: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1607:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3486);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();
            _fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3496); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1614:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1619:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1620:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1620:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1620:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1620:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1623:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3543); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleBooleanAttributeWhereEntry3555); 

                    createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1640:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1643:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3577); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1656:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1659:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3614);
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1677:2: ( (lv_isTrue_4= 'true' ) | 'false' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            else if ( (LA23_0==31) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1677:2: ( (lv_isTrue_4= 'true' ) | 'false' )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1677:3: (lv_isTrue_4= 'true' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1677:3: (lv_isTrue_4= 'true' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1679:6: lv_isTrue_4= 'true'
                    {
                    lv_isTrue_4=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleBooleanAttributeWhereEntry3640); 

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
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1699:6: 'false'
                    {
                    match(input,31,FOLLOW_31_in_ruleBooleanAttributeWhereEntry3668); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1710:1: entryRuleReferenceWhereEntry returns [EObject current=null] : iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF ;
    public final EObject entryRuleReferenceWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1710:61: (iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1711:2: iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry3702);
            iv_ruleReferenceWhereEntry=ruleReferenceWhereEntry();
            _fsp--;

             current =iv_ruleReferenceWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceWhereEntry3712); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1718:1: ruleReferenceWhereEntry returns [EObject current=null] : (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry ) ;
    public final EObject ruleReferenceWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceAliasWhereEntry_0 = null;

        EObject this_SubselectWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1723:6: ( (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==17) ) {
                    int LA24_2 = input.LA(3);

                    if ( (LA24_2==RULE_ID) ) {
                        int LA24_3 = input.LA(4);

                        if ( (LA24_3==33) ) {
                            alt24=1;
                        }
                        else if ( ((LA24_3>=20 && LA24_3<=21)) ) {
                            alt24=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 24, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 24, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1724:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1725:5: this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_ruleReferenceWhereEntry3759);
                    this_ReferenceAliasWhereEntry_0=ruleReferenceAliasWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1735:5: this_SubselectWhereEntry_1= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReferenceWhereEntryAccess().getSubselectWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_ruleReferenceWhereEntry3786);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1750:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1750:56: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1751:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3818);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();
            _fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry3828); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1758:1: ruleNullWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1763:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1764:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1764:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1764:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1764:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1767:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3875); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleNullWhereEntry3887); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1784:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1787:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3909); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1800:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1803:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3946);
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

            match(input,32,FOLLOW_32_in_ruleNullWhereEntry3959); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1832:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1832:66: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1833:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3992);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();
            _fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry4002); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1840:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1845:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1846:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1846:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1846:2: ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1846:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1849:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4049); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleReferenceAliasWhereEntry4061); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1866:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1869:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4083); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }

            match(input,33,FOLLOW_33_in_ruleReferenceAliasWhereEntry4095); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1886:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1889:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4117); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1909:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1909:61: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1910:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry4153);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();
            _fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry4163); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1917:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_3=null;
        EObject lv_subQuery_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1922:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1923:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1923:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1923:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1923:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1926:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4210); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleSubselectWhereEntry4222); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1943:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1946:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4244); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1959:2: (lv_notIn_3= 'not' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1961:6: lv_notIn_3= 'not'
                    {
                    lv_notIn_3=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleSubselectWhereEntry4268); 

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

            match(input,21,FOLLOW_21_in_ruleSubselectWhereEntry4291); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null); 
                
            match(input,28,FOLLOW_28_in_ruleSubselectWhereEntry4300); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1988:1: (lv_subQuery_6= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1991:6: lv_subQuery_6= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4334);
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

            match(input,29,FOLLOW_29_in_ruleSubselectWhereEntry4347); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2020:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2020:57: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2021:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4380);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();
            _fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry4390); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2028:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2033:6: ( ( ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2034:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2034:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2034:2: ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2034:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2037:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4437); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,33,FOLLOW_33_in_ruleAliasWhereEntry4449); 

                    createLeafNode(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2054:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2057:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4471); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2077:1: ruleNumericOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2081:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt26=1;
                }
                break;
            case 35:
                {
                alt26=2;
                }
                break;
            case 36:
                {
                alt26=3;
                }
                break;
            case 37:
                {
                alt26=4;
                }
                break;
            case 33:
                {
                alt26=5;
                }
                break;
            case 38:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2082:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:2: ( '<' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:2: ( '<' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:4: '<'
                    {
                    match(input,34,FOLLOW_34_in_ruleNumericOperator4521); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2088:6: ( '>' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2088:6: ( '>' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2088:8: '>'
                    {
                    match(input,35,FOLLOW_35_in_ruleNumericOperator4536); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2094:6: ( '<=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2094:6: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2094:8: '<='
                    {
                    match(input,36,FOLLOW_36_in_ruleNumericOperator4551); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2100:6: ( '>=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2100:6: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2100:8: '>='
                    {
                    match(input,37,FOLLOW_37_in_ruleNumericOperator4566); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2106:6: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2106:6: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2106:8: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleNumericOperator4581); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2112:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2112:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2112:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleNumericOperator4596); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2122:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2126:6: ( ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2127:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2127:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt27=1;
                }
                break;
            case 38:
                {
                alt27=2;
                }
                break;
            case 39:
                {
                alt27=3;
                }
                break;
            case 40:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2127:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2127:2: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2127:2: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2127:4: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleStringOperator4639); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2133:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2133:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2133:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleStringOperator4654); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2139:6: ( 'like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2139:6: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2139:8: 'like'
                    {
                    match(input,39,FOLLOW_39_in_ruleStringOperator4669); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2145:6: ( 'notlike' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2145:6: ( 'notlike' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2145:8: 'notlike'
                    {
                    match(input,40,FOLLOW_40_in_ruleStringOperator4684); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2155:1: ruleBooleanOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2159:6: ( ( ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2160:1: ( ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2160:1: ( ( '=' ) | ( '!=' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            else if ( (LA28_0==38) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2160:1: ( ( '=' ) | ( '!=' ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2160:2: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2160:2: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2160:4: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleBooleanOperator4727); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2166:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2166:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2166:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleBooleanOperator4742); 

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
    public static final BitSet FOLLOW_ruleAbstractAliasWhereEntry_in_ruleConcreteWhereEntry2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry2158 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2180 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleParWhereEntry2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAliasWhereEntry_in_entryRuleAbstractAliasWhereEntry2221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAliasWhereEntry2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleAbstractAliasWhereEntry2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_ruleAbstractAliasWhereEntry2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleAbstractAliasWhereEntry2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleAbstractAliasWhereEntry2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2734 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleDoubleWhereEntry2746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2768 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2805 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2929 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLongWhereEntry2941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2963 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry3000 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry3067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3124 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableWhereEntry3136 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3158 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3195 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3221 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableWhereEntry3233 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3348 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStringAttributeWhereEntry3360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3382 = new BitSet(new long[]{0x000001C200000000L});
    public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3543 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBooleanAttributeWhereEntry3555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3577 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3614 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBooleanAttributeWhereEntry3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry3702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceWhereEntry3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleReferenceWhereEntry3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleReferenceWhereEntry3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3875 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleNullWhereEntry3887 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3909 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3946 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleNullWhereEntry3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry4002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4049 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleReferenceAliasWhereEntry4061 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4083 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleReferenceAliasWhereEntry4095 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry4153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4210 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubselectWhereEntry4222 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4244 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry4268 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSubselectWhereEntry4291 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry4300 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4334 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSubselectWhereEntry4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4437 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAliasWhereEntry4449 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleNumericOperator4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleNumericOperator4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleNumericOperator4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNumericOperator4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleNumericOperator4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNumericOperator4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleStringOperator4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringOperator4654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringOperator4669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleStringOperator4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanOperator4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanOperator4742 = new BitSet(new long[]{0x0000000000000002L});

}