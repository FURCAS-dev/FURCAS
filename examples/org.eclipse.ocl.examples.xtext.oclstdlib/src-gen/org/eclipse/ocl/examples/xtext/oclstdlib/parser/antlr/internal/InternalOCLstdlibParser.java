package org.eclipse.ocl.examples.xtext.oclstdlib.parser.antlr.internal; 

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
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalOCLstdlibParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID_TERMINAL", "RULE_SINGLE_QUOTED_STRING", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'library'", "'{'", "'}'", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'operation'", "'package'", "'property'", "'static'", "'super'", "'type'", "':'", "'<'", "','", "'>'", "'('", "'...'", "')'", "'=>'", "';'", "'['", "'..'", "'+'", "'?'", "']'", "'::'", "'&&'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID_TERMINAL=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_SINGLE_QUOTED_STRING=6;
    public static final int RULE_DOUBLE_QUOTED_STRING=7;
    public static final int RULE_SL_COMMENT=9;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[84+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private OCLstdlibGrammarAccess grammarAccess;
     	
        public InternalOCLstdlibParser(TokenStream input, IAstFactory factory, OCLstdlibGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Library";	
       	}
       	
       	@Override
       	protected OCLstdlibGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleLibrary
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:83:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:84:2: (iv_ruleLibrary= ruleLibrary EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:85:2: iv_ruleLibrary= ruleLibrary EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibraryRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_entryRuleLibrary81);
            iv_ruleLibrary=ruleLibrary();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibrary91); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibrary


    // $ANTLR start ruleLibrary
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:92:1: ruleLibrary returns [EObject current=null] : ( 'library' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_imports_2_0= ruleLibImportCS ) )* '{' ( (lv_packages_4_0= ruleLibPackageCS ) )* '}' ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_packages_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:97:6: ( ( 'library' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_imports_2_0= ruleLibImportCS ) )* '{' ( (lv_packages_4_0= ruleLibPackageCS ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:98:1: ( 'library' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_imports_2_0= ruleLibImportCS ) )* '{' ( (lv_packages_4_0= ruleLibPackageCS ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:98:1: ( 'library' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_imports_2_0= ruleLibImportCS ) )* '{' ( (lv_packages_4_0= ruleLibPackageCS ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:98:3: 'library' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_imports_2_0= ruleLibImportCS ) )* '{' ( (lv_packages_4_0= ruleLibPackageCS ) )* '}'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleLibrary126); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibraryAccess().getLibraryKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:102:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:103:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:103:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:104:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibrary147);
            lv_name_1_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibraryRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:126:2: ( (lv_imports_2_0= ruleLibImportCS ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:127:1: (lv_imports_2_0= ruleLibImportCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:127:1: (lv_imports_2_0= ruleLibImportCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:128:3: lv_imports_2_0= ruleLibImportCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_ruleLibrary168);
            	    lv_imports_2_0=ruleLibImportCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibraryRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"imports",
            	      	        		lv_imports_2_0, 
            	      	        		"LibImportCS", 
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibrary179); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:154:1: ( (lv_packages_4_0= ruleLibPackageCS ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:155:1: (lv_packages_4_0= ruleLibPackageCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:155:1: (lv_packages_4_0= ruleLibPackageCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:156:3: lv_packages_4_0= ruleLibPackageCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_ruleLibrary200);
            	    lv_packages_4_0=ruleLibPackageCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibraryRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"packages",
            	      	        		lv_packages_4_0, 
            	      	        		"LibPackageCS", 
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
            	    break loop2;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibrary211); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5(), null); 
                  
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
    // $ANTLR end ruleLibrary


    // $ANTLR start entryRuleLOWER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:190:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:191:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:192:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLOWERRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER248);
            iv_ruleLOWER=ruleLOWER();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER259); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLOWER


    // $ANTLR start ruleLOWER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:199:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:204:6: (this_INT_0= RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:205:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER298); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getLOWERAccess().getINTTerminalRuleCall(), null); 
                  
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
    // $ANTLR end ruleLOWER


    // $ANTLR start entryRuleUPPER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:220:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:221:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:222:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUPPERRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER343);
            iv_ruleUPPER=ruleUPPER();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER354); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleUPPER


    // $ANTLR start ruleUPPER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:229:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:234:6: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:235:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:235:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("235:1: (this_INT_0= RULE_INT | kw= '*' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:235:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)input.LT(1);
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER394); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:244:2: kw= '*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleUPPER418); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getUPPERAccess().getAsteriskKeyword_1(), null); 
                          
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
    // $ANTLR end ruleUPPER


    // $ANTLR start entryRuleIdentifier
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:257:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:258:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:259:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIdentifierRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier459);
            iv_ruleIdentifier=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier470); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIdentifier


    // $ANTLR start ruleIdentifier
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:266:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'static' | kw= 'super' | kw= 'type' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_TERMINAL_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:271:6: ( (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'static' | kw= 'super' | kw= 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'static' | kw= 'super' | kw= 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'static' | kw= 'super' | kw= 'type' )
            int alt4=12;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 17:
                {
                alt4=4;
                }
                break;
            case 18:
                {
                alt4=5;
                }
                break;
            case 11:
                {
                alt4=6;
                }
                break;
            case 19:
                {
                alt4=7;
                }
                break;
            case 20:
                {
                alt4=8;
                }
                break;
            case 21:
                {
                alt4=9;
                }
                break;
            case 22:
                {
                alt4=10;
                }
                break;
            case 23:
                {
                alt4=11;
                }
                break;
            case 24:
                {
                alt4=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'static' | kw= 'super' | kw= 'type' )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:6: this_ID_TERMINAL_0= RULE_ID_TERMINAL
                    {
                    this_ID_TERMINAL_0=(Token)input.LT(1);
                    match(input,RULE_ID_TERMINAL,FollowSets000.FOLLOW_RULE_ID_TERMINAL_in_ruleIdentifier510); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_ID_TERMINAL_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getIdentifierAccess().getID_TERMINALTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:281:2: kw= 'conformsTo'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleIdentifier534); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getConformsToKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:288:2: kw= 'extends'
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleIdentifier553); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getExtendsKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:295:2: kw= 'import'
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleIdentifier572); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getImportKeyword_3(), null); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:302:2: kw= 'iteration'
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleIdentifier591); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getIterationKeyword_4(), null); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:309:2: kw= 'library'
                    {
                    kw=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleIdentifier610); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getLibraryKeyword_5(), null); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:316:2: kw= 'operation'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleIdentifier629); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getOperationKeyword_6(), null); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:323:2: kw= 'package'
                    {
                    kw=(Token)input.LT(1);
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleIdentifier648); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getPackageKeyword_7(), null); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:330:2: kw= 'property'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleIdentifier667); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getPropertyKeyword_8(), null); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:337:2: kw= 'static'
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleIdentifier686); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getStaticKeyword_9(), null); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:344:2: kw= 'super'
                    {
                    kw=(Token)input.LT(1);
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleIdentifier705); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getSuperKeyword_10(), null); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:351:2: kw= 'type'
                    {
                    kw=(Token)input.LT(1);
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleIdentifier724); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getTypeKeyword_11(), null); 
                          
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
    // $ANTLR end ruleIdentifier


    // $ANTLR start entryRuleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:366:1: entryRuleLibImportCS returns [EObject current=null] : iv_ruleLibImportCS= ruleLibImportCS EOF ;
    public final EObject entryRuleLibImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibImportCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:367:2: (iv_ruleLibImportCS= ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:368:2: iv_ruleLibImportCS= ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibImportCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS766);
            iv_ruleLibImportCS=ruleLibImportCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS776); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibImportCS


    // $ANTLR start ruleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:375:1: ruleLibImportCS returns [EObject current=null] : ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) ;
    public final EObject ruleLibImportCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:380:6: ( ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:381:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:381:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:381:3: 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleLibImportCS811); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibImportCSAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:385:1: ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID_TERMINAL||LA5_0==11||(LA5_0>=15 && LA5_0<=24)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:385:2: ( (lv_name_1_0= ruleIdentifier ) ) ':'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:385:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:386:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:386:1: (lv_name_1_0= ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:387:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibImportCS833);
                    lv_name_1_0=ruleIdentifier();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibImportCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"name",
                      	        		lv_name_1_0, 
                      	        		"Identifier", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibImportCS843); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:413:3: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:414:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:414:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:415:3: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getLibImportCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS867); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0(), "namespace"); 
              	
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
    // $ANTLR end ruleLibImportCS


    // $ANTLR start entryRuleLibClassCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:438:1: entryRuleLibClassCS returns [EObject current=null] : iv_ruleLibClassCS= ruleLibClassCS EOF ;
    public final EObject entryRuleLibClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:439:2: (iv_ruleLibClassCS= ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:440:2: iv_ruleLibClassCS= ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS903);
            iv_ruleLibClassCS=ruleLibClassCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS913); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibClassCS


    // $ANTLR start ruleLibClassCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:447:1: ruleLibClassCS returns [EObject current=null] : ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' ) ;
    public final EObject ruleLibClassCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_conformsTo_8_0 = null;

        EObject lv_conformsTo_10_0 = null;

        EObject lv_iterations_12_0 = null;

        EObject lv_operations_13_0 = null;

        EObject lv_structuralFeatures_14_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:452:6: ( ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:453:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:453:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:453:3: 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}'
            {
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibClassCS948); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getTypeKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:457:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:458:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:458:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:459:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibClassCS969);
            lv_name_1_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:481:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:481:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibClassCS980); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:485:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:486:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:486:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:487:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1001);
                    lv_typeParameters_3_0=ruleLibTypeParameterCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParameters",
                      	        		lv_typeParameters_3_0, 
                      	        		"LibTypeParameterCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:509:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==27) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:509:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibClassCS1012); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:513:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:514:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:514:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:515:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1033);
                    	    lv_typeParameters_5_0=ruleLibTypeParameterCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParameters",
                    	      	        		lv_typeParameters_5_0, 
                    	      	        		"LibTypeParameterCS", 
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
                    	    break loop6;
                        }
                    } while (true);

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleLibClassCS1045); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:541:3: ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:541:5: 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleLibClassCS1058); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:545:1: ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:546:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:546:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:547:3: lv_conformsTo_8_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1079);
                    lv_conformsTo_8_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"conformsTo",
                      	        		lv_conformsTo_8_0, 
                      	        		"LibTypedRefCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:569:2: ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==27) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:569:4: ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibClassCS1090); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:573:1: ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:574:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:574:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:575:3: lv_conformsTo_10_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1111);
                    	    lv_conformsTo_10_0=ruleLibTypedRefCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"conformsTo",
                    	      	        		lv_conformsTo_10_0, 
                    	      	        		"LibTypedRefCS", 
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
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibClassCS1125); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:601:1: ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )*
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt10=1;
                    }
                    break;
                case 22:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==21) ) {
                        alt10=3;
                    }
                    else if ( (LA10_3==19) ) {
                        alt10=2;
                    }


                    }
                    break;
                case 19:
                    {
                    alt10=2;
                    }
                    break;
                case 21:
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:601:2: ( (lv_iterations_12_0= ruleLibIterationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:601:2: ( (lv_iterations_12_0= ruleLibIterationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:602:1: (lv_iterations_12_0= ruleLibIterationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:602:1: (lv_iterations_12_0= ruleLibIterationCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:603:3: lv_iterations_12_0= ruleLibIterationCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1147);
            	    lv_iterations_12_0=ruleLibIterationCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"iterations",
            	      	        		lv_iterations_12_0, 
            	      	        		"LibIterationCS", 
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:626:6: ( (lv_operations_13_0= ruleLibOperationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:626:6: ( (lv_operations_13_0= ruleLibOperationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:627:1: (lv_operations_13_0= ruleLibOperationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:627:1: (lv_operations_13_0= ruleLibOperationCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:628:3: lv_operations_13_0= ruleLibOperationCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1174);
            	    lv_operations_13_0=ruleLibOperationCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"operations",
            	      	        		lv_operations_13_0, 
            	      	        		"LibOperationCS", 
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:651:6: ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:651:6: ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:652:1: (lv_structuralFeatures_14_0= ruleLibPropertyCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:652:1: (lv_structuralFeatures_14_0= ruleLibPropertyCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:653:3: lv_structuralFeatures_14_0= ruleLibPropertyCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1201);
            	    lv_structuralFeatures_14_0=ruleLibPropertyCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibClassCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"structuralFeatures",
            	      	        		lv_structuralFeatures_14_0, 
            	      	        		"LibPropertyCS", 
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
            	    break loop10;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibClassCS1213); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6(), null); 
                  
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
    // $ANTLR end ruleLibClassCS


    // $ANTLR start entryRuleLibClassifierCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:687:1: entryRuleLibClassifierCS returns [EObject current=null] : iv_ruleLibClassifierCS= ruleLibClassifierCS EOF ;
    public final EObject entryRuleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:688:2: (iv_ruleLibClassifierCS= ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:689:2: iv_ruleLibClassifierCS= ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassifierCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1249);
            iv_ruleLibClassifierCS=ruleLibClassifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassifierCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS1259); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibClassifierCS


    // $ANTLR start ruleLibClassifierCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:696:1: ruleLibClassifierCS returns [EObject current=null] : this_LibClassCS_0= ruleLibClassCS ;
    public final EObject ruleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibClassCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:701:6: (this_LibClassCS_0= ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:703:2: this_LibClassCS_0= ruleLibClassCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1308);
            this_LibClassCS_0=ruleLibClassCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_LibClassCS_0; 
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
    // $ANTLR end ruleLibClassifierCS


    // $ANTLR start entryRuleLibIterationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:722:1: entryRuleLibIterationCS returns [EObject current=null] : iv_ruleLibIterationCS= ruleLibIterationCS EOF ;
    public final EObject entryRuleLibIterationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibIterationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:723:2: (iv_ruleLibIterationCS= ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:724:2: iv_ruleLibIterationCS= ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibIterationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1342);
            iv_ruleLibIterationCS=ruleLibIterationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibIterationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS1352); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibIterationCS


    // $ANTLR start ruleLibIterationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:731:1: ruleLibIterationCS returns [EObject current=null] : ( 'iteration' ( (lv_name_1_0= ruleIdentifier ) ) '(' ( (lv_iterators_3_0= ruleIdentifier ) ) ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )* ( (lv_iterators_6_0= '...' ) )? ')' ':' ( (lv_type_9_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibIterationCS() throws RecognitionException {
        EObject current = null;

        Token lv_iterators_6_0=null;
        Token lv_class_11_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_iterators_3_0 = null;

        AntlrDatatypeRuleToken lv_iterators_5_0 = null;

        EObject lv_type_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:736:6: ( ( 'iteration' ( (lv_name_1_0= ruleIdentifier ) ) '(' ( (lv_iterators_3_0= ruleIdentifier ) ) ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )* ( (lv_iterators_6_0= '...' ) )? ')' ':' ( (lv_type_9_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:737:1: ( 'iteration' ( (lv_name_1_0= ruleIdentifier ) ) '(' ( (lv_iterators_3_0= ruleIdentifier ) ) ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )* ( (lv_iterators_6_0= '...' ) )? ')' ':' ( (lv_type_9_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:737:1: ( 'iteration' ( (lv_name_1_0= ruleIdentifier ) ) '(' ( (lv_iterators_3_0= ruleIdentifier ) ) ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )* ( (lv_iterators_6_0= '...' ) )? ')' ':' ( (lv_type_9_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:737:3: 'iteration' ( (lv_name_1_0= ruleIdentifier ) ) '(' ( (lv_iterators_3_0= ruleIdentifier ) ) ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )* ( (lv_iterators_6_0= '...' ) )? ')' ':' ( (lv_type_9_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleLibIterationCS1387); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:741:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:742:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:742:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:743:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibIterationCS1408);
            lv_name_1_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibIterationCS1418); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:769:1: ( (lv_iterators_3_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:770:1: (lv_iterators_3_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:770:1: (lv_iterators_3_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:771:3: lv_iterators_3_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibIterationCS1439);
            lv_iterators_3_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"iterators",
              	        		lv_iterators_3_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:793:2: ( ',' ( (lv_iterators_5_0= ruleIdentifier ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:793:4: ',' ( (lv_iterators_5_0= ruleIdentifier ) )
            	    {
            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibIterationCS1450); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLibIterationCSAccess().getCommaKeyword_4_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:797:1: ( (lv_iterators_5_0= ruleIdentifier ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:798:1: (lv_iterators_5_0= ruleIdentifier )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:798:1: (lv_iterators_5_0= ruleIdentifier )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:799:3: lv_iterators_5_0= ruleIdentifier
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_4_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibIterationCS1471);
            	    lv_iterators_5_0=ruleIdentifier();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"iterators",
            	      	        		lv_iterators_5_0, 
            	      	        		"Identifier", 
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:821:4: ( (lv_iterators_6_0= '...' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:822:1: (lv_iterators_6_0= '...' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:822:1: (lv_iterators_6_0= '...' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:823:3: lv_iterators_6_0= '...'
                    {
                    lv_iterators_6_0=(Token)input.LT(1);
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleLibIterationCS1491); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibIterationCSAccess().getIteratorsFullStopFullStopFullStopKeyword_5_0(), "iterators"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		add(current, "iterators", lv_iterators_6_0, "...", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibIterationCS1515); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            match(input,25,FollowSets000.FOLLOW_25_in_ruleLibIterationCS1525); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getColonKeyword_7(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:850:1: ( (lv_type_9_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:851:1: (lv_type_9_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:851:1: (lv_type_9_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:852:3: lv_type_9_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1546);
            lv_type_9_0=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_9_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleLibIterationCS1556); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:878:1: ( (lv_class_11_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:879:1: (lv_class_11_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:879:1: (lv_class_11_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:880:3: lv_class_11_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_11_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1573); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0(), "class"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibIterationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"class",
              	        		lv_class_11_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleLibIterationCS1588); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11(), null); 
                  
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
    // $ANTLR end ruleLibIterationCS


    // $ANTLR start entryRuleLibOperationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:914:1: entryRuleLibOperationCS returns [EObject current=null] : iv_ruleLibOperationCS= ruleLibOperationCS EOF ;
    public final EObject entryRuleLibOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibOperationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:915:2: (iv_ruleLibOperationCS= ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:916:2: iv_ruleLibOperationCS= ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibOperationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1624);
            iv_ruleLibOperationCS=ruleLibOperationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibOperationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS1634); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibOperationCS


    // $ANTLR start ruleLibOperationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:923:1: ruleLibOperationCS returns [EObject current=null] : ( ( (lv_isStatic_0_0= 'static' ) )? 'operation' ( (lv_name_2_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_14_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibOperationCS() throws RecognitionException {
        EObject current = null;

        Token lv_isStatic_0_0=null;
        Token lv_class_16_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_typeParameters_4_0 = null;

        EObject lv_typeParameters_6_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_11_0 = null;

        EObject lv_type_14_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:928:6: ( ( ( (lv_isStatic_0_0= 'static' ) )? 'operation' ( (lv_name_2_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_14_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:929:1: ( ( (lv_isStatic_0_0= 'static' ) )? 'operation' ( (lv_name_2_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_14_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:929:1: ( ( (lv_isStatic_0_0= 'static' ) )? 'operation' ( (lv_name_2_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_14_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:929:2: ( (lv_isStatic_0_0= 'static' ) )? 'operation' ( (lv_name_2_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_14_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:929:2: ( (lv_isStatic_0_0= 'static' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:930:1: (lv_isStatic_0_0= 'static' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:930:1: (lv_isStatic_0_0= 'static' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:931:3: lv_isStatic_0_0= 'static'
                    {
                    lv_isStatic_0_0=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibOperationCS1677); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0(), "isStatic"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isStatic", true, "static", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,19,FollowSets000.FOLLOW_19_in_ruleLibOperationCS1701); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getOperationKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:954:1: ( (lv_name_2_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:955:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:955:1: (lv_name_2_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:956:3: lv_name_2_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getNameIdentifierParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibOperationCS1722);
            lv_name_2_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:978:2: ( '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:978:4: '<' ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibOperationCS1733); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:982:1: ( (lv_typeParameters_4_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:983:1: (lv_typeParameters_4_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:983:1: (lv_typeParameters_4_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:984:3: lv_typeParameters_4_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1754);
                    lv_typeParameters_4_0=ruleLibTypeParameterCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeParameters",
                      	        		lv_typeParameters_4_0, 
                      	        		"LibTypeParameterCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1006:2: ( ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==27) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1006:4: ',' ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibOperationCS1765); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_3_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1010:1: ( (lv_typeParameters_6_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1011:1: (lv_typeParameters_6_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1011:1: (lv_typeParameters_6_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1012:3: lv_typeParameters_6_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1786);
                    	    lv_typeParameters_6_0=ruleLibTypeParameterCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeParameters",
                    	      	        		lv_typeParameters_6_0, 
                    	      	        		"LibTypeParameterCS", 
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
                    	    break loop14;
                        }
                    } while (true);

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleLibOperationCS1798); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_3_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibOperationCS1810); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1042:1: ( ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID_TERMINAL||LA17_0==11||(LA17_0>=15 && LA17_0<=24)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1042:2: ( (lv_parameters_9_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1042:2: ( (lv_parameters_9_0= ruleLibParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1043:1: (lv_parameters_9_0= ruleLibParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1043:1: (lv_parameters_9_0= ruleLibParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1044:3: lv_parameters_9_0= ruleLibParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1832);
                    lv_parameters_9_0=ruleLibParameterCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"parameters",
                      	        		lv_parameters_9_0, 
                      	        		"LibParameterCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1066:2: ( ',' ( (lv_parameters_11_0= ruleLibParameterCS ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==27) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1066:4: ',' ( (lv_parameters_11_0= ruleLibParameterCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibOperationCS1843); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1070:1: ( (lv_parameters_11_0= ruleLibParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1071:1: (lv_parameters_11_0= ruleLibParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1071:1: (lv_parameters_11_0= ruleLibParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1072:3: lv_parameters_11_0= ruleLibParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1864);
                    	    lv_parameters_11_0=ruleLibParameterCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"parameters",
                    	      	        		lv_parameters_11_0, 
                    	      	        		"LibParameterCS", 
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
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibOperationCS1878); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            match(input,25,FollowSets000.FOLLOW_25_in_ruleLibOperationCS1888); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getColonKeyword_7(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1102:1: ( (lv_type_14_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1103:1: (lv_type_14_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1103:1: (lv_type_14_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1104:3: lv_type_14_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS1909);
            lv_type_14_0=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_14_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleLibOperationCS1919); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_9(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1130:1: ( (lv_class_16_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1131:1: (lv_class_16_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1131:1: (lv_class_16_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1132:3: lv_class_16_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_16_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS1936); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0(), "class"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibOperationCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"class",
              	        		lv_class_16_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleLibOperationCS1951); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_11(), null); 
                  
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
    // $ANTLR end ruleLibOperationCS


    // $ANTLR start entryRuleLibPackageCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1166:1: entryRuleLibPackageCS returns [EObject current=null] : iv_ruleLibPackageCS= ruleLibPackageCS EOF ;
    public final EObject entryRuleLibPackageCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPackageCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1167:2: (iv_ruleLibPackageCS= ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1168:2: iv_ruleLibPackageCS= ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPackageCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS1987);
            iv_ruleLibPackageCS=ruleLibPackageCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPackageCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS1997); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibPackageCS


    // $ANTLR start ruleLibPackageCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1175:1: ruleLibPackageCS returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) ;
    public final EObject ruleLibPackageCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_subpackages_3_0 = null;

        EObject lv_classifiers_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1180:6: ( ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1181:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1181:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1181:3: 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}'
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleLibPackageCS2032); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1185:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1186:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1186:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1187:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibPackageCS2053);
            lv_name_1_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibPackageCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibPackageCS2063); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1213:1: ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==20) ) {
                    alt18=1;
                }
                else if ( (LA18_0==24) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1213:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1213:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1214:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1214:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1215:3: lv_subpackages_3_0= ruleLibPackageCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2085);
            	    lv_subpackages_3_0=ruleLibPackageCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibPackageCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"subpackages",
            	      	        		lv_subpackages_3_0, 
            	      	        		"LibPackageCS", 
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1238:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1238:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1239:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1239:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1240:3: lv_classifiers_4_0= ruleLibClassifierCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2112);
            	    lv_classifiers_4_0=ruleLibClassifierCS();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLibPackageCSRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"classifiers",
            	      	        		lv_classifiers_4_0, 
            	      	        		"LibClassifierCS", 
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
            	    break loop18;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibPackageCS2124); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4(), null); 
                  
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
    // $ANTLR end ruleLibPackageCS


    // $ANTLR start entryRuleLibParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1274:1: entryRuleLibParameterCS returns [EObject current=null] : iv_ruleLibParameterCS= ruleLibParameterCS EOF ;
    public final EObject entryRuleLibParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1275:2: (iv_ruleLibParameterCS= ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1276:2: iv_ruleLibParameterCS= ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2160);
            iv_ruleLibParameterCS=ruleLibParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS2170); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibParameterCS


    // $ANTLR start ruleLibParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1283:1: ruleLibParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) ;
    public final EObject ruleLibParameterCS() throws RecognitionException {
        EObject current = null;

        Token lv_multiplicity_7_1=null;
        Token lv_multiplicity_7_2=null;
        Token lv_multiplicity_7_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_lower_4_0 = null;

        AntlrDatatypeRuleToken lv_upper_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1288:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:2: ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1290:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1290:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1291:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibParameterCS2216);
            lv_name_0_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleLibParameterCS2226); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibParameterCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1317:1: ( (lv_type_2_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1318:1: (lv_type_2_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1318:1: (lv_type_2_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1319:3: lv_type_2_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2247);
            lv_type_2_0=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_2_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1341:2: ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1341:4: '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_ruleLibParameterCS2258); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1345:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_INT) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==14||(LA21_0>=36 && LA21_0<=37)) ) {
                        alt21=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1345:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1345:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1345:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1345:3: ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1345:3: ( (lv_lower_4_0= ruleLOWER ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1346:1: (lv_lower_4_0= ruleLOWER )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1346:1: (lv_lower_4_0= ruleLOWER )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1347:3: lv_lower_4_0= ruleLOWER
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleLibParameterCS2281);
                            lv_lower_4_0=ruleLOWER();
                            _fsp--;
                            if (failed) return current;
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode.getParent(), current);
                              	        }
                              	        try {
                              	       		set(
                              	       			current, 
                              	       			"lower",
                              	        		lv_lower_4_0, 
                              	        		"LOWER", 
                              	        		currentNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	        currentNode = currentNode.getParent();
                              	    
                            }

                            }


                            }

                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1369:2: ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==35) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1369:4: '..' ( (lv_upper_6_0= ruleUPPER ) )
                                    {
                                    match(input,35,FollowSets000.FOLLOW_35_in_ruleLibParameterCS2292); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1373:1: ( (lv_upper_6_0= ruleUPPER ) )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1374:1: (lv_upper_6_0= ruleUPPER )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1374:1: (lv_upper_6_0= ruleUPPER )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1375:3: lv_upper_6_0= ruleUPPER
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleLibParameterCS2313);
                                    lv_upper_6_0=ruleUPPER();
                                    _fsp--;
                                    if (failed) return current;
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                                      	        }
                                      	        try {
                                      	       		set(
                                      	       			current, 
                                      	       			"upper",
                                      	        		lv_upper_6_0, 
                                      	        		"UPPER", 
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
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1398:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1398:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1399:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1399:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1400:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1400:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            int alt20=3;
                            switch ( input.LA(1) ) {
                            case 14:
                                {
                                alt20=1;
                                }
                                break;
                            case 36:
                                {
                                alt20=2;
                                }
                                break;
                            case 37:
                                {
                                alt20=3;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1400:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )", 20, 0, input);

                                throw nvae;
                            }

                            switch (alt20) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1401:3: lv_multiplicity_7_1= '*'
                                    {
                                    lv_multiplicity_7_1=(Token)input.LT(1);
                                    match(input,14,FollowSets000.FOLLOW_14_in_ruleLibParameterCS2342); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0(), "multiplicity"); 
                                          
                                    }
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode, current);
                                      	        }
                                      	        
                                      	        try {
                                      	       		set(current, "multiplicity", lv_multiplicity_7_1, null, lastConsumedNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1419:8: lv_multiplicity_7_2= '+'
                                    {
                                    lv_multiplicity_7_2=(Token)input.LT(1);
                                    match(input,36,FollowSets000.FOLLOW_36_in_ruleLibParameterCS2371); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1(), "multiplicity"); 
                                          
                                    }
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode, current);
                                      	        }
                                      	        
                                      	        try {
                                      	       		set(current, "multiplicity", lv_multiplicity_7_2, null, lastConsumedNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	    
                                    }

                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1437:8: lv_multiplicity_7_3= '?'
                                    {
                                    lv_multiplicity_7_3=(Token)input.LT(1);
                                    match(input,37,FollowSets000.FOLLOW_37_in_ruleLibParameterCS2400); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2(), "multiplicity"); 
                                          
                                    }
                                    if ( backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = factory.create(grammarAccess.getLibParameterCSRule().getType().getClassifier());
                                      	            associateNodeWithAstElement(currentNode, current);
                                      	        }
                                      	        
                                      	        try {
                                      	       		set(current, "multiplicity", lv_multiplicity_7_3, null, lastConsumedNode);
                                      	        } catch (ValueConverterException vce) {
                                      				handleValueConverterException(vce);
                                      	        }
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }

                    match(input,38,FollowSets000.FOLLOW_38_in_ruleLibParameterCS2427); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2(), null); 
                          
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
    // $ANTLR end ruleLibParameterCS


    // $ANTLR start entryRuleLibPropertyCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1470:1: entryRuleLibPropertyCS returns [EObject current=null] : iv_ruleLibPropertyCS= ruleLibPropertyCS EOF ;
    public final EObject entryRuleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPropertyCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1471:2: (iv_ruleLibPropertyCS= ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1472:2: iv_ruleLibPropertyCS= ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPropertyCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2465);
            iv_ruleLibPropertyCS=ruleLibPropertyCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPropertyCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS2475); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibPropertyCS


    // $ANTLR start ruleLibPropertyCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1479:1: ruleLibPropertyCS returns [EObject current=null] : ( ( (lv_isStatic_0_0= 'static' ) )? 'property' ( (lv_name_2_0= ruleIdentifier ) ) ':' ( (lv_type_4_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        Token lv_isStatic_0_0=null;
        Token lv_class_6_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_type_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1484:6: ( ( ( (lv_isStatic_0_0= 'static' ) )? 'property' ( (lv_name_2_0= ruleIdentifier ) ) ':' ( (lv_type_4_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1485:1: ( ( (lv_isStatic_0_0= 'static' ) )? 'property' ( (lv_name_2_0= ruleIdentifier ) ) ':' ( (lv_type_4_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1485:1: ( ( (lv_isStatic_0_0= 'static' ) )? 'property' ( (lv_name_2_0= ruleIdentifier ) ) ':' ( (lv_type_4_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1485:2: ( (lv_isStatic_0_0= 'static' ) )? 'property' ( (lv_name_2_0= ruleIdentifier ) ) ':' ( (lv_type_4_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1485:2: ( (lv_isStatic_0_0= 'static' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==22) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1486:1: (lv_isStatic_0_0= 'static' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1486:1: (lv_isStatic_0_0= 'static' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1487:3: lv_isStatic_0_0= 'static'
                    {
                    lv_isStatic_0_0=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibPropertyCS2518); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0(), "isStatic"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibPropertyCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "isStatic", true, "static", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,21,FollowSets000.FOLLOW_21_in_ruleLibPropertyCS2542); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1510:1: ( (lv_name_2_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1511:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1511:1: (lv_name_2_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1512:3: lv_name_2_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getNameIdentifierParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibPropertyCS2563);
            lv_name_2_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibPropertyCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_2_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,25,FollowSets000.FOLLOW_25_in_ruleLibPropertyCS2573); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getColonKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1538:1: ( (lv_type_4_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1539:1: (lv_type_4_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1539:1: (lv_type_4_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1540:3: lv_type_4_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2594);
            lv_type_4_0=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibPropertyCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_4_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleLibPropertyCS2604); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_5(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1566:1: ( (lv_class_6_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1567:1: (lv_class_6_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1567:1: (lv_class_6_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1568:3: lv_class_6_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_6_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2621); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_6_0(), "class"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibPropertyCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"class",
              	        		lv_class_6_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,33,FollowSets000.FOLLOW_33_in_ruleLibPropertyCS2636); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7(), null); 
                  
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
    // $ANTLR end ruleLibPropertyCS


    // $ANTLR start entryRuleLibQualifiedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1602:1: entryRuleLibQualifiedTypeRefCS returns [EObject current=null] : iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF ;
    public final EObject entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibQualifiedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1603:2: (iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1604:2: iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2672);
            iv_ruleLibQualifiedTypeRefCS=ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibQualifiedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2682); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibQualifiedTypeRefCS


    // $ANTLR start ruleLibQualifiedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1611:1: ruleLibQualifiedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) ) ;
    public final EObject ruleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_type_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1616:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1617:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1617:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1617:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1617:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1618:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1618:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1619:3: ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getLibQualifiedTypeRefCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2734);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1636:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==26) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1636:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibQualifiedTypeRefCS2745); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1640:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1641:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1641:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1642:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2766);
                    lv_typeArguments_2_0=ruleLibTypeRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibQualifiedTypeRefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeArguments",
                      	        		lv_typeArguments_2_0, 
                      	        		"LibTypeRefCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1664:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==27) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1664:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibQualifiedTypeRefCS2777); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1668:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1669:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1669:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1670:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2798);
                    	    lv_typeArguments_4_0=ruleLibTypeRefCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibQualifiedTypeRefCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeArguments",
                    	      	        		lv_typeArguments_4_0, 
                    	      	        		"LibTypeRefCS", 
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
                    	    break loop24;
                        }
                    } while (true);

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleLibQualifiedTypeRefCS2810); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,39,FollowSets000.FOLLOW_39_in_ruleLibQualifiedTypeRefCS2822); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1700:1: ( (lv_type_7_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1701:1: (lv_type_7_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1701:1: (lv_type_7_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1702:3: lv_type_7_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS2843);
            lv_type_7_0=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibQualifiedTypeRefCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"type",
              	        		lv_type_7_0, 
              	        		"LibTypedRefCS", 
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
    // $ANTLR end ruleLibQualifiedTypeRefCS


    // $ANTLR start entryRuleLibTypeParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1732:1: entryRuleLibTypeParameterCS returns [EObject current=null] : iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF ;
    public final EObject entryRuleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1733:2: (iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1734:2: iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS2879);
            iv_ruleLibTypeParameterCS=ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS2889); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibTypeParameterCS


    // $ANTLR start ruleLibTypeParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1741:1: ruleLibTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_extends_2_0 = null;

        EObject lv_extends_4_0 = null;

        EObject lv_super_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1746:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1747:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1747:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1747:2: ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1747:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1748:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1748:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1749:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS2935);
            lv_name_0_0=ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLibTypeParameterCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_0_0, 
              	        		"Identifier", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1771:2: ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==16) ) {
                alt27=1;
            }
            else if ( (LA27_0==23) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1771:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1771:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1771:5: 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibTypeParameterCS2947); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1775:1: ( (lv_extends_2_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1776:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1776:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1777:3: lv_extends_2_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS2968);
                    lv_extends_2_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibTypeParameterCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"extends",
                      	        		lv_extends_2_0, 
                      	        		"LibTypedRefCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1799:2: ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==40) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1799:4: '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,40,FollowSets000.FOLLOW_40_in_ruleLibTypeParameterCS2979); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1803:1: ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1804:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1804:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1805:3: lv_extends_4_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3000);
                    	    lv_extends_4_0=ruleLibTypedRefCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibTypeParameterCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"extends",
                    	      	        		lv_extends_4_0, 
                    	      	        		"LibTypedRefCS", 
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
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1828:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1828:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1828:8: 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleLibTypeParameterCS3020); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1832:1: ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1833:1: (lv_super_6_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1833:1: (lv_super_6_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:3: lv_super_6_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3041);
                    lv_super_6_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibTypeParameterCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"super",
                      	        		lv_super_6_0, 
                      	        		"LibTypedRefCS", 
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
    // $ANTLR end ruleLibTypeParameterCS


    // $ANTLR start entryRuleLibTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1864:1: entryRuleLibTypeRefCS returns [EObject current=null] : iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF ;
    public final EObject entryRuleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1865:2: (iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1866:2: iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3080);
            iv_ruleLibTypeRefCS=ruleLibTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS3090); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibTypeRefCS


    // $ANTLR start ruleLibTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1873:1: ruleLibTypeRefCS returns [EObject current=null] : (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) ;
    public final EObject ruleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibTypedRefCS_0 = null;

        EObject this_LibWildcardTypeRefCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1878:6: ( (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1879:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1879:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID_TERMINAL||LA28_0==11||(LA28_0>=15 && LA28_0<=24)) ) {
                alt28=1;
            }
            else if ( (LA28_0==37) ) {
                alt28=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1879:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1880:2: this_LibTypedRefCS_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3140);
                    this_LibTypedRefCS_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LibTypedRefCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1893:2: this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3170);
                    this_LibWildcardTypeRefCS_1=ruleLibWildcardTypeRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LibWildcardTypeRefCS_1; 
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
    // $ANTLR end ruleLibTypeRefCS


    // $ANTLR start entryRuleLibTypedRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1912:1: entryRuleLibTypedRefCS returns [EObject current=null] : iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF ;
    public final EObject entryRuleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1913:2: (iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1914:2: iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3205);
            iv_ruleLibTypedRefCS=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS3215); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibTypedRefCS


    // $ANTLR start ruleLibTypedRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1921:1: ruleLibTypedRefCS returns [EObject current=null] : (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) ;
    public final EObject ruleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibQualifiedTypeRefCS_0 = null;

        EObject this_LibTypedTypeRefCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1926:6: ( (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            int alt29=2;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                int LA29_1 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA29_2 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA29_3 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA29_5 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 5, input);

                    throw nvae;
                }
                }
                break;
            case 11:
                {
                int LA29_6 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 6, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA29_7 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 7, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA29_8 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 8, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA29_9 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 9, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA29_10 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 10, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                int LA29_11 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 11, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                int LA29_12 = input.LA(2);

                if ( (synpred44()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 12, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1927:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1928:2: this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3265);
                    this_LibQualifiedTypeRefCS_0=ruleLibQualifiedTypeRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LibQualifiedTypeRefCS_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1941:2: this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3295);
                    this_LibTypedTypeRefCS_1=ruleLibTypedTypeRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LibTypedTypeRefCS_1; 
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
    // $ANTLR end ruleLibTypedRefCS


    // $ANTLR start entryRuleLibTypedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1960:1: entryRuleLibTypedTypeRefCS returns [EObject current=null] : iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF ;
    public final EObject entryRuleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1961:2: (iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1962:2: iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3330);
            iv_ruleLibTypedTypeRefCS=ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3340); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibTypedTypeRefCS


    // $ANTLR start ruleLibTypedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1969:1: ruleLibTypedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) ;
    public final EObject ruleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1974:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1975:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1975:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1975:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1975:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1976:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1976:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1977:3: ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getLibTypedTypeRefCSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3392);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1994:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==26) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1994:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibTypedTypeRefCS3403); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1998:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1999:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1999:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2000:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3424);
                    lv_typeArguments_2_0=ruleLibTypeRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibTypedTypeRefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"typeArguments",
                      	        		lv_typeArguments_2_0, 
                      	        		"LibTypeRefCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2022:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==27) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2022:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibTypedTypeRefCS3435); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2026:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2027:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2027:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2028:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3456);
                    	    lv_typeArguments_4_0=ruleLibTypeRefCS();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getLibTypedTypeRefCSRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"typeArguments",
                    	      	        		lv_typeArguments_4_0, 
                    	      	        		"LibTypeRefCS", 
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
                    	    break loop30;
                        }
                    } while (true);

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleLibTypedTypeRefCS3468); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
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
    // $ANTLR end ruleLibTypedTypeRefCS


    // $ANTLR start entryRuleLibWildcardTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2062:1: entryRuleLibWildcardTypeRefCS returns [EObject current=null] : iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF ;
    public final EObject entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibWildcardTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2063:2: (iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2064:2: iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibWildcardTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3506);
            iv_ruleLibWildcardTypeRefCS=ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3516); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLibWildcardTypeRefCS


    // $ANTLR start ruleLibWildcardTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2071:1: ruleLibWildcardTypeRefCS returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2076:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2077:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2077:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2077:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2077:2: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2078:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,37,FollowSets000.FOLLOW_37_in_ruleLibWildcardTypeRefCS3563); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2095:1: ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            else if ( (LA32_0==23) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2095:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2095:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2095:4: 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibWildcardTypeRefCS3575); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2099:1: ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2100:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2100:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2101:3: lv_extends_3_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3596);
                    lv_extends_3_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibWildcardTypeRefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"extends",
                      	        		lv_extends_3_0, 
                      	        		"LibTypedRefCS", 
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2124:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2124:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2124:8: 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleLibWildcardTypeRefCS3614); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2128:1: ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2129:1: (lv_super_5_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2129:1: (lv_super_5_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2130:3: lv_super_5_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3635);
                    lv_super_5_0=ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getLibWildcardTypeRefCSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"super",
                      	        		lv_super_5_0, 
                      	        		"LibTypedRefCS", 
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
    // $ANTLR end ruleLibWildcardTypeRefCS

    // $ANTLR start synpred44
    public final void synpred44_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1928:2: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1928:2: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred443265);
        ruleLibQualifiedTypeRefCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred44

    public final boolean synpred44() {
        backtracking++;
        int start = input.mark();
        try {
            synpred44_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibrary91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleLibrary126 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibrary147 = new BitSet(new long[]{0x0000000000021000L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_ruleLibrary168 = new BitSet(new long[]{0x0000000000021000L});
        public static final BitSet FOLLOW_12_in_ruleLibrary179 = new BitSet(new long[]{0x0000000000102000L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_ruleLibrary200 = new BitSet(new long[]{0x0000000000102000L});
        public static final BitSet FOLLOW_13_in_ruleLibrary211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER343 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleUPPER418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier459 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_TERMINAL_in_ruleIdentifier510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleIdentifier534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleIdentifier553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleIdentifier572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleIdentifier591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleIdentifier610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleIdentifier629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIdentifier648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleIdentifier667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleIdentifier686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleIdentifier705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleIdentifier724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS766 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLibImportCS811 = new BitSet(new long[]{0x0000000001FF8860L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibImportCS833 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibImportCS843 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS903 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleLibClassCS948 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibClassCS969 = new BitSet(new long[]{0x0000000004009000L});
        public static final BitSet FOLLOW_26_in_ruleLibClassCS980 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1001 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleLibClassCS1012 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1033 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleLibClassCS1045 = new BitSet(new long[]{0x0000000000009000L});
        public static final BitSet FOLLOW_15_in_ruleLibClassCS1058 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1079 = new BitSet(new long[]{0x0000000008001000L});
        public static final BitSet FOLLOW_27_in_ruleLibClassCS1090 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1111 = new BitSet(new long[]{0x0000000008001000L});
        public static final BitSet FOLLOW_12_in_ruleLibClassCS1125 = new BitSet(new long[]{0x00000000006C2000L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1147 = new BitSet(new long[]{0x00000000006C2000L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1174 = new BitSet(new long[]{0x00000000006C2000L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1201 = new BitSet(new long[]{0x00000000006C2000L});
        public static final BitSet FOLLOW_13_in_ruleLibClassCS1213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS1259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS1352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleLibIterationCS1387 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibIterationCS1408 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleLibIterationCS1418 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibIterationCS1439 = new BitSet(new long[]{0x00000000C8000000L});
        public static final BitSet FOLLOW_27_in_ruleLibIterationCS1450 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibIterationCS1471 = new BitSet(new long[]{0x00000000C8000000L});
        public static final BitSet FOLLOW_30_in_ruleLibIterationCS1491 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibIterationCS1515 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibIterationCS1525 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1546 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLibIterationCS1556 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1573 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLibIterationCS1588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1624 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS1634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibOperationCS1677 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleLibOperationCS1701 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibOperationCS1722 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_26_in_ruleLibOperationCS1733 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1754 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleLibOperationCS1765 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1786 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleLibOperationCS1798 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleLibOperationCS1810 = new BitSet(new long[]{0x0000000081FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1832 = new BitSet(new long[]{0x0000000088000000L});
        public static final BitSet FOLLOW_27_in_ruleLibOperationCS1843 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1864 = new BitSet(new long[]{0x0000000088000000L});
        public static final BitSet FOLLOW_31_in_ruleLibOperationCS1878 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibOperationCS1888 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS1909 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLibOperationCS1919 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS1936 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLibOperationCS1951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS1987 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS1997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleLibPackageCS2032 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibPackageCS2053 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLibPackageCS2063 = new BitSet(new long[]{0x0000000001102000L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2085 = new BitSet(new long[]{0x0000000001102000L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2112 = new BitSet(new long[]{0x0000000001102000L});
        public static final BitSet FOLLOW_13_in_ruleLibPackageCS2124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS2170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibParameterCS2216 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibParameterCS2226 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2247 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleLibParameterCS2258 = new BitSet(new long[]{0x0000003000004010L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleLibParameterCS2281 = new BitSet(new long[]{0x0000004800000000L});
        public static final BitSet FOLLOW_35_in_ruleLibParameterCS2292 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleLibParameterCS2313 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_14_in_ruleLibParameterCS2342 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_36_in_ruleLibParameterCS2371 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_37_in_ruleLibParameterCS2400 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleLibParameterCS2427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2465 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS2475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibPropertyCS2518 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleLibPropertyCS2542 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibPropertyCS2563 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibPropertyCS2573 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2594 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLibPropertyCS2604 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2621 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLibPropertyCS2636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2734 = new BitSet(new long[]{0x0000008004000000L});
        public static final BitSet FOLLOW_26_in_ruleLibQualifiedTypeRefCS2745 = new BitSet(new long[]{0x0000002001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2766 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleLibQualifiedTypeRefCS2777 = new BitSet(new long[]{0x0000002001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2798 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleLibQualifiedTypeRefCS2810 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleLibQualifiedTypeRefCS2822 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS2843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS2879 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS2935 = new BitSet(new long[]{0x0000000000810002L});
        public static final BitSet FOLLOW_16_in_ruleLibTypeParameterCS2947 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS2968 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleLibTypeParameterCS2979 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3000 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_23_in_ruleLibTypeParameterCS3020 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS3090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3205 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS3215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3392 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleLibTypedTypeRefCS3403 = new BitSet(new long[]{0x0000002001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3424 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_27_in_ruleLibTypedTypeRefCS3435 = new BitSet(new long[]{0x0000002001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3456 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_28_in_ruleLibTypedTypeRefCS3468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3506 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleLibWildcardTypeRefCS3563 = new BitSet(new long[]{0x0000000000810002L});
        public static final BitSet FOLLOW_16_in_ruleLibWildcardTypeRefCS3575 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleLibWildcardTypeRefCS3614 = new BitSet(new long[]{0x0000000001FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred443265 = new BitSet(new long[]{0x0000000000000002L});
    }


}