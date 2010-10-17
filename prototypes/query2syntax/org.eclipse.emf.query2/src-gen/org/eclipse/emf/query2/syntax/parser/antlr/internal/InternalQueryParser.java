package org.eclipse.emf.query2.syntax.parser.antlr.internal; 

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
import org.eclipse.emf.query2.syntax.services.QueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQueryParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "':'", "'from'", "','", "'select'", "'where'", "'.'", "'withoutsubtypes'", "'{'", "'}'", "'as'", "'not'", "'in'", "'resources'", "'elements'", "'or'", "'and'", "'('", "')'", "'?'", "'null'", "'true'", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'not like'", "'not in'"
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
    public String getGrammarFileName() { return "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g"; }



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
        	return classLoader.getResourceAsStream("org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected QueryGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:80:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:87:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_defaultQuery_1_0= ruleMQLquery ) )? ( (lv_namedQueries_2_0= ruleNamedQuery ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_defaultQuery_1_0 = null;

        EObject lv_namedQueries_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:92:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_defaultQuery_1_0= ruleMQLquery ) )? ( (lv_namedQueries_2_0= ruleNamedQuery ) )* ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:93:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_defaultQuery_1_0= ruleMQLquery ) )? ( (lv_namedQueries_2_0= ruleNamedQuery ) )* )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:93:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_defaultQuery_1_0= ruleMQLquery ) )? ( (lv_namedQueries_2_0= ruleNamedQuery ) )* )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:93:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_defaultQuery_1_0= ruleMQLquery ) )? ( (lv_namedQueries_2_0= ruleNamedQuery ) )*
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:93:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:94:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:94:1: (lv_imports_0_0= ruleImport )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:95:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel131);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_0_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:117:3: ( (lv_defaultQuery_1_0= ruleMQLquery ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:118:1: (lv_defaultQuery_1_0= ruleMQLquery )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:118:1: (lv_defaultQuery_1_0= ruleMQLquery )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:119:3: lv_defaultQuery_1_0= ruleMQLquery
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMQLquery_in_ruleModel153);
                    lv_defaultQuery_1_0=ruleMQLquery();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"defaultQuery",
                    	        		lv_defaultQuery_1_0, 
                    	        		"MQLquery", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:141:3: ( (lv_namedQueries_2_0= ruleNamedQuery ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:142:1: (lv_namedQueries_2_0= ruleNamedQuery )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:142:1: (lv_namedQueries_2_0= ruleNamedQuery )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:143:3: lv_namedQueries_2_0= ruleNamedQuery
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedQuery_in_ruleModel175);
            	    lv_namedQueries_2_0=ruleNamedQuery();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"namedQueries",
            	    	        		lv_namedQueries_2_0, 
            	    	        		"NamedQuery", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:173:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:174:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:175:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport212);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport222); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:182:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_impURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_impURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:187:6: ( ( 'import' ( (lv_impURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:188:1: ( 'import' ( (lv_impURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:188:1: ( 'import' ( (lv_impURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:188:3: 'import' ( (lv_impURI_1_0= RULE_STRING ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport257); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:192:1: ( (lv_impURI_1_0= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:193:1: (lv_impURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:193:1: (lv_impURI_1_0= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:194:3: lv_impURI_1_0= RULE_STRING
            {
            lv_impURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport274); 

            			createLeafNode(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0(), "impURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"impURI",
            	        		lv_impURI_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:224:1: entryRuleNamedQuery returns [EObject current=null] : iv_ruleNamedQuery= ruleNamedQuery EOF ;
    public final EObject entryRuleNamedQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedQuery = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:225:2: (iv_ruleNamedQuery= ruleNamedQuery EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:226:2: iv_ruleNamedQuery= ruleNamedQuery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedQueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery315);
            iv_ruleNamedQuery=ruleNamedQuery();
            _fsp--;

             current =iv_ruleNamedQuery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedQuery325); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:233:1: ruleNamedQuery returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_query_2_0= ruleMQLquery ) ) ) ;
    public final EObject ruleNamedQuery() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_query_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:238:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_query_2_0= ruleMQLquery ) ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:239:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_query_2_0= ruleMQLquery ) ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:239:1: ( ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_query_2_0= ruleMQLquery ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:239:2: ( (lv_name_0_0= RULE_ID ) ) ':' ( (lv_query_2_0= ruleMQLquery ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:239:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:240:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:240:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:241:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedQuery367); 

            			createLeafNode(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedQueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleNamedQuery382); 

                    createLeafNode(grammarAccess.getNamedQueryAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:267:1: ( (lv_query_2_0= ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:268:1: (lv_query_2_0= ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:268:1: (lv_query_2_0= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:269:3: lv_query_2_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleNamedQuery403);
            lv_query_2_0=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedQueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"query",
            	        		lv_query_2_0, 
            	        		"MQLquery", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleNamedQuery


    // $ANTLR start entryRuleMQLquery
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:299:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:300:2: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:301:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery439);
            iv_ruleMQLquery=ruleMQLquery();
            _fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery449); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:308:1: ruleMQLquery returns [EObject current=null] : ( 'from' ( (lv_fromEntries_1_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )* 'select' ( (lv_selectEntries_5_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )* ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_fromEntries_1_0 = null;

        EObject lv_fromEntries_3_0 = null;

        EObject lv_selectEntries_5_0 = null;

        EObject lv_selectEntries_7_0 = null;

        EObject lv_whereEntry_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:313:6: ( ( 'from' ( (lv_fromEntries_1_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )* 'select' ( (lv_selectEntries_5_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )* ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:314:1: ( 'from' ( (lv_fromEntries_1_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )* 'select' ( (lv_selectEntries_5_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )* ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:314:1: ( 'from' ( (lv_fromEntries_1_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )* 'select' ( (lv_selectEntries_5_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )* ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:314:3: 'from' ( (lv_fromEntries_1_0= ruleFromEntry ) ) ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )* 'select' ( (lv_selectEntries_5_0= ruleSelectEntry ) ) ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )* ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )?
            {
            match(input,13,FOLLOW_13_in_ruleMQLquery484); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:318:1: ( (lv_fromEntries_1_0= ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:319:1: (lv_fromEntries_1_0= ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:319:1: (lv_fromEntries_1_0= ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:320:3: lv_fromEntries_1_0= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery505);
            lv_fromEntries_1_0=ruleFromEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"fromEntries",
            	        		lv_fromEntries_1_0, 
            	        		"FromEntry", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:342:2: ( ',' ( (lv_fromEntries_3_0= ruleFromEntry ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:342:4: ',' ( (lv_fromEntries_3_0= ruleFromEntry ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery516); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:346:1: ( (lv_fromEntries_3_0= ruleFromEntry ) )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:347:1: (lv_fromEntries_3_0= ruleFromEntry )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:347:1: (lv_fromEntries_3_0= ruleFromEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:348:3: lv_fromEntries_3_0= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery537);
            	    lv_fromEntries_3_0=ruleFromEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"fromEntries",
            	    	        		lv_fromEntries_3_0, 
            	    	        		"FromEntry", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleMQLquery549); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:374:1: ( (lv_selectEntries_5_0= ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:375:1: (lv_selectEntries_5_0= ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:375:1: (lv_selectEntries_5_0= ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:376:3: lv_selectEntries_5_0= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery570);
            lv_selectEntries_5_0=ruleSelectEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"selectEntries",
            	        		lv_selectEntries_5_0, 
            	        		"SelectEntry", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:398:2: ( ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:398:4: ',' ( (lv_selectEntries_7_0= ruleSelectEntry ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery581); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:402:1: ( (lv_selectEntries_7_0= ruleSelectEntry ) )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:403:1: (lv_selectEntries_7_0= ruleSelectEntry )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:403:1: (lv_selectEntries_7_0= ruleSelectEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:404:3: lv_selectEntries_7_0= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery602);
            	    lv_selectEntries_7_0=ruleSelectEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"selectEntries",
            	    	        		lv_selectEntries_7_0, 
            	    	        		"SelectEntry", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:426:4: ( 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:426:6: 'where' ( (lv_whereEntry_9_0= ruleWhereEntry ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleMQLquery615); 

                            createLeafNode(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:430:1: ( (lv_whereEntry_9_0= ruleWhereEntry ) )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:431:1: (lv_whereEntry_9_0= ruleWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:431:1: (lv_whereEntry_9_0= ruleWhereEntry )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:432:3: lv_whereEntry_9_0= ruleWhereEntry
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleWhereEntry_in_ruleMQLquery636);
                    lv_whereEntry_9_0=ruleWhereEntry();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"whereEntry",
                    	        		lv_whereEntry_9_0, 
                    	        		"WhereEntry", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:462:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:463:2: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:464:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry674);
            iv_ruleSelectEntry=ruleSelectEntry();
            _fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry684); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:471:1: ruleSelectEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:476:6: ( ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:477:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:477:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:477:2: ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:477:2: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:478:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:478:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:479:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry727); 

            		createLeafNode(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:491:2: ( '.' ( ( RULE_ID ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:491:4: '.' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleSelectEntry738); 

                            createLeafNode(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:495:1: ( ( RULE_ID ) )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:496:1: ( RULE_ID )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:496:1: ( RULE_ID )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:497:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry756); 

                    		createLeafNode(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0(), "attribute"); 
                    	

                    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:517:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:518:2: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:519:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry794);
            iv_ruleFromEntry=ruleFromEntry();
            _fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry804); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:526:1: ruleFromEntry returns [EObject current=null] : ( ( ( RULE_ID ) ) ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )? 'as' ( (lv_alias_8_0= RULE_ID ) ) ( (lv_scopeClause_9_0= ruleScopeClause ) )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1_0=null;
        Token lv_alias_8_0=null;
        EObject lv_scopeClause_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:531:6: ( ( ( ( RULE_ID ) ) ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )? 'as' ( (lv_alias_8_0= RULE_ID ) ) ( (lv_scopeClause_9_0= ruleScopeClause ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:532:1: ( ( ( RULE_ID ) ) ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )? 'as' ( (lv_alias_8_0= RULE_ID ) ) ( (lv_scopeClause_9_0= ruleScopeClause ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:532:1: ( ( ( RULE_ID ) ) ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )? 'as' ( (lv_alias_8_0= RULE_ID ) ) ( (lv_scopeClause_9_0= ruleScopeClause ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:532:2: ( ( RULE_ID ) ) ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )? 'as' ( (lv_alias_8_0= RULE_ID ) ) ( (lv_scopeClause_9_0= ruleScopeClause ) )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:532:2: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:533:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:533:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:534:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry847); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:546:2: ( ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:546:3: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) ) ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )?
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:546:3: ( (lv_withoutsubtypes_1_0= 'withoutsubtypes' ) )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:547:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:547:1: (lv_withoutsubtypes_1_0= 'withoutsubtypes' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:548:3: lv_withoutsubtypes_1_0= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1_0=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleFromEntry866); 

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


                    }

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:567:2: ( '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:567:4: '{' ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* '}'
                            {
                            match(input,19,FOLLOW_19_in_ruleFromEntry890); 

                                    createLeafNode(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0(), null); 
                                
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:571:1: ( ( RULE_ID ) )
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:572:1: ( RULE_ID )
                            {
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:572:1: ( RULE_ID )
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:573:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry908); 

                            		createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0(), "withoutsubtypesTypes"); 
                            	

                            }


                            }

                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:585:2: ( ',' ( ( RULE_ID ) ) )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==14) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:585:4: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,14,FOLLOW_14_in_ruleFromEntry919); 

                            	            createLeafNode(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:589:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:590:1: ( RULE_ID )
                            	    {
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:590:1: ( RULE_ID )
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:591:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry937); 

                            	    		createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0(), "withoutsubtypesTypes"); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);

                            match(input,20,FOLLOW_20_in_ruleFromEntry949); 

                                    createLeafNode(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruleFromEntry963); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:611:1: ( (lv_alias_8_0= RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:612:1: (lv_alias_8_0= RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:612:1: (lv_alias_8_0= RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:613:3: lv_alias_8_0= RULE_ID
            {
            lv_alias_8_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry980); 

            			createLeafNode(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"alias",
            	        		lv_alias_8_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:635:2: ( (lv_scopeClause_9_0= ruleScopeClause ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=22 && LA11_0<=23)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:636:1: (lv_scopeClause_9_0= ruleScopeClause )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:636:1: (lv_scopeClause_9_0= ruleScopeClause )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:637:3: lv_scopeClause_9_0= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleScopeClause_in_ruleFromEntry1006);
                    lv_scopeClause_9_0=ruleScopeClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"scopeClause",
                    	        		lv_scopeClause_9_0, 
                    	        		"ScopeClause", 
                    	        		currentNode);
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
    // $ANTLR end ruleFromEntry


    // $ANTLR start entryRuleScopeClause
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:667:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:668:2: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:669:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause1043);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause1053); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:676:1: ruleScopeClause returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:681:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==23) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==24) ) {
                        alt12=1;
                    }
                    else if ( (LA12_2==25) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==23) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==24) ) {
                    alt12=1;
                }
                else if ( (LA12_2==25) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("682:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:683:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceScope_in_ruleScopeClause1100);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:693:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleElementScope_in_ruleScopeClause1127);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:709:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:710:2: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:711:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope1162);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope1172); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:718:1: ruleResourceScope returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'resources' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        Token lv_uris_4_0=null;
        Token lv_uris_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:723:6: ( ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'resources' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:724:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'resources' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:724:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'resources' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:724:2: ( (lv_notIn_0_0= 'not' ) )? 'in' 'resources' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:724:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:725:1: (lv_notIn_0_0= 'not' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:725:1: (lv_notIn_0_0= 'not' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:726:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleResourceScope1215); 

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


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleResourceScope1239); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getInKeyword_1(), null); 
                
            match(input,24,FOLLOW_24_in_ruleResourceScope1249); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2(), null); 
                
            match(input,19,FOLLOW_19_in_ruleResourceScope1259); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:757:1: ( (lv_uris_4_0= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:758:1: (lv_uris_4_0= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:758:1: (lv_uris_4_0= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:759:3: lv_uris_4_0= RULE_STRING
            {
            lv_uris_4_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1276); 

            			createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0(), "uris"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"uris",
            	        		lv_uris_4_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:781:2: ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==14) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:781:4: ',' ( (lv_uris_6_0= RULE_STRING ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleResourceScope1292); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:785:1: ( (lv_uris_6_0= RULE_STRING ) )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:786:1: (lv_uris_6_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:786:1: (lv_uris_6_0= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:787:3: lv_uris_6_0= RULE_STRING
            	    {
            	    lv_uris_6_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1309); 

            	    			createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0(), "uris"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"uris",
            	    	        		lv_uris_6_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleResourceScope1326); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:821:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:822:2: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:823:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope1362);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope1372); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:830:1: ruleElementScope returns [EObject current=null] : ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'elements' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0_0=null;
        Token lv_uris_4_0=null;
        Token lv_uris_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:835:6: ( ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'elements' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:836:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'elements' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:836:1: ( ( (lv_notIn_0_0= 'not' ) )? 'in' 'elements' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:836:2: ( (lv_notIn_0_0= 'not' ) )? 'in' 'elements' '{' ( (lv_uris_4_0= RULE_STRING ) ) ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:836:2: ( (lv_notIn_0_0= 'not' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:837:1: (lv_notIn_0_0= 'not' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:837:1: (lv_notIn_0_0= 'not' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:838:3: lv_notIn_0_0= 'not'
                    {
                    lv_notIn_0_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleElementScope1415); 

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


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleElementScope1439); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getInKeyword_1(), null); 
                
            match(input,25,FOLLOW_25_in_ruleElementScope1449); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_2(), null); 
                
            match(input,19,FOLLOW_19_in_ruleElementScope1459); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:869:1: ( (lv_uris_4_0= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:870:1: (lv_uris_4_0= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:870:1: (lv_uris_4_0= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:871:3: lv_uris_4_0= RULE_STRING
            {
            lv_uris_4_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1476); 

            			createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0(), "uris"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"uris",
            	        		lv_uris_4_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:893:2: ( ',' ( (lv_uris_6_0= RULE_STRING ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:893:4: ',' ( (lv_uris_6_0= RULE_STRING ) )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleElementScope1492); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:897:1: ( (lv_uris_6_0= RULE_STRING ) )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:898:1: (lv_uris_6_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:898:1: (lv_uris_6_0= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:899:3: lv_uris_6_0= RULE_STRING
            	    {
            	    lv_uris_6_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1509); 

            	    			createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0(), "uris"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"uris",
            	    	        		lv_uris_6_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleElementScope1526); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:933:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:934:2: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:935:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1562);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry1572); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:942:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:947:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:948:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:948:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:949:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1619);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:957:1: ( () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:957:2: () ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:957:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:958:5: 
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

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:973:2: ( 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) ) )+
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
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:973:4: 'or' ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleWhereEntry1639); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:977:1: ( (lv_entries_3_0= ruleAndWhereEntry ) )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:978:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    {
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:978:1: (lv_entries_3_0= ruleAndWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:979:3: lv_entries_3_0= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1660);
                    	    lv_entries_3_0=ruleAndWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"entries",
                    	    	        		lv_entries_3_0, 
                    	    	        		"AndWhereEntry", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1009:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1010:2: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1011:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1700);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry1710); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1018:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1023:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1024:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1024:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1025:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1757);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1033:1: ( () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1033:2: () ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1033:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1034:5: 
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

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1049:2: ( 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) ) )+
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
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1049:4: 'and' ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    {
                    	    match(input,27,FOLLOW_27_in_ruleAndWhereEntry1777); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1053:1: ( (lv_entries_3_0= ruleConcreteWhereEntry ) )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1054:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    {
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1054:1: (lv_entries_3_0= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1055:3: lv_entries_3_0= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1798);
                    	    lv_entries_3_0=ruleConcreteWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAndWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"entries",
                    	    	        		lv_entries_3_0, 
                    	    	        		"ConcreteWhereEntry", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1085:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1086:2: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1087:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1838);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry1848); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1094:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_ExpressionWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1099:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1100:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1100:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )
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
                    new NoViableAltException("1100:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1101:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1895);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1111:5: this_ExpressionWhereEntry_1= ruleExpressionWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getExpressionWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionWhereEntry_in_ruleConcreteWhereEntry1922);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1127:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1128:2: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1129:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1957);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry1967); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1136:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1141:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1142:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1142:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1142:3: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,28,FOLLOW_28_in_ruleParWhereEntry2002); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2024);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,29,FOLLOW_29_in_ruleParWhereEntry2033); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1167:1: entryRuleExpressionWhereEntry returns [EObject current=null] : iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF ;
    public final EObject entryRuleExpressionWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1168:2: (iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1169:2: iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry2069);
            iv_ruleExpressionWhereEntry=ruleExpressionWhereEntry();
            _fsp--;

             current =iv_ruleExpressionWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionWhereEntry2079); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1176:1: ruleExpressionWhereEntry returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleAliasAttributeExpression ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_rhs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1181:6: ( ( ( (lv_lhs_0_0= ruleAliasAttributeExpression ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1182:1: ( ( (lv_lhs_0_0= ruleAliasAttributeExpression ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1182:1: ( ( (lv_lhs_0_0= ruleAliasAttributeExpression ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1182:2: ( (lv_lhs_0_0= ruleAliasAttributeExpression ) ) ( (lv_operator_1_0= ruleOperator ) ) ( (lv_rhs_2_0= ruleExpression ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1182:2: ( (lv_lhs_0_0= ruleAliasAttributeExpression ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1183:1: (lv_lhs_0_0= ruleAliasAttributeExpression )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1183:1: (lv_lhs_0_0= ruleAliasAttributeExpression )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1184:3: lv_lhs_0_0= ruleAliasAttributeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_ruleExpressionWhereEntry2125);
            lv_lhs_0_0=ruleAliasAttributeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"lhs",
            	        		lv_lhs_0_0, 
            	        		"AliasAttributeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1206:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1207:1: (lv_operator_1_0= ruleOperator )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1207:1: (lv_operator_1_0= ruleOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1208:3: lv_operator_1_0= ruleOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleOperator_in_ruleExpressionWhereEntry2146);
            lv_operator_1_0=ruleOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_1_0, 
            	        		"Operator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1230:2: ( (lv_rhs_2_0= ruleExpression ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1231:1: (lv_rhs_2_0= ruleExpression )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1231:1: (lv_rhs_2_0= ruleExpression )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1232:3: lv_rhs_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionWhereEntry2167);
            lv_rhs_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rhs",
            	        		lv_rhs_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleExpressionWhereEntry


    // $ANTLR start entryRuleAliasAttributeExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1262:1: entryRuleAliasAttributeExpression returns [EObject current=null] : iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF ;
    public final EObject entryRuleAliasAttributeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasAttributeExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1263:2: (iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1264:2: iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasAttributeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression2203);
            iv_ruleAliasAttributeExpression=ruleAliasAttributeExpression();
            _fsp--;

             current =iv_ruleAliasAttributeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasAttributeExpression2213); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1271:1: ruleAliasAttributeExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) ;
    public final EObject ruleAliasAttributeExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1276:6: ( ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1277:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1277:1: ( ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1277:2: ( ( RULE_ID ) ) ( '.' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1277:2: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1278:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1278:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1279:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasAttributeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2256); 

            		createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }


            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1291:2: ( '.' ( ( RULE_ID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1291:4: '.' ( ( RULE_ID ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleAliasAttributeExpression2267); 

                            createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1295:1: ( ( RULE_ID ) )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1296:1: ( RULE_ID )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1296:1: ( RULE_ID )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1297:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAliasAttributeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2285); 

                    		createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0(), "attribute"); 
                    	

                    }


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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1317:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1318:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1319:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2323);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2333); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1326:1: ruleExpression returns [EObject current=null] : (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression | this_ReplacableValue_7= ruleReplacableValue ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AliasAttributeExpression_0 = null;

        EObject this_DoubleExpression_1 = null;

        EObject this_LongExpression_2 = null;

        EObject this_StringExpression_3 = null;

        EObject this_NullExpression_4 = null;

        EObject this_BooleanExpression_5 = null;

        EObject this_QueryExpression_6 = null;

        EObject this_ReplacableValue_7 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1331:6: ( (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression | this_ReplacableValue_7= ruleReplacableValue ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1332:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression | this_ReplacableValue_7= ruleReplacableValue )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1332:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression | this_ReplacableValue_7= ruleReplacableValue )
            int alt23=8;
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
            case 31:
                {
                alt23=5;
                }
                break;
            case 32:
            case 33:
                {
                alt23=6;
                }
                break;
            case 28:
                {
                alt23=7;
                }
                break;
            case 30:
                {
                alt23=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1332:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression | this_ReplacableValue_7= ruleReplacableValue )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1333:5: this_AliasAttributeExpression_0= ruleAliasAttributeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasAttributeExpression_in_ruleExpression2380);
                    this_AliasAttributeExpression_0=ruleAliasAttributeExpression();
                    _fsp--;

                     
                            current = this_AliasAttributeExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1343:5: this_DoubleExpression_1= ruleDoubleExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleExpression_in_ruleExpression2407);
                    this_DoubleExpression_1=ruleDoubleExpression();
                    _fsp--;

                     
                            current = this_DoubleExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1353:5: this_LongExpression_2= ruleLongExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongExpression_in_ruleExpression2434);
                    this_LongExpression_2=ruleLongExpression();
                    _fsp--;

                     
                            current = this_LongExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1363:5: this_StringExpression_3= ruleStringExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringExpression_in_ruleExpression2461);
                    this_StringExpression_3=ruleStringExpression();
                    _fsp--;

                     
                            current = this_StringExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1373:5: this_NullExpression_4= ruleNullExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullExpression_in_ruleExpression2488);
                    this_NullExpression_4=ruleNullExpression();
                    _fsp--;

                     
                            current = this_NullExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1383:5: this_BooleanExpression_5= ruleBooleanExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanExpression_in_ruleExpression2515);
                    this_BooleanExpression_5=ruleBooleanExpression();
                    _fsp--;

                     
                            current = this_BooleanExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1393:5: this_QueryExpression_6= ruleQueryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQueryExpression_in_ruleExpression2542);
                    this_QueryExpression_6=ruleQueryExpression();
                    _fsp--;

                     
                            current = this_QueryExpression_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1403:5: this_ReplacableValue_7= ruleReplacableValue
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getReplacableValueParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReplacableValue_in_ruleExpression2569);
                    this_ReplacableValue_7=ruleReplacableValue();
                    _fsp--;

                     
                            current = this_ReplacableValue_7; 
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


    // $ANTLR start entryRuleReplacableValue
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1419:1: entryRuleReplacableValue returns [EObject current=null] : iv_ruleReplacableValue= ruleReplacableValue EOF ;
    public final EObject entryRuleReplacableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplacableValue = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1420:2: (iv_ruleReplacableValue= ruleReplacableValue EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1421:2: iv_ruleReplacableValue= ruleReplacableValue EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReplacableValueRule(), currentNode); 
            pushFollow(FOLLOW_ruleReplacableValue_in_entryRuleReplacableValue2604);
            iv_ruleReplacableValue=ruleReplacableValue();
            _fsp--;

             current =iv_ruleReplacableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReplacableValue2614); 

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
    // $ANTLR end entryRuleReplacableValue


    // $ANTLR start ruleReplacableValue
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1428:1: ruleReplacableValue returns [EObject current=null] : ( (lv_value_0_0= '?' ) ) ;
    public final EObject ruleReplacableValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1433:6: ( ( (lv_value_0_0= '?' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1434:1: ( (lv_value_0_0= '?' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1434:1: ( (lv_value_0_0= '?' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1435:1: (lv_value_0_0= '?' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1435:1: (lv_value_0_0= '?' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1436:3: lv_value_0_0= '?'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_ruleReplacableValue2656); 

                    createLeafNode(grammarAccess.getReplacableValueAccess().getValueQuestionMarkKeyword_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReplacableValueRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0_0, "?", lastConsumedNode);
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
    // $ANTLR end ruleReplacableValue


    // $ANTLR start entryRuleDoubleExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1463:1: entryRuleDoubleExpression returns [EObject current=null] : iv_ruleDoubleExpression= ruleDoubleExpression EOF ;
    public final EObject entryRuleDoubleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1464:2: (iv_ruleDoubleExpression= ruleDoubleExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1465:2: iv_ruleDoubleExpression= ruleDoubleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression2704);
            iv_ruleDoubleExpression=ruleDoubleExpression();
            _fsp--;

             current =iv_ruleDoubleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleExpression2714); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1472:1: ruleDoubleExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_SIGNED_DOUBLE ) ) ;
    public final EObject ruleDoubleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1477:6: ( ( (lv_value_0_0= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1478:1: ( (lv_value_0_0= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1478:1: ( (lv_value_0_0= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1479:1: (lv_value_0_0= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1479:1: (lv_value_0_0= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1480:3: lv_value_0_0= RULE_SIGNED_DOUBLE
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleExpression2755); 

            			createLeafNode(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"SIGNED_DOUBLE", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleDoubleExpression


    // $ANTLR start entryRuleLongExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1510:1: entryRuleLongExpression returns [EObject current=null] : iv_ruleLongExpression= ruleLongExpression EOF ;
    public final EObject entryRuleLongExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1511:2: (iv_ruleLongExpression= ruleLongExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1512:2: iv_ruleLongExpression= ruleLongExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongExpression_in_entryRuleLongExpression2795);
            iv_ruleLongExpression=ruleLongExpression();
            _fsp--;

             current =iv_ruleLongExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongExpression2805); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1519:1: ruleLongExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_SINGED_LONG ) ) ;
    public final EObject ruleLongExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1524:6: ( ( (lv_value_0_0= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1525:1: ( (lv_value_0_0= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1525:1: ( (lv_value_0_0= RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1526:1: (lv_value_0_0= RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1526:1: (lv_value_0_0= RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1527:3: lv_value_0_0= RULE_SINGED_LONG
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongExpression2846); 

            			createLeafNode(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"SINGED_LONG", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleLongExpression


    // $ANTLR start entryRuleStringExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1557:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1558:2: (iv_ruleStringExpression= ruleStringExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1559:2: iv_ruleStringExpression= ruleStringExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression2886);
            iv_ruleStringExpression=ruleStringExpression();
            _fsp--;

             current =iv_ruleStringExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression2896); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1566:1: ruleStringExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1571:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1572:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1572:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1573:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1573:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1574:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringExpression2937); 

            			createLeafNode(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleStringExpression


    // $ANTLR start entryRuleNullExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1604:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1605:2: (iv_ruleNullExpression= ruleNullExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1606:2: iv_ruleNullExpression= ruleNullExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression2977);
            iv_ruleNullExpression=ruleNullExpression();
            _fsp--;

             current =iv_ruleNullExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression2987); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1613:1: ruleNullExpression returns [EObject current=null] : ( (lv_value_0_0= 'null' ) ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1618:6: ( ( (lv_value_0_0= 'null' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1619:1: ( (lv_value_0_0= 'null' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1619:1: ( (lv_value_0_0= 'null' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1620:1: (lv_value_0_0= 'null' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1620:1: (lv_value_0_0= 'null' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1621:3: lv_value_0_0= 'null'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_ruleNullExpression3029); 

                    createLeafNode(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0_0, "null", lastConsumedNode);
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
    // $ANTLR end ruleNullExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1648:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1649:2: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1650:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3077);
            iv_ruleBooleanExpression=ruleBooleanExpression();
            _fsp--;

             current =iv_ruleBooleanExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression3087); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1657:1: ruleBooleanExpression returns [EObject current=null] : ( ( (lv_true_0_0= 'true' ) ) | 'false' ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_true_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1662:6: ( ( ( (lv_true_0_0= 'true' ) ) | 'false' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1663:1: ( ( (lv_true_0_0= 'true' ) ) | 'false' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1663:1: ( ( (lv_true_0_0= 'true' ) ) | 'false' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            else if ( (LA24_0==33) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1663:1: ( ( (lv_true_0_0= 'true' ) ) | 'false' )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1663:2: ( (lv_true_0_0= 'true' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1663:2: ( (lv_true_0_0= 'true' ) )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1664:1: (lv_true_0_0= 'true' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1664:1: (lv_true_0_0= 'true' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1665:3: lv_true_0_0= 'true'
                    {
                    lv_true_0_0=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleBooleanExpression3130); 

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


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1685:7: 'false'
                    {
                    match(input,33,FOLLOW_33_in_ruleBooleanExpression3159); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1697:1: entryRuleQueryExpression returns [EObject current=null] : iv_ruleQueryExpression= ruleQueryExpression EOF ;
    public final EObject entryRuleQueryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1698:2: (iv_ruleQueryExpression= ruleQueryExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1699:2: iv_ruleQueryExpression= ruleQueryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQueryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression3195);
            iv_ruleQueryExpression=ruleQueryExpression();
            _fsp--;

             current =iv_ruleQueryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryExpression3205); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1706:1: ruleQueryExpression returns [EObject current=null] : ( '(' ( (lv_value_1_0= ruleMQLquery ) ) ')' ) ;
    public final EObject ruleQueryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1711:6: ( ( '(' ( (lv_value_1_0= ruleMQLquery ) ) ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1712:1: ( '(' ( (lv_value_1_0= ruleMQLquery ) ) ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1712:1: ( '(' ( (lv_value_1_0= ruleMQLquery ) ) ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1712:3: '(' ( (lv_value_1_0= ruleMQLquery ) ) ')'
            {
            match(input,28,FOLLOW_28_in_ruleQueryExpression3240); 

                    createLeafNode(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1716:1: ( (lv_value_1_0= ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1717:1: (lv_value_1_0= ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1717:1: (lv_value_1_0= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1718:3: lv_value_1_0= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleQueryExpression3261);
            lv_value_1_0=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getQueryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"MQLquery", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,29,FOLLOW_29_in_ruleQueryExpression3271); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1752:1: ruleOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1756:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1757:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1757:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )
            int alt25=10;
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
            case 38:
                {
                alt25=5;
                }
                break;
            case 39:
                {
                alt25=6;
                }
                break;
            case 40:
                {
                alt25=7;
                }
                break;
            case 41:
                {
                alt25=8;
                }
                break;
            case 42:
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
                    new NoViableAltException("1757:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1757:2: ( '<' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1757:2: ( '<' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1757:4: '<'
                    {
                    match(input,34,FOLLOW_34_in_ruleOperator3319); 

                            current = grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1763:6: ( '>' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1763:6: ( '>' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1763:8: '>'
                    {
                    match(input,35,FOLLOW_35_in_ruleOperator3334); 

                            current = grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1769:6: ( '<=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1769:6: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1769:8: '<='
                    {
                    match(input,36,FOLLOW_36_in_ruleOperator3349); 

                            current = grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1775:6: ( '>=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1775:6: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1775:8: '>='
                    {
                    match(input,37,FOLLOW_37_in_ruleOperator3364); 

                            current = grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1781:6: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1781:6: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1781:8: '='
                    {
                    match(input,38,FOLLOW_38_in_ruleOperator3379); 

                            current = grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1787:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1787:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1787:8: '!='
                    {
                    match(input,39,FOLLOW_39_in_ruleOperator3394); 

                            current = grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1793:6: ( 'like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1793:6: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1793:8: 'like'
                    {
                    match(input,40,FOLLOW_40_in_ruleOperator3409); 

                            current = grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1799:6: ( 'not like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1799:6: ( 'not like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1799:8: 'not like'
                    {
                    match(input,41,FOLLOW_41_in_ruleOperator3424); 

                            current = grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1805:6: ( 'not in' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1805:6: ( 'not in' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1805:8: 'not in'
                    {
                    match(input,42,FOLLOW_42_in_ruleOperator3439); 

                            current = grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1811:6: ( 'in' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1811:6: ( 'in' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/syntax/parser/antlr/internal/InternalQuery.g:1811:8: 'in'
                    {
                    match(input,23,FOLLOW_23_in_ruleOperator3454); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000002822L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel153 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_ruleModel175 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedQuery325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedQuery367 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNamedQuery382 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleNamedQuery403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery484 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery505 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery516 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery537 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleMQLquery549 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery570 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery581 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery602 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_16_in_ruleMQLquery615 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry727 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSelectEntry738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry847 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleFromEntry866 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_ruleFromEntry890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry908 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleFromEntry919 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry937 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleFromEntry949 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFromEntry963 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry980 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause1043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_ruleScopeClause1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_ruleScopeClause1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleResourceScope1215 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleResourceScope1239 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleResourceScope1249 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResourceScope1259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1276 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleResourceScope1292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1309 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleResourceScope1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleElementScope1415 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleElementScope1439 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleElementScope1449 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleElementScope1459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1476 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleElementScope1492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1509 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleElementScope1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1619 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleWhereEntry1639 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1660 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1757 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleAndWhereEntry1777 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1798 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_ruleConcreteWhereEntry1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry1957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry2002 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2024 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleParWhereEntry2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry2069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionWhereEntry2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_ruleExpressionWhereEntry2125 = new BitSet(new long[]{0x000007FC00800000L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleExpressionWhereEntry2146 = new BitSet(new long[]{0x00000003D00000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionWhereEntry2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression2203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasAttributeExpression2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2256 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleAliasAttributeExpression2267 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_ruleExpression2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_ruleExpression2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_ruleExpression2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_ruleExpression2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_ruleExpression2488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleExpression2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_ruleExpression2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReplacableValue_in_ruleExpression2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReplacableValue_in_entryRuleReplacableValue2604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReplacableValue2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleReplacableValue2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleExpression2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleExpression2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_entryRuleLongExpression2795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongExpression2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongExpression2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression2886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringExpression2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression2977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleNullExpression3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBooleanExpression3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanExpression3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression3195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryExpression3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleQueryExpression3240 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleQueryExpression3261 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleQueryExpression3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOperator3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOperator3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOperator3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOperator3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOperator3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperator3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOperator3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOperator3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOperator3439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOperator3454 = new BitSet(new long[]{0x0000000000000002L});

}