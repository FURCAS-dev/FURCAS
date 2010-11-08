// $ANTLR 3.1.1 ./scenariotestTemp/generated2/XPathReduced.g 2010-11-04 23:27:38

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class XPathReducedParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LPAREN", "RPAREN", "PIPE", "MINUS", "STAR", "PLUS", "LT", "LE", "GT", "GE", "EQ", "EXCLEQ", "DOLLAR", "COMMENT", "LSQUARE", "RSQUARE", "COLONS", "POINT", "POINTPOINT", "AROBAS", "SLASH", "SLASHSLASH", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'div'", "'mod'", "'and'", "'or'"
    };
    public static final int DOLLAR=20;
    public static final int GE=17;
    public static final int LT=14;
    public static final int STAR=12;
    public static final int LSQUARE=22;
    public static final int POINT=25;
    public static final int AROBAS=27;
    public static final int ESC=35;
    public static final int EXCLEQ=19;
    public static final int INT=6;
    public static final int FLOAT=7;
    public static final int RSQUARE=23;
    public static final int MINUS=11;
    public static final int EOF=-1;
    public static final int ALPHA=33;
    public static final int LPAREN=8;
    public static final int COLONS=24;
    public static final int RPAREN=9;
    public static final int NAME=4;
    public static final int WS=31;
    public static final int SLASH=28;
    public static final int SLASHSLASH=29;
    public static final int SNAME=34;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int POINTPOINT=26;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int GT=16;
    public static final int PIPE=10;
    public static final int PLUS=13;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int EQ=18;
    public static final int COMMENT=21;
    public static final int LE=15;
    public static final int STRING=5;

    // delegates
    // delegators


        public XPathReducedParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XPathReducedParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return XPathReducedParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/XPathReduced.g"; }


       private static final String syntaxUUID = "XPathReduced";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
       /**
         * Unescape string.
         * 
         * @param s the s
         * @param delimLength the delim length
         * 
         * @return the string
         */
        public String unescapeString(String s) {
            StringBuilder ret = new StringBuilder();
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
            }
            
            CharacterIterator ci = new StringCharacterIterator(s);
            char c = ci.first();
            while(c != CharacterIterator.DONE) {
                char tc = 0;
                switch(c) {
                case '\\':
                    c = ci.next();
                    switch(c) {
                    case 'n':
                        tc = '\n';
                        break;
                    case 'r':
                        tc = '\r';
                        break;
                    case 't':
                        tc = '\t';
                        break;
                    case 'b':
                        tc = '\b';
                        break;
                    case 'f':
                        tc = '\f';
                        break;
                    case '"':
                        tc = '"';
                        break;
                    case '\'':
                        tc = '\'';
                        break;
                    case '\\':
                        tc = '\\';
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                        throw new RuntimeException("octal escape sequences not supported yet");
                    default:
                        throw new RuntimeException("unknown escape sequence: '\\" + c + "'");
                    }
                    break;
                default:
                    tc = c;
                    break;
                }
                ret.append(tc);
                c = ci.next();
            }
            return ret.toString();
        }




    // $ANTLR start "identifier"
    // ./scenariotestTemp/generated2/XPathReduced.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/XPathReduced.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "identifier"


    // $ANTLR start "stringSymbol"
    // ./scenariotestTemp/generated2/XPathReduced.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/XPathReduced.g:219:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol100); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "stringSymbol"


    // $ANTLR start "integerSymbol"
    // ./scenariotestTemp/generated2/XPathReduced.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:228:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:229:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:229:3: (ast= INT )
            // ./scenariotestTemp/generated2/XPathReduced.g:229:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol131); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Integer.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "integerSymbol"


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/XPathReduced.g:237:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:238:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:239:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:239:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/XPathReduced.g:239:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol162); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "floatSymbol"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/XPathReduced.g:247:1: main returns [Object ret2] : ( (ret= xpath_expression ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:248:3: ( ( (ret= xpath_expression ) EOF ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:249:3: ( (ret= xpath_expression ) EOF )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:249:3: ( (ret= xpath_expression ) EOF )
            // ./scenariotestTemp/generated2/XPathReduced.g:249:4: (ret= xpath_expression ) EOF
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:249:4: (ret= xpath_expression )
            // ./scenariotestTemp/generated2/XPathReduced.g:249:5: ret= xpath_expression
            {
            pushFollow(FOLLOW_xpath_expression_in_main190);
            ret=xpath_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main193); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "main"


    // $ANTLR start "primary_xpath_expression"
    // ./scenariotestTemp/generated2/XPathReduced.g:256:1: primary_xpath_expression returns [Object ret2] : (ret= xpath_literalexp | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) ) ;
    public final Object primary_xpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:257:3: ( (ret= xpath_literalexp | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:258:3: (ret= xpath_literalexp | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:258:3: (ret= xpath_literalexp | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case STRING:
            case INT:
                {
                alt1=1;
                }
                break;
            case DOLLAR:
                {
                alt1=2;
                }
                break;
            case LPAREN:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:258:4: ret= xpath_literalexp
                    {
                    pushFollow(FOLLOW_xpath_literalexp_in_primary_xpath_expression221);
                    ret=xpath_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:259:5: ret= xpath_variableexp
                    {
                    pushFollow(FOLLOW_xpath_variableexp_in_primary_xpath_expression229);
                    ret=xpath_variableexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:260:5: ( LPAREN ret= xpath_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:260:5: ( LPAREN ret= xpath_expression RPAREN )
                    // ./scenariotestTemp/generated2/XPathReduced.g:260:6: LPAREN ret= xpath_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_xpath_expression238); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_xpath_expression_in_primary_xpath_expression244);
                    ret=xpath_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_xpath_expression248); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitOpdBrackSeq();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "primary_xpath_expression"


    // $ANTLR start "priority_0"
    // ./scenariotestTemp/generated2/XPathReduced.g:267:1: priority_0 returns [Object ret2] : (ret= primary_xpath_expression ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:268:3: ( (ret= primary_xpath_expression ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:269:4: (ret= primary_xpath_expression )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:269:4: (ret= primary_xpath_expression )
            // ./scenariotestTemp/generated2/XPathReduced.g:269:5: ret= primary_xpath_expression
            {
            pushFollow(FOLLOW_primary_xpath_expression_in_priority_0283);
            ret=primary_xpath_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_0"


    // $ANTLR start "priority_1"
    // ./scenariotestTemp/generated2/XPathReduced.g:277:1: priority_1 returns [Object ret2] : (ret= priority_0 ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:278:3: ( (ret= priority_0 ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:279:4: (ret= priority_0 )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:279:4: (ret= priority_0 )
            // ./scenariotestTemp/generated2/XPathReduced.g:279:5: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_priority_1318);
            ret=priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_1"


    // $ANTLR start "priority_2"
    // ./scenariotestTemp/generated2/XPathReduced.g:287:1: priority_2 returns [Object ret2] : ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:288:3: ( ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:289:4: ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:289:4: ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:289:6: (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:289:6: (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:289:8: ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_2356);
            ret=priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:289:22: ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PIPE) && (synpred3_XPathReduced())) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:23: ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:35: ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:36: PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("|", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_priority_2369); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "|";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:289:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_2377);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_1_in_priority_2381);
            	    right=priority_1();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
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

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_2"


    // $ANTLR start "priority_3"
    // ./scenariotestTemp/generated2/XPathReduced.g:299:1: priority_3 returns [Object ret2] : ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:300:3: ( ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:301:4: ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:301:4: ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==MINUS) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=STRING && LA3_0<=INT)||LA3_0==LPAREN||LA3_0==DOLLAR) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:5: ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:5: ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) )
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:6: ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:19: ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) )
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:20: MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpSeq("-", 1, false);
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,MINUS,FOLLOW_MINUS_in_priority_3435); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      opName = "-";
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) )
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 )
                    // ./scenariotestTemp/generated2/XPathReduced.g:301:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2
                    {
                    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_3443);
                    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, null, firstToken);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    pushFollow(FOLLOW_priority_2_in_priority_3447);
                    right=priority_2();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "left", right);
                      this.setLocationAndComment(ret, firstToken);

                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                      _exitOpSeq();
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:305:2: (ret= priority_2 )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:305:2: (ret= priority_2 )
                    // ./scenariotestTemp/generated2/XPathReduced.g:305:4: ret= priority_2
                    {
                    pushFollow(FOLLOW_priority_2_in_priority_3463);
                    ret=priority_2();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_3"


    // $ANTLR start "priority_4"
    // ./scenariotestTemp/generated2/XPathReduced.g:313:1: priority_4 returns [Object ret2] : ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:314:3: ( ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:315:4: ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:315:4: ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:315:6: (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:315:6: (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:315:8: ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_4502);
            ret=priority_3();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:315:22: ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop4:
            do {
                int alt4=4;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==STAR) && (synpred6_XPathReduced())) {
                    alt4=1;
                }
                else if ( (LA4_0==36) && (synpred7_XPathReduced())) {
                    alt4=2;
                }
                else if ( (LA4_0==37) && (synpred8_XPathReduced())) {
                    alt4=3;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:23: ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:35: ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:36: STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,STAR,FOLLOW_STAR_in_priority_4515); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:315:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4523);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4527);
            	    right=priority_3();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:3: ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:16: ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:17: 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("div", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,36,FOLLOW_36_in_priority_4548); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "div";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:318:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4555);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4559);
            	    right=priority_3();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:3: ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:16: ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:17: 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("mod", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,37,FOLLOW_37_in_priority_4580); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "mod";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:321:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4587);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4591);
            	    right=priority_3();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_4"


    // $ANTLR start "priority_5"
    // ./scenariotestTemp/generated2/XPathReduced.g:331:1: priority_5 returns [Object ret2] : ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:332:3: ( ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:333:4: ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:333:4: ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:333:6: (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:333:6: (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:333:8: ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_5638);
            ret=priority_4();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:333:22: ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==PLUS) && (synpred9_XPathReduced())) {
                    alt5=1;
                }
                else if ( (LA5_0==MINUS) && (synpred10_XPathReduced())) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:23: ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:35: ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:36: PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_5651); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:333:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5659);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5663);
            	    right=priority_4();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:3: ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:16: ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:17: MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,MINUS,FOLLOW_MINUS_in_priority_5684); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:100: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:101: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:101: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:336:102: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5692);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5696);
            	    right=priority_4();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_5"


    // $ANTLR start "priority_6"
    // ./scenariotestTemp/generated2/XPathReduced.g:346:1: priority_6 returns [Object ret2] : ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) ) ;
    public final Object priority_6() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:347:3: ( ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:348:4: ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:348:4: ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:348:6: (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:348:6: (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:348:8: ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_5_in_priority_6743);
            ret=priority_5();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:348:22: ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )*
            loop6:
            do {
                int alt6=5;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==LT) && (synpred11_XPathReduced())) {
                    alt6=1;
                }
                else if ( (LA6_0==LE) && (synpred12_XPathReduced())) {
                    alt6=2;
                }
                else if ( (LA6_0==GT) && (synpred13_XPathReduced())) {
                    alt6=3;
                }
                else if ( (LA6_0==GE) && (synpred14_XPathReduced())) {
                    alt6=4;
                }


                switch (alt6) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:23: ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:33: ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:34: LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LT,FOLLOW_LT_in_priority_6756); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:114: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:348:116: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6764);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6768);
            	    right=priority_5();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:3: ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:13: ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:14: LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LE,FOLLOW_LE_in_priority_6789); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:96: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:351:98: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6797);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6801);
            	    right=priority_5();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:3: ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:13: ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:14: GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GT,FOLLOW_GT_in_priority_6822); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:94: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:95: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:95: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:354:96: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6830);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6834);
            	    right=priority_5();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:3: ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:13: ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:14: GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GE,FOLLOW_GE_in_priority_6855); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:96: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:357:98: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6863);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6867);
            	    right=priority_5();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_6"


    // $ANTLR start "priority_7"
    // ./scenariotestTemp/generated2/XPathReduced.g:367:1: priority_7 returns [Object ret2] : ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) ) ;
    public final Object priority_7() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:368:3: ( ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:369:4: ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:369:4: ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:369:6: (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:369:6: (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:369:8: ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_6_in_priority_7914);
            ret=priority_6();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:369:22: ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EQ) && (synpred15_XPathReduced())) {
                    alt7=1;
                }
                else if ( (LA7_0==EXCLEQ) && (synpred16_XPathReduced())) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:23: ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:33: ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:34: EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQ,FOLLOW_EQ_in_priority_7927); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:114: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:369:116: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7935);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_6_in_priority_7939);
            	    right=priority_6();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:3: ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:17: ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:18: EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EXCLEQ,FOLLOW_EXCLEQ_in_priority_7960); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:104: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:105: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:105: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:372:106: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7968);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_6_in_priority_7972);
            	    right=priority_6();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
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

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_7"


    // $ANTLR start "priority_8"
    // ./scenariotestTemp/generated2/XPathReduced.g:382:1: priority_8 returns [Object ret2] : ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) ) ;
    public final Object priority_8() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:383:3: ( ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:384:4: ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:384:4: ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:384:6: (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:384:6: (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:384:8: ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_7_in_priority_81019);
            ret=priority_7();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:384:22: ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==38) && (synpred17_XPathReduced())) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:23: ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:36: ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:37: 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("and", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,38,FOLLOW_38_in_priority_81032); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "and";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:123: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:124: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:124: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:384:125: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_81039);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_7_in_priority_81043);
            	    right=priority_7();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_8"


    // $ANTLR start "priority_9"
    // ./scenariotestTemp/generated2/XPathReduced.g:394:1: priority_9 returns [Object ret2] : ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) ) ;
    public final Object priority_9() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:395:3: ( ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:396:4: ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:396:4: ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:396:6: (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:396:6: (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:396:8: ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_8_in_priority_91090);
            ret=priority_8();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPathReduced.g:396:22: ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==39) && (synpred18_XPathReduced())) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:23: ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:35: ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:36: 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("or", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,39,FOLLOW_39_in_priority_91103); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "or";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:119: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:120: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 )
            	    {
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:120: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 )
            	    // ./scenariotestTemp/generated2/XPathReduced.g:396:121: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_91110);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_8_in_priority_91114);
            	    right=priority_8();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "priority_9"


    // $ANTLR start "xpath_expression"
    // ./scenariotestTemp/generated2/XPathReduced.g:406:1: xpath_expression returns [Object ret2] : ret= priority_9 ;
    public final Object xpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:407:3: (ret= priority_9 )
            // ./scenariotestTemp/generated2/XPathReduced.g:408:3: ret= priority_9
            {
            pushFollow(FOLLOW_priority_9_in_xpath_expression1152);
            ret=priority_9();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "xpath_expression"


    // $ANTLR start "xpath_variableexp"
    // ./scenariotestTemp/generated2/XPathReduced.g:415:1: xpath_variableexp returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object xpath_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","VariableExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:420:3: ( ( DOLLAR (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:421:3: ( DOLLAR (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:421:3: ( DOLLAR (temp= identifier ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:421:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_xpath_variableexp1182); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPathReduced.g:421:62: (temp= identifier )
            // ./scenariotestTemp/generated2/XPathReduced.g:421:64: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_xpath_variableexp1190);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "xpath_variableexp"


    // $ANTLR start "xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr"
    // ./scenariotestTemp/generated2/XPathReduced.g:429:1: xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","OperatorCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:434:3: ()
            // ./scenariotestTemp/generated2/XPathReduced.g:435:3: 
            {
            if ( state.backtracking==0 ) {

              setProperty(ret,"name" , opName);
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


            }

            }

        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr"


    // $ANTLR start "xpath_literalexp"
    // ./scenariotestTemp/generated2/XPathReduced.g:445:1: xpath_literalexp returns [Object ret2] : (ret= xpath_integerexp | ret= xpath_stringexp ) ;
    public final Object xpath_literalexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:446:3: ( (ret= xpath_integerexp | ret= xpath_stringexp ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:447:3: (ret= xpath_integerexp | ret= xpath_stringexp )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:447:3: (ret= xpath_integerexp | ret= xpath_stringexp )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==INT) ) {
                alt10=1;
            }
            else if ( (LA10_0==STRING) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:447:4: ret= xpath_integerexp
                    {
                    pushFollow(FOLLOW_xpath_integerexp_in_xpath_literalexp1258);
                    ret=xpath_integerexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:448:5: ret= xpath_stringexp
                    {
                    pushFollow(FOLLOW_xpath_stringexp_in_xpath_literalexp1266);
                    ret=xpath_stringexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "xpath_literalexp"


    // $ANTLR start "xpath_integerexp"
    // ./scenariotestTemp/generated2/XPathReduced.g:455:1: xpath_integerexp returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object xpath_integerexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","IntegerExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:460:3: ( ( (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:461:3: ( (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:461:3: ( (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:461:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPathReduced.g:461:21: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/XPathReduced.g:461:23: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_xpath_integerexp1300);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "symbol", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "xpath_integerexp"


    // $ANTLR start "xpath_stringexp"
    // ./scenariotestTemp/generated2/XPathReduced.g:469:1: xpath_stringexp returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object xpath_stringexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","StringExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:474:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:475:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:475:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:475:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPathReduced.g:475:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/XPathReduced.g:475:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_xpath_stringexp1347);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "symbol", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "xpath_stringexp"

    // $ANTLR start synpred3_XPathReduced
    public final void synpred3_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:289:23: ( ( PIPE ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:289:24: ( PIPE ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:289:24: ( PIPE )
        // ./scenariotestTemp/generated2/XPathReduced.g:289:25: PIPE
        {
        match(input,PIPE,FOLLOW_PIPE_in_synpred3_XPathReduced360); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:289:30: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:289:31: 
        {
        }


        }
    }
    // $ANTLR end synpred3_XPathReduced

    // $ANTLR start synpred6_XPathReduced
    public final void synpred6_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:315:23: ( ( STAR ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:315:24: ( STAR ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:315:24: ( STAR )
        // ./scenariotestTemp/generated2/XPathReduced.g:315:25: STAR
        {
        match(input,STAR,FOLLOW_STAR_in_synpred6_XPathReduced506); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:315:30: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:315:31: 
        {
        }


        }
    }
    // $ANTLR end synpred6_XPathReduced

    // $ANTLR start synpred7_XPathReduced
    public final void synpred7_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:318:3: ( ( 'div' ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:318:4: ( 'div' ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:318:4: ( 'div' )
        // ./scenariotestTemp/generated2/XPathReduced.g:318:5: 'div'
        {
        match(input,36,FOLLOW_36_in_synpred7_XPathReduced539); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:318:11: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:318:12: 
        {
        }


        }
    }
    // $ANTLR end synpred7_XPathReduced

    // $ANTLR start synpred8_XPathReduced
    public final void synpred8_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:321:3: ( ( 'mod' ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:321:4: ( 'mod' ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:321:4: ( 'mod' )
        // ./scenariotestTemp/generated2/XPathReduced.g:321:5: 'mod'
        {
        match(input,37,FOLLOW_37_in_synpred8_XPathReduced571); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:321:11: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:321:12: 
        {
        }


        }
    }
    // $ANTLR end synpred8_XPathReduced

    // $ANTLR start synpred9_XPathReduced
    public final void synpred9_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:333:23: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:333:24: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:333:24: ( PLUS )
        // ./scenariotestTemp/generated2/XPathReduced.g:333:25: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred9_XPathReduced642); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:333:30: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:333:31: 
        {
        }


        }
    }
    // $ANTLR end synpred9_XPathReduced

    // $ANTLR start synpred10_XPathReduced
    public final void synpred10_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:336:3: ( ( MINUS ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:336:4: ( MINUS ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:336:4: ( MINUS )
        // ./scenariotestTemp/generated2/XPathReduced.g:336:5: MINUS
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred10_XPathReduced675); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:336:11: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:336:12: 
        {
        }


        }
    }
    // $ANTLR end synpred10_XPathReduced

    // $ANTLR start synpred11_XPathReduced
    public final void synpred11_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:348:23: ( ( LT ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:348:24: ( LT ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:348:24: ( LT )
        // ./scenariotestTemp/generated2/XPathReduced.g:348:25: LT
        {
        match(input,LT,FOLLOW_LT_in_synpred11_XPathReduced747); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:348:28: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:348:29: 
        {
        }


        }
    }
    // $ANTLR end synpred11_XPathReduced

    // $ANTLR start synpred12_XPathReduced
    public final void synpred12_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:351:3: ( ( LE ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:351:4: ( LE ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:351:4: ( LE )
        // ./scenariotestTemp/generated2/XPathReduced.g:351:5: LE
        {
        match(input,LE,FOLLOW_LE_in_synpred12_XPathReduced780); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:351:8: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:351:9: 
        {
        }


        }
    }
    // $ANTLR end synpred12_XPathReduced

    // $ANTLR start synpred13_XPathReduced
    public final void synpred13_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:354:3: ( ( GT ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:354:4: ( GT ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:354:4: ( GT )
        // ./scenariotestTemp/generated2/XPathReduced.g:354:5: GT
        {
        match(input,GT,FOLLOW_GT_in_synpred13_XPathReduced813); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:354:8: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:354:9: 
        {
        }


        }
    }
    // $ANTLR end synpred13_XPathReduced

    // $ANTLR start synpred14_XPathReduced
    public final void synpred14_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:357:3: ( ( GE ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:357:4: ( GE ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:357:4: ( GE )
        // ./scenariotestTemp/generated2/XPathReduced.g:357:5: GE
        {
        match(input,GE,FOLLOW_GE_in_synpred14_XPathReduced846); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:357:8: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:357:9: 
        {
        }


        }
    }
    // $ANTLR end synpred14_XPathReduced

    // $ANTLR start synpred15_XPathReduced
    public final void synpred15_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:369:23: ( ( EQ ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:369:24: ( EQ ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:369:24: ( EQ )
        // ./scenariotestTemp/generated2/XPathReduced.g:369:25: EQ
        {
        match(input,EQ,FOLLOW_EQ_in_synpred15_XPathReduced918); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:369:28: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:369:29: 
        {
        }


        }
    }
    // $ANTLR end synpred15_XPathReduced

    // $ANTLR start synpred16_XPathReduced
    public final void synpred16_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:372:3: ( ( EXCLEQ ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:372:4: ( EXCLEQ ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:372:4: ( EXCLEQ )
        // ./scenariotestTemp/generated2/XPathReduced.g:372:5: EXCLEQ
        {
        match(input,EXCLEQ,FOLLOW_EXCLEQ_in_synpred16_XPathReduced951); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:372:12: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:372:13: 
        {
        }


        }
    }
    // $ANTLR end synpred16_XPathReduced

    // $ANTLR start synpred17_XPathReduced
    public final void synpred17_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:384:23: ( ( 'and' ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:384:24: ( 'and' ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:384:24: ( 'and' )
        // ./scenariotestTemp/generated2/XPathReduced.g:384:25: 'and'
        {
        match(input,38,FOLLOW_38_in_synpred17_XPathReduced1023); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:384:31: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:384:32: 
        {
        }


        }
    }
    // $ANTLR end synpred17_XPathReduced

    // $ANTLR start synpred18_XPathReduced
    public final void synpred18_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:396:23: ( ( 'or' ) () )
        // ./scenariotestTemp/generated2/XPathReduced.g:396:24: ( 'or' ) ()
        {
        // ./scenariotestTemp/generated2/XPathReduced.g:396:24: ( 'or' )
        // ./scenariotestTemp/generated2/XPathReduced.g:396:25: 'or'
        {
        match(input,39,FOLLOW_39_in_synpred18_XPathReduced1094); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPathReduced.g:396:30: ()
        // ./scenariotestTemp/generated2/XPathReduced.g:396:31: 
        {
        }


        }
    }
    // $ANTLR end synpred18_XPathReduced

    // Delegated rules

    public final boolean synpred10_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_expression_in_main190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_literalexp_in_primary_xpath_expression221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_variableexp_in_primary_xpath_expression229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_xpath_expression238 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_expression_in_primary_xpath_expression244 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_primary_xpath_expression248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_xpath_expression_in_priority_0283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_2356 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_PIPE_in_priority_2369 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_2377 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_1_in_priority_2381 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_MINUS_in_priority_3435 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_3443 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_2_in_priority_3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_2_in_priority_3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_3_in_priority_4502 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_STAR_in_priority_4515 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4523 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_3_in_priority_4527 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_36_in_priority_4548 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4555 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_3_in_priority_4559 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_37_in_priority_4580 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4587 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_3_in_priority_4591 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_priority_4_in_priority_5638 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_PLUS_in_priority_5651 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5659 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_4_in_priority_5663 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_MINUS_in_priority_5684 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5692 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_4_in_priority_5696 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_priority_5_in_priority_6743 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LT_in_priority_6756 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6764 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_5_in_priority_6768 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LE_in_priority_6789 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6797 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_5_in_priority_6801 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GT_in_priority_6822 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6830 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_5_in_priority_6834 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GE_in_priority_6855 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6863 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_5_in_priority_6867 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_priority_6_in_priority_7914 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQ_in_priority_7927 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7935 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_6_in_priority_7939 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EXCLEQ_in_priority_7960 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7968 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_6_in_priority_7972 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_priority_7_in_priority_81019 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_priority_81032 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_81039 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_7_in_priority_81043 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_priority_8_in_priority_91090 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_priority_91103 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_91110 = new BitSet(new long[]{0x0000000000100960L});
    public static final BitSet FOLLOW_priority_8_in_priority_91114 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_priority_9_in_xpath_expression1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_xpath_variableexp1182 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_xpath_variableexp1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_integerexp_in_xpath_literalexp1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_stringexp_in_xpath_literalexp1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_xpath_integerexp1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_xpath_stringexp1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred3_XPathReduced360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred6_XPathReduced506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred7_XPathReduced539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred8_XPathReduced571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred9_XPathReduced642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred10_XPathReduced675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_synpred11_XPathReduced747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_synpred12_XPathReduced780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_synpred13_XPathReduced813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_synpred14_XPathReduced846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_synpred15_XPathReduced918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLEQ_in_synpred16_XPathReduced951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred17_XPathReduced1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred18_XPathReduced1094 = new BitSet(new long[]{0x0000000000000002L});

}