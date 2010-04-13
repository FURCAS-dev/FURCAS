package org.eclipse.ocl.examples.xtext.essentialocl.parser.antlr.internal; 

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
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalEssentialOCLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING_LITERAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'e'", "'E'", "'+'", "'-'", "'Tuple'", "'self'", "'::'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'('", "')'", "','", "':'", "'{'", "'}'", "'..'", "'='", "'true'", "'false'", "'*'", "'invalid'", "'null'", "'implies'", "'xor'", "'or'", "'and'", "'<>'", "'>'", "'<'", "'>='", "'<='", "'/'", "'not'", "'->'", "';'", "'|'", "'['", "']'", "'if'", "'then'", "'else'", "'endif'", "'let'", "'in'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING_LITERAL=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEssentialOCLParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[186+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private EssentialOCLGrammarAccess grammarAccess;
     	
        public InternalEssentialOCLParser(TokenStream input, IAstFactory factory, EssentialOCLGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EssentialOCLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:83:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:84:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:85:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:92:1: ruleModel returns [EObject current=null] : this_OclExpressionCS_0= ruleOclExpressionCS ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_OclExpressionCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:97:6: (this_OclExpressionCS_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:99:2: this_OclExpressionCS_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getModelAccess().getOclExpressionCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleModel140);
            this_OclExpressionCS_0=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_OclExpressionCS_0; 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleREAL_LITERAL
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:118:1: entryRuleREAL_LITERAL returns [String current=null] : iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF ;
    public final String entryRuleREAL_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:119:2: (iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:120:2: iv_ruleREAL_LITERAL= ruleREAL_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getREAL_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL175);
            iv_ruleREAL_LITERAL=ruleREAL_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleREAL_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL_LITERAL186); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:127:1: ruleREAL_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) ;
    public final AntlrDatatypeRuleToken ruleREAL_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        Token this_INT_9=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:132:6: ( (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:133:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:133:1: (this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:133:6: this_INT_0= RULE_INT ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL226); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:140:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==EOF||LA4_3==11||(LA4_3>=14 && LA4_3<=15)||(LA4_3>=32 && LA4_3<=34)||(LA4_3>=37 && LA4_3<=39)||LA4_3==42||(LA4_3>=45 && LA4_3<=54)||LA4_3==56||(LA4_3>=58 && LA4_3<=60)||(LA4_3>=62 && LA4_3<=64)||LA4_3==66) ) {
                        alt4=1;
                    }
                    else if ( ((LA4_3>=12 && LA4_3<=13)) ) {
                        alt4=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("140:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 4, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("140:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("140:1: ( (kw= '.' this_INT_2= RULE_INT ) | ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT ) )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:140:2: (kw= '.' this_INT_2= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:140:2: (kw= '.' this_INT_2= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:141:2: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleREAL_LITERAL246); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_0_0(), null); 
                          
                    }
                    this_INT_2=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL261); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:154:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:154:6: ( (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:154:7: (kw= '.' this_INT_4= RULE_INT )? (kw= 'e' | kw= 'E' ) (kw= '+' | kw= '-' )? this_INT_9= RULE_INT
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:154:7: (kw= '.' this_INT_4= RULE_INT )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:155:2: kw= '.' this_INT_4= RULE_INT
                            {
                            kw=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_ruleREAL_LITERAL288); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getFullStopKeyword_1_1_0_0(), null); 
                                  
                            }
                            this_INT_4=(Token)input.LT(1);
                            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL303); if (failed) return current;
                            if ( backtracking==0 ) {

                              		current.merge(this_INT_4);
                                  
                            }
                            if ( backtracking==0 ) {
                               
                                  createLeafNode(grammarAccess.getREAL_LITERALAccess().getINTTerminalRuleCall_1_1_0_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:167:3: (kw= 'e' | kw= 'E' )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==12) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==13) ) {
                        alt2=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("167:3: (kw= 'e' | kw= 'E' )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:168:2: kw= 'e'
                            {
                            kw=(Token)input.LT(1);
                            match(input,12,FOLLOW_12_in_ruleREAL_LITERAL324); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:175:2: kw= 'E'
                            {
                            kw=(Token)input.LT(1);
                            match(input,13,FOLLOW_13_in_ruleREAL_LITERAL343); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getEKeyword_1_1_1_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:180:2: (kw= '+' | kw= '-' )?
                    int alt3=3;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==15) ) {
                        alt3=2;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:181:2: kw= '+'
                            {
                            kw=(Token)input.LT(1);
                            match(input,14,FOLLOW_14_in_ruleREAL_LITERAL358); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getPlusSignKeyword_1_1_2_0(), null); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:188:2: kw= '-'
                            {
                            kw=(Token)input.LT(1);
                            match(input,15,FOLLOW_15_in_ruleREAL_LITERAL377); if (failed) return current;
                            if ( backtracking==0 ) {

                                      current.merge(kw);
                                      createLeafNode(grammarAccess.getREAL_LITERALAccess().getHyphenMinusKeyword_1_1_2_1(), null); 
                                  
                            }

                            }
                            break;

                    }

                    this_INT_9=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL_LITERAL394); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:208:1: entryRuleINTEGER_LITERAL returns [String current=null] : iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF ;
    public final String entryRuleINTEGER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER_LITERAL = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:209:2: (iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:210:2: iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getINTEGER_LITERALRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL442);
            iv_ruleINTEGER_LITERAL=ruleINTEGER_LITERAL();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleINTEGER_LITERAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER_LITERAL453); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:217:1: ruleINTEGER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleINTEGER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:222:6: (this_INT_0= RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:223:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL492); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:240:1: entryRuletupleKeywordCS returns [EObject current=null] : iv_ruletupleKeywordCS= ruletupleKeywordCS EOF ;
    public final EObject entryRuletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:241:2: (iv_ruletupleKeywordCS= ruletupleKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:242:2: iv_ruletupleKeywordCS= ruletupleKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS538);
            iv_ruletupleKeywordCS=ruletupleKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleKeywordCS548); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:249:1: ruletupleKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'Tuple' ) ) ;
    public final EObject ruletupleKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:254:6: ( ( (lv_value_0_0= 'Tuple' ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:255:1: ( (lv_value_0_0= 'Tuple' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:255:1: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:256:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:256:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:257:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_ruletupleKeywordCS590); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:284:1: entryRulerestrictedKeywordCS returns [EObject current=null] : iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF ;
    public final EObject entryRulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerestrictedKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:285:2: (iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:286:2: iv_rulerestrictedKeywordCS= rulerestrictedKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRestrictedKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS638);
            iv_rulerestrictedKeywordCS=rulerestrictedKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerestrictedKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerestrictedKeywordCS648); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:293:1: rulerestrictedKeywordCS returns [EObject current=null] : (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) ;
    public final EObject rulerestrictedKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionTypeIdentifierCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_tupleKeywordCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:298:6: ( (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:299:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:299:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt5=1;
                }
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt5=2;
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("299:1: (this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleKeywordCS_2= ruletupleKeywordCS )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:300:2: this_CollectionTypeIdentifierCS_0= ruleCollectionTypeIdentifierCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getCollectionTypeIdentifierCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS698);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:313:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS728);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:326:2: this_tupleKeywordCS_2= ruletupleKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getRestrictedKeywordCSAccess().getTupleKeywordCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS758);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:345:1: entryRuleselfKeywordCS returns [EObject current=null] : iv_ruleselfKeywordCS= ruleselfKeywordCS EOF ;
    public final EObject entryRuleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleselfKeywordCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:346:2: (iv_ruleselfKeywordCS= ruleselfKeywordCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:347:2: iv_ruleselfKeywordCS= ruleselfKeywordCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSelfKeywordCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS793);
            iv_ruleselfKeywordCS=ruleselfKeywordCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleselfKeywordCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleselfKeywordCS803); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:354:1: ruleselfKeywordCS returns [EObject current=null] : ( (lv_value_0_0= 'self' ) ) ;
    public final EObject ruleselfKeywordCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:359:6: ( ( (lv_value_0_0= 'self' ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:360:1: ( (lv_value_0_0= 'self' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:360:1: ( (lv_value_0_0= 'self' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:361:1: (lv_value_0_0= 'self' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:361:1: (lv_value_0_0= 'self' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:362:3: lv_value_0_0= 'self'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_ruleselfKeywordCS845); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:389:1: entryRulesimpleNameCS returns [EObject current=null] : iv_rulesimpleNameCS= rulesimpleNameCS EOF ;
    public final EObject entryRulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:390:2: (iv_rulesimpleNameCS= rulesimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:391:2: iv_rulesimpleNameCS= rulesimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS893);
            iv_rulesimpleNameCS=rulesimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulesimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulesimpleNameCS903); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:398:1: rulesimpleNameCS returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject rulesimpleNameCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:403:6: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:404:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:404:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:405:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:405:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:406:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulesimpleNameCS944); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:436:1: entryRuleunreservedSimpleNameCS returns [EObject current=null] : iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF ;
    public final EObject entryRuleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunreservedSimpleNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:437:2: (iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:438:2: iv_ruleunreservedSimpleNameCS= ruleunreservedSimpleNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnreservedSimpleNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS984);
            iv_ruleunreservedSimpleNameCS=ruleunreservedSimpleNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunreservedSimpleNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS994); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:445:1: ruleunreservedSimpleNameCS returns [EObject current=null] : (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) ;
    public final EObject ruleunreservedSimpleNameCS() throws RecognitionException {
        EObject current = null;

        EObject this_simpleNameCS_0 = null;

        EObject this_restrictedKeywordCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:450:6: ( (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:451:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:451:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==16||(LA6_0>=19 && LA6_0<=31)) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("451:1: (this_simpleNameCS_0= rulesimpleNameCS | this_restrictedKeywordCS_1= rulerestrictedKeywordCS )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:452:2: this_simpleNameCS_0= rulesimpleNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getSimpleNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS1044);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:465:2: this_restrictedKeywordCS_1= rulerestrictedKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnreservedSimpleNameCSAccess().getRestrictedKeywordCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS1074);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:484:1: entryRulepathNameCS returns [EObject current=null] : iv_rulepathNameCS= rulepathNameCS EOF ;
    public final EObject entryRulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepathNameCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:485:2: (iv_rulepathNameCS= rulepathNameCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:486:2: iv_rulepathNameCS= rulepathNameCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPathNameCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepathNameCS_in_entryRulepathNameCS1109);
            iv_rulepathNameCS=rulepathNameCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepathNameCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepathNameCS1119); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:493:1: rulepathNameCS returns [EObject current=null] : ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) ;
    public final EObject rulepathNameCS() throws RecognitionException {
        EObject current = null;

        EObject lv_simpleNames_0_0 = null;

        EObject lv_simpleNames_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:498:6: ( ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:499:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:499:1: ( ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )* )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:499:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) ) ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:499:2: ( (lv_simpleNames_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:500:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:500:1: (lv_simpleNames_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:501:3: lv_simpleNames_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_rulepathNameCS1165);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:523:2: ( '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:523:4: '::' ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    {
            	    match(input,18,FOLLOW_18_in_rulepathNameCS1176); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:527:1: ( (lv_simpleNames_2_0= ruleunreservedSimpleNameCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:528:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:528:1: (lv_simpleNames_2_0= ruleunreservedSimpleNameCS )
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:529:3: lv_simpleNames_2_0= ruleunreservedSimpleNameCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getPathNameCSAccess().getSimpleNamesUnreservedSimpleNameCSParserRuleCall_1_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS1197);
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
            	    break loop7;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:559:1: entryRuleprimitiveTypeCS returns [EObject current=null] : iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF ;
    public final EObject entryRuleprimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimitiveTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:560:2: (iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:561:2: iv_ruleprimitiveTypeCS= ruleprimitiveTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS1235);
            iv_ruleprimitiveTypeCS=ruleprimitiveTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimitiveTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimitiveTypeCS1245); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:568:1: ruleprimitiveTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) ;
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:573:6: ( ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:574:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:574:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            case 21:
                {
                alt8=3;
                }
                break;
            case 22:
                {
                alt8=4;
                }
                break;
            case 23:
                {
                alt8=5;
                }
                break;
            case 24:
                {
                alt8=6;
                }
                break;
            case 25:
                {
                alt8=7;
                }
                break;
            case 26:
                {
                alt8=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("574:1: ( ( (lv_value_0_0= 'Boolean' ) ) | ( (lv_value_1_0= 'Integer' ) ) | ( (lv_value_2_0= 'Real' ) ) | ( (lv_value_3_0= 'String' ) ) | ( (lv_value_4_0= 'UnlimitedNatural' ) ) | ( (lv_value_5_0= 'OclAny' ) ) | ( (lv_value_6_0= 'OclInvalid' ) ) | ( (lv_value_7_0= 'OclVoid' ) ) )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:574:2: ( (lv_value_0_0= 'Boolean' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:574:2: ( (lv_value_0_0= 'Boolean' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:575:1: (lv_value_0_0= 'Boolean' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:575:1: (lv_value_0_0= 'Boolean' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:576:3: lv_value_0_0= 'Boolean'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleprimitiveTypeCS1288); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:596:6: ( (lv_value_1_0= 'Integer' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:596:6: ( (lv_value_1_0= 'Integer' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:597:1: (lv_value_1_0= 'Integer' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:597:1: (lv_value_1_0= 'Integer' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:598:3: lv_value_1_0= 'Integer'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleprimitiveTypeCS1325); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:618:6: ( (lv_value_2_0= 'Real' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:618:6: ( (lv_value_2_0= 'Real' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:619:1: (lv_value_2_0= 'Real' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:619:1: (lv_value_2_0= 'Real' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:620:3: lv_value_2_0= 'Real'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleprimitiveTypeCS1362); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:640:6: ( (lv_value_3_0= 'String' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:640:6: ( (lv_value_3_0= 'String' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:641:1: (lv_value_3_0= 'String' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:641:1: (lv_value_3_0= 'String' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:642:3: lv_value_3_0= 'String'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleprimitiveTypeCS1399); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:662:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:662:6: ( (lv_value_4_0= 'UnlimitedNatural' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:663:1: (lv_value_4_0= 'UnlimitedNatural' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:663:1: (lv_value_4_0= 'UnlimitedNatural' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:664:3: lv_value_4_0= 'UnlimitedNatural'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleprimitiveTypeCS1436); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:684:6: ( (lv_value_5_0= 'OclAny' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:684:6: ( (lv_value_5_0= 'OclAny' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:685:1: (lv_value_5_0= 'OclAny' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:685:1: (lv_value_5_0= 'OclAny' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:686:3: lv_value_5_0= 'OclAny'
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleprimitiveTypeCS1473); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:706:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:706:6: ( (lv_value_6_0= 'OclInvalid' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:707:1: (lv_value_6_0= 'OclInvalid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:707:1: (lv_value_6_0= 'OclInvalid' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:708:3: lv_value_6_0= 'OclInvalid'
                    {
                    lv_value_6_0=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleprimitiveTypeCS1510); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:728:6: ( (lv_value_7_0= 'OclVoid' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:728:6: ( (lv_value_7_0= 'OclVoid' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:729:1: (lv_value_7_0= 'OclVoid' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:729:1: (lv_value_7_0= 'OclVoid' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:730:3: lv_value_7_0= 'OclVoid'
                    {
                    lv_value_7_0=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleprimitiveTypeCS1547); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:757:1: entryRuleCollectionTypeIdentifierCS returns [EObject current=null] : iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF ;
    public final EObject entryRuleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeIdentifierCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:758:2: (iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:759:2: iv_ruleCollectionTypeIdentifierCS= ruleCollectionTypeIdentifierCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeIdentifierCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS1596);
            iv_ruleCollectionTypeIdentifierCS=ruleCollectionTypeIdentifierCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifierCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS1606); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:766:1: ruleCollectionTypeIdentifierCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) ;
    public final EObject ruleCollectionTypeIdentifierCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;
        Token lv_value_2_0=null;
        Token lv_value_3_0=null;
        Token lv_value_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:771:6: ( ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:772:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:772:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 29:
                {
                alt9=3;
                }
                break;
            case 30:
                {
                alt9=4;
                }
                break;
            case 31:
                {
                alt9=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("772:1: ( ( (lv_value_0_0= 'Set' ) ) | ( (lv_value_1_0= 'Bag' ) ) | ( (lv_value_2_0= 'Sequence' ) ) | ( (lv_value_3_0= 'Collection' ) ) | ( (lv_value_4_0= 'OrderedSet' ) ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:772:2: ( (lv_value_0_0= 'Set' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:772:2: ( (lv_value_0_0= 'Set' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:773:1: (lv_value_0_0= 'Set' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:773:1: (lv_value_0_0= 'Set' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:774:3: lv_value_0_0= 'Set'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleCollectionTypeIdentifierCS1649); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:794:6: ( (lv_value_1_0= 'Bag' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:794:6: ( (lv_value_1_0= 'Bag' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:795:1: (lv_value_1_0= 'Bag' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:795:1: (lv_value_1_0= 'Bag' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:796:3: lv_value_1_0= 'Bag'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleCollectionTypeIdentifierCS1686); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:816:6: ( (lv_value_2_0= 'Sequence' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:816:6: ( (lv_value_2_0= 'Sequence' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:817:1: (lv_value_2_0= 'Sequence' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:817:1: (lv_value_2_0= 'Sequence' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:818:3: lv_value_2_0= 'Sequence'
                    {
                    lv_value_2_0=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_ruleCollectionTypeIdentifierCS1723); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:838:6: ( (lv_value_3_0= 'Collection' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:838:6: ( (lv_value_3_0= 'Collection' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:839:1: (lv_value_3_0= 'Collection' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:839:1: (lv_value_3_0= 'Collection' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:840:3: lv_value_3_0= 'Collection'
                    {
                    lv_value_3_0=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleCollectionTypeIdentifierCS1760); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:860:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:860:6: ( (lv_value_4_0= 'OrderedSet' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:861:1: (lv_value_4_0= 'OrderedSet' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:861:1: (lv_value_4_0= 'OrderedSet' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:862:3: lv_value_4_0= 'OrderedSet'
                    {
                    lv_value_4_0=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleCollectionTypeIdentifierCS1797); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:889:1: entryRuletypeCS returns [EObject current=null] : iv_ruletypeCS= ruletypeCS EOF ;
    public final EObject entryRuletypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:890:2: (iv_ruletypeCS= ruletypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:891:2: iv_ruletypeCS= ruletypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletypeCS_in_entryRuletypeCS1846);
            iv_ruletypeCS=ruletypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletypeCS1856); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:898:1: ruletypeCS returns [EObject current=null] : (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) ;
    public final EObject ruletypeCS() throws RecognitionException {
        EObject current = null;

        EObject this_primitiveTypeCS_0 = null;

        EObject this_pathNameCS_1 = null;

        EObject this_collectionTypeCS_2 = null;

        EObject this_tupleTypeCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:903:6: ( (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:904:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:904:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt10=3;
                }
                break;
            case 16:
                {
                alt10=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("904:1: (this_primitiveTypeCS_0= ruleprimitiveTypeCS | this_pathNameCS_1= rulepathNameCS | this_collectionTypeCS_2= rulecollectionTypeCS | this_tupleTypeCS_3= ruletupleTypeCS )", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:905:2: this_primitiveTypeCS_0= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPrimitiveTypeCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS1906);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:918:2: this_pathNameCS_1= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getPathNameCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruletypeCS1936);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:931:2: this_collectionTypeCS_2= rulecollectionTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getCollectionTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecollectionTypeCS_in_ruletypeCS1966);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:944:2: this_tupleTypeCS_3= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeCSAccess().getTupleTypeCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruletypeCS1996);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:963:1: entryRulecollectionTypeCS returns [EObject current=null] : iv_rulecollectionTypeCS= rulecollectionTypeCS EOF ;
    public final EObject entryRulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecollectionTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:964:2: (iv_rulecollectionTypeCS= rulecollectionTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:965:2: iv_rulecollectionTypeCS= rulecollectionTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS2031);
            iv_rulecollectionTypeCS=rulecollectionTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecollectionTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecollectionTypeCS2041); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:972:1: rulecollectionTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? ) ;
    public final EObject rulecollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;

        EObject lv_typeCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:977:6: ( ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:978:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:978:1: ( ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:978:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) ) ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )?
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:978:2: ( (lv_value_0_0= ruleCollectionTypeIdentifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:979:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:979:1: (lv_value_0_0= ruleCollectionTypeIdentifierCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:980:3: lv_value_0_0= ruleCollectionTypeIdentifierCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getValueCollectionTypeIdentifierCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS2087);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1002:2: ( '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred24()) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1002:4: '(' ( (lv_typeCS_2_0= ruletypeCS ) ) ')'
                    {
                    match(input,32,FOLLOW_32_in_rulecollectionTypeCS2098); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1006:1: ( (lv_typeCS_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1007:1: (lv_typeCS_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1007:1: (lv_typeCS_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1008:3: lv_typeCS_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_rulecollectionTypeCS2119);
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

                    match(input,33,FOLLOW_33_in_rulecollectionTypeCS2129); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1042:1: entryRuletupleTypeCS returns [EObject current=null] : iv_ruletupleTypeCS= ruletupleTypeCS EOF ;
    public final EObject entryRuletupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletupleTypeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1043:2: (iv_ruletupleTypeCS= ruletupleTypeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1044:2: iv_ruletupleTypeCS= ruletupleTypeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleTypeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS2167);
            iv_ruletupleTypeCS=ruletupleTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletupleTypeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletupleTypeCS2177); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1051:1: ruletupleTypeCS returns [EObject current=null] : ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) ;
    public final EObject ruletupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_part_2_0 = null;

        EObject lv_part_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1056:6: ( ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1057:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1057:1: ( ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1057:2: ( (lv_value_0_0= 'Tuple' ) ) '(' ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )? ')'
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1057:2: ( (lv_value_0_0= 'Tuple' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:1: (lv_value_0_0= 'Tuple' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1058:1: (lv_value_0_0= 'Tuple' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1059:3: lv_value_0_0= 'Tuple'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_ruletupleTypeCS2220); if (failed) return current;
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

            match(input,32,FOLLOW_32_in_ruletupleTypeCS2243); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1082:1: ( ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1082:2: ( (lv_part_2_0= ruletuplePartCS ) ) ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1082:2: ( (lv_part_2_0= ruletuplePartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1083:1: (lv_part_2_0= ruletuplePartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1083:1: (lv_part_2_0= ruletuplePartCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1084:3: lv_part_2_0= ruletuplePartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_0_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS2265);
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1106:2: ( ',' ( (lv_part_4_0= ruletuplePartCS ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==34) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1106:4: ',' ( (lv_part_4_0= ruletuplePartCS ) )
                    	    {
                    	    match(input,34,FOLLOW_34_in_ruletupleTypeCS2276); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTupleTypeCSAccess().getCommaKeyword_2_1_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1110:1: ( (lv_part_4_0= ruletuplePartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1111:1: (lv_part_4_0= ruletuplePartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1111:1: (lv_part_4_0= ruletuplePartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1112:3: lv_part_4_0= ruletuplePartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTupleTypeCSAccess().getPartTuplePartCSParserRuleCall_2_1_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruletuplePartCS_in_ruletupleTypeCS2297);
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
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,33,FOLLOW_33_in_ruletupleTypeCS2311); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1146:1: entryRuletuplePartCS returns [EObject current=null] : iv_ruletuplePartCS= ruletuplePartCS EOF ;
    public final EObject entryRuletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletuplePartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1147:2: (iv_ruletuplePartCS= ruletuplePartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1148:2: iv_ruletuplePartCS= ruletuplePartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTuplePartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS2347);
            iv_ruletuplePartCS=ruletuplePartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruletuplePartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuletuplePartCS2357); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1155:1: ruletuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) ;
    public final EObject ruletuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1160:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1161:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1161:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1161:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1161:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1162:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1162:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1163:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruletuplePartCS2403);
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

            match(input,35,FOLLOW_35_in_ruletuplePartCS2413); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTuplePartCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1189:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1190:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1190:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1191:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTuplePartCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruletuplePartCS2434);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1221:1: entryRuleLiteralExpCS returns [EObject current=null] : iv_ruleLiteralExpCS= ruleLiteralExpCS EOF ;
    public final EObject entryRuleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1222:2: (iv_ruleLiteralExpCS= ruleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1223:2: iv_ruleLiteralExpCS= ruleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS2470);
            iv_ruleLiteralExpCS=ruleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpCS2480); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1230:1: ruleLiteralExpCS returns [EObject current=null] : (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) ;
    public final EObject ruleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionLiteralExpCS_0 = null;

        EObject this_TupleLiteralExpCS_1 = null;

        EObject this_PrimitiveLiteralExpCS_2 = null;

        EObject this_TypeLiteralExpCS_3 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1235:6: ( (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1236:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1236:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt14=1;
                }
                break;
            case 16:
                {
                int LA14_6 = input.LA(2);

                if ( (synpred28()) ) {
                    alt14=2;
                }
                else if ( (true) ) {
                    alt14=4;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1236:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 14, 6, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING_LITERAL:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt14=3;
                }
                break;
            case RULE_ID:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt14=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1236:1: (this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS | this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS | this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS | this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1237:2: this_CollectionLiteralExpCS_0= ruleCollectionLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS2530);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1250:2: this_TupleLiteralExpCS_1= ruleTupleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTupleLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS2560);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1263:2: this_PrimitiveLiteralExpCS_2= rulePrimitiveLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS2590);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1276:2: this_TypeLiteralExpCS_3= ruleTypeLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getLiteralExpCSAccess().getTypeLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS2620);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1295:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1296:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1297:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS2655);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS2665); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1304:1: ruleCollectionLiteralExpCS returns [EObject current=null] : (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_collectionTypeCS_0 = null;

        EObject lv_collectionLiteralParts_2_0 = null;

        EObject lv_collectionLiteralParts_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1309:6: ( (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1310:1: (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1310:1: (this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1311:2: this_collectionTypeCS_0= rulecollectionTypeCS ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionTypeCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS2715);
            this_collectionTypeCS_0=rulecollectionTypeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_collectionTypeCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1322:1: ( '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1322:3: '{' ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? '}'
                    {
                    match(input,36,FOLLOW_36_in_ruleCollectionLiteralExpCS2725); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1326:1: ( ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=RULE_INT && LA16_0<=RULE_STRING_LITERAL)||(LA16_0>=15 && LA16_0<=17)||(LA16_0>=19 && LA16_0<=32)||(LA16_0>=40 && LA16_0<=44)||LA16_0==55||LA16_0==61||LA16_0==65) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1326:2: ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) ) ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1326:2: ( (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS ) )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1327:1: (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1327:1: (lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1328:3: lv_collectionLiteralParts_2_0= ruleCollectionLiteralPartCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_1_1_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS2747);
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

                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1350:2: ( ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==34) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1350:4: ',' ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) )
                            	    {
                            	    match(input,34,FOLLOW_34_in_ruleCollectionLiteralExpCS2758); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_1_1_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1354:1: ( (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:1: (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1355:1: (lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS )
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1356:3: lv_collectionLiteralParts_4_0= ruleCollectionLiteralPartCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getCollectionLiteralPartsCollectionLiteralPartCSParserRuleCall_1_1_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS2779);
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
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,37,FOLLOW_37_in_ruleCollectionLiteralExpCS2793); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1390:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1391:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1392:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCollectionLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS2831);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS2841); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1399:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1404:6: ( ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1405:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1405:1: ( ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1405:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) ) ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1405:2: ( (lv_expressionCS_0_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1406:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1406:1: (lv_expressionCS_0_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1407:3: lv_expressionCS_0_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSOclExpressionCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS2887);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1429:2: ( '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1429:4: '..' ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    {
                    match(input,38,FOLLOW_38_in_ruleCollectionLiteralPartCS2898); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1433:1: ( (lv_lastExpressionCS_2_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1434:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1434:1: (lv_lastExpressionCS_2_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1435:3: lv_lastExpressionCS_2_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSOclExpressionCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS2919);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1465:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1466:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1467:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS2957);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS2967); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1474:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) ;
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1479:6: ( (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )
            int alt19=7;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                switch ( input.LA(2) ) {
                case 11:
                    {
                    int LA19_7 = input.LA(3);

                    if ( (LA19_7==RULE_INT) ) {
                        int LA19_10 = input.LA(4);

                        if ( (synpred34()) ) {
                            alt19=1;
                        }
                        else if ( (synpred35()) ) {
                            alt19=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 19, 10, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA19_7>=RULE_ID && LA19_7<=RULE_STRING_LITERAL)||(LA19_7>=16 && LA19_7<=17)||(LA19_7>=19 && LA19_7<=32)||(LA19_7>=40 && LA19_7<=44)||LA19_7==61) ) {
                        alt19=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 19, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case 12:
                case 13:
                    {
                    alt19=2;
                    }
                    break;
                case EOF:
                case 14:
                case 15:
                case 32:
                case 33:
                case 34:
                case 37:
                case 38:
                case 39:
                case 42:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 56:
                case 58:
                case 59:
                case 60:
                case 62:
                case 63:
                case 64:
                case 66:
                    {
                    alt19=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 19, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt19=3;
                }
                break;
            case 40:
            case 41:
                {
                alt19=4;
                }
                break;
            case 42:
                {
                alt19=5;
                }
                break;
            case 43:
                {
                alt19=6;
                }
                break;
            case 44:
                {
                alt19=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1480:1: (this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS | this_RealLiteralExpCS_1= ruleRealLiteralExpCS | this_StringLiteralExpCS_2= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_6= ruleNullLiteralExpCS )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1481:2: this_IntegerLiteralExpCS_0= ruleIntegerLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getIntegerLiteralExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS3017);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1494:2: this_RealLiteralExpCS_1= ruleRealLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getRealLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS3047);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1507:2: this_StringLiteralExpCS_2= ruleStringLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS3077);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1520:2: this_BooleanLiteralExpCS_3= ruleBooleanLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS3107);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1533:2: this_UnlimitedNaturalLiteralExpCS_4= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS3137);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1546:2: this_InvalidLiteralExpCS_5= ruleInvalidLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS3167);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1559:2: this_NullLiteralExpCS_6= ruleNullLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS3197);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1578:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1579:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1580:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS3232);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralExpCS3242); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1587:1: ruleTupleLiteralExpCS returns [EObject current=null] : ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_part_3_0 = null;

        EObject lv_part_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1592:6: ( ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1593:1: ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1593:1: ( () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1593:2: () 'Tuple' ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )?
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1593:2: ()
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1594:2: 
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

            match(input,16,FOLLOW_16_in_ruleTupleLiteralExpCS3289); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1611:1: ( '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1611:3: '{' ( (lv_part_3_0= ruleTupleLiteralPartCS ) ) ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )* '}'
                    {
                    match(input,36,FOLLOW_36_in_ruleTupleLiteralExpCS3300); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1615:1: ( (lv_part_3_0= ruleTupleLiteralPartCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1616:1: (lv_part_3_0= ruleTupleLiteralPartCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1616:1: (lv_part_3_0= ruleTupleLiteralPartCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1617:3: lv_part_3_0= ruleTupleLiteralPartCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS3321);
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1639:2: ( ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==34) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1639:4: ',' ( (lv_part_5_0= ruleTupleLiteralPartCS ) )
                    	    {
                    	    match(input,34,FOLLOW_34_in_ruleTupleLiteralExpCS3332); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_2_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1643:1: ( (lv_part_5_0= ruleTupleLiteralPartCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1644:1: (lv_part_5_0= ruleTupleLiteralPartCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1644:1: (lv_part_5_0= ruleTupleLiteralPartCS )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1645:3: lv_part_5_0= ruleTupleLiteralPartCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getPartTupleLiteralPartCSParserRuleCall_2_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS3353);
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
                    	    break loop20;
                        }
                    } while (true);

                    match(input,37,FOLLOW_37_in_ruleTupleLiteralExpCS3365); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1679:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1680:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1681:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTupleLiteralPartCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS3403);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralPartCS3413); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1688:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1693:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1694:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1694:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1694:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1694:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1695:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1695:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1696:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS3459);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1718:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1718:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,35,FOLLOW_35_in_ruleTupleLiteralPartCS3470); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1722:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1723:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1723:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1724:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS3491);
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

            match(input,39,FOLLOW_39_in_ruleTupleLiteralPartCS3503); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1750:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1751:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1751:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1752:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS3524);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1782:1: entryRuleIntegerLiteralExpCS returns [EObject current=null] : iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF ;
    public final EObject entryRuleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1783:2: (iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1784:2: iv_ruleIntegerLiteralExpCS= ruleIntegerLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIntegerLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS3560);
            iv_ruleIntegerLiteralExpCS=ruleIntegerLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIntegerLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS3570); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1791:1: ruleIntegerLiteralExpCS returns [EObject current=null] : ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) ;
    public final EObject ruleIntegerLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_integerSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1796:6: ( ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1797:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1797:1: ( (lv_integerSymbol_0_0= ruleINTEGER_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1798:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1798:1: (lv_integerSymbol_0_0= ruleINTEGER_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1799:3: lv_integerSymbol_0_0= ruleINTEGER_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralExpCSAccess().getIntegerSymbolINTEGER_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS3615);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1829:1: entryRuleRealLiteralExpCS returns [EObject current=null] : iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF ;
    public final EObject entryRuleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1830:2: (iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1831:2: iv_ruleRealLiteralExpCS= ruleRealLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRealLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS3650);
            iv_ruleRealLiteralExpCS=ruleRealLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRealLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralExpCS3660); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1838:1: ruleRealLiteralExpCS returns [EObject current=null] : ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) ;
    public final EObject ruleRealLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_realSymbol_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1843:6: ( ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1844:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1844:1: ( (lv_realSymbol_0_0= ruleREAL_LITERAL ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1845:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1845:1: (lv_realSymbol_0_0= ruleREAL_LITERAL )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1846:3: lv_realSymbol_0_0= ruleREAL_LITERAL
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRealLiteralExpCSAccess().getRealSymbolREAL_LITERALParserRuleCall_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS3705);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1876:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1877:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1878:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getStringLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS3740);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralExpCS3750); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1885:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringSymbol_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1890:6: ( ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+ )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1891:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1891:1: ( (lv_stringSymbol_0_0= RULE_STRING_LITERAL ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_STRING_LITERAL) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1892:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1892:1: (lv_stringSymbol_0_0= RULE_STRING_LITERAL )
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1893:3: lv_stringSymbol_0_0= RULE_STRING_LITERAL
            	    {
            	    lv_stringSymbol_0_0=(Token)input.LT(1);
            	    match(input,RULE_STRING_LITERAL,FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS3791); if (failed) return current;
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
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1923:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1924:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1925:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBooleanLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS3832);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS3842); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1932:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1937:6: ( ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1938:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1938:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            else if ( (LA24_0==41) ) {
                alt24=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("1938:1: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1938:2: ( (lv_value_0_0= 'true' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1938:2: ( (lv_value_0_0= 'true' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1939:1: (lv_value_0_0= 'true' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1939:1: (lv_value_0_0= 'true' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1940:3: lv_value_0_0= 'true'
                    {
                    lv_value_0_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleBooleanLiteralExpCS3885); if (failed) return current;
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1960:6: ( (lv_value_1_0= 'false' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1960:6: ( (lv_value_1_0= 'false' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1961:1: (lv_value_1_0= 'false' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1961:1: (lv_value_1_0= 'false' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1962:3: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleBooleanLiteralExpCS3922); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1989:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1990:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1991:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS3971);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS3981); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1998:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2003:6: ( ( () '*' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2004:1: ( () '*' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2004:1: ( () '*' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2004:2: () '*'
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2004:2: ()
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2005:2: 
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

            match(input,42,FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS4028); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2030:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2031:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2032:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getInvalidLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS4064);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS4074); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2039:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2044:6: ( ( () 'invalid' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2045:1: ( () 'invalid' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2045:1: ( () 'invalid' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2045:2: () 'invalid'
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2045:2: ()
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2046:2: 
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

            match(input,43,FOLLOW_43_in_ruleInvalidLiteralExpCS4121); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2071:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2072:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2073:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getNullLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS4157);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralExpCS4167); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2080:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2085:6: ( ( () 'null' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2086:1: ( () 'null' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2086:1: ( () 'null' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2086:2: () 'null'
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2086:2: ()
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2087:2: 
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

            match(input,44,FOLLOW_44_in_ruleNullLiteralExpCS4214); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2112:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2113:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2114:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeLiteralExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS4250);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralExpCS4260); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2121:1: ruleTypeLiteralExpCS returns [EObject current=null] : (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_pathNameCS_0 = null;

        EObject this_primitiveTypeCS_1 = null;

        EObject this_tupleTypeCS_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2126:6: ( (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2127:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2127:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )
            int alt25=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt25=1;
                }
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                {
                alt25=2;
                }
                break;
            case 16:
                {
                alt25=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2127:1: (this_pathNameCS_0= rulepathNameCS | this_primitiveTypeCS_1= ruleprimitiveTypeCS | this_tupleTypeCS_2= ruletupleTypeCS )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2128:2: this_pathNameCS_0= rulepathNameCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPathNameCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS4310);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2141:2: this_primitiveTypeCS_1= ruleprimitiveTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getPrimitiveTypeCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS4340);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2154:2: this_tupleTypeCS_2= ruletupleTypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getTupleTypeCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS4370);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2173:1: entryRuleOclExpressionCS returns [EObject current=null] : iv_ruleOclExpressionCS= ruleOclExpressionCS EOF ;
    public final EObject entryRuleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclExpressionCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2174:2: (iv_ruleOclExpressionCS= ruleOclExpressionCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2175:2: iv_ruleOclExpressionCS= ruleOclExpressionCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOclExpressionCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS4405);
            iv_ruleOclExpressionCS=ruleOclExpressionCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOclExpressionCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOclExpressionCS4415); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2182:1: ruleOclExpressionCS returns [EObject current=null] : (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) ;
    public final EObject ruleOclExpressionCS() throws RecognitionException {
        EObject current = null;

        EObject this_impliesCS_0 = null;

        EObject this_LetExpCS_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2187:6: ( (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2188:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2188:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_INT && LA26_0<=RULE_STRING_LITERAL)||(LA26_0>=15 && LA26_0<=17)||(LA26_0>=19 && LA26_0<=32)||(LA26_0>=40 && LA26_0<=44)||LA26_0==55||LA26_0==61) ) {
                alt26=1;
            }
            else if ( (LA26_0==65) ) {
                alt26=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2188:1: (this_impliesCS_0= ruleimpliesCS | this_LetExpCS_1= ruleLetExpCS )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2189:2: this_impliesCS_0= ruleimpliesCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getImpliesCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS4465);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2202:2: this_LetExpCS_1= ruleLetExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getOclExpressionCSAccess().getLetExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS4495);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2221:1: entryRuleimpliesCS returns [EObject current=null] : iv_ruleimpliesCS= ruleimpliesCS EOF ;
    public final EObject entryRuleimpliesCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleimpliesCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2222:2: (iv_ruleimpliesCS= ruleimpliesCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2223:2: iv_ruleimpliesCS= ruleimpliesCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImpliesCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS4530);
            iv_ruleimpliesCS=ruleimpliesCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleimpliesCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleimpliesCS4540); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2230:1: ruleimpliesCS returns [EObject current=null] : (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleimpliesCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_xorCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2235:6: ( (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2236:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2236:1: (this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2237:2: this_xorCS_0= rulexorCS ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getXorCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulexorCS_in_ruleimpliesCS4590);
            this_xorCS_0=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_xorCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:1: ( () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==45) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred49()) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: () ( (lv_op_2_0= 'implies' ) ) ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2249:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2267:2: ( (lv_op_2_0= 'implies' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2268:1: (lv_op_2_0= 'implies' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2268:1: (lv_op_2_0= 'implies' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2269:3: lv_op_2_0= 'implies'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleimpliesCS4620); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2288:2: ( ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2289:1: ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2289:1: ( (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2290:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2290:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0>=RULE_INT && LA27_0<=RULE_STRING_LITERAL)||(LA27_0>=15 && LA27_0<=17)||(LA27_0>=19 && LA27_0<=32)||(LA27_0>=40 && LA27_0<=44)||LA27_0==55||LA27_0==61) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==65) ) {
                        alt27=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2290:1: (lv_argument_3_1= ruleimpliesCS | lv_argument_3_2= ruleLetExpCS )", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2291:3: lv_argument_3_1= ruleimpliesCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentImpliesCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleimpliesCS_in_ruleimpliesCS4656);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2312:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleimpliesCS4675);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2344:1: entryRulexorCS returns [EObject current=null] : iv_rulexorCS= rulexorCS EOF ;
    public final EObject entryRulexorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulexorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2345:2: (iv_rulexorCS= rulexorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2346:2: iv_rulexorCS= rulexorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getXorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulexorCS_in_entryRulexorCS4716);
            iv_rulexorCS=rulexorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulexorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulexorCS4726); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2353:1: rulexorCS returns [EObject current=null] : (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulexorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_orCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2358:6: ( (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2359:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2359:1: (this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2360:2: this_orCS_0= ruleorCS ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getOrCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleorCS_in_rulexorCS4776);
            this_orCS_0=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_orCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:1: ( () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==46) ) {
                int LA30_1 = input.LA(2);

                if ( (synpred51()) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:2: () ( (lv_op_2_0= 'xor' ) ) ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2372:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2390:2: ( (lv_op_2_0= 'xor' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: (lv_op_2_0= 'xor' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: (lv_op_2_0= 'xor' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2392:3: lv_op_2_0= 'xor'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_rulexorCS4806); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2411:2: ( ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: ( (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2413:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2413:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=RULE_INT && LA29_0<=RULE_STRING_LITERAL)||(LA29_0>=15 && LA29_0<=17)||(LA29_0>=19 && LA29_0<=32)||(LA29_0>=40 && LA29_0<=44)||LA29_0==55||LA29_0==61) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==65) ) {
                        alt29=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2413:1: (lv_argument_3_1= rulexorCS | lv_argument_3_2= ruleLetExpCS )", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2414:3: lv_argument_3_1= rulexorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentXorCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulexorCS_in_rulexorCS4842);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2435:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulexorCS4861);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2467:1: entryRuleorCS returns [EObject current=null] : iv_ruleorCS= ruleorCS EOF ;
    public final EObject entryRuleorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2468:2: (iv_ruleorCS= ruleorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2469:2: iv_ruleorCS= ruleorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOrCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleorCS_in_entryRuleorCS4902);
            iv_ruleorCS=ruleorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleorCS4912); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2476:1: ruleorCS returns [EObject current=null] : (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleorCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_andCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2481:6: ( (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2482:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2482:1: (this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2483:2: this_andCS_0= ruleandCS ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getAndCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleandCS_in_ruleorCS4962);
            this_andCS_0=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_andCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:1: ( () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==47) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred53()) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:2: () ( (lv_op_2_0= 'or' ) ) ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2495:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2513:2: ( (lv_op_2_0= 'or' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:1: (lv_op_2_0= 'or' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:1: (lv_op_2_0= 'or' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2515:3: lv_op_2_0= 'or'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,47,FOLLOW_47_in_ruleorCS4992); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2534:2: ( ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2535:1: ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2535:1: ( (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2536:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2536:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=RULE_INT && LA31_0<=RULE_STRING_LITERAL)||(LA31_0>=15 && LA31_0<=17)||(LA31_0>=19 && LA31_0<=32)||(LA31_0>=40 && LA31_0<=44)||LA31_0==55||LA31_0==61) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==65) ) {
                        alt31=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2536:1: (lv_argument_3_1= ruleorCS | lv_argument_3_2= ruleLetExpCS )", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2537:3: lv_argument_3_1= ruleorCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentOrCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleorCS_in_ruleorCS5028);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2558:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleorCS5047);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2590:1: entryRuleandCS returns [EObject current=null] : iv_ruleandCS= ruleandCS EOF ;
    public final EObject entryRuleandCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleandCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2591:2: (iv_ruleandCS= ruleandCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2592:2: iv_ruleandCS= ruleandCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAndCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleandCS_in_entryRuleandCS5088);
            iv_ruleandCS=ruleandCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleandCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleandCS5098); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2599:1: ruleandCS returns [EObject current=null] : (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleandCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_equalityCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2604:6: ( (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2605:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2605:1: (this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2606:2: this_equalityCS_0= ruleequalityCS ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getEqualityCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleequalityCS_in_ruleandCS5148);
            this_equalityCS_0=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_equalityCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:1: ( () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred55()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:2: () ( (lv_op_2_0= 'and' ) ) ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2618:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2636:2: ( (lv_op_2_0= 'and' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2637:1: (lv_op_2_0= 'and' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2637:1: (lv_op_2_0= 'and' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2638:3: lv_op_2_0= 'and'
                    {
                    lv_op_2_0=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_ruleandCS5178); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2657:2: ( ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2658:1: ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2658:1: ( (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2659:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2659:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=RULE_INT && LA33_0<=RULE_STRING_LITERAL)||(LA33_0>=15 && LA33_0<=17)||(LA33_0>=19 && LA33_0<=32)||(LA33_0>=40 && LA33_0<=44)||LA33_0==55||LA33_0==61) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==65) ) {
                        alt33=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2659:1: (lv_argument_3_1= ruleandCS | lv_argument_3_2= ruleLetExpCS )", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:3: lv_argument_3_1= ruleandCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentAndCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleandCS_in_ruleandCS5214);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2681:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleandCS5233);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2713:1: entryRuleequalityCS returns [EObject current=null] : iv_ruleequalityCS= ruleequalityCS EOF ;
    public final EObject entryRuleequalityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleequalityCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2714:2: (iv_ruleequalityCS= ruleequalityCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2715:2: iv_ruleequalityCS= ruleequalityCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEqualityCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleequalityCS_in_entryRuleequalityCS5274);
            iv_ruleequalityCS=ruleequalityCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleequalityCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleequalityCS5284); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2722:1: ruleequalityCS returns [EObject current=null] : (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleequalityCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_relationalCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2727:6: ( (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2728:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2728:1: (this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2729:2: this_relationalCS_0= rulerelationalCS ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getRelationalCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulerelationalCS_in_ruleequalityCS5334);
            this_relationalCS_0=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_relationalCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:1: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==39) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred58()) ) {
                    alt37=1;
                }
            }
            else if ( (LA37_0==49) ) {
                int LA37_2 = input.LA(2);

                if ( (synpred58()) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:2: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) ) ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2741:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:2: ( ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2760:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2760:1: ( (lv_op_2_1= '=' | lv_op_2_2= '<>' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2761:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2761:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==39) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==49) ) {
                        alt35=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2761:1: (lv_op_2_1= '=' | lv_op_2_2= '<>' )", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2762:3: lv_op_2_1= '='
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,39,FOLLOW_39_in_ruleequalityCS5366); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2780:8: lv_op_2_2= '<>'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,49,FOLLOW_49_in_ruleequalityCS5395); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2801:2: ( ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:1: ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:1: ( (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2803:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2803:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=RULE_INT && LA36_0<=RULE_STRING_LITERAL)||(LA36_0>=15 && LA36_0<=17)||(LA36_0>=19 && LA36_0<=32)||(LA36_0>=40 && LA36_0<=44)||LA36_0==55||LA36_0==61) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==65) ) {
                        alt36=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2803:1: (lv_argument_3_1= ruleequalityCS | lv_argument_3_2= ruleLetExpCS )", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2804:3: lv_argument_3_1= ruleequalityCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentEqualityCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleequalityCS_in_ruleequalityCS5434);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2825:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleequalityCS5453);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2857:1: entryRulerelationalCS returns [EObject current=null] : iv_rulerelationalCS= rulerelationalCS EOF ;
    public final EObject entryRulerelationalCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerelationalCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2858:2: (iv_rulerelationalCS= rulerelationalCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2859:2: iv_rulerelationalCS= rulerelationalCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRelationalCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulerelationalCS_in_entryRulerelationalCS5494);
            iv_rulerelationalCS=rulerelationalCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulerelationalCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulerelationalCS5504); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2866:1: rulerelationalCS returns [EObject current=null] : (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2871:6: ( (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2872:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2872:1: (this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2873:2: this_additiveCS_0= ruleadditiveCS ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getAdditiveCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_rulerelationalCS5554);
            this_additiveCS_0=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_additiveCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:1: ( () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt40=2;
            switch ( input.LA(1) ) {
                case 50:
                    {
                    int LA40_1 = input.LA(2);

                    if ( (synpred63()) ) {
                        alt40=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (synpred63()) ) {
                        alt40=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (synpred63()) ) {
                        alt40=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA40_4 = input.LA(2);

                    if ( (synpred63()) ) {
                        alt40=1;
                    }
                    }
                    break;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:2: () ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) ) ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2885:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2903:2: ( ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:1: ( (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2905:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2905:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )
                    int alt38=4;
                    switch ( input.LA(1) ) {
                    case 50:
                        {
                        alt38=1;
                        }
                        break;
                    case 51:
                        {
                        alt38=2;
                        }
                        break;
                    case 52:
                        {
                        alt38=3;
                        }
                        break;
                    case 53:
                        {
                        alt38=4;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2905:1: (lv_op_2_1= '>' | lv_op_2_2= '<' | lv_op_2_3= '>=' | lv_op_2_4= '<=' )", 38, 0, input);

                        throw nvae;
                    }

                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2906:3: lv_op_2_1= '>'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,50,FOLLOW_50_in_rulerelationalCS5586); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2924:8: lv_op_2_2= '<'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,51,FOLLOW_51_in_rulerelationalCS5615); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2942:8: lv_op_2_3= '>='
                            {
                            lv_op_2_3=(Token)input.LT(1);
                            match(input,52,FOLLOW_52_in_rulerelationalCS5644); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2960:8: lv_op_2_4= '<='
                            {
                            lv_op_2_4=(Token)input.LT(1);
                            match(input,53,FOLLOW_53_in_rulerelationalCS5673); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2981:2: ( ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2982:1: ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2982:1: ( (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2983:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2983:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=RULE_INT && LA39_0<=RULE_STRING_LITERAL)||(LA39_0>=15 && LA39_0<=17)||(LA39_0>=19 && LA39_0<=32)||(LA39_0>=40 && LA39_0<=44)||LA39_0==55||LA39_0==61) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==65) ) {
                        alt39=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("2983:1: (lv_argument_3_1= rulerelationalCS | lv_argument_3_2= ruleLetExpCS )", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2984:3: lv_argument_3_1= rulerelationalCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentRelationalCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulerelationalCS_in_rulerelationalCS5712);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3005:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulerelationalCS5731);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3037:1: entryRuleadditiveCS returns [EObject current=null] : iv_ruleadditiveCS= ruleadditiveCS EOF ;
    public final EObject entryRuleadditiveCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleadditiveCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3038:2: (iv_ruleadditiveCS= ruleadditiveCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3039:2: iv_ruleadditiveCS= ruleadditiveCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAdditiveCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS5772);
            iv_ruleadditiveCS=ruleadditiveCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleadditiveCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleadditiveCS5782); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3046:1: ruleadditiveCS returns [EObject current=null] : (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject ruleadditiveCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_multiplicativeCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3051:6: ( (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3052:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3052:1: (this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3053:2: this_multiplicativeCS_0= rulemultiplicativeCS ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getMultiplicativeCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS5832);
            this_multiplicativeCS_0=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_multiplicativeCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:1: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==14) ) {
                int LA43_1 = input.LA(2);

                if ( (synpred66()) ) {
                    alt43=1;
                }
            }
            else if ( (LA43_0==15) ) {
                int LA43_2 = input.LA(2);

                if ( (synpred66()) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) ) ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3065:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3083:2: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3084:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3084:1: ( (lv_op_2_1= '+' | lv_op_2_2= '-' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3085:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3085:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==14) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==15) ) {
                        alt41=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3085:1: (lv_op_2_1= '+' | lv_op_2_2= '-' )", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3086:3: lv_op_2_1= '+'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,14,FOLLOW_14_in_ruleadditiveCS5864); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3104:8: lv_op_2_2= '-'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,15,FOLLOW_15_in_ruleadditiveCS5893); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3125:2: ( ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3126:1: ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3126:1: ( (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3127:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3127:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_INT && LA42_0<=RULE_STRING_LITERAL)||(LA42_0>=15 && LA42_0<=17)||(LA42_0>=19 && LA42_0<=32)||(LA42_0>=40 && LA42_0<=44)||LA42_0==55||LA42_0==61) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==65) ) {
                        alt42=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3127:1: (lv_argument_3_1= ruleadditiveCS | lv_argument_3_2= ruleLetExpCS )", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3128:3: lv_argument_3_1= ruleadditiveCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentAdditiveCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleadditiveCS_in_ruleadditiveCS5932);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3149:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_ruleadditiveCS5951);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3181:1: entryRulemultiplicativeCS returns [EObject current=null] : iv_rulemultiplicativeCS= rulemultiplicativeCS EOF ;
    public final EObject entryRulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiplicativeCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3182:2: (iv_rulemultiplicativeCS= rulemultiplicativeCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3183:2: iv_rulemultiplicativeCS= rulemultiplicativeCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMultiplicativeCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS5992);
            iv_rulemultiplicativeCS=rulemultiplicativeCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulemultiplicativeCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiplicativeCS6002); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3190:1: rulemultiplicativeCS returns [EObject current=null] : (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) ;
    public final EObject rulemultiplicativeCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_unaryCS_0 = null;

        EObject lv_argument_3_1 = null;

        EObject lv_argument_3_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3195:6: ( (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3196:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3196:1: (this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3197:2: this_unaryCS_0= ruleunaryCS ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getUnaryCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleunaryCS_in_rulemultiplicativeCS6052);
            this_unaryCS_0=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_unaryCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3208:1: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==42||LA46_0==54) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3208:2: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3208:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3209:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3227:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3228:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3229:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3229:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==42) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==54) ) {
                        alt44=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3229:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3230:3: lv_op_2_1= '*'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,42,FOLLOW_42_in_rulemultiplicativeCS6084); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3248:8: lv_op_2_2= '/'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,54,FOLLOW_54_in_rulemultiplicativeCS6113); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3269:2: ( ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3270:1: ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3270:1: ( (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3271:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3271:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_INT && LA45_0<=RULE_STRING_LITERAL)||(LA45_0>=15 && LA45_0<=17)||(LA45_0>=19 && LA45_0<=32)||(LA45_0>=40 && LA45_0<=44)||LA45_0==55||LA45_0==61) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==65) ) {
                        alt45=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3271:1: (lv_argument_3_1= rulemultiplicativeCS | lv_argument_3_2= ruleLetExpCS )", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3272:3: lv_argument_3_1= rulemultiplicativeCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getArgumentMultiplicativeCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS6152);
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3293:8: lv_argument_3_2= ruleLetExpCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS6171);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3325:1: entryRuleunaryCS returns [EObject current=null] : iv_ruleunaryCS= ruleunaryCS EOF ;
    public final EObject entryRuleunaryCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleunaryCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3326:2: (iv_ruleunaryCS= ruleunaryCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3327:2: iv_ruleunaryCS= ruleunaryCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getUnaryCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleunaryCS_in_entryRuleunaryCS6212);
            iv_ruleunaryCS=ruleunaryCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleunaryCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleunaryCS6222); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3334:1: ruleunaryCS returns [EObject current=null] : (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) ;
    public final EObject ruleunaryCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_callingExpCS_0 = null;

        EObject lv_source_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3339:6: ( (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3340:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3340:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_INT && LA48_0<=RULE_STRING_LITERAL)||(LA48_0>=16 && LA48_0<=17)||(LA48_0>=19 && LA48_0<=32)||(LA48_0>=40 && LA48_0<=44)||LA48_0==61) ) {
                alt48=1;
            }
            else if ( (LA48_0==15||LA48_0==55) ) {
                alt48=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3340:1: (this_callingExpCS_0= rulecallingExpCS | ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) ) )", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3341:2: this_callingExpCS_0= rulecallingExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getCallingExpCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_rulecallingExpCS_in_ruleunaryCS6272);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3353:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3353:6: ( () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3353:7: () ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) ) ( (lv_source_3_0= ruleunaryCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3353:7: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3354:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3367:2: ( ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3368:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3368:1: ( (lv_op_2_1= '-' | lv_op_2_2= 'not' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3369:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3369:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==15) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==55) ) {
                        alt47=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3369:1: (lv_op_2_1= '-' | lv_op_2_2= 'not' )", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3370:3: lv_op_2_1= '-'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,15,FOLLOW_15_in_ruleunaryCS6310); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3388:8: lv_op_2_2= 'not'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,55,FOLLOW_55_in_ruleunaryCS6339); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3409:2: ( (lv_source_3_0= ruleunaryCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3410:1: (lv_source_3_0= ruleunaryCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3410:1: (lv_source_3_0= ruleunaryCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3411:3: lv_source_3_0= ruleunaryCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getUnaryCSAccess().getSourceUnaryCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleunaryCS_in_ruleunaryCS6376);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3441:1: entryRulecallingExpCS returns [EObject current=null] : iv_rulecallingExpCS= rulecallingExpCS EOF ;
    public final EObject entryRulecallingExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecallingExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3442:2: (iv_rulecallingExpCS= rulecallingExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3443:2: iv_rulecallingExpCS= rulecallingExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCallingExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecallingExpCS_in_entryRulecallingExpCS6413);
            iv_rulecallingExpCS=rulecallingExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecallingExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecallingExpCS6423); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3450:1: rulecallingExpCS returns [EObject current=null] : (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? ) ;
    public final EObject rulecallingExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_callExpCS_0 = null;

        EObject lv_argument_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3455:6: ( (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3456:1: (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3456:1: (this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3457:2: this_callExpCS_0= rulecallExpCS ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCallingExpCSAccess().getCallExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulecallExpCS_in_rulecallingExpCS6473);
            this_callExpCS_0=rulecallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_callExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3468:1: ( () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==11||LA50_0==56) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3468:2: () ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) ) ( (lv_argument_3_0= rulecallingExpCS ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3468:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3469:2: 
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3487:2: ( ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3488:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3488:1: ( (lv_op_2_1= '.' | lv_op_2_2= '->' ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3489:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3489:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==11) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==56) ) {
                        alt49=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("3489:1: (lv_op_2_1= '.' | lv_op_2_2= '->' )", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3490:3: lv_op_2_1= '.'
                            {
                            lv_op_2_1=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_rulecallingExpCS6505); if (failed) return current;
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
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3508:8: lv_op_2_2= '->'
                            {
                            lv_op_2_2=(Token)input.LT(1);
                            match(input,56,FOLLOW_56_in_rulecallingExpCS6534); if (failed) return current;
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3529:2: ( (lv_argument_3_0= rulecallingExpCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:1: (lv_argument_3_0= rulecallingExpCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3530:1: (lv_argument_3_0= rulecallingExpCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3531:3: lv_argument_3_0= rulecallingExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getCallingExpCSAccess().getArgumentCallingExpCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_rulecallingExpCS_in_rulecallingExpCS6571);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3561:1: entryRuleiteratorVariableCS returns [EObject current=null] : iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF ;
    public final EObject entryRuleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3562:2: (iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3563:2: iv_ruleiteratorVariableCS= ruleiteratorVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS6609);
            iv_ruleiteratorVariableCS=ruleiteratorVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorVariableCS6619); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3570:1: ruleiteratorVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) ;
    public final EObject ruleiteratorVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3575:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3576:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3576:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3576:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3576:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3577:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3577:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3578:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS6665);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3600:2: ( ':' ( (lv_type_2_0= ruletypeCS ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==35) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3600:4: ':' ( (lv_type_2_0= ruletypeCS ) )
                    {
                    match(input,35,FOLLOW_35_in_ruleiteratorVariableCS6676); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIteratorVariableCSAccess().getColonKeyword_1_0(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3604:1: ( (lv_type_2_0= ruletypeCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:1: (lv_type_2_0= ruletypeCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3605:1: (lv_type_2_0= ruletypeCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3606:3: lv_type_2_0= ruletypeCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIteratorVariableCSAccess().getTypeTypeCSParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorVariableCS6697);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3636:1: entryRuleiteratorAccumulatorCS returns [EObject current=null] : iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF ;
    public final EObject entryRuleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleiteratorAccumulatorCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3637:2: (iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3638:2: iv_ruleiteratorAccumulatorCS= ruleiteratorAccumulatorCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIteratorAccumulatorCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS6735);
            iv_ruleiteratorAccumulatorCS=ruleiteratorAccumulatorCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleiteratorAccumulatorCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS6745); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3645:1: ruleiteratorAccumulatorCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleiteratorAccumulatorCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3650:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3651:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3651:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3651:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3651:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3652:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3652:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3653:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS6791);
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

            match(input,35,FOLLOW_35_in_ruleiteratorAccumulatorCS6801); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3679:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3680:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3680:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3681:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS6822);
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

            match(input,39,FOLLOW_39_in_ruleiteratorAccumulatorCS6832); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIteratorAccumulatorCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3707:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3708:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3708:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3709:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIteratorAccumulatorCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS6853);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3739:1: entryRulecallExpCS returns [EObject current=null] : iv_rulecallExpCS= rulecallExpCS EOF ;
    public final EObject entryRulecallExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecallExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3740:2: (iv_rulecallExpCS= rulecallExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3741:2: iv_rulecallExpCS= rulecallExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getCallExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulecallExpCS_in_entryRulecallExpCS6889);
            iv_rulecallExpCS=rulecallExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulecallExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulecallExpCS6899); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3748:1: rulecallExpCS returns [EObject current=null] : (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? ) ;
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
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3753:6: ( (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3754:1: (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3754:1: (this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3755:2: this_preExpCS_0= rulepreExpCS ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getPreExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulepreExpCS_in_rulecallExpCS6949);
            this_preExpCS_0=rulepreExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_preExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3766:1: ( () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==32) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3766:2: () '(' ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )? ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )? ')'
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3766:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3767:2: 
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

                    match(input,32,FOLLOW_32_in_rulecallExpCS6971); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getCallExpCSAccess().getLeftParenthesisKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:1: ( ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_ID) ) {
                        int LA53_1 = input.LA(2);

                        if ( (LA53_1==34) ) {
                            int LA53_3 = input.LA(3);

                            if ( (LA53_3==RULE_ID) ) {
                                int LA53_5 = input.LA(4);

                                if ( (LA53_5==35||LA53_5==58) ) {
                                    alt53=1;
                                }
                            }
                        }
                        else if ( (LA53_1==35||(LA53_1>=57 && LA53_1<=58)) ) {
                            alt53=1;
                        }
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:2: ( (lv_variable1_3_0= ruleiteratorVariableCS ) ) ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )? '|'
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3789:2: ( (lv_variable1_3_0= ruleiteratorVariableCS ) )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3790:1: (lv_variable1_3_0= ruleiteratorVariableCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3790:1: (lv_variable1_3_0= ruleiteratorVariableCS )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3791:3: lv_variable1_3_0= ruleiteratorVariableCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable1IteratorVariableCSParserRuleCall_1_2_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS6993);
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

                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3813:2: ( ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) ) | ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) ) )?
                            int alt52=3;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==34) ) {
                                alt52=1;
                            }
                            else if ( (LA52_0==57) ) {
                                alt52=2;
                            }
                            switch (alt52) {
                                case 1 :
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3813:3: ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3813:3: ( ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3813:5: ',' ( (lv_variable2_5_0= ruleiteratorVariableCS ) )
                                    {
                                    match(input,34,FOLLOW_34_in_rulecallExpCS7005); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallExpCSAccess().getCommaKeyword_1_2_1_0_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3817:1: ( (lv_variable2_5_0= ruleiteratorVariableCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3818:1: (lv_variable2_5_0= ruleiteratorVariableCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3818:1: (lv_variable2_5_0= ruleiteratorVariableCS )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3819:3: lv_variable2_5_0= ruleiteratorVariableCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable2IteratorVariableCSParserRuleCall_1_2_1_0_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS7026);
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
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3842:6: ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3842:6: ( ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) ) )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3842:8: ';' ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) )
                                    {
                                    match(input,57,FOLLOW_57_in_rulecallExpCS7044); if (failed) return current;
                                    if ( backtracking==0 ) {

                                              createLeafNode(grammarAccess.getCallExpCSAccess().getSemicolonKeyword_1_2_1_1_0(), null); 
                                          
                                    }
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3846:1: ( (lv_variable2_7_0= ruleiteratorAccumulatorCS ) )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3847:1: (lv_variable2_7_0= ruleiteratorAccumulatorCS )
                                    {
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3847:1: (lv_variable2_7_0= ruleiteratorAccumulatorCS )
                                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3848:3: lv_variable2_7_0= ruleiteratorAccumulatorCS
                                    {
                                    if ( backtracking==0 ) {
                                       
                                      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getVariable2IteratorAccumulatorCSParserRuleCall_1_2_1_1_1_0(), currentNode); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleiteratorAccumulatorCS_in_rulecallExpCS7065);
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

                            match(input,58,FOLLOW_58_in_rulecallExpCS7078); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getCallExpCSAccess().getVerticalLineKeyword_1_2_2(), null); 
                                  
                            }

                            }
                            break;

                    }

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3874:3: ( ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )* )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( ((LA55_0>=RULE_INT && LA55_0<=RULE_STRING_LITERAL)||(LA55_0>=15 && LA55_0<=17)||(LA55_0>=19 && LA55_0<=32)||(LA55_0>=40 && LA55_0<=44)||LA55_0==55||LA55_0==61||LA55_0==65) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3874:4: ( (lv_arguments_9_0= ruleOclExpressionCS ) ) ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )*
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3874:4: ( (lv_arguments_9_0= ruleOclExpressionCS ) )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3875:1: (lv_arguments_9_0= ruleOclExpressionCS )
                            {
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3875:1: (lv_arguments_9_0= ruleOclExpressionCS )
                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3876:3: lv_arguments_9_0= ruleOclExpressionCS
                            {
                            if ( backtracking==0 ) {
                               
                              	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_3_0_0(), currentNode); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleOclExpressionCS_in_rulecallExpCS7102);
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

                            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3898:2: ( ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) ) )*
                            loop54:
                            do {
                                int alt54=2;
                                int LA54_0 = input.LA(1);

                                if ( (LA54_0==34) ) {
                                    alt54=1;
                                }


                                switch (alt54) {
                            	case 1 :
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3898:4: ',' ( (lv_arguments_11_0= ruleOclExpressionCS ) )
                            	    {
                            	    match(input,34,FOLLOW_34_in_rulecallExpCS7113); if (failed) return current;
                            	    if ( backtracking==0 ) {

                            	              createLeafNode(grammarAccess.getCallExpCSAccess().getCommaKeyword_1_3_1_0(), null); 
                            	          
                            	    }
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3902:1: ( (lv_arguments_11_0= ruleOclExpressionCS ) )
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3903:1: (lv_arguments_11_0= ruleOclExpressionCS )
                            	    {
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3903:1: (lv_arguments_11_0= ruleOclExpressionCS )
                            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3904:3: lv_arguments_11_0= ruleOclExpressionCS
                            	    {
                            	    if ( backtracking==0 ) {
                            	       
                            	      	        currentNode=createCompositeNode(grammarAccess.getCallExpCSAccess().getArgumentsOclExpressionCSParserRuleCall_1_3_1_1_0(), currentNode); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleOclExpressionCS_in_rulecallExpCS7134);
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
                            	    break loop54;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,33,FOLLOW_33_in_rulecallExpCS7148); if (failed) return current;
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


    // $ANTLR start entryRulepreExpCS
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3938:1: entryRulepreExpCS returns [EObject current=null] : iv_rulepreExpCS= rulepreExpCS EOF ;
    public final EObject entryRulepreExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepreExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3939:2: (iv_rulepreExpCS= rulepreExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3940:2: iv_rulepreExpCS= rulepreExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPreExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulepreExpCS_in_entryRulepreExpCS7186);
            iv_rulepreExpCS=rulepreExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulepreExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulepreExpCS7196); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3947:1: rulepreExpCS returns [EObject current=null] : this_indexExpCS_0= ruleindexExpCS ;
    public final EObject rulepreExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_indexExpCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3952:6: (this_indexExpCS_0= ruleindexExpCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3954:2: this_indexExpCS_0= ruleindexExpCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getPreExpCSAccess().getIndexExpCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleindexExpCS_in_rulepreExpCS7245);
            this_indexExpCS_0=ruleindexExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_indexExpCS_0; 
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
    // $ANTLR end rulepreExpCS


    // $ANTLR start entryRuleindexExpCS
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3973:1: entryRuleindexExpCS returns [EObject current=null] : iv_ruleindexExpCS= ruleindexExpCS EOF ;
    public final EObject entryRuleindexExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleindexExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3974:2: (iv_ruleindexExpCS= ruleindexExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3975:2: iv_ruleindexExpCS= ruleindexExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIndexExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleindexExpCS_in_entryRuleindexExpCS7279);
            iv_ruleindexExpCS=ruleindexExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleindexExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleindexExpCS7289); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3982:1: ruleindexExpCS returns [EObject current=null] : (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? ) ;
    public final EObject ruleindexExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_messageExpCS_0 = null;

        EObject lv_indexes_3_0 = null;

        EObject lv_indexes_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3987:6: ( (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3988:1: (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3988:1: (this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )? )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3989:2: this_messageExpCS_0= rulemessageExpCS ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )?
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getMessageExpCSParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FOLLOW_rulemessageExpCS_in_ruleindexExpCS7339);
            this_messageExpCS_0=rulemessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_messageExpCS_0; 
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4000:1: ( () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==59) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4000:2: () '[' ( (lv_indexes_3_0= ruleOclExpressionCS ) ) ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )* ']'
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4000:2: ()
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4001:2: 
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

                    match(input,59,FOLLOW_59_in_ruleindexExpCS7361); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getIndexExpCSAccess().getLeftSquareBracketKeyword_1_1(), null); 
                          
                    }
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4023:1: ( (lv_indexes_3_0= ruleOclExpressionCS ) )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4024:1: (lv_indexes_3_0= ruleOclExpressionCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4024:1: (lv_indexes_3_0= ruleOclExpressionCS )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4025:3: lv_indexes_3_0= ruleOclExpressionCS
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getIndexesOclExpressionCSParserRuleCall_1_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS7382);
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

                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4047:2: ( ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==34) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4047:4: ',' ( (lv_indexes_5_0= ruleOclExpressionCS ) )
                    	    {
                    	    match(input,34,FOLLOW_34_in_ruleindexExpCS7393); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getIndexExpCSAccess().getCommaKeyword_1_3_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4051:1: ( (lv_indexes_5_0= ruleOclExpressionCS ) )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4052:1: (lv_indexes_5_0= ruleOclExpressionCS )
                    	    {
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4052:1: (lv_indexes_5_0= ruleOclExpressionCS )
                    	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4053:3: lv_indexes_5_0= ruleOclExpressionCS
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getIndexExpCSAccess().getIndexesOclExpressionCSParserRuleCall_1_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS7414);
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
                    	    break loop57;
                        }
                    } while (true);

                    match(input,60,FOLLOW_60_in_ruleindexExpCS7426); if (failed) return current;
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


    // $ANTLR start entryRulemessageExpCS
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4087:1: entryRulemessageExpCS returns [EObject current=null] : iv_rulemessageExpCS= rulemessageExpCS EOF ;
    public final EObject entryRulemessageExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemessageExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4088:2: (iv_rulemessageExpCS= rulemessageExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4089:2: iv_rulemessageExpCS= rulemessageExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMessageExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_rulemessageExpCS_in_entryRulemessageExpCS7464);
            iv_rulemessageExpCS=rulemessageExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulemessageExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemessageExpCS7474); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4096:1: rulemessageExpCS returns [EObject current=null] : this_primaryExpCS_0= ruleprimaryExpCS ;
    public final EObject rulemessageExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_primaryExpCS_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4101:6: (this_primaryExpCS_0= ruleprimaryExpCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4103:2: this_primaryExpCS_0= ruleprimaryExpCS
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getMessageExpCSAccess().getPrimaryExpCSParserRuleCall(), currentNode); 
                  
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_rulemessageExpCS7523);
            this_primaryExpCS_0=ruleprimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
                      current = this_primaryExpCS_0; 
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
    // $ANTLR end rulemessageExpCS


    // $ANTLR start entryRuleprimaryExpCS
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4122:1: entryRuleprimaryExpCS returns [EObject current=null] : iv_ruleprimaryExpCS= ruleprimaryExpCS EOF ;
    public final EObject entryRuleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleprimaryExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4123:2: (iv_ruleprimaryExpCS= ruleprimaryExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4124:2: iv_ruleprimaryExpCS= ruleprimaryExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPrimaryExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS7557);
            iv_ruleprimaryExpCS=ruleprimaryExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleprimaryExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleprimaryExpCS7567); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4131:1: ruleprimaryExpCS returns [EObject current=null] : (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) ;
    public final EObject ruleprimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_selfKeywordCS_0 = null;

        EObject this_LiteralExpCS_1 = null;

        EObject this_IfExpCS_2 = null;

        EObject this_OclExpressionCS_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4136:6: ( (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4137:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4137:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )
            int alt59=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt59=1;
                }
                break;
            case RULE_INT:
            case RULE_ID:
            case RULE_STRING_LITERAL:
            case 16:
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
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt59=2;
                }
                break;
            case 61:
                {
                alt59=3;
                }
                break;
            case 32:
                {
                alt59=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4137:1: (this_selfKeywordCS_0= ruleselfKeywordCS | this_LiteralExpCS_1= ruleLiteralExpCS | this_IfExpCS_2= ruleIfExpCS | ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' ) )", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4138:2: this_selfKeywordCS_0= ruleselfKeywordCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfKeywordCSParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS7617);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4151:2: this_LiteralExpCS_1= ruleLiteralExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS7647);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4164:2: this_IfExpCS_2= ruleIfExpCS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS7677);
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
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4176:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4176:6: ( '(' this_OclExpressionCS_4= ruleOclExpressionCS ')' )
                    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4176:8: '(' this_OclExpressionCS_4= ruleOclExpressionCS ')'
                    {
                    match(input,32,FOLLOW_32_in_ruleprimaryExpCS7693); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getPrimaryExpCSAccess().getLeftParenthesisKeyword_3_0(), null); 
                          
                    }
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPrimaryExpCSAccess().getOclExpressionCSParserRuleCall_3_1(), currentNode); 
                          
                    }
                    pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS7718);
                    this_OclExpressionCS_4=ruleOclExpressionCS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_OclExpressionCS_4; 
                              currentNode = currentNode.getParent();
                          
                    }
                    match(input,33,FOLLOW_33_in_ruleprimaryExpCS7727); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4204:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4205:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4206:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getIfExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS7764);
            iv_ruleIfExpCS=ruleIfExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpCS7774); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4213:1: ruleIfExpCS returns [EObject current=null] : ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4218:6: ( ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4219:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4219:1: ( 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif' )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4219:3: 'if' ( (lv_condition_1_0= ruleOclExpressionCS ) ) 'then' ( (lv_thenExpression_3_0= ruleOclExpressionCS ) ) 'else' ( (lv_elseExpression_5_0= ruleOclExpressionCS ) ) 'endif'
            {
            match(input,61,FOLLOW_61_in_ruleIfExpCS7809); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getIfKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4223:1: ( (lv_condition_1_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4224:1: (lv_condition_1_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4224:1: (lv_condition_1_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4225:3: lv_condition_1_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getConditionOclExpressionCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7830);
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

            match(input,62,FOLLOW_62_in_ruleIfExpCS7840); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getThenKeyword_2(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4251:1: ( (lv_thenExpression_3_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4252:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4252:1: (lv_thenExpression_3_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4253:3: lv_thenExpression_3_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionOclExpressionCSParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7861);
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

            match(input,63,FOLLOW_63_in_ruleIfExpCS7871); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getIfExpCSAccess().getElseKeyword_4(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4279:1: ( (lv_elseExpression_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4280:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4280:1: (lv_elseExpression_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4281:3: lv_elseExpression_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionOclExpressionCSParserRuleCall_5_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7892);
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

            match(input,64,FOLLOW_64_in_ruleIfExpCS7902); if (failed) return current;
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4315:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4316:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4317:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetExpCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS7938);
            iv_ruleLetExpCS=ruleLetExpCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpCS7948); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4324:1: ruleLetExpCS returns [EObject current=null] : ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4329:6: ( ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4330:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4330:1: ( 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4330:3: 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* 'in' ( (lv_in_5_0= ruleOclExpressionCS ) )
            {
            match(input,65,FOLLOW_65_in_ruleLetExpCS7983); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getLetKeyword_0(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4334:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4335:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4335:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4336:3: lv_variable_1_0= ruleLetVariableCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS8004);
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

            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4358:2: ( ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==34) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4358:4: ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    match(input,34,FOLLOW_34_in_ruleLetExpCS8015); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0(), null); 
            	          
            	    }
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4362:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4363:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4363:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4364:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS8036);
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
            	    break loop60;
                }
            } while (true);

            match(input,66,FOLLOW_66_in_ruleLetExpCS8048); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetExpCSAccess().getInKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4390:1: ( (lv_in_5_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4391:1: (lv_in_5_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4391:1: (lv_in_5_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4392:3: lv_in_5_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetExpCSAccess().getInOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS8069);
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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4422:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4423:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4424:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLetVariableCSRule(), currentNode); 
            }
            pushFollow(FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS8105);
            iv_ruleLetVariableCS=ruleLetVariableCS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetVariableCS8115); if (failed) return current;

            }

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
    // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4431:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4436:6: ( ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4437:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4437:1: ( ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4437:2: ( (lv_name_0_0= rulesimpleNameCS ) ) ':' ( (lv_type_2_0= ruletypeCS ) ) '=' ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4437:2: ( (lv_name_0_0= rulesimpleNameCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4438:1: (lv_name_0_0= rulesimpleNameCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4438:1: (lv_name_0_0= rulesimpleNameCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4439:3: lv_name_0_0= rulesimpleNameCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getNameSimpleNameCSParserRuleCall_0_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS8161);
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

            match(input,35,FOLLOW_35_in_ruleLetVariableCS8171); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getColonKeyword_1(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4465:1: ( (lv_type_2_0= ruletypeCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4466:1: (lv_type_2_0= ruletypeCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4466:1: (lv_type_2_0= ruletypeCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4467:3: lv_type_2_0= ruletypeCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getTypeTypeCSParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruletypeCS_in_ruleLetVariableCS8192);
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

            match(input,39,FOLLOW_39_in_ruleLetVariableCS8202); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3(), null); 
                  
            }
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4493:1: ( (lv_initExpression_4_0= ruleOclExpressionCS ) )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4494:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            {
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4494:1: (lv_initExpression_4_0= ruleOclExpressionCS )
            // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:4495:3: lv_initExpression_4_0= ruleOclExpressionCS
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionOclExpressionCSParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS8223);
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

    // $ANTLR start synpred24
    public final void synpred24_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1002:4: ( '(' ( ( ruletypeCS ) ) ')' )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1002:4: '(' ( ( ruletypeCS ) ) ')'
        {
        match(input,32,FOLLOW_32_in_synpred242098); if (failed) return ;
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1006:1: ( ( ruletypeCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1007:1: ( ruletypeCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1007:1: ( ruletypeCS )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1008:3: ruletypeCS
        {
        if ( backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getCollectionTypeCSAccess().getTypeCSTypeCSParserRuleCall_1_1_0(), currentNode); 
          	    
        }
        pushFollow(FOLLOW_ruletypeCS_in_synpred242119);
        ruletypeCS();
        _fsp--;
        if (failed) return ;

        }


        }

        match(input,33,FOLLOW_33_in_synpred242129); if (failed) return ;

        }
    }
    // $ANTLR end synpred24

    // $ANTLR start synpred28
    public final void synpred28_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1250:2: ( ruleTupleLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1250:2: ruleTupleLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_synpred282560);
        ruleTupleLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred28

    // $ANTLR start synpred34
    public final void synpred34_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1481:2: ( ruleIntegerLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1481:2: ruleIntegerLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleIntegerLiteralExpCS_in_synpred343017);
        ruleIntegerLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred34

    // $ANTLR start synpred35
    public final void synpred35_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1494:2: ( ruleRealLiteralExpCS )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:1494:2: ruleRealLiteralExpCS
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleRealLiteralExpCS_in_synpred353047);
        ruleRealLiteralExpCS();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred35

    // $ANTLR start synpred49
    public final void synpred49_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: ( () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: () ( ( 'implies' ) ) ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2248:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2249:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2267:2: ( ( 'implies' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2268:1: ( 'implies' )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2268:1: ( 'implies' )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2269:3: 'implies'
        {
        match(input,45,FOLLOW_45_in_synpred494620); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2288:2: ( ( ( ruleimpliesCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2289:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2289:1: ( ( ruleimpliesCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2290:1: ( ruleimpliesCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2290:1: ( ruleimpliesCS | ruleLetExpCS )
        int alt66=2;
        int LA66_0 = input.LA(1);

        if ( ((LA66_0>=RULE_INT && LA66_0<=RULE_STRING_LITERAL)||(LA66_0>=15 && LA66_0<=17)||(LA66_0>=19 && LA66_0<=32)||(LA66_0>=40 && LA66_0<=44)||LA66_0==55||LA66_0==61) ) {
            alt66=1;
        }
        else if ( (LA66_0==65) ) {
            alt66=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2290:1: ( ruleimpliesCS | ruleLetExpCS )", 66, 0, input);

            throw nvae;
        }
        switch (alt66) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2291:3: ruleimpliesCS
                {
                pushFollow(FOLLOW_ruleimpliesCS_in_synpred494656);
                ruleimpliesCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2312:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getImpliesCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred494675);
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
    // $ANTLR end synpred49

    // $ANTLR start synpred51
    public final void synpred51_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:2: ( () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:2: () ( ( 'xor' ) ) ( ( ( rulexorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2371:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2372:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2390:2: ( ( 'xor' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: ( 'xor' )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2391:1: ( 'xor' )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2392:3: 'xor'
        {
        match(input,46,FOLLOW_46_in_synpred514806); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2411:2: ( ( ( rulexorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: ( ( rulexorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2412:1: ( ( rulexorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2413:1: ( rulexorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2413:1: ( rulexorCS | ruleLetExpCS )
        int alt67=2;
        int LA67_0 = input.LA(1);

        if ( ((LA67_0>=RULE_INT && LA67_0<=RULE_STRING_LITERAL)||(LA67_0>=15 && LA67_0<=17)||(LA67_0>=19 && LA67_0<=32)||(LA67_0>=40 && LA67_0<=44)||LA67_0==55||LA67_0==61) ) {
            alt67=1;
        }
        else if ( (LA67_0==65) ) {
            alt67=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2413:1: ( rulexorCS | ruleLetExpCS )", 67, 0, input);

            throw nvae;
        }
        switch (alt67) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2414:3: rulexorCS
                {
                pushFollow(FOLLOW_rulexorCS_in_synpred514842);
                rulexorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2435:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getXorCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred514861);
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
    // $ANTLR end synpred51

    // $ANTLR start synpred53
    public final void synpred53_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:2: ( () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:2: () ( ( 'or' ) ) ( ( ( ruleorCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2494:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2495:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2513:2: ( ( 'or' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:1: ( 'or' )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2514:1: ( 'or' )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2515:3: 'or'
        {
        match(input,47,FOLLOW_47_in_synpred534992); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2534:2: ( ( ( ruleorCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2535:1: ( ( ruleorCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2535:1: ( ( ruleorCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2536:1: ( ruleorCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2536:1: ( ruleorCS | ruleLetExpCS )
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( ((LA68_0>=RULE_INT && LA68_0<=RULE_STRING_LITERAL)||(LA68_0>=15 && LA68_0<=17)||(LA68_0>=19 && LA68_0<=32)||(LA68_0>=40 && LA68_0<=44)||LA68_0==55||LA68_0==61) ) {
            alt68=1;
        }
        else if ( (LA68_0==65) ) {
            alt68=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2536:1: ( ruleorCS | ruleLetExpCS )", 68, 0, input);

            throw nvae;
        }
        switch (alt68) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2537:3: ruleorCS
                {
                pushFollow(FOLLOW_ruleorCS_in_synpred535028);
                ruleorCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2558:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getOrCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred535047);
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
    // $ANTLR end synpred53

    // $ANTLR start synpred55
    public final void synpred55_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:2: ( () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:2: () ( ( 'and' ) ) ( ( ( ruleandCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2617:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2618:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2636:2: ( ( 'and' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2637:1: ( 'and' )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2637:1: ( 'and' )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2638:3: 'and'
        {
        match(input,48,FOLLOW_48_in_synpred555178); if (failed) return ;

        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2657:2: ( ( ( ruleandCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2658:1: ( ( ruleandCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2658:1: ( ( ruleandCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2659:1: ( ruleandCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2659:1: ( ruleandCS | ruleLetExpCS )
        int alt69=2;
        int LA69_0 = input.LA(1);

        if ( ((LA69_0>=RULE_INT && LA69_0<=RULE_STRING_LITERAL)||(LA69_0>=15 && LA69_0<=17)||(LA69_0>=19 && LA69_0<=32)||(LA69_0>=40 && LA69_0<=44)||LA69_0==55||LA69_0==61) ) {
            alt69=1;
        }
        else if ( (LA69_0==65) ) {
            alt69=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2659:1: ( ruleandCS | ruleLetExpCS )", 69, 0, input);

            throw nvae;
        }
        switch (alt69) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2660:3: ruleandCS
                {
                pushFollow(FOLLOW_ruleandCS_in_synpred555214);
                ruleandCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2681:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAndCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred555233);
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
    // $ANTLR end synpred55

    // $ANTLR start synpred58
    public final void synpred58_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:2: ( () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:2: () ( ( ( '=' | '<>' ) ) ) ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2740:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2741:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2759:2: ( ( ( '=' | '<>' ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2760:1: ( ( '=' | '<>' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2760:1: ( ( '=' | '<>' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2761:1: ( '=' | '<>' )
        {
        if ( input.LA(1)==39||input.LA(1)==49 ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred585359);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2801:2: ( ( ( ruleequalityCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2802:1: ( ( ruleequalityCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2803:1: ( ruleequalityCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2803:1: ( ruleequalityCS | ruleLetExpCS )
        int alt70=2;
        int LA70_0 = input.LA(1);

        if ( ((LA70_0>=RULE_INT && LA70_0<=RULE_STRING_LITERAL)||(LA70_0>=15 && LA70_0<=17)||(LA70_0>=19 && LA70_0<=32)||(LA70_0>=40 && LA70_0<=44)||LA70_0==55||LA70_0==61) ) {
            alt70=1;
        }
        else if ( (LA70_0==65) ) {
            alt70=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2803:1: ( ruleequalityCS | ruleLetExpCS )", 70, 0, input);

            throw nvae;
        }
        switch (alt70) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2804:3: ruleequalityCS
                {
                pushFollow(FOLLOW_ruleequalityCS_in_synpred585434);
                ruleequalityCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2825:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getEqualityCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred585453);
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
    // $ANTLR end synpred58

    // $ANTLR start synpred63
    public final void synpred63_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:2: ( () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:2: () ( ( ( '>' | '<' | '>=' | '<=' ) ) ) ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2884:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2885:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2903:2: ( ( ( '>' | '<' | '>=' | '<=' ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:1: ( ( '>' | '<' | '>=' | '<=' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2904:1: ( ( '>' | '<' | '>=' | '<=' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2905:1: ( '>' | '<' | '>=' | '<=' )
        {
        if ( (input.LA(1)>=50 && input.LA(1)<=53) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred635579);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2981:2: ( ( ( rulerelationalCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2982:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2982:1: ( ( rulerelationalCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2983:1: ( rulerelationalCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2983:1: ( rulerelationalCS | ruleLetExpCS )
        int alt71=2;
        int LA71_0 = input.LA(1);

        if ( ((LA71_0>=RULE_INT && LA71_0<=RULE_STRING_LITERAL)||(LA71_0>=15 && LA71_0<=17)||(LA71_0>=19 && LA71_0<=32)||(LA71_0>=40 && LA71_0<=44)||LA71_0==55||LA71_0==61) ) {
            alt71=1;
        }
        else if ( (LA71_0==65) ) {
            alt71=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("2983:1: ( rulerelationalCS | ruleLetExpCS )", 71, 0, input);

            throw nvae;
        }
        switch (alt71) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:2984:3: rulerelationalCS
                {
                pushFollow(FOLLOW_rulerelationalCS_in_synpred635712);
                rulerelationalCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3005:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getRelationalCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred635731);
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
    // $ANTLR end synpred63

    // $ANTLR start synpred66
    public final void synpred66_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: ( () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: () ( ( ( '+' | '-' ) ) ) ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3064:2: ()
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3065:2: 
        {
        if ( backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3083:2: ( ( ( '+' | '-' ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3084:1: ( ( '+' | '-' ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3084:1: ( ( '+' | '-' ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3085:1: ( '+' | '-' )
        {
        if ( (input.LA(1)>=14 && input.LA(1)<=15) ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred665857);    throw mse;
        }


        }


        }

        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3125:2: ( ( ( ruleadditiveCS | ruleLetExpCS ) ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3126:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3126:1: ( ( ruleadditiveCS | ruleLetExpCS ) )
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3127:1: ( ruleadditiveCS | ruleLetExpCS )
        {
        // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3127:1: ( ruleadditiveCS | ruleLetExpCS )
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( ((LA72_0>=RULE_INT && LA72_0<=RULE_STRING_LITERAL)||(LA72_0>=15 && LA72_0<=17)||(LA72_0>=19 && LA72_0<=32)||(LA72_0>=40 && LA72_0<=44)||LA72_0==55||LA72_0==61) ) {
            alt72=1;
        }
        else if ( (LA72_0==65) ) {
            alt72=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("3127:1: ( ruleadditiveCS | ruleLetExpCS )", 72, 0, input);

            throw nvae;
        }
        switch (alt72) {
            case 1 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3128:3: ruleadditiveCS
                {
                pushFollow(FOLLOW_ruleadditiveCS_in_synpred665932);
                ruleadditiveCS();
                _fsp--;
                if (failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.ocl.examples.xtext.essentialocl/src-gen/org/eclipse/ocl/examples/xtext/essentialocl/parser/antlr/internal/InternalEssentialOCL.g:3149:8: ruleLetExpCS
                {
                if ( backtracking==0 ) {
                   
                  	        currentNode=createCompositeNode(grammarAccess.getAdditiveCSAccess().getArgumentLetExpCSParserRuleCall_1_2_0_1(), currentNode); 
                  	    
                }
                pushFollow(FOLLOW_ruleLetExpCS_in_synpred665951);
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
    // $ANTLR end synpred66

    public final boolean synpred53() {
        backtracking++;
        int start = input.mark();
        try {
            synpred53_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred49() {
        backtracking++;
        int start = input.mark();
        try {
            synpred49_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred35() {
        backtracking++;
        int start = input.mark();
        try {
            synpred35_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred63() {
        backtracking++;
        int start = input.mark();
        try {
            synpred63_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred58() {
        backtracking++;
        int start = input.mark();
        try {
            synpred58_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred24() {
        backtracking++;
        int start = input.mark();
        try {
            synpred24_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred34() {
        backtracking++;
        int start = input.mark();
        try {
            synpred34_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred28() {
        backtracking++;
        int start = input.mark();
        try {
            synpred28_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred66() {
        backtracking++;
        int start = input.mark();
        try {
            synpred66_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred51() {
        backtracking++;
        int start = input.mark();
        try {
            synpred51_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred55() {
        backtracking++;
        int start = input.mark();
        try {
            synpred55_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleModel140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_entryRuleREAL_LITERAL175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL_LITERAL186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL226 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleREAL_LITERAL288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL303 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleREAL_LITERAL324 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_13_in_ruleREAL_LITERAL343 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_ruleREAL_LITERAL358 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15_in_ruleREAL_LITERAL377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL_LITERAL394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER_LITERAL453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleINTEGER_LITERAL492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_entryRuletupleKeywordCS538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleKeywordCS548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruletupleKeywordCS590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_entryRulerestrictedKeywordCS638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerestrictedKeywordCS648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulerestrictedKeywordCS698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_rulerestrictedKeywordCS728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleKeywordCS_in_rulerestrictedKeywordCS758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_entryRuleselfKeywordCS793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleselfKeywordCS803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleselfKeywordCS845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_entryRulesimpleNameCS893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulesimpleNameCS903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulesimpleNameCS944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_entryRuleunreservedSimpleNameCS984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunreservedSimpleNameCS994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleunreservedSimpleNameCS1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerestrictedKeywordCS_in_ruleunreservedSimpleNameCS1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_entryRulepathNameCS1109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepathNameCS1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_rulepathNameCS1165 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_rulepathNameCS1176 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruleunreservedSimpleNameCS_in_rulepathNameCS1197 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_entryRuleprimitiveTypeCS1235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimitiveTypeCS1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleprimitiveTypeCS1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleprimitiveTypeCS1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleprimitiveTypeCS1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleprimitiveTypeCS1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleprimitiveTypeCS1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleprimitiveTypeCS1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleprimitiveTypeCS1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleprimitiveTypeCS1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_entryRuleCollectionTypeIdentifierCS1596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifierCS1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleCollectionTypeIdentifierCS1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleCollectionTypeIdentifierCS1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCollectionTypeIdentifierCS1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleCollectionTypeIdentifierCS1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleCollectionTypeIdentifierCS1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletypeCS_in_entryRuletypeCS1846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletypeCS1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruletypeCS1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruletypeCS1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruletypeCS1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruletypeCS1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_entryRulecollectionTypeCS2031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecollectionTypeCS2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifierCS_in_rulecollectionTypeCS2087 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_rulecollectionTypeCS2098 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_rulecollectionTypeCS2119 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rulecollectionTypeCS2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_entryRuletupleTypeCS2167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletupleTypeCS2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruletupleTypeCS2220 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruletupleTypeCS2243 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS2265 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruletupleTypeCS2276 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_ruletupleTypeCS2297 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruletupleTypeCS2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletuplePartCS_in_entryRuletuplePartCS2347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletuplePartCS2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruletuplePartCS2403 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruletuplePartCS2413 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruletuplePartCS2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_entryRuleLiteralExpCS2470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpCS2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_ruleLiteralExpCS2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_ruleLiteralExpCS2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_ruleLiteralExpCS2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_ruleLiteralExpCS2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS2655 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecollectionTypeCS_in_ruleCollectionLiteralExpCS2715 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleCollectionLiteralExpCS2725 = new BitSet(new long[]{0x20801F21FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS2747 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_34_in_ruleCollectionLiteralExpCS2758 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS2779 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_37_in_ruleCollectionLiteralExpCS2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS2831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS2887 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleCollectionLiteralPartCS2898 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleCollectionLiteralPartCS2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS2957 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_rulePrimitiveLiteralExpCS3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_rulePrimitiveLiteralExpCS3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS3232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTupleLiteralExpCS3289 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleTupleLiteralExpCS3300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS3321 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_34_in_ruleTupleLiteralExpCS3332 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS3353 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_37_in_ruleTupleLiteralExpCS3365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS3403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleTupleLiteralPartCS3459 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_35_in_ruleTupleLiteralPartCS3470 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleTupleLiteralPartCS3491 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleTupleLiteralPartCS3503 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleTupleLiteralPartCS3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_entryRuleIntegerLiteralExpCS3560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralExpCS3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_ruleIntegerLiteralExpCS3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_entryRuleRealLiteralExpCS3650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralExpCS3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_LITERAL_in_ruleRealLiteralExpCS3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS3740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_LITERAL_in_ruleStringLiteralExpCS3791 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS3832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleBooleanLiteralExpCS3885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleBooleanLiteralExpCS3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS3971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleUnlimitedNaturalLiteralExpCS4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS4064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleInvalidLiteralExpCS4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS4157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS4167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleNullLiteralExpCS4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS4250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepathNameCS_in_ruleTypeLiteralExpCS4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimitiveTypeCS_in_ruleTypeLiteralExpCS4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletupleTypeCS_in_ruleTypeLiteralExpCS4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_entryRuleOclExpressionCS4405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOclExpressionCS4415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleOclExpressionCS4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleOclExpressionCS4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_entryRuleimpliesCS4530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleimpliesCS4540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_ruleimpliesCS4590 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleimpliesCS4620 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_ruleimpliesCS4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleimpliesCS4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_entryRulexorCS4716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulexorCS4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_rulexorCS4776 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_rulexorCS4806 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_rulexorCS4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulexorCS4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_entryRuleorCS4902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleorCS4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleorCS4962 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleorCS4992 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_ruleorCS5028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleorCS5047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_entryRuleandCS5088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleandCS5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleandCS5148 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleandCS5178 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_ruleandCS5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleandCS5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_entryRuleequalityCS5274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleequalityCS5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_ruleequalityCS5334 = new BitSet(new long[]{0x0002008000000002L});
    public static final BitSet FOLLOW_39_in_ruleequalityCS5366 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleequalityCS5395 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_ruleequalityCS5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleequalityCS5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_entryRulerelationalCS5494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerelationalCS5504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_rulerelationalCS5554 = new BitSet(new long[]{0x003C000000000002L});
    public static final BitSet FOLLOW_50_in_rulerelationalCS5586 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulerelationalCS5615 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulerelationalCS5644 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rulerelationalCS5673 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_rulerelationalCS5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulerelationalCS5731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_entryRuleadditiveCS5772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleadditiveCS5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_ruleadditiveCS5832 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_ruleadditiveCS5864 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleadditiveCS5893 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_ruleadditiveCS5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleadditiveCS5951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_entryRulemultiplicativeCS5992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiplicativeCS6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_rulemultiplicativeCS6052 = new BitSet(new long[]{0x0040040000000002L});
    public static final BitSet FOLLOW_42_in_rulemultiplicativeCS6084 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rulemultiplicativeCS6113 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiplicativeCS_in_rulemultiplicativeCS6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulemultiplicativeCS6171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleunaryCS_in_entryRuleunaryCS6212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleunaryCS6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_ruleunaryCS6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleunaryCS6310 = new BitSet(new long[]{0x20801F01FFFB8070L});
    public static final BitSet FOLLOW_55_in_ruleunaryCS6339 = new BitSet(new long[]{0x20801F01FFFB8070L});
    public static final BitSet FOLLOW_ruleunaryCS_in_ruleunaryCS6376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_entryRulecallingExpCS6413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecallingExpCS6423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallExpCS_in_rulecallingExpCS6473 = new BitSet(new long[]{0x0100000000000802L});
    public static final BitSet FOLLOW_11_in_rulecallingExpCS6505 = new BitSet(new long[]{0x20001F01FFFB0070L});
    public static final BitSet FOLLOW_56_in_rulecallingExpCS6534 = new BitSet(new long[]{0x20001F01FFFB0070L});
    public static final BitSet FOLLOW_rulecallingExpCS_in_rulecallingExpCS6571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_entryRuleiteratorVariableCS6609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorVariableCS6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorVariableCS6665 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleiteratorVariableCS6676 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorVariableCS6697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_entryRuleiteratorAccumulatorCS6735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleiteratorAccumulatorCS6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleiteratorAccumulatorCS6791 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleiteratorAccumulatorCS6801 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleiteratorAccumulatorCS6822 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleiteratorAccumulatorCS6832 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleiteratorAccumulatorCS6853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulecallExpCS_in_entryRulecallExpCS6889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulecallExpCS6899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreExpCS_in_rulecallExpCS6949 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_rulecallExpCS6971 = new BitSet(new long[]{0x20801F03FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS6993 = new BitSet(new long[]{0x0600000400000000L});
    public static final BitSet FOLLOW_34_in_rulecallExpCS7005 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleiteratorVariableCS_in_rulecallExpCS7026 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_57_in_rulecallExpCS7044 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleiteratorAccumulatorCS_in_rulecallExpCS7065 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_rulecallExpCS7078 = new BitSet(new long[]{0x20801F03FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulecallExpCS7102 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_rulecallExpCS7113 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_rulecallExpCS7134 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_rulecallExpCS7148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulepreExpCS_in_entryRulepreExpCS7186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulepreExpCS7196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleindexExpCS_in_rulepreExpCS7245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleindexExpCS_in_entryRuleindexExpCS7279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleindexExpCS7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemessageExpCS_in_ruleindexExpCS7339 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleindexExpCS7361 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS7382 = new BitSet(new long[]{0x1000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleindexExpCS7393 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleindexExpCS7414 = new BitSet(new long[]{0x1000000400000000L});
    public static final BitSet FOLLOW_60_in_ruleindexExpCS7426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemessageExpCS_in_entryRulemessageExpCS7464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemessageExpCS7474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_rulemessageExpCS7523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleprimaryExpCS_in_entryRuleprimaryExpCS7557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleprimaryExpCS7567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleselfKeywordCS_in_ruleprimaryExpCS7617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpCS_in_ruleprimaryExpCS7647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_ruleprimaryExpCS7677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleprimaryExpCS7693 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleprimaryExpCS7718 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleprimaryExpCS7727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS7764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS7774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleIfExpCS7809 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7830 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleIfExpCS7840 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7861 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleIfExpCS7871 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleIfExpCS7892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleIfExpCS7902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS7938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS7948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLetExpCS7983 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS8004 = new BitSet(new long[]{0x0000000400000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_34_in_ruleLetExpCS8015 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS8036 = new BitSet(new long[]{0x0000000400000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleLetExpCS8048 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetExpCS8069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS8105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS8115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulesimpleNameCS_in_ruleLetVariableCS8161 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleLetVariableCS8171 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_ruleLetVariableCS8192 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleLetVariableCS8202 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOclExpressionCS_in_ruleLetVariableCS8223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred242098 = new BitSet(new long[]{0x00000000FFF90020L});
    public static final BitSet FOLLOW_ruletypeCS_in_synpred242119 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred242129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred282560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralExpCS_in_synpred343017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpCS_in_synpred353047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred494620 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleimpliesCS_in_synpred494656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred494675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_synpred514806 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulexorCS_in_synpred514842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred514861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred534992 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleorCS_in_synpred535028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred535047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred555178 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleandCS_in_synpred555214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred555233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred585359 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleequalityCS_in_synpred585434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred585453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred635579 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulerelationalCS_in_synpred635712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred635731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred665857 = new BitSet(new long[]{0x20801F01FFFB8070L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleadditiveCS_in_synpred665932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_synpred665951 = new BitSet(new long[]{0x0000000000000002L});

}