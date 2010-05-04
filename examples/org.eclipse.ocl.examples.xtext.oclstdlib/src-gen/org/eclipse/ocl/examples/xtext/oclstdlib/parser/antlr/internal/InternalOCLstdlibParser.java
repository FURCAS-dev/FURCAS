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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID_TERMINAL", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'library'", "'{'", "'}'", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'operation'", "'package'", "'property'", "'super'", "'type'", "':'", "'<'", "','", "'>'", "'('", "')'", "'=>'", "';'", "'['", "'..'", "'+'", "'?'", "']'", "'::'", "'&&'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID_TERMINAL=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int RULE_SL_COMMENT=9;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[85+1];
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:266:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_TERMINAL_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:271:6: ( (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )
            int alt4=11;
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
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("272:1: (this_ID_TERMINAL_0= RULE_ID_TERMINAL | kw= 'conformsTo' | kw= 'extends' | kw= 'import' | kw= 'iteration' | kw= 'library' | kw= 'operation' | kw= 'package' | kw= 'property' | kw= 'super' | kw= 'type' )", 4, 0, input);

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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:337:2: kw= 'super'
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleIdentifier686); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getSuperKeyword_9(), null); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:344:2: kw= 'type'
                    {
                    kw=(Token)input.LT(1);
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleIdentifier705); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getIdentifierAccess().getTypeKeyword_10(), null); 
                          
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


    // $ANTLR start entryRuleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:357:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:358:2: (iv_ruleName= ruleName EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:359:2: iv_ruleName= ruleName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNameRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_entryRuleName746);
            iv_ruleName=ruleName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleName757); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:366:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_QUOTED_STRING_1=null;
        AntlrDatatypeRuleToken this_Identifier_0 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:371:6: ( (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:372:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:372:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID_TERMINAL||LA5_0==11||(LA5_0>=15 && LA5_0<=23)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_DOUBLE_QUOTED_STRING) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("372:1: (this_Identifier_0= ruleIdentifier | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:373:5: this_Identifier_0= ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleName804);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:384:10: this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING
                    {
                    this_DOUBLE_QUOTED_STRING_1=(Token)input.LT(1);
                    match(input,RULE_DOUBLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleName830); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:399:1: entryRuleLibImportCS returns [EObject current=null] : iv_ruleLibImportCS= ruleLibImportCS EOF ;
    public final EObject entryRuleLibImportCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibImportCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:400:2: (iv_ruleLibImportCS= ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:401:2: iv_ruleLibImportCS= ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibImportCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS875);
            iv_ruleLibImportCS=ruleLibImportCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibImportCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS885); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:408:1: ruleLibImportCS returns [EObject current=null] : ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) ;
    public final EObject ruleLibImportCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:413:6: ( ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:414:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:414:1: ( 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:414:3: 'import' ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )? ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleLibImportCS920); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibImportCSAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:418:1: ( ( (lv_name_1_0= ruleIdentifier ) ) ':' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID_TERMINAL||LA6_0==11||(LA6_0>=15 && LA6_0<=23)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:418:2: ( (lv_name_1_0= ruleIdentifier ) ) ':'
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:418:2: ( (lv_name_1_0= ruleIdentifier ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:419:1: (lv_name_1_0= ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:419:1: (lv_name_1_0= ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:420:3: lv_name_1_0= ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibImportCS942);
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

                    match(input,24,FollowSets000.FOLLOW_24_in_ruleLibImportCS952); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:446:3: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:447:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:447:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:448:3: RULE_SINGLE_QUOTED_STRING
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
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS976); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:471:1: entryRuleLibClassCS returns [EObject current=null] : iv_ruleLibClassCS= ruleLibClassCS EOF ;
    public final EObject entryRuleLibClassCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:472:2: (iv_ruleLibClassCS= ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:473:2: iv_ruleLibClassCS= ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS1012);
            iv_ruleLibClassCS=ruleLibClassCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS1022); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:480:1: ruleLibClassCS returns [EObject current=null] : ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' ) ;
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:485:6: ( ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:486:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:486:1: ( 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:486:3: 'type' ( (lv_name_1_0= ruleIdentifier ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )? '{' ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )* '}'
            {
            match(input,23,FollowSets000.FOLLOW_23_in_ruleLibClassCS1057); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getTypeKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:490:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:491:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:491:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:492:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibClassCS1078);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:514:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:514:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibClassCS1089); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:518:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:519:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:519:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:520:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1110);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:542:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==26) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:542:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibClassCS1121); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:546:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:547:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:547:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:548:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1142);
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
                    	    break loop7;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibClassCS1154); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:574:3: ( 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:574:5: 'conformsTo' ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) ) ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleLibClassCS1167); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:578:1: ( (lv_conformsTo_8_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:579:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:579:1: (lv_conformsTo_8_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:580:3: lv_conformsTo_8_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1188);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:602:2: ( ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==26) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:602:4: ',' ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibClassCS1199); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:606:1: ( (lv_conformsTo_10_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:607:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:607:1: (lv_conformsTo_10_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:608:3: lv_conformsTo_10_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1220);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibClassCS1234); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:634:1: ( ( (lv_iterations_12_0= ruleLibIterationCS ) ) | ( (lv_operations_13_0= ruleLibOperationCS ) ) | ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) ) )*
            loop11:
            do {
                int alt11=4;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt11=1;
                    }
                    break;
                case 19:
                    {
                    alt11=2;
                    }
                    break;
                case 21:
                    {
                    alt11=3;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:634:2: ( (lv_iterations_12_0= ruleLibIterationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:634:2: ( (lv_iterations_12_0= ruleLibIterationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:635:1: (lv_iterations_12_0= ruleLibIterationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:635:1: (lv_iterations_12_0= ruleLibIterationCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:636:3: lv_iterations_12_0= ruleLibIterationCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1256);
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:659:6: ( (lv_operations_13_0= ruleLibOperationCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:659:6: ( (lv_operations_13_0= ruleLibOperationCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:660:1: (lv_operations_13_0= ruleLibOperationCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:660:1: (lv_operations_13_0= ruleLibOperationCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:661:3: lv_operations_13_0= ruleLibOperationCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1283);
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:684:6: ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:684:6: ( (lv_structuralFeatures_14_0= ruleLibPropertyCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:685:1: (lv_structuralFeatures_14_0= ruleLibPropertyCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:685:1: (lv_structuralFeatures_14_0= ruleLibPropertyCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:686:3: lv_structuralFeatures_14_0= ruleLibPropertyCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1310);
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
            	    break loop11;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibClassCS1322); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:720:1: entryRuleLibClassifierCS returns [EObject current=null] : iv_ruleLibClassifierCS= ruleLibClassifierCS EOF ;
    public final EObject entryRuleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibClassifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:721:2: (iv_ruleLibClassifierCS= ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:722:2: iv_ruleLibClassifierCS= ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibClassifierCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1358);
            iv_ruleLibClassifierCS=ruleLibClassifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibClassifierCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS1368); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:729:1: ruleLibClassifierCS returns [EObject current=null] : this_LibClassCS_0= ruleLibClassCS ;
    public final EObject ruleLibClassifierCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibClassCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:734:6: (this_LibClassCS_0= ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:736:2: this_LibClassCS_0= ruleLibClassCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1417);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:755:1: entryRuleLibIterationCS returns [EObject current=null] : iv_ruleLibIterationCS= ruleLibIterationCS EOF ;
    public final EObject entryRuleLibIterationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibIterationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:756:2: (iv_ruleLibIterationCS= ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:757:2: iv_ruleLibIterationCS= ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibIterationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1451);
            iv_ruleLibIterationCS=ruleLibIterationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibIterationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS1461); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:764:1: ruleLibIterationCS returns [EObject current=null] : ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibIterationCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_15_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_type_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:769:6: ( ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:770:1: ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:770:1: ( 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:770:3: 'iteration' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleLibIterationCS1496); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:774:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:775:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:775:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:776:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibIterationCS1517);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:798:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:798:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibIterationCS1528); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:802:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:803:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:803:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:804:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1549);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:826:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==26) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:826:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibIterationCS1560); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:830:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:831:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:831:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:832:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1581);
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
                    	    break loop12;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibIterationCS1593); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleLibIterationCS1605); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:862:1: ( (lv_parameters_8_0= ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:863:1: (lv_parameters_8_0= ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:863:1: (lv_parameters_8_0= ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:864:3: lv_parameters_8_0= ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1626);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:886:2: ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:886:4: ',' ( (lv_parameters_10_0= ruleLibParameterCS ) )
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibIterationCS1637); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:890:1: ( (lv_parameters_10_0= ruleLibParameterCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:891:1: (lv_parameters_10_0= ruleLibParameterCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:891:1: (lv_parameters_10_0= ruleLibParameterCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:892:3: lv_parameters_10_0= ruleLibParameterCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1658);
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
            	    break loop14;
                }
            } while (true);

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibIterationCS1670); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6(), null); 
                  
            }
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibIterationCS1680); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getColonKeyword_7(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:922:1: ( (lv_type_13_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:923:1: (lv_type_13_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:923:1: (lv_type_13_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:924:3: lv_type_13_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1701);
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

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibIterationCS1711); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:950:1: ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:951:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:951:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:952:3: lv_class_15_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_15_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1728); if (failed) return current;
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

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibIterationCS1743); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:986:1: entryRuleLibOperationCS returns [EObject current=null] : iv_ruleLibOperationCS= ruleLibOperationCS EOF ;
    public final EObject entryRuleLibOperationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibOperationCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:987:2: (iv_ruleLibOperationCS= ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:988:2: iv_ruleLibOperationCS= ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibOperationCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1779);
            iv_ruleLibOperationCS=ruleLibOperationCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibOperationCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS1789); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:995:1: ruleLibOperationCS returns [EObject current=null] : ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibOperationCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_15_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_typeParameters_3_0 = null;

        EObject lv_typeParameters_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_type_13_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1000:6: ( ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1001:1: ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1001:1: ( 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1001:3: 'operation' ( (lv_name_1_0= ruleName ) ) ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )? '(' ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )? ')' ':' ( (lv_type_13_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleLibOperationCS1824); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1005:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1006:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1006:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1007:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibOperationCS1845);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1029:2: ( '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1029:4: '<' ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) ) ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibOperationCS1856); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1033:1: ( (lv_typeParameters_3_0= ruleLibTypeParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1034:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1034:1: (lv_typeParameters_3_0= ruleLibTypeParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1035:3: lv_typeParameters_3_0= ruleLibTypeParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1877);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1057:2: ( ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==26) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1057:4: ',' ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibOperationCS1888); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1061:1: ( (lv_typeParameters_5_0= ruleLibTypeParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1062:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1062:1: (lv_typeParameters_5_0= ruleLibTypeParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1063:3: lv_typeParameters_5_0= ruleLibTypeParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1909);
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
                    	    break loop15;
                        }
                    } while (true);

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibOperationCS1921); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleLibOperationCS1933); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1093:1: ( ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID_TERMINAL||LA18_0==11||(LA18_0>=15 && LA18_0<=23)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1093:2: ( (lv_parameters_8_0= ruleLibParameterCS ) ) ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1093:2: ( (lv_parameters_8_0= ruleLibParameterCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1094:1: (lv_parameters_8_0= ruleLibParameterCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1094:1: (lv_parameters_8_0= ruleLibParameterCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1095:3: lv_parameters_8_0= ruleLibParameterCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1955);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1117:2: ( ',' ( (lv_parameters_10_0= ruleLibParameterCS ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==26) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1117:4: ',' ( (lv_parameters_10_0= ruleLibParameterCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibOperationCS1966); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1121:1: ( (lv_parameters_10_0= ruleLibParameterCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1122:1: (lv_parameters_10_0= ruleLibParameterCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1122:1: (lv_parameters_10_0= ruleLibParameterCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1123:3: lv_parameters_10_0= ruleLibParameterCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1987);
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,29,FollowSets000.FOLLOW_29_in_ruleLibOperationCS2001); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5(), null); 
                  
            }
            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibOperationCS2011); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getColonKeyword_6(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1153:1: ( (lv_type_13_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1154:1: (lv_type_13_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1154:1: (lv_type_13_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1155:3: lv_type_13_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS2032);
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

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibOperationCS2042); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1181:1: ( (lv_class_15_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1182:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1182:1: (lv_class_15_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1183:3: lv_class_15_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_15_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS2059); if (failed) return current;
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

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibOperationCS2074); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1217:1: entryRuleLibPackageCS returns [EObject current=null] : iv_ruleLibPackageCS= ruleLibPackageCS EOF ;
    public final EObject entryRuleLibPackageCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPackageCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1218:2: (iv_ruleLibPackageCS= ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1219:2: iv_ruleLibPackageCS= ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPackageCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS2110);
            iv_ruleLibPackageCS=ruleLibPackageCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPackageCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS2120); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1226:1: ruleLibPackageCS returns [EObject current=null] : ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) ;
    public final EObject ruleLibPackageCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_subpackages_3_0 = null;

        EObject lv_classifiers_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1231:6: ( ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1232:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1232:1: ( 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1232:3: 'package' ( (lv_name_1_0= ruleIdentifier ) ) '{' ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )* '}'
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleLibPackageCS2155); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1236:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1237:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1237:1: (lv_name_1_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1238:3: lv_name_1_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibPackageCS2176);
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleLibPackageCS2186); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1264:1: ( ( (lv_subpackages_3_0= ruleLibPackageCS ) ) | ( (lv_classifiers_4_0= ruleLibClassifierCS ) ) )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    alt19=1;
                }
                else if ( (LA19_0==23) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1264:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1264:2: ( (lv_subpackages_3_0= ruleLibPackageCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1265:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1265:1: (lv_subpackages_3_0= ruleLibPackageCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1266:3: lv_subpackages_3_0= ruleLibPackageCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2208);
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
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1289:6: ( (lv_classifiers_4_0= ruleLibClassifierCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1290:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1290:1: (lv_classifiers_4_0= ruleLibClassifierCS )
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1291:3: lv_classifiers_4_0= ruleLibClassifierCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2235);
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
            	    break loop19;
                }
            } while (true);

            match(input,13,FollowSets000.FOLLOW_13_in_ruleLibPackageCS2247); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1325:1: entryRuleLibParameterCS returns [EObject current=null] : iv_ruleLibParameterCS= ruleLibParameterCS EOF ;
    public final EObject entryRuleLibParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1326:2: (iv_ruleLibParameterCS= ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1327:2: iv_ruleLibParameterCS= ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2283);
            iv_ruleLibParameterCS=ruleLibParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS2293); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1334:1: ruleLibParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) ;
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
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1339:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1340:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1340:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1340:2: ( (lv_name_0_0= ruleIdentifier ) ) ':' ( (lv_type_2_0= ruleLibTypedRefCS ) ) ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1340:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1341:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1341:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1342:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibParameterCS2339);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibParameterCS2349); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibParameterCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1368:1: ( (lv_type_2_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1369:1: (lv_type_2_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1369:1: (lv_type_2_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1370:3: lv_type_2_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2370);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1392:2: ( '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1392:4: '[' ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) ) ']'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_ruleLibParameterCS2381); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1396:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==RULE_INT) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==14||(LA22_0>=34 && LA22_0<=35)) ) {
                        alt22=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1396:1: ( ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? ) | ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) ) )", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1396:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1396:2: ( ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )? )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1396:3: ( (lv_lower_4_0= ruleLOWER ) ) ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1396:3: ( (lv_lower_4_0= ruleLOWER ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1397:1: (lv_lower_4_0= ruleLOWER )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1397:1: (lv_lower_4_0= ruleLOWER )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1398:3: lv_lower_4_0= ruleLOWER
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleLibParameterCS2404);
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

                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1420:2: ( '..' ( (lv_upper_6_0= ruleUPPER ) ) )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==33) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1420:4: '..' ( (lv_upper_6_0= ruleUPPER ) )
                                    {
                                    match(input,33,FollowSets000.FOLLOW_33_in_ruleLibParameterCS2415); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1424:1: ( (lv_upper_6_0= ruleUPPER ) )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1425:1: (lv_upper_6_0= ruleUPPER )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1425:1: (lv_upper_6_0= ruleUPPER )
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1426:3: lv_upper_6_0= ruleUPPER
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleLibParameterCS2436);
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
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1449:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1449:6: ( ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1450:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1450:1: ( (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' ) )
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1451:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            {
                            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1451:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )
                            int alt21=3;
                            switch ( input.LA(1) ) {
                            case 14:
                                {
                                alt21=1;
                                }
                                break;
                            case 34:
                                {
                                alt21=2;
                                }
                                break;
                            case 35:
                                {
                                alt21=3;
                                }
                                break;
                            default:
                                if (backtracking>0) {failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("1451:1: (lv_multiplicity_7_1= '*' | lv_multiplicity_7_2= '+' | lv_multiplicity_7_3= '?' )", 21, 0, input);

                                throw nvae;
                            }

                            switch (alt21) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1452:3: lv_multiplicity_7_1= '*'
                                    {
                                    lv_multiplicity_7_1=(Token)input.LT(1);
                                    match(input,14,FollowSets000.FOLLOW_14_in_ruleLibParameterCS2465); if (failed) return current;
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
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1470:8: lv_multiplicity_7_2= '+'
                                    {
                                    lv_multiplicity_7_2=(Token)input.LT(1);
                                    match(input,34,FollowSets000.FOLLOW_34_in_ruleLibParameterCS2494); if (failed) return current;
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
                                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1488:8: lv_multiplicity_7_3= '?'
                                    {
                                    lv_multiplicity_7_3=(Token)input.LT(1);
                                    match(input,35,FollowSets000.FOLLOW_35_in_ruleLibParameterCS2523); if (failed) return current;
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

                    match(input,36,FollowSets000.FOLLOW_36_in_ruleLibParameterCS2550); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1521:1: entryRuleLibPropertyCS returns [EObject current=null] : iv_ruleLibPropertyCS= ruleLibPropertyCS EOF ;
    public final EObject entryRuleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibPropertyCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1522:2: (iv_ruleLibPropertyCS= ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1523:2: iv_ruleLibPropertyCS= ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibPropertyCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2588);
            iv_ruleLibPropertyCS=ruleLibPropertyCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibPropertyCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS2598); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1530:1: ruleLibPropertyCS returns [EObject current=null] : ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) ;
    public final EObject ruleLibPropertyCS() throws RecognitionException {
        EObject current = null;

        Token lv_class_5_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1535:6: ( ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1536:1: ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1536:1: ( 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1536:3: 'property' ( (lv_name_1_0= ruleName ) ) ':' ( (lv_type_3_0= ruleLibTypedRefCS ) ) '=>' ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) ) ';'
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleLibPropertyCS2633); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1540:1: ( (lv_name_1_0= ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1541:1: (lv_name_1_0= ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1541:1: (lv_name_1_0= ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1542:3: lv_name_1_0= ruleName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_ruleLibPropertyCS2654);
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleLibPropertyCS2664); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1568:1: ( (lv_type_3_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1569:1: (lv_type_3_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1569:1: (lv_type_3_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1570:3: lv_type_3_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2685);
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

            match(input,30,FollowSets000.FOLLOW_30_in_ruleLibPropertyCS2695); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1596:1: ( (lv_class_5_0= RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1597:1: (lv_class_5_0= RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1597:1: (lv_class_5_0= RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1598:3: lv_class_5_0= RULE_SINGLE_QUOTED_STRING
            {
            lv_class_5_0=(Token)input.LT(1);
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2712); if (failed) return current;
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

            match(input,31,FollowSets000.FOLLOW_31_in_ruleLibPropertyCS2727); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1632:1: entryRuleLibQualifiedTypeRefCS returns [EObject current=null] : iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF ;
    public final EObject entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibQualifiedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1633:2: (iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1634:2: iv_ruleLibQualifiedTypeRefCS= ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2763);
            iv_ruleLibQualifiedTypeRefCS=ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibQualifiedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2773); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1641:1: ruleLibQualifiedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) ) ;
    public final EObject ruleLibQualifiedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_type_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1646:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1647:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1647:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1647:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? '::' ( (lv_type_7_0= ruleLibTypedRefCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1647:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1648:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1648:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1649:3: ruleIdentifier
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
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2825);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1666:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1666:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibQualifiedTypeRefCS2836); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1670:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1671:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1671:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1672:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2857);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1694:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==26) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1694:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibQualifiedTypeRefCS2868); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1698:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1699:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1699:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1700:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2889);
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

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibQualifiedTypeRefCS2901); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,37,FollowSets000.FOLLOW_37_in_ruleLibQualifiedTypeRefCS2913); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1730:1: ( (lv_type_7_0= ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1731:1: (lv_type_7_0= ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1731:1: (lv_type_7_0= ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1732:3: lv_type_7_0= ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS2934);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1762:1: entryRuleLibTypeParameterCS returns [EObject current=null] : iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF ;
    public final EObject entryRuleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeParameterCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1763:2: (iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1764:2: iv_ruleLibTypeParameterCS= ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeParameterCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS2970);
            iv_ruleLibTypeParameterCS=ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS2980); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1771:1: ruleLibTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibTypeParameterCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_extends_2_0 = null;

        EObject lv_extends_4_0 = null;

        EObject lv_super_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1776:6: ( ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1777:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1777:1: ( ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1777:2: ( (lv_name_0_0= ruleIdentifier ) ) ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1777:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1778:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1778:1: (lv_name_0_0= ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1779:3: lv_name_0_0= ruleIdentifier
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS3026);
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

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1801:2: ( ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* ) | ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==16) ) {
                alt27=1;
            }
            else if ( (LA27_0==22) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1801:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1801:3: ( 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )* )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1801:5: 'extends' ( (lv_extends_2_0= ruleLibTypedRefCS ) ) ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibTypeParameterCS3038); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1805:1: ( (lv_extends_2_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1806:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1806:1: (lv_extends_2_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1807:3: lv_extends_2_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3059);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1829:2: ( '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==38) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1829:4: '&&' ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    {
                    	    match(input,38,FollowSets000.FOLLOW_38_in_ruleLibTypeParameterCS3070); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1833:1: ( (lv_extends_4_0= ruleLibTypedRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1834:1: (lv_extends_4_0= ruleLibTypedRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1835:3: lv_extends_4_0= ruleLibTypedRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3091);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1858:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1858:6: ( 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1858:8: 'super' ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibTypeParameterCS3111); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1862:1: ( (lv_super_6_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1863:1: (lv_super_6_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1863:1: (lv_super_6_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1864:3: lv_super_6_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3132);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1894:1: entryRuleLibTypeRefCS returns [EObject current=null] : iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF ;
    public final EObject entryRuleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1895:2: (iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1896:2: iv_ruleLibTypeRefCS= ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3171);
            iv_ruleLibTypeRefCS=ruleLibTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS3181); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1903:1: ruleLibTypeRefCS returns [EObject current=null] : (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) ;
    public final EObject ruleLibTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibTypedRefCS_0 = null;

        EObject this_LibWildcardTypeRefCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1908:6: ( (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1909:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1909:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID_TERMINAL||LA28_0==11||(LA28_0>=15 && LA28_0<=23)) ) {
                alt28=1;
            }
            else if ( (LA28_0==35) ) {
                alt28=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1909:1: (this_LibTypedRefCS_0= ruleLibTypedRefCS | this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1910:2: this_LibTypedRefCS_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3231);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1923:2: this_LibWildcardTypeRefCS_1= ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3261);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1942:1: entryRuleLibTypedRefCS returns [EObject current=null] : iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF ;
    public final EObject entryRuleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1943:2: (iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1944:2: iv_ruleLibTypedRefCS= ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3296);
            iv_ruleLibTypedRefCS=ruleLibTypedRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS3306); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1951:1: ruleLibTypedRefCS returns [EObject current=null] : (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) ;
    public final EObject ruleLibTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_LibQualifiedTypeRefCS_0 = null;

        EObject this_LibTypedTypeRefCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1956:6: ( (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )
            int alt29=2;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                int LA29_1 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 1, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA29_2 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA29_3 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 3, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA29_4 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA29_5 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 5, input);

                    throw nvae;
                }
                }
                break;
            case 11:
                {
                int LA29_6 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 6, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA29_7 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 7, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA29_8 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 8, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA29_9 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 9, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA29_10 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 10, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                int LA29_11 = input.LA(2);

                if ( (synpred43()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1957:1: (this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS | this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1958:2: this_LibQualifiedTypeRefCS_0= ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3356);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1971:2: this_LibTypedTypeRefCS_1= ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3386);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1990:1: entryRuleLibTypedTypeRefCS returns [EObject current=null] : iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF ;
    public final EObject entryRuleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibTypedTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1991:2: (iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1992:2: iv_ruleLibTypedTypeRefCS= ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibTypedTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3421);
            iv_ruleLibTypedTypeRefCS=ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3431); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1999:1: ruleLibTypedTypeRefCS returns [EObject current=null] : ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) ;
    public final EObject ruleLibTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2004:6: ( ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2005:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2005:1: ( ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2005:2: ( ( ruleIdentifier ) ) ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2005:2: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2006:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2006:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2007:3: ruleIdentifier
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
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3483);
            ruleIdentifier();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2024:2: ( '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==25) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2024:4: '<' ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) ) ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )* '>'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleLibTypedTypeRefCS3494); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2028:1: ( (lv_typeArguments_2_0= ruleLibTypeRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2029:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2029:1: (lv_typeArguments_2_0= ruleLibTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2030:3: lv_typeArguments_2_0= ruleLibTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3515);
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

                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2052:2: ( ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==26) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2052:4: ',' ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    {
                    	    match(input,26,FollowSets000.FOLLOW_26_in_ruleLibTypedTypeRefCS3526); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2056:1: ( (lv_typeArguments_4_0= ruleLibTypeRefCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2057:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2057:1: (lv_typeArguments_4_0= ruleLibTypeRefCS )
                    	    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2058:3: lv_typeArguments_4_0= ruleLibTypeRefCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3547);
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

                    match(input,27,FollowSets000.FOLLOW_27_in_ruleLibTypedTypeRefCS3559); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2092:1: entryRuleLibWildcardTypeRefCS returns [EObject current=null] : iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF ;
    public final EObject entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibWildcardTypeRefCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2093:2: (iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2094:2: iv_ruleLibWildcardTypeRefCS= ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLibWildcardTypeRefCSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3597);
            iv_ruleLibWildcardTypeRefCS=ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLibWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3607); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2101:1: ruleLibWildcardTypeRefCS returns [EObject current=null] : ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) ;
    public final EObject ruleLibWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject lv_extends_3_0 = null;

        EObject lv_super_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2106:6: ( ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2107:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2107:1: ( () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2107:2: () '?' ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2107:2: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2108:2: 
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

            match(input,35,FollowSets000.FOLLOW_35_in_ruleLibWildcardTypeRefCS3654); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2125:1: ( ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) ) | ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) ) )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==16) ) {
                alt32=1;
            }
            else if ( (LA32_0==22) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2125:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2125:2: ( 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2125:4: 'extends' ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleLibWildcardTypeRefCS3666); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2129:1: ( (lv_extends_3_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2130:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2130:1: (lv_extends_3_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2131:3: lv_extends_3_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3687);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2154:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2154:6: ( 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2154:8: 'super' ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleLibWildcardTypeRefCS3705); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2158:1: ( (lv_super_5_0= ruleLibTypedRefCS ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:1: (lv_super_5_0= ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2159:1: (lv_super_5_0= ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:2160:3: lv_super_5_0= ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3726);
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1958:2: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/parser/antlr/internal/InternalOCLstdlib.g:1958:2: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred433356);
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
        public static final BitSet FOLLOW_ruleName_in_entryRuleName746 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleName757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleName804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleName830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS875 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLibImportCS920 = new BitSet(new long[]{0x0000000000FF88A0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibImportCS942 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibImportCS952 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibImportCS976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS1012 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS1022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleLibClassCS1057 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibClassCS1078 = new BitSet(new long[]{0x0000000002009000L});
        public static final BitSet FOLLOW_25_in_ruleLibClassCS1089 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1110 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibClassCS1121 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibClassCS1142 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibClassCS1154 = new BitSet(new long[]{0x0000000000009000L});
        public static final BitSet FOLLOW_15_in_ruleLibClassCS1167 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1188 = new BitSet(new long[]{0x0000000004001000L});
        public static final BitSet FOLLOW_26_in_ruleLibClassCS1199 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibClassCS1220 = new BitSet(new long[]{0x0000000004001000L});
        public static final BitSet FOLLOW_12_in_ruleLibClassCS1234 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_ruleLibClassCS1256 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_ruleLibClassCS1283 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_ruleLibClassCS1310 = new BitSet(new long[]{0x00000000002C2000L});
        public static final BitSet FOLLOW_13_in_ruleLibClassCS1322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS1358 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS1417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS1451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS1461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleLibIterationCS1496 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibIterationCS1517 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_25_in_ruleLibIterationCS1528 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1549 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibIterationCS1560 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibIterationCS1581 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibIterationCS1593 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleLibIterationCS1605 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1626 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_26_in_ruleLibIterationCS1637 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibIterationCS1658 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_29_in_ruleLibIterationCS1670 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibIterationCS1680 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibIterationCS1701 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibIterationCS1711 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibIterationCS1728 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibIterationCS1743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS1779 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS1789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleLibOperationCS1824 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibOperationCS1845 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_25_in_ruleLibOperationCS1856 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1877 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibOperationCS1888 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_ruleLibOperationCS1909 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibOperationCS1921 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleLibOperationCS1933 = new BitSet(new long[]{0x0000000020FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1955 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_26_in_ruleLibOperationCS1966 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_ruleLibOperationCS1987 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_29_in_ruleLibOperationCS2001 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibOperationCS2011 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibOperationCS2032 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibOperationCS2042 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibOperationCS2059 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibOperationCS2074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS2110 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS2120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleLibPackageCS2155 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibPackageCS2176 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLibPackageCS2186 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_ruleLibPackageCS2208 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_ruleLibPackageCS2235 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_13_in_ruleLibPackageCS2247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS2283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS2293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibParameterCS2339 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibParameterCS2349 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibParameterCS2370 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleLibParameterCS2381 = new BitSet(new long[]{0x0000000C00004010L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleLibParameterCS2404 = new BitSet(new long[]{0x0000001200000000L});
        public static final BitSet FOLLOW_33_in_ruleLibParameterCS2415 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleLibParameterCS2436 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_14_in_ruleLibParameterCS2465 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_34_in_ruleLibParameterCS2494 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_35_in_ruleLibParameterCS2523 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLibParameterCS2550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS2588 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleLibPropertyCS2633 = new BitSet(new long[]{0x0000000000FF8860L});
        public static final BitSet FOLLOW_ruleName_in_ruleLibPropertyCS2654 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleLibPropertyCS2664 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibPropertyCS2685 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLibPropertyCS2695 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleLibPropertyCS2712 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLibPropertyCS2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS2763 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS2773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibQualifiedTypeRefCS2825 = new BitSet(new long[]{0x0000002002000000L});
        public static final BitSet FOLLOW_25_in_ruleLibQualifiedTypeRefCS2836 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2857 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibQualifiedTypeRefCS2868 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibQualifiedTypeRefCS2889 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibQualifiedTypeRefCS2901 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleLibQualifiedTypeRefCS2913 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibQualifiedTypeRefCS2934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS2970 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS2980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypeParameterCS3026 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_16_in_ruleLibTypeParameterCS3038 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3059 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_38_in_ruleLibTypeParameterCS3070 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3091 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibTypeParameterCS3111 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeParameterCS3132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS3171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS3181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibTypeRefCS3231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_ruleLibTypeRefCS3261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS3296 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS3306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_ruleLibTypedRefCS3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_ruleLibTypedRefCS3386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS3421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS3431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleLibTypedTypeRefCS3483 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleLibTypedTypeRefCS3494 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3515 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleLibTypedTypeRefCS3526 = new BitSet(new long[]{0x0000000800FF8820L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_ruleLibTypedTypeRefCS3547 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_27_in_ruleLibTypedTypeRefCS3559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS3597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS3607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLibWildcardTypeRefCS3654 = new BitSet(new long[]{0x0000000000410002L});
        public static final BitSet FOLLOW_16_in_ruleLibWildcardTypeRefCS3666 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleLibWildcardTypeRefCS3705 = new BitSet(new long[]{0x0000000000FF8820L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_ruleLibWildcardTypeRefCS3726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred433356 = new BitSet(new long[]{0x0000000000000002L});
    }


}