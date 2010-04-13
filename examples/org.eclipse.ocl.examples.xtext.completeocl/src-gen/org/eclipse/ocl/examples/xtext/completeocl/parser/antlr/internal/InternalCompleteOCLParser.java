package org.eclipse.ocl.examples.xtext.completeocl.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalCompleteOCLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING_LITERAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'import'", "'package'", "'endpackage'", "'context'", "':'", "'init'", "'derive'", "'inv'", "'static'", "'def'", "'('", "','", "')'", "'='", "'pre'", "'post'", "'body'", "'@'", "'^^'", "'^'", "'?'", "'e'", "'E'", "'+'", "'-'", "'Tuple'", "'self'", "'::'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'{'", "'}'", "'..'", "'true'", "'false'", "'*'", "'invalid'", "'null'", "'implies'", "'xor'", "'or'", "'and'", "'<>'", "'>'", "'<'", "'>='", "'<='", "'/'", "'not'", "'->'", "';'", "'|'", "'['", "']'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'"
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
            ruleMemo = new HashMap[265+1];
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

            if ( (LA18_0==RULE_ID||LA18_0==37||(LA18_0>=40 && LA18_0<=52)) ) {
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

            if ( (LA21_0==RULE_ID||LA21_0==37||(LA21_0>=40 && LA21_0<=52)) ) {
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


    // $ANTLR start entryRulemessageExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1764:1: entryRulemessageExpCS returns [EObject current=null] : iv_rulemessageExpCS= rulemessageExpCS EOF ;
    public final EObject entryRulemessageExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemessageExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1765:2: (iv_rulemessageExpCS= rulemessageExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1766:2: iv_rulemessageExpCS= rulemessageExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMessageExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulemessageExpCS_in_entryRulemessageExpCS2905);
            iv_rulemessageExpCS=rulemessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulemessageExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemessageExpCS2915); if (failed) return current;

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
    // $ANTLR end entryRulemessageExpCS


    // $ANTLR start rulemessageExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1773:1: rulemessageExpCS returns [EObject current=null] : (this_primaryExpCS_0= ruleprimaryExpCS | this_OclMessageExpCS_1= ruleOclMessageExpCS ) ;
    public final EObject rulemessageExpCS() throws RecognitionException {
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
            case 38:
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
            case 48:
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
            case 49:
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
            case 50:
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
            case 51:
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
            case 52:
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
            case 37:
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
            case 56:
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
            case 57:
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
            case 58:
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
            case 59:
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
            case 60:
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
            case 40:
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
            case 41:
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
            case 42:
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
            case 43:
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
            case 44:
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
            case 45:
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
            case 46:
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
            case 47:
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
                       
                              currentNode=createCompositeNode(grammarAccess.getMessageExpCSAccess().getPrimaryExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimaryExpCS_in_rulemessageExpCS2965);
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
                       
                              currentNode=createCompositeNode(grammarAccess.getMessageExpCSAccess().getOclMessageExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclMessageExpCS_in_rulemessageExpCS2995);
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
    // $ANTLR end rulemessageExpCS


    // $ANTLR start entryRulepreExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1812:1: entryRulepreExpCS returns [EObject current=null] : iv_rulepreExpCS= rulepreExpCS EOF ;
    public final EObject entryRulepreExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepreExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1813:2: (iv_rulepreExpCS= rulepreExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1814:2: iv_rulepreExpCS= rulepreExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepreExpCS_in_entryRulepreExpCS3030);
            iv_rulepreExpCS=rulepreExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepreExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepreExpCS3040); if (failed) return current;

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
    // $ANTLR end entryRulepreExpCS


    // $ANTLR start rulepreExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1821:1: rulepreExpCS returns [EObject current=null] : (this_indexExpCS_0= ruleindexExpCS ( () '@' ( (lv_op_3_0= 'pre' ) ) )? ) ;
    public final EObject rulepreExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_3_0=null;
        EObject this_indexExpCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1826:6: ( (this_indexExpCS_0= ruleindexExpCS ( () '@' ( (lv_op_3_0= 'pre' ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:1: (this_indexExpCS_0= ruleindexExpCS ( () '@' ( (lv_op_3_0= 'pre' ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1827:1: (this_indexExpCS_0= ruleindexExpCS ( () '@' ( (lv_op_3_0= 'pre' ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1828:2: this_indexExpCS_0= ruleindexExpCS ( () '@' ( (lv_op_3_0= 'pre' ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getPreExpCSAccess().getIndexExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleindexExpCS_in_rulepreExpCS3090);
            this_indexExpCS_0=ruleindexExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_indexExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1839:1: ( () '@' ( (lv_op_3_0= 'pre' ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1839:2: () '@' ( (lv_op_3_0= 'pre' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1839:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1840:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getPreExpCSAccess().getUnaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getPreExpCSAccess().getUnaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,29,FOLLOW_29_in_rulepreExpCS3112); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPreExpCSAccess().getCommercialAtKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1862:1: ( (lv_op_3_0= 'pre' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1863:1: (lv_op_3_0= 'pre' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1863:1: (lv_op_3_0= 'pre' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1864:3: lv_op_3_0= 'pre'
                    {
                    lv_op_3_0=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_rulepreExpCS3130); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPreExpCSAccess().getOpPreKeyword_1_2_0(), "op"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getPreExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "op", lv_op_3_0, "pre", lastConsumedNode);
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
    // $ANTLR end rulepreExpCS


    // $ANTLR start entryRuleOclMessageExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1891:1: entryRuleOclMessageExpCS returns [EObject current=null] : iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF ;
    public final EObject entryRuleOclMessageExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclMessageExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1892:2: (iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1893:2: iv_ruleOclMessageExpCS= ruleOclMessageExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclMessageExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclMessageExpCS_in_entryRuleOclMessageExpCS3181);
            iv_ruleOclMessageExpCS=ruleOclMessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclMessageExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclMessageExpCS3191); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1900:1: ruleOclMessageExpCS returns [EObject current=null] : ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' ) ;
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1905:6: ( ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1906:1: ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1906:1: ( ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1906:2: ( (lv_source_0_0= ruleprimaryExpCS ) ) ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) ) ( (lv_messageName_2_0= rulesimpleNameCS ) ) '(' ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )? ')'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1906:2: ( (lv_source_0_0= ruleprimaryExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1907:1: (lv_source_0_0= ruleprimaryExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1907:1: (lv_source_0_0= ruleprimaryExpCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1908:3: lv_source_0_0= ruleprimaryExpCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getSourcePrimaryExpCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_ruleOclMessageExpCS3237);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1930:2: ( ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1931:1: ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1931:1: ( (lv_op_1_1= '^^' | lv_op_1_2= '^' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1932:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1932:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==30) ) {
                alt31=1;
            }
            else if ( (LA31_0==31) ) {
                alt31=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1932:1: (lv_op_1_1= '^^' | lv_op_1_2= '^' )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1933:3: lv_op_1_1= '^^'
                    {
                    lv_op_1_1=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleOclMessageExpCS3257); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1951:8: lv_op_1_2= '^'
                    {
                    lv_op_1_2=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleOclMessageExpCS3286); if (failed) return current;
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1972:2: ( (lv_messageName_2_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1973:1: (lv_messageName_2_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1973:1: (lv_messageName_2_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:1974:3: lv_messageName_2_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getMessageNameSimpleNameCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleOclMessageExpCS3323);
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

            match(input,22,FOLLOW_22_in_ruleOclMessageExpCS3333); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOclMessageExpCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:1: ( ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_STRING_LITERAL)||LA33_0==22||LA33_0==32||(LA33_0>=36 && LA33_0<=38)||(LA33_0>=40 && LA33_0<=52)||(LA33_0>=56 && LA33_0<=60)||LA33_0==71||LA33_0==77||LA33_0==81) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:2: ( (lv_arguments_4_0= ruleOclMessageArgCS ) ) ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2000:2: ( (lv_arguments_4_0= ruleOclMessageArgCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2001:1: (lv_arguments_4_0= ruleOclMessageArgCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2001:1: (lv_arguments_4_0= ruleOclMessageArgCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2002:3: lv_arguments_4_0= ruleOclMessageArgCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3355);
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2024:2: ( ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==23) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2024:4: ',' ( (lv_arguments_6_0= ruleOclMessageArgCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleOclMessageExpCS3366); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getOclMessageExpCSAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2028:1: ( (lv_arguments_6_0= ruleOclMessageArgCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2029:1: (lv_arguments_6_0= ruleOclMessageArgCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2029:1: (lv_arguments_6_0= ruleOclMessageArgCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2030:3: lv_arguments_6_0= ruleOclMessageArgCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOclMessageExpCSAccess().getArgumentsOclMessageArgCSParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3387);
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
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruleOclMessageExpCS3401); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2064:1: entryRuleOclMessageArgCS returns [EObject current=null] : iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF ;
    public final EObject entryRuleOclMessageArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclMessageArgCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2065:2: (iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2066:2: iv_ruleOclMessageArgCS= ruleOclMessageArgCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclMessageArgCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclMessageArgCS_in_entryRuleOclMessageArgCS3437);
            iv_ruleOclMessageArgCS=ruleOclMessageArgCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclMessageArgCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclMessageArgCS3447); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2073:1: ruleOclMessageArgCS returns [EObject current=null] : ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS ) ;
    public final EObject ruleOclMessageArgCS() throws RecognitionException {
        EObject current = null;

        EObject lv_type_3_0 = null;

        EObject this_OclExpressionCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2078:6: ( ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING_LITERAL)||LA35_0==22||(LA35_0>=36 && LA35_0<=38)||(LA35_0>=40 && LA35_0<=52)||(LA35_0>=56 && LA35_0<=60)||LA35_0==71||LA35_0==77||LA35_0==81) ) {
                alt35=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2079:1: ( ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? ) | this_OclExpressionCS_4= ruleOclExpressionCS )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:2: ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:2: ( () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )? )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:3: () '?' ( ':' ( (lv_type_3_0= ruletypeCS ) ) )?
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2079:3: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2080:2: 
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

                    match(input,32,FOLLOW_32_in_ruleOclMessageArgCS3495); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOclMessageArgCSAccess().getQuestionMarkKeyword_0_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2097:1: ( ':' ( (lv_type_3_0= ruletypeCS ) ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==16) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2097:3: ':' ( (lv_type_3_0= ruletypeCS ) )
                            {
                            match(input,16,FOLLOW_16_in_ruleOclMessageArgCS3506); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getOclMessageArgCSAccess().getColonKeyword_0_2_0(), null); 
                                  
                            }
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2101:1: ( (lv_type_3_0= ruletypeCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2102:1: (lv_type_3_0= ruletypeCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2102:1: (lv_type_3_0= ruletypeCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2103:3: lv_type_3_0= ruletypeCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOclMessageArgCSAccess().getTypeTypeCSParserRuleCall_0_2_1_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruletypeCS_in_ruleOclMessageArgCS3527);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2127:2: this_OclExpressionCS_4= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclMessageArgCSAccess().getOclExpressionCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleOclMessageArgCS3561);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2146:1: entryRuleREAL_LITERAL returns [String current=null] : iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF ;
    public final String entryRuleREAL_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2147:2: (iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2148:2: iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getREAL_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL3597);
            iv_ruleREAL_LITERAL=ruleREAL_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleREAL_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL_LITERAL3608); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2155:1: ruleREAL_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) ;
    public final AntlrDatatypeRuleToken ruleREAL_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2160:6: ( (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2161:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2161:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2161:6: this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3648); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2168:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==11) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==RULE_INT) ) {
                    int LA39_3 = input.LA(3);

                    if ( ((LA39_3>=33 && LA39_3<=34)) ) {
                        alt39=2;
                    }
                    else if ( (LA39_3==EOF||LA39_3==11||(LA39_3>=13 && LA39_3<=15)||(LA39_3>=17 && LA39_3<=31)||(LA39_3>=35 && LA39_3<=36)||(LA39_3>=54 && LA39_3<=55)||LA39_3==58||(LA39_3>=61 && LA39_3<=70)||LA39_3==72||(LA39_3>=74 && LA39_3<=76)||(LA39_3>=78 && LA39_3<=80)||LA39_3==82) ) {
                        alt39=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2168:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 39, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("2168:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA39_0>=33 && LA39_0<=34)) ) {
                alt39=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2168:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2168:2: (kw= '.' this_INT_2= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2168:2: (kw= '.' this_INT_2= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2169:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleREAL_LITERAL3668); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_0_0(), null); 
                          
                    }
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3683); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2182:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2182:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2182:7: (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2182:7: (kw= '.' this_INT_4= RULE_INT )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==11) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2183:2: kw= '.' this_INT_4= RULE_INT
                            {
                            kw=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_ruleREAL_LITERAL3710); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_1_0_0(), null); 
                                  
                            }
                            this_INT_4=(Token)input.LT(1);
                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3725); if (failed) return current;
                            if ( backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( backtracking==0 ) {
                               
                                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_1_1_0_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2195:3: (kw= 'e' | kw= 'E' )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==33) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==34) ) {
                        alt37=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2195:3: (kw= 'e' | kw= 'E' )", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2196:2: kw= 'e'
                            {
                            kw=(Token)input.LT(1);
                            match(input,33,FOLLOW_33_in_ruleREAL_LITERAL3746); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2203:2: kw= 'E'
                            {
                            kw=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleREAL_LITERAL3765); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2208:2: (kw= '+' | kw= '-' )?
                    int alt38=3;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==35) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==36) ) {
                        alt38=2;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2209:2: kw= '+'
                            {
                            kw=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleREAL_LITERAL3780); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getPlusSignKeyword_1_1_2_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2216:2: kw= '-'
                            {
                            kw=(Token)input.LT(1);
                            match(input,36,FOLLOW_36_in_ruleREAL_LITERAL3799); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getHyphenMinusKeyword_1_1_2_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    this_INT_9=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL3816); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2236:1: entryRuleINTEGER_LITERAL returns [String current=null] : iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF ;
    public final String entryRuleINTEGER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2237:2: (iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2238:2: iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getINTEGER_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL3864);
            iv_ruleINTEGER_LITERAL=ruleINTEGER_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleINTEGER_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER_LITERAL3875); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2245:1: ruleINTEGER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleINTEGER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2250:6: (this_INT_0= RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2251:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL3914); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2268:1: entryRuletupleKeywordCS returns [EObject current=null] : iv_ruletupleKeywordCS= ruletupleKeywordCS EOF ;
    public final EObject entryRuletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2269:2: (iv_ruletupleKeywordCS= ruletupleKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2270:2: iv_ruletupleKeywordCS= ruletupleKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS3960);
            iv_ruletupleKeywordCS=ruletupleKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleKeywordCS3970); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2277:1: ruletupleKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'Tuple' ) ) ;
    public final EObject ruletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2282:6: ( ( (lv_value_0_0= 'Tuple' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2283:1: ( (lv_value_0_0= 'Tuple' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2283:1: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2284:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2284:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2285:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_ruletupleKeywordCS4012); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2312:1: entryRulerestrictedKeywordCS returns [EObject current=null] : iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF ;
    public final EObject entryRulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerestrictedKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2313:2: (iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2314:2: iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRestrictedKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS4060);
            iv_rulerestrictedKeywordCS=rulerestrictedKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerestrictedKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerestrictedKeywordCS4070); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2321:1: rulerestrictedKeywordCS returns [EObject current=null] : (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) ;
    public final EObject rulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeIdentifierCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_tupleKeywordCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2326:6: ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2327:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2327:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt40=1;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt40=2;
                }
                break;
            case 37:
                {
                alt40=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2327:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2328:2: this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS4120);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2341:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS4150);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2354:2: this_tupleKeywordCS_2= ruletupleKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getTupleKeywordCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS4180);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2373:1: entryRuleselfKeywordCS returns [EObject current=null] : iv_ruleselfKeywordCS= ruleselfKeywordCS EOF ;
    public final EObject entryRuleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleselfKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2374:2: (iv_ruleselfKeywordCS= ruleselfKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2375:2: iv_ruleselfKeywordCS= ruleselfKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSelfKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS4215);
            iv_ruleselfKeywordCS=ruleselfKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleselfKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleselfKeywordCS4225); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2382:1: ruleselfKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'self' ) ) ;
    public final EObject ruleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2387:6: ( ( (lv_value_0_0= 'self' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2388:1: ( (lv_value_0_0= 'self' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2388:1: ( (lv_value_0_0= 'self' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2389:1: (lv_value_0_0= 'self' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2389:1: (lv_value_0_0= 'self' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2390:3: lv_value_0_0= 'self'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,38,FOLLOW_38_in_ruleselfKeywordCS4267); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2417:1: entryRulesimpleNameCS returns [EObject current=null] : iv_rulesimpleNameCS= rulesimpleNameCS EOF ;
    public final EObject entryRulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2418:2: (iv_rulesimpleNameCS= rulesimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2419:2: iv_rulesimpleNameCS= rulesimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS4315);
            iv_rulesimpleNameCS=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulesimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulesimpleNameCS4325); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2426:1: rulesimpleNameCS returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject rulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2431:6: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2432:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2432:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2433:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2433:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2434:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulesimpleNameCS4366); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2464:1: entryRuleunreservedSimpleNameCS returns [EObject current=null] : iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF ;
    public final EObject entryRuleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunreservedSimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2465:2: (iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2466:2: iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnreservedSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS4406);
            iv_ruleunreservedSimpleNameCS=ruleunreservedSimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunreservedSimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS4416); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2473:1: ruleunreservedSimpleNameCS returns [EObject current=null] : (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) ;
    public final EObject ruleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject this_simpleNameCS_0 = null;

        EObject this_restrictedKeywordCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2478:6: ( (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2479:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2479:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            else if ( (LA41_0==37||(LA41_0>=40 && LA41_0<=52)) ) {
                alt41=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2479:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2480:2: this_simpleNameCS_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getSimpleNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS4466);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2493:2: this_restrictedKeywordCS_1= rulerestrictedKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getRestrictedKeywordCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS4496);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2512:1: entryRulepathNameCS returns [EObject current=null] : iv_rulepathNameCS= rulepathNameCS EOF ;
    public final EObject entryRulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepathNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2513:2: (iv_rulepathNameCS= rulepathNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2514:2: iv_rulepathNameCS= rulepathNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPathNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepathNameCS_in_entryRulepathNameCS4531);
            iv_rulepathNameCS=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepathNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepathNameCS4541); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2521:1: rulepathNameCS returns [EObject current=null] : ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) ;
    public final EObject rulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject lv_simpleNames_0_0 = null;

        EObject lv_simpleNames_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2526:6: ( ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2527:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2527:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2527:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2527:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2528:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2528:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2529:3: lv_simpleNames_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_rulepathNameCS4587);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2551:2: ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==39) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2551:4: '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    {
            	    match(input,39,FOLLOW_39_in_rulepathNameCS4598); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2555:1: ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2556:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2556:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2557:3: lv_simpleNames_2_0= ruleunreservedSimpleNameCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS4619);
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
            	    break loop42;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2587:1: entryRuleprimitiveTypeCS returns [EObject current=null] : iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF ;
    public final EObject entryRuleprimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimitiveTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2588:2: (iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2589:2: iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS4657);
            iv_ruleprimitiveTypeCS=ruleprimitiveTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimitiveTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimitiveTypeCS4667); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2596:1: ruleprimitiveTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) ;
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2601:6: ( ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2602:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2602:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            int alt43=8;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt43=1;
                }
                break;
            case 41:
                {
                alt43=2;
                }
                break;
            case 42:
                {
                alt43=3;
                }
                break;
            case 43:
                {
                alt43=4;
                }
                break;
            case 44:
                {
                alt43=5;
                }
                break;
            case 45:
                {
                alt43=6;
                }
                break;
            case 46:
                {
                alt43=7;
                }
                break;
            case 47:
                {
                alt43=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2602:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2602:2: ( (lv_value_0_0= 'Boolean' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2602:2: ( (lv_value_0_0= 'Boolean' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2603:1: (lv_value_0_0= 'Boolean' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2603:1: (lv_value_0_0= 'Boolean' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2604:3: lv_value_0_0= 'Boolean'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleprimitiveTypeCS4710); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2624:6: ( (lv_value_1_0= 'Integer' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2624:6: ( (lv_value_1_0= 'Integer' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2625:1: (lv_value_1_0= 'Integer' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2625:1: (lv_value_1_0= 'Integer' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2626:3: lv_value_1_0= 'Integer'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleprimitiveTypeCS4747); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2646:6: ( (lv_value_2_0= 'Real' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2646:6: ( (lv_value_2_0= 'Real' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2647:1: (lv_value_2_0= 'Real' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2647:1: (lv_value_2_0= 'Real' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2648:3: lv_value_2_0= 'Real'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,42,FOLLOW_42_in_ruleprimitiveTypeCS4784); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2668:6: ( (lv_value_3_0= 'String' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2668:6: ( (lv_value_3_0= 'String' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2669:1: (lv_value_3_0= 'String' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2669:1: (lv_value_3_0= 'String' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2670:3: lv_value_3_0= 'String'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,43,FOLLOW_43_in_ruleprimitiveTypeCS4821); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2690:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2690:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2691:1: (lv_value_4_0= 'UnlimitedNatural' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2691:1: (lv_value_4_0= 'UnlimitedNatural' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2692:3: lv_value_4_0= 'UnlimitedNatural'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_ruleprimitiveTypeCS4858); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2712:6: ( (lv_value_5_0= 'OclAny' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2712:6: ( (lv_value_5_0= 'OclAny' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2713:1: (lv_value_5_0= 'OclAny' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2713:1: (lv_value_5_0= 'OclAny' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2714:3: lv_value_5_0= 'OclAny'
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleprimitiveTypeCS4895); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2734:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2734:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2735:1: (lv_value_6_0= 'OclInvalid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2735:1: (lv_value_6_0= 'OclInvalid' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2736:3: lv_value_6_0= 'OclInvalid'
                    {
                    lv_value_6_0=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_ruleprimitiveTypeCS4932); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2756:6: ( (lv_value_7_0= 'OclVoid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2756:6: ( (lv_value_7_0= 'OclVoid' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2757:1: (lv_value_7_0= 'OclVoid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2757:1: (lv_value_7_0= 'OclVoid' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2758:3: lv_value_7_0= 'OclVoid'
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleprimitiveTypeCS4969); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2785:1: entryRuleCollectionTypeIdentifierCS returns [EObject current=null] : iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF ;
    public final EObject entryRuleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeIdentifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2786:2: (iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2787:2: iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeIdentifierCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS5018);
            iv_ruleCollectionTypeIdentifierCS=ruleCollectionTypeIdentifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifierCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS5028); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2794:1: ruleCollectionTypeIdentifierCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) ;
    public final EObject ruleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_value_3_0=null;
        Token lv_value_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2799:6: ( ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2800:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2800:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt44=1;
                }
                break;
            case 49:
                {
                alt44=2;
                }
                break;
            case 50:
                {
                alt44=3;
                }
                break;
            case 51:
                {
                alt44=4;
                }
                break;
            case 52:
                {
                alt44=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2800:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2800:2: ( (lv_value_0_0= 'Set' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2800:2: ( (lv_value_0_0= 'Set' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2801:1: (lv_value_0_0= 'Set' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2801:1: (lv_value_0_0= 'Set' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2802:3: lv_value_0_0= 'Set'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_ruleCollectionTypeIdentifierCS5071); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2822:6: ( (lv_value_1_0= 'Bag' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2822:6: ( (lv_value_1_0= 'Bag' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2823:1: (lv_value_1_0= 'Bag' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2823:1: (lv_value_1_0= 'Bag' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2824:3: lv_value_1_0= 'Bag'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_ruleCollectionTypeIdentifierCS5108); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2844:6: ( (lv_value_2_0= 'Sequence' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2844:6: ( (lv_value_2_0= 'Sequence' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2845:1: (lv_value_2_0= 'Sequence' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2845:1: (lv_value_2_0= 'Sequence' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2846:3: lv_value_2_0= 'Sequence'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleCollectionTypeIdentifierCS5145); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2866:6: ( (lv_value_3_0= 'Collection' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2866:6: ( (lv_value_3_0= 'Collection' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2867:1: (lv_value_3_0= 'Collection' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2867:1: (lv_value_3_0= 'Collection' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2868:3: lv_value_3_0= 'Collection'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,51,FOLLOW_51_in_ruleCollectionTypeIdentifierCS5182); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2888:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2888:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2889:1: (lv_value_4_0= 'OrderedSet' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2889:1: (lv_value_4_0= 'OrderedSet' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2890:3: lv_value_4_0= 'OrderedSet'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,52,FOLLOW_52_in_ruleCollectionTypeIdentifierCS5219); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2917:1: entryRuletypeCS returns [EObject current=null] : iv_ruletypeCS= ruletypeCS EOF ;
    public final EObject entryRuletypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2918:2: (iv_ruletypeCS= ruletypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2919:2: iv_ruletypeCS= ruletypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletypeCS_in_entryRuletypeCS5268);
            iv_ruletypeCS=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletypeCS5278); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2926:1: ruletypeCS returns [EObject current=null] : (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) ;
    public final EObject ruletypeCS() throws RecognitionException {
        EObject current = null;

        EObject this_primitiveTypeCS_0 = null;

        EObject this_pathNameCS_1 = null;

        EObject this_collectionTypeCS_2 = null;

        EObject this_tupleTypeCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2931:6: ( (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2932:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2932:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt45=1;
                }
                break;
            case RULE_ID:
                {
                alt45=2;
                }
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt45=3;
                }
                break;
            case 37:
                {
                alt45=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2932:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2933:2: this_primitiveTypeCS_0= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPrimitiveTypeCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS5328);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2946:2: this_pathNameCS_1= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPathNameCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruletypeCS5358);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2959:2: this_collectionTypeCS_2= rulecollectionTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getCollectionTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecollectionTypeCS_in_ruletypeCS5388);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2972:2: this_tupleTypeCS_3= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getTupleTypeCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruletypeCS5418);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2991:1: entryRulecollectionTypeCS returns [EObject current=null] : iv_rulecollectionTypeCS= rulecollectionTypeCS EOF ;
    public final EObject entryRulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecollectionTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2992:2: (iv_rulecollectionTypeCS= rulecollectionTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:2993:2: iv_rulecollectionTypeCS= rulecollectionTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS5453);
            iv_rulecollectionTypeCS=rulecollectionTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecollectionTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecollectionTypeCS5463); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3000:1: rulecollectionTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? ) ;
    public final EObject rulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;

        EObject lv_typeCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3005:6: ( ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3006:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3006:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3006:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3006:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3007:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3007:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3008:3: lv_value_0_0= ruleCollectionTypeIdentifierCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getValueCollectionTypeIdentifierCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS5509);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:2: ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==22) ) {
                int LA46_1 = input.LA(2);

                if ( (synpred67()) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:4: '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')'
                    {
                    match(input,22,FOLLOW_22_in_rulecollectionTypeCS5520); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3034:1: ( (lv_typeCS_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3035:1: (lv_typeCS_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3035:1: (lv_typeCS_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3036:3: lv_typeCS_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_rulecollectionTypeCS5541);
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

                    match(input,24,FOLLOW_24_in_rulecollectionTypeCS5551); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2(), null); 
                          
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
    // $ANTLR end rulecollectionTypeCS


    // $ANTLR start entryRuletupleTypeCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3070:1: entryRuletupleTypeCS returns [EObject current=null] : iv_ruletupleTypeCS= ruletupleTypeCS EOF ;
    public final EObject entryRuletupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3071:2: (iv_ruletupleTypeCS= ruletupleTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3072:2: iv_ruletupleTypeCS= ruletupleTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS5589);
            iv_ruletupleTypeCS=ruletupleTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleTypeCS5599); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3079:1: ruletupleTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) ;
    public final EObject ruletupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_part_2_0 = null;

        EObject lv_part_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3084:6: ( ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3085:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3085:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3085:2: ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3085:2: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3086:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3086:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3087:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_ruletupleTypeCS5642); if (failed) return current;
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

            match(input,22,FOLLOW_22_in_ruletupleTypeCS5665); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3110:1: ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3110:2: ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3110:2: ( (lv_part_2_0= ruletuplePartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3111:1: (lv_part_2_0= ruletuplePartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3111:1: (lv_part_2_0= ruletuplePartCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3112:3: lv_part_2_0= ruletuplePartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5687);
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3134:2: ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==23) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3134:4: ',' ( (lv_part_4_0= ruletuplePartCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruletupleTypeCS5698); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_2_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3138:1: ( (lv_part_4_0= ruletuplePartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3139:1: (lv_part_4_0= ruletuplePartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3139:1: (lv_part_4_0= ruletuplePartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3140:3: lv_part_4_0= ruletuplePartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5719);
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
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_ruletupleTypeCS5733); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3174:1: entryRuletuplePartCS returns [EObject current=null] : iv_ruletuplePartCS= ruletuplePartCS EOF ;
    public final EObject entryRuletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3175:2: (iv_ruletuplePartCS= ruletuplePartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3176:2: iv_ruletuplePartCS= ruletuplePartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTuplePartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS5769);
            iv_ruletuplePartCS=ruletuplePartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletuplePartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletuplePartCS5779); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3183:1: ruletuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) ;
    public final EObject ruletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3188:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3189:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3189:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3189:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3189:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3190:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3190:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3191:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruletuplePartCS5825);
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

            match(input,16,FOLLOW_16_in_ruletuplePartCS5835); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTuplePartCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3217:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3218:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3218:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3219:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruletuplePartCS5856);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3249:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3250:2: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3251:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS5892);
            iv_ruleLiteralExpCS=ruleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpCS5902); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3258:1: ruleLiteralExpCS returns [EObject current=null] : (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) ;
    public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionLiteralExpCS_0 = null;

        EObject this_TupleLiteralExpCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;

        EObject this_TypeLiteralExpCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3263:6: ( (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3264:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3264:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            int alt49=4;
            switch ( input.LA(1) ) {
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt49=1;
                }
                break;
            case 37:
                {
                int LA49_6 = input.LA(2);

                if ( (synpred71()) ) {
                    alt49=2;
                }
                else if ( (true) ) {
                    alt49=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3264:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 49, 6, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING_LITERAL:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
                {
                alt49=3;
                }
                break;
            case RULE_ID:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt49=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3264:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3265:2: this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS5952);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3278:2: this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTupleLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS5982);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3291:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS6012);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3304:2: this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTypeLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS6042);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3323:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3324:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3325:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6077);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6087); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3332:1: ruleCollectionLiteralExpCS returns [EObject current=null] : (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_collectionTypeCS_0 = null;

        EObject lv_collectionLiteralParts_2_0 = null;

        EObject lv_collectionLiteralParts_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3337:6: ( (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3338:1: (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3338:1: (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3339:2: this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS6137);
            this_collectionTypeCS_0=rulecollectionTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_collectionTypeCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3350:1: ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==53) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3350:3: '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}'
                    {
                    match(input,53,FOLLOW_53_in_ruleCollectionLiteralExpCS6147); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3354:1: ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING_LITERAL)||LA51_0==22||(LA51_0>=36 && LA51_0<=38)||(LA51_0>=40 && LA51_0<=52)||(LA51_0>=56 && LA51_0<=60)||LA51_0==71||LA51_0==77||LA51_0==81) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3354:2: ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3354:2: ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3355:1: (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3355:1: (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3356:3: lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6169);
                            lv_collectionLiteralParts_2_0=ruleCollectionLiteralPartCS();
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
                              	        		lv_collectionLiteralParts_2_0, 
                              	        		"CollectionLiteralPartCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3378:2: ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==23) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3378:4: ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) )
                            	    {
                            	    match(input,23,FOLLOW_23_in_ruleCollectionLiteralExpCS6180); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3382:1: ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3383:1: (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3383:1: (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3384:3: lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6201);
                            	    lv_collectionLiteralParts_4_0=ruleCollectionLiteralPartCS();
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
                            	      	        		lv_collectionLiteralParts_4_0, 
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
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,54,FOLLOW_54_in_ruleCollectionLiteralExpCS6215); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_1_2(), null); 
                          
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
    // $ANTLR end ruleCollectionLiteralExpCS


    // $ANTLR start entryRuleCollectionLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3418:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3419:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3420:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6253);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6263); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3427:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3432:6: ( ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3433:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3433:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3433:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3433:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3434:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3434:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3435:3: lv_expressionCS_0_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSOclExpressionCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6309);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3457:2: ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==55) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3457:4: '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    {
                    match(input,55,FOLLOW_55_in_ruleCollectionLiteralPartCS6320); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3461:1: ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3462:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3462:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3463:3: lv_lastExpressionCS_2_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSOclExpressionCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6341);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3493:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3494:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3495:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6379);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6389); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3502:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) ;
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
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3507:6: ( (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            int alt54=7;
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
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 35:
                case 36:
                case 54:
                case 55:
                case 58:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 72:
                case 74:
                case 75:
                case 76:
                case 78:
                case 79:
                case 80:
                case 82:
                    {
                    alt54=1;
                    }
                    break;
                case 11:
                    {
                    int LA54_8 = input.LA(3);

                    if ( (LA54_8==RULE_INT) ) {
                        int LA54_10 = input.LA(4);

                        if ( (synpred77()) ) {
                            alt54=1;
                        }
                        else if ( (synpred78()) ) {
                            alt54=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 54, 10, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA54_8==RULE_ID||LA54_8==RULE_STRING_LITERAL||LA54_8==22||(LA54_8>=37 && LA54_8<=38)||(LA54_8>=40 && LA54_8<=52)||(LA54_8>=56 && LA54_8<=60)||LA54_8==77) ) {
                        alt54=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 54, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case 33:
                case 34:
                    {
                    alt54=2;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 54, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt54=3;
                }
                break;
            case 56:
            case 57:
                {
                alt54=4;
                }
                break;
            case 58:
                {
                alt54=5;
                }
                break;
            case 59:
                {
                alt54=6;
                }
                break;
            case 60:
                {
                alt54=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3508:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3509:2: this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getIntegerLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS6439);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3522:2: this_RealLiteralExpCS_1= ruleRealLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getRealLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS6469);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3535:2: this_StringLiteralExpCS_2= ruleStringLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6499);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3548:2: this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6529);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3561:2: this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6559);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3574:2: this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6589);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3587:2: this_NullLiteralExpCS_6= ruleNullLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6619);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3606:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3607:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3608:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6654);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6664); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3615:1: ruleTupleLiteralExpCS returns [EObject current=null] : ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_part_3_0 = null;

        EObject lv_part_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3620:6: ( ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3621:1: ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3621:1: ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3621:2: () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3621:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3622:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getTupleLiteralExpCSAccess().getTupleLiteralExpCSAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getTupleLiteralExpCSAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,37,FOLLOW_37_in_ruleTupleLiteralExpCS6711); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3639:1: ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3639:3: '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}'
                    {
                    match(input,53,FOLLOW_53_in_ruleTupleLiteralExpCS6722); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3643:1: ( (lv_part_3_0= ruleTupleLiteralPartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3644:1: (lv_part_3_0= ruleTupleLiteralPartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3644:1: (lv_part_3_0= ruleTupleLiteralPartCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3645:3: lv_part_3_0= ruleTupleLiteralPartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6743);
                    lv_part_3_0=ruleTupleLiteralPartCS();
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
                      	        		lv_part_3_0, 
                      	        		"TupleLiteralPartCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3667:2: ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==23) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3667:4: ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleTupleLiteralExpCS6754); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3671:1: ( (lv_part_5_0= ruleTupleLiteralPartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3672:1: (lv_part_5_0= ruleTupleLiteralPartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3672:1: (lv_part_5_0= ruleTupleLiteralPartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3673:3: lv_part_5_0= ruleTupleLiteralPartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6775);
                    	    lv_part_5_0=ruleTupleLiteralPartCS();
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
                    	      	        		lv_part_5_0, 
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
                    	    break loop55;
                        }
                    } while (true);

                    match(input,54,FOLLOW_54_in_ruleTupleLiteralExpCS6787); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_2_3(), null); 
                          
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
    // $ANTLR end ruleTupleLiteralExpCS


    // $ANTLR start entryRuleTupleLiteralPartCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3707:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3708:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3709:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6825);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6835); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3716:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3721:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3722:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3722:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3722:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3722:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3723:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3723:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3724:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS6881);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3746:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==16) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3746:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleTupleLiteralPartCS6892); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3750:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3751:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3751:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3752:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS6913);
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

            match(input,25,FOLLOW_25_in_ruleTupleLiteralPartCS6925); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3778:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3779:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3779:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3780:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS6946);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3810:1: entryRuleIntegerLiteralExpCS returns [EObject current=null] : iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF ;
    public final EObject entryRuleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3811:2: (iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3812:2: iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntegerLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS6982);
            iv_ruleIntegerLiteralExpCS=ruleIntegerLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntegerLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS6992); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3819:1: ruleIntegerLiteralExpCS returns [EObject current=null] : ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) ;
    public final EObject ruleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_integerSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3824:6: ( ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3825:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3825:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3826:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3826:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3827:3: lv_integerSymbol_0_0= ruleINTEGER_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolINTEGER_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS7037);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3857:1: entryRuleRealLiteralExpCS returns [EObject current=null] : iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF ;
    public final EObject entryRuleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3858:2: (iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3859:2: iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRealLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS7072);
            iv_ruleRealLiteralExpCS=ruleRealLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRealLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralExpCS7082); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3866:1: ruleRealLiteralExpCS returns [EObject current=null] : ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) ;
    public final EObject ruleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_realSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3871:6: ( ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3872:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3872:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3873:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3873:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3874:3: lv_realSymbol_0_0= ruleREAL_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRealLiteralExpCSAccess().getRealSymbolREAL_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS7127);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3904:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3905:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3906:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7162);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralExpCS7172); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3913:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringSymbol_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3918:6: ( ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3919:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3919:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_STRING_LITERAL) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3920:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3920:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3921:3: lv_stringSymbol_0_0= RULE_STRING_LITERAL
            	    {
            	    lv_stringSymbol_0_0=(Token)input.LT(1);
            	    match(input,RULE_STRING_LITERAL,FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS7213); if (failed) return current;
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
            	    if ( cnt58 >= 1 ) break loop58;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3951:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3952:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3953:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7254);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7264); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3960:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3965:6: ( ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3966:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3966:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==56) ) {
                alt59=1;
            }
            else if ( (LA59_0==57) ) {
                alt59=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3966:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3966:2: ( (lv_value_0_0= 'true' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3966:2: ( (lv_value_0_0= 'true' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3967:1: (lv_value_0_0= 'true' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3967:1: (lv_value_0_0= 'true' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3968:3: lv_value_0_0= 'true'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleBooleanLiteralExpCS7307); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3988:6: ( (lv_value_1_0= 'false' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3988:6: ( (lv_value_1_0= 'false' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3989:1: (lv_value_1_0= 'false' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3989:1: (lv_value_1_0= 'false' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3990:3: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,57,FOLLOW_57_in_ruleBooleanLiteralExpCS7344); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4017:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4018:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4019:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7393);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7403); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4026:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4031:6: ( ( () '*' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:1: ( () '*' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:1: ( () '*' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:2: () '*'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4032:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4033:2: 
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

            match(input,58,FOLLOW_58_in_ruleUnlimitedNaturalLiteralExpCS7450); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4058:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4059:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4060:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInvalidLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7486);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7496); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4067:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4072:6: ( ( () 'invalid' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:1: ( () 'invalid' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:1: ( () 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:2: () 'invalid'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4073:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4074:2: 
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

            match(input,59,FOLLOW_59_in_ruleInvalidLiteralExpCS7543); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4099:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4100:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4101:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7579);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralExpCS7589); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4108:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4113:6: ( ( () 'null' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4114:1: ( () 'null' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4114:1: ( () 'null' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4114:2: () 'null'
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4114:2: ()
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4115:2: 
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

            match(input,60,FOLLOW_60_in_ruleNullLiteralExpCS7636); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4140:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4141:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4142:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7672);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7682); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4149:1: ruleTypeLiteralExpCS returns [EObject current=null] : (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_pathNameCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_tupleTypeCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4154:6: ( (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4155:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4155:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )
            int alt60=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt60=1;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt60=2;
                }
                break;
            case 37:
                {
                alt60=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4155:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4156:2: this_pathNameCS_0= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPathNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS7732);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4169:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS7762);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4182:2: this_tupleTypeCS_2= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getTupleTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS7792);
                    this_tupleTypeCS_2=ruletupleTypeCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_tupleTypeCS_2; 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4201:1: entryRuleOclExpressionCS returns [EObject current=null] : iv_ruleOclExpressionCS= ruleOclExpressionCS EOF ;
    public final EObject entryRuleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclExpressionCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4202:2: (iv_ruleOclExpressionCS= ruleOclExpressionCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4203:2: iv_ruleOclExpressionCS= ruleOclExpressionCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclExpressionCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS7827);
            iv_ruleOclExpressionCS=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclExpressionCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclExpressionCS7837); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4210:1: ruleOclExpressionCS returns [EObject current=null] : (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) ;
    public final EObject ruleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject this_impliesCS_0 = null;

        EObject this_LetExpCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4215:6: ( (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4216:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4216:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=RULE_ID && LA61_0<=RULE_STRING_LITERAL)||LA61_0==22||(LA61_0>=36 && LA61_0<=38)||(LA61_0>=40 && LA61_0<=52)||(LA61_0>=56 && LA61_0<=60)||LA61_0==71||LA61_0==77) ) {
                alt61=1;
            }
            else if ( (LA61_0==81) ) {
                alt61=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4216:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4217:2: this_impliesCS_0= ruleimpliesCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getImpliesCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS7887);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4230:2: this_LetExpCS_1= ruleLetExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getLetExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS7917);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4249:1: entryRuleimpliesCS returns [EObject current=null] : iv_ruleimpliesCS= ruleimpliesCS EOF ;
    public final EObject entryRuleimpliesCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimpliesCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4250:2: (iv_ruleimpliesCS= ruleimpliesCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4251:2: iv_ruleimpliesCS= ruleimpliesCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImpliesCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS7952);
            iv_ruleimpliesCS=ruleimpliesCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleimpliesCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleimpliesCS7962); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4258:1: ruleimpliesCS returns [EObject current=null] : (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleimpliesCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_xorCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4263:6: ( (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4264:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4264:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4265:2: this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getXorCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulexorCS_in_ruleimpliesCS8012);
            this_xorCS_0=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_xorCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:1: ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==61) ) {
                int LA63_1 = input.LA(2);

                if ( (synpred92()) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:2: () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4277:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getImpliesCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getImpliesCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4295:2: ( (lv_op_2_0= 'implies' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4296:1: (lv_op_2_0= 'implies' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4296:1: (lv_op_2_0= 'implies' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4297:3: lv_op_2_0= 'implies'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,61,FOLLOW_61_in_ruleimpliesCS8042); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4316:2: ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4317:1: ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4317:1: ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( ((LA62_0>=RULE_ID && LA62_0<=RULE_STRING_LITERAL)||LA62_0==22||(LA62_0>=36 && LA62_0<=38)||(LA62_0>=40 && LA62_0<=52)||(LA62_0>=56 && LA62_0<=60)||LA62_0==71||LA62_0==77) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==81) ) {
                        alt62=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4318:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4319:3: lv_argument_3_1= ruleimpliesCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentImpliesCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleimpliesCS_in_ruleimpliesCS8078);
                            lv_argument_3_1=ruleimpliesCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4340:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleimpliesCS8097);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4372:1: entryRulexorCS returns [EObject current=null] : iv_rulexorCS= rulexorCS EOF ;
    public final EObject entryRulexorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulexorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4373:2: (iv_rulexorCS= rulexorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4374:2: iv_rulexorCS= rulexorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulexorCS_in_entryRulexorCS8138);
            iv_rulexorCS=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulexorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulexorCS8148); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4381:1: rulexorCS returns [EObject current=null] : (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulexorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_orCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4386:6: ( (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4387:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4387:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4388:2: this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getOrCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleorCS_in_rulexorCS8198);
            this_orCS_0=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_orCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:1: ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==62) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred94()) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:2: () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4400:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getXorCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getXorCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4418:2: ( (lv_op_2_0= 'xor' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4419:1: (lv_op_2_0= 'xor' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4419:1: (lv_op_2_0= 'xor' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4420:3: lv_op_2_0= 'xor'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,62,FOLLOW_62_in_rulexorCS8228); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4439:2: ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4440:1: ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4440:1: ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( ((LA64_0>=RULE_ID && LA64_0<=RULE_STRING_LITERAL)||LA64_0==22||(LA64_0>=36 && LA64_0<=38)||(LA64_0>=40 && LA64_0<=52)||(LA64_0>=56 && LA64_0<=60)||LA64_0==71||LA64_0==77) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==81) ) {
                        alt64=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4441:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4442:3: lv_argument_3_1= rulexorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentXorCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulexorCS_in_rulexorCS8264);
                            lv_argument_3_1=rulexorCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4463:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulexorCS8283);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4495:1: entryRuleorCS returns [EObject current=null] : iv_ruleorCS= ruleorCS EOF ;
    public final EObject entryRuleorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4496:2: (iv_ruleorCS= ruleorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4497:2: iv_ruleorCS= ruleorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleorCS_in_entryRuleorCS8324);
            iv_ruleorCS=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleorCS8334); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4504:1: ruleorCS returns [EObject current=null] : (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_andCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4509:6: ( (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4510:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4510:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4511:2: this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getAndCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleandCS_in_ruleorCS8384);
            this_andCS_0=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_andCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:1: ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==63) ) {
                int LA67_1 = input.LA(2);

                if ( (synpred96()) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:2: () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4523:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getOrCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getOrCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4541:2: ( (lv_op_2_0= 'or' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4542:1: (lv_op_2_0= 'or' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4542:1: (lv_op_2_0= 'or' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4543:3: lv_op_2_0= 'or'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,63,FOLLOW_63_in_ruleorCS8414); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4562:2: ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4563:1: ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4563:1: ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( ((LA66_0>=RULE_ID && LA66_0<=RULE_STRING_LITERAL)||LA66_0==22||(LA66_0>=36 && LA66_0<=38)||(LA66_0>=40 && LA66_0<=52)||(LA66_0>=56 && LA66_0<=60)||LA66_0==71||LA66_0==77) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==81) ) {
                        alt66=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4564:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )", 66, 0, input);

                        throw nvae;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4565:3: lv_argument_3_1= ruleorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentOrCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleorCS_in_ruleorCS8450);
                            lv_argument_3_1=ruleorCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4586:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleorCS8469);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4618:1: entryRuleandCS returns [EObject current=null] : iv_ruleandCS= ruleandCS EOF ;
    public final EObject entryRuleandCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleandCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4619:2: (iv_ruleandCS= ruleandCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4620:2: iv_ruleandCS= ruleandCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleandCS_in_entryRuleandCS8510);
            iv_ruleandCS=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleandCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleandCS8520); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4627:1: ruleandCS returns [EObject current=null] : (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleandCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_equalityCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4632:6: ( (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4633:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4633:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4634:2: this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getEqualityCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleequalityCS_in_ruleandCS8570);
            this_equalityCS_0=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_equalityCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:1: ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==64) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred98()) ) {
                    alt69=1;
                }
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:2: () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4646:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAndCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAndCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4664:2: ( (lv_op_2_0= 'and' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4665:1: (lv_op_2_0= 'and' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4665:1: (lv_op_2_0= 'and' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4666:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,64,FOLLOW_64_in_ruleandCS8600); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4685:2: ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4686:1: ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4686:1: ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_STRING_LITERAL)||LA68_0==22||(LA68_0>=36 && LA68_0<=38)||(LA68_0>=40 && LA68_0<=52)||(LA68_0>=56 && LA68_0<=60)||LA68_0==71||LA68_0==77) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==81) ) {
                        alt68=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4687:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4688:3: lv_argument_3_1= ruleandCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentAndCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleandCS_in_ruleandCS8636);
                            lv_argument_3_1=ruleandCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4709:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleandCS8655);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4741:1: entryRuleequalityCS returns [EObject current=null] : iv_ruleequalityCS= ruleequalityCS EOF ;
    public final EObject entryRuleequalityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4742:2: (iv_ruleequalityCS= ruleequalityCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4743:2: iv_ruleequalityCS= ruleequalityCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEqualityCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleequalityCS_in_entryRuleequalityCS8696);
            iv_ruleequalityCS=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleequalityCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityCS8706); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4750:1: ruleequalityCS returns [EObject current=null] : (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleequalityCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_relationalCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4755:6: ( (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4756:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4756:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4757:2: this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRelationalCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulerelationalCS_in_ruleequalityCS8756);
            this_relationalCS_0=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_relationalCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:1: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==25) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred101()) ) {
                    alt72=1;
                }
            }
            else if ( (LA72_0==65) ) {
                int LA72_2 = input.LA(2);

                if ( (synpred101()) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:2: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4769:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getEqualityCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getEqualityCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4787:2: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4788:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4788:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4789:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4789:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==25) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==65) ) {
                        alt70=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4789:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )", 70, 0, input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4790:3: lv_op_2_1= '='
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,25,FOLLOW_25_in_ruleequalityCS8788); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4808:8: lv_op_2_2= '<>'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,65,FOLLOW_65_in_ruleequalityCS8817); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4829:2: ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4830:1: ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4830:1: ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_STRING_LITERAL)||LA71_0==22||(LA71_0>=36 && LA71_0<=38)||(LA71_0>=40 && LA71_0<=52)||(LA71_0>=56 && LA71_0<=60)||LA71_0==71||LA71_0==77) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==81) ) {
                        alt71=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4831:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4832:3: lv_argument_3_1= ruleequalityCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentEqualityCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleequalityCS_in_ruleequalityCS8856);
                            lv_argument_3_1=ruleequalityCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4853:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleequalityCS8875);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4885:1: entryRulerelationalCS returns [EObject current=null] : iv_rulerelationalCS= rulerelationalCS EOF ;
    public final EObject entryRulerelationalCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4886:2: (iv_rulerelationalCS= rulerelationalCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4887:2: iv_rulerelationalCS= rulerelationalCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerelationalCS_in_entryRulerelationalCS8916);
            iv_rulerelationalCS=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerelationalCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalCS8926); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4894:1: rulerelationalCS returns [EObject current=null] : (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulerelationalCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_additiveCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4899:6: ( (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4900:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4900:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4901:2: this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getAdditiveCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_rulerelationalCS8976);
            this_additiveCS_0=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_additiveCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:1: ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt75=2;
            switch ( input.LA(1) ) {
                case 66:
                    {
                    int LA75_1 = input.LA(2);

                    if ( (synpred106()) ) {
                        alt75=1;
                    }
                    }
                    break;
                case 67:
                    {
                    int LA75_2 = input.LA(2);

                    if ( (synpred106()) ) {
                        alt75=1;
                    }
                    }
                    break;
                case 68:
                    {
                    int LA75_3 = input.LA(2);

                    if ( (synpred106()) ) {
                        alt75=1;
                    }
                    }
                    break;
                case 69:
                    {
                    int LA75_4 = input.LA(2);

                    if ( (synpred106()) ) {
                        alt75=1;
                    }
                    }
                    break;
            }

            switch (alt75) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:2: () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4913:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getRelationalCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4931:2: ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4932:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4932:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4933:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4933:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    int alt73=4;
                    switch ( input.LA(1) ) {
                    case 66:
                        {
                        alt73=1;
                        }
                        break;
                    case 67:
                        {
                        alt73=2;
                        }
                        break;
                    case 68:
                        {
                        alt73=3;
                        }
                        break;
                    case 69:
                        {
                        alt73=4;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("4933:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )", 73, 0, input);

                        throw nvae;
                    }

                    switch (alt73) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4934:3: lv_op_2_1= '>'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,66,FOLLOW_66_in_rulerelationalCS9008); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4952:8: lv_op_2_2= '<'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,67,FOLLOW_67_in_rulerelationalCS9037); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4970:8: lv_op_2_3= '>='
                            {
                            lv_op_2_3=(Token)input.LT(1);
                            match(input,68,FOLLOW_68_in_rulerelationalCS9066); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4988:8: lv_op_2_4= '<='
                            {
                            lv_op_2_4=(Token)input.LT(1);
                            match(input,69,FOLLOW_69_in_rulerelationalCS9095); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5009:2: ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5010:1: ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5010:1: ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_STRING_LITERAL)||LA74_0==22||(LA74_0>=36 && LA74_0<=38)||(LA74_0>=40 && LA74_0<=52)||(LA74_0>=56 && LA74_0<=60)||LA74_0==71||LA74_0==77) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==81) ) {
                        alt74=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5011:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5012:3: lv_argument_3_1= rulerelationalCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentRelationalCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulerelationalCS_in_rulerelationalCS9134);
                            lv_argument_3_1=rulerelationalCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5033:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulerelationalCS9153);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5065:1: entryRuleadditiveCS returns [EObject current=null] : iv_ruleadditiveCS= ruleadditiveCS EOF ;
    public final EObject entryRuleadditiveCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5066:2: (iv_ruleadditiveCS= ruleadditiveCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5067:2: iv_ruleadditiveCS= ruleadditiveCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS9194);
            iv_ruleadditiveCS=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleadditiveCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveCS9204); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5074:1: ruleadditiveCS returns [EObject current=null] : (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleadditiveCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_multiplicativeCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5079:6: ( (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5080:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5080:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5081:2: this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getMultiplicativeCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS9254);
            this_multiplicativeCS_0=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_multiplicativeCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:1: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==35) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred109()) ) {
                    alt78=1;
                }
            }
            else if ( (LA78_0==36) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred109()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:2: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5093:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5111:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5112:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5112:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5113:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5113:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==35) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==36) ) {
                        alt76=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5113:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )", 76, 0, input);

                        throw nvae;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5114:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleadditiveCS9286); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5132:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,36,FOLLOW_36_in_ruleadditiveCS9315); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5153:2: ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5154:1: ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5154:1: ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( ((LA77_0>=RULE_ID && LA77_0<=RULE_STRING_LITERAL)||LA77_0==22||(LA77_0>=36 && LA77_0<=38)||(LA77_0>=40 && LA77_0<=52)||(LA77_0>=56 && LA77_0<=60)||LA77_0==71||LA77_0==77) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==81) ) {
                        alt77=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5155:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5156:3: lv_argument_3_1= ruleadditiveCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentAdditiveCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleadditiveCS_in_ruleadditiveCS9354);
                            lv_argument_3_1=ruleadditiveCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5177:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleadditiveCS9373);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5209:1: entryRulemultiplicativeCS returns [EObject current=null] : iv_rulemultiplicativeCS= rulemultiplicativeCS EOF ;
    public final EObject entryRulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5210:2: (iv_rulemultiplicativeCS= rulemultiplicativeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5211:2: iv_rulemultiplicativeCS= rulemultiplicativeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS9414);
            iv_rulemultiplicativeCS=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulemultiplicativeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeCS9424); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5218:1: rulemultiplicativeCS returns [EObject current=null] : (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_unaryCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5223:6: ( (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5224:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5224:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5225:2: this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getUnaryCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleunaryCS_in_rulemultiplicativeCS9474);
            this_unaryCS_0=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_unaryCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5236:1: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==58||LA81_0==70) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5236:2: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5236:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5237:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5255:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5256:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5256:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5257:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5257:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==58) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==70) ) {
                        alt79=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5257:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )", 79, 0, input);

                        throw nvae;
                    }
                    switch (alt79) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5258:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,58,FOLLOW_58_in_rulemultiplicativeCS9506); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5276:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,70,FOLLOW_70_in_rulemultiplicativeCS9535); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5297:2: ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5298:1: ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5298:1: ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5299:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5299:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_STRING_LITERAL)||LA80_0==22||(LA80_0>=36 && LA80_0<=38)||(LA80_0>=40 && LA80_0<=52)||(LA80_0>=56 && LA80_0<=60)||LA80_0==71||LA80_0==77) ) {
                        alt80=1;
                    }
                    else if ( (LA80_0==81) ) {
                        alt80=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5299:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )", 80, 0, input);

                        throw nvae;
                    }
                    switch (alt80) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5300:3: lv_argument_3_1= rulemultiplicativeCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getArgumentMultiplicativeCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS9574);
                            lv_argument_3_1=rulemultiplicativeCS();
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
                              	       			"argument",
                              	        		lv_argument_3_1, 
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5321:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS9593);
                            lv_argument_3_2=ruleLetExpCS();
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
                              	       			"argument",
                              	        		lv_argument_3_2, 
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5353:1: entryRuleunaryCS returns [EObject current=null] : iv_ruleunaryCS= ruleunaryCS EOF ;
    public final EObject entryRuleunaryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5354:2: (iv_ruleunaryCS= ruleunaryCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5355:2: iv_ruleunaryCS= ruleunaryCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunaryCS_in_entryRuleunaryCS9634);
            iv_ruleunaryCS=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunaryCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryCS9644); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5362:1: ruleunaryCS returns [EObject current=null] : (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) ;
    public final EObject ruleunaryCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_callingExpCS_0 = null;

        EObject lv_source_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5367:6: ( (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5368:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5368:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_STRING_LITERAL)||LA83_0==22||(LA83_0>=37 && LA83_0<=38)||(LA83_0>=40 && LA83_0<=52)||(LA83_0>=56 && LA83_0<=60)||LA83_0==77) ) {
                alt83=1;
            }
            else if ( (LA83_0==36||LA83_0==71) ) {
                alt83=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("5368:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5369:2: this_callingExpCS_0= rulecallingExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getCallingExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecallingExpCS_in_ruleunaryCS9694);
                    this_callingExpCS_0=rulecallingExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_callingExpCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5381:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5381:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5381:7: () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5381:7: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5382:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5395:2: ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5396:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5396:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5397:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5397:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==36) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==71) ) {
                        alt82=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5397:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )", 82, 0, input);

                        throw nvae;
                    }
                    switch (alt82) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5398:3: lv_op_2_1= '-'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,36,FOLLOW_36_in_ruleunaryCS9732); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5416:8: lv_op_2_2= 'not'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,71,FOLLOW_71_in_ruleunaryCS9761); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5437:2: ( (lv_source_3_0= ruleunaryCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5438:1: (lv_source_3_0= ruleunaryCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5438:1: (lv_source_3_0= ruleunaryCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5439:3: lv_source_3_0= ruleunaryCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getSourceUnaryCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleunaryCS_in_ruleunaryCS9798);
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


    // $ANTLR start entryRulecallingExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5469:1: entryRulecallingExpCS returns [EObject current=null] : iv_rulecallingExpCS= rulecallingExpCS EOF ;
    public final EObject entryRulecallingExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecallingExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5470:2: (iv_rulecallingExpCS= rulecallingExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5471:2: iv_rulecallingExpCS= rulecallingExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCallingExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecallingExpCS_in_entryRulecallingExpCS9835);
            iv_rulecallingExpCS=rulecallingExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecallingExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecallingExpCS9845); if (failed) return current;

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
    // $ANTLR end entryRulecallingExpCS


    // $ANTLR start rulecallingExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5478:1: rulecallingExpCS returns [EObject current=null] : (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? ) ;
    public final EObject rulecallingExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_callExpCS_0 = null;

        EObject lv_argument_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5483:6: ( (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5484:1: (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5484:1: (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5485:2: this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCallingExpCSAccess().getCallExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulecallExpCS_in_rulecallingExpCS9895);
            this_callExpCS_0=rulecallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_callExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5496:1: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==11||LA85_0==72) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5496:2: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5496:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5497:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCallingExpCSAccess().getBinaryExpressionCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCallingExpCSAccess().getBinaryExpressionCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5515:2: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5516:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5516:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5517:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5517:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==11) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==72) ) {
                        alt84=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("5517:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )", 84, 0, input);

                        throw nvae;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5518:3: lv_op_2_1= '.'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_rulecallingExpCS9927); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallingExpCSAccess().getOpFullStopKeyword_1_1_0_0(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallingExpCSRule().getType().getClassifier());
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
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5536:8: lv_op_2_2= '->'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,72,FOLLOW_72_in_rulecallingExpCS9956); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallingExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1(), "op"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallingExpCSRule().getType().getClassifier());
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

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5557:2: ( (lv_argument_3_0= rulecallingExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5558:1: (lv_argument_3_0= rulecallingExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5558:1: (lv_argument_3_0= rulecallingExpCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5559:3: lv_argument_3_0= rulecallingExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCallingExpCSAccess().getArgumentCallingExpCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulecallingExpCS_in_rulecallingExpCS9993);
                    lv_argument_3_0=rulecallingExpCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getCallingExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"argument",
                      	        		lv_argument_3_0, 
                      	        		"callingExpCS", 
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
    // $ANTLR end rulecallingExpCS


    // $ANTLR start entryRuleiteratorVariableCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5589:1: entryRuleiteratorVariableCS returns [EObject current=null] : iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF ;
    public final EObject entryRuleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5590:2: (iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5591:2: iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS10031);
            iv_ruleiteratorVariableCS=ruleiteratorVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorVariableCS10041); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5598:1: ruleiteratorVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) ;
    public final EObject ruleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5603:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5604:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5604:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5604:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5604:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5605:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5605:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5606:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS10087);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5628:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==16) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5628:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleiteratorVariableCS10098); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIteratorVariableCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5632:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5633:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5633:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5634:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorVariableCS10119);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5664:1: entryRuleiteratorAccumulatorCS returns [EObject current=null] : iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF ;
    public final EObject entryRuleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorAccumulatorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5665:2: (iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5666:2: iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorAccumulatorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS10157);
            iv_ruleiteratorAccumulatorCS=ruleiteratorAccumulatorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorAccumulatorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS10167); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5673:1: ruleiteratorAccumulatorCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5678:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5679:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5679:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5679:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5679:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5680:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5680:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5681:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS10213);
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

            match(input,16,FOLLOW_16_in_ruleiteratorAccumulatorCS10223); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5707:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5708:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5708:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5709:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS10244);
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

            match(input,25,FOLLOW_25_in_ruleiteratorAccumulatorCS10254); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5735:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5736:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5736:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5737:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS10275);
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


    // $ANTLR start entryRulecallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5767:1: entryRulecallExpCS returns [EObject current=null] : iv_rulecallExpCS= rulecallExpCS EOF ;
    public final EObject entryRulecallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecallExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5768:2: (iv_rulecallExpCS= rulecallExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5769:2: iv_rulecallExpCS= rulecallExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCallExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecallExpCS_in_entryRulecallExpCS10311);
            iv_rulecallExpCS=rulecallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecallExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecallExpCS10321); if (failed) return current;

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
    // $ANTLR end entryRulecallExpCS


    // $ANTLR start rulecallExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5776:1: rulecallExpCS returns [EObject current=null] : (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? ) ;
    public final EObject rulecallExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_preExpCS_0 = null;

        EObject lv_variable1_3_0 = null;

        EObject lv_variable2_5_0 = null;

        EObject lv_variable2_7_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5781:6: ( (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5782:1: (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5782:1: (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5783:2: this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getPreExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulepreExpCS_in_rulecallExpCS10371);
            this_preExpCS_0=rulepreExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_preExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5794:1: ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==22) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5794:2: () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5794:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5795:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,22,FOLLOW_22_in_rulecallExpCS10393); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallExpCSAccess().getLeftParenthesisKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5817:1: ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==RULE_ID) ) {
                        int LA88_1 = input.LA(2);

                        if ( (LA88_1==16||(LA88_1>=73 && LA88_1<=74)) ) {
                            alt88=1;
                        }
                        else if ( (LA88_1==23) ) {
                            int LA88_4 = input.LA(3);

                            if ( (LA88_4==RULE_ID) ) {
                                int LA88_5 = input.LA(4);

                                if ( (LA88_5==16||LA88_5==74) ) {
                                    alt88=1;
                                }
                            }
                        }
                    }
                    switch (alt88) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5817:2: ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|'
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5817:2: ( (lv_variable1_3_0= ruleiteratorVariableCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5818:1: (lv_variable1_3_0= ruleiteratorVariableCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5818:1: (lv_variable1_3_0= ruleiteratorVariableCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5819:3: lv_variable1_3_0= ruleiteratorVariableCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable1IteratorVariableCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS10415);
                            lv_variable1_3_0=ruleiteratorVariableCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallExpCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"variable1",
                              	        		lv_variable1_3_0, 
                              	        		"iteratorVariableCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5841:2: ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )?
                            int alt87=3;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==23) ) {
                                alt87=1;
                            }
                            else if ( (LA87_0==73) ) {
                                alt87=2;
                            }
                            switch (alt87) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5841:3: ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5841:3: ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5841:5: ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) )
                                    {
                                    match(input,23,FOLLOW_23_in_rulecallExpCS10427); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallExpCSAccess().getCommaKeyword_1_2_1_0_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5845:1: ( (lv_variable2_5_0= ruleiteratorVariableCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5846:1: (lv_variable2_5_0= ruleiteratorVariableCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5846:1: (lv_variable2_5_0= ruleiteratorVariableCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5847:3: lv_variable2_5_0= ruleiteratorVariableCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable2IteratorVariableCSParserRuleCall_1_2_1_0_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS10448);
                                    lv_variable2_5_0=ruleiteratorVariableCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallExpCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"variable2",
                                      	        		lv_variable2_5_0, 
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
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5870:6: ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5870:6: ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5870:8: ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) )
                                    {
                                    match(input,73,FOLLOW_73_in_rulecallExpCS10466); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallExpCSAccess().getSemicolonKeyword_1_2_1_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5874:1: ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5875:1: (lv_variable2_7_0= ruleiteratorAccumulatorCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5875:1: (lv_variable2_7_0= ruleiteratorAccumulatorCS )
                                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5876:3: lv_variable2_7_0= ruleiteratorAccumulatorCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable2IteratorAccumulatorCSParserRuleCall_1_2_1_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_rulecallExpCS10487);
                                    lv_variable2_7_0=ruleiteratorAccumulatorCS();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getCallExpCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"variable2",
                                      	        		lv_variable2_7_0, 
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

                            match(input,74,FOLLOW_74_in_rulecallExpCS10500); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallExpCSAccess().getVerticalLineKeyword_1_2_2(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5902:3: ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( ((LA90_0>=RULE_ID && LA90_0<=RULE_STRING_LITERAL)||LA90_0==22||(LA90_0>=36 && LA90_0<=38)||(LA90_0>=40 && LA90_0<=52)||(LA90_0>=56 && LA90_0<=60)||LA90_0==71||LA90_0==77||LA90_0==81) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5902:4: ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )*
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5902:4: ( (lv_arguments_9_0= ruleOclExpressionCS ) )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5903:1: (lv_arguments_9_0= ruleOclExpressionCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5903:1: (lv_arguments_9_0= ruleOclExpressionCS )
                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5904:3: lv_arguments_9_0= ruleOclExpressionCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_3_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulecallExpCS10524);
                            lv_arguments_9_0=ruleOclExpressionCS();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getCallExpCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		add(
                              	       			current, 
                              	       			"arguments",
                              	        		lv_arguments_9_0, 
                              	        		"OclExpressionCS", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5926:2: ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )*
                            loop89:
                            do {
                                int alt89=2;
                                int LA89_0 = input.LA(1);

                                if ( (LA89_0==23) ) {
                                    alt89=1;
                                }


                                switch (alt89) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5926:4: ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) )
                            	    {
                            	    match(input,23,FOLLOW_23_in_rulecallExpCS10535); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getCallExpCSAccess().getCommaKeyword_1_3_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5930:1: ( (lv_arguments_11_0= ruleOclExpressionCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5931:1: (lv_arguments_11_0= ruleOclExpressionCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5931:1: (lv_arguments_11_0= ruleOclExpressionCS )
                            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5932:3: lv_arguments_11_0= ruleOclExpressionCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_3_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOclExpressionCS_in_rulecallExpCS10556);
                            	    lv_arguments_11_0=ruleOclExpressionCS();
                            	    _fsp--;
                            	    if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = factory.create(grammarAccess.getCallExpCSRule().getType().getClassifier());
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


                            	    }
                            	    break;

                            	default :
                            	    break loop89;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,24,FOLLOW_24_in_rulecallExpCS10570); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallExpCSAccess().getRightParenthesisKeyword_1_4(), null); 
                          
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
    // $ANTLR end rulecallExpCS


    // $ANTLR start entryRuleindexExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5966:1: entryRuleindexExpCS returns [EObject current=null] : iv_ruleindexExpCS= ruleindexExpCS EOF ;
    public final EObject entryRuleindexExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleindexExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5967:2: (iv_ruleindexExpCS= ruleindexExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5968:2: iv_ruleindexExpCS= ruleindexExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIndexExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleindexExpCS_in_entryRuleindexExpCS10608);
            iv_ruleindexExpCS=ruleindexExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleindexExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleindexExpCS10618); if (failed) return current;

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
    // $ANTLR end entryRuleindexExpCS


    // $ANTLR start ruleindexExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5975:1: ruleindexExpCS returns [EObject current=null] : (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? ) ;
    public final EObject ruleindexExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_messageExpCS_0 = null;

        EObject lv_indexes_3_0 = null;

        EObject lv_indexes_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5980:6: ( (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5981:1: (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5981:1: (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5982:2: this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getMessageExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulemessageExpCS_in_ruleindexExpCS10668);
            this_messageExpCS_0=rulemessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_messageExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5993:1: ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==75) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5993:2: () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']'
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5993:2: ()
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5994:2: 
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              temp=factory.create(grammarAccess.getIndexExpCSAccess().getIndexExpCSSourceAction_1_0().getType().getClassifier());
                              try {
                              	factory.set(temp, "source", current, null /*ParserRule*/, currentNode);
                              } catch(ValueConverterException vce) {
                              	handleValueConverterException(vce);
                              }
                              current = temp; 
                              temp = null;
                              CompositeNode newNode = createCompositeNode(grammarAccess.getIndexExpCSAccess().getIndexExpCSSourceAction_1_0(), currentNode.getParent());
                          newNode.getChildren().add(currentNode);
                          moveLookaheadInfo(currentNode, newNode);
                          currentNode = newNode; 
                              associateNodeWithAstElement(currentNode, current); 
                          
                    }

                    }

                    match(input,75,FOLLOW_75_in_ruleindexExpCS10690); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6016:1: ( (lv_indexes_3_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6017:1: (lv_indexes_3_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6017:1: (lv_indexes_3_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6018:3: lv_indexes_3_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getIndexesOclExpressionCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS10711);
                    lv_indexes_3_0=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getIndexExpCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"indexes",
                      	        		lv_indexes_3_0, 
                      	        		"OclExpressionCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6040:2: ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==23) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6040:4: ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) )
                    	    {
                    	    match(input,23,FOLLOW_23_in_ruleindexExpCS10722); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_3_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6044:1: ( (lv_indexes_5_0= ruleOclExpressionCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6045:1: (lv_indexes_5_0= ruleOclExpressionCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6045:1: (lv_indexes_5_0= ruleOclExpressionCS )
                    	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6046:3: lv_indexes_5_0= ruleOclExpressionCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS10743);
                    	    lv_indexes_5_0=ruleOclExpressionCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getIndexExpCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"indexes",
                    	      	        		lv_indexes_5_0, 
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
                    	    break loop92;
                        }
                    } while (true);

                    match(input,76,FOLLOW_76_in_ruleindexExpCS10755); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIndexExpCSAccess().getRightSquareBracketKeyword_1_4(), null); 
                          
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
    // $ANTLR end ruleindexExpCS


    // $ANTLR start entryRuleprimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6080:1: entryRuleprimaryExpCS returns [EObject current=null] : iv_ruleprimaryExpCS= ruleprimaryExpCS EOF ;
    public final EObject entryRuleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimaryExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6081:2: (iv_ruleprimaryExpCS= ruleprimaryExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6082:2: iv_ruleprimaryExpCS= ruleprimaryExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS10793);
            iv_ruleprimaryExpCS=ruleprimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimaryExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimaryExpCS10803); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6089:1: ruleprimaryExpCS returns [EObject current=null] : (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) ;
    public final EObject ruleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_selfKeywordCS_0 = null;

        EObject this_LiteralExpCS_1 = null;

        EObject this_IfExpCS_2 = null;

        EObject this_OclExpressionCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6094:6: ( (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6095:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6095:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            int alt94=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt94=1;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING_LITERAL:
            case 37:
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
            case 52:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
                {
                alt94=2;
                }
                break;
            case 77:
                {
                alt94=3;
                }
                break;
            case 22:
                {
                alt94=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("6095:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6096:2: this_selfKeywordCS_0= ruleselfKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfKeywordCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS10853);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6109:2: this_LiteralExpCS_1= ruleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS10883);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6122:2: this_IfExpCS_2= ruleIfExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS10913);
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
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6134:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6134:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6134:8: '(' this_OclExpressionCS_4= ruleOclExpressionCS ')'
                    {
                    match(input,22,FOLLOW_22_in_ruleprimaryExpCS10929); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_3_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOclExpressionCSParserRuleCall_3_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS10954);
                    this_OclExpressionCS_4=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OclExpressionCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,24,FOLLOW_24_in_ruleprimaryExpCS10963); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6162:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6163:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6164:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11000);
            iv_ruleIfExpCS=ruleIfExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpCS11010); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6171:1: ruleIfExpCS returns [EObject current=null] : ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6176:6: ( ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6177:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6177:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6177:3: 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif'
            {
            match(input,77,FOLLOW_77_in_ruleIfExpCS11045); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getIfKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6181:1: ( (lv_condition_1_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6182:1: (lv_condition_1_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6182:1: (lv_condition_1_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6183:3: lv_condition_1_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getConditionOclExpressionCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11066);
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

            match(input,78,FOLLOW_78_in_ruleIfExpCS11076); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getThenKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6209:1: ( (lv_thenExpression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6210:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6210:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6211:3: lv_thenExpression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11097);
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

            match(input,79,FOLLOW_79_in_ruleIfExpCS11107); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getElseKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6237:1: ( (lv_elseExpression_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6238:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6238:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6239:3: lv_elseExpression_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionOclExpressionCSParserRuleCall_5_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11128);
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

            match(input,80,FOLLOW_80_in_ruleIfExpCS11138); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6273:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6274:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6275:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11174);
            iv_ruleLetExpCS=ruleLetExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpCS11184); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6282:1: ruleLetExpCS returns [EObject current=null] : ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6287:6: ( ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6288:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6288:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6288:3: 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) )
            {
            match(input,81,FOLLOW_81_in_ruleLetExpCS11219); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getLetKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6292:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6293:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6293:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6294:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11240);
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

            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6316:2: ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==23) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6316:4: ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    match(input,23,FOLLOW_23_in_ruleLetExpCS11251); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6320:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6321:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6321:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6322:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11272);
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
            	    break loop95;
                }
            } while (true);

            match(input,82,FOLLOW_82_in_ruleLetExpCS11284); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getInKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6348:1: ( (lv_in_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6349:1: (lv_in_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6349:1: (lv_in_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6350:3: lv_in_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getInOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS11305);
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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6380:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6381:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6382:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11341);
            iv_ruleLetVariableCS=ruleLetVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetVariableCS11351); if (failed) return current;

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
    // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6389:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6394:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6395:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6395:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6395:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6395:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6396:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6396:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6397:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS11397);
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

            match(input,16,FOLLOW_16_in_ruleLetVariableCS11407); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6423:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6424:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6424:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6425:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleLetVariableCS11428);
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

            match(input,25,FOLLOW_25_in_ruleLetVariableCS11438); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6451:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6452:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6452:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:6453:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS11459);
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

    // $ANTLR start synpred67
    public final void synpred67_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:4: ( '(' ( ( ruletypeCS ) ) ')' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3030:4: '(' ( ( ruletypeCS ) ) ')'
        {
        match(input,22,FOLLOW_22_in_synpred675520); if (failed) return ;
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3034:1: ( ( ruletypeCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3035:1: ( ruletypeCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3035:1: ( ruletypeCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3036:3: ruletypeCS
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruletypeCS_in_synpred675541);
        ruletypeCS();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,24,FOLLOW_24_in_synpred675551); if (failed) return ;

        }
    }
    // $ANTLR end synpred67

    // $ANTLR start synpred71
    public final void synpred71_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3278:2: ( ruleTupleLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3278:2: ruleTupleLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_synpred715982);
        ruleTupleLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred71

    // $ANTLR start synpred77
    public final void synpred77_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3509:2: ( ruleIntegerLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3509:2: ruleIntegerLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_synpred776439);
        ruleIntegerLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred77

    // $ANTLR start synpred78
    public final void synpred78_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3522:2: ( ruleRealLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:3522:2: ruleRealLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleRealLiteralExpCS_in_synpred786469);
        ruleRealLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred78

    // $ANTLR start synpred92
    public final void synpred92_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:2: ( () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:2: () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4276:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4277:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4295:2: ( ( 'implies' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4296:1: ( 'implies' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4296:1: ( 'implies' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4297:3: 'implies'
        {
        match(input,61,FOLLOW_61_in_synpred928042); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4316:2: ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4317:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4317:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: ( ruleimpliesCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4318:1: ( ruleimpliesCS | ruleLetExpCS )
        int alt110=2;
        int LA110_0 = input.LA(1);

        if ( ((LA110_0>=RULE_ID && LA110_0<=RULE_STRING_LITERAL)||LA110_0==22||(LA110_0>=36 && LA110_0<=38)||(LA110_0>=40 && LA110_0<=52)||(LA110_0>=56 && LA110_0<=60)||LA110_0==71||LA110_0==77) ) {
            alt110=1;
        }
        else if ( (LA110_0==81) ) {
            alt110=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4318:1: ( ruleimpliesCS | ruleLetExpCS )", 110, 0, input);

            throw nvae;
        }
        switch (alt110) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4319:3: ruleimpliesCS
                {
                pushFollow(FOLLOW_ruleimpliesCS_in_synpred928078);
                ruleimpliesCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4340:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred928097);
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
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:2: ( () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:2: () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4399:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4400:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4418:2: ( ( 'xor' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4419:1: ( 'xor' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4419:1: ( 'xor' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4420:3: 'xor'
        {
        match(input,62,FOLLOW_62_in_synpred948228); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4439:2: ( ( ( rulexorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4440:1: ( ( rulexorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4440:1: ( ( rulexorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: ( rulexorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4441:1: ( rulexorCS | ruleLetExpCS )
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( ((LA111_0>=RULE_ID && LA111_0<=RULE_STRING_LITERAL)||LA111_0==22||(LA111_0>=36 && LA111_0<=38)||(LA111_0>=40 && LA111_0<=52)||(LA111_0>=56 && LA111_0<=60)||LA111_0==71||LA111_0==77) ) {
            alt111=1;
        }
        else if ( (LA111_0==81) ) {
            alt111=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4441:1: ( rulexorCS | ruleLetExpCS )", 111, 0, input);

            throw nvae;
        }
        switch (alt111) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4442:3: rulexorCS
                {
                pushFollow(FOLLOW_rulexorCS_in_synpred948264);
                rulexorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4463:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred948283);
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
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:2: ( () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:2: () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4522:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4523:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4541:2: ( ( 'or' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4542:1: ( 'or' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4542:1: ( 'or' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4543:3: 'or'
        {
        match(input,63,FOLLOW_63_in_synpred968414); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4562:2: ( ( ( ruleorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4563:1: ( ( ruleorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4563:1: ( ( ruleorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: ( ruleorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4564:1: ( ruleorCS | ruleLetExpCS )
        int alt112=2;
        int LA112_0 = input.LA(1);

        if ( ((LA112_0>=RULE_ID && LA112_0<=RULE_STRING_LITERAL)||LA112_0==22||(LA112_0>=36 && LA112_0<=38)||(LA112_0>=40 && LA112_0<=52)||(LA112_0>=56 && LA112_0<=60)||LA112_0==71||LA112_0==77) ) {
            alt112=1;
        }
        else if ( (LA112_0==81) ) {
            alt112=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4564:1: ( ruleorCS | ruleLetExpCS )", 112, 0, input);

            throw nvae;
        }
        switch (alt112) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4565:3: ruleorCS
                {
                pushFollow(FOLLOW_ruleorCS_in_synpred968450);
                ruleorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4586:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred968469);
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

    // $ANTLR start synpred98
    public final void synpred98_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:2: ( () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:2: () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4645:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4646:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4664:2: ( ( 'and' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4665:1: ( 'and' )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4665:1: ( 'and' )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4666:3: 'and'
        {
        match(input,64,FOLLOW_64_in_synpred988600); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4685:2: ( ( ( ruleandCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4686:1: ( ( ruleandCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4686:1: ( ( ruleandCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: ( ruleandCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4687:1: ( ruleandCS | ruleLetExpCS )
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( ((LA113_0>=RULE_ID && LA113_0<=RULE_STRING_LITERAL)||LA113_0==22||(LA113_0>=36 && LA113_0<=38)||(LA113_0>=40 && LA113_0<=52)||(LA113_0>=56 && LA113_0<=60)||LA113_0==71||LA113_0==77) ) {
            alt113=1;
        }
        else if ( (LA113_0==81) ) {
            alt113=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4687:1: ( ruleandCS | ruleLetExpCS )", 113, 0, input);

            throw nvae;
        }
        switch (alt113) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4688:3: ruleandCS
                {
                pushFollow(FOLLOW_ruleandCS_in_synpred988636);
                ruleandCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4709:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred988655);
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
    // $ANTLR end synpred98

    // $ANTLR start synpred101
    public final void synpred101_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:2: ( () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:2: () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4768:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4769:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4787:2: ( ( ( '=' | '<>' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4788:1: ( ( '=' | '<>' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4788:1: ( ( '=' | '<>' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4789:1: ( '=' | '<>' )
        {
        if ( input.LA(1)==25||input.LA(1)==65 ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1018781);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4829:2: ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4830:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4830:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: ( ruleequalityCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4831:1: ( ruleequalityCS | ruleLetExpCS )
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( ((LA114_0>=RULE_ID && LA114_0<=RULE_STRING_LITERAL)||LA114_0==22||(LA114_0>=36 && LA114_0<=38)||(LA114_0>=40 && LA114_0<=52)||(LA114_0>=56 && LA114_0<=60)||LA114_0==71||LA114_0==77) ) {
            alt114=1;
        }
        else if ( (LA114_0==81) ) {
            alt114=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("4831:1: ( ruleequalityCS | ruleLetExpCS )", 114, 0, input);

            throw nvae;
        }
        switch (alt114) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4832:3: ruleequalityCS
                {
                pushFollow(FOLLOW_ruleequalityCS_in_synpred1018856);
                ruleequalityCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4853:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred1018875);
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
    // $ANTLR end synpred101

    // $ANTLR start synpred106
    public final void synpred106_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:2: ( () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:2: () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4912:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4913:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4931:2: ( ( ( '>' | '<' | '>=' | '<=' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4932:1: ( ( '>' | '<' | '>=' | '<=' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4932:1: ( ( '>' | '<' | '>=' | '<=' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:4933:1: ( '>' | '<' | '>=' | '<=' )
        {
        if ( (input.LA(1)>=66 && input.LA(1)<=69) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1069001);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5009:2: ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5010:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5010:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: ( rulerelationalCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5011:1: ( rulerelationalCS | ruleLetExpCS )
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( ((LA115_0>=RULE_ID && LA115_0<=RULE_STRING_LITERAL)||LA115_0==22||(LA115_0>=36 && LA115_0<=38)||(LA115_0>=40 && LA115_0<=52)||(LA115_0>=56 && LA115_0<=60)||LA115_0==71||LA115_0==77) ) {
            alt115=1;
        }
        else if ( (LA115_0==81) ) {
            alt115=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("5011:1: ( rulerelationalCS | ruleLetExpCS )", 115, 0, input);

            throw nvae;
        }
        switch (alt115) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5012:3: rulerelationalCS
                {
                pushFollow(FOLLOW_rulerelationalCS_in_synpred1069134);
                rulerelationalCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5033:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred1069153);
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
    // $ANTLR end synpred106

    // $ANTLR start synpred109
    public final void synpred109_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:2: () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5092:2: ()
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5093:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5111:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5112:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5112:1: ( ( '+' | '-' ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5113:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=35 && input.LA(1)<=36) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1099279);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5153:2: ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5154:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5154:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: ( ruleadditiveCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5155:1: ( ruleadditiveCS | ruleLetExpCS )
        int alt116=2;
        int LA116_0 = input.LA(1);

        if ( ((LA116_0>=RULE_ID && LA116_0<=RULE_STRING_LITERAL)||LA116_0==22||(LA116_0>=36 && LA116_0<=38)||(LA116_0>=40 && LA116_0<=52)||(LA116_0>=56 && LA116_0<=60)||LA116_0==71||LA116_0==77) ) {
            alt116=1;
        }
        else if ( (LA116_0==81) ) {
            alt116=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("5155:1: ( ruleadditiveCS | ruleLetExpCS )", 116, 0, input);

            throw nvae;
        }
        switch (alt116) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5156:3: ruleadditiveCS
                {
                pushFollow(FOLLOW_ruleadditiveCS_in_synpred1099354);
                ruleadditiveCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.completeocl/src-gen/org/eclipse/ocl/examples/xtext/completeocl/parser/antlr/internal/InternalCompleteOCL.g:5177:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred1099373);
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
    // $ANTLR end synpred109

    public final boolean synpred106() {
        backtracking++;
        int start = input.mark();
        try {
            synpred106_fragment(); // can never throw exception
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
    public final boolean synpred78() {
        backtracking++;
        int start = input.mark();
        try {
            synpred78_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred109() {
        backtracking++;
        int start = input.mark();
        try {
            synpred109_fragment(); // can never throw exception
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
    public final boolean synpred77() {
        backtracking++;
        int start = input.mark();
        try {
            synpred77_fragment(); // can never throw exception
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
    public final boolean synpred98() {
        backtracking++;
        int start = input.mark();
        try {
            synpred98_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred101() {
        backtracking++;
        int start = input.mark();
        try {
            synpred101_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred67() {
        backtracking++;
        int start = input.mark();
        try {
            synpred67_fragment(); // can never throw exception
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
    public final boolean synpred71() {
        backtracking++;
        int start = input.mark();
        try {
            synpred71_fragment(); // can never throw exception
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
        "\2\uffff\1\6\6\uffff\17\6";
    static final String DFA5_minS =
        "\1\17\1\4\1\15\2\4\3\uffff\1\0\17\15";
    static final String DFA5_maxS =
        "\1\17\1\4\1\47\2\64\3\uffff\1\0\17\47";
    static final String DFA5_acceptS =
        "\5\uffff\1\3\1\2\1\1\20\uffff";
    static final String DFA5_specialS =
        "\10\uffff\1\0\17\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\3\6\1\3\2\uffff\3\6\1\5\20\uffff\1\4",
            "\1\10\40\uffff\1\7\2\uffff\15\7",
            "\1\11\40\uffff\1\27\2\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\12\1\13\1\14\1\15\1\16",
            "",
            "",
            "",
            "\1\uffff",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4",
            "\3\6\1\7\2\uffff\3\6\1\5\20\uffff\1\4"
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
                        int LA5_8 = input.LA(1);

                         
                        int index5_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6()) ) {s = 7;}

                        else if ( (synpred7()) ) {s = 6;}

                         
                        input.seek(index5_8);
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
    public static final BitSet FOLLOW_16_in_rulepropertyContextDeclCS825 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_rulepropertyContextDeclCS846 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS869 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rulederCS_in_rulepropertyContextDeclCS890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulederCS_in_rulepropertyContextDeclCS921 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleinitCS_in_rulepropertyContextDeclCS942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleinitCS_in_entryRuleinitCS981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleinitCS991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleinitCS1026 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleinitCS1036 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleinitCS1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulederCS_in_entryRulederCS1093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulederCS1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rulederCS1138 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulederCS1148 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
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
    public static final BitSet FOLLOW_16_in_ruleinvCS1469 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
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
    public static final BitSet FOLLOW_16_in_ruledefCS1747 = new BitSet(new long[]{0x001FFF2002000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruledefCS1768 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruledefCS1779 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
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
    public static final BitSet FOLLOW_16_in_ruleoperationContextDeclCS1990 = new BitSet(new long[]{0x001FFF201C000012L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleoperationContextDeclCS2011 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulepreCS_in_ruleoperationContextDeclCS2034 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulepostCS_in_ruleoperationContextDeclCS2061 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_ruleoperationContextDeclCS2088 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleparameterCS_in_entryRuleparameterCS2126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleparameterCS2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleparameterCS2182 = new BitSet(new long[]{0x0000000002010002L});
    public static final BitSet FOLLOW_16_in_ruleparameterCS2193 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleparameterCS2214 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleparameterCS2227 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleparameterCS2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCS_in_entryRulepreCS2286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepreCS2296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulepreCS2331 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepreCS2352 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulepreCS2363 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulepreCS2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepostCS_in_entryRulepostCS2420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepostCS2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rulepostCS2465 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepostCS2486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulepostCS2497 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulepostCS2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_entryRulebodyCS2554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulebodyCS2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulebodyCS2599 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulebodyCS2620 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulebodyCS2631 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulebodyCS2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulenamedConstraintCS_in_entryRulenamedConstraintCS2690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulenamedConstraintCS2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulebodyCS_in_rulenamedConstraintCS2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruledefCS_in_rulenamedConstraintCS2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleinvCS_in_rulenamedConstraintCS2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepostCS_in_rulenamedConstraintCS2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreCS_in_rulenamedConstraintCS2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemessageExpCS_in_entryRulemessageExpCS2905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemessageExpCS2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_rulemessageExpCS2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageExpCS_in_rulemessageExpCS2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreExpCS_in_entryRulepreExpCS3030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepreExpCS3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleindexExpCS_in_rulepreExpCS3090 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_rulepreExpCS3112 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulepreExpCS3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageExpCS_in_entryRuleOclMessageExpCS3181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclMessageExpCS3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_ruleOclMessageExpCS3237 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleOclMessageExpCS3257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_31_in_ruleOclMessageExpCS3286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleOclMessageExpCS3323 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOclMessageExpCS3333 = new BitSet(new long[]{0x1F1FFF7101400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3355 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleOclMessageExpCS3366 = new BitSet(new long[]{0x1F1FFF7100400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_ruleOclMessageExpCS3387 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleOclMessageExpCS3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclMessageArgCS_in_entryRuleOclMessageArgCS3437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclMessageArgCS3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleOclMessageArgCS3495 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleOclMessageArgCS3506 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleOclMessageArgCS3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleOclMessageArgCS3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL3597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL_LITERAL3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3648 = new BitSet(new long[]{0x0000000600000800L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL3668 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL3710 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3725 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleREAL_LITERAL3746 = new BitSet(new long[]{0x0000001800000020L});
    public static final BitSet FOLLOW_34_in_ruleREAL_LITERAL3765 = new BitSet(new long[]{0x0000001800000020L});
    public static final BitSet FOLLOW_35_in_ruleREAL_LITERAL3780 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36_in_ruleREAL_LITERAL3799 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL3864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER_LITERAL3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL3914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS3960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleKeywordCS3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruletupleKeywordCS4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS4060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerestrictedKeywordCS4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS4150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS4215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleselfKeywordCS4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleselfKeywordCS4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS4315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesimpleNameCS4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulesimpleNameCS4366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS4466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_entryRulepathNameCS4531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepathNameCS4541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepathNameCS4587 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_rulepathNameCS4598 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS4619 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS4657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimitiveTypeCS4667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleprimitiveTypeCS4710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleprimitiveTypeCS4747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleprimitiveTypeCS4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleprimitiveTypeCS4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleprimitiveTypeCS4858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleprimitiveTypeCS4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleprimitiveTypeCS4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleprimitiveTypeCS4969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS5018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS5028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCollectionTypeIdentifierCS5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleCollectionTypeIdentifierCS5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleCollectionTypeIdentifierCS5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleCollectionTypeIdentifierCS5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleCollectionTypeIdentifierCS5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletypeCS_in_entryRuletypeCS5268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletypeCS5278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruletypeCS5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruletypeCS5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruletypeCS5418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS5453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecollectionTypeCS5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS5509 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_rulecollectionTypeCS5520 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_rulecollectionTypeCS5541 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulecollectionTypeCS5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS5589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleTypeCS5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruletupleTypeCS5642 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruletupleTypeCS5665 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5687 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruletupleTypeCS5698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS5719 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruletupleTypeCS5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS5769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletuplePartCS5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruletuplePartCS5825 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruletuplePartCS5835 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruletuplePartCS5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS5892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpCS5902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS5952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS5982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS6042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS6077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS6137 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleCollectionLiteralExpCS6147 = new BitSet(new long[]{0x1F5FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6169 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCollectionLiteralExpCS6180 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS6201 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_54_in_ruleCollectionLiteralExpCS6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS6253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS6263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6309 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleCollectionLiteralPartCS6320 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS6469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleTupleLiteralExpCS6711 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleTupleLiteralExpCS6722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6743 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTupleLiteralExpCS6754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6775 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_54_in_ruleTupleLiteralExpCS6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS6881 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleTupleLiteralPartCS6892 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS6913 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTupleLiteralPartCS6925 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS6946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS6982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS6992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS7072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralExpCS7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS7127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS7162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS7172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS7213 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS7254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS7264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBooleanLiteralExpCS7307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleBooleanLiteralExpCS7344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS7393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS7403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUnlimitedNaturalLiteralExpCS7450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleInvalidLiteralExpCS7543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleNullLiteralExpCS7636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS7732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS7762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS7827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclExpressionCS7837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS7917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS7952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleimpliesCS7962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_ruleimpliesCS8012 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleimpliesCS8042 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleimpliesCS8078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleimpliesCS8097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_entryRulexorCS8138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulexorCS8148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_rulexorCS8198 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_rulexorCS8228 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_rulexorCS_in_rulexorCS8264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulexorCS8283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_entryRuleorCS8324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleorCS8334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleorCS8384 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleorCS8414 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleorCS_in_ruleorCS8450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleorCS8469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_entryRuleandCS8510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleandCS8520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleandCS8570 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleandCS8600 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleandCS8636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleandCS8655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_entryRuleequalityCS8696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityCS8706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_ruleequalityCS8756 = new BitSet(new long[]{0x0000000002000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleequalityCS8788 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_65_in_ruleequalityCS8817 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleequalityCS8856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleequalityCS8875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_entryRulerelationalCS8916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalCS8926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_rulerelationalCS8976 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_66_in_rulerelationalCS9008 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_67_in_rulerelationalCS9037 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_68_in_rulerelationalCS9066 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_69_in_rulerelationalCS9095 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_rulerelationalCS_in_rulerelationalCS9134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulerelationalCS9153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS9194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveCS9204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS9254 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_ruleadditiveCS9286 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_36_in_ruleadditiveCS9315 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_ruleadditiveCS9354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleadditiveCS9373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS9414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeCS9424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_rulemultiplicativeCS9474 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_58_in_rulemultiplicativeCS9506 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_70_in_rulemultiplicativeCS9535 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS9574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS9593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_entryRuleunaryCS9634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryCS9644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_ruleunaryCS9694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleunaryCS9732 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000002080L});
    public static final BitSet FOLLOW_71_in_ruleunaryCS9761 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000002080L});
    public static final BitSet FOLLOW_ruleunaryCS_in_ruleunaryCS9798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_entryRulecallingExpCS9835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecallingExpCS9845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallExpCS_in_rulecallingExpCS9895 = new BitSet(new long[]{0x0000000000000802L,0x0000000000000100L});
    public static final BitSet FOLLOW_11_in_rulecallingExpCS9927 = new BitSet(new long[]{0x1F1FFF6000400070L,0x0000000000002000L});
    public static final BitSet FOLLOW_72_in_rulecallingExpCS9956 = new BitSet(new long[]{0x1F1FFF6000400070L,0x0000000000002000L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_rulecallingExpCS9993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS10031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorVariableCS10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS10087 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleiteratorVariableCS10098 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorVariableCS10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS10157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS10167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS10213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleiteratorAccumulatorCS10223 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS10244 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleiteratorAccumulatorCS10254 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS10275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallExpCS_in_entryRulecallExpCS10311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecallExpCS10321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreExpCS_in_rulecallExpCS10371 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_rulecallExpCS10393 = new BitSet(new long[]{0x1F1FFF7001400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS10415 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000600L});
    public static final BitSet FOLLOW_23_in_rulecallExpCS10427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS10448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_73_in_rulecallExpCS10466 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_rulecallExpCS10487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_rulecallExpCS10500 = new BitSet(new long[]{0x1F1FFF7001400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulecallExpCS10524 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_rulecallExpCS10535 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulecallExpCS10556 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_rulecallExpCS10570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleindexExpCS_in_entryRuleindexExpCS10608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleindexExpCS10618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemessageExpCS_in_ruleindexExpCS10668 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleindexExpCS10690 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS10711 = new BitSet(new long[]{0x0000000000800000L,0x0000000000001000L});
    public static final BitSet FOLLOW_23_in_ruleindexExpCS10722 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS10743 = new BitSet(new long[]{0x0000000000800000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleindexExpCS10755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS10793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimaryExpCS10803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS10853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS10883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS10913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleprimaryExpCS10929 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS10954 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleprimaryExpCS10963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS11000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS11010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleIfExpCS11045 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleIfExpCS11076 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleIfExpCS11107 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS11128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleIfExpCS11138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS11174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS11184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleLetExpCS11219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11240 = new BitSet(new long[]{0x0000000000800000L,0x0000000000040000L});
    public static final BitSet FOLLOW_23_in_ruleLetExpCS11251 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS11272 = new BitSet(new long[]{0x0000000000800000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ruleLetExpCS11284 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS11305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS11341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS11351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS11397 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLetVariableCS11407 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleLetVariableCS11428 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLetVariableCS11438 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS11459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepropertyContextDeclCS_in_synpred6654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleclassifierContextDeclCS_in_synpred7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_synpred372965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_synpred675520 = new BitSet(new long[]{0x001FFF2000000010L});
    public static final BitSet FOLLOW_ruletypeCS_in_synpred675541 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_synpred675551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred715982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_synpred776439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_synpred786469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_synpred928042 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_synpred928078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred928097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_synpred948228 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_rulexorCS_in_synpred948264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred948283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred968414 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleorCS_in_synpred968450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred968469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_synpred988600 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleandCS_in_synpred988636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred988655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1018781 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleequalityCS_in_synpred1018856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred1018875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1069001 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_rulerelationalCS_in_synpred1069134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred1069153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1099279 = new BitSet(new long[]{0x1F1FFF7000400070L,0x0000000000022080L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_synpred1099354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred1099373 = new BitSet(new long[]{0x0000000000000002L});

}