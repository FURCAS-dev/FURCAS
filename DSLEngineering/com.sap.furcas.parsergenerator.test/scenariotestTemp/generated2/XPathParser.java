// $ANTLR 3.1.1 ./scenariotestTemp/generated2/XPath.g 2010-11-04 23:26:46

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
public class XPathParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LPAREN", "RPAREN", "PIPE", "MINUS", "STAR", "PLUS", "LT", "LE", "GT", "GE", "EQ", "EXCLEQ", "DOLLAR", "SLASH", "POINT", "POINTPOINT", "LSQUARE", "RSQUARE", "COLONS", "AROBAS", "COMMENT", "SLASHSLASH", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'div'", "'mod'", "'and'", "'or'", "','", "'node'", "'text'", "'ancestor'", "'ancestor-or-self'", "'attribute'", "'child'", "'descendant'", "'descendant-or-self'", "'following'", "'following-sibling'", "'namespace'", "'parent'", "'preceding'", "'preceding-sibling'", "'self'"
    };
    public static final int DOLLAR=20;
    public static final int LT=14;
    public static final int STAR=12;
    public static final int LSQUARE=24;
    public static final int POINT=22;
    public static final int AROBAS=27;
    public static final int ESC=35;
    public static final int FLOAT=7;
    public static final int EOF=-1;
    public static final int LPAREN=8;
    public static final int COLONS=26;
    public static final int T__55=55;
    public static final int RPAREN=9;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=21;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int POINTPOINT=23;
    public static final int PIPE=10;
    public static final int PLUS=13;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int EQ=18;
    public static final int COMMENT=28;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int GE=17;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int EXCLEQ=19;
    public static final int INT=6;
    public static final int RSQUARE=25;
    public static final int MINUS=11;
    public static final int ALPHA=33;
    public static final int WS=31;
    public static final int SLASHSLASH=29;
    public static final int SNAME=34;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int GT=16;
    public static final int LE=15;
    public static final int STRING=5;

    // delegates
    // delegators


        public XPathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XPathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return XPathParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/XPath.g"; }


       private static final String syntaxUUID = "XPath";
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
    // ./scenariotestTemp/generated2/XPath.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPath.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/XPath.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/XPath.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/XPath.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/XPath.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPath.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/XPath.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/XPath.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/XPath.g:219:4: ast= STRING
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
    // ./scenariotestTemp/generated2/XPath.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPath.g:228:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/XPath.g:229:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/XPath.g:229:3: (ast= INT )
            // ./scenariotestTemp/generated2/XPath.g:229:4: ast= INT
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
    // ./scenariotestTemp/generated2/XPath.g:237:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/XPath.g:238:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/XPath.g:239:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/XPath.g:239:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/XPath.g:239:4: ast= FLOAT
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
    // ./scenariotestTemp/generated2/XPath.g:247:1: main returns [Object ret2] : ( (ret= xpath_expression ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:248:3: ( ( (ret= xpath_expression ) EOF ) )
            // ./scenariotestTemp/generated2/XPath.g:249:3: ( (ret= xpath_expression ) EOF )
            {
            // ./scenariotestTemp/generated2/XPath.g:249:3: ( (ret= xpath_expression ) EOF )
            // ./scenariotestTemp/generated2/XPath.g:249:4: (ret= xpath_expression ) EOF
            {
            // ./scenariotestTemp/generated2/XPath.g:249:4: (ret= xpath_expression )
            // ./scenariotestTemp/generated2/XPath.g:249:5: ret= xpath_expression
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
    // ./scenariotestTemp/generated2/XPath.g:256:1: primary_xpath_expression returns [Object ret2] : (ret= xpath_functioncallexp | ret= xpath_literalexp | ret= xpath_pathexpression | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) ) ;
    public final Object primary_xpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:257:3: ( (ret= xpath_functioncallexp | ret= xpath_literalexp | ret= xpath_pathexpression | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/XPath.g:258:3: (ret= xpath_functioncallexp | ret= xpath_literalexp | ret= xpath_pathexpression | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:258:3: (ret= xpath_functioncallexp | ret= xpath_literalexp | ret= xpath_pathexpression | ret= xpath_variableexp | ( LPAREN ret= xpath_expression RPAREN ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case NAME:
                {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==EOF||(LA1_1>=RPAREN && LA1_1<=EXCLEQ)||LA1_1==SLASH||(LA1_1>=LSQUARE && LA1_1<=RSQUARE)||(LA1_1>=36 && LA1_1<=40)) ) {
                    alt1=3;
                }
                else if ( (LA1_1==LPAREN) ) {
                    alt1=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
            case INT:
                {
                alt1=2;
                }
                break;
            case STAR:
            case SLASH:
            case POINT:
            case POINTPOINT:
            case AROBAS:
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
            case 53:
            case 54:
            case 55:
                {
                alt1=3;
                }
                break;
            case DOLLAR:
                {
                alt1=4;
                }
                break;
            case LPAREN:
                {
                alt1=5;
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
                    // ./scenariotestTemp/generated2/XPath.g:258:4: ret= xpath_functioncallexp
                    {
                    pushFollow(FOLLOW_xpath_functioncallexp_in_primary_xpath_expression221);
                    ret=xpath_functioncallexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:259:5: ret= xpath_literalexp
                    {
                    pushFollow(FOLLOW_xpath_literalexp_in_primary_xpath_expression229);
                    ret=xpath_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:260:5: ret= xpath_pathexpression
                    {
                    pushFollow(FOLLOW_xpath_pathexpression_in_primary_xpath_expression237);
                    ret=xpath_pathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPath.g:261:5: ret= xpath_variableexp
                    {
                    pushFollow(FOLLOW_xpath_variableexp_in_primary_xpath_expression245);
                    ret=xpath_variableexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/XPath.g:262:5: ( LPAREN ret= xpath_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:262:5: ( LPAREN ret= xpath_expression RPAREN )
                    // ./scenariotestTemp/generated2/XPath.g:262:6: LPAREN ret= xpath_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_xpath_expression254); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_xpath_expression_in_primary_xpath_expression260);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_xpath_expression264); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/XPath.g:269:1: priority_0 returns [Object ret2] : (ret= primary_xpath_expression ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:270:3: ( (ret= primary_xpath_expression ) )
            // ./scenariotestTemp/generated2/XPath.g:271:4: (ret= primary_xpath_expression )
            {
            // ./scenariotestTemp/generated2/XPath.g:271:4: (ret= primary_xpath_expression )
            // ./scenariotestTemp/generated2/XPath.g:271:5: ret= primary_xpath_expression
            {
            pushFollow(FOLLOW_primary_xpath_expression_in_priority_0299);
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
    // ./scenariotestTemp/generated2/XPath.g:279:1: priority_1 returns [Object ret2] : (ret= priority_0 ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:280:3: ( (ret= priority_0 ) )
            // ./scenariotestTemp/generated2/XPath.g:281:4: (ret= priority_0 )
            {
            // ./scenariotestTemp/generated2/XPath.g:281:4: (ret= priority_0 )
            // ./scenariotestTemp/generated2/XPath.g:281:5: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_priority_1334);
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
    // ./scenariotestTemp/generated2/XPath.g:289:1: priority_2 returns [Object ret2] : ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:290:3: ( ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:291:4: ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:291:4: ( (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:291:6: (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:291:6: (ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:291:8: ret= priority_1 ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_2372);
            ret=priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:291:22: ( ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PIPE) && (synpred5_XPath())) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:291:23: ( ( PIPE ) () )=> ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:291:35: ( PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:291:36: PIPE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("|", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_priority_2385); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "|";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:291:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:291:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:291:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    // ./scenariotestTemp/generated2/XPath.g:291:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_1
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_2393);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_1_in_priority_2397);
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
    // ./scenariotestTemp/generated2/XPath.g:301:1: priority_3 returns [Object ret2] : ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:302:3: ( ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) ) )
            // ./scenariotestTemp/generated2/XPath.g:303:4: ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:303:4: ( ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) ) | (ret= priority_2 ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==MINUS) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=NAME && LA3_0<=INT)||LA3_0==LPAREN||LA3_0==STAR||(LA3_0>=DOLLAR && LA3_0<=POINTPOINT)||LA3_0==AROBAS||(LA3_0>=41 && LA3_0<=55)) ) {
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
                    // ./scenariotestTemp/generated2/XPath.g:303:5: ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:303:5: ( ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) ) )
                    // ./scenariotestTemp/generated2/XPath.g:303:6: ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:303:19: ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) ) )
                    // ./scenariotestTemp/generated2/XPath.g:303:20: MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpSeq("-", 1, false);
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,MINUS,FOLLOW_MINUS_in_priority_3451); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      opName = "-";
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPath.g:303:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 ) )
                    // ./scenariotestTemp/generated2/XPath.g:303:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:303:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2 )
                    // ./scenariotestTemp/generated2/XPath.g:303:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken] right= priority_2
                    {
                    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_3459);
                    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, null, firstToken);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    pushFollow(FOLLOW_priority_2_in_priority_3463);
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
                    // ./scenariotestTemp/generated2/XPath.g:307:2: (ret= priority_2 )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:307:2: (ret= priority_2 )
                    // ./scenariotestTemp/generated2/XPath.g:307:4: ret= priority_2
                    {
                    pushFollow(FOLLOW_priority_2_in_priority_3479);
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
    // ./scenariotestTemp/generated2/XPath.g:315:1: priority_4 returns [Object ret2] : ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:316:3: ( ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:317:4: ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:317:4: ( (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:317:6: (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:317:6: (ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:317:8: ret= priority_3 ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_4518);
            ret=priority_3();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:317:22: ( ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop4:
            do {
                int alt4=4;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==STAR) && (synpred8_XPath())) {
                    alt4=1;
                }
                else if ( (LA4_0==36) && (synpred9_XPath())) {
                    alt4=2;
                }
                else if ( (LA4_0==37) && (synpred10_XPath())) {
                    alt4=3;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:317:23: ( ( STAR ) () )=> ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:317:35: ( STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:317:36: STAR ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,STAR,FOLLOW_STAR_in_priority_4531); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:317:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:317:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:317:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPath.g:317:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4539);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4543);
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
            	    // ./scenariotestTemp/generated2/XPath.g:320:3: ( ( 'div' ) () )=> ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:320:16: ( 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:320:17: 'div' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("div", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,36,FOLLOW_36_in_priority_4564); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "div";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:320:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:320:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:320:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPath.g:320:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4571);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4575);
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
            	    // ./scenariotestTemp/generated2/XPath.g:323:3: ( ( 'mod' ) () )=> ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:323:16: ( 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:323:17: 'mod' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("mod", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,37,FOLLOW_37_in_priority_4596); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "mod";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:323:103: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:323:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:323:104: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/XPath.g:323:105: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4603);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4607);
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
    // ./scenariotestTemp/generated2/XPath.g:333:1: priority_5 returns [Object ret2] : ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:334:3: ( ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:335:4: ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:335:4: ( (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:335:6: (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:335:6: (ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:335:8: ret= priority_4 ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_5654);
            ret=priority_4();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:335:22: ( ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==PLUS) && (synpred11_XPath())) {
                    alt5=1;
                }
                else if ( (LA5_0==MINUS) && (synpred12_XPath())) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:335:23: ( ( PLUS ) () )=> ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:335:35: ( PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:335:36: PLUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_5667); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:335:118: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:335:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:335:119: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/XPath.g:335:120: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5675);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5679);
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
            	    // ./scenariotestTemp/generated2/XPath.g:338:3: ( ( MINUS ) () )=> ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:338:16: ( MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:338:17: MINUS ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,MINUS,FOLLOW_MINUS_in_priority_5700); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:338:100: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:338:101: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:338:101: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/XPath.g:338:102: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5708);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5712);
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
    // ./scenariotestTemp/generated2/XPath.g:348:1: priority_6 returns [Object ret2] : ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) ) ;
    public final Object priority_6() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:349:3: ( ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:350:4: ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:350:4: ( (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:350:6: (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:350:6: (ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:350:8: ret= priority_5 ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_5_in_priority_6759);
            ret=priority_5();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:350:22: ( ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) ) )*
            loop6:
            do {
                int alt6=5;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==LT) && (synpred13_XPath())) {
                    alt6=1;
                }
                else if ( (LA6_0==LE) && (synpred14_XPath())) {
                    alt6=2;
                }
                else if ( (LA6_0==GT) && (synpred15_XPath())) {
                    alt6=3;
                }
                else if ( (LA6_0==GE) && (synpred16_XPath())) {
                    alt6=4;
                }


                switch (alt6) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:350:23: ( ( LT ) () )=> ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:350:33: ( LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:350:34: LT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LT,FOLLOW_LT_in_priority_6772); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:350:114: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:350:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:350:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPath.g:350:116: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6780);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6784);
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
            	    // ./scenariotestTemp/generated2/XPath.g:353:3: ( ( LE ) () )=> ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:353:13: ( LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:353:14: LE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LE,FOLLOW_LE_in_priority_6805); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:353:96: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:353:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:353:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPath.g:353:98: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6813);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6817);
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
            	    // ./scenariotestTemp/generated2/XPath.g:356:3: ( ( GT ) () )=> ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:356:13: ( GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:356:14: GT ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GT,FOLLOW_GT_in_priority_6838); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:356:94: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:356:95: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:356:95: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPath.g:356:96: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6846);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6850);
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
            	    // ./scenariotestTemp/generated2/XPath.g:359:3: ( ( GE ) () )=> ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:359:13: ( GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:359:14: GE ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GE,FOLLOW_GE_in_priority_6871); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:359:96: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:359:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:359:97: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5 )
            	    // ./scenariotestTemp/generated2/XPath.g:359:98: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_5
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6879);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_5_in_priority_6883);
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
    // ./scenariotestTemp/generated2/XPath.g:369:1: priority_7 returns [Object ret2] : ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) ) ;
    public final Object priority_7() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:370:3: ( ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:371:4: ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:371:4: ( (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:371:6: (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:371:6: (ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:371:8: ret= priority_6 ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_6_in_priority_7930);
            ret=priority_6();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:371:22: ( ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) | ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==EQ) && (synpred17_XPath())) {
                    alt7=1;
                }
                else if ( (LA7_0==EXCLEQ) && (synpred18_XPath())) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:371:23: ( ( EQ ) () )=> ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:371:33: ( EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:371:34: EQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQ,FOLLOW_EQ_in_priority_7943); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:371:114: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:371:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:371:115: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    // ./scenariotestTemp/generated2/XPath.g:371:116: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7951);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_6_in_priority_7955);
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
            	    // ./scenariotestTemp/generated2/XPath.g:374:3: ( ( EXCLEQ ) () )=> ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:374:17: ( EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:374:18: EXCLEQ ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EXCLEQ,FOLLOW_EXCLEQ_in_priority_7976); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:374:104: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:374:105: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:374:105: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6 )
            	    // ./scenariotestTemp/generated2/XPath.g:374:106: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_6
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7984);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_6_in_priority_7988);
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
    // ./scenariotestTemp/generated2/XPath.g:384:1: priority_8 returns [Object ret2] : ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) ) ;
    public final Object priority_8() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:385:3: ( ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:386:4: ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:386:4: ( (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:386:6: (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:386:6: (ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:386:8: ret= priority_7 ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_7_in_priority_81035);
            ret=priority_7();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:386:22: ( ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==38) && (synpred19_XPath())) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:386:23: ( ( 'and' ) () )=> ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:386:36: ( 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:386:37: 'and' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("and", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,38,FOLLOW_38_in_priority_81048); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "and";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:386:123: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:386:124: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:386:124: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7 )
            	    // ./scenariotestTemp/generated2/XPath.g:386:125: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_7
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_81055);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_7_in_priority_81059);
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
    // ./scenariotestTemp/generated2/XPath.g:396:1: priority_9 returns [Object ret2] : ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) ) ;
    public final Object priority_9() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/XPath.g:397:3: ( ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:398:4: ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:398:4: ( (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:398:6: (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:398:6: (ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )* )
            // ./scenariotestTemp/generated2/XPath.g:398:8: ret= priority_8 ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_8_in_priority_91106);
            ret=priority_8();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/XPath.g:398:22: ( ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==39) && (synpred20_XPath())) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:398:23: ( ( 'or' ) () )=> ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:398:35: ( 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) ) )
            	    // ./scenariotestTemp/generated2/XPath.g:398:36: 'or' ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("or", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,39,FOLLOW_39_in_priority_91119); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "or";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/XPath.g:398:119: ( (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 ) )
            	    // ./scenariotestTemp/generated2/XPath.g:398:120: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 )
            	    {
            	    // ./scenariotestTemp/generated2/XPath.g:398:120: (ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8 )
            	    // ./scenariotestTemp/generated2/XPath.g:398:121: ret= xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken] right= priority_8
            	    {
            	    pushFollow(FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_91126);
            	    ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_8_in_priority_91130);
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
    // ./scenariotestTemp/generated2/XPath.g:408:1: xpath_expression returns [Object ret2] : ret= priority_9 ;
    public final Object xpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:409:3: (ret= priority_9 )
            // ./scenariotestTemp/generated2/XPath.g:410:3: ret= priority_9
            {
            pushFollow(FOLLOW_priority_9_in_xpath_expression1168);
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
    // ./scenariotestTemp/generated2/XPath.g:417:1: xpath_variableexp returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object xpath_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","VariableExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:422:3: ( ( DOLLAR (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/XPath.g:423:3: ( DOLLAR (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:423:3: ( DOLLAR (temp= identifier ) )
            // ./scenariotestTemp/generated2/XPath.g:423:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_xpath_variableexp1198); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:423:62: (temp= identifier )
            // ./scenariotestTemp/generated2/XPath.g:423:64: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_xpath_variableexp1206);
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


    // $ANTLR start "xpath_pathexpression"
    // ./scenariotestTemp/generated2/XPath.g:431:1: xpath_pathexpression returns [Object ret2] : ( ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) ) ) ;
    public final Object xpath_pathexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:436:3: ( ( ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) ) ) )
            // ./scenariotestTemp/generated2/XPath.g:437:3: ( ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:437:3: ( ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) ) )
            // ./scenariotestTemp/generated2/XPath.g:437:4: ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:437:22: ( ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? ) | ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==SLASH) ) {
                alt13=1;
            }
            else if ( (LA13_0==EOF||LA13_0==NAME||LA13_0==STAR||(LA13_0>=POINT && LA13_0<=POINTPOINT)||LA13_0==AROBAS||(LA13_0>=41 && LA13_0<=55)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:437:23: ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:437:39: ( SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )? )
                    // ./scenariotestTemp/generated2/XPath.g:437:40: SLASH (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SLASH,FOLLOW_SLASH_in_xpath_pathexpression1256); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPath.g:437:97: (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )?
                    int alt11=2;
                    alt11 = dfa11.predict(input);
                    switch (alt11) {
                        case 1 :
                            // ./scenariotestTemp/generated2/XPath.g:437:99: temp= xpath_step ( ( SLASH ) temp= xpath_step )*
                            {
                            pushFollow(FOLLOW_xpath_step_in_xpath_pathexpression1264);
                            temp=xpath_step();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "steps", temp);
                            }
                            // ./scenariotestTemp/generated2/XPath.g:437:150: ( ( SLASH ) temp= xpath_step )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==SLASH) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/XPath.g:437:151: ( SLASH ) temp= xpath_step
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/XPath.g:437:168: ( SLASH )
                            	    // ./scenariotestTemp/generated2/XPath.g:437:169: SLASH
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,SLASH,FOLLOW_SLASH_in_xpath_pathexpression1273); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_xpath_step_in_xpath_pathexpression1281);
                            	    temp=xpath_step();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "steps", temp);
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

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAbsolute", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:437:374: ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:437:390: ( (temp= xpath_step ( ( SLASH ) temp= xpath_step )* ) )
                    // ./scenariotestTemp/generated2/XPath.g:437:391: (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPath.g:437:408: (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )
                    // ./scenariotestTemp/generated2/XPath.g:437:410: temp= xpath_step ( ( SLASH ) temp= xpath_step )*
                    {
                    pushFollow(FOLLOW_xpath_step_in_xpath_pathexpression1306);
                    temp=xpath_step();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "steps", temp);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:437:461: ( ( SLASH ) temp= xpath_step )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==SLASH) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/XPath.g:437:462: ( SLASH ) temp= xpath_step
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/XPath.g:437:479: ( SLASH )
                    	    // ./scenariotestTemp/generated2/XPath.g:437:480: SLASH
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,SLASH,FOLLOW_SLASH_in_xpath_pathexpression1315); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_xpath_step_in_xpath_pathexpression1323);
                    	    temp=xpath_step();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "steps", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAbsolute", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "xpath_pathexpression"


    // $ANTLR start "xpath_step"
    // ./scenariotestTemp/generated2/XPath.g:446:1: xpath_step returns [Object ret2] : ( ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) ) (temp= xpath_predicate (temp= xpath_predicate )* )? ) ;
    public final Object xpath_step() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","Step");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:451:3: ( ( ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) ) (temp= xpath_predicate (temp= xpath_predicate )* )? ) )
            // ./scenariotestTemp/generated2/XPath.g:452:3: ( ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) ) (temp= xpath_predicate (temp= xpath_predicate )* )? )
            {
            // ./scenariotestTemp/generated2/XPath.g:452:3: ( ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) ) (temp= xpath_predicate (temp= xpath_predicate )* )? )
            // ./scenariotestTemp/generated2/XPath.g:452:4: ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) ) (temp= xpath_predicate (temp= xpath_predicate )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:452:21: ( ( (temp= xpath_axis ) (temp= xpath_nodetest ) ) | ( POINT ) | ( POINTPOINT ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case EOF:
            case NAME:
            case STAR:
            case AROBAS:
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
            case 53:
            case 54:
            case 55:
                {
                alt14=1;
                }
                break;
            case POINT:
                {
                alt14=2;
                }
                break;
            case POINTPOINT:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:452:22: ( (temp= xpath_axis ) (temp= xpath_nodetest ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:452:38: ( (temp= xpath_axis ) (temp= xpath_nodetest ) )
                    // ./scenariotestTemp/generated2/XPath.g:452:39: (temp= xpath_axis ) (temp= xpath_nodetest )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPath.g:452:56: (temp= xpath_axis )
                    // ./scenariotestTemp/generated2/XPath.g:452:58: temp= xpath_axis
                    {
                    pushFollow(FOLLOW_xpath_axis_in_xpath_step1385);
                    temp=xpath_axis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "axis", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/XPath.g:452:141: (temp= xpath_nodetest )
                    // ./scenariotestTemp/generated2/XPath.g:452:143: temp= xpath_nodetest
                    {
                    pushFollow(FOLLOW_xpath_nodetest_in_xpath_step1395);
                    temp=xpath_nodetest();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "nodeTest", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:453:4: ( POINT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:453:20: ( POINT )
                    // ./scenariotestTemp/generated2/XPath.g:453:21: POINT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,POINT,FOLLOW_POINT_in_xpath_step1412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:454:4: ( POINTPOINT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:454:20: ( POINTPOINT )
                    // ./scenariotestTemp/generated2/XPath.g:454:21: POINTPOINT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,POINTPOINT,FOLLOW_POINTPOINT_in_xpath_step1427); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:454:115: (temp= xpath_predicate (temp= xpath_predicate )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LSQUARE) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:454:117: temp= xpath_predicate (temp= xpath_predicate )*
                    {
                    pushFollow(FOLLOW_xpath_predicate_in_xpath_step1440);
                    temp=xpath_predicate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "predicates", temp);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:454:178: (temp= xpath_predicate )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==LSQUARE) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/XPath.g:454:180: temp= xpath_predicate
                    	    {
                    	    pushFollow(FOLLOW_xpath_predicate_in_xpath_step1448);
                    	    temp=xpath_predicate();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "predicates", temp);
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
    // $ANTLR end "xpath_step"


    // $ANTLR start "xpath_predicate"
    // ./scenariotestTemp/generated2/XPath.g:462:1: xpath_predicate returns [Object ret2] : ( LSQUARE (temp= xpath_expression ) RSQUARE ) ;
    public final Object xpath_predicate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","Predicate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:467:3: ( ( LSQUARE (temp= xpath_expression ) RSQUARE ) )
            // ./scenariotestTemp/generated2/XPath.g:468:3: ( LSQUARE (temp= xpath_expression ) RSQUARE )
            {
            // ./scenariotestTemp/generated2/XPath.g:468:3: ( LSQUARE (temp= xpath_expression ) RSQUARE )
            // ./scenariotestTemp/generated2/XPath.g:468:4: LSQUARE (temp= xpath_expression ) RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_xpath_predicate1497); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:468:63: (temp= xpath_expression )
            // ./scenariotestTemp/generated2/XPath.g:468:65: temp= xpath_expression
            {
            pushFollow(FOLLOW_xpath_expression_in_xpath_predicate1505);
            temp=xpath_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "expression", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_xpath_predicate1512); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_predicate"


    // $ANTLR start "xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr"
    // ./scenariotestTemp/generated2/XPath.g:476:1: xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","OperatorCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:481:3: ()
            // ./scenariotestTemp/generated2/XPath.g:482:3: 
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


    // $ANTLR start "xpath_functioncallexp"
    // ./scenariotestTemp/generated2/XPath.g:492:1: xpath_functioncallexp returns [Object ret2] : ( (temp= identifier ) LPAREN (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )? RPAREN ) ;
    public final Object xpath_functioncallexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","FunctionCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:497:3: ( ( (temp= identifier ) LPAREN (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )? RPAREN ) )
            // ./scenariotestTemp/generated2/XPath.g:498:3: ( (temp= identifier ) LPAREN (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )? RPAREN )
            {
            // ./scenariotestTemp/generated2/XPath.g:498:3: ( (temp= identifier ) LPAREN (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )? RPAREN )
            // ./scenariotestTemp/generated2/XPath.g:498:4: (temp= identifier ) LPAREN (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:498:21: (temp= identifier )
            // ./scenariotestTemp/generated2/XPath.g:498:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_xpath_functioncallexp1585);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_xpath_functioncallexp1592); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:498:147: (temp= xpath_expression ( ( ',' ) temp= xpath_expression )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=NAME && LA18_0<=INT)||LA18_0==LPAREN||(LA18_0>=MINUS && LA18_0<=STAR)||(LA18_0>=DOLLAR && LA18_0<=POINTPOINT)||LA18_0==AROBAS||(LA18_0>=41 && LA18_0<=55)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:498:149: temp= xpath_expression ( ( ',' ) temp= xpath_expression )*
                    {
                    pushFollow(FOLLOW_xpath_expression_in_xpath_functioncallexp1600);
                    temp=xpath_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:498:210: ( ( ',' ) temp= xpath_expression )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==40) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/XPath.g:498:211: ( ',' ) temp= xpath_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/XPath.g:498:228: ( ',' )
                    	    // ./scenariotestTemp/generated2/XPath.g:498:229: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,40,FOLLOW_40_in_xpath_functioncallexp1608); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_xpath_expression_in_xpath_functioncallexp1615);
                    	    temp=xpath_expression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
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

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_xpath_functioncallexp1627); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_functioncallexp"


    // $ANTLR start "xpath_literalexp"
    // ./scenariotestTemp/generated2/XPath.g:506:1: xpath_literalexp returns [Object ret2] : (ret= xpath_integerexp | ret= xpath_stringexp ) ;
    public final Object xpath_literalexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:507:3: ( (ret= xpath_integerexp | ret= xpath_stringexp ) )
            // ./scenariotestTemp/generated2/XPath.g:508:3: (ret= xpath_integerexp | ret= xpath_stringexp )
            {
            // ./scenariotestTemp/generated2/XPath.g:508:3: (ret= xpath_integerexp | ret= xpath_stringexp )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==INT) ) {
                alt19=1;
            }
            else if ( (LA19_0==STRING) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:508:4: ret= xpath_integerexp
                    {
                    pushFollow(FOLLOW_xpath_integerexp_in_xpath_literalexp1665);
                    ret=xpath_integerexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:509:5: ret= xpath_stringexp
                    {
                    pushFollow(FOLLOW_xpath_stringexp_in_xpath_literalexp1673);
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
    // ./scenariotestTemp/generated2/XPath.g:516:1: xpath_integerexp returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object xpath_integerexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","IntegerExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:521:3: ( ( (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/XPath.g:522:3: ( (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:522:3: ( (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/XPath.g:522:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:522:21: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/XPath.g:522:23: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_xpath_integerexp1707);
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
    // ./scenariotestTemp/generated2/XPath.g:530:1: xpath_stringexp returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object xpath_stringexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","StringExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:535:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/XPath.g:536:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:536:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/XPath.g:536:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:536:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/XPath.g:536:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_xpath_stringexp1754);
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


    // $ANTLR start "xpath_nodetest"
    // ./scenariotestTemp/generated2/XPath.g:544:1: xpath_nodetest returns [Object ret2] : (ret= xpath_nametest | ret= xpath_wildcardtest | ret= xpath_isnodetest | ret= xpath_istexttest ) ;
    public final Object xpath_nodetest() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:545:3: ( (ret= xpath_nametest | ret= xpath_wildcardtest | ret= xpath_isnodetest | ret= xpath_istexttest ) )
            // ./scenariotestTemp/generated2/XPath.g:546:3: (ret= xpath_nametest | ret= xpath_wildcardtest | ret= xpath_isnodetest | ret= xpath_istexttest )
            {
            // ./scenariotestTemp/generated2/XPath.g:546:3: (ret= xpath_nametest | ret= xpath_wildcardtest | ret= xpath_isnodetest | ret= xpath_istexttest )
            int alt20=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt20=1;
                }
                break;
            case STAR:
                {
                alt20=2;
                }
                break;
            case 41:
                {
                alt20=3;
                }
                break;
            case 42:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:546:4: ret= xpath_nametest
                    {
                    pushFollow(FOLLOW_xpath_nametest_in_xpath_nodetest1794);
                    ret=xpath_nametest();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:547:5: ret= xpath_wildcardtest
                    {
                    pushFollow(FOLLOW_xpath_wildcardtest_in_xpath_nodetest1802);
                    ret=xpath_wildcardtest();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:548:5: ret= xpath_isnodetest
                    {
                    pushFollow(FOLLOW_xpath_isnodetest_in_xpath_nodetest1810);
                    ret=xpath_isnodetest();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPath.g:549:5: ret= xpath_istexttest
                    {
                    pushFollow(FOLLOW_xpath_istexttest_in_xpath_nodetest1818);
                    ret=xpath_istexttest();

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
    // $ANTLR end "xpath_nodetest"


    // $ANTLR start "xpath_nametest"
    // ./scenariotestTemp/generated2/XPath.g:556:1: xpath_nametest returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object xpath_nametest() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("XPath","NameTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:561:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/XPath.g:562:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:562:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/XPath.g:562:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:562:21: (temp= identifier )
            // ./scenariotestTemp/generated2/XPath.g:562:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_xpath_nametest1852);
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
    // $ANTLR end "xpath_nametest"


    // $ANTLR start "xpath_wildcardtest"
    // ./scenariotestTemp/generated2/XPath.g:570:1: xpath_wildcardtest returns [Object ret2] : ( STAR ) ;
    public final Object xpath_wildcardtest() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","WildCardTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:575:3: ( ( STAR ) )
            // ./scenariotestTemp/generated2/XPath.g:576:3: ( STAR )
            {
            // ./scenariotestTemp/generated2/XPath.g:576:3: ( STAR )
            // ./scenariotestTemp/generated2/XPath.g:576:4: STAR
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,STAR,FOLLOW_STAR_in_xpath_wildcardtest1896); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_wildcardtest"


    // $ANTLR start "xpath_isnodetest"
    // ./scenariotestTemp/generated2/XPath.g:584:1: xpath_isnodetest returns [Object ret2] : ( 'node' LPAREN RPAREN ) ;
    public final Object xpath_isnodetest() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","IsNodeTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:589:3: ( ( 'node' LPAREN RPAREN ) )
            // ./scenariotestTemp/generated2/XPath.g:590:3: ( 'node' LPAREN RPAREN )
            {
            // ./scenariotestTemp/generated2/XPath.g:590:3: ( 'node' LPAREN RPAREN )
            // ./scenariotestTemp/generated2/XPath.g:590:4: 'node' LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,41,FOLLOW_41_in_xpath_isnodetest1937); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_xpath_isnodetest1941); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_xpath_isnodetest1946); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_isnodetest"


    // $ANTLR start "xpath_istexttest"
    // ./scenariotestTemp/generated2/XPath.g:598:1: xpath_istexttest returns [Object ret2] : ( 'text' LPAREN RPAREN ) ;
    public final Object xpath_istexttest() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","IsTextTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:603:3: ( ( 'text' LPAREN RPAREN ) )
            // ./scenariotestTemp/generated2/XPath.g:604:3: ( 'text' LPAREN RPAREN )
            {
            // ./scenariotestTemp/generated2/XPath.g:604:3: ( 'text' LPAREN RPAREN )
            // ./scenariotestTemp/generated2/XPath.g:604:4: 'text' LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,42,FOLLOW_42_in_xpath_istexttest1987); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_xpath_istexttest1991); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_xpath_istexttest1996); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_istexttest"


    // $ANTLR start "xpath_axis"
    // ./scenariotestTemp/generated2/XPath.g:612:1: xpath_axis returns [Object ret2] : (ret= xpath_ancestoraxis | ret= xpath_ancestororselfaxis | ret= xpath_attributeaxis | ret= xpath_childaxis | ret= xpath_descendantaxis | ret= xpath_descendantorselfaxis | ret= xpath_followingaxis | ret= xpath_followingsiblingaxis | ret= xpath_namespaceaxis | ret= xpath_parentaxis | ret= xpath_precedingaxis | ret= xpath_precedingsiblingaxis | ret= xpath_selfaxis ) ;
    public final Object xpath_axis() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/XPath.g:613:3: ( (ret= xpath_ancestoraxis | ret= xpath_ancestororselfaxis | ret= xpath_attributeaxis | ret= xpath_childaxis | ret= xpath_descendantaxis | ret= xpath_descendantorselfaxis | ret= xpath_followingaxis | ret= xpath_followingsiblingaxis | ret= xpath_namespaceaxis | ret= xpath_parentaxis | ret= xpath_precedingaxis | ret= xpath_precedingsiblingaxis | ret= xpath_selfaxis ) )
            // ./scenariotestTemp/generated2/XPath.g:614:3: (ret= xpath_ancestoraxis | ret= xpath_ancestororselfaxis | ret= xpath_attributeaxis | ret= xpath_childaxis | ret= xpath_descendantaxis | ret= xpath_descendantorselfaxis | ret= xpath_followingaxis | ret= xpath_followingsiblingaxis | ret= xpath_namespaceaxis | ret= xpath_parentaxis | ret= xpath_precedingaxis | ret= xpath_precedingsiblingaxis | ret= xpath_selfaxis )
            {
            // ./scenariotestTemp/generated2/XPath.g:614:3: (ret= xpath_ancestoraxis | ret= xpath_ancestororselfaxis | ret= xpath_attributeaxis | ret= xpath_childaxis | ret= xpath_descendantaxis | ret= xpath_descendantorselfaxis | ret= xpath_followingaxis | ret= xpath_followingsiblingaxis | ret= xpath_namespaceaxis | ret= xpath_parentaxis | ret= xpath_precedingaxis | ret= xpath_precedingsiblingaxis | ret= xpath_selfaxis )
            int alt21=13;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt21=1;
                }
                break;
            case 44:
                {
                alt21=2;
                }
                break;
            case AROBAS:
            case 45:
                {
                alt21=3;
                }
                break;
            case EOF:
            case NAME:
            case STAR:
            case 41:
            case 42:
            case 46:
                {
                alt21=4;
                }
                break;
            case 47:
                {
                alt21=5;
                }
                break;
            case 48:
                {
                alt21=6;
                }
                break;
            case 49:
                {
                alt21=7;
                }
                break;
            case 50:
                {
                alt21=8;
                }
                break;
            case 51:
                {
                alt21=9;
                }
                break;
            case 52:
                {
                alt21=10;
                }
                break;
            case 53:
                {
                alt21=11;
                }
                break;
            case 54:
                {
                alt21=12;
                }
                break;
            case 55:
                {
                alt21=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:614:4: ret= xpath_ancestoraxis
                    {
                    pushFollow(FOLLOW_xpath_ancestoraxis_in_xpath_axis2034);
                    ret=xpath_ancestoraxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:615:5: ret= xpath_ancestororselfaxis
                    {
                    pushFollow(FOLLOW_xpath_ancestororselfaxis_in_xpath_axis2042);
                    ret=xpath_ancestororselfaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:616:5: ret= xpath_attributeaxis
                    {
                    pushFollow(FOLLOW_xpath_attributeaxis_in_xpath_axis2050);
                    ret=xpath_attributeaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPath.g:617:5: ret= xpath_childaxis
                    {
                    pushFollow(FOLLOW_xpath_childaxis_in_xpath_axis2058);
                    ret=xpath_childaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/XPath.g:618:5: ret= xpath_descendantaxis
                    {
                    pushFollow(FOLLOW_xpath_descendantaxis_in_xpath_axis2066);
                    ret=xpath_descendantaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/XPath.g:619:5: ret= xpath_descendantorselfaxis
                    {
                    pushFollow(FOLLOW_xpath_descendantorselfaxis_in_xpath_axis2074);
                    ret=xpath_descendantorselfaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/XPath.g:620:5: ret= xpath_followingaxis
                    {
                    pushFollow(FOLLOW_xpath_followingaxis_in_xpath_axis2082);
                    ret=xpath_followingaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/XPath.g:621:5: ret= xpath_followingsiblingaxis
                    {
                    pushFollow(FOLLOW_xpath_followingsiblingaxis_in_xpath_axis2090);
                    ret=xpath_followingsiblingaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/XPath.g:622:5: ret= xpath_namespaceaxis
                    {
                    pushFollow(FOLLOW_xpath_namespaceaxis_in_xpath_axis2098);
                    ret=xpath_namespaceaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // ./scenariotestTemp/generated2/XPath.g:623:5: ret= xpath_parentaxis
                    {
                    pushFollow(FOLLOW_xpath_parentaxis_in_xpath_axis2106);
                    ret=xpath_parentaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // ./scenariotestTemp/generated2/XPath.g:624:5: ret= xpath_precedingaxis
                    {
                    pushFollow(FOLLOW_xpath_precedingaxis_in_xpath_axis2114);
                    ret=xpath_precedingaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // ./scenariotestTemp/generated2/XPath.g:625:5: ret= xpath_precedingsiblingaxis
                    {
                    pushFollow(FOLLOW_xpath_precedingsiblingaxis_in_xpath_axis2122);
                    ret=xpath_precedingsiblingaxis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // ./scenariotestTemp/generated2/XPath.g:626:5: ret= xpath_selfaxis
                    {
                    pushFollow(FOLLOW_xpath_selfaxis_in_xpath_axis2130);
                    ret=xpath_selfaxis();

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
    // $ANTLR end "xpath_axis"


    // $ANTLR start "xpath_ancestoraxis"
    // ./scenariotestTemp/generated2/XPath.g:633:1: xpath_ancestoraxis returns [Object ret2] : ( 'ancestor' COLONS ) ;
    public final Object xpath_ancestoraxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","AncestorAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:638:3: ( ( 'ancestor' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:639:3: ( 'ancestor' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:639:3: ( 'ancestor' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:639:4: 'ancestor' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,43,FOLLOW_43_in_xpath_ancestoraxis2160); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_ancestoraxis2164); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_ancestoraxis"


    // $ANTLR start "xpath_ancestororselfaxis"
    // ./scenariotestTemp/generated2/XPath.g:647:1: xpath_ancestororselfaxis returns [Object ret2] : ( 'ancestor-or-self' COLONS ) ;
    public final Object xpath_ancestororselfaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","AncestorOrSelfAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:652:3: ( ( 'ancestor-or-self' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:653:3: ( 'ancestor-or-self' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:653:3: ( 'ancestor-or-self' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:653:4: 'ancestor-or-self' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,44,FOLLOW_44_in_xpath_ancestororselfaxis2205); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_ancestororselfaxis2209); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_ancestororselfaxis"


    // $ANTLR start "xpath_attributeaxis"
    // ./scenariotestTemp/generated2/XPath.g:661:1: xpath_attributeaxis returns [Object ret2] : ( ( ( 'attribute' COLONS ) | ( AROBAS ) ) ) ;
    public final Object xpath_attributeaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","AttributeAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:666:3: ( ( ( ( 'attribute' COLONS ) | ( AROBAS ) ) ) )
            // ./scenariotestTemp/generated2/XPath.g:667:3: ( ( ( 'attribute' COLONS ) | ( AROBAS ) ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:667:3: ( ( ( 'attribute' COLONS ) | ( AROBAS ) ) )
            // ./scenariotestTemp/generated2/XPath.g:667:4: ( ( 'attribute' COLONS ) | ( AROBAS ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:667:21: ( ( 'attribute' COLONS ) | ( AROBAS ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==45) ) {
                alt22=1;
            }
            else if ( (LA22_0==AROBAS) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:667:22: ( 'attribute' COLONS )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:667:38: ( 'attribute' COLONS )
                    // ./scenariotestTemp/generated2/XPath.g:667:39: 'attribute' COLONS
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,45,FOLLOW_45_in_xpath_attributeaxis2255); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLONS,FOLLOW_COLONS_in_xpath_attributeaxis2259); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:668:4: ( AROBAS )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:668:20: ( AROBAS )
                    // ./scenariotestTemp/generated2/XPath.g:668:21: AROBAS
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,AROBAS,FOLLOW_AROBAS_in_xpath_attributeaxis2274); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "xpath_attributeaxis"


    // $ANTLR start "xpath_childaxis"
    // ./scenariotestTemp/generated2/XPath.g:676:1: xpath_childaxis returns [Object ret2] : ( ( ( 'child' COLONS ) | () ) ) ;
    public final Object xpath_childaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","ChildAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:681:3: ( ( ( ( 'child' COLONS ) | () ) ) )
            // ./scenariotestTemp/generated2/XPath.g:682:3: ( ( ( 'child' COLONS ) | () ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:682:3: ( ( ( 'child' COLONS ) | () ) )
            // ./scenariotestTemp/generated2/XPath.g:682:4: ( ( 'child' COLONS ) | () )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/XPath.g:682:21: ( ( 'child' COLONS ) | () )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==46) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||LA23_0==NAME||LA23_0==STAR||(LA23_0>=41 && LA23_0<=42)) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:682:22: ( 'child' COLONS )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:682:38: ( 'child' COLONS )
                    // ./scenariotestTemp/generated2/XPath.g:682:39: 'child' COLONS
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,46,FOLLOW_46_in_xpath_childaxis2325); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLONS,FOLLOW_COLONS_in_xpath_childaxis2329); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:683:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/XPath.g:683:20: ()
                    // ./scenariotestTemp/generated2/XPath.g:683:21: 
                    {
                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "xpath_childaxis"


    // $ANTLR start "xpath_descendantaxis"
    // ./scenariotestTemp/generated2/XPath.g:691:1: xpath_descendantaxis returns [Object ret2] : ( 'descendant' COLONS ) ;
    public final Object xpath_descendantaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","DescendantAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:696:3: ( ( 'descendant' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:697:3: ( 'descendant' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:697:3: ( 'descendant' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:697:4: 'descendant' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,47,FOLLOW_47_in_xpath_descendantaxis2385); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_descendantaxis2389); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_descendantaxis"


    // $ANTLR start "xpath_descendantorselfaxis"
    // ./scenariotestTemp/generated2/XPath.g:705:1: xpath_descendantorselfaxis returns [Object ret2] : ( 'descendant-or-self' COLONS ) ;
    public final Object xpath_descendantorselfaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","DescendantOrSelfAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:710:3: ( ( 'descendant-or-self' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:711:3: ( 'descendant-or-self' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:711:3: ( 'descendant-or-self' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:711:4: 'descendant-or-self' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_xpath_descendantorselfaxis2430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_descendantorselfaxis2434); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_descendantorselfaxis"


    // $ANTLR start "xpath_followingaxis"
    // ./scenariotestTemp/generated2/XPath.g:719:1: xpath_followingaxis returns [Object ret2] : ( 'following' COLONS ) ;
    public final Object xpath_followingaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","FollowingAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:724:3: ( ( 'following' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:725:3: ( 'following' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:725:3: ( 'following' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:725:4: 'following' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,49,FOLLOW_49_in_xpath_followingaxis2475); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_followingaxis2479); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_followingaxis"


    // $ANTLR start "xpath_followingsiblingaxis"
    // ./scenariotestTemp/generated2/XPath.g:733:1: xpath_followingsiblingaxis returns [Object ret2] : ( 'following-sibling' COLONS ) ;
    public final Object xpath_followingsiblingaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","FollowingSiblingAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:738:3: ( ( 'following-sibling' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:739:3: ( 'following-sibling' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:739:3: ( 'following-sibling' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:739:4: 'following-sibling' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,50,FOLLOW_50_in_xpath_followingsiblingaxis2520); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_followingsiblingaxis2524); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_followingsiblingaxis"


    // $ANTLR start "xpath_namespaceaxis"
    // ./scenariotestTemp/generated2/XPath.g:747:1: xpath_namespaceaxis returns [Object ret2] : ( 'namespace' COLONS ) ;
    public final Object xpath_namespaceaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","NamespaceAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:752:3: ( ( 'namespace' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:753:3: ( 'namespace' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:753:3: ( 'namespace' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:753:4: 'namespace' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,51,FOLLOW_51_in_xpath_namespaceaxis2565); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_namespaceaxis2569); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_namespaceaxis"


    // $ANTLR start "xpath_parentaxis"
    // ./scenariotestTemp/generated2/XPath.g:761:1: xpath_parentaxis returns [Object ret2] : ( 'parent' COLONS ) ;
    public final Object xpath_parentaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","ParentAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:766:3: ( ( 'parent' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:767:3: ( 'parent' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:767:3: ( 'parent' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:767:4: 'parent' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,52,FOLLOW_52_in_xpath_parentaxis2610); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_parentaxis2614); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_parentaxis"


    // $ANTLR start "xpath_precedingaxis"
    // ./scenariotestTemp/generated2/XPath.g:775:1: xpath_precedingaxis returns [Object ret2] : ( 'preceding' COLONS ) ;
    public final Object xpath_precedingaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","PrecedingAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:780:3: ( ( 'preceding' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:781:3: ( 'preceding' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:781:3: ( 'preceding' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:781:4: 'preceding' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,53,FOLLOW_53_in_xpath_precedingaxis2655); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_precedingaxis2659); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_precedingaxis"


    // $ANTLR start "xpath_precedingsiblingaxis"
    // ./scenariotestTemp/generated2/XPath.g:789:1: xpath_precedingsiblingaxis returns [Object ret2] : ( 'preceding-sibling' COLONS ) ;
    public final Object xpath_precedingsiblingaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","PrecedingSiblingAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:794:3: ( ( 'preceding-sibling' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:795:3: ( 'preceding-sibling' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:795:3: ( 'preceding-sibling' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:795:4: 'preceding-sibling' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,54,FOLLOW_54_in_xpath_precedingsiblingaxis2700); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_precedingsiblingaxis2704); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_precedingsiblingaxis"


    // $ANTLR start "xpath_selfaxis"
    // ./scenariotestTemp/generated2/XPath.g:803:1: xpath_selfaxis returns [Object ret2] : ( 'self' COLONS ) ;
    public final Object xpath_selfaxis() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("XPath","SelfAxis");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/XPath.g:808:3: ( ( 'self' COLONS ) )
            // ./scenariotestTemp/generated2/XPath.g:809:3: ( 'self' COLONS )
            {
            // ./scenariotestTemp/generated2/XPath.g:809:3: ( 'self' COLONS )
            // ./scenariotestTemp/generated2/XPath.g:809:4: 'self' COLONS
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,55,FOLLOW_55_in_xpath_selfaxis2745); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLONS,FOLLOW_COLONS_in_xpath_selfaxis2749); if (state.failed) return ret2;
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
    // $ANTLR end "xpath_selfaxis"

    // $ANTLR start synpred5_XPath
    public final void synpred5_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:291:23: ( ( PIPE ) () )
        // ./scenariotestTemp/generated2/XPath.g:291:24: ( PIPE ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:291:24: ( PIPE )
        // ./scenariotestTemp/generated2/XPath.g:291:25: PIPE
        {
        match(input,PIPE,FOLLOW_PIPE_in_synpred5_XPath376); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:291:30: ()
        // ./scenariotestTemp/generated2/XPath.g:291:31: 
        {
        }


        }
    }
    // $ANTLR end synpred5_XPath

    // $ANTLR start synpred8_XPath
    public final void synpred8_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:317:23: ( ( STAR ) () )
        // ./scenariotestTemp/generated2/XPath.g:317:24: ( STAR ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:317:24: ( STAR )
        // ./scenariotestTemp/generated2/XPath.g:317:25: STAR
        {
        match(input,STAR,FOLLOW_STAR_in_synpred8_XPath522); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:317:30: ()
        // ./scenariotestTemp/generated2/XPath.g:317:31: 
        {
        }


        }
    }
    // $ANTLR end synpred8_XPath

    // $ANTLR start synpred9_XPath
    public final void synpred9_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:320:3: ( ( 'div' ) () )
        // ./scenariotestTemp/generated2/XPath.g:320:4: ( 'div' ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:320:4: ( 'div' )
        // ./scenariotestTemp/generated2/XPath.g:320:5: 'div'
        {
        match(input,36,FOLLOW_36_in_synpred9_XPath555); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:320:11: ()
        // ./scenariotestTemp/generated2/XPath.g:320:12: 
        {
        }


        }
    }
    // $ANTLR end synpred9_XPath

    // $ANTLR start synpred10_XPath
    public final void synpred10_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:323:3: ( ( 'mod' ) () )
        // ./scenariotestTemp/generated2/XPath.g:323:4: ( 'mod' ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:323:4: ( 'mod' )
        // ./scenariotestTemp/generated2/XPath.g:323:5: 'mod'
        {
        match(input,37,FOLLOW_37_in_synpred10_XPath587); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:323:11: ()
        // ./scenariotestTemp/generated2/XPath.g:323:12: 
        {
        }


        }
    }
    // $ANTLR end synpred10_XPath

    // $ANTLR start synpred11_XPath
    public final void synpred11_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:335:23: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/XPath.g:335:24: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:335:24: ( PLUS )
        // ./scenariotestTemp/generated2/XPath.g:335:25: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred11_XPath658); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:335:30: ()
        // ./scenariotestTemp/generated2/XPath.g:335:31: 
        {
        }


        }
    }
    // $ANTLR end synpred11_XPath

    // $ANTLR start synpred12_XPath
    public final void synpred12_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:338:3: ( ( MINUS ) () )
        // ./scenariotestTemp/generated2/XPath.g:338:4: ( MINUS ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:338:4: ( MINUS )
        // ./scenariotestTemp/generated2/XPath.g:338:5: MINUS
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred12_XPath691); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:338:11: ()
        // ./scenariotestTemp/generated2/XPath.g:338:12: 
        {
        }


        }
    }
    // $ANTLR end synpred12_XPath

    // $ANTLR start synpred13_XPath
    public final void synpred13_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:350:23: ( ( LT ) () )
        // ./scenariotestTemp/generated2/XPath.g:350:24: ( LT ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:350:24: ( LT )
        // ./scenariotestTemp/generated2/XPath.g:350:25: LT
        {
        match(input,LT,FOLLOW_LT_in_synpred13_XPath763); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:350:28: ()
        // ./scenariotestTemp/generated2/XPath.g:350:29: 
        {
        }


        }
    }
    // $ANTLR end synpred13_XPath

    // $ANTLR start synpred14_XPath
    public final void synpred14_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:353:3: ( ( LE ) () )
        // ./scenariotestTemp/generated2/XPath.g:353:4: ( LE ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:353:4: ( LE )
        // ./scenariotestTemp/generated2/XPath.g:353:5: LE
        {
        match(input,LE,FOLLOW_LE_in_synpred14_XPath796); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:353:8: ()
        // ./scenariotestTemp/generated2/XPath.g:353:9: 
        {
        }


        }
    }
    // $ANTLR end synpred14_XPath

    // $ANTLR start synpred15_XPath
    public final void synpred15_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:356:3: ( ( GT ) () )
        // ./scenariotestTemp/generated2/XPath.g:356:4: ( GT ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:356:4: ( GT )
        // ./scenariotestTemp/generated2/XPath.g:356:5: GT
        {
        match(input,GT,FOLLOW_GT_in_synpred15_XPath829); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:356:8: ()
        // ./scenariotestTemp/generated2/XPath.g:356:9: 
        {
        }


        }
    }
    // $ANTLR end synpred15_XPath

    // $ANTLR start synpred16_XPath
    public final void synpred16_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:359:3: ( ( GE ) () )
        // ./scenariotestTemp/generated2/XPath.g:359:4: ( GE ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:359:4: ( GE )
        // ./scenariotestTemp/generated2/XPath.g:359:5: GE
        {
        match(input,GE,FOLLOW_GE_in_synpred16_XPath862); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:359:8: ()
        // ./scenariotestTemp/generated2/XPath.g:359:9: 
        {
        }


        }
    }
    // $ANTLR end synpred16_XPath

    // $ANTLR start synpred17_XPath
    public final void synpred17_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:371:23: ( ( EQ ) () )
        // ./scenariotestTemp/generated2/XPath.g:371:24: ( EQ ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:371:24: ( EQ )
        // ./scenariotestTemp/generated2/XPath.g:371:25: EQ
        {
        match(input,EQ,FOLLOW_EQ_in_synpred17_XPath934); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:371:28: ()
        // ./scenariotestTemp/generated2/XPath.g:371:29: 
        {
        }


        }
    }
    // $ANTLR end synpred17_XPath

    // $ANTLR start synpred18_XPath
    public final void synpred18_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:374:3: ( ( EXCLEQ ) () )
        // ./scenariotestTemp/generated2/XPath.g:374:4: ( EXCLEQ ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:374:4: ( EXCLEQ )
        // ./scenariotestTemp/generated2/XPath.g:374:5: EXCLEQ
        {
        match(input,EXCLEQ,FOLLOW_EXCLEQ_in_synpred18_XPath967); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:374:12: ()
        // ./scenariotestTemp/generated2/XPath.g:374:13: 
        {
        }


        }
    }
    // $ANTLR end synpred18_XPath

    // $ANTLR start synpred19_XPath
    public final void synpred19_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:386:23: ( ( 'and' ) () )
        // ./scenariotestTemp/generated2/XPath.g:386:24: ( 'and' ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:386:24: ( 'and' )
        // ./scenariotestTemp/generated2/XPath.g:386:25: 'and'
        {
        match(input,38,FOLLOW_38_in_synpred19_XPath1039); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:386:31: ()
        // ./scenariotestTemp/generated2/XPath.g:386:32: 
        {
        }


        }
    }
    // $ANTLR end synpred19_XPath

    // $ANTLR start synpred20_XPath
    public final void synpred20_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:398:23: ( ( 'or' ) () )
        // ./scenariotestTemp/generated2/XPath.g:398:24: ( 'or' ) ()
        {
        // ./scenariotestTemp/generated2/XPath.g:398:24: ( 'or' )
        // ./scenariotestTemp/generated2/XPath.g:398:25: 'or'
        {
        match(input,39,FOLLOW_39_in_synpred20_XPath1110); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/XPath.g:398:30: ()
        // ./scenariotestTemp/generated2/XPath.g:398:31: 
        {
        }


        }
    }
    // $ANTLR end synpred20_XPath

    // $ANTLR start synpred22_XPath
    public final void synpred22_XPath_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/XPath.g:437:99: (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )
        // ./scenariotestTemp/generated2/XPath.g:437:99: temp= xpath_step ( ( SLASH ) temp= xpath_step )*
        {
        pushFollow(FOLLOW_xpath_step_in_synpred22_XPath1264);
        temp=xpath_step();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // ./scenariotestTemp/generated2/XPath.g:437:150: ( ( SLASH ) temp= xpath_step )*
        loop24:
        do {
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==SLASH) ) {
                alt24=1;
            }


            switch (alt24) {
        	case 1 :
        	    // ./scenariotestTemp/generated2/XPath.g:437:151: ( SLASH ) temp= xpath_step
        	    {
        	    // ./scenariotestTemp/generated2/XPath.g:437:168: ( SLASH )
        	    // ./scenariotestTemp/generated2/XPath.g:437:169: SLASH
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl();
        	    }
        	    match(input,SLASH,FOLLOW_SLASH_in_synpred22_XPath1273); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_xpath_step_in_synpred22_XPath1281);
        	    temp=xpath_step();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop24;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred22_XPath

    // Delegated rules

    public final boolean synpred8_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_XPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\46\uffff";
    static final String DFA11_eofS =
        "\1\25\45\uffff";
    static final String DFA11_minS =
        "\1\4\6\uffff\1\0\36\uffff";
    static final String DFA11_maxS =
        "\1\67\6\uffff\1\0\36\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\23\uffff\1\2\20\uffff";
    static final String DFA11_specialS =
        "\7\uffff\1\0\36\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\4\uffff\3\25\1\7\7\25\2\uffff\2\1\1\uffff\1\25\1\uffff"+
            "\1\1\10\uffff\5\25\17\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "437:97: (temp= xpath_step ( ( SLASH ) temp= xpath_step )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_XPath()) ) {s = 1;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_expression_in_main190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_functioncallexp_in_primary_xpath_expression221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_literalexp_in_primary_xpath_expression229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_pathexpression_in_primary_xpath_expression237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_variableexp_in_primary_xpath_expression245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_xpath_expression254 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_expression_in_primary_xpath_expression260 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_primary_xpath_expression264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_xpath_expression_in_priority_0299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_2372 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_PIPE_in_priority_2385 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_2393 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_1_in_priority_2397 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_MINUS_in_priority_3451 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_3459 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_2_in_priority_3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_2_in_priority_3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_3_in_priority_4518 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_STAR_in_priority_4531 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4539 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_3_in_priority_4543 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_36_in_priority_4564 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4571 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_3_in_priority_4575 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_37_in_priority_4596 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_4603 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_3_in_priority_4607 = new BitSet(new long[]{0x0000003000001002L});
    public static final BitSet FOLLOW_priority_4_in_priority_5654 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_PLUS_in_priority_5667 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5675 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_4_in_priority_5679 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_MINUS_in_priority_5700 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_5708 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_4_in_priority_5712 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_priority_5_in_priority_6759 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LT_in_priority_6772 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6780 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_5_in_priority_6784 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LE_in_priority_6805 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6813 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_5_in_priority_6817 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GT_in_priority_6838 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6846 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_5_in_priority_6850 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GE_in_priority_6871 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_6879 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_5_in_priority_6883 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_priority_6_in_priority_7930 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EQ_in_priority_7943 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7951 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_6_in_priority_7955 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_EXCLEQ_in_priority_7976 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_7984 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_6_in_priority_7988 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_priority_7_in_priority_81035 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_priority_81048 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_81055 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_7_in_priority_81059 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_priority_8_in_priority_91106 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_priority_91119 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr_in_priority_91126 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_priority_8_in_priority_91130 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_priority_9_in_xpath_expression1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_xpath_variableexp1198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_xpath_variableexp1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_xpath_pathexpression1256 = new BitSet(new long[]{0x00FFF80008E00002L});
    public static final BitSet FOLLOW_xpath_step_in_xpath_pathexpression1264 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_SLASH_in_xpath_pathexpression1273 = new BitSet(new long[]{0x00FFF80008E00000L});
    public static final BitSet FOLLOW_xpath_step_in_xpath_pathexpression1281 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_xpath_step_in_xpath_pathexpression1306 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_SLASH_in_xpath_pathexpression1315 = new BitSet(new long[]{0x00FFF80008E00000L});
    public static final BitSet FOLLOW_xpath_step_in_xpath_pathexpression1323 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_xpath_axis_in_xpath_step1385 = new BitSet(new long[]{0x0000060000001010L});
    public static final BitSet FOLLOW_xpath_nodetest_in_xpath_step1395 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_POINT_in_xpath_step1412 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_POINTPOINT_in_xpath_step1427 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_xpath_predicate_in_xpath_step1440 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_xpath_predicate_in_xpath_step1448 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_LSQUARE_in_xpath_predicate1497 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_expression_in_xpath_predicate1505 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RSQUARE_in_xpath_predicate1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_xpath_functioncallexp1585 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_xpath_functioncallexp1592 = new BitSet(new long[]{0x00FFF80008F00B70L});
    public static final BitSet FOLLOW_xpath_expression_in_xpath_functioncallexp1600 = new BitSet(new long[]{0x0000010000000200L});
    public static final BitSet FOLLOW_40_in_xpath_functioncallexp1608 = new BitSet(new long[]{0x00FFF80008F00970L});
    public static final BitSet FOLLOW_xpath_expression_in_xpath_functioncallexp1615 = new BitSet(new long[]{0x0000010000000200L});
    public static final BitSet FOLLOW_RPAREN_in_xpath_functioncallexp1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_integerexp_in_xpath_literalexp1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_stringexp_in_xpath_literalexp1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_xpath_integerexp1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_xpath_stringexp1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_nametest_in_xpath_nodetest1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_wildcardtest_in_xpath_nodetest1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_isnodetest_in_xpath_nodetest1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_istexttest_in_xpath_nodetest1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_xpath_nametest1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_xpath_wildcardtest1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_xpath_isnodetest1937 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_xpath_isnodetest1941 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_xpath_isnodetest1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_xpath_istexttest1987 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_xpath_istexttest1991 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_xpath_istexttest1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_ancestoraxis_in_xpath_axis2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_ancestororselfaxis_in_xpath_axis2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_attributeaxis_in_xpath_axis2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_childaxis_in_xpath_axis2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_descendantaxis_in_xpath_axis2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_descendantorselfaxis_in_xpath_axis2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_followingaxis_in_xpath_axis2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_followingsiblingaxis_in_xpath_axis2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_namespaceaxis_in_xpath_axis2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_parentaxis_in_xpath_axis2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_precedingaxis_in_xpath_axis2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_precedingsiblingaxis_in_xpath_axis2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_selfaxis_in_xpath_axis2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_xpath_ancestoraxis2160 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_ancestoraxis2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_xpath_ancestororselfaxis2205 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_ancestororselfaxis2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_xpath_attributeaxis2255 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_attributeaxis2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AROBAS_in_xpath_attributeaxis2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_xpath_childaxis2325 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_childaxis2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_xpath_descendantaxis2385 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_descendantaxis2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_xpath_descendantorselfaxis2430 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_descendantorselfaxis2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_xpath_followingaxis2475 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_followingaxis2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_xpath_followingsiblingaxis2520 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_followingsiblingaxis2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_xpath_namespaceaxis2565 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_namespaceaxis2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_xpath_parentaxis2610 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_parentaxis2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_xpath_precedingaxis2655 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_precedingaxis2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_xpath_precedingsiblingaxis2700 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_precedingsiblingaxis2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_xpath_selfaxis2745 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_COLONS_in_xpath_selfaxis2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred5_XPath376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred8_XPath522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_synpred9_XPath555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred10_XPath587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred11_XPath658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred12_XPath691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_synpred13_XPath763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_synpred14_XPath796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_synpred15_XPath829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_synpred16_XPath862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_synpred17_XPath934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCLEQ_in_synpred18_XPath967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred19_XPath1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred20_XPath1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xpath_step_in_synpred22_XPath1264 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_SLASH_in_synpred22_XPath1273 = new BitSet(new long[]{0x00FFF80008E00000L});
    public static final BitSet FOLLOW_xpath_step_in_synpred22_XPath1281 = new BitSet(new long[]{0x0000000000200002L});

}