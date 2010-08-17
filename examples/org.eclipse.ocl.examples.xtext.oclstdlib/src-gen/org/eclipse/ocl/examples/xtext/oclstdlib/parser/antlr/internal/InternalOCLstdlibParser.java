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
@SuppressWarnings("all")
public class InternalOCLstdlibParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'library'", "'{'", "'}'", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'operation'", "'package'", "'property'", "'super'", "'type'", "':'", "'<'", "','", "'>'", "'('", "')'", "'=>'", "';'", "'['", "'..'", "'+'", "'?'", "']'", "'::'", "'&&'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[87+1];
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:266:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_RestrictedKeywords_1 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:271:6: ( (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==11||(LA4_0>=15 && LA4_0<=23)) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("272:1: (this_ID_0= RULE_ID | this_RestrictedKeywords_1= ruleRestrictedKeywords )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdentifier510); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:281:5: this_RestrictedKeywords_1= ruleRestrictedKeywords
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRestrictedKeywords_in_ruleIdentifier543);
                    this_RestrictedKeywords_1=ruleRestrictedKeywords();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_RestrictedKeywords_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
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
    // $ANTLR end ruleIdentifier


    // $ANTLR start entryRuleRestrictedKeywords
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:299:1: entryRuleRestrictedKeywords returns [String current=null] : iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF ;
    public final String entryRuleRestrictedKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRestrictedKeywords = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:300:2: (iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:301:2: iv_ruleRestrictedKeywords= ruleRestrictedKeywords EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRestrictedKeywordsRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRestrictedKeywords_in_entryRuleRestrictedKeywords589);
            iv_ruleRestrictedKeywords=ruleRestrictedKeywords();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRestrictedKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRestrictedKeywords600); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleRestrictedKeywords


    // $ANTLR start ruleRestrictedKeywords
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:308:1: ruleRestrictedKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' ) ;
    public final AntlrDatatypeRuleToken ruleRestrictedKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:313:6: ( (kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:314:1: (kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:314:1: (kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )
            int alt5=10;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 16:
                {
                alt5=2;
                }
                break;
            case 17:
                {
                alt5=3;
                }
                break;
            case 18:
                {
                alt5=4;
                }
                break;
            case 11:
                {
                alt5=5;
                }
                break;
            case 19:
                {
                alt5=6;
                }
                break;
            case 20:
                {
                alt5=7;
                }
                break;
            case 21:
                {
                alt5=8;
                }
                break;
            case 22:
                {
                alt5=9;
                }
                break;
            case 23:
                {
                alt5=10;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("314:1: (kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:315:2: kw= 'conformsTo'
                    {
                    kw=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleRestrictedKeywords638); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:322:2: kw= 'extends'
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleRestrictedKeywords657); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_1(), null); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:329:2: kw= 'import'
                    {
                    kw=(Token)input.LT(1);
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleRestrictedKeywords676); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_2(), null); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:336:2: kw= 'iteration'
                    {
                    kw=(Token)input.LT(1);
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleRestrictedKeywords695); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_3(), null); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:343:2: kw= 'library'
                    {
                    kw=(Token)input.LT(1);
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleRestrictedKeywords714); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_4(), null); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:350:2: kw= 'operation'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleRestrictedKeywords733); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_5(), null); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:357:2: kw= 'package'
                    {
                    kw=(Token)input.LT(1);
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleRestrictedKeywords752); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_6(), null); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:364:2: kw= 'property'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleRestrictedKeywords771); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_7(), null); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:371:2: kw= 'super'
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleRestrictedKeywords790); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getSuperKeyword_8(), null); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:378:2: kw= 'type'
                    {
                    kw=(Token)input.LT(1);
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleRestrictedKeywords809); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_9(), null); 
                          
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
    // $ANTLR end ruleRestrictedKeywords


    // $ANTLR start entryRuleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:391:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:392:2: (iv_ruleName= ruleName EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:393:2: iv_ruleName= ruleName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNameRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_entryRuleName850);
            iv_ruleName=ruleName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleName861); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleName


    // $ANTLR start ruleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:400:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_QUOTED_STRING_1=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:405:6: ( (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:406:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:406:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==11||(LA6_0>=15 && LA6_0<=23)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_DOUBLE_QUOTED_STRING) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("406:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:407:5: this_Identifier_0= ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleName908);
                    this_Identifier_0=ruleIdentifier();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_Identifier_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:418:10: this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING
                    {
                    this_DOUBLE_QUOTED_STRING_1=(Token)input.LT(1);
                    match(input,RULE_DOUBLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleName934); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_DOUBLE_QUOTED_STRING_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1(), null); 
                          
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
    // $ANTLR end ruleName


    // $ANTLR start entryRuleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:433:1: entryRuleLibImportCS returns [EObject current=null] : iv_ruleLibImportCS= ruleLibImportCS EOF ;
    public final EObject entryRuleLibImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibImportCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:434:2: (iv_ruleLibImportCS= ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:435:2: iv_ruleLibImportCS= ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibImportCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS979);
            iv_ruleLibImportCS=ruleLibImportCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS989); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:442:1: ruleLibImportCS returns [EObject current=null] : ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) ;
    public final EObject ruleLibImportCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:447:6: ( ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:448:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:448:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:448:3: 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleLibImportCS1024); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibImportCSAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:452:1: ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||LA7_0==11||(LA7_0>=15 && LA7_0<=23)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:452:2: ( (lv_name_1_0= ruleIdentifier ) ) ':'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:452:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:453:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:453:1: (lv_name_1_0= ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:454:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibImportCS1046);
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

                    match(input,24,FollowSets000.FOLLOW_24_in_ruleLibImportCS1056); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:480:3: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:481:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:481:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:482:3: RULE_SINGLE_QUOTED_STRING
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
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS1080); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:505:1: entryRuleLibClassCS returns [EObject current=null] : iv_ruleLibClassCS= ruleLibClassCS EOF ;
    public final EObject entryRuleLibClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:506:2: (iv_ruleLibClassCS= ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:507:2: iv_ruleLibClassCS= ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS1116);
            iv_ruleLibClassCS=ruleLibClassCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS1126); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:514:1: ruleLibClassCS returns [EObject current=null] : ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )* '}' ) ;
    public final EObject ruleLibClassCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_conformsTo_8_0 = null;

        EObject lv_conformsTo_10_0 = null;

        EObject lv_operations_12_1 = null;

        EObject lv_operations_12_2 = null;

        EObject lv_structuralFeatures_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:519:6: ( ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:520:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:520:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:520:3: 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )* '}'
            {
            match(input,23,FollowSets000.FOLLOW_23_in_ruleLibClassCS1161); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getTypeKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:524:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:525:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:525:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:526:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibClassCS1182);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:548:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:548:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibClassCS1193); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:552:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:553:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:553:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:554:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1214);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:576:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:576:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibClassCS1225); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:580:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:581:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:581:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:582:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1246);
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
                    	    break loop8;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibClassCS1258); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:608:3: ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:608:5: 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleLibClassCS1271); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:612:1: ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:613:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:613:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:614:3: lv_conformsTo_8_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1292);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:636:2: ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==26) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:636:4: ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibClassCS1303); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:640:1: ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:641:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:641:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:642:3: lv_conformsTo_10_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1324);
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibClassCS1338); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:668:1: ( ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) ) | ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                    alt13=1;
                }
                else if ( (LA13_0==21) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:668:2: ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:668:2: ( ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:669:1: ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:669:1: ( (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:670:1: (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:670:1: (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==18) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==19) ) {
            	        alt12=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("670:1: (lv_operations_12_1= ruleLibIterationCS | lv_operations_12_2= ruleLibOperationCS )", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:671:3: lv_operations_12_1= ruleLibIterationCS
            	            {
            	            if ( backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getOperationsLibIterationCSParserRuleCall_5_0_0_0(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1362);
            	            lv_operations_12_1=ruleLibIterationCS();
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
            	              	        		lv_operations_12_1, 
            	              	        		"LibIterationCS", 
            	              	        		currentNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	        currentNode = currentNode.getParent();
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:692:8: lv_operations_12_2= ruleLibOperationCS
            	            {
            	            if ( backtracking==0 ) {
            	               
            	              	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_0_0_1(), currentNode); 
            	              	    
            	            }
            	            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1381);
            	            lv_operations_12_2=ruleLibOperationCS();
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
            	              	        		lv_operations_12_2, 
            	              	        		"LibOperationCS", 
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
            	case 2 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:717:6: ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:717:6: ( (lv_structuralFeatures_13_0= ruleLibPropertyCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:718:1: (lv_structuralFeatures_13_0= ruleLibPropertyCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:718:1: (lv_structuralFeatures_13_0= ruleLibPropertyCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:719:3: lv_structuralFeatures_13_0= ruleLibPropertyCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1411);
            	    lv_structuralFeatures_13_0=ruleLibPropertyCS();
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
            	      	        		lv_structuralFeatures_13_0, 
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
            	    break loop13;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibClassCS1423); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:753:1: entryRuleLibClassifierCS returns [EObject current=null] : iv_ruleLibClassifierCS= ruleLibClassifierCS EOF ;
    public final EObject entryRuleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:754:2: (iv_ruleLibClassifierCS= ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:755:2: iv_ruleLibClassifierCS= ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassifierCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1459);
            iv_ruleLibClassifierCS=ruleLibClassifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassifierCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS1469); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:762:1: ruleLibClassifierCS returns [EObject current=null] : this_LibClassCS_0= ruleLibClassCS ;
    public final EObject ruleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibClassCS_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:767:6: (this_LibClassCS_0= ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:769:2: this_LibClassCS_0= ruleLibClassCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1518);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:788:1: entryRuleLibIterationCS returns [EObject current=null] : iv_ruleLibIterationCS= ruleLibIterationCS EOF ;
    public final EObject entryRuleLibIterationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibIterationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:789:2: (iv_ruleLibIterationCS= ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:790:2: iv_ruleLibIterationCS= ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibIterationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1552);
            iv_ruleLibIterationCS=ruleLibIterationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibIterationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS1562); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:797:1: ruleLibIterationCS returns [EObject current=null] : ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibIterationCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_15_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_type_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:802:6: ( ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:803:1: ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:803:1: ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:803:3: 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleLibIterationCS1597); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:807:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:808:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:808:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:809:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibIterationCS1618);
            lv_name_1_0=ruleName();
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
              	        		"Name", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:831:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:831:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibIterationCS1629); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:835:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:836:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:836:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:837:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1650);
                    lv_typeParameters_3_0=ruleLibTypeParameterCS();
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:859:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==26) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:859:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibIterationCS1661); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:863:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:864:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:864:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:865:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1682);
                    	    lv_typeParameters_5_0=ruleLibTypeParameterCS();
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
                    	    break loop14;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibIterationCS1694); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleLibIterationCS1706); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:895:1: ( (lv_parameters_8_0= ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:896:1: (lv_parameters_8_0= ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:896:1: (lv_parameters_8_0= ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:897:3: lv_parameters_8_0= ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1727);
            lv_parameters_8_0=ruleLibParameterCS();
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
              	       			"parameters",
              	        		lv_parameters_8_0, 
              	        		"LibParameterCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:919:2: ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:919:4: ',' ( (lv_parameters_10_0= ruleLibParameterCS ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibIterationCS1738); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:923:1: ( (lv_parameters_10_0= ruleLibParameterCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:924:1: (lv_parameters_10_0= ruleLibParameterCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:924:1: (lv_parameters_10_0= ruleLibParameterCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:925:3: lv_parameters_10_0= ruleLibParameterCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1759);
            	    lv_parameters_10_0=ruleLibParameterCS();
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
            	      	       			"parameters",
            	      	        		lv_parameters_10_0, 
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

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibIterationCS1771); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibIterationCS1781); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getColonKeyword_7(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:955:1: ( (lv_type_13_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:956:1: (lv_type_13_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:956:1: (lv_type_13_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:957:3: lv_type_13_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1802);
            lv_type_13_0=ruleLibTypedRefCS();
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
              	        		lv_type_13_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibIterationCS1812); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:983:1: ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:984:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:984:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:985:3: lv_class_15_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_15_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1829); if (failed) return current;
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
              	        		lv_class_15_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibIterationCS1844); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1019:1: entryRuleLibOperationCS returns [EObject current=null] : iv_ruleLibOperationCS= ruleLibOperationCS EOF ;
    public final EObject entryRuleLibOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibOperationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1020:2: (iv_ruleLibOperationCS= ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1021:2: iv_ruleLibOperationCS= ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibOperationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1880);
            iv_ruleLibOperationCS=ruleLibOperationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibOperationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS1890); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1028:1: ruleLibOperationCS returns [EObject current=null] : ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibOperationCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_15_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_type_13_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1033:6: ( ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1034:1: ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1034:1: ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1034:3: 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleLibOperationCS1925); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1038:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1039:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1039:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1040:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibOperationCS1946);
            lv_name_1_0=ruleName();
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
              	        		lv_name_1_0, 
              	        		"Name", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1062:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==25) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1062:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibOperationCS1957); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1066:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1067:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1067:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1068:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1978);
                    lv_typeParameters_3_0=ruleLibTypeParameterCS();
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1090:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==26) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1090:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibOperationCS1989); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1094:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1095:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1095:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1096:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS2010);
                    	    lv_typeParameters_5_0=ruleLibTypeParameterCS();
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
                    	    break loop17;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibOperationCS2022); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleLibOperationCS2034); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1126:1: ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||LA20_0==11||(LA20_0>=15 && LA20_0<=23)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1126:2: ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1126:2: ( (lv_parameters_8_0= ruleLibParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1127:1: (lv_parameters_8_0= ruleLibParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1127:1: (lv_parameters_8_0= ruleLibParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1128:3: lv_parameters_8_0= ruleLibParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS2056);
                    lv_parameters_8_0=ruleLibParameterCS();
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
                      	        		lv_parameters_8_0, 
                      	        		"LibParameterCS", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1150:2: ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==26) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1150:4: ',' ( (lv_parameters_10_0= ruleLibParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibOperationCS2067); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1154:1: ( (lv_parameters_10_0= ruleLibParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1155:1: (lv_parameters_10_0= ruleLibParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1155:1: (lv_parameters_10_0= ruleLibParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1156:3: lv_parameters_10_0= ruleLibParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS2088);
                    	    lv_parameters_10_0=ruleLibParameterCS();
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
                    	      	        		lv_parameters_10_0, 
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
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibOperationCS2102); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5(), null); 
                  
            }
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibOperationCS2112); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getColonKeyword_6(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1186:1: ( (lv_type_13_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1187:1: (lv_type_13_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1187:1: (lv_type_13_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1188:3: lv_type_13_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS2133);
            lv_type_13_0=ruleLibTypedRefCS();
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
              	        		lv_type_13_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibOperationCS2143); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1214:1: ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1215:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1215:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1216:3: lv_class_15_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_15_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS2160); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0(), "class"); 
              		
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
              	        		lv_class_15_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibOperationCS2175); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10(), null); 
                  
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1250:1: entryRuleLibPackageCS returns [EObject current=null] : iv_ruleLibPackageCS= ruleLibPackageCS EOF ;
    public final EObject entryRuleLibPackageCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPackageCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1251:2: (iv_ruleLibPackageCS= ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1252:2: iv_ruleLibPackageCS= ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPackageCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS2211);
            iv_ruleLibPackageCS=ruleLibPackageCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPackageCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS2221); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1259:1: ruleLibPackageCS returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) ;
    public final EObject ruleLibPackageCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_subpackages_3_0 = null;

        EObject lv_classifiers_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1264:6: ( ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1265:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1265:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1265:3: 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}'
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleLibPackageCS2256); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1269:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1270:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1270:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1271:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibPackageCS2277);
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibPackageCS2287); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1297:1: ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==20) ) {
                    alt21=1;
                }
                else if ( (LA21_0==23) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1297:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1297:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1298:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1298:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1299:3: lv_subpackages_3_0= ruleLibPackageCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2309);
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1322:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1322:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1323:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1323:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1324:3: lv_classifiers_4_0= ruleLibClassifierCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2336);
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
            	    break loop21;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibPackageCS2348); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1358:1: entryRuleLibParameterCS returns [EObject current=null] : iv_ruleLibParameterCS= ruleLibParameterCS EOF ;
    public final EObject entryRuleLibParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1359:2: (iv_ruleLibParameterCS= ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1360:2: iv_ruleLibParameterCS= ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2384);
            iv_ruleLibParameterCS=ruleLibParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS2394); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1367:1: ruleLibParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) ;
    public final EObject ruleLibParameterCS() throws RecognitionException {
        EObject current = null;

        Token lv_multiplicity_7_1=null;
        Token lv_multiplicity_7_2=null;
        Token lv_multiplicity_7_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_lower_4_0 = null;

        AntlrDatatypeRuleToken lv_upper_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1372:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1373:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1373:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1373:2: ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1373:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1374:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1374:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1375:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibParameterCS2440);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibParameterCS2450); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibParameterCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1401:1: ( (lv_type_2_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1402:1: (lv_type_2_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1402:1: (lv_type_2_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1403:3: lv_type_2_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2471);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1425:2: ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1425:4: '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleLibParameterCS2482); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1429:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==RULE_INT) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==14||(LA24_0>=34 && LA24_0<=35)) ) {
                        alt24=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1429:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1429:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1429:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1429:3: ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1429:3: ( (lv_lower_4_0= ruleLOWER ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1430:1: (lv_lower_4_0= ruleLOWER )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1430:1: (lv_lower_4_0= ruleLOWER )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1431:3: lv_lower_4_0= ruleLOWER
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleLibParameterCS2505);
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

                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1453:2: ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==33) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1453:4: '..' ( (lv_upper_6_0= ruleUPPER ) )
                                    {
                                    match(input,33,FollowSets000.FOLLOW_33_in_ruleLibParameterCS2516); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1457:1: ( (lv_upper_6_0= ruleUPPER ) )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1458:1: (lv_upper_6_0= ruleUPPER )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1458:1: (lv_upper_6_0= ruleUPPER )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1459:3: lv_upper_6_0= ruleUPPER
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleLibParameterCS2537);
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
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1482:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1482:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1483:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1483:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1484:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1484:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            int alt23=3;
                            switch ( input.LA(1) ) {
                            case 14:
                                {
                                alt23=1;
                                }
                                break;
                            case 34:
                                {
                                alt23=2;
                                }
                                break;
                            case 35:
                                {
                                alt23=3;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1484:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )", 23, 0, input);

                                throw nvae;
                            }

                            switch (alt23) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1485:3: lv_multiplicity_7_1= '*'
                                    {
                                    lv_multiplicity_7_1=(Token)input.LT(1);
                                    match(input,14,FollowSets000.FOLLOW_14_in_ruleLibParameterCS2566); if (failed) return current;
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
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1503:8: lv_multiplicity_7_2= '+'
                                    {
                                    lv_multiplicity_7_2=(Token)input.LT(1);
                                    match(input,34,FollowSets000.FOLLOW_34_in_ruleLibParameterCS2595); if (failed) return current;
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
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1521:8: lv_multiplicity_7_3= '?'
                                    {
                                    lv_multiplicity_7_3=(Token)input.LT(1);
                                    match(input,35,FollowSets000.FOLLOW_35_in_ruleLibParameterCS2624); if (failed) return current;
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

                    match(input,36,FollowSets000.FOLLOW_36_in_ruleLibParameterCS2651); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1554:1: entryRuleLibPropertyCS returns [EObject current=null] : iv_ruleLibPropertyCS= ruleLibPropertyCS EOF ;
    public final EObject entryRuleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPropertyCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1555:2: (iv_ruleLibPropertyCS= ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1556:2: iv_ruleLibPropertyCS= ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPropertyCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2689);
            iv_ruleLibPropertyCS=ruleLibPropertyCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPropertyCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS2699); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1563:1: ruleLibPropertyCS returns [EObject current=null] : ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_5_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1568:6: ( ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1569:1: ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1569:1: ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1569:3: 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleLibPropertyCS2734); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1573:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1574:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1574:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1575:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibPropertyCS2755);
            lv_name_1_0=ruleName();
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
              	        		lv_name_1_0, 
              	        		"Name", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibPropertyCS2765); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1601:1: ( (lv_type_3_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1602:1: (lv_type_3_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1602:1: (lv_type_3_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1603:3: lv_type_3_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2786);
            lv_type_3_0=ruleLibTypedRefCS();
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
              	        		lv_type_3_0, 
              	        		"LibTypedRefCS", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibPropertyCS2796); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1629:1: ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1630:1: (lv_class_5_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1630:1: (lv_class_5_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1631:3: lv_class_5_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_5_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2813); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0(), "class"); 
              		
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
              	        		lv_class_5_0, 
              	        		"SINGLE_QUOTED_STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibPropertyCS2828); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6(), null); 
                  
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1665:1: entryRuleLibQualifiedTypeRefCS returns [EObject current=null] : iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF ;
    public final EObject entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibQualifiedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1666:2: (iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1667:2: iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2864);
            iv_ruleLibQualifiedTypeRefCS=ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibQualifiedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2874); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1674:1: ruleLibQualifiedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_element_7_0= ruleLibTypedRefCS ) ) ) ;
    public final EObject ruleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_element_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1679:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_element_7_0= ruleLibTypedRefCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1680:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_element_7_0= ruleLibTypedRefCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1680:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_element_7_0= ruleLibTypedRefCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1680:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_element_7_0= ruleLibTypedRefCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1680:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1681:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1681:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1682:3: ruleIdentifier
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
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2926);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1699:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==25) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1699:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibQualifiedTypeRefCS2937); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1703:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1704:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1704:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1705:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2958);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1727:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==26) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1727:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibQualifiedTypeRefCS2969); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1731:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1732:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1732:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1733:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2990);
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
                    	    break loop26;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibQualifiedTypeRefCS3002); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,37,FollowSets000.FOLLOW_37_in_ruleLibQualifiedTypeRefCS3014); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1763:1: ( (lv_element_7_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1764:1: (lv_element_7_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1764:1: (lv_element_7_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1765:3: lv_element_7_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementLibTypedRefCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS3035);
            lv_element_7_0=ruleLibTypedRefCS();
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
              	       			"element",
              	        		lv_element_7_0, 
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1795:1: entryRuleLibTypeParameterCS returns [EObject current=null] : iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF ;
    public final EObject entryRuleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1796:2: (iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1797:2: iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS3071);
            iv_ruleLibTypeParameterCS=ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS3081); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1804:1: ruleLibTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_extends_2_0 = null;

        EObject lv_extends_4_0 = null;

        EObject lv_super_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1809:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1810:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1810:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1810:2: ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1810:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1811:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1811:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1812:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS3127);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:2: ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            int alt29=3;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==16) ) {
                alt29=1;
            }
            else if ( (LA29_0==22) ) {
                alt29=2;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:5: 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibTypeParameterCS3139); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1838:1: ( (lv_extends_2_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1839:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1839:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1840:3: lv_extends_2_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3160);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1862:2: ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==38) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1862:4: '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,38,FollowSets000.FOLLOW_38_in_ruleLibTypeParameterCS3171); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1866:1: ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1867:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1867:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1868:3: lv_extends_4_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3192);
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
                    	    break loop28;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1891:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1891:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1891:8: 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibTypeParameterCS3212); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1895:1: ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1896:1: (lv_super_6_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1896:1: (lv_super_6_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1897:3: lv_super_6_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3233);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1927:1: entryRuleLibTypeRefCS returns [EObject current=null] : iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF ;
    public final EObject entryRuleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1928:2: (iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1929:2: iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3272);
            iv_ruleLibTypeRefCS=ruleLibTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS3282); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1936:1: ruleLibTypeRefCS returns [EObject current=null] : (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) ;
    public final EObject ruleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibTypedRefCS_0 = null;

        EObject this_LibWildcardTypeRefCS_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1941:6: ( (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1942:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1942:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID||LA30_0==11||(LA30_0>=15 && LA30_0<=23)) ) {
                alt30=1;
            }
            else if ( (LA30_0==35) ) {
                alt30=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1942:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1943:2: this_LibTypedRefCS_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3332);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1956:2: this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3362);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1975:1: entryRuleLibTypedRefCS returns [EObject current=null] : iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF ;
    public final EObject entryRuleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1976:2: (iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1977:2: iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3397);
            iv_ruleLibTypedRefCS=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS3407); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1984:1: ruleLibTypedRefCS returns [EObject current=null] : (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) ;
    public final EObject ruleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibQualifiedTypeRefCS_0 = null;

        EObject this_LibTypedTypeRefCS_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1989:6: ( (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            int alt31=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA31_2 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA31_3 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 3, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA31_4 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 4, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA31_5 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 5, input);

                    throw nvae;
                }
                }
                break;
            case 11:
                {
                int LA31_6 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 6, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA31_7 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 7, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA31_8 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 8, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA31_9 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 9, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA31_10 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 10, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                int LA31_11 = input.LA(2);

                if ( (synpred43()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1990:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1991:2: this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3457);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2004:2: this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3487);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2023:1: entryRuleLibTypedTypeRefCS returns [EObject current=null] : iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF ;
    public final EObject entryRuleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2024:2: (iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2025:2: iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3522);
            iv_ruleLibTypedTypeRefCS=ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3532); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2032:1: ruleLibTypedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) ;
    public final EObject ruleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2037:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2038:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2038:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2038:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2038:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2039:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2039:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2040:3: ruleIdentifier
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
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3584);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2057:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2057:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibTypedTypeRefCS3595); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2061:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2062:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2062:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2063:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3616);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2085:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==26) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2085:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibTypedTypeRefCS3627); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2089:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2090:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2090:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2091:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3648);
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
                    	    break loop32;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibTypedTypeRefCS3660); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2125:1: entryRuleLibWildcardTypeRefCS returns [EObject current=null] : iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF ;
    public final EObject entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibWildcardTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2126:2: (iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2127:2: iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibWildcardTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3698);
            iv_ruleLibWildcardTypeRefCS=ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3708); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2134:1: ruleLibWildcardTypeRefCS returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2139:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2140:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2140:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2140:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2140:2: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2141:2: 
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

            match(input,35,FollowSets000.FOLLOW_35_in_ruleLibWildcardTypeRefCS3755); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2158:1: ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==16) ) {
                alt34=1;
            }
            else if ( (LA34_0==22) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2158:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2158:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2158:4: 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibWildcardTypeRefCS3767); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2162:1: ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2163:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2164:3: lv_extends_3_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3788);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2187:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2187:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2187:8: 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibWildcardTypeRefCS3806); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2191:1: ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2192:1: (lv_super_5_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2192:1: (lv_super_5_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2193:3: lv_super_5_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3827);
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

    // $ANTLR start synpred43
    public final void synpred43_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1991:2: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1991:2: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred433457);
        ruleLibQualifiedTypeRefCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred43

    public final boolean synpred43() {
        backtracking++;
        int start = input.mark();
        try {
            synpred43_fragment(); // can never throw exception
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
        public static final BitSet FOLLOW_11_in_ruleLibrary126 = new BitSet(new long[]{0x0000000000FF8820L});
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
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRestrictedKeywords_in_ruleIdentifier543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRestrictedKeywords_in_entryRuleRestrictedKeywords589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRestrictedKeywords600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRestrictedKeywords638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRestrictedKeywords657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRestrictedKeywords676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleRestrictedKeywords695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRestrictedKeywords714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleRestrictedKeywords733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRestrictedKeywords752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRestrictedKeywords771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRestrictedKeywords790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleRestrictedKeywords809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_entryRuleName850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleName861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleName908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleName934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLibImportCS1024 = new BitSet(new long[]{0x0000000000FF88A0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibImportCS1046 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibImportCS1056 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS1080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS1116 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS1126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleLibClassCS1161 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibClassCS1182 = new BitSet(new long[]{0x0000000002009000L});
        public static final BitSet FOLLOW_25_in_ruleLibClassCS1193 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1214 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibClassCS1225 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1246 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibClassCS1258 = new BitSet(new long[]{0x0000000000009000L});
        public static final BitSet FOLLOW_15_in_ruleLibClassCS1271 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1292 = new BitSet(new long[]{0x0000000004001000L});
        public static final BitSet FOLLOW_26_in_ruleLibClassCS1303 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1324 = new BitSet(new long[]{0x0000000004001000L});
        public static final BitSet FOLLOW_12_in_ruleLibClassCS1338 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1362 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1381 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1411 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_13_in_ruleLibClassCS1423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1459 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS1469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS1562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleLibIterationCS1597 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibIterationCS1618 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_25_in_ruleLibIterationCS1629 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1650 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibIterationCS1661 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1682 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibIterationCS1694 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleLibIterationCS1706 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1727 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_26_in_ruleLibIterationCS1738 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1759 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_29_in_ruleLibIterationCS1771 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibIterationCS1781 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1802 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibIterationCS1812 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1829 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibIterationCS1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1880 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS1890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleLibOperationCS1925 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibOperationCS1946 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_25_in_ruleLibOperationCS1957 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1978 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibOperationCS1989 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS2010 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibOperationCS2022 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleLibOperationCS2034 = new BitSet(new long[]{0x0000000020FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS2056 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_26_in_ruleLibOperationCS2067 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS2088 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_29_in_ruleLibOperationCS2102 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibOperationCS2112 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS2133 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibOperationCS2143 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS2160 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibOperationCS2175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS2211 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS2221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleLibPackageCS2256 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibPackageCS2277 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLibPackageCS2287 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2309 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2336 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_13_in_ruleLibPackageCS2348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS2394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibParameterCS2440 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibParameterCS2450 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2471 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleLibParameterCS2482 = new BitSet(new long[]{0x0000000C00004010L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleLibParameterCS2505 = new BitSet(new long[]{0x0000001200000000L});
        public static final BitSet FOLLOW_33_in_ruleLibParameterCS2516 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleLibParameterCS2537 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_14_in_ruleLibParameterCS2566 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_34_in_ruleLibParameterCS2595 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_35_in_ruleLibParameterCS2624 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLibParameterCS2651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2689 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS2699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleLibPropertyCS2734 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibPropertyCS2755 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibPropertyCS2765 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2786 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibPropertyCS2796 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2813 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibPropertyCS2828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2864 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2926 = new BitSet(new long[]{0x0000002002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibQualifiedTypeRefCS2937 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2958 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibQualifiedTypeRefCS2969 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2990 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibQualifiedTypeRefCS3002 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleLibQualifiedTypeRefCS3014 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS3035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS3071 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS3081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS3127 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_16_in_ruleLibTypeParameterCS3139 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3160 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_38_in_ruleLibTypeParameterCS3171 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3192 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibTypeParameterCS3212 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS3282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3397 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS3407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3522 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3584 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleLibTypedTypeRefCS3595 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3616 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibTypedTypeRefCS3627 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3648 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibTypedTypeRefCS3660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3698 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLibWildcardTypeRefCS3755 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_16_in_ruleLibWildcardTypeRefCS3767 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibWildcardTypeRefCS3806 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred433457 = new BitSet(new long[]{0x0000000000000002L});
    }


}