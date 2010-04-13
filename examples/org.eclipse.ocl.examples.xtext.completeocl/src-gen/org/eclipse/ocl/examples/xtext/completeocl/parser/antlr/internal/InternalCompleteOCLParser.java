/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: InternalCompleteOCLParser.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal; 

import java.io.InputStream;
import java.util.HashMap;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.CompositeNode;
public class InternalCompleteOCLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING_LITERAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'import'", "'package'", "'endpackage'", "'context'", "':'", "'init'", "'derive'", "'inv'", "'static'", "'def'", "'('", "','", "')'", "'='", "'pre'", "'post'", "'body'", "'^^'", "'^'", "'?'", "'e'", "'E'", "'+'", "'-'", "'Tuple'", "'self'", "'::'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'{'", "'}'", "'..'", "'true'", "'false'", "'*'", "'invalid'", "'null'", "'implies'", "'xor'", "'or'", "'and'", "'<>'", "'>'", "'<'", "'>='", "'<='", "'/'", "'not'", "'->'", "';'", "'|'", "'['", "']'", "'@pre'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING_LITERAL=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalCompleteOCLParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[267+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private CompleteOCLGrammarAccess grammarAccess;
     	
        public InternalCompleteOCLParser(TokenStream input, IAstFactory factory, CompleteOCLGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected CompleteOCLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:83:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:84:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:85:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel91); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:92:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleimportCS ) )* ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_packages_1_0 = null;

        EObject lv_contexts_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:97:6: ( ( ( (lv_imports_0_0= ruleimportCS ) )* ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:98:1: ( ( (lv_imports_0_0= ruleimportCS ) )* ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:98:1: ( ( (lv_imports_0_0= ruleimportCS ) )* ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:98:2: ( (lv_imports_0_0= ruleimportCS ) )* ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )*
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:98:2: ( (lv_imports_0_0= ruleimportCS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:99:1: (lv_imports_0_0= ruleimportCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:99:1: (lv_imports_0_0= ruleimportCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:100:3: lv_imports_0_0= ruleimportCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportCSParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleimportCS_in_ruleModel137);
            	    lv_imports_0_0=ruleimportCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"imports",
            	      	        		lv_imports_0_0, 
            	      	        		"importCS", 
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
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:122:3: ( ( (lv_packages_1_0= rulepackageDeclarationCS ) ) | ( (lv_contexts_2_0= rulecontextDeclCS ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }
                else if ( (LA2_0==15) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:122:4: ( (lv_packages_1_0= rulepackageDeclarationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:122:4: ( (lv_packages_1_0= rulepackageDeclarationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:123:1: (lv_packages_1_0= rulepackageDeclarationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:123:1: (lv_packages_1_0= rulepackageDeclarationCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:124:3: lv_packages_1_0= rulepackageDeclarationCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getPackagesPackageDeclarationCSParserRuleCall_1_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulepackageDeclarationCS_in_ruleModel160);
            	    lv_packages_1_0=rulepackageDeclarationCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"packages",
            	      	        		lv_packages_1_0, 
            	      	        		"packageDeclarationCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:147:6: ( (lv_contexts_2_0= rulecontextDeclCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:147:6: ( (lv_contexts_2_0= rulecontextDeclCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:148:1: (lv_contexts_2_0= rulecontextDeclCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:148:1: (lv_contexts_2_0= rulecontextDeclCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:149:3: lv_contexts_2_0= rulecontextDeclCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getContextsContextDeclCSParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulecontextDeclCS_in_ruleModel187);
            	    lv_contexts_2_0=rulecontextDeclCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"contexts",
            	      	        		lv_contexts_2_0, 
            	      	        		"contextDeclCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:179:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:180:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:181:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN226);
            iv_ruleFQN=ruleFQN();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN237); if (failed) return current;

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:188:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:193:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:194:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:194:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:194:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN277); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:201:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:202:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,11,FOLLOW_11_in_ruleFQN296); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQN311); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleFQN


    // $ANTLR start entryRuleimportCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:222:1: entryRuleimportCS returns [EObject current=null] : iv_ruleimportCS= ruleimportCS EOF ;
    public final EObject entryRuleimportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimportCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:223:2: (iv_ruleimportCS= ruleimportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:224:2: iv_ruleimportCS= ruleimportCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleimportCS_in_entryRuleimportCS358);
            iv_ruleimportCS=ruleimportCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleimportCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleimportCS368); if (failed) return current;

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
    // $ANTLR end entryRuleimportCS


    // $ANTLR start ruleimportCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:231:1: ruleimportCS returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleFQN ) ) ) ;
    public final EObject ruleimportCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:236:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleFQN ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:237:1: ( 'import' ( (lv_importedNamespace_1_0= ruleFQN ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:237:1: ( 'import' ( (lv_importedNamespace_1_0= ruleFQN ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:237:3: 'import' ( (lv_importedNamespace_1_0= ruleFQN ) )
            {
            match(input,12,FOLLOW_12_in_ruleimportCS403); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportCSAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:241:1: ( (lv_importedNamespace_1_0= ruleFQN ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:242:1: (lv_importedNamespace_1_0= ruleFQN )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:242:1: (lv_importedNamespace_1_0= ruleFQN )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:243:3: lv_importedNamespace_1_0= ruleFQN
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getImportCSAccess().getImportedNamespaceFQNParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleFQN_in_ruleimportCS424);
            lv_importedNamespace_1_0=ruleFQN();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getImportCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"importedNamespace",
              	        		lv_importedNamespace_1_0, 
              	        		"FQN", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleimportCS


    // $ANTLR start entryRulepackageDeclarationCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:273:1: entryRulepackageDeclarationCS returns [EObject current=null] : iv_rulepackageDeclarationCS= rulepackageDeclarationCS EOF ;
    public final EObject entryRulepackageDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepackageDeclarationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:274:2: (iv_rulepackageDeclarationCS= rulepackageDeclarationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:275:2: iv_rulepackageDeclarationCS= rulepackageDeclarationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPackageDeclarationCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepackageDeclarationCS_in_entryRulepackageDeclarationCS460);
            iv_rulepackageDeclarationCS=rulepackageDeclarationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepackageDeclarationCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepackageDeclarationCS470); if (failed) return current;

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
    // $ANTLR end entryRulepackageDeclarationCS


    // $ANTLR start rulepackageDeclarationCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:282:1: rulepackageDeclarationCS returns [EObject current=null] : ( 'package' ( (lv_name_1_0= rulepathNameCS ) ) ( (lv_contexts_2_0= rulecontextDeclCS ) )* 'endpackage' ) ;
    public final EObject rulepackageDeclarationCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_1_0 = null;

        EObject lv_contexts_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:287:6: ( ( 'package' ( (lv_name_1_0= rulepathNameCS ) ) ( (lv_contexts_2_0= rulecontextDeclCS ) )* 'endpackage' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:288:1: ( 'package' ( (lv_name_1_0= rulepathNameCS ) ) ( (lv_contexts_2_0= rulecontextDeclCS ) )* 'endpackage' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:288:1: ( 'package' ( (lv_name_1_0= rulepathNameCS ) ) ( (lv_contexts_2_0= rulecontextDeclCS ) )* 'endpackage' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:288:3: 'package' ( (lv_name_1_0= rulepathNameCS ) ) ( (lv_contexts_2_0= rulecontextDeclCS ) )* 'endpackage'
            {
            match(input,13,FOLLOW_13_in_rulepackageDeclarationCS505); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPackageDeclarationCSAccess().getPackageKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:292:1: ( (lv_name_1_0= rulepathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:293:1: (lv_name_1_0= rulepathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:293:1: (lv_name_1_0= rulepathNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:294:3: lv_name_1_0= rulepathNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPackageDeclarationCSAccess().getNamePathNameCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulepathNameCS_in_rulepackageDeclarationCS526);
            lv_name_1_0=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPackageDeclarationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"pathNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:316:2: ( (lv_contexts_2_0= rulecontextDeclCS ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:317:1: (lv_contexts_2_0= rulecontextDeclCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:317:1: (lv_contexts_2_0= rulecontextDeclCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:318:3: lv_contexts_2_0= rulecontextDeclCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPackageDeclarationCSAccess().getContextsContextDeclCSParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulecontextDeclCS_in_rulepackageDeclarationCS547);
            	    lv_contexts_2_0=rulecontextDeclCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getPackageDeclarationCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"contexts",
            	      	        		lv_contexts_2_0, 
            	      	        		"contextDeclCS", 
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

            match(input,14,FOLLOW_14_in_rulepackageDeclarationCS558); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPackageDeclarationCSAccess().getEndpackageKeyword_3(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepackageDeclarationCS


    // $ANTLR start entryRulecontextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:352:1: entryRulecontextDeclCS returns [EObject current=null] : iv_rulecontextDeclCS= rulecontextDeclCS EOF ;
    public final EObject entryRulecontextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecontextDeclCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:353:2: (iv_rulecontextDeclCS= rulecontextDeclCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:354:2: iv_rulecontextDeclCS= rulecontextDeclCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getContextDeclCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecontextDeclCS_in_entryRulecontextDeclCS594);
            iv_rulecontextDeclCS=rulecontextDeclCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecontextDeclCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecontextDeclCS604); if (failed) return current;

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
    // $ANTLR end entryRulecontextDeclCS


    // $ANTLR start rulecontextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:361:1: rulecontextDeclCS returns [EObject current=null] : (this_propertyContextDeclCS_0= rulepropertyContextDeclCS | this_classifierContextDeclCS_1= ruleclassifierContextDeclCS | this_operationContextDeclCS_2= ruleoperationContextDeclCS ) ;
    public final EObject rulecontextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject this_propertyContextDeclCS_0 = null;

        EObject this_classifierContextDeclCS_1 = null;

        EObject this_operationContextDeclCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:366:6: ( (this_propertyContextDeclCS_0= rulepropertyContextDeclCS | this_classifierContextDeclCS_1= ruleclassifierContextDeclCS | this_operationContextDeclCS_2= ruleoperationContextDeclCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:367:1: (this_propertyContextDeclCS_0= rulepropertyContextDeclCS | this_classifierContextDeclCS_1= ruleclassifierContextDeclCS | this_operationContextDeclCS_2= ruleoperationContextDeclCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:367:1: (this_propertyContextDeclCS_0= rulepropertyContextDeclCS | this_classifierContextDeclCS_1= ruleclassifierContextDeclCS | this_operationContextDeclCS_2= ruleoperationContextDeclCS )
            int alt5=3;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:368:2: this_propertyContextDeclCS_0= rulepropertyContextDeclCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getContextDeclCSAccess().getPropertyContextDeclCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepropertyContextDeclCS_in_rulecontextDeclCS654);
                    this_propertyContextDeclCS_0=rulepropertyContextDeclCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_propertyContextDeclCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:381:2: this_classifierContextDeclCS_1= ruleclassifierContextDeclCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getContextDeclCSAccess().getClassifierContextDeclCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleclassifierContextDeclCS_in_rulecontextDeclCS684);
                    this_classifierContextDeclCS_1=ruleclassifierContextDeclCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_classifierContextDeclCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:394:2: this_operationContextDeclCS_2= ruleoperationContextDeclCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getContextDeclCSAccess().getOperationContextDeclCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleoperationContextDeclCS_in_rulecontextDeclCS714);
                    this_operationContextDeclCS_2=ruleoperationContextDeclCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_operationContextDeclCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulecontextDeclCS


    // $ANTLR start entryRulepropertyContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:413:1: entryRulepropertyContextDeclCS returns [EObject current=null] : iv_rulepropertyContextDeclCS= rulepropertyContextDeclCS EOF ;
    public final EObject entryRulepropertyContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepropertyContextDeclCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:414:2: (iv_rulepropertyContextDeclCS= rulepropertyContextDeclCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:415:2: iv_rulepropertyContextDeclCS= rulepropertyContextDeclCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPropertyContextDeclCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepropertyContextDeclCS_in_entryRulepropertyContextDeclCS749);
            iv_rulepropertyContextDeclCS=rulepropertyContextDeclCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepropertyContextDeclCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepropertyContextDeclCS759); if (failed) return current;

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
    // $ANTLR end entryRulepropertyContextDeclCS


    // $ANTLR start rulepropertyContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:422:1: rulepropertyContextDeclCS returns [EObject current=null] : ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) ':' ( (lv_type_3_0= ruletypeCS ) ) ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) ) ) ;
    public final EObject rulepropertyContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject lv_contextName_1_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_init_4_0 = null;

        EObject lv_der_5_0 = null;

        EObject lv_der_6_0 = null;

        EObject lv_init_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:427:6: ( ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) ':' ( (lv_type_3_0= ruletypeCS ) ) ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:428:1: ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) ':' ( (lv_type_3_0= ruletypeCS ) ) ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:428:1: ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) ':' ( (lv_type_3_0= ruletypeCS ) ) ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:428:3: 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) ':' ( (lv_type_3_0= ruletypeCS ) ) ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) )
            {
            match(input,15,FOLLOW_15_in_rulepropertyContextDeclCS794); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPropertyContextDeclCSAccess().getContextKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:432:1: ( (lv_contextName_1_0= rulepathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:433:1: (lv_contextName_1_0= rulepathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:433:1: (lv_contextName_1_0= rulepathNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:434:3: lv_contextName_1_0= rulepathNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulepathNameCS_in_rulepropertyContextDeclCS815);
            lv_contextName_1_0=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"contextName",
              	        		lv_contextName_1_0, 
              	        		"pathNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FOLLOW_16_in_rulepropertyContextDeclCS825); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPropertyContextDeclCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:460:1: ( (lv_type_3_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:461:1: (lv_type_3_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:461:1: (lv_type_3_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:462:3: lv_type_3_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getTypeTypeCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_rulepropertyContextDeclCS846);
            lv_type_3_0=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_3_0, 
              	        		"typeCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:484:2: ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EOF||(LA9_0>=13 && LA9_0<=15)||LA9_0==17) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("484:2: ( ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )? | ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? ) )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:484:3: ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )?
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:484:3: ( ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )? )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==17) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:484:4: ( (lv_init_4_0= ruleinitCS ) ) ( (lv_der_5_0= rulederCS ) )?
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:484:4: ( (lv_init_4_0= ruleinitCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:485:1: (lv_init_4_0= ruleinitCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:485:1: (lv_init_4_0= ruleinitCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:486:3: lv_init_4_0= ruleinitCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getInitInitCSParserRuleCall_4_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS869);
                            lv_init_4_0=ruleinitCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"init",
                              	        		lv_init_4_0, 
                              	        		"initCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:508:2: ( (lv_der_5_0= rulederCS ) )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==18) ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:509:1: (lv_der_5_0= rulederCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:509:1: (lv_der_5_0= rulederCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:510:3: lv_der_5_0= rulederCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getDerDerCSParserRuleCall_4_0_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_rulederCS_in_rulepropertyContextDeclCS890);
                                    lv_der_5_0=rulederCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"der",
                                      	        		lv_der_5_0, 
                                      	        		"derCS", 
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
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:533:6: ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:533:6: ( ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )? )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:533:7: ( (lv_der_6_0= rulederCS ) ) ( (lv_init_7_0= ruleinitCS ) )?
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:533:7: ( (lv_der_6_0= rulederCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:534:1: (lv_der_6_0= rulederCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:534:1: (lv_der_6_0= rulederCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:535:3: lv_der_6_0= rulederCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getDerDerCSParserRuleCall_4_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulederCS_in_rulepropertyContextDeclCS921);
                    lv_der_6_0=rulederCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"der",
                      	        		lv_der_6_0, 
                      	        		"derCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:557:2: ( (lv_init_7_0= ruleinitCS ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==17) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:558:1: (lv_init_7_0= ruleinitCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:558:1: (lv_init_7_0= ruleinitCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:559:3: lv_init_7_0= ruleinitCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getPropertyContextDeclCSAccess().getInitInitCSParserRuleCall_4_1_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS942);
                            lv_init_7_0=ruleinitCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getPropertyContextDeclCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"init",
                              	        		lv_init_7_0, 
                              	        		"initCS", 
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
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepropertyContextDeclCS


    // $ANTLR start entryRuleinitCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:589:1: entryRuleinitCS returns [EObject current=null] : iv_ruleinitCS= ruleinitCS EOF ;
    public final EObject entryRuleinitCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleinitCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:590:2: (iv_ruleinitCS= ruleinitCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:591:2: iv_ruleinitCS= ruleinitCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInitCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleinitCS_in_entryRuleinitCS981);
            iv_ruleinitCS=ruleinitCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleinitCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleinitCS991); if (failed) return current;

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
    // $ANTLR end entryRuleinitCS


    // $ANTLR start ruleinitCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:598:1: ruleinitCS returns [EObject current=null] : ( 'init' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleinitCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:603:6: ( ( 'init' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:604:1: ( 'init' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:604:1: ( 'init' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:604:3: 'init' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) )
            {
            match(input,17,FOLLOW_17_in_ruleinitCS1026); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInitCSAccess().getInitKeyword_0(), null); 
                  
            }
            match(input,16,FOLLOW_16_in_ruleinitCS1036); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInitCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:612:1: ( (lv_expression_2_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:613:1: (lv_expression_2_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:613:1: (lv_expression_2_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:614:3: lv_expression_2_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getInitCSAccess().getExpressionOclExpressionCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleinitCS1057);
            lv_expression_2_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getInitCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_2_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleinitCS


    // $ANTLR start entryRulederCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:644:1: entryRulederCS returns [EObject current=null] : iv_rulederCS= rulederCS EOF ;
    public final EObject entryRulederCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulederCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:645:2: (iv_rulederCS= rulederCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:646:2: iv_rulederCS= rulederCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDerCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulederCS_in_entryRulederCS1093);
            iv_rulederCS=rulederCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulederCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulederCS1103); if (failed) return current;

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
    // $ANTLR end entryRulederCS


    // $ANTLR start rulederCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:653:1: rulederCS returns [EObject current=null] : ( 'derive' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) ) ;
    public final EObject rulederCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:658:6: ( ( 'derive' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:659:1: ( 'derive' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:659:1: ( 'derive' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:659:3: 'derive' ':' ( (lv_expression_2_0= ruleOclExpressionCS ) )
            {
            match(input,18,FOLLOW_18_in_rulederCS1138); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDerCSAccess().getDeriveKeyword_0(), null); 
                  
            }
            match(input,16,FOLLOW_16_in_rulederCS1148); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDerCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:667:1: ( (lv_expression_2_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:668:1: (lv_expression_2_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:668:1: (lv_expression_2_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:669:3: lv_expression_2_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDerCSAccess().getExpressionOclExpressionCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulederCS1169);
            lv_expression_2_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDerCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_2_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulederCS


    // $ANTLR start entryRuleclassifierContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:699:1: entryRuleclassifierContextDeclCS returns [EObject current=null] : iv_ruleclassifierContextDeclCS= ruleclassifierContextDeclCS EOF ;
    public final EObject entryRuleclassifierContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleclassifierContextDeclCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:700:2: (iv_ruleclassifierContextDeclCS= ruleclassifierContextDeclCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:701:2: iv_ruleclassifierContextDeclCS= ruleclassifierContextDeclCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getClassifierContextDeclCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleclassifierContextDeclCS_in_entryRuleclassifierContextDeclCS1205);
            iv_ruleclassifierContextDeclCS=ruleclassifierContextDeclCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleclassifierContextDeclCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleclassifierContextDeclCS1215); if (failed) return current;

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
    // $ANTLR end entryRuleclassifierContextDeclCS


    // $ANTLR start ruleclassifierContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:708:1: ruleclassifierContextDeclCS returns [EObject current=null] : ( 'context' ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )? ( (lv_contextName_3_0= rulepathNameCS ) ) ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )* ) ;
    public final EObject ruleclassifierContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject lv_selfName_1_0 = null;

        EObject lv_contextName_3_0 = null;

        EObject lv_invs_4_0 = null;

        EObject lv_defs_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:713:6: ( ( 'context' ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )? ( (lv_contextName_3_0= rulepathNameCS ) ) ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:714:1: ( 'context' ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )? ( (lv_contextName_3_0= rulepathNameCS ) ) ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:714:1: ( 'context' ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )? ( (lv_contextName_3_0= rulepathNameCS ) ) ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:714:3: 'context' ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )? ( (lv_contextName_3_0= rulepathNameCS ) ) ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )*
            {
            match(input,15,FOLLOW_15_in_ruleclassifierContextDeclCS1250); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getClassifierContextDeclCSAccess().getContextKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:718:1: ( ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==16) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:718:2: ( (lv_selfName_1_0= rulesimpleNameCS ) ) ':'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:718:2: ( (lv_selfName_1_0= rulesimpleNameCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:719:1: (lv_selfName_1_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:719:1: (lv_selfName_1_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:720:3: lv_selfName_1_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getSelfNameSimpleNameCSParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruleclassifierContextDeclCS1272);
                    lv_selfName_1_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"selfName",
                      	        		lv_selfName_1_0, 
                      	        		"simpleNameCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,16,FOLLOW_16_in_ruleclassifierContextDeclCS1282); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getClassifierContextDeclCSAccess().getColonKeyword_1_1(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:746:3: ( (lv_contextName_3_0= rulepathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:747:1: (lv_contextName_3_0= rulepathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:747:1: (lv_contextName_3_0= rulepathNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:748:3: lv_contextName_3_0= rulepathNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulepathNameCS_in_ruleclassifierContextDeclCS1305);
            lv_contextName_3_0=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"contextName",
              	        		lv_contextName_3_0, 
              	        		"pathNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:770:2: ( ( (lv_invs_4_0= ruleinvCS ) ) | ( (lv_defs_5_0= ruledefCS ) ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==19) ) {
                    alt11=1;
                }
                else if ( ((LA11_0>=20 && LA11_0<=21)) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:770:3: ( (lv_invs_4_0= ruleinvCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:770:3: ( (lv_invs_4_0= ruleinvCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:771:1: (lv_invs_4_0= ruleinvCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:771:1: (lv_invs_4_0= ruleinvCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:772:3: lv_invs_4_0= ruleinvCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getInvsInvCSParserRuleCall_3_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleinvCS_in_ruleclassifierContextDeclCS1327);
            	    lv_invs_4_0=ruleinvCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"invs",
            	      	        		lv_invs_4_0, 
            	      	        		"invCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:795:6: ( (lv_defs_5_0= ruledefCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:795:6: ( (lv_defs_5_0= ruledefCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:796:1: (lv_defs_5_0= ruledefCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:796:1: (lv_defs_5_0= ruledefCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:797:3: lv_defs_5_0= ruledefCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getDefsDefCSParserRuleCall_3_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruledefCS_in_ruleclassifierContextDeclCS1354);
            	    lv_defs_5_0=ruledefCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getClassifierContextDeclCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"defs",
            	      	        		lv_defs_5_0, 
            	      	        		"defCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleclassifierContextDeclCS


    // $ANTLR start entryRuleinvCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:827:1: entryRuleinvCS returns [EObject current=null] : iv_ruleinvCS= ruleinvCS EOF ;
    public final EObject entryRuleinvCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleinvCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:828:2: (iv_ruleinvCS= ruleinvCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:829:2: iv_ruleinvCS= ruleinvCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInvCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleinvCS_in_entryRuleinvCS1392);
            iv_ruleinvCS=ruleinvCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleinvCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleinvCS1402); if (failed) return current;

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
    // $ANTLR end entryRuleinvCS


    // $ANTLR start ruleinvCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:836:1: ruleinvCS returns [EObject current=null] : ( 'inv' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleinvCS() throws RecognitionException {
        EObject current = null;

        EObject lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:841:6: ( ( 'inv' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:842:1: ( 'inv' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:842:1: ( 'inv' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:842:3: 'inv' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) )
            {
            match(input,19,FOLLOW_19_in_ruleinvCS1437); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInvCSAccess().getInvKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:846:1: ( (lv_constraintName_1_0= rulesimpleNameCS ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:847:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:847:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:848:3: lv_constraintName_1_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getInvCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruleinvCS1458);
                    lv_constraintName_1_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getInvCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"constraintName",
                      	        		lv_constraintName_1_0, 
                      	        		"simpleNameCS", 
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

            match(input,16,FOLLOW_16_in_ruleinvCS1469); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInvCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:874:1: ( (lv_expression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:875:1: (lv_expression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:875:1: (lv_expression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:876:3: lv_expression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getInvCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleinvCS1490);
            lv_expression_3_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getInvCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_3_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleinvCS


    // $ANTLR start entryRuledefCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:906:1: entryRuledefCS returns [EObject current=null] : iv_ruledefCS= ruledefCS EOF ;
    public final EObject entryRuledefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:907:2: (iv_ruledefCS= ruledefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:908:2: iv_ruledefCS= ruledefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDefCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruledefCS_in_entryRuledefCS1526);
            iv_ruledefCS=ruledefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruledefCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuledefCS1536); if (failed) return current;

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
    // $ANTLR end entryRuledefCS


    // $ANTLR start ruledefCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:915:1: ruledefCS returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? 'def' ( (lv_constraintName_2_0= rulesimpleNameCS ) )? ':' ( (lv_constrainedName_4_0= rulesimpleNameCS ) ) ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )? ':' ( (lv_type_11_0= ruletypeCS ) )? '=' ( (lv_expression_13_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruledefCS() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        EObject lv_constraintName_2_0 = null;

        EObject lv_constrainedName_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_type_11_0 = null;

        EObject lv_expression_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:920:6: ( ( ( (lv_static_0_0= 'static' ) )? 'def' ( (lv_constraintName_2_0= rulesimpleNameCS ) )? ':' ( (lv_constrainedName_4_0= rulesimpleNameCS ) ) ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )? ':' ( (lv_type_11_0= ruletypeCS ) )? '=' ( (lv_expression_13_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:921:1: ( ( (lv_static_0_0= 'static' ) )? 'def' ( (lv_constraintName_2_0= rulesimpleNameCS ) )? ':' ( (lv_constrainedName_4_0= rulesimpleNameCS ) ) ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )? ':' ( (lv_type_11_0= ruletypeCS ) )? '=' ( (lv_expression_13_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:921:1: ( ( (lv_static_0_0= 'static' ) )? 'def' ( (lv_constraintName_2_0= rulesimpleNameCS ) )? ':' ( (lv_constrainedName_4_0= rulesimpleNameCS ) ) ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )? ':' ( (lv_type_11_0= ruletypeCS ) )? '=' ( (lv_expression_13_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:921:2: ( (lv_static_0_0= 'static' ) )? 'def' ( (lv_constraintName_2_0= rulesimpleNameCS ) )? ':' ( (lv_constrainedName_4_0= rulesimpleNameCS ) ) ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )? ':' ( (lv_type_11_0= ruletypeCS ) )? '=' ( (lv_expression_13_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:921:2: ( (lv_static_0_0= 'static' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:922:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:922:1: (lv_static_0_0= 'static' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:923:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruledefCS1579); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDefCSAccess().getStaticStaticKeyword_0_0(), "static"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "static", true, "static", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruledefCS1603); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDefCSAccess().getDefKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:946:1: ( (lv_constraintName_2_0= rulesimpleNameCS ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:947:1: (lv_constraintName_2_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:947:1: (lv_constraintName_2_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:948:3: lv_constraintName_2_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getConstraintNameSimpleNameCSParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruledefCS1624);
                    lv_constraintName_2_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"constraintName",
                      	        		lv_constraintName_2_0, 
                      	        		"simpleNameCS", 
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

            match(input,16,FOLLOW_16_in_ruledefCS1635); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDefCSAccess().getColonKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:974:1: ( (lv_constrainedName_4_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:975:1: (lv_constrainedName_4_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:975:1: (lv_constrainedName_4_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:976:3: lv_constrainedName_4_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getConstrainedNameSimpleNameCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruledefCS1656);
            lv_constrainedName_4_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"constrainedName",
              	        		lv_constrainedName_4_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:998:2: ( '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:998:4: '(' ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )? ')'
                    {
                    match(input,22,FOLLOW_22_in_ruledefCS1667); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDefCSAccess().getLeftParenthesisKeyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1002:1: ( ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1002:2: ( (lv_parameters_6_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )*
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1002:2: ( (lv_parameters_6_0= ruleparameterCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1003:1: (lv_parameters_6_0= ruleparameterCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1003:1: (lv_parameters_6_0= ruleparameterCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1004:3: lv_parameters_6_0= ruleparameterCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getParametersParameterCSParserRuleCall_5_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleparameterCS_in_ruledefCS1689);
                            lv_parameters_6_0=ruleparameterCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"parameters",
                              	        		lv_parameters_6_0, 
                              	        		"parameterCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1026:2: ( ',' ( (lv_parameters_8_0= ruleparameterCS ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==23) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1026:4: ',' ( (lv_parameters_8_0= ruleparameterCS ) )
                            	    {
                            	    match(input,23,FOLLOW_23_in_ruledefCS1700); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getDefCSAccess().getCommaKeyword_5_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1030:1: ( (lv_parameters_8_0= ruleparameterCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1031:1: (lv_parameters_8_0= ruleparameterCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1031:1: (lv_parameters_8_0= ruleparameterCS )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1032:3: lv_parameters_8_0= ruleparameterCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getParametersParameterCSParserRuleCall_5_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleparameterCS_in_ruledefCS1721);
                            	    lv_parameters_8_0=ruleparameterCS();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"parameters",
                            	      	        		lv_parameters_8_0, 
                            	      	        		"parameterCS", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,24,FOLLOW_24_in_ruledefCS1735); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDefCSAccess().getRightParenthesisKeyword_5_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruledefCS1747); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDefCSAccess().getColonKeyword_6(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1062:1: ( (lv_type_11_0= ruletypeCS ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||LA18_0==36||(LA18_0>=39 && LA18_0<=51)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1063:1: (lv_type_11_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1063:1: (lv_type_11_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1064:3: lv_type_11_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getTypeTypeCSParserRuleCall_7_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruledefCS1768);
                    lv_type_11_0=ruletypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_11_0, 
                      	        		"typeCS", 
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

            match(input,25,FOLLOW_25_in_ruledefCS1779); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDefCSAccess().getEqualsSignKeyword_8(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1090:1: ( (lv_expression_13_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1091:1: (lv_expression_13_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1091:1: (lv_expression_13_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1092:3: lv_expression_13_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDefCSAccess().getExpressionOclExpressionCSParserRuleCall_9_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruledefCS1800);
            lv_expression_13_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDefCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_13_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruledefCS


    // $ANTLR start entryRuleoperationContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1122:1: entryRuleoperationContextDeclCS returns [EObject current=null] : iv_ruleoperationContextDeclCS= ruleoperationContextDeclCS EOF ;
    public final EObject entryRuleoperationContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoperationContextDeclCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1123:2: (iv_ruleoperationContextDeclCS= ruleoperationContextDeclCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1124:2: iv_ruleoperationContextDeclCS= ruleoperationContextDeclCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOperationContextDeclCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleoperationContextDeclCS_in_entryRuleoperationContextDeclCS1836);
            iv_ruleoperationContextDeclCS=ruleoperationContextDeclCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleoperationContextDeclCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleoperationContextDeclCS1846); if (failed) return current;

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
    // $ANTLR end entryRuleoperationContextDeclCS


    // $ANTLR start ruleoperationContextDeclCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1131:1: ruleoperationContextDeclCS returns [EObject current=null] : ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) '(' ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )? ')' ':' ( (lv_type_8_0= ruletypeCS ) )? ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )* ) ;
    public final EObject ruleoperationContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject lv_contextName_1_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_type_8_0 = null;

        EObject lv_pres_9_0 = null;

        EObject lv_posts_10_0 = null;

        EObject lv_bodies_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1136:6: ( ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) '(' ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )? ')' ':' ( (lv_type_8_0= ruletypeCS ) )? ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1137:1: ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) '(' ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )? ')' ':' ( (lv_type_8_0= ruletypeCS ) )? ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1137:1: ( 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) '(' ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )? ')' ':' ( (lv_type_8_0= ruletypeCS ) )? ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1137:3: 'context' ( (lv_contextName_1_0= rulepathNameCS ) ) '(' ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )? ')' ':' ( (lv_type_8_0= ruletypeCS ) )? ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )*
            {
            match(input,15,FOLLOW_15_in_ruleoperationContextDeclCS1881); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationContextDeclCSAccess().getContextKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1141:1: ( (lv_contextName_1_0= rulepathNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1142:1: (lv_contextName_1_0= rulepathNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1142:1: (lv_contextName_1_0= rulepathNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1143:3: lv_contextName_1_0= rulepathNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getContextNamePathNameCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulepathNameCS_in_ruleoperationContextDeclCS1902);
            lv_contextName_1_0=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"contextName",
              	        		lv_contextName_1_0, 
              	        		"pathNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,22,FOLLOW_22_in_ruleoperationContextDeclCS1912); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationContextDeclCSAccess().getLeftParenthesisKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1169:1: ( ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1169:2: ( (lv_parameters_3_0= ruleparameterCS ) ) ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1169:2: ( (lv_parameters_3_0= ruleparameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1170:1: (lv_parameters_3_0= ruleparameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1170:1: (lv_parameters_3_0= ruleparameterCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1171:3: lv_parameters_3_0= ruleparameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getParametersParameterCSParserRuleCall_3_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleparameterCS_in_ruleoperationContextDeclCS1934);
                    lv_parameters_3_0=ruleparameterCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"parameters",
                      	        		lv_parameters_3_0, 
                      	        		"parameterCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1193:2: ( ',' ( (lv_parameters_5_0= ruleparameterCS ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1193:4: ',' ( (lv_parameters_5_0= ruleparameterCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleoperationContextDeclCS1945); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getOperationContextDeclCSAccess().getCommaKeyword_3_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1197:1: ( (lv_parameters_5_0= ruleparameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1198:1: (lv_parameters_5_0= ruleparameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1198:1: (lv_parameters_5_0= ruleparameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1199:3: lv_parameters_5_0= ruleparameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getParametersParameterCSParserRuleCall_3_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleparameterCS_in_ruleoperationContextDeclCS1966);
                    	    lv_parameters_5_0=ruleparameterCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"parameters",
                    	      	        		lv_parameters_5_0, 
                    	      	        		"parameterCS", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleoperationContextDeclCS1980); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationContextDeclCSAccess().getRightParenthesisKeyword_4(), null); 
                  
            }
            match(input,16,FOLLOW_16_in_ruleoperationContextDeclCS1990); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationContextDeclCSAccess().getColonKeyword_5(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1229:1: ( (lv_type_8_0= ruletypeCS ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID||LA21_0==36||(LA21_0>=39 && LA21_0<=51)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1230:1: (lv_type_8_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1230:1: (lv_type_8_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1231:3: lv_type_8_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getTypeTypeCSParserRuleCall_6_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleoperationContextDeclCS2011);
                    lv_type_8_0=ruletypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_8_0, 
                      	        		"typeCS", 
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1253:3: ( ( (lv_pres_9_0= rulepreCS ) ) | ( (lv_posts_10_0= rulepostCS ) ) | ( (lv_bodies_11_0= rulebodyCS ) ) )*
            loop22:
            do {
                int alt22=4;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt22=1;
                    }
                    break;
                case 27:
                    {
                    alt22=2;
                    }
                    break;
                case 28:
                    {
                    alt22=3;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1253:4: ( (lv_pres_9_0= rulepreCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1253:4: ( (lv_pres_9_0= rulepreCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1254:1: (lv_pres_9_0= rulepreCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1254:1: (lv_pres_9_0= rulepreCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1255:3: lv_pres_9_0= rulepreCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getPresPreCSParserRuleCall_7_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulepreCS_in_ruleoperationContextDeclCS2034);
            	    lv_pres_9_0=rulepreCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"pres",
            	      	        		lv_pres_9_0, 
            	      	        		"preCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1278:6: ( (lv_posts_10_0= rulepostCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1278:6: ( (lv_posts_10_0= rulepostCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1279:1: (lv_posts_10_0= rulepostCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1279:1: (lv_posts_10_0= rulepostCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1280:3: lv_posts_10_0= rulepostCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getPostsPostCSParserRuleCall_7_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulepostCS_in_ruleoperationContextDeclCS2061);
            	    lv_posts_10_0=rulepostCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"posts",
            	      	        		lv_posts_10_0, 
            	      	        		"postCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1303:6: ( (lv_bodies_11_0= rulebodyCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1303:6: ( (lv_bodies_11_0= rulebodyCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1304:1: (lv_bodies_11_0= rulebodyCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1304:1: (lv_bodies_11_0= rulebodyCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1305:3: lv_bodies_11_0= rulebodyCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOperationContextDeclCSAccess().getBodiesBodyCSParserRuleCall_7_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulebodyCS_in_ruleoperationContextDeclCS2088);
            	    lv_bodies_11_0=rulebodyCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOperationContextDeclCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"bodies",
            	      	        		lv_bodies_11_0, 
            	      	        		"bodyCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleoperationContextDeclCS


    // $ANTLR start entryRuleparameterCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1335:1: entryRuleparameterCS returns [EObject current=null] : iv_ruleparameterCS= ruleparameterCS EOF ;
    public final EObject entryRuleparameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleparameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1336:2: (iv_ruleparameterCS= ruleparameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1337:2: iv_ruleparameterCS= ruleparameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getParameterCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleparameterCS_in_entryRuleparameterCS2126);
            iv_ruleparameterCS=ruleparameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleparameterCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleparameterCS2136); if (failed) return current;

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
    // $ANTLR end entryRuleparameterCS


    // $ANTLR start ruleparameterCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1344:1: ruleparameterCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )? ) ;
    public final EObject ruleparameterCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1349:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1350:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1350:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1350:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1350:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1351:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1351:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1352:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getParameterCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleparameterCS2182);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getParameterCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1374:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==16) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1374:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleparameterCS2193); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getParameterCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1378:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1379:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1379:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1380:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getParameterCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleparameterCS2214);
                    lv_type_2_0=ruletypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getParameterCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"typeCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1402:4: ( '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==25) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1402:6: '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleparameterCS2227); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getParameterCSAccess().getEqualsSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1406:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1407:1: (lv_initExpression_4_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1407:1: (lv_initExpression_4_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1408:3: lv_initExpression_4_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getParameterCSAccess().getInitExpressionOclExpressionCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleparameterCS2248);
                    lv_initExpression_4_0=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getParameterCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"initExpression",
                      	        		lv_initExpression_4_0, 
                      	        		"OclExpressionCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleparameterCS


    // $ANTLR start entryRulepreCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1438:1: entryRulepreCS returns [EObject current=null] : iv_rulepreCS= rulepreCS EOF ;
    public final EObject entryRulepreCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepreCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1439:2: (iv_rulepreCS= rulepreCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1440:2: iv_rulepreCS= rulepreCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepreCS_in_entryRulepreCS2286);
            iv_rulepreCS=rulepreCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepreCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepreCS2296); if (failed) return current;

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
    // $ANTLR end entryRulepreCS


    // $ANTLR start rulepreCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1447:1: rulepreCS returns [EObject current=null] : ( 'pre' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) ;
    public final EObject rulepreCS() throws RecognitionException {
        EObject current = null;

        EObject lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1452:6: ( ( 'pre' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1453:1: ( 'pre' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1453:1: ( 'pre' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1453:3: 'pre' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) )
            {
            match(input,26,FOLLOW_26_in_rulepreCS2331); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPreCSAccess().getPreKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1457:1: ( (lv_constraintName_1_0= rulesimpleNameCS ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1458:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1458:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1459:3: lv_constraintName_1_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getPreCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_rulepreCS2352);
                    lv_constraintName_1_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPreCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"constraintName",
                      	        		lv_constraintName_1_0, 
                      	        		"simpleNameCS", 
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

            match(input,16,FOLLOW_16_in_rulepreCS2363); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPreCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1485:1: ( (lv_expression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1486:1: (lv_expression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1486:1: (lv_expression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1487:3: lv_expression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPreCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulepreCS2384);
            lv_expression_3_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPreCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_3_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepreCS


    // $ANTLR start entryRulepostCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1517:1: entryRulepostCS returns [EObject current=null] : iv_rulepostCS= rulepostCS EOF ;
    public final EObject entryRulepostCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepostCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1518:2: (iv_rulepostCS= rulepostCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1519:2: iv_rulepostCS= rulepostCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPostCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepostCS_in_entryRulepostCS2420);
            iv_rulepostCS=rulepostCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepostCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepostCS2430); if (failed) return current;

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
    // $ANTLR end entryRulepostCS


    // $ANTLR start rulepostCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1526:1: rulepostCS returns [EObject current=null] : ( 'post' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) ;
    public final EObject rulepostCS() throws RecognitionException {
        EObject current = null;

        EObject lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1531:6: ( ( 'post' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1532:1: ( 'post' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1532:1: ( 'post' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1532:3: 'post' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) )
            {
            match(input,27,FOLLOW_27_in_rulepostCS2465); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPostCSAccess().getPostKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1536:1: ( (lv_constraintName_1_0= rulesimpleNameCS ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1537:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1537:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1538:3: lv_constraintName_1_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getPostCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_rulepostCS2486);
                    lv_constraintName_1_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPostCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"constraintName",
                      	        		lv_constraintName_1_0, 
                      	        		"simpleNameCS", 
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

            match(input,16,FOLLOW_16_in_rulepostCS2497); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPostCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1564:1: ( (lv_expression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1565:1: (lv_expression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1565:1: (lv_expression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1566:3: lv_expression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPostCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulepostCS2518);
            lv_expression_3_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPostCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_3_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepostCS


    // $ANTLR start entryRulebodyCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1596:1: entryRulebodyCS returns [EObject current=null] : iv_rulebodyCS= rulebodyCS EOF ;
    public final EObject entryRulebodyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebodyCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1597:2: (iv_rulebodyCS= rulebodyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1598:2: iv_rulebodyCS= rulebodyCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBodyCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulebodyCS_in_entryRulebodyCS2554);
            iv_rulebodyCS=rulebodyCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulebodyCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulebodyCS2564); if (failed) return current;

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
    // $ANTLR end entryRulebodyCS


    // $ANTLR start rulebodyCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1605:1: rulebodyCS returns [EObject current=null] : ( 'body' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) ;
    public final EObject rulebodyCS() throws RecognitionException {
        EObject current = null;

        EObject lv_constraintName_1_0 = null;

        EObject lv_expression_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1610:6: ( ( 'body' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1611:1: ( 'body' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1611:1: ( 'body' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1611:3: 'body' ( (lv_constraintName_1_0= rulesimpleNameCS ) )? ':' ( (lv_expression_3_0= ruleOclExpressionCS ) )
            {
            match(input,28,FOLLOW_28_in_rulebodyCS2599); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBodyCSAccess().getBodyKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1615:1: ( (lv_constraintName_1_0= rulesimpleNameCS ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1616:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1616:1: (lv_constraintName_1_0= rulesimpleNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1617:3: lv_constraintName_1_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getBodyCSAccess().getConstraintNameSimpleNameCSParserRuleCall_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_rulebodyCS2620);
                    lv_constraintName_1_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getBodyCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"constraintName",
                      	        		lv_constraintName_1_0, 
                      	        		"simpleNameCS", 
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

            match(input,16,FOLLOW_16_in_rulebodyCS2631); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getBodyCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1643:1: ( (lv_expression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1644:1: (lv_expression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1644:1: (lv_expression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1645:3: lv_expression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getBodyCSAccess().getExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulebodyCS2652);
            lv_expression_3_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBodyCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expression",
              	        		lv_expression_3_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulebodyCS


    // $ANTLR start entryRulenamedConstraintCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1677:1: entryRulenamedConstraintCS returns [EObject current=null] : iv_rulenamedConstraintCS= rulenamedConstraintCS EOF ;
    public final EObject entryRulenamedConstraintCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulenamedConstraintCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1678:2: (iv_rulenamedConstraintCS= rulenamedConstraintCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1679:2: iv_rulenamedConstraintCS= rulenamedConstraintCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNamedConstraintCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulenamedConstraintCS_in_entryRulenamedConstraintCS2690);
            iv_rulenamedConstraintCS=rulenamedConstraintCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulenamedConstraintCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulenamedConstraintCS2700); if (failed) return current;

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
    // $ANTLR end entryRulenamedConstraintCS


    // $ANTLR start rulenamedConstraintCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1686:1: rulenamedConstraintCS returns [EObject current=null] : (this_bodyCS_0= rulebodyCS | this_defCS_1= ruledefCS | this_invCS_2= ruleinvCS | this_postCS_3= rulepostCS | this_preCS_4= rulepreCS ) ;
    public final EObject rulenamedConstraintCS() throws RecognitionException {
        EObject current = null;

        EObject this_bodyCS_0 = null;

        EObject this_defCS_1 = null;

        EObject this_invCS_2 = null;

        EObject this_postCS_3 = null;

        EObject this_preCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1691:6: ( (this_bodyCS_0= rulebodyCS | this_defCS_1= ruledefCS | this_invCS_2= ruleinvCS | this_postCS_3= rulepostCS | this_preCS_4= rulepreCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1692:1: (this_bodyCS_0= rulebodyCS | this_defCS_1= ruledefCS | this_invCS_2= ruleinvCS | this_postCS_3= rulepostCS | this_preCS_4= rulepreCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1692:1: (this_bodyCS_0= rulebodyCS | this_defCS_1= ruledefCS | this_invCS_2= ruleinvCS | this_postCS_3= rulepostCS | this_preCS_4= rulepreCS )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt28=1;
                }
                break;
            case 20:
            case 21:
                {
                alt28=2;
                }
                break;
            case 19:
                {
                alt28=3;
                }
                break;
            case 27:
                {
                alt28=4;
                }
                break;
            case 26:
                {
                alt28=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1692:1: (this_bodyCS_0= rulebodyCS | this_defCS_1= ruledefCS | this_invCS_2= ruleinvCS | this_postCS_3= rulepostCS | this_preCS_4= rulepreCS )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1693:2: this_bodyCS_0= rulebodyCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNamedConstraintCSAccess().getBodyCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulebodyCS_in_rulenamedConstraintCS2750);
                    this_bodyCS_0=rulebodyCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_bodyCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1706:2: this_defCS_1= ruledefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNamedConstraintCSAccess().getDefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruledefCS_in_rulenamedConstraintCS2780);
                    this_defCS_1=ruledefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_defCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1719:2: this_invCS_2= ruleinvCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNamedConstraintCSAccess().getInvCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleinvCS_in_rulenamedConstraintCS2810);
                    this_invCS_2=ruleinvCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_invCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1732:2: this_postCS_3= rulepostCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNamedConstraintCSAccess().getPostCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepostCS_in_rulenamedConstraintCS2840);
                    this_postCS_3=rulepostCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_postCS_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1745:2: this_preCS_4= rulepreCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNamedConstraintCSAccess().getPreCSParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepreCS_in_rulenamedConstraintCS2870);
                    this_preCS_4=rulepreCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_preCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulenamedConstraintCS


    // $ANTLR start entryRuleextendedPrimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1764:1: entryRuleextendedPrimaryExpCS returns [EObject current=null] : iv_ruleextendedPrimaryExpCS= ruleextendedPrimaryExpCS EOF ;
    public final EObject entryRuleextendedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleextendedPrimaryExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1765:2: (iv_ruleextendedPrimaryExpCS= ruleextendedPrimaryExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1766:2: iv_ruleextendedPrimaryExpCS= ruleextendedPrimaryExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getExtendedPrimaryExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleextendedPrimaryExpCS_in_entryRuleextendedPrimaryExpCS2905);
            iv_ruleextendedPrimaryExpCS=ruleextendedPrimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleextendedPrimaryExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleextendedPrimaryExpCS2915); if (failed) return current;

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
    // $ANTLR end entryRuleextendedPrimaryExpCS


    // $ANTLR start ruleextendedPrimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1773:1: ruleextendedPrimaryExpCS returns [EObject current=null] : (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS ) ;
    @SuppressWarnings("unused")
	public final EObject ruleextendedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_primaryExpCS_0 = null;

        EObject this_OclMessageExpCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1778:6: ( (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )
            int alt29=2;
            switch ( input.LA(1) ) {
            case 37:
                {
                int LA29_1 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 1, input);

                    throw nvae;
                }
                }
                break;
            case 47:
                {
                int LA29_2 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                int LA29_3 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case 50:
                {
                int LA29_5 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 5, input);

                    throw nvae;
                }
                }
                break;
            case 51:
                {
                int LA29_6 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 6, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                int LA29_7 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 7, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA29_8 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 8, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING_LITERAL:
                {
                int LA29_9 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 9, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                int LA29_10 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 10, input);

                    throw nvae;
                }
                }
                break;
            case 56:
                {
                int LA29_11 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 11, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA29_12 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 12, input);

                    throw nvae;
                }
                }
                break;
            case 58:
                {
                int LA29_13 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 13, input);

                    throw nvae;
                }
                }
                break;
            case 59:
                {
                int LA29_14 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 14, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA29_15 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 15, input);

                    throw nvae;
                }
                }
                break;
            case 39:
                {
                int LA29_16 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 16, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                int LA29_17 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 17, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                int LA29_18 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 18, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                int LA29_19 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 19, input);

                    throw nvae;
                }
                }
                break;
            case 43:
                {
                int LA29_20 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 20, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA29_21 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 21, input);

                    throw nvae;
                }
                }
                break;
            case 45:
                {
                int LA29_22 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 22, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA29_23 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 23, input);

                    throw nvae;
                }
                }
                break;
            case 77:
                {
                int LA29_24 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 24, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA29_25 = input.LA(2);

                if ( (synpred37()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 25, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1779:1: (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1780:2: this_primaryExpCS_0= ruleprimaryExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExtendedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimaryExpCS_in_ruleextendedPrimaryExpCS2965);
                    this_primaryExpCS_0=ruleprimaryExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_primaryExpCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1793:2: this_OclMessageExpCS_1= ruleOclMessageExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getExtendedPrimaryExpCSAccess().getOclMessageExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclMessageExpCS_in_ruleextendedPrimaryExpCS2995);
                    this_OclMessageExpCS_1=ruleOclMessageExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OclMessageExpCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleextendedPrimaryExpCS


    // $ANTLR start entryRuleOclMessageExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1812:1: entryRuleOclMessageExpCS returns [EObject current=null] : iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF ;
    public final EObject entryRuleOclMessageExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclMessageExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1813:2: (iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1814:2: iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclMessageExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclMessageExpCS_in_entryRuleOclMessageExpCS3030);
            iv_ruleOclMessageExpCS=ruleOclMessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclMessageExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclMessageExpCS3040); if (failed) return current;

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
    // $ANTLR end entryRuleOclMessageExpCS


    // $ANTLR start ruleOclMessageExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1821:1: ruleOclMessageExpCS returns [EObject current=null] : ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' ) ;
    public final EObject ruleOclMessageExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_source_0_0 = null;

        EObject lv_messageName_2_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1826:6: ( ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:1: ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:1: ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:2: ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:2: ( (lv_source_0_0= ruleprimaryExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1828:1: (lv_source_0_0= ruleprimaryExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1828:1: (lv_source_0_0= ruleprimaryExpCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1829:3: lv_source_0_0= ruleprimaryExpCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getSourcePrimaryExpCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_ruleOclMessageExpCS3086);
            lv_source_0_0=ruleprimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"source",
              	        		lv_source_0_0, 
              	        		"primaryExpCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1851:2: ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1852:1: ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1852:1: ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1853:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1853:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            else if ( (LA30_0==30) ) {
                alt30=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1853:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1854:3: lv_op_1_1= '^^'
                    {
                    lv_op_1_1=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleOclMessageExpCS3106); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOclMessageExpCSAccess().getOpCircumflexAccentCircumflexAccentKeyword_1_0_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_1_1, null, lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1872:8: lv_op_1_2= '^'
                    {
                    lv_op_1_2=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleOclMessageExpCS3135); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOclMessageExpCSAccess().getOpCircumflexAccentKeyword_1_0_1(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_1_2, null, lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1893:2: ( (lv_messageName_2_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1894:1: (lv_messageName_2_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1894:1: (lv_messageName_2_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1895:3: lv_messageName_2_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getMessageNameSimpleNameCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleOclMessageExpCS3172);
            lv_messageName_2_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"messageName",
              	        		lv_messageName_2_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,22,FOLLOW_22_in_ruleOclMessageExpCS3182); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOclMessageExpCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1921:1: ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_STRING_LITERAL)||LA32_0==22||LA32_0==31||(LA32_0>=35 && LA32_0<=37)||(LA32_0>=39 && LA32_0<=51)||(LA32_0>=55 && LA32_0<=59)||LA32_0==70||LA32_0==77||LA32_0==81) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1921:2: ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1921:2: ( (lv_arguments_4_0= ruleOclMessageArgCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1922:1: (lv_arguments_4_0= ruleOclMessageArgCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1922:1: (lv_arguments_4_0= ruleOclMessageArgCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1923:3: lv_arguments_4_0= ruleOclMessageArgCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3204);
                    lv_arguments_4_0=ruleOclMessageArgCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"arguments",
                      	        		lv_arguments_4_0, 
                      	        		"OclMessageArgCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1945:2: ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==23) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1945:4: ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleOclMessageExpCS3215); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getOclMessageExpCSAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1949:1: ( (lv_arguments_6_0= ruleOclMessageArgCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1950:1: (lv_arguments_6_0= ruleOclMessageArgCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1950:1: (lv_arguments_6_0= ruleOclMessageArgCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1951:3: lv_arguments_6_0= ruleOclMessageArgCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3236);
                    	    lv_arguments_6_0=ruleOclMessageArgCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOclMessageExpCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"arguments",
                    	      	        		lv_arguments_6_0, 
                    	      	        		"OclMessageArgCS", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleOclMessageExpCS3250); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOclMessageExpCSAccess().getRightParenthesisKeyword_5(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOclMessageExpCS


    // $ANTLR start entryRuleOclMessageArgCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1985:1: entryRuleOclMessageArgCS returns [EObject current=null] : iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF ;
    public final EObject entryRuleOclMessageArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclMessageArgCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1986:2: (iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1987:2: iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclMessageArgCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclMessageArgCS_in_entryRuleOclMessageArgCS3286);
            iv_ruleOclMessageArgCS=ruleOclMessageArgCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclMessageArgCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclMessageArgCS3296); if (failed) return current;

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
    // $ANTLR end entryRuleOclMessageArgCS


    // $ANTLR start ruleOclMessageArgCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1994:1: ruleOclMessageArgCS returns [EObject current=null] : ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS ) ;
    public final EObject ruleOclMessageArgCS() throws RecognitionException {
        EObject current = null;

        EObject lv_type_3_0 = null;

        EObject this_OclExpressionCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1999:6: ( ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==31) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING_LITERAL)||LA34_0==22||(LA34_0>=35 && LA34_0<=37)||(LA34_0>=39 && LA34_0<=51)||(LA34_0>=55 && LA34_0<=59)||LA34_0==70||LA34_0==77||LA34_0==81) ) {
                alt34=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2000:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:2: ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:2: ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:3: () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )?
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:3: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2001:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getOclMessageArgCSAccess().getOclMessageArgCSAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getOclMessageArgCSAccess().getOclMessageArgCSAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,31,FOLLOW_31_in_ruleOclMessageArgCS3344); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOclMessageArgCSAccess().getQuestionMarkKeyword_0_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2018:1: ( ':' ( (lv_type_3_0= ruletypeCS ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==16) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2018:3: ':' ( (lv_type_3_0= ruletypeCS ) )
                            {
                            match(input,16,FOLLOW_16_in_ruleOclMessageArgCS3355); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getOclMessageArgCSAccess().getColonKeyword_0_2_0(), null); 
                                  
                            }
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2022:1: ( (lv_type_3_0= ruletypeCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2023:1: (lv_type_3_0= ruletypeCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2023:1: (lv_type_3_0= ruletypeCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2024:3: lv_type_3_0= ruletypeCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOclMessageArgCSAccess().getTypeTypeCSParserRuleCall_0_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruletypeCS_in_ruleOclMessageArgCS3376);
                            lv_type_3_0=ruletypeCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getOclMessageArgCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"type",
                              	        		lv_type_3_0, 
                              	        		"typeCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2048:2: this_OclExpressionCS_4= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclMessageArgCSAccess().getOclExpressionCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleOclMessageArgCS3410);
                    this_OclExpressionCS_4=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OclExpressionCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOclMessageArgCS


    // $ANTLR start entryRuleREAL_LITERAL
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2067:1: entryRuleREAL_LITERAL returns [String current=null] : iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF ;
    public final String entryRuleREAL_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2068:2: (iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2069:2: iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getREAL_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL3446);
            iv_ruleREAL_LITERAL=ruleREAL_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleREAL_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL_LITERAL3457); if (failed) return current;

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
    // $ANTLR end entryRuleREAL_LITERAL


    // $ANTLR start ruleREAL_LITERAL
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2076:1: ruleREAL_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) ;
    public final AntlrDatatypeRuleToken ruleREAL_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2081:6: ( (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2082:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2082:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2082:6: this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3497); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2089:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==11) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==RULE_INT) ) {
                    int LA38_3 = input.LA(3);

                    if ( ((LA38_3>=32 && LA38_3<=33)) ) {
                        alt38=2;
                    }
                    else if ( (LA38_3==EOF||LA38_3==11||(LA38_3>=13 && LA38_3<=15)||(LA38_3>=17 && LA38_3<=21)||(LA38_3>=23 && LA38_3<=30)||(LA38_3>=34 && LA38_3<=35)||(LA38_3>=53 && LA38_3<=54)||LA38_3==57||(LA38_3>=60 && LA38_3<=69)||LA38_3==71||LA38_3==73||LA38_3==75||(LA38_3>=78 && LA38_3<=80)||LA38_3==82) ) {
                        alt38=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2089:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 38, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2089:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 38, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA38_0>=32 && LA38_0<=33)) ) {
                alt38=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2089:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2089:2: (kw= '.' this_INT_2= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2089:2: (kw= '.' this_INT_2= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2090:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleREAL_LITERAL3517); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_0_0(), null); 
                          
                    }
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3532); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_2);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_1_0_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2103:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2103:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2103:7: (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2103:7: (kw= '.' this_INT_4= RULE_INT )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==11) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2104:2: kw= '.' this_INT_4= RULE_INT
                            {
                            kw=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_ruleREAL_LITERAL3559); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_1_0_0(), null); 
                                  
                            }
                            this_INT_4=(Token)input.LT(1);
                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3574); if (failed) return current;
                            if ( backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( backtracking==0 ) {
                               
                                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_1_1_0_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2116:3: (kw= 'e' | kw= 'E' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==32) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==33) ) {
                        alt36=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2116:3: (kw= 'e' | kw= 'E' )", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2117:2: kw= 'e'
                            {
                            kw=(Token)input.LT(1);
                            match(input,32,FOLLOW_32_in_ruleREAL_LITERAL3595); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2124:2: kw= 'E'
                            {
                            kw=(Token)input.LT(1);
                            match(input,33,FOLLOW_33_in_ruleREAL_LITERAL3614); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2129:2: (kw= '+' | kw= '-' )?
                    int alt37=3;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==34) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==35) ) {
                        alt37=2;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2130:2: kw= '+'
                            {
                            kw=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleREAL_LITERAL3629); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getPlusSignKeyword_1_1_2_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2137:2: kw= '-'
                            {
                            kw=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleREAL_LITERAL3648); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getHyphenMinusKeyword_1_1_2_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    this_INT_9=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3665); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_9);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_1_1_3(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleREAL_LITERAL


    // $ANTLR start entryRuleINTEGER_LITERAL
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2157:1: entryRuleINTEGER_LITERAL returns [String current=null] : iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF ;
    public final String entryRuleINTEGER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2158:2: (iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2159:2: iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getINTEGER_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL3713);
            iv_ruleINTEGER_LITERAL=ruleINTEGER_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleINTEGER_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER_LITERAL3724); if (failed) return current;

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
    // $ANTLR end entryRuleINTEGER_LITERAL


    // $ANTLR start ruleINTEGER_LITERAL
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2166:1: ruleINTEGER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleINTEGER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2171:6: (this_INT_0= RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2172:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL3763); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getINTEGER_LITERALAccess().getINTTerminalRuleCall(), null); 
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleINTEGER_LITERAL


    // $ANTLR start entryRuletupleKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2187:1: entryRuletupleKeywordCS returns [EObject current=null] : iv_ruletupleKeywordCS= ruletupleKeywordCS EOF ;
    public final EObject entryRuletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2188:2: (iv_ruletupleKeywordCS= ruletupleKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2189:2: iv_ruletupleKeywordCS= ruletupleKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS3807);
            iv_ruletupleKeywordCS=ruletupleKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleKeywordCS3817); if (failed) return current;

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
    // $ANTLR end entryRuletupleKeywordCS


    // $ANTLR start ruletupleKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2196:1: ruletupleKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'Tuple' ) ) ;
    public final EObject ruletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2201:6: ( ( (lv_value_0_0= 'Tuple' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2202:1: ( (lv_value_0_0= 'Tuple' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2202:1: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2203:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2203:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2204:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_ruletupleKeywordCS3859); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleKeywordCSAccess().getValueTupleKeyword_0(), "value"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTupleKeywordCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "value", lv_value_0_0, "Tuple", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruletupleKeywordCS


    // $ANTLR start entryRulerestrictedKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2231:1: entryRulerestrictedKeywordCS returns [EObject current=null] : iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF ;
    public final EObject entryRulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerestrictedKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2232:2: (iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2233:2: iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRestrictedKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS3907);
            iv_rulerestrictedKeywordCS=rulerestrictedKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerestrictedKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerestrictedKeywordCS3917); if (failed) return current;

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
    // $ANTLR end entryRulerestrictedKeywordCS


    // $ANTLR start rulerestrictedKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2240:1: rulerestrictedKeywordCS returns [EObject current=null] : (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) ;
    public final EObject rulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeIdentifierCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_tupleKeywordCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2245:6: ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2246:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2246:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt39=1;
                }
                break;
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt39=2;
                }
                break;
            case 36:
                {
                alt39=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2246:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2247:2: this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS3967);
                    this_CollectionTypeIdentifierCS_0=ruleCollectionTypeIdentifierCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CollectionTypeIdentifierCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2260:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS3997);
                    this_primitiveTypeCS_1=ruleprimitiveTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_primitiveTypeCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2273:2: this_tupleKeywordCS_2= ruletupleKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getTupleKeywordCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS4027);
                    this_tupleKeywordCS_2=ruletupleKeywordCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_tupleKeywordCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulerestrictedKeywordCS


    // $ANTLR start entryRuleselfKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2292:1: entryRuleselfKeywordCS returns [EObject current=null] : iv_ruleselfKeywordCS= ruleselfKeywordCS EOF ;
    public final EObject entryRuleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleselfKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2293:2: (iv_ruleselfKeywordCS= ruleselfKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2294:2: iv_ruleselfKeywordCS= ruleselfKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSelfKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS4062);
            iv_ruleselfKeywordCS=ruleselfKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleselfKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleselfKeywordCS4072); if (failed) return current;

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
    // $ANTLR end entryRuleselfKeywordCS


    // $ANTLR start ruleselfKeywordCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2301:1: ruleselfKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'self' ) ) ;
    public final EObject ruleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2306:6: ( ( (lv_value_0_0= 'self' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2307:1: ( (lv_value_0_0= 'self' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2307:1: ( (lv_value_0_0= 'self' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2308:1: (lv_value_0_0= 'self' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2308:1: (lv_value_0_0= 'self' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2309:3: lv_value_0_0= 'self'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_ruleselfKeywordCS4114); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSelfKeywordCSAccess().getValueSelfKeyword_0(), "value"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSelfKeywordCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "value", lv_value_0_0, "self", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleselfKeywordCS


    // $ANTLR start entryRulesimpleNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2336:1: entryRulesimpleNameCS returns [EObject current=null] : iv_rulesimpleNameCS= rulesimpleNameCS EOF ;
    public final EObject entryRulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2337:2: (iv_rulesimpleNameCS= rulesimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2338:2: iv_rulesimpleNameCS= rulesimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS4162);
            iv_rulesimpleNameCS=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulesimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulesimpleNameCS4172); if (failed) return current;

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
    // $ANTLR end entryRulesimpleNameCS


    // $ANTLR start rulesimpleNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2345:1: rulesimpleNameCS returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject rulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2350:6: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2351:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2351:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2352:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2352:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2353:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulesimpleNameCS4213); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSimpleNameCSAccess().getValueIDTerminalRuleCall_0(), "value"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleNameCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulesimpleNameCS


    // $ANTLR start entryRuleunreservedSimpleNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2383:1: entryRuleunreservedSimpleNameCS returns [EObject current=null] : iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF ;
    public final EObject entryRuleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunreservedSimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2384:2: (iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2385:2: iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnreservedSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS4253);
            iv_ruleunreservedSimpleNameCS=ruleunreservedSimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunreservedSimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS4263); if (failed) return current;

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
    // $ANTLR end entryRuleunreservedSimpleNameCS


    // $ANTLR start ruleunreservedSimpleNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2392:1: ruleunreservedSimpleNameCS returns [EObject current=null] : (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) ;
    public final EObject ruleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject this_simpleNameCS_0 = null;

        EObject this_restrictedKeywordCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2397:6: ( (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2398:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2398:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==36||(LA40_0>=39 && LA40_0<=51)) ) {
                alt40=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2398:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2399:2: this_simpleNameCS_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getSimpleNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS4313);
                    this_simpleNameCS_0=rulesimpleNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_simpleNameCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2412:2: this_restrictedKeywordCS_1= rulerestrictedKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getRestrictedKeywordCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS4343);
                    this_restrictedKeywordCS_1=rulerestrictedKeywordCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_restrictedKeywordCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleunreservedSimpleNameCS


    // $ANTLR start entryRulepathNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2431:1: entryRulepathNameCS returns [EObject current=null] : iv_rulepathNameCS= rulepathNameCS EOF ;
    public final EObject entryRulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepathNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2432:2: (iv_rulepathNameCS= rulepathNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2433:2: iv_rulepathNameCS= rulepathNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPathNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepathNameCS_in_entryRulepathNameCS4378);
            iv_rulepathNameCS=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepathNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepathNameCS4388); if (failed) return current;

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
    // $ANTLR end entryRulepathNameCS


    // $ANTLR start rulepathNameCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2440:1: rulepathNameCS returns [EObject current=null] : ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) ;
    public final EObject rulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject lv_simpleNames_0_0 = null;

        EObject lv_simpleNames_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2445:6: ( ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2446:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2446:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2446:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2446:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2447:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2447:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2448:3: lv_simpleNames_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_rulepathNameCS4434);
            lv_simpleNames_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getPathNameCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"simpleNames",
              	        		lv_simpleNames_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2470:2: ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==38) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2470:4: '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    {
            	    match(input,38,FOLLOW_38_in_rulepathNameCS4445); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2474:1: ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2475:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2475:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2476:3: lv_simpleNames_2_0= ruleunreservedSimpleNameCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS4466);
            	    lv_simpleNames_2_0=ruleunreservedSimpleNameCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getPathNameCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"simpleNames",
            	      	        		lv_simpleNames_2_0, 
            	      	        		"unreservedSimpleNameCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepathNameCS


    // $ANTLR start entryRuleprimitiveTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2506:1: entryRuleprimitiveTypeCS returns [EObject current=null] : iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF ;
    public final EObject entryRuleprimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimitiveTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2507:2: (iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2508:2: iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS4504);
            iv_ruleprimitiveTypeCS=ruleprimitiveTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimitiveTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimitiveTypeCS4514); if (failed) return current;

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
    // $ANTLR end entryRuleprimitiveTypeCS


    // $ANTLR start ruleprimitiveTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2515:1: ruleprimitiveTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) ;
    public final EObject ruleprimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_value_3_0=null;
        Token lv_value_4_0=null;
        Token lv_value_5_0=null;
        Token lv_value_6_0=null;
        Token lv_value_7_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2520:6: ( ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2521:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2521:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            int alt42=8;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt42=1;
                }
                break;
            case 40:
                {
                alt42=2;
                }
                break;
            case 41:
                {
                alt42=3;
                }
                break;
            case 42:
                {
                alt42=4;
                }
                break;
            case 43:
                {
                alt42=5;
                }
                break;
            case 44:
                {
                alt42=6;
                }
                break;
            case 45:
                {
                alt42=7;
                }
                break;
            case 46:
                {
                alt42=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2521:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2521:2: ( (lv_value_0_0= 'Boolean' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2521:2: ( (lv_value_0_0= 'Boolean' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2522:1: (lv_value_0_0= 'Boolean' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2522:1: (lv_value_0_0= 'Boolean' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2523:3: lv_value_0_0= 'Boolean'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleprimitiveTypeCS4557); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueBooleanKeyword_0_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_0_0, "Boolean", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2543:6: ( (lv_value_1_0= 'Integer' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2543:6: ( (lv_value_1_0= 'Integer' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2544:1: (lv_value_1_0= 'Integer' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2544:1: (lv_value_1_0= 'Integer' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2545:3: lv_value_1_0= 'Integer'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleprimitiveTypeCS4594); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueIntegerKeyword_1_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_1_0, "Integer", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2565:6: ( (lv_value_2_0= 'Real' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2565:6: ( (lv_value_2_0= 'Real' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2566:1: (lv_value_2_0= 'Real' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2566:1: (lv_value_2_0= 'Real' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2567:3: lv_value_2_0= 'Real'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleprimitiveTypeCS4631); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueRealKeyword_2_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_2_0, "Real", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2587:6: ( (lv_value_3_0= 'String' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2587:6: ( (lv_value_3_0= 'String' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2588:1: (lv_value_3_0= 'String' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2588:1: (lv_value_3_0= 'String' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2589:3: lv_value_3_0= 'String'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,42,FOLLOW_42_in_ruleprimitiveTypeCS4668); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueStringKeyword_3_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_3_0, "String", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2609:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2609:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2610:1: (lv_value_4_0= 'UnlimitedNatural' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2610:1: (lv_value_4_0= 'UnlimitedNatural' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2611:3: lv_value_4_0= 'UnlimitedNatural'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,43,FOLLOW_43_in_ruleprimitiveTypeCS4705); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueUnlimitedNaturalKeyword_4_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_4_0, "UnlimitedNatural", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2631:6: ( (lv_value_5_0= 'OclAny' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2631:6: ( (lv_value_5_0= 'OclAny' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2632:1: (lv_value_5_0= 'OclAny' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2632:1: (lv_value_5_0= 'OclAny' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2633:3: lv_value_5_0= 'OclAny'
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_ruleprimitiveTypeCS4742); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueOclAnyKeyword_5_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_5_0, "OclAny", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2653:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2653:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2654:1: (lv_value_6_0= 'OclInvalid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2654:1: (lv_value_6_0= 'OclInvalid' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2655:3: lv_value_6_0= 'OclInvalid'
                    {
                    lv_value_6_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleprimitiveTypeCS4779); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueOclInvalidKeyword_6_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_6_0, "OclInvalid", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2675:6: ( (lv_value_7_0= 'OclVoid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2675:6: ( (lv_value_7_0= 'OclVoid' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2676:1: (lv_value_7_0= 'OclVoid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2676:1: (lv_value_7_0= 'OclVoid' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2677:3: lv_value_7_0= 'OclVoid'
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_ruleprimitiveTypeCS4816); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimitiveTypeCSAccess().getValueOclVoidKeyword_7_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPrimitiveTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_7_0, "OclVoid", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleprimitiveTypeCS


    // $ANTLR start entryRuleCollectionTypeIdentifierCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2704:1: entryRuleCollectionTypeIdentifierCS returns [EObject current=null] : iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF ;
    public final EObject entryRuleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeIdentifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2705:2: (iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2706:2: iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeIdentifierCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS4865);
            iv_ruleCollectionTypeIdentifierCS=ruleCollectionTypeIdentifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifierCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS4875); if (failed) return current;

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
    // $ANTLR end entryRuleCollectionTypeIdentifierCS


    // $ANTLR start ruleCollectionTypeIdentifierCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2713:1: ruleCollectionTypeIdentifierCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) ;
    public final EObject ruleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_value_3_0=null;
        Token lv_value_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2718:6: ( ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2719:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2719:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            int alt43=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt43=1;
                }
                break;
            case 48:
                {
                alt43=2;
                }
                break;
            case 49:
                {
                alt43=3;
                }
                break;
            case 50:
                {
                alt43=4;
                }
                break;
            case 51:
                {
                alt43=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2719:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2719:2: ( (lv_value_0_0= 'Set' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2719:2: ( (lv_value_0_0= 'Set' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2720:1: (lv_value_0_0= 'Set' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2720:1: (lv_value_0_0= 'Set' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2721:3: lv_value_0_0= 'Set'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleCollectionTypeIdentifierCS4918); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueSetKeyword_0_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_0_0, "Set", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2741:6: ( (lv_value_1_0= 'Bag' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2741:6: ( (lv_value_1_0= 'Bag' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2742:1: (lv_value_1_0= 'Bag' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2742:1: (lv_value_1_0= 'Bag' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2743:3: lv_value_1_0= 'Bag'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_ruleCollectionTypeIdentifierCS4955); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueBagKeyword_1_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_1_0, "Bag", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2763:6: ( (lv_value_2_0= 'Sequence' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2763:6: ( (lv_value_2_0= 'Sequence' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2764:1: (lv_value_2_0= 'Sequence' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2764:1: (lv_value_2_0= 'Sequence' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2765:3: lv_value_2_0= 'Sequence'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_ruleCollectionTypeIdentifierCS4992); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueSequenceKeyword_2_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_2_0, "Sequence", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2785:6: ( (lv_value_3_0= 'Collection' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2785:6: ( (lv_value_3_0= 'Collection' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2786:1: (lv_value_3_0= 'Collection' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2786:1: (lv_value_3_0= 'Collection' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2787:3: lv_value_3_0= 'Collection'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleCollectionTypeIdentifierCS5029); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueCollectionKeyword_3_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_3_0, "Collection", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2807:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2807:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2808:1: (lv_value_4_0= 'OrderedSet' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2808:1: (lv_value_4_0= 'OrderedSet' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2809:3: lv_value_4_0= 'OrderedSet'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,51,FOLLOW_51_in_ruleCollectionTypeIdentifierCS5066); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeIdentifierCSAccess().getValueOrderedSetKeyword_4_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionTypeIdentifierCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_4_0, "OrderedSet", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCollectionTypeIdentifierCS


    // $ANTLR start entryRuletypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2836:1: entryRuletypeCS returns [EObject current=null] : iv_ruletypeCS= ruletypeCS EOF ;
    public final EObject entryRuletypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2837:2: (iv_ruletypeCS= ruletypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2838:2: iv_ruletypeCS= ruletypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletypeCS_in_entryRuletypeCS5115);
            iv_ruletypeCS=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletypeCS5125); if (failed) return current;

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
    // $ANTLR end entryRuletypeCS


    // $ANTLR start ruletypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2845:1: ruletypeCS returns [EObject current=null] : (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) ;
    public final EObject ruletypeCS() throws RecognitionException {
        EObject current = null;

        EObject this_primitiveTypeCS_0 = null;

        EObject this_pathNameCS_1 = null;

        EObject this_collectionTypeCS_2 = null;

        EObject this_tupleTypeCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2850:6: ( (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2851:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2851:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt44=1;
                }
                break;
            case RULE_ID:
                {
                alt44=2;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt44=3;
                }
                break;
            case 36:
                {
                alt44=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2851:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2852:2: this_primitiveTypeCS_0= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPrimitiveTypeCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS5175);
                    this_primitiveTypeCS_0=ruleprimitiveTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_primitiveTypeCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2865:2: this_pathNameCS_1= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPathNameCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruletypeCS5205);
                    this_pathNameCS_1=rulepathNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_pathNameCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2878:2: this_collectionTypeCS_2= rulecollectionTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getCollectionTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecollectionTypeCS_in_ruletypeCS5235);
                    this_collectionTypeCS_2=rulecollectionTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_collectionTypeCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2891:2: this_tupleTypeCS_3= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getTupleTypeCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruletypeCS5265);
                    this_tupleTypeCS_3=ruletupleTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_tupleTypeCS_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruletypeCS


    // $ANTLR start entryRulecollectionTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2910:1: entryRulecollectionTypeCS returns [EObject current=null] : iv_rulecollectionTypeCS= rulecollectionTypeCS EOF ;
    public final EObject entryRulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecollectionTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2911:2: (iv_rulecollectionTypeCS= rulecollectionTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2912:2: iv_rulecollectionTypeCS= rulecollectionTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS5300);
            iv_rulecollectionTypeCS=rulecollectionTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecollectionTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecollectionTypeCS5310); if (failed) return current;

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
    // $ANTLR end entryRulecollectionTypeCS


    // $ANTLR start rulecollectionTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2919:1: rulecollectionTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' ) ;
    public final EObject rulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;

        EObject lv_typeCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2924:6: ( ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2925:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2925:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2925:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2925:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2926:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2926:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2927:3: lv_value_0_0= ruleCollectionTypeIdentifierCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getValueCollectionTypeIdentifierCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS5356);
            lv_value_0_0=ruleCollectionTypeIdentifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCollectionTypeCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"value",
              	        		lv_value_0_0, 
              	        		"CollectionTypeIdentifierCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,22,FOLLOW_22_in_rulecollectionTypeCS5366); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2953:1: ( (lv_typeCS_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2954:1: (lv_typeCS_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2954:1: (lv_typeCS_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2955:3: lv_typeCS_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_rulecollectionTypeCS5387);
            lv_typeCS_2_0=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCollectionTypeCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"typeCS",
              	        		lv_typeCS_2_0, 
              	        		"typeCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FOLLOW_24_in_rulecollectionTypeCS5397); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_3(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulecollectionTypeCS


    // $ANTLR start entryRuletupleTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2989:1: entryRuletupleTypeCS returns [EObject current=null] : iv_ruletupleTypeCS= ruletupleTypeCS EOF ;
    public final EObject entryRuletupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2990:2: (iv_ruletupleTypeCS= ruletupleTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2991:2: iv_ruletupleTypeCS= ruletupleTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS5433);
            iv_ruletupleTypeCS=ruletupleTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleTypeCS5443); if (failed) return current;

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
    // $ANTLR end entryRuletupleTypeCS


    // $ANTLR start ruletupleTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2998:1: ruletupleTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) ;
    public final EObject ruletupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_part_2_0 = null;

        EObject lv_part_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3003:6: ( ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3004:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3004:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3004:2: ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3004:2: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3005:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3005:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3006:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_ruletupleTypeCS5486); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleTypeCSAccess().getValueTupleKeyword_0_0(), "value"); 
                  
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTupleTypeCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        
              	        try {
              	       		set(current, "value", lv_value_0_0, "Tuple", lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,22,FOLLOW_22_in_ruletupleTypeCS5509); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3029:1: ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3029:2: ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3029:2: ( (lv_part_2_0= ruletuplePartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:1: (lv_part_2_0= ruletuplePartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:1: (lv_part_2_0= ruletuplePartCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3031:3: lv_part_2_0= ruletuplePartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5531);
                    lv_part_2_0=ruletuplePartCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTupleTypeCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"part",
                      	        		lv_part_2_0, 
                      	        		"tuplePartCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3053:2: ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==23) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3053:4: ',' ( (lv_part_4_0= ruletuplePartCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruletupleTypeCS5542); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_2_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3057:1: ( (lv_part_4_0= ruletuplePartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3058:1: (lv_part_4_0= ruletuplePartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3058:1: (lv_part_4_0= ruletuplePartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3059:3: lv_part_4_0= ruletuplePartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5563);
                    	    lv_part_4_0=ruletuplePartCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getTupleTypeCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"part",
                    	      	        		lv_part_4_0, 
                    	      	        		"tuplePartCS", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruletupleTypeCS5577); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_3(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruletupleTypeCS


    // $ANTLR start entryRuletuplePartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3093:1: entryRuletuplePartCS returns [EObject current=null] : iv_ruletuplePartCS= ruletuplePartCS EOF ;
    public final EObject entryRuletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3094:2: (iv_ruletuplePartCS= ruletuplePartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3095:2: iv_ruletuplePartCS= ruletuplePartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTuplePartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS5613);
            iv_ruletuplePartCS=ruletuplePartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletuplePartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletuplePartCS5623); if (failed) return current;

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
    // $ANTLR end entryRuletuplePartCS


    // $ANTLR start ruletuplePartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3102:1: ruletuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) ;
    public final EObject ruletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3107:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3108:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3108:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3108:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3108:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3109:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3109:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3110:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruletuplePartCS5669);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTuplePartCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FOLLOW_16_in_ruletuplePartCS5679); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTuplePartCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3136:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3137:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3137:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3138:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruletuplePartCS5700);
            lv_type_2_0=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTuplePartCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_2_0, 
              	        		"typeCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruletuplePartCS


    // $ANTLR start entryRuleLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3168:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3169:2: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3170:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS5736);
            iv_ruleLiteralExpCS=ruleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpCS5746); if (failed) return current;

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
    // $ANTLR end entryRuleLiteralExpCS


    // $ANTLR start ruleLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3177:1: ruleLiteralExpCS returns [EObject current=null] : (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) ;
    @SuppressWarnings("unused")
	public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionLiteralExpCS_0 = null;

        EObject this_TupleLiteralExpCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;

        EObject this_TypeLiteralExpCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3182:6: ( (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            int alt47=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA47_1 = input.LA(2);

                if ( (synpred68()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 1, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                int LA47_2 = input.LA(2);

                if ( (synpred68()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 2, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA47_3 = input.LA(2);

                if ( (synpred68()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 3, input);

                    throw nvae;
                }
                }
                break;
            case 50:
                {
                int LA47_4 = input.LA(2);

                if ( (synpred68()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 4, input);

                    throw nvae;
                }
                }
                break;
            case 51:
                {
                int LA47_5 = input.LA(2);

                if ( (synpred68()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 5, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                int LA47_6 = input.LA(2);

                if ( (synpred69()) ) {
                    alt47=2;
                }
                else if ( (true) ) {
                    alt47=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 6, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING_LITERAL:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt47=3;
                }
                break;
            case RULE_ID:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt47=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3183:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3184:2: this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS5796);
                    this_CollectionLiteralExpCS_0=ruleCollectionLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3197:2: this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTupleLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS5826);
                    this_TupleLiteralExpCS_1=ruleTupleLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TupleLiteralExpCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3210:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS5856);
                    this_PrimitiveLiteralExpCS_2=rulePrimitiveLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExpCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3223:2: this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTypeLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS5886);
                    this_TypeLiteralExpCS_3=ruleTypeLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleLiteralExpCS


    // $ANTLR start entryRuleCollectionLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3242:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3243:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3244:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS5921);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS5931); if (failed) return current;

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
    // $ANTLR end entryRuleCollectionLiteralExpCS


    // $ANTLR start ruleCollectionLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3251:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS ) '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeIdentifierCS_0 = null;

        EObject this_collectionTypeCS_1 = null;

        EObject lv_collectionLiteralParts_3_0 = null;

        EObject lv_collectionLiteralParts_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3256:6: ( ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS ) '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? '}' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3257:1: ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS ) '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3257:1: ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS ) '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS ) '{' ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? '}'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )
            int alt48=2;
            switch ( input.LA(1) ) {
            case 47:
                {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==22) ) {
                    alt48=2;
                }
                else if ( (LA48_1==52) ) {
                    alt48=1;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 1, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==52) ) {
                    alt48=1;
                }
                else if ( (LA48_2==22) ) {
                    alt48=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 2, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA48_3 = input.LA(2);

                if ( (LA48_3==52) ) {
                    alt48=1;
                }
                else if ( (LA48_3==22) ) {
                    alt48=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 3, input);

                    throw nvae;
                }
                }
                break;
            case 50:
                {
                int LA48_4 = input.LA(2);

                if ( (LA48_4==22) ) {
                    alt48=2;
                }
                else if ( (LA48_4==52) ) {
                    alt48=1;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 4, input);

                    throw nvae;
                }
                }
                break;
            case 51:
                {
                int LA48_5 = input.LA(2);

                if ( (LA48_5==52) ) {
                    alt48=1;
                }
                else if ( (LA48_5==22) ) {
                    alt48=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3257:2: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_collectionTypeCS_1= rulecollectionTypeCS )", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3258:2: this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_ruleCollectionLiteralExpCS5982);
                    this_CollectionTypeIdentifierCS_0=ruleCollectionTypeIdentifierCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_CollectionTypeIdentifierCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3271:2: this_collectionTypeCS_1= rulecollectionTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_0_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS6012);
                    this_collectionTypeCS_1=rulecollectionTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_collectionTypeCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }

            match(input,52,FOLLOW_52_in_ruleCollectionLiteralExpCS6022); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3286:1: ( ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_STRING_LITERAL)||LA50_0==22||(LA50_0>=35 && LA50_0<=37)||(LA50_0>=39 && LA50_0<=51)||(LA50_0>=55 && LA50_0<=59)||LA50_0==70||LA50_0==77||LA50_0==81) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3286:2: ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3286:2: ( (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3287:1: (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3287:1: (lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3288:3: lv_collectionLiteralParts_3_0= ruleCollectionLiteralPartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6044);
                    lv_collectionLiteralParts_3_0=ruleCollectionLiteralPartCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionLiteralExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"collectionLiteralParts",
                      	        		lv_collectionLiteralParts_3_0, 
                      	        		"CollectionLiteralPartCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3310:2: ( ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==23) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3310:4: ',' ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleCollectionLiteralExpCS6055); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3314:1: ( (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3315:1: (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3315:1: (lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3316:3: lv_collectionLiteralParts_5_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6076);
                    	    lv_collectionLiteralParts_5_0=ruleCollectionLiteralPartCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getCollectionLiteralExpCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"collectionLiteralParts",
                    	      	        		lv_collectionLiteralParts_5_0, 
                    	      	        		"CollectionLiteralPartCS", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_ruleCollectionLiteralExpCS6090); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCollectionLiteralExpCS


    // $ANTLR start entryRuleCollectionLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3350:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3351:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3352:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6126);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6136); if (failed) return current;

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
    // $ANTLR end entryRuleCollectionLiteralPartCS


    // $ANTLR start ruleCollectionLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3359:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3364:6: ( ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3365:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3365:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3365:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3365:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3366:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3366:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3367:3: lv_expressionCS_0_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSOclExpressionCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6182);
            lv_expressionCS_0_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getCollectionLiteralPartCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"expressionCS",
              	        		lv_expressionCS_0_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3389:2: ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==54) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3389:4: '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    {
                    match(input,54,FOLLOW_54_in_ruleCollectionLiteralPartCS6193); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3393:1: ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3394:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3394:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3395:3: lv_lastExpressionCS_2_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSOclExpressionCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6214);
                    lv_lastExpressionCS_2_0=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCollectionLiteralPartCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"lastExpressionCS",
                      	        		lv_lastExpressionCS_2_0, 
                      	        		"OclExpressionCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCollectionLiteralPartCS


    // $ANTLR start entryRulePrimitiveLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3425:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3426:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3427:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6252);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6262); if (failed) return current;

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
    // $ANTLR end entryRulePrimitiveLiteralExpCS


    // $ANTLR start rulePrimitiveLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3434:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) ;
    public final EObject rulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralExpCS_0 = null;

        EObject this_RealLiteralExpCS_1 = null;

        EObject this_StringLiteralExpCS_2 = null;

        EObject this_BooleanLiteralExpCS_3 = null;

        EObject this_UnlimitedNaturalLiteralExpCS_4 = null;

        EObject this_InvalidLiteralExpCS_5 = null;

        EObject this_NullLiteralExpCS_6 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3439:6: ( (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3440:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3440:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            int alt52=7;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case 13:
                case 14:
                case 15:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 34:
                case 35:
                case 53:
                case 54:
                case 57:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 71:
                case 73:
                case 75:
                case 78:
                case 79:
                case 80:
                case 82:
                    {
                    alt52=1;
                    }
                    break;
                case 11:
                    {
                    int LA52_8 = input.LA(3);

                    if ( (LA52_8==RULE_INT) ) {
                        alt52=2;
                    }
                    else if ( (LA52_8==RULE_ID) ) {
                        alt52=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3440:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 52, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case 32:
                case 33:
                    {
                    alt52=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3440:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 52, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt52=3;
                }
                break;
            case 55:
            case 56:
                {
                alt52=4;
                }
                break;
            case 57:
                {
                alt52=5;
                }
                break;
            case 58:
                {
                alt52=6;
                }
                break;
            case 59:
                {
                alt52=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3440:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3441:2: this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getIntegerLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS6312);
                    this_IntegerLiteralExpCS_0=ruleIntegerLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IntegerLiteralExpCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3454:2: this_RealLiteralExpCS_1= ruleRealLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getRealLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS6342);
                    this_RealLiteralExpCS_1=ruleRealLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_RealLiteralExpCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3467:2: this_StringLiteralExpCS_2= ruleStringLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6372);
                    this_StringLiteralExpCS_2=ruleStringLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_StringLiteralExpCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3480:2: this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6402);
                    this_BooleanLiteralExpCS_3=ruleBooleanLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_BooleanLiteralExpCS_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3493:2: this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6432);
                    this_UnlimitedNaturalLiteralExpCS_4=ruleUnlimitedNaturalLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_UnlimitedNaturalLiteralExpCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3506:2: this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6462);
                    this_InvalidLiteralExpCS_5=ruleInvalidLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_InvalidLiteralExpCS_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3519:2: this_NullLiteralExpCS_6= ruleNullLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6492);
                    this_NullLiteralExpCS_6=ruleNullLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_NullLiteralExpCS_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulePrimitiveLiteralExpCS


    // $ANTLR start entryRuleTupleLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3538:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3539:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3540:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6527);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6537); if (failed) return current;

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
    // $ANTLR end entryRuleTupleLiteralExpCS


    // $ANTLR start ruleTupleLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3547:1: ruleTupleLiteralExpCS returns [EObject current=null] : ( 'Tuple' '{' ( (lv_part_2_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )* '}' ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_part_2_0 = null;

        EObject lv_part_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3552:6: ( ( 'Tuple' '{' ( (lv_part_2_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3553:1: ( 'Tuple' '{' ( (lv_part_2_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3553:1: ( 'Tuple' '{' ( (lv_part_2_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3553:3: 'Tuple' '{' ( (lv_part_2_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )* '}'
            {
            match(input,36,FOLLOW_36_in_ruleTupleLiteralExpCS6572); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0(), null); 
                  
            }
            match(input,52,FOLLOW_52_in_ruleTupleLiteralExpCS6582); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3561:1: ( (lv_part_2_0= ruleTupleLiteralPartCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3562:1: (lv_part_2_0= ruleTupleLiteralPartCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3562:1: (lv_part_2_0= ruleTupleLiteralPartCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3563:3: lv_part_2_0= ruleTupleLiteralPartCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6603);
            lv_part_2_0=ruleTupleLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTupleLiteralExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"part",
              	        		lv_part_2_0, 
              	        		"TupleLiteralPartCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3585:2: ( ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==23) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3585:4: ',' ( (lv_part_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    match(input,23,FOLLOW_23_in_ruleTupleLiteralExpCS6614); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3589:1: ( (lv_part_4_0= ruleTupleLiteralPartCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3590:1: (lv_part_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3590:1: (lv_part_4_0= ruleTupleLiteralPartCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3591:3: lv_part_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_3_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6635);
            	    lv_part_4_0=ruleTupleLiteralPartCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getTupleLiteralExpCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"part",
            	      	        		lv_part_4_0, 
            	      	        		"TupleLiteralPartCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            match(input,53,FOLLOW_53_in_ruleTupleLiteralExpCS6647); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTupleLiteralExpCS


    // $ANTLR start entryRuleTupleLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3625:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3626:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3627:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6683);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6693); if (failed) return current;

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
    // $ANTLR end entryRuleTupleLiteralPartCS


    // $ANTLR start ruleTupleLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3634:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3639:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3640:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3640:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3640:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3640:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3641:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3641:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3642:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS6739);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3664:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==16) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3664:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleTupleLiteralPartCS6750); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3668:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3669:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3669:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3670:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS6771);
                    lv_type_2_0=ruletypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"typeCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_ruleTupleLiteralPartCS6783); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3696:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3697:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3697:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3698:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS6804);
            lv_initExpression_4_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTupleLiteralPartCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"initExpression",
              	        		lv_initExpression_4_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTupleLiteralPartCS


    // $ANTLR start entryRuleIntegerLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3728:1: entryRuleIntegerLiteralExpCS returns [EObject current=null] : iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF ;
    public final EObject entryRuleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3729:2: (iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3730:2: iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntegerLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS6840);
            iv_ruleIntegerLiteralExpCS=ruleIntegerLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntegerLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS6850); if (failed) return current;

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
    // $ANTLR end entryRuleIntegerLiteralExpCS


    // $ANTLR start ruleIntegerLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3737:1: ruleIntegerLiteralExpCS returns [EObject current=null] : ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) ;
    public final EObject ruleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_integerSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3742:6: ( ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3743:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3743:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3744:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3744:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3745:3: lv_integerSymbol_0_0= ruleINTEGER_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolINTEGER_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS6895);
            lv_integerSymbol_0_0=ruleINTEGER_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIntegerLiteralExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"integerSymbol",
              	        		lv_integerSymbol_0_0, 
              	        		"INTEGER_LITERAL", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleIntegerLiteralExpCS


    // $ANTLR start entryRuleRealLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3775:1: entryRuleRealLiteralExpCS returns [EObject current=null] : iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF ;
    public final EObject entryRuleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3776:2: (iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3777:2: iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRealLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS6930);
            iv_ruleRealLiteralExpCS=ruleRealLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRealLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralExpCS6940); if (failed) return current;

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
    // $ANTLR end entryRuleRealLiteralExpCS


    // $ANTLR start ruleRealLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3784:1: ruleRealLiteralExpCS returns [EObject current=null] : ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) ;
    public final EObject ruleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_realSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3789:6: ( ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3790:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3790:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3791:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3791:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3792:3: lv_realSymbol_0_0= ruleREAL_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRealLiteralExpCSAccess().getRealSymbolREAL_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS6985);
            lv_realSymbol_0_0=ruleREAL_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRealLiteralExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"realSymbol",
              	        		lv_realSymbol_0_0, 
              	        		"REAL_LITERAL", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleRealLiteralExpCS


    // $ANTLR start entryRuleStringLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3822:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3823:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3824:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7020);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralExpCS7030); if (failed) return current;

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
    // $ANTLR end entryRuleStringLiteralExpCS


    // $ANTLR start ruleStringLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3831:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringSymbol_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3836:6: ( ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3837:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3837:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_STRING_LITERAL) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3838:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3838:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3839:3: lv_stringSymbol_0_0= RULE_STRING_LITERAL
            	    {
            	    lv_stringSymbol_0_0=(Token)input.LT(1);
            	    match(input,RULE_STRING_LITERAL,FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS7071); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      			createLeafNode(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolSTRING_LITERALTerminalRuleCall_0(), "stringSymbol"); 
            	      		
            	    }
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getStringLiteralExpCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"stringSymbol",
            	      	        		lv_stringSymbol_0_0, 
            	      	        		"STRING_LITERAL", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleStringLiteralExpCS


    // $ANTLR start entryRuleBooleanLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3869:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3870:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3871:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7112);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7122); if (failed) return current;

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
    // $ANTLR end entryRuleBooleanLiteralExpCS


    // $ANTLR start ruleBooleanLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3878:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3883:6: ( ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3884:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3884:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==55) ) {
                alt56=1;
            }
            else if ( (LA56_0==56) ) {
                alt56=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3884:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3884:2: ( (lv_value_0_0= 'true' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3884:2: ( (lv_value_0_0= 'true' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3885:1: (lv_value_0_0= 'true' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3885:1: (lv_value_0_0= 'true' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3886:3: lv_value_0_0= 'true'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleBooleanLiteralExpCS7165); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralExpCSAccess().getValueTrueKeyword_0_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getBooleanLiteralExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_0_0, "true", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3906:6: ( (lv_value_1_0= 'false' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3906:6: ( (lv_value_1_0= 'false' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3907:1: (lv_value_1_0= 'false' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3907:1: (lv_value_1_0= 'false' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3908:3: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleBooleanLiteralExpCS7202); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getBooleanLiteralExpCSAccess().getValueFalseKeyword_1_0(), "value"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getBooleanLiteralExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "value", lv_value_1_0, "false", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleBooleanLiteralExpCS


    // $ANTLR start entryRuleUnlimitedNaturalLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3935:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3936:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3937:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7251);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7261); if (failed) return current;

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
    // $ANTLR end entryRuleUnlimitedNaturalLiteralExpCS


    // $ANTLR start ruleUnlimitedNaturalLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3944:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3949:6: ( ( () '*' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3950:1: ( () '*' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3950:1: ( () '*' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3950:2: () '*'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3950:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3951:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,57,FOLLOW_57_in_ruleUnlimitedNaturalLiteralExpCS7308); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleUnlimitedNaturalLiteralExpCS


    // $ANTLR start entryRuleInvalidLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3976:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3977:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3978:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInvalidLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7344);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7354); if (failed) return current;

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
    // $ANTLR end entryRuleInvalidLiteralExpCS


    // $ANTLR start ruleInvalidLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3985:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3990:6: ( ( () 'invalid' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3991:1: ( () 'invalid' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3991:1: ( () 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3991:2: () 'invalid'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3991:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3992:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,58,FOLLOW_58_in_ruleInvalidLiteralExpCS7401); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleInvalidLiteralExpCS


    // $ANTLR start entryRuleNullLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4017:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4018:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4019:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7437);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralExpCS7447); if (failed) return current;

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
    // $ANTLR end entryRuleNullLiteralExpCS


    // $ANTLR start ruleNullLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4026:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4031:6: ( ( () 'null' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:1: ( () 'null' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:1: ( () 'null' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:2: () 'null'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4033:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,59,FOLLOW_59_in_ruleNullLiteralExpCS7494); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleNullLiteralExpCS


    // $ANTLR start entryRuleTypeLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4058:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4059:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4060:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7530);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7540); if (failed) return current;

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
    // $ANTLR end entryRuleTypeLiteralExpCS


    // $ANTLR start ruleTypeLiteralExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4067:1: ruleTypeLiteralExpCS returns [EObject current=null] : (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_pathNameCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_collectionTypeCS_2 = null;

        EObject this_tupleTypeCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4072:6: ( (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            int alt57=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt57=1;
                }
                break;
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt57=2;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt57=3;
                }
                break;
            case 36:
                {
                alt57=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4073:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4074:2: this_pathNameCS_0= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPathNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS7590);
                    this_pathNameCS_0=rulepathNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_pathNameCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4087:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS7620);
                    this_primitiveTypeCS_1=ruleprimitiveTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_primitiveTypeCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4100:2: this_collectionTypeCS_2= rulecollectionTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecollectionTypeCS_in_ruleTypeLiteralExpCS7650);
                    this_collectionTypeCS_2=rulecollectionTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_collectionTypeCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4113:2: this_tupleTypeCS_3= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getTupleTypeCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS7680);
                    this_tupleTypeCS_3=ruletupleTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_tupleTypeCS_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleTypeLiteralExpCS


    // $ANTLR start entryRuleOclExpressionCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4132:1: entryRuleOclExpressionCS returns [EObject current=null] : iv_ruleOclExpressionCS= ruleOclExpressionCS EOF ;
    public final EObject entryRuleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclExpressionCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4133:2: (iv_ruleOclExpressionCS= ruleOclExpressionCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4134:2: iv_ruleOclExpressionCS= ruleOclExpressionCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclExpressionCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS7715);
            iv_ruleOclExpressionCS=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclExpressionCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclExpressionCS7725); if (failed) return current;

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
    // $ANTLR end entryRuleOclExpressionCS


    // $ANTLR start ruleOclExpressionCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4141:1: ruleOclExpressionCS returns [EObject current=null] : (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) ;
    public final EObject ruleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject this_impliesCS_0 = null;

        EObject this_LetExpCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4146:6: ( (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4147:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4147:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_STRING_LITERAL)||LA58_0==22||(LA58_0>=35 && LA58_0<=37)||(LA58_0>=39 && LA58_0<=51)||(LA58_0>=55 && LA58_0<=59)||LA58_0==70||LA58_0==77) ) {
                alt58=1;
            }
            else if ( (LA58_0==81) ) {
                alt58=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4147:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4148:2: this_impliesCS_0= ruleimpliesCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getImpliesCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS7775);
                    this_impliesCS_0=ruleimpliesCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_impliesCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4161:2: this_LetExpCS_1= ruleLetExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getLetExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS7805);
                    this_LetExpCS_1=ruleLetExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LetExpCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleOclExpressionCS


    // $ANTLR start entryRuleimpliesCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4180:1: entryRuleimpliesCS returns [EObject current=null] : iv_ruleimpliesCS= ruleimpliesCS EOF ;
    public final EObject entryRuleimpliesCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimpliesCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4181:2: (iv_ruleimpliesCS= ruleimpliesCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4182:2: iv_ruleimpliesCS= ruleimpliesCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImpliesCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS7840);
            iv_ruleimpliesCS=ruleimpliesCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleimpliesCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleimpliesCS7850); if (failed) return current;

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
    // $ANTLR end entryRuleimpliesCS


    // $ANTLR start ruleimpliesCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4189:1: ruleimpliesCS returns [EObject current=null] : (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleimpliesCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_xorCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4194:6: ( (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4195:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4195:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4196:2: this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getXorCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulexorCS_in_ruleimpliesCS7900);
            this_xorCS_0=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_xorCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:1: ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==60) ) {
                int LA60_1 = input.LA(2);

                if ( (synpred90()) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:2: () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4208:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getImpliesCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getImpliesCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4226:2: ( (lv_op_2_0= 'implies' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4227:1: (lv_op_2_0= 'implies' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4227:1: (lv_op_2_0= 'implies' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4228:3: lv_op_2_0= 'implies'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,60,FOLLOW_60_in_ruleimpliesCS7930); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getImpliesCSAccess().getOpImpliesKeyword_1_1_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getImpliesCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_2_0, "implies", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4247:2: ( ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4248:1: ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4248:1: ( (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4249:1: (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4249:1: (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( ((LA59_0>=RULE_ID && LA59_0<=RULE_STRING_LITERAL)||LA59_0==22||(LA59_0>=35 && LA59_0<=37)||(LA59_0>=39 && LA59_0<=51)||(LA59_0>=55 && LA59_0<=59)||LA59_0==70||LA59_0==77) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==81) ) {
                        alt59=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4249:1: (lv_right_3_1= ruleimpliesCS | lv_right_3_2= ruleLetExpCS )", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4250:3: lv_right_3_1= ruleimpliesCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getRightImpliesCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleimpliesCS_in_ruleimpliesCS7966);
                            lv_right_3_1=ruleimpliesCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getImpliesCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"impliesCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4271:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleimpliesCS7985);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getImpliesCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleimpliesCS


    // $ANTLR start entryRulexorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4303:1: entryRulexorCS returns [EObject current=null] : iv_rulexorCS= rulexorCS EOF ;
    public final EObject entryRulexorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulexorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4304:2: (iv_rulexorCS= rulexorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4305:2: iv_rulexorCS= rulexorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulexorCS_in_entryRulexorCS8026);
            iv_rulexorCS=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulexorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulexorCS8036); if (failed) return current;

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
    // $ANTLR end entryRulexorCS


    // $ANTLR start rulexorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4312:1: rulexorCS returns [EObject current=null] : (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulexorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_orCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4317:6: ( (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4319:2: this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getOrCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleorCS_in_rulexorCS8086);
            this_orCS_0=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_orCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:1: ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==61) ) {
                int LA62_1 = input.LA(2);

                if ( (synpred92()) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:2: () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4331:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXorCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXorCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4349:2: ( (lv_op_2_0= 'xor' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4350:1: (lv_op_2_0= 'xor' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4350:1: (lv_op_2_0= 'xor' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4351:3: lv_op_2_0= 'xor'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_rulexorCS8116); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getXorCSAccess().getOpXorKeyword_1_1_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getXorCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_2_0, "xor", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4370:2: ( ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4371:1: ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4371:1: ( (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4372:1: (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4372:1: (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( ((LA61_0>=RULE_ID && LA61_0<=RULE_STRING_LITERAL)||LA61_0==22||(LA61_0>=35 && LA61_0<=37)||(LA61_0>=39 && LA61_0<=51)||(LA61_0>=55 && LA61_0<=59)||LA61_0==70||LA61_0==77) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==81) ) {
                        alt61=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4372:1: (lv_right_3_1= rulexorCS | lv_right_3_2= ruleLetExpCS )", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4373:3: lv_right_3_1= rulexorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getRightXorCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulexorCS_in_rulexorCS8152);
                            lv_right_3_1=rulexorCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXorCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"xorCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4394:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulexorCS8171);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getXorCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulexorCS


    // $ANTLR start entryRuleorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4426:1: entryRuleorCS returns [EObject current=null] : iv_ruleorCS= ruleorCS EOF ;
    public final EObject entryRuleorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4427:2: (iv_ruleorCS= ruleorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4428:2: iv_ruleorCS= ruleorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleorCS_in_entryRuleorCS8212);
            iv_ruleorCS=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleorCS8222); if (failed) return current;

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
    // $ANTLR end entryRuleorCS


    // $ANTLR start ruleorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4435:1: ruleorCS returns [EObject current=null] : (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_andCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4440:6: ( (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4442:2: this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getAndCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleandCS_in_ruleorCS8272);
            this_andCS_0=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_andCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:1: ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==62) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred94()) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:2: () ( (lv_op_2_0= 'or' ) ) ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4454:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getOrCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getOrCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4472:2: ( (lv_op_2_0= 'or' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4473:1: (lv_op_2_0= 'or' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4473:1: (lv_op_2_0= 'or' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4474:3: lv_op_2_0= 'or'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,62,FOLLOW_62_in_ruleorCS8302); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOrCSAccess().getOpOrKeyword_1_1_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getOrCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_2_0, "or", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4493:2: ( ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4494:1: ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4494:1: ( (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4495:1: (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4495:1: (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_STRING_LITERAL)||LA63_0==22||(LA63_0>=35 && LA63_0<=37)||(LA63_0>=39 && LA63_0<=51)||(LA63_0>=55 && LA63_0<=59)||LA63_0==70||LA63_0==77) ) {
                        alt63=1;
                    }
                    else if ( (LA63_0==81) ) {
                        alt63=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4495:1: (lv_right_3_1= ruleorCS | lv_right_3_2= ruleLetExpCS )", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4496:3: lv_right_3_1= ruleorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getRightOrCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleorCS_in_ruleorCS8338);
                            lv_right_3_1=ruleorCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getOrCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"orCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4517:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleorCS8357);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getOrCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleorCS


    // $ANTLR start entryRuleandCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4549:1: entryRuleandCS returns [EObject current=null] : iv_ruleandCS= ruleandCS EOF ;
    public final EObject entryRuleandCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleandCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4550:2: (iv_ruleandCS= ruleandCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4551:2: iv_ruleandCS= ruleandCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleandCS_in_entryRuleandCS8398);
            iv_ruleandCS=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleandCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleandCS8408); if (failed) return current;

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
    // $ANTLR end entryRuleandCS


    // $ANTLR start ruleandCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4558:1: ruleandCS returns [EObject current=null] : (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleandCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_equalityCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4563:6: ( (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4565:2: this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getEqualityCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleequalityCS_in_ruleandCS8458);
            this_equalityCS_0=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_equalityCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:1: ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==63) ) {
                int LA66_1 = input.LA(2);

                if ( (synpred96()) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:2: () ( (lv_op_2_0= 'and' ) ) ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4577:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAndCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAndCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4595:2: ( (lv_op_2_0= 'and' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4596:1: (lv_op_2_0= 'and' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4596:1: (lv_op_2_0= 'and' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4597:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,63,FOLLOW_63_in_ruleandCS8488); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAndCSAccess().getOpAndKeyword_1_1_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAndCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_2_0, "and", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4616:2: ( ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4617:1: ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4617:1: ( (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4618:1: (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4618:1: (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_STRING_LITERAL)||LA65_0==22||(LA65_0>=35 && LA65_0<=37)||(LA65_0>=39 && LA65_0<=51)||(LA65_0>=55 && LA65_0<=59)||LA65_0==70||LA65_0==77) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==81) ) {
                        alt65=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4618:1: (lv_right_3_1= ruleandCS | lv_right_3_2= ruleLetExpCS )", 65, 0, input);

                        throw nvae;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4619:3: lv_right_3_1= ruleandCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getRightAndCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleandCS_in_ruleandCS8524);
                            lv_right_3_1=ruleandCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAndCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"andCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4640:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleandCS8543);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAndCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleandCS


    // $ANTLR start entryRuleequalityCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4672:1: entryRuleequalityCS returns [EObject current=null] : iv_ruleequalityCS= ruleequalityCS EOF ;
    public final EObject entryRuleequalityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4673:2: (iv_ruleequalityCS= ruleequalityCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4674:2: iv_ruleequalityCS= ruleequalityCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEqualityCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleequalityCS_in_entryRuleequalityCS8584);
            iv_ruleequalityCS=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleequalityCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityCS8594); if (failed) return current;

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
    // $ANTLR end entryRuleequalityCS


    // $ANTLR start ruleequalityCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4681:1: ruleequalityCS returns [EObject current=null] : (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleequalityCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_relationalCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4686:6: ( (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4688:2: this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRelationalCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulerelationalCS_in_ruleequalityCS8644);
            this_relationalCS_0=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_relationalCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:1: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==25) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred99()) ) {
                    alt69=1;
                }
            }
            else if ( (LA69_0==64) ) {
                int LA69_2 = input.LA(2);

                if ( (synpred99()) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:2: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4700:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getEqualityCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getEqualityCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4718:2: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4719:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4719:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4720:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4720:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==25) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==64) ) {
                        alt67=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4720:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4721:3: lv_op_2_1= '='
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,25,FOLLOW_25_in_ruleequalityCS8676); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getEqualityCSAccess().getOpEqualsSignKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getEqualityCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4739:8: lv_op_2_2= '<>'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,64,FOLLOW_64_in_ruleequalityCS8705); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getEqualityCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getEqualityCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4760:2: ( ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4761:1: ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4761:1: ( (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4762:1: (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4762:1: (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_STRING_LITERAL)||LA68_0==22||(LA68_0>=35 && LA68_0<=37)||(LA68_0>=39 && LA68_0<=51)||(LA68_0>=55 && LA68_0<=59)||LA68_0==70||LA68_0==77) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==81) ) {
                        alt68=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4762:1: (lv_right_3_1= ruleequalityCS | lv_right_3_2= ruleLetExpCS )", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4763:3: lv_right_3_1= ruleequalityCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRightEqualityCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleequalityCS_in_ruleequalityCS8744);
                            lv_right_3_1=ruleequalityCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getEqualityCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"equalityCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4784:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleequalityCS8763);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getEqualityCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleequalityCS


    // $ANTLR start entryRulerelationalCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4816:1: entryRulerelationalCS returns [EObject current=null] : iv_rulerelationalCS= rulerelationalCS EOF ;
    public final EObject entryRulerelationalCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4817:2: (iv_rulerelationalCS= rulerelationalCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4818:2: iv_rulerelationalCS= rulerelationalCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerelationalCS_in_entryRulerelationalCS8804);
            iv_rulerelationalCS=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerelationalCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalCS8814); if (failed) return current;

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
    // $ANTLR end entryRulerelationalCS


    // $ANTLR start rulerelationalCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4825:1: rulerelationalCS returns [EObject current=null] : (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulerelationalCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_additiveCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4830:6: ( (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4832:2: this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getAdditiveCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_rulerelationalCS8864);
            this_additiveCS_0=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_additiveCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:1: ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt72=2;
            switch ( input.LA(1) ) {
                case 65:
                    {
                    int LA72_1 = input.LA(2);

                    if ( (synpred104()) ) {
                        alt72=1;
                    }
                    }
                    break;
                case 66:
                    {
                    int LA72_2 = input.LA(2);

                    if ( (synpred104()) ) {
                        alt72=1;
                    }
                    }
                    break;
                case 67:
                    {
                    int LA72_3 = input.LA(2);

                    if ( (synpred104()) ) {
                        alt72=1;
                    }
                    }
                    break;
                case 68:
                    {
                    int LA72_4 = input.LA(2);

                    if ( (synpred104()) ) {
                        alt72=1;
                    }
                    }
                    break;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:2: () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4844:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getRelationalCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4862:2: ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4863:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4863:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4864:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4864:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    int alt70=4;
                    switch ( input.LA(1) ) {
                    case 65:
                        {
                        alt70=1;
                        }
                        break;
                    case 66:
                        {
                        alt70=2;
                        }
                        break;
                    case 67:
                        {
                        alt70=3;
                        }
                        break;
                    case 68:
                        {
                        alt70=4;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4864:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4865:3: lv_op_2_1= '>'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,65,FOLLOW_65_in_rulerelationalCS8896); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getRelationalCSAccess().getOpGreaterThanSignKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4883:8: lv_op_2_2= '<'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,66,FOLLOW_66_in_rulerelationalCS8925); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getRelationalCSAccess().getOpLessThanSignKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4901:8: lv_op_2_3= '>='
                            {
                            lv_op_2_3=(Token)input.LT(1);
                            match(input,67,FOLLOW_67_in_rulerelationalCS8954); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getRelationalCSAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_2(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_3, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4919:8: lv_op_2_4= '<='
                            {
                            lv_op_2_4=(Token)input.LT(1);
                            match(input,68,FOLLOW_68_in_rulerelationalCS8983); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getRelationalCSAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_3(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_4, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4940:2: ( ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4941:1: ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4941:1: ( (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4942:1: (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4942:1: (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_STRING_LITERAL)||LA71_0==22||(LA71_0>=35 && LA71_0<=37)||(LA71_0>=39 && LA71_0<=51)||(LA71_0>=55 && LA71_0<=59)||LA71_0==70||LA71_0==77) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==81) ) {
                        alt71=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4942:1: (lv_right_3_1= rulerelationalCS | lv_right_3_2= ruleLetExpCS )", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4943:3: lv_right_3_1= rulerelationalCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getRightRelationalCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulerelationalCS_in_rulerelationalCS9022);
                            lv_right_3_1=rulerelationalCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"relationalCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4964:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulerelationalCS9041);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getRelationalCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulerelationalCS


    // $ANTLR start entryRuleadditiveCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4996:1: entryRuleadditiveCS returns [EObject current=null] : iv_ruleadditiveCS= ruleadditiveCS EOF ;
    public final EObject entryRuleadditiveCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4997:2: (iv_ruleadditiveCS= ruleadditiveCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4998:2: iv_ruleadditiveCS= ruleadditiveCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS9082);
            iv_ruleadditiveCS=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleadditiveCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveCS9092); if (failed) return current;

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
    // $ANTLR end entryRuleadditiveCS


    // $ANTLR start ruleadditiveCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5005:1: ruleadditiveCS returns [EObject current=null] : (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleadditiveCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_multiplicativeCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5010:6: ( (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5012:2: this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getMultiplicativeCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS9142);
            this_multiplicativeCS_0=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_multiplicativeCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:1: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==34) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred107()) ) {
                    alt75=1;
                }
            }
            else if ( (LA75_0==35) ) {
                int LA75_2 = input.LA(2);

                if ( (synpred107()) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:2: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5024:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5042:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5043:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5043:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5044:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5044:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==34) ) {
                        alt73=1;
                    }
                    else if ( (LA73_0==35) ) {
                        alt73=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5044:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )", 73, 0, input);

                        throw nvae;
                    }
                    switch (alt73) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5045:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleadditiveCS9174); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getAdditiveCSAccess().getOpPlusSignKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAdditiveCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5063:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleadditiveCS9203); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getAdditiveCSAccess().getOpHyphenMinusKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAdditiveCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5084:2: ( ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5085:1: ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5085:1: ( (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5086:1: (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5086:1: (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_STRING_LITERAL)||LA74_0==22||(LA74_0>=35 && LA74_0<=37)||(LA74_0>=39 && LA74_0<=51)||(LA74_0>=55 && LA74_0<=59)||LA74_0==70||LA74_0==77) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==81) ) {
                        alt74=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5086:1: (lv_right_3_1= ruleadditiveCS | lv_right_3_2= ruleLetExpCS )", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5087:3: lv_right_3_1= ruleadditiveCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getRightAdditiveCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleadditiveCS_in_ruleadditiveCS9242);
                            lv_right_3_1=ruleadditiveCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAdditiveCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"additiveCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5108:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleadditiveCS9261);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getAdditiveCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleadditiveCS


    // $ANTLR start entryRulemultiplicativeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5140:1: entryRulemultiplicativeCS returns [EObject current=null] : iv_rulemultiplicativeCS= rulemultiplicativeCS EOF ;
    public final EObject entryRulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5141:2: (iv_rulemultiplicativeCS= rulemultiplicativeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5142:2: iv_rulemultiplicativeCS= rulemultiplicativeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS9302);
            iv_rulemultiplicativeCS=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulemultiplicativeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeCS9312); if (failed) return current;

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
    // $ANTLR end entryRulemultiplicativeCS


    // $ANTLR start rulemultiplicativeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5149:1: rulemultiplicativeCS returns [EObject current=null] : (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_unaryCS_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5154:6: ( (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5156:2: this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getUnaryCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleunaryCS_in_rulemultiplicativeCS9362);
            this_unaryCS_0=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_unaryCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5167:1: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==57||LA78_0==69) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5167:2: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5167:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5168:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSLeftAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSLeftAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5186:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5187:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5187:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5188:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5188:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==57) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==69) ) {
                        alt76=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5188:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )", 76, 0, input);

                        throw nvae;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5189:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,57,FOLLOW_57_in_rulemultiplicativeCS9394); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getMultiplicativeCSAccess().getOpAsteriskKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getMultiplicativeCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5207:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,69,FOLLOW_69_in_rulemultiplicativeCS9423); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getMultiplicativeCSAccess().getOpSolidusKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getMultiplicativeCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5228:2: ( ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5229:1: ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5229:1: ( (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5230:1: (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5230:1: (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( ((LA77_0>=RULE_ID && LA77_0<=RULE_STRING_LITERAL)||LA77_0==22||(LA77_0>=35 && LA77_0<=37)||(LA77_0>=39 && LA77_0<=51)||(LA77_0>=55 && LA77_0<=59)||LA77_0==70||LA77_0==77) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==81) ) {
                        alt77=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5230:1: (lv_right_3_1= rulemultiplicativeCS | lv_right_3_2= ruleLetExpCS )", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5231:3: lv_right_3_1= rulemultiplicativeCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getRightMultiplicativeCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS9462);
                            lv_right_3_1=rulemultiplicativeCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getMultiplicativeCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_1, 
                              	        		"multiplicativeCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5252:8: lv_right_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS9481);
                            lv_right_3_2=ruleLetExpCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getMultiplicativeCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"right",
                              	        		lv_right_3_2, 
                              	        		"LetExpCS", 
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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulemultiplicativeCS


    // $ANTLR start entryRuleunaryCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5284:1: entryRuleunaryCS returns [EObject current=null] : iv_ruleunaryCS= ruleunaryCS EOF ;
    public final EObject entryRuleunaryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5285:2: (iv_ruleunaryCS= ruleunaryCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5286:2: iv_ruleunaryCS= ruleunaryCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunaryCS_in_entryRuleunaryCS9522);
            iv_ruleunaryCS=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunaryCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryCS9532); if (failed) return current;

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
    // $ANTLR end entryRuleunaryCS


    // $ANTLR start ruleunaryCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5293:1: ruleunaryCS returns [EObject current=null] : (this_calledExpCS_0= rulecalledExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) ;
    public final EObject ruleunaryCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_calledExpCS_0 = null;

        EObject lv_source_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5298:6: ( (this_calledExpCS_0= rulecalledExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5299:1: (this_calledExpCS_0= rulecalledExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5299:1: (this_calledExpCS_0= rulecalledExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_STRING_LITERAL)||LA80_0==22||(LA80_0>=36 && LA80_0<=37)||(LA80_0>=39 && LA80_0<=51)||(LA80_0>=55 && LA80_0<=59)||LA80_0==77) ) {
                alt80=1;
            }
            else if ( (LA80_0==35||LA80_0==70) ) {
                alt80=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5299:1: (this_calledExpCS_0= rulecalledExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5300:2: this_calledExpCS_0= rulecalledExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getCalledExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecalledExpCS_in_ruleunaryCS9582);
                    this_calledExpCS_0=rulecalledExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_calledExpCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5312:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5312:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5312:7: () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5312:7: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5313:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getUnaryCSAccess().getUnaryExpressionCSAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryCSAccess().getUnaryExpressionCSAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5326:2: ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5327:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5327:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5328:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5328:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==35) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==70) ) {
                        alt79=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5328:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )", 79, 0, input);

                        throw nvae;
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5329:3: lv_op_2_1= '-'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleunaryCS9620); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryCSAccess().getOpHyphenMinusKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_1, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5347:8: lv_op_2_2= 'not'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,70,FOLLOW_70_in_ruleunaryCS9649); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getUnaryCSAccess().getOpNotKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getUnaryCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "op", lv_op_2_2, null, lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5368:2: ( (lv_source_3_0= ruleunaryCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5369:1: (lv_source_3_0= ruleunaryCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5369:1: (lv_source_3_0= ruleunaryCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5370:3: lv_source_3_0= ruleunaryCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getSourceUnaryCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleunaryCS_in_ruleunaryCS9686);
                    lv_source_3_0=ruleunaryCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getUnaryCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"source",
                      	        		lv_source_3_0, 
                      	        		"unaryCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleunaryCS


    // $ANTLR start entryRulecalledExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5400:1: entryRulecalledExpCS returns [EObject current=null] : iv_rulecalledExpCS= rulecalledExpCS EOF ;
    public final EObject entryRulecalledExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecalledExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5401:2: (iv_rulecalledExpCS= rulecalledExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5402:2: iv_rulecalledExpCS= rulecalledExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCalledExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecalledExpCS_in_entryRulecalledExpCS9723);
            iv_rulecalledExpCS=rulecalledExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecalledExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecalledExpCS9733); if (failed) return current;

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
    // $ANTLR end entryRulecalledExpCS


    // $ANTLR start rulecalledExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5409:1: rulecalledExpCS returns [EObject current=null] : (this_implicitCallExpCS_0= ruleimplicitCallExpCS ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )? ) ;
    public final EObject rulecalledExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_implicitCallExpCS_0 = null;

        EObject lv_callArguments_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5414:6: ( (this_implicitCallExpCS_0= ruleimplicitCallExpCS ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5415:1: (this_implicitCallExpCS_0= ruleimplicitCallExpCS ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5415:1: (this_implicitCallExpCS_0= ruleimplicitCallExpCS ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5416:2: this_implicitCallExpCS_0= ruleimplicitCallExpCS ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCalledExpCSAccess().getImplicitCallExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleimplicitCallExpCS_in_rulecalledExpCS9783);
            this_implicitCallExpCS_0=ruleimplicitCallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_implicitCallExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5427:1: ( () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+ )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==11||LA82_0==71) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5427:2: () ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5427:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5428:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCalledExpCSAccess().getCallExpCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCalledExpCSAccess().getCallExpCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5446:2: ( (lv_callArguments_2_0= ruleCallArgumentsCS ) )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==11||LA81_0==71) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5447:1: (lv_callArguments_2_0= ruleCallArgumentsCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5447:1: (lv_callArguments_2_0= ruleCallArgumentsCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5448:3: lv_callArguments_2_0= ruleCallArgumentsCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getCalledExpCSAccess().getCallArgumentsCallArgumentsCSParserRuleCall_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCallArgumentsCS_in_rulecalledExpCS9816);
                    	    lv_callArguments_2_0=ruleCallArgumentsCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getCalledExpCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"callArguments",
                    	      	        		lv_callArguments_2_0, 
                    	      	        		"CallArgumentsCS", 
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
                    	    if ( cnt81 >= 1 ) break loop81;
                    	    if (backtracking>0) {failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulecalledExpCS


    // $ANTLR start entryRuleCallArgumentsCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5478:1: entryRuleCallArgumentsCS returns [EObject current=null] : iv_ruleCallArgumentsCS= ruleCallArgumentsCS EOF ;
    public final EObject entryRuleCallArgumentsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallArgumentsCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5479:2: (iv_ruleCallArgumentsCS= ruleCallArgumentsCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5480:2: iv_ruleCallArgumentsCS= ruleCallArgumentsCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCallArgumentsCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCallArgumentsCS_in_entryRuleCallArgumentsCS9855);
            iv_ruleCallArgumentsCS=ruleCallArgumentsCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCallArgumentsCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallArgumentsCS9865); if (failed) return current;

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
    // $ANTLR end entryRuleCallArgumentsCS


    // $ANTLR start ruleCallArgumentsCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5487:1: ruleCallArgumentsCS returns [EObject current=null] : ( ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' ) | ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? ) ) ;
    public final EObject ruleCallArgumentsCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPre_23_0=null;
        EObject lv_pathName_2_0 = null;

        EObject lv_variable1_4_0 = null;

        EObject lv_variable2_6_0 = null;

        EObject lv_variable2_8_0 = null;

        EObject lv_body_10_0 = null;

        EObject lv_arguments_11_0 = null;

        EObject lv_arguments_13_0 = null;

        EObject lv_pathName_17_0 = null;

        EObject lv_indexes_19_0 = null;

        EObject lv_indexes_21_0 = null;

        EObject lv_arguments_25_0 = null;

        EObject lv_arguments_27_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5492:6: ( ( ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' ) | ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:1: ( ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' ) | ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:1: ( ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' ) | ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==71) ) {
                alt93=1;
            }
            else if ( (LA93_0==11) ) {
                alt93=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5493:1: ( ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' ) | ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? ) )", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:2: ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:2: ( () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:3: () '->' ( (lv_pathName_2_0= rulepathNameCS ) ) '(' ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? ) ')'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5493:3: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5494:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCallArgumentsCSAccess().getArrowCallArgumentsCSAction_0_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getArrowCallArgumentsCSAction_0_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,71,FOLLOW_71_in_ruleCallArgumentsCS9913); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getHyphenMinusGreaterThanSignKeyword_0_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5511:1: ( (lv_pathName_2_0= rulepathNameCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5512:1: (lv_pathName_2_0= rulepathNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5512:1: (lv_pathName_2_0= rulepathNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5513:3: lv_pathName_2_0= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getPathNamePathNameCSParserRuleCall_0_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruleCallArgumentsCS9934);
                    lv_pathName_2_0=rulepathNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"pathName",
                      	        		lv_pathName_2_0, 
                      	        		"pathNameCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,22,FOLLOW_22_in_ruleCallArgumentsCS9944); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getLeftParenthesisKeyword_0_3(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5539:1: ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? )
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==RULE_ID) ) {
                        switch ( input.LA(2) ) {
                        case 16:
                        case 72:
                        case 73:
                            {
                            alt86=1;
                            }
                            break;
                        case 23:
                            {
                            int LA86_4 = input.LA(3);

                            if ( ((LA86_4>=RULE_INT && LA86_4<=RULE_STRING_LITERAL)||LA86_4==22||(LA86_4>=35 && LA86_4<=37)||(LA86_4>=39 && LA86_4<=51)||(LA86_4>=55 && LA86_4<=59)||LA86_4==70||LA86_4==77||LA86_4==81) ) {
                                alt86=2;
                            }
                            else if ( (LA86_4==RULE_ID) ) {
                                int LA86_5 = input.LA(4);

                                if ( (LA86_5==16||LA86_5==73) ) {
                                    alt86=1;
                                }
                                else if ( (LA86_5==11||(LA86_5>=23 && LA86_5<=25)||(LA86_5>=29 && LA86_5<=30)||(LA86_5>=34 && LA86_5<=35)||LA86_5==38||LA86_5==57||(LA86_5>=60 && LA86_5<=69)||LA86_5==71) ) {
                                    alt86=2;
                                }
                                else {
                                    if (backtracking>0) {failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("5539:1: ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? )", 86, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("5539:1: ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? )", 86, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 11:
                        case 24:
                        case 25:
                        case 29:
                        case 30:
                        case 34:
                        case 35:
                        case 38:
                        case 57:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 71:
                            {
                            alt86=2;
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("5539:1: ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? )", 86, 1, input);

                            throw nvae;
                        }

                    }
                    else if ( ((LA86_0>=RULE_INT && LA86_0<=RULE_STRING_LITERAL)||LA86_0==22||LA86_0==24||(LA86_0>=35 && LA86_0<=37)||(LA86_0>=39 && LA86_0<=51)||(LA86_0>=55 && LA86_0<=59)||LA86_0==70||LA86_0==77||LA86_0==81) ) {
                        alt86=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5539:1: ( ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) ) | ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )? )", 86, 0, input);

                        throw nvae;
                    }
                    switch (alt86) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5539:2: ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5539:2: ( ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5539:3: ( (lv_variable1_4_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )? '|' ( (lv_body_10_0= ruleOclExpressionCS ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5539:3: ( (lv_variable1_4_0= ruleiteratorVariableCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5540:1: (lv_variable1_4_0= ruleiteratorVariableCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5540:1: (lv_variable1_4_0= ruleiteratorVariableCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5541:3: lv_variable1_4_0= ruleiteratorVariableCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getVariable1IteratorVariableCSParserRuleCall_0_4_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleiteratorVariableCS_in_ruleCallArgumentsCS9967);
                            lv_variable1_4_0=ruleiteratorVariableCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"variable1",
                              	        		lv_variable1_4_0, 
                              	        		"iteratorVariableCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5563:2: ( ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) ) )?
                            int alt83=3;
                            int LA83_0 = input.LA(1);

                            if ( (LA83_0==23) ) {
                                alt83=1;
                            }
                            else if ( (LA83_0==72) ) {
                                alt83=2;
                            }
                            switch (alt83) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5563:3: ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5563:3: ( ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5563:5: ',' ( (lv_variable2_6_0= ruleiteratorVariableCS ) )
                                    {
                                    match(input,23,FOLLOW_23_in_ruleCallArgumentsCS9979); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_0_4_0_1_0_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5567:1: ( (lv_variable2_6_0= ruleiteratorVariableCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5568:1: (lv_variable2_6_0= ruleiteratorVariableCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5568:1: (lv_variable2_6_0= ruleiteratorVariableCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5569:3: lv_variable2_6_0= ruleiteratorVariableCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getVariable2IteratorVariableCSParserRuleCall_0_4_0_1_0_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorVariableCS_in_ruleCallArgumentsCS10000);
                                    lv_variable2_6_0=ruleiteratorVariableCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"variable2",
                                      	        		lv_variable2_6_0, 
                                      	        		"iteratorVariableCS", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }


                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5592:6: ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5592:6: ( ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5592:8: ';' ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) )
                                    {
                                    match(input,72,FOLLOW_72_in_ruleCallArgumentsCS10018); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getSemicolonKeyword_0_4_0_1_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5596:1: ( (lv_variable2_8_0= ruleiteratorAccumulatorCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5597:1: (lv_variable2_8_0= ruleiteratorAccumulatorCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5597:1: (lv_variable2_8_0= ruleiteratorAccumulatorCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5598:3: lv_variable2_8_0= ruleiteratorAccumulatorCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getVariable2IteratorAccumulatorCSParserRuleCall_0_4_0_1_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_ruleCallArgumentsCS10039);
                                    lv_variable2_8_0=ruleiteratorAccumulatorCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"variable2",
                                      	        		lv_variable2_8_0, 
                                      	        		"iteratorAccumulatorCS", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }


                                    }


                                    }
                                    break;

                            }

                            match(input,73,FOLLOW_73_in_ruleCallArgumentsCS10052); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getVerticalLineKeyword_0_4_0_2(), null); 
                                  
                            }
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5624:1: ( (lv_body_10_0= ruleOclExpressionCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5625:1: (lv_body_10_0= ruleOclExpressionCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5625:1: (lv_body_10_0= ruleOclExpressionCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5626:3: lv_body_10_0= ruleOclExpressionCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getBodyOclExpressionCSParserRuleCall_0_4_0_3_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10073);
                            lv_body_10_0=ruleOclExpressionCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"body",
                              	        		lv_body_10_0, 
                              	        		"OclExpressionCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5649:6: ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )?
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5649:6: ( ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )* )?
                            int alt85=2;
                            int LA85_0 = input.LA(1);

                            if ( ((LA85_0>=RULE_ID && LA85_0<=RULE_STRING_LITERAL)||LA85_0==22||(LA85_0>=35 && LA85_0<=37)||(LA85_0>=39 && LA85_0<=51)||(LA85_0>=55 && LA85_0<=59)||LA85_0==70||LA85_0==77||LA85_0==81) ) {
                                alt85=1;
                            }
                            switch (alt85) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5649:7: ( (lv_arguments_11_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )*
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5649:7: ( (lv_arguments_11_0= ruleOclExpressionCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5650:1: (lv_arguments_11_0= ruleOclExpressionCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5650:1: (lv_arguments_11_0= ruleOclExpressionCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5651:3: lv_arguments_11_0= ruleOclExpressionCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_0_4_1_0_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10102);
                                    lv_arguments_11_0=ruleOclExpressionCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		add(
                                      	       			current, 
                                      	       			"arguments",
                                      	        		lv_arguments_11_0, 
                                      	        		"OclExpressionCS", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }

                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5673:2: ( ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) ) )*
                                    loop84:
                                    do {
                                        int alt84=2;
                                        int LA84_0 = input.LA(1);

                                        if ( (LA84_0==23) ) {
                                            alt84=1;
                                        }


                                        switch (alt84) {
                                    	case 1 :
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5673:4: ',' ( (lv_arguments_13_0= ruleOclExpressionCS ) )
                                    	    {
                                    	    match(input,23,FOLLOW_23_in_ruleCallArgumentsCS10113); if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_0_4_1_1_0(), null); 
                                    	          
                                    	    }
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5677:1: ( (lv_arguments_13_0= ruleOclExpressionCS ) )
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5678:1: (lv_arguments_13_0= ruleOclExpressionCS )
                                    	    {
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5678:1: (lv_arguments_13_0= ruleOclExpressionCS )
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5679:3: lv_arguments_13_0= ruleOclExpressionCS
                                    	    {
                                    	    if ( backtracking==0 ) {
                                    	       
                                    	      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_0_4_1_1_1_0(), currentNode); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10134);
                                    	    lv_arguments_13_0=ruleOclExpressionCS();
                                    	    _fsp--;
                                    	    if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	      	        }
                                    	      	        try {
                                    	      	       		add(
                                    	      	       			current, 
                                    	      	       			"arguments",
                                    	      	        		lv_arguments_13_0, 
                                    	      	        		"OclExpressionCS", 
                                    	      	        		currentNode);
                                    	      	        } catch (ValueConverterException vce) {
                                    	      				handleValueConverterException(vce);
                                    	      	        }
                                    	      	        currentNode = currentNode.getParent();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop84;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    match(input,24,FOLLOW_24_in_ruleCallArgumentsCS10149); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getRightParenthesisKeyword_0_5(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5706:6: ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5706:6: ( () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )? )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5706:7: () '.' ( (lv_pathName_17_0= rulepathNameCS ) ) ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )? ( (lv_isPre_23_0= '@pre' ) )? ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )?
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5706:7: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5707:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCallArgumentsCSAccess().getDotIndexArgumentsCSAction_1_0().getType().getClassifier());
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getDotIndexArgumentsCSAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,11,FOLLOW_11_in_ruleCallArgumentsCS10179); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getFullStopKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5724:1: ( (lv_pathName_17_0= rulepathNameCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5725:1: (lv_pathName_17_0= rulepathNameCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5725:1: (lv_pathName_17_0= rulepathNameCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5726:3: lv_pathName_17_0= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getPathNamePathNameCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruleCallArgumentsCS10200);
                    lv_pathName_17_0=rulepathNameCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"pathName",
                      	        		lv_pathName_17_0, 
                      	        		"pathNameCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5748:2: ( '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']' )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==74) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5748:4: '[' ( (lv_indexes_19_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )* ']'
                            {
                            match(input,74,FOLLOW_74_in_ruleCallArgumentsCS10211); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getLeftSquareBracketKeyword_1_3_0(), null); 
                                  
                            }
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5752:1: ( (lv_indexes_19_0= ruleOclExpressionCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5753:1: (lv_indexes_19_0= ruleOclExpressionCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5753:1: (lv_indexes_19_0= ruleOclExpressionCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5754:3: lv_indexes_19_0= ruleOclExpressionCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10232);
                            lv_indexes_19_0=ruleOclExpressionCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"indexes",
                              	        		lv_indexes_19_0, 
                              	        		"OclExpressionCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5776:2: ( ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==23) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5776:4: ',' ( (lv_indexes_21_0= ruleOclExpressionCS ) )
                            	    {
                            	    match(input,23,FOLLOW_23_in_ruleCallArgumentsCS10243); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_1_3_2_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5780:1: ( (lv_indexes_21_0= ruleOclExpressionCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5781:1: (lv_indexes_21_0= ruleOclExpressionCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5781:1: (lv_indexes_21_0= ruleOclExpressionCS )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5782:3: lv_indexes_21_0= ruleOclExpressionCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_2_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10264);
                            	    lv_indexes_21_0=ruleOclExpressionCS();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	      	        }
                            	      	        try {
                            	      	       		add(
                            	      	       			current, 
                            	      	       			"indexes",
                            	      	        		lv_indexes_21_0, 
                            	      	        		"OclExpressionCS", 
                            	      	        		currentNode);
                            	      	        } catch (ValueConverterException vce) {
                            	      				handleValueConverterException(vce);
                            	      	        }
                            	      	        currentNode = currentNode.getParent();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop87;
                                }
                            } while (true);

                            match(input,75,FOLLOW_75_in_ruleCallArgumentsCS10276); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getRightSquareBracketKeyword_1_3_3(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5808:3: ( (lv_isPre_23_0= '@pre' ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==76) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5809:1: (lv_isPre_23_0= '@pre' )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5809:1: (lv_isPre_23_0= '@pre' )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5810:3: lv_isPre_23_0= '@pre'
                            {
                            lv_isPre_23_0=(Token)input.LT(1);
                            match(input,76,FOLLOW_76_in_ruleCallArgumentsCS10296); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getIsPrePreKeyword_1_4_0(), "isPre"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "isPre", true, "@pre", lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5829:3: ( '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')' )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==22) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5829:5: '(' ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )? ')'
                            {
                            match(input,22,FOLLOW_22_in_ruleCallArgumentsCS10321); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getLeftParenthesisKeyword_1_5_0(), null); 
                                  
                            }
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5833:1: ( ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )* )?
                            int alt91=2;
                            int LA91_0 = input.LA(1);

                            if ( ((LA91_0>=RULE_ID && LA91_0<=RULE_STRING_LITERAL)||LA91_0==22||(LA91_0>=35 && LA91_0<=37)||(LA91_0>=39 && LA91_0<=51)||(LA91_0>=55 && LA91_0<=59)||LA91_0==70||LA91_0==77||LA91_0==81) ) {
                                alt91=1;
                            }
                            switch (alt91) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5833:2: ( (lv_arguments_25_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )*
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5833:2: ( (lv_arguments_25_0= ruleOclExpressionCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5834:1: (lv_arguments_25_0= ruleOclExpressionCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5834:1: (lv_arguments_25_0= ruleOclExpressionCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5835:3: lv_arguments_25_0= ruleOclExpressionCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_5_1_0_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10343);
                                    lv_arguments_25_0=ruleOclExpressionCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		add(
                                      	       			current, 
                                      	       			"arguments",
                                      	        		lv_arguments_25_0, 
                                      	        		"OclExpressionCS", 
                                      	        		currentNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	        currentNode = currentNode.getParent();
                                      	    
                                    }

                                    }


                                    }

                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5857:2: ( ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) ) )*
                                    loop90:
                                    do {
                                        int alt90=2;
                                        int LA90_0 = input.LA(1);

                                        if ( (LA90_0==23) ) {
                                            alt90=1;
                                        }


                                        switch (alt90) {
                                    	case 1 :
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5857:4: ',' ( (lv_arguments_27_0= ruleOclExpressionCS ) )
                                    	    {
                                    	    match(input,23,FOLLOW_23_in_ruleCallArgumentsCS10354); if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	              createLeafNode(grammarAccess.getCallArgumentsCSAccess().getCommaKeyword_1_5_1_1_0(), null); 
                                    	          
                                    	    }
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5861:1: ( (lv_arguments_27_0= ruleOclExpressionCS ) )
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5862:1: (lv_arguments_27_0= ruleOclExpressionCS )
                                    	    {
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5862:1: (lv_arguments_27_0= ruleOclExpressionCS )
                                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5863:3: lv_arguments_27_0= ruleOclExpressionCS
                                    	    {
                                    	    if ( backtracking==0 ) {
                                    	       
                                    	      	        currentNode=createCompositeNode(grammarAccess.getCallArgumentsCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_5_1_1_1_0(), currentNode); 
                                    	      	    
                                    	    }
                                    	    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10375);
                                    	    lv_arguments_27_0=ruleOclExpressionCS();
                                    	    _fsp--;
                                    	    if (failed) return current;
                                    	    if ( backtracking==0 ) {

                                    	      	        if (current==null) {
                                    	      	            current = factory.create(grammarAccess.getCallArgumentsCSRule().getType().getClassifier());
                                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                    	      	        }
                                    	      	        try {
                                    	      	       		add(
                                    	      	       			current, 
                                    	      	       			"arguments",
                                    	      	        		lv_arguments_27_0, 
                                    	      	        		"OclExpressionCS", 
                                    	      	        		currentNode);
                                    	      	        } catch (ValueConverterException vce) {
                                    	      				handleValueConverterException(vce);
                                    	      	        }
                                    	      	        currentNode = currentNode.getParent();
                                    	      	    
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop90;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            match(input,24,FOLLOW_24_in_ruleCallArgumentsCS10389); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallArgumentsCSAccess().getRightParenthesisKeyword_1_5_2(), null); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleCallArgumentsCS


    // $ANTLR start entryRuleiteratorVariableCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5897:1: entryRuleiteratorVariableCS returns [EObject current=null] : iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF ;
    public final EObject entryRuleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5898:2: (iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5899:2: iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS10428);
            iv_ruleiteratorVariableCS=ruleiteratorVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorVariableCS10438); if (failed) return current;

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
    // $ANTLR end entryRuleiteratorVariableCS


    // $ANTLR start ruleiteratorVariableCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5906:1: ruleiteratorVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) ;
    public final EObject ruleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5911:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5912:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5912:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5912:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5912:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5913:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5913:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5914:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS10484);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIteratorVariableCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5936:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==16) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5936:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleiteratorVariableCS10495); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIteratorVariableCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5940:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5941:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5941:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5942:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorVariableCS10516);
                    lv_type_2_0=ruletypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getIteratorVariableCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"type",
                      	        		lv_type_2_0, 
                      	        		"typeCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleiteratorVariableCS


    // $ANTLR start entryRuleiteratorAccumulatorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5972:1: entryRuleiteratorAccumulatorCS returns [EObject current=null] : iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF ;
    public final EObject entryRuleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorAccumulatorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5973:2: (iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5974:2: iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorAccumulatorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS10554);
            iv_ruleiteratorAccumulatorCS=ruleiteratorAccumulatorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorAccumulatorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS10564); if (failed) return current;

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
    // $ANTLR end entryRuleiteratorAccumulatorCS


    // $ANTLR start ruleiteratorAccumulatorCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5981:1: ruleiteratorAccumulatorCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5986:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5987:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5987:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5987:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5987:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5988:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5988:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5989:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS10610);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIteratorAccumulatorCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FOLLOW_16_in_ruleiteratorAccumulatorCS10620); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6015:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6016:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6016:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6017:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS10641);
            lv_type_2_0=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIteratorAccumulatorCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_2_0, 
              	        		"typeCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,25,FOLLOW_25_in_ruleiteratorAccumulatorCS10651); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6043:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6044:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6044:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6045:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS10672);
            lv_initExpression_4_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIteratorAccumulatorCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"initExpression",
              	        		lv_initExpression_4_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleiteratorAccumulatorCS


    // $ANTLR start entryRuleimplicitCallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6075:1: entryRuleimplicitCallExpCS returns [EObject current=null] : iv_ruleimplicitCallExpCS= ruleimplicitCallExpCS EOF ;
    public final EObject entryRuleimplicitCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimplicitCallExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6076:2: (iv_ruleimplicitCallExpCS= ruleimplicitCallExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6077:2: iv_ruleimplicitCallExpCS= ruleimplicitCallExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImplicitCallExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleimplicitCallExpCS_in_entryRuleimplicitCallExpCS10708);
            iv_ruleimplicitCallExpCS=ruleimplicitCallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleimplicitCallExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleimplicitCallExpCS10718); if (failed) return current;

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
    // $ANTLR end entryRuleimplicitCallExpCS


    // $ANTLR start ruleimplicitCallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6084:1: ruleimplicitCallExpCS returns [EObject current=null] : this_preCallExpCS_0= rulepreCallExpCS ;
    public final EObject ruleimplicitCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_preCallExpCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6089:6: (this_preCallExpCS_0= rulepreCallExpCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6091:2: this_preCallExpCS_0= rulepreCallExpCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getImplicitCallExpCSAccess().getPreCallExpCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulepreCallExpCS_in_ruleimplicitCallExpCS10767);
            this_preCallExpCS_0=rulepreCallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_preCallExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleimplicitCallExpCS


    // $ANTLR start entryRulepreCallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6110:1: entryRulepreCallExpCS returns [EObject current=null] : iv_rulepreCallExpCS= rulepreCallExpCS EOF ;
    public final EObject entryRulepreCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepreCallExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6111:2: (iv_rulepreCallExpCS= rulepreCallExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6112:2: iv_rulepreCallExpCS= rulepreCallExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreCallExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepreCallExpCS_in_entryRulepreCallExpCS10801);
            iv_rulepreCallExpCS=rulepreCallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepreCallExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepreCallExpCS10811); if (failed) return current;

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
    // $ANTLR end entryRulepreCallExpCS


    // $ANTLR start rulepreCallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6119:1: rulepreCallExpCS returns [EObject current=null] : this_extendedPrimaryExpCS_0= ruleextendedPrimaryExpCS ;
    public final EObject rulepreCallExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_extendedPrimaryExpCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6124:6: (this_extendedPrimaryExpCS_0= ruleextendedPrimaryExpCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6126:2: this_extendedPrimaryExpCS_0= ruleextendedPrimaryExpCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getPreCallExpCSAccess().getExtendedPrimaryExpCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleextendedPrimaryExpCS_in_rulepreCallExpCS10860);
            this_extendedPrimaryExpCS_0=ruleextendedPrimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_extendedPrimaryExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end rulepreCallExpCS


    // $ANTLR start entryRuleprimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6147:1: entryRuleprimaryExpCS returns [EObject current=null] : iv_ruleprimaryExpCS= ruleprimaryExpCS EOF ;
    public final EObject entryRuleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimaryExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6148:2: (iv_ruleprimaryExpCS= ruleprimaryExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6149:2: iv_ruleprimaryExpCS= ruleprimaryExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS10896);
            iv_ruleprimaryExpCS=ruleprimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimaryExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimaryExpCS10906); if (failed) return current;

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
    // $ANTLR end entryRuleprimaryExpCS


    // $ANTLR start ruleprimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6156:1: ruleprimaryExpCS returns [EObject current=null] : (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) ;
    public final EObject ruleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_selfKeywordCS_0 = null;

        EObject this_LiteralExpCS_1 = null;

        EObject this_IfExpCS_2 = null;

        EObject this_OclExpressionCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6161:6: ( (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6162:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6162:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            int alt95=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt95=1;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING_LITERAL:
            case 36:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                {
                alt95=2;
                }
                break;
            case 77:
                {
                alt95=3;
                }
                break;
            case 22:
                {
                alt95=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("6162:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6163:2: this_selfKeywordCS_0= ruleselfKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfKeywordCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS10956);
                    this_selfKeywordCS_0=ruleselfKeywordCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_selfKeywordCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6176:2: this_LiteralExpCS_1= ruleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS10986);
                    this_LiteralExpCS_1=ruleLiteralExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LiteralExpCS_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6189:2: this_IfExpCS_2= ruleIfExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS11016);
                    this_IfExpCS_2=ruleIfExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_IfExpCS_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6201:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6201:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6201:8: '(' this_OclExpressionCS_4= ruleOclExpressionCS ')'
                    {
                    match(input,22,FOLLOW_22_in_ruleprimaryExpCS11032); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_3_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOclExpressionCSParserRuleCall_3_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS11057);
                    this_OclExpressionCS_4=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OclExpressionCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,24,FOLLOW_24_in_ruleprimaryExpCS11066); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimaryExpCSAccess().getRightParenthesisKeyword_3_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleprimaryExpCS


    // $ANTLR start entryRuleIfExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6229:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6230:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6231:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11103);
            iv_ruleIfExpCS=ruleIfExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpCS11113); if (failed) return current;

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
    // $ANTLR end entryRuleIfExpCS


    // $ANTLR start ruleIfExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6238:1: ruleIfExpCS returns [EObject current=null] : ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6243:6: ( ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6244:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6244:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6244:3: 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif'
            {
            match(input,77,FOLLOW_77_in_ruleIfExpCS11148); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getIfKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6248:1: ( (lv_condition_1_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6249:1: (lv_condition_1_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6249:1: (lv_condition_1_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6250:3: lv_condition_1_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getConditionOclExpressionCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11169);
            lv_condition_1_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"condition",
              	        		lv_condition_1_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,78,FOLLOW_78_in_ruleIfExpCS11179); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getThenKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6276:1: ( (lv_thenExpression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6277:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6277:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6278:3: lv_thenExpression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11200);
            lv_thenExpression_3_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"thenExpression",
              	        		lv_thenExpression_3_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,79,FOLLOW_79_in_ruleIfExpCS11210); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getElseKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6304:1: ( (lv_elseExpression_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6305:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6305:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6306:3: lv_elseExpression_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionOclExpressionCSParserRuleCall_5_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11231);
            lv_elseExpression_5_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getIfExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"elseExpression",
              	        		lv_elseExpression_5_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,80,FOLLOW_80_in_ruleIfExpCS11241); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getEndifKeyword_6(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleIfExpCS


    // $ANTLR start entryRuleLetExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6340:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6341:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6342:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11277);
            iv_ruleLetExpCS=ruleLetExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpCS11287); if (failed) return current;

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
    // $ANTLR end entryRuleLetExpCS


    // $ANTLR start ruleLetExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6349:1: ruleLetExpCS returns [EObject current=null] : ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6354:6: ( ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6355:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6355:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6355:3: 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) )
            {
            match(input,81,FOLLOW_81_in_ruleLetExpCS11322); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getLetKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6359:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6360:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6360:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6361:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11343);
            lv_variable_1_0=ruleLetVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLetExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"variable",
              	        		lv_variable_1_0, 
              	        		"LetVariableCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6383:2: ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==23) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6383:4: ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    match(input,23,FOLLOW_23_in_ruleLetExpCS11354); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6387:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6388:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6388:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6389:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11375);
            	    lv_variable_3_0=ruleLetVariableCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLetExpCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"variable",
            	      	        		lv_variable_3_0, 
            	      	        		"LetVariableCS", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            match(input,82,FOLLOW_82_in_ruleLetExpCS11387); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getInKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6415:1: ( (lv_in_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6416:1: (lv_in_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6416:1: (lv_in_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6417:3: lv_in_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getInOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS11408);
            lv_in_5_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLetExpCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"in",
              	        		lv_in_5_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleLetExpCS


    // $ANTLR start entryRuleLetVariableCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6447:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6448:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6449:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11444);
            iv_ruleLetVariableCS=ruleLetVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetVariableCS11454); if (failed) return current;

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
    // $ANTLR end entryRuleLetVariableCS


    // $ANTLR start ruleLetVariableCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6456:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6461:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6462:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6462:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6462:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6462:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6463:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6463:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6464:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS11500);
            lv_name_0_0=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLetVariableCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"simpleNameCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FOLLOW_16_in_ruleLetVariableCS11510); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6490:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6491:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6491:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6492:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleLetVariableCS11531);
            lv_type_2_0=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLetVariableCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_2_0, 
              	        		"typeCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,25,FOLLOW_25_in_ruleLetVariableCS11541); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6518:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6519:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6519:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6520:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS11562);
            lv_initExpression_4_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLetVariableCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"initExpression",
              	        		lv_initExpression_4_0, 
              	        		"OclExpressionCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleLetVariableCS

    // $ANTLR start synpred6
    public final void synpred6_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:368:2: ( rulepropertyContextDeclCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:368:2: rulepropertyContextDeclCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulepropertyContextDeclCS_in_synpred6654);
        rulepropertyContextDeclCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred6

    // $ANTLR start synpred7
    public final void synpred7_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:381:2: ( ruleclassifierContextDeclCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:381:2: ruleclassifierContextDeclCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleclassifierContextDeclCS_in_synpred7684);
        ruleclassifierContextDeclCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred7

    // $ANTLR start synpred37
    public final void synpred37_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1780:2: ( ruleprimaryExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1780:2: ruleprimaryExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleprimaryExpCS_in_synpred372965);
        ruleprimaryExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred37

    // $ANTLR start synpred68
    public final void synpred68_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3184:2: ( ruleCollectionLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3184:2: ruleCollectionLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_synpred685796);
        ruleCollectionLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred68

    // $ANTLR start synpred69
    public final void synpred69_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3197:2: ( ruleTupleLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3197:2: ruleTupleLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_synpred695826);
        ruleTupleLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred69

    // $ANTLR start synpred90
    public final void synpred90_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:2: ( () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:2: () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4207:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4208:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4226:2: ( ( 'implies' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4227:1: ( 'implies' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4227:1: ( 'implies' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4228:3: 'implies'
        {
        match(input,60,FOLLOW_60_in_synpred907930); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4247:2: ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4248:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4248:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4249:1: ( ruleimpliesCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4249:1: ( ruleimpliesCS | ruleLetExpCS )
        int alt108=2;
        int LA108_0 = input.LA(1);

        if ( ((LA108_0>=RULE_ID && LA108_0<=RULE_STRING_LITERAL)||LA108_0==22||(LA108_0>=35 && LA108_0<=37)||(LA108_0>=39 && LA108_0<=51)||(LA108_0>=55 && LA108_0<=59)||LA108_0==70||LA108_0==77) ) {
            alt108=1;
        }
        else if ( (LA108_0==81) ) {
            alt108=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4249:1: ( ruleimpliesCS | ruleLetExpCS )", 108, 0, input);

            throw nvae;
        }
        switch (alt108) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4250:3: ruleimpliesCS
                {
                pushFollow(FOLLOW_ruleimpliesCS_in_synpred907966);
                ruleimpliesCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4271:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred907985);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred90

    // $ANTLR start synpred92
    public final void synpred92_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:2: ( () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:2: () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4330:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4331:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4349:2: ( ( 'xor' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4350:1: ( 'xor' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4350:1: ( 'xor' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4351:3: 'xor'
        {
        match(input,61,FOLLOW_61_in_synpred928116); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4370:2: ( ( ( rulexorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4371:1: ( ( rulexorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4371:1: ( ( rulexorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4372:1: ( rulexorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4372:1: ( rulexorCS | ruleLetExpCS )
        int alt109=2;
        int LA109_0 = input.LA(1);

        if ( ((LA109_0>=RULE_ID && LA109_0<=RULE_STRING_LITERAL)||LA109_0==22||(LA109_0>=35 && LA109_0<=37)||(LA109_0>=39 && LA109_0<=51)||(LA109_0>=55 && LA109_0<=59)||LA109_0==70||LA109_0==77) ) {
            alt109=1;
        }
        else if ( (LA109_0==81) ) {
            alt109=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4372:1: ( rulexorCS | ruleLetExpCS )", 109, 0, input);

            throw nvae;
        }
        switch (alt109) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4373:3: rulexorCS
                {
                pushFollow(FOLLOW_rulexorCS_in_synpred928152);
                rulexorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4394:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred928171);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred92

    // $ANTLR start synpred94
    public final void synpred94_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:2: ( () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:2: () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4453:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4454:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4472:2: ( ( 'or' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4473:1: ( 'or' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4473:1: ( 'or' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4474:3: 'or'
        {
        match(input,62,FOLLOW_62_in_synpred948302); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4493:2: ( ( ( ruleorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4494:1: ( ( ruleorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4494:1: ( ( ruleorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4495:1: ( ruleorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4495:1: ( ruleorCS | ruleLetExpCS )
        int alt110=2;
        int LA110_0 = input.LA(1);

        if ( ((LA110_0>=RULE_ID && LA110_0<=RULE_STRING_LITERAL)||LA110_0==22||(LA110_0>=35 && LA110_0<=37)||(LA110_0>=39 && LA110_0<=51)||(LA110_0>=55 && LA110_0<=59)||LA110_0==70||LA110_0==77) ) {
            alt110=1;
        }
        else if ( (LA110_0==81) ) {
            alt110=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4495:1: ( ruleorCS | ruleLetExpCS )", 110, 0, input);

            throw nvae;
        }
        switch (alt110) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4496:3: ruleorCS
                {
                pushFollow(FOLLOW_ruleorCS_in_synpred948338);
                ruleorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4517:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred948357);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred94

    // $ANTLR start synpred96
    public final void synpred96_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:2: ( () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:2: () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4576:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4577:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4595:2: ( ( 'and' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4596:1: ( 'and' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4596:1: ( 'and' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4597:3: 'and'
        {
        match(input,63,FOLLOW_63_in_synpred968488); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4616:2: ( ( ( ruleandCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4617:1: ( ( ruleandCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4617:1: ( ( ruleandCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4618:1: ( ruleandCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4618:1: ( ruleandCS | ruleLetExpCS )
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( ((LA111_0>=RULE_ID && LA111_0<=RULE_STRING_LITERAL)||LA111_0==22||(LA111_0>=35 && LA111_0<=37)||(LA111_0>=39 && LA111_0<=51)||(LA111_0>=55 && LA111_0<=59)||LA111_0==70||LA111_0==77) ) {
            alt111=1;
        }
        else if ( (LA111_0==81) ) {
            alt111=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4618:1: ( ruleandCS | ruleLetExpCS )", 111, 0, input);

            throw nvae;
        }
        switch (alt111) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4619:3: ruleandCS
                {
                pushFollow(FOLLOW_ruleandCS_in_synpred968524);
                ruleandCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4640:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred968543);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred96

    // $ANTLR start synpred99
    public final void synpred99_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:2: ( () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:2: () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4699:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4700:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4718:2: ( ( ( '=' | '<>' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4719:1: ( ( '=' | '<>' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4719:1: ( ( '=' | '<>' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4720:1: ( '=' | '<>' )
        {
        if ( input.LA(1)==25||input.LA(1)==64 ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred998669);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4760:2: ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4761:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4761:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4762:1: ( ruleequalityCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4762:1: ( ruleequalityCS | ruleLetExpCS )
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( ((LA112_0>=RULE_ID && LA112_0<=RULE_STRING_LITERAL)||LA112_0==22||(LA112_0>=35 && LA112_0<=37)||(LA112_0>=39 && LA112_0<=51)||(LA112_0>=55 && LA112_0<=59)||LA112_0==70||LA112_0==77) ) {
            alt112=1;
        }
        else if ( (LA112_0==81) ) {
            alt112=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4762:1: ( ruleequalityCS | ruleLetExpCS )", 112, 0, input);

            throw nvae;
        }
        switch (alt112) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4763:3: ruleequalityCS
                {
                pushFollow(FOLLOW_ruleequalityCS_in_synpred998744);
                ruleequalityCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4784:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred998763);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99

    // $ANTLR start synpred104
    public final void synpred104_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:2: ( () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:2: () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4843:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4844:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4862:2: ( ( ( '>' | '<' | '>=' | '<=' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4863:1: ( ( '>' | '<' | '>=' | '<=' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4863:1: ( ( '>' | '<' | '>=' | '<=' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4864:1: ( '>' | '<' | '>=' | '<=' )
        {
        if ( (input.LA(1)>=65 && input.LA(1)<=68) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1048889);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4940:2: ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4941:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4941:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4942:1: ( rulerelationalCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4942:1: ( rulerelationalCS | ruleLetExpCS )
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( ((LA113_0>=RULE_ID && LA113_0<=RULE_STRING_LITERAL)||LA113_0==22||(LA113_0>=35 && LA113_0<=37)||(LA113_0>=39 && LA113_0<=51)||(LA113_0>=55 && LA113_0<=59)||LA113_0==70||LA113_0==77) ) {
            alt113=1;
        }
        else if ( (LA113_0==81) ) {
            alt113=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4942:1: ( rulerelationalCS | ruleLetExpCS )", 113, 0, input);

            throw nvae;
        }
        switch (alt113) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4943:3: rulerelationalCS
                {
                pushFollow(FOLLOW_rulerelationalCS_in_synpred1049022);
                rulerelationalCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4964:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred1049041);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred104

    // $ANTLR start synpred107
    public final void synpred107_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:2: () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5023:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5024:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5042:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5043:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5043:1: ( ( '+' | '-' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5044:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=34 && input.LA(1)<=35) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1079167);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5084:2: ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5085:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5085:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5086:1: ( ruleadditiveCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5086:1: ( ruleadditiveCS | ruleLetExpCS )
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( ((LA114_0>=RULE_ID && LA114_0<=RULE_STRING_LITERAL)||LA114_0==22||(LA114_0>=35 && LA114_0<=37)||(LA114_0>=39 && LA114_0<=51)||(LA114_0>=55 && LA114_0<=59)||LA114_0==70||LA114_0==77) ) {
            alt114=1;
        }
        else if ( (LA114_0==81) ) {
            alt114=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("5086:1: ( ruleadditiveCS | ruleLetExpCS )", 114, 0, input);

            throw nvae;
        }
        switch (alt114) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5087:3: ruleadditiveCS
                {
                pushFollow(FOLLOW_ruleadditiveCS_in_synpred1079242);
                ruleadditiveCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5108:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getRightLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred1079261);
                ruleLetExpCS();
                _fsp--;
                if (failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred107

    public final boolean synpred107() {
        backtracking++;
        int start = input.mark();
        try {
            synpred107_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred92() {
        backtracking++;
        int start = input.mark();
        try {
            synpred92_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred96() {
        backtracking++;
        int start = input.mark();
        try {
            synpred96_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred7() {
        backtracking++;
        int start = input.mark();
        try {
            synpred7_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred69() {
        backtracking++;
        int start = input.mark();
        try {
            synpred69_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred99() {
        backtracking++;
        int start = input.mark();
        try {
            synpred99_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred94() {
        backtracking++;
        int start = input.mark();
        try {
            synpred94_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred37() {
        backtracking++;
        int start = input.mark();
        try {
            synpred37_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred104() {
        backtracking++;
        int start = input.mark();
        try {
            synpred104_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred6() {
        backtracking++;
        int start = input.mark();
        try {
            synpred6_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred90() {
        backtracking++;
        int start = input.mark();
        try {
            synpred90_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred68() {
        backtracking++;
        int start = input.mark();
        try {
            synpred68_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\30\uffff";
    static final String DFA5_eofS =
        "\2\uffff\1\5\4\uffff\17\5\2\uffff";
    static final String DFA5_minS =
        "\1\17\1\4\1\15\1\4\2\uffff\1\4\17\15\1\uffff\1\0";
    static final String DFA5_maxS =
        "\1\17\1\4\1\46\1\63\2\uffff\1\63\17\46\1\uffff\1\0";
    static final String DFA5_acceptS =
        "\4\uffff\1\3\1\2\20\uffff\1\1\1\uffff";
    static final String DFA5_specialS =
        "\27\uffff\1\0}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\3\5\1\6\2\uffff\3\5\1\4\17\uffff\1\3",
            "\1\7\37\uffff\1\25\2\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\10\1\11\1\12\1\13\1\14",
            "",
            "",
            "\1\27\37\uffff\1\26\2\uffff\15\26",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "\3\5\1\26\2\uffff\3\5\1\4\17\uffff\1\3",
            "",
            "\1\uffff"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "367:1: (this_propertyContextDeclCS_0= rulepropertyContextDeclCS | this_classifierContextDeclCS_1= ruleclassifierContextDeclCS | this_operationContextDeclCS_2= ruleoperationContextDeclCS )";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_23 = input.LA(1);

                         
                        int index5_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6()) ) {s = 22;}

                        else if ( (synpred7()) ) {s = 5;}

                         
                        input.seek(index5_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimportCS_in_ruleModel137 = new BitSet(new long[]{0x000000000000B002L});
    public static final BitSet FOLLOW_rulepackageDeclarationCS_in_ruleModel160 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_rulecontextDeclCS_in_ruleModel187 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN277 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_ruleFQN296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQN311 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleimportCS_in_entryRuleimportCS358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleimportCS368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleimportCS403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleimportCS424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepackageDeclarationCS_in_entryRulepackageDeclarationCS460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepackageDeclarationCS470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulepackageDeclarationCS505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_rulepackageDeclarationCS526 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_rulecontextDeclCS_in_rulepackageDeclarationCS547 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_rulepackageDeclarationCS558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecontextDeclCS_in_entryRulecontextDeclCS594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecontextDeclCS604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepropertyContextDeclCS_in_rulecontextDeclCS654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleclassifierContextDeclCS_in_rulecontextDeclCS684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleoperationContextDeclCS_in_rulecontextDeclCS714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepropertyContextDeclCS_in_entryRulepropertyContextDeclCS749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepropertyContextDeclCS759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulepropertyContextDeclCS794 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_rulepropertyContextDeclCS815 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulepropertyContextDeclCS825 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_rulepropertyContextDeclCS846 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS869 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rulederCS_in_rulepropertyContextDeclCS890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulederCS_in_rulepropertyContextDeclCS921 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleinitCS_in_entryRuleinitCS981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleinitCS991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleinitCS1026 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleinitCS1036 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleinitCS1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulederCS_in_entryRulederCS1093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulederCS1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulederCS1138 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulederCS1148 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulederCS1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleclassifierContextDeclCS_in_entryRuleclassifierContextDeclCS1205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleclassifierContextDeclCS1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleclassifierContextDeclCS1250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleclassifierContextDeclCS1272 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleclassifierContextDeclCS1282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleclassifierContextDeclCS1305 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruleinvCS_in_ruleclassifierContextDeclCS1327 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruledefCS_in_ruleclassifierContextDeclCS1354 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruleinvCS_in_entryRuleinvCS1392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleinvCS1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleinvCS1437 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleinvCS1458 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleinvCS1469 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleinvCS1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruledefCS_in_entryRuledefCS1526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuledefCS1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruledefCS1579 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruledefCS1603 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruledefCS1624 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruledefCS1635 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruledefCS1656 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_22_in_ruledefCS1667 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleparameterCS_in_ruledefCS1689 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruledefCS1700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleparameterCS_in_ruledefCS1721 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruledefCS1735 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruledefCS1747 = new BitSet(new long[]{0x000FFF9002000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruledefCS1768 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruledefCS1779 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruledefCS1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleoperationContextDeclCS_in_entryRuleoperationContextDeclCS1836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleoperationContextDeclCS1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleoperationContextDeclCS1881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleoperationContextDeclCS1902 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleoperationContextDeclCS1912 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleparameterCS_in_ruleoperationContextDeclCS1934 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleoperationContextDeclCS1945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleparameterCS_in_ruleoperationContextDeclCS1966 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleoperationContextDeclCS1980 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleoperationContextDeclCS1990 = new BitSet(new long[]{0x000FFF901C000012L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleoperationContextDeclCS2011 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulepreCS_in_ruleoperationContextDeclCS2034 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulepostCS_in_ruleoperationContextDeclCS2061 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_ruleoperationContextDeclCS2088 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleparameterCS_in_entryRuleparameterCS2126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparameterCS2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleparameterCS2182 = new BitSet(new long[]{0x0000000002010002L});
    public static final BitSet FOLLOW_16_in_ruleparameterCS2193 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleparameterCS2214 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleparameterCS2227 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleparameterCS2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCS_in_entryRulepreCS2286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepreCS2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulepreCS2331 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepreCS2352 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulepreCS2363 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulepreCS2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepostCS_in_entryRulepostCS2420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepostCS2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rulepostCS2465 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepostCS2486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulepostCS2497 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulepostCS2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_entryRulebodyCS2554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebodyCS2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulebodyCS2599 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulebodyCS2620 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulebodyCS2631 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulebodyCS2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulenamedConstraintCS_in_entryRulenamedConstraintCS2690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulenamedConstraintCS2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_rulenamedConstraintCS2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruledefCS_in_rulenamedConstraintCS2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleinvCS_in_rulenamedConstraintCS2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepostCS_in_rulenamedConstraintCS2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCS_in_rulenamedConstraintCS2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedPrimaryExpCS_in_entryRuleextendedPrimaryExpCS2905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleextendedPrimaryExpCS2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_ruleextendedPrimaryExpCS2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageExpCS_in_ruleextendedPrimaryExpCS2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageExpCS_in_entryRuleOclMessageExpCS3030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclMessageExpCS3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_ruleOclMessageExpCS3086 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleOclMessageExpCS3106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_30_in_ruleOclMessageExpCS3135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleOclMessageExpCS3172 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOclMessageExpCS3182 = new BitSet(new long[]{0x0F8FFFB881400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3204 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleOclMessageExpCS3215 = new BitSet(new long[]{0x0F8FFFB880400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3236 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleOclMessageExpCS3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_entryRuleOclMessageArgCS3286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclMessageArgCS3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleOclMessageArgCS3344 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleOclMessageArgCS3355 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleOclMessageArgCS3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleOclMessageArgCS3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL3446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL_LITERAL3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3497 = new BitSet(new long[]{0x0000000300000800L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL3517 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL3559 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3574 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_32_in_ruleREAL_LITERAL3595 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_33_in_ruleREAL_LITERAL3614 = new BitSet(new long[]{0x0000000C00000020L});
    public static final BitSet FOLLOW_34_in_ruleREAL_LITERAL3629 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_ruleREAL_LITERAL3648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL3713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER_LITERAL3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS3807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleKeywordCS3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruletupleKeywordCS3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerestrictedKeywordCS3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS4027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS4062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleselfKeywordCS4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleselfKeywordCS4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS4162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesimpleNameCS4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulesimpleNameCS4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS4253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_entryRulepathNameCS4378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepathNameCS4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepathNameCS4434 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_rulepathNameCS4445 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS4466 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS4504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimitiveTypeCS4514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleprimitiveTypeCS4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleprimitiveTypeCS4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleprimitiveTypeCS4631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleprimitiveTypeCS4668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleprimitiveTypeCS4705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleprimitiveTypeCS4742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleprimitiveTypeCS4779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleprimitiveTypeCS4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS4865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleCollectionTypeIdentifierCS4918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCollectionTypeIdentifierCS4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCollectionTypeIdentifierCS4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleCollectionTypeIdentifierCS5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleCollectionTypeIdentifierCS5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletypeCS_in_entryRuletypeCS5115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletypeCS5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruletypeCS5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruletypeCS5235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruletypeCS5265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS5300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecollectionTypeCS5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS5356 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rulecollectionTypeCS5366 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_rulecollectionTypeCS5387 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulecollectionTypeCS5397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS5433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleTypeCS5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruletupleTypeCS5486 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruletupleTypeCS5509 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5531 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruletupleTypeCS5542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5563 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruletupleTypeCS5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS5613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletuplePartCS5623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruletuplePartCS5669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruletuplePartCS5679 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruletuplePartCS5700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS5736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpCS5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS5796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS5826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS5921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS5931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_ruleCollectionLiteralExpCS5982 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS6012 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleCollectionLiteralExpCS6022 = new BitSet(new long[]{0x0FAFFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6044 = new BitSet(new long[]{0x0020000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCollectionLiteralExpCS6055 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6076 = new BitSet(new long[]{0x0020000000800000L});
    public static final BitSet FOLLOW_53_in_ruleCollectionLiteralExpCS6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6182 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleCollectionLiteralPartCS6193 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS6342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS6572 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleTupleLiteralExpCS6582 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6603 = new BitSet(new long[]{0x0020000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTupleLiteralExpCS6614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6635 = new BitSet(new long[]{0x0020000000800000L});
    public static final BitSet FOLLOW_53_in_ruleTupleLiteralExpCS6647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS6739 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleTupleLiteralPartCS6750 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS6771 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS6783 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS6840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS6930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralExpCS6940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS7030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS7071 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7112 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleBooleanLiteralExpCS7165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBooleanLiteralExpCS7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUnlimitedNaturalLiteralExpCS7308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleInvalidLiteralExpCS7401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleNullLiteralExpCS7494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS7590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS7620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruleTypeLiteralExpCS7650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS7680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS7715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclExpressionCS7725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS7775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS7805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS7840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleimpliesCS7850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_ruleimpliesCS7900 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleimpliesCS7930 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleimpliesCS7966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleimpliesCS7985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_entryRulexorCS8026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulexorCS8036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_rulexorCS8086 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_rulexorCS8116 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_rulexorCS_in_rulexorCS8152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulexorCS8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_entryRuleorCS8212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleorCS8222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleorCS8272 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleorCS8302 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleorCS_in_ruleorCS8338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleorCS8357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_entryRuleandCS8398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleandCS8408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleandCS8458 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleandCS8488 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleandCS8524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleandCS8543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_entryRuleequalityCS8584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityCS8594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_ruleequalityCS8644 = new BitSet(new long[]{0x0000000002000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_25_in_ruleequalityCS8676 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_64_in_ruleequalityCS8705 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleequalityCS8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleequalityCS8763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_entryRulerelationalCS8804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalCS8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_rulerelationalCS8864 = new BitSet(new long[]{0x0000000000000002L,0x000000000000001EL});
    public static final BitSet FOLLOW_65_in_rulerelationalCS8896 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_66_in_rulerelationalCS8925 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_67_in_rulerelationalCS8954 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_68_in_rulerelationalCS8983 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_rulerelationalCS_in_rulerelationalCS9022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulerelationalCS9041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS9082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveCS9092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS9142 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_ruleadditiveCS9174 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_35_in_ruleadditiveCS9203 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_ruleadditiveCS9242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleadditiveCS9261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS9302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeCS9312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_rulemultiplicativeCS9362 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_rulemultiplicativeCS9394 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_69_in_rulemultiplicativeCS9423 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS9462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS9481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_entryRuleunaryCS9522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryCS9532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecalledExpCS_in_ruleunaryCS9582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleunaryCS9620 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000002040L});
    public static final BitSet FOLLOW_70_in_ruleunaryCS9649 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000002040L});
    public static final BitSet FOLLOW_ruleunaryCS_in_ruleunaryCS9686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecalledExpCS_in_entryRulecalledExpCS9723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecalledExpCS9733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimplicitCallExpCS_in_rulecalledExpCS9783 = new BitSet(new long[]{0x0000000000000802L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCallArgumentsCS_in_rulecalledExpCS9816 = new BitSet(new long[]{0x0000000000000802L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleCallArgumentsCS_in_entryRuleCallArgumentsCS9855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallArgumentsCS9865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleCallArgumentsCS9913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleCallArgumentsCS9934 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCallArgumentsCS9944 = new BitSet(new long[]{0x0F8FFFB801400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_ruleCallArgumentsCS9967 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000300L});
    public static final BitSet FOLLOW_23_in_ruleCallArgumentsCS9979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_ruleCallArgumentsCS10000 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_72_in_ruleCallArgumentsCS10018 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_ruleCallArgumentsCS10039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleCallArgumentsCS10052 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10073 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10102 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleCallArgumentsCS10113 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10134 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleCallArgumentsCS10149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleCallArgumentsCS10179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleCallArgumentsCS10200 = new BitSet(new long[]{0x0000000000400002L,0x0000000000001400L});
    public static final BitSet FOLLOW_74_in_ruleCallArgumentsCS10211 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10232 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_23_in_ruleCallArgumentsCS10243 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10264 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleCallArgumentsCS10276 = new BitSet(new long[]{0x0000000000400002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleCallArgumentsCS10296 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleCallArgumentsCS10321 = new BitSet(new long[]{0x0F8FFFB801400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10343 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleCallArgumentsCS10354 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCallArgumentsCS10375 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleCallArgumentsCS10389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS10428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorVariableCS10438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS10484 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleiteratorVariableCS10495 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorVariableCS10516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS10554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS10564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS10610 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleiteratorAccumulatorCS10620 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS10641 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleiteratorAccumulatorCS10651 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS10672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimplicitCallExpCS_in_entryRuleimplicitCallExpCS10708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleimplicitCallExpCS10718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCallExpCS_in_ruleimplicitCallExpCS10767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCallExpCS_in_entryRulepreCallExpCS10801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepreCallExpCS10811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleextendedPrimaryExpCS_in_rulepreCallExpCS10860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS10896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimaryExpCS10906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS10956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS10986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS11016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleprimaryExpCS11032 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS11057 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleprimaryExpCS11066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS11113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleIfExpCS11148 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11169 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleIfExpCS11179 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleIfExpCS11210 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleIfExpCS11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS11287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleLetExpCS11322 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11343 = new BitSet(new long[]{0x0000000000800000L,0x0000000000040000L});
    public static final BitSet FOLLOW_23_in_ruleLetExpCS11354 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11375 = new BitSet(new long[]{0x0000000000800000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ruleLetExpCS11387 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS11408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS11454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS11500 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLetVariableCS11510 = new BitSet(new long[]{0x000FFF9000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleLetVariableCS11531 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLetVariableCS11541 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS11562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepropertyContextDeclCS_in_synpred6654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleclassifierContextDeclCS_in_synpred7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_synpred372965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred685796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred695826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred907930 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_synpred907966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred907985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred928116 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_rulexorCS_in_synpred928152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred928171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred948302 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleorCS_in_synpred948338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred948357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred968488 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleandCS_in_synpred968524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred968543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred998669 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleequalityCS_in_synpred998744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred998763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1048889 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_rulerelationalCS_in_synpred1049022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred1049041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1079167 = new BitSet(new long[]{0x0F8FFFB800400070L,0x0000000000022040L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_synpred1079242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred1079261 = new BitSet(new long[]{0x0000000000000002L});

}