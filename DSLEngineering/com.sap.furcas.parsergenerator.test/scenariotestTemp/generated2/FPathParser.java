// $ANTLR 3.1.1 ./scenariotestTemp/generated2/FPath.g 2010-11-04 23:27:13

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
public class FPathParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "FLOAT", "LPAREN", "RPAREN", "SLASH", "MINUS", "STAR", "PLUS", "LT", "GT", "LE", "GE", "EQEQ", "NE", "POINT", "COMA", "COLONCOLON", "LSQUARE", "RSQUARE", "COMMENT", "EXCL", "LCURLY", "RCURLY", "SEMI", "COLON", "PIPE", "SHARP", "QMARK", "RARROW", "EQ", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'not'", "'div'", "'and'", "'or'", "'$'", "'component'", "'internal-interface'", "'interface'", "'attribute'", "'binding'", "'child'", "'parent'", "'descendant'", "'ancestor'", "'sibling'", "'descendant-or-self'", "'ancestor-or-self'", "'sibling-or-self'"
    };
    public static final int LT=13;
    public static final int STAR=11;
    public static final int LSQUARE=22;
    public static final int POINT=19;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int FLOAT=6;
    public static final int EXCL=25;
    public static final int EOF=-1;
    public static final int LPAREN=7;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RPAREN=8;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=9;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int PIPE=30;
    public static final int PLUS=12;
    public static final int DIGIT=38;
    public static final int NL=36;
    public static final int EQ=34;
    public static final int COMMENT=24;
    public static final int T__50=50;
    public static final int EQEQ=17;
    public static final int NE=18;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int GE=16;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int SHARP=31;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=33;
    public static final int LCURLY=26;
    public static final int MINUS=10;
    public static final int RSQUARE=23;
    public static final int COMA=20;
    public static final int SEMI=28;
    public static final int ALPHA=39;
    public static final int COLON=29;
    public static final int COLONCOLON=21;
    public static final int WS=37;
    public static final int SNAME=40;
    public static final int RCURLY=27;
    public static final int GT=14;
    public static final int QMARK=32;
    public static final int LE=15;
    public static final int STRING=5;

    // delegates
    // delegators


        public FPathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FPathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return FPathParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/FPath.g"; }


       private static final String syntaxUUID = "FPath";
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
    // ./scenariotestTemp/generated2/FPath.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/FPath.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/FPath.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/FPath.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/FPath.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/FPath.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/FPath.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/FPath.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/FPath.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/FPath.g:219:4: ast= STRING
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


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/FPath.g:227:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/FPath.g:228:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/FPath.g:229:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/FPath.g:229:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/FPath.g:229:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol131); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/FPath.g:237:1: main returns [Object ret2] : ( (ret= fpath_expression ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:238:3: ( ( (ret= fpath_expression ) EOF ) )
            // ./scenariotestTemp/generated2/FPath.g:239:3: ( (ret= fpath_expression ) EOF )
            {
            // ./scenariotestTemp/generated2/FPath.g:239:3: ( (ret= fpath_expression ) EOF )
            // ./scenariotestTemp/generated2/FPath.g:239:4: (ret= fpath_expression ) EOF
            {
            // ./scenariotestTemp/generated2/FPath.g:239:4: (ret= fpath_expression )
            // ./scenariotestTemp/generated2/FPath.g:239:5: ret= fpath_expression
            {
            pushFollow(FOLLOW_fpath_expression_in_main159);
            ret=fpath_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main162); if (state.failed) return ret2;

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


    // $ANTLR start "primary_fpath_expression"
    // ./scenariotestTemp/generated2/FPath.g:246:1: primary_fpath_expression returns [Object ret2] : (ret= fpath_contextexp | ret= fpath_functioncallexp | ret= fpath_numberexp | ret= fpath_stringexp | ret= fpath_variableexp | ( LPAREN ret= fpath_expression RPAREN ) ) ;
    public final Object primary_fpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:247:3: ( (ret= fpath_contextexp | ret= fpath_functioncallexp | ret= fpath_numberexp | ret= fpath_stringexp | ret= fpath_variableexp | ( LPAREN ret= fpath_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/FPath.g:248:3: (ret= fpath_contextexp | ret= fpath_functioncallexp | ret= fpath_numberexp | ret= fpath_stringexp | ret= fpath_variableexp | ( LPAREN ret= fpath_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:248:3: (ret= fpath_contextexp | ret= fpath_functioncallexp | ret= fpath_numberexp | ret= fpath_stringexp | ret= fpath_variableexp | ( LPAREN ret= fpath_expression RPAREN ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case POINT:
                {
                alt1=1;
                }
                break;
            case NAME:
                {
                alt1=2;
                }
                break;
            case FLOAT:
                {
                alt1=3;
                }
                break;
            case STRING:
                {
                alt1=4;
                }
                break;
            case 46:
                {
                alt1=5;
                }
                break;
            case LPAREN:
                {
                alt1=6;
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
                    // ./scenariotestTemp/generated2/FPath.g:248:4: ret= fpath_contextexp
                    {
                    pushFollow(FOLLOW_fpath_contextexp_in_primary_fpath_expression190);
                    ret=fpath_contextexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:249:5: ret= fpath_functioncallexp
                    {
                    pushFollow(FOLLOW_fpath_functioncallexp_in_primary_fpath_expression198);
                    ret=fpath_functioncallexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/FPath.g:250:5: ret= fpath_numberexp
                    {
                    pushFollow(FOLLOW_fpath_numberexp_in_primary_fpath_expression206);
                    ret=fpath_numberexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/FPath.g:251:5: ret= fpath_stringexp
                    {
                    pushFollow(FOLLOW_fpath_stringexp_in_primary_fpath_expression214);
                    ret=fpath_stringexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/FPath.g:252:5: ret= fpath_variableexp
                    {
                    pushFollow(FOLLOW_fpath_variableexp_in_primary_fpath_expression222);
                    ret=fpath_variableexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/FPath.g:253:5: ( LPAREN ret= fpath_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:253:5: ( LPAREN ret= fpath_expression RPAREN )
                    // ./scenariotestTemp/generated2/FPath.g:253:6: LPAREN ret= fpath_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_fpath_expression231); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_fpath_expression_in_primary_fpath_expression237);
                    ret=fpath_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_fpath_expression241); if (state.failed) return ret2;
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
    // $ANTLR end "primary_fpath_expression"


    // $ANTLR start "priority_0"
    // ./scenariotestTemp/generated2/FPath.g:260:1: priority_0 returns [Object ret2] : ( (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:261:3: ( ( (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:262:4: ( (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:262:4: ( (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:262:6: (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:262:6: (ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )* )
            // ./scenariotestTemp/generated2/FPath.g:262:8: ret= primary_fpath_expression ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_fpath_expression_in_priority_0279);
            ret=primary_fpath_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/FPath.g:262:36: ( ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SLASH) && (synpred6_FPath())) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:262:37: ( ( SLASH ) () )=> ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:262:50: ( SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:262:51: SLASH ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,SLASH,FOLLOW_SLASH_in_priority_0292); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:262:134: ( (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] ) )
            	    // ./scenariotestTemp/generated2/FPath.g:262:135: (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:262:135: (ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken] )
            	    // ./scenariotestTemp/generated2/FPath.g:262:136: ret= fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_fpath_pathexp_FPath_PathExp_opSlash_in_priority_0300);
            	    ret=fpath_pathexp_FPath_PathExp_opSlash(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;

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
    // $ANTLR end "priority_0"


    // $ANTLR start "priority_1"
    // ./scenariotestTemp/generated2/FPath.g:270:1: priority_1 returns [Object ret2] : ( ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) ) | (ret= priority_0 ) ) ;
    public final Object priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:271:3: ( ( ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) ) | (ret= priority_0 ) ) )
            // ./scenariotestTemp/generated2/FPath.g:272:4: ( ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) ) | (ret= priority_0 ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:272:4: ( ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) ) | (ret= priority_0 ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==MINUS||LA4_0==42) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=NAME && LA4_0<=LPAREN)||LA4_0==POINT||LA4_0==46) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:272:5: ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:272:5: ( ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==42) && (synpred7_FPath())) {
                        alt3=1;
                    }
                    else if ( (LA3_0==MINUS) && (synpred8_FPath())) {
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
                            // ./scenariotestTemp/generated2/FPath.g:272:6: ( ( 'not' ) () )=> ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) )
                            {
                            // ./scenariotestTemp/generated2/FPath.g:272:19: ( 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) )
                            // ./scenariotestTemp/generated2/FPath.g:272:20: 'not' ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,42,FOLLOW_42_in_priority_1353); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // ./scenariotestTemp/generated2/FPath.g:272:106: ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) )
                            // ./scenariotestTemp/generated2/FPath.g:272:107: (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 )
                            {
                            // ./scenariotestTemp/generated2/FPath.g:272:107: (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 )
                            // ./scenariotestTemp/generated2/FPath.g:272:108: ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0
                            {
                            pushFollow(FOLLOW_fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1_in_priority_1360);
                            ret=fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_priority_0_in_priority_1364);
                            right=priority_0();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "operand", right);
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
                            // ./scenariotestTemp/generated2/FPath.g:275:3: ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) )
                            {
                            // ./scenariotestTemp/generated2/FPath.g:275:16: ( MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) ) )
                            // ./scenariotestTemp/generated2/FPath.g:275:17: MINUS ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,MINUS,FOLLOW_MINUS_in_priority_1385); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // ./scenariotestTemp/generated2/FPath.g:275:100: ( (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 ) )
                            // ./scenariotestTemp/generated2/FPath.g:275:101: (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 )
                            {
                            // ./scenariotestTemp/generated2/FPath.g:275:101: (ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0 )
                            // ./scenariotestTemp/generated2/FPath.g:275:102: ret= fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken] right= priority_0
                            {
                            pushFollow(FOLLOW_fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1_in_priority_1393);
                            ret=fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_priority_0_in_priority_1397);
                            right=priority_0();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "operand", right);
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

                    }


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:279:2: (ret= priority_0 )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:279:2: (ret= priority_0 )
                    // ./scenariotestTemp/generated2/FPath.g:279:4: ret= priority_0
                    {
                    pushFollow(FOLLOW_priority_0_in_priority_1413);
                    ret=priority_0();

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
    // $ANTLR end "priority_1"


    // $ANTLR start "priority_2"
    // ./scenariotestTemp/generated2/FPath.g:287:1: priority_2 returns [Object ret2] : ( (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) ;
    public final Object priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:288:3: ( ( (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:289:4: ( (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:289:4: ( (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:289:6: (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:289:6: (ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )* )
            // ./scenariotestTemp/generated2/FPath.g:289:8: ret= priority_1 ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_1_in_priority_2452);
            ret=priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/FPath.g:289:22: ( ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) | ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==STAR) && (synpred10_FPath())) {
                    alt5=1;
                }
                else if ( (LA5_0==43) && (synpred11_FPath())) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:289:23: ( ( STAR ) () )=> ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:289:35: ( STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:289:36: STAR ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,STAR,FOLLOW_STAR_in_priority_2465); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:289:118: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:289:119: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:289:119: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    // ./scenariotestTemp/generated2/FPath.g:289:120: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_2473);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_1_in_priority_2477);
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
            	case 2 :
            	    // ./scenariotestTemp/generated2/FPath.g:292:3: ( ( 'div' ) () )=> ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:292:16: ( 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:292:17: 'div' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("div", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,43,FOLLOW_43_in_priority_2498); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "div";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:292:103: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:292:104: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:292:104: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1 )
            	    // ./scenariotestTemp/generated2/FPath.g:292:105: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_1
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_2505);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_1_in_priority_2509);
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
    // $ANTLR end "priority_2"


    // $ANTLR start "priority_3"
    // ./scenariotestTemp/generated2/FPath.g:302:1: priority_3 returns [Object ret2] : ( (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ) ;
    public final Object priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:303:3: ( ( (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:304:4: ( (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:304:4: ( (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:304:6: (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:304:6: (ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )* )
            // ./scenariotestTemp/generated2/FPath.g:304:8: ret= priority_2 ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_2_in_priority_3556);
            ret=priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/FPath.g:304:22: ( ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) | ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==PLUS) && (synpred12_FPath())) {
                    alt6=1;
                }
                else if ( (LA6_0==MINUS) && (synpred13_FPath())) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:304:23: ( ( PLUS ) () )=> ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:304:35: ( PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:304:36: PLUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_3569); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:304:118: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:304:119: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:304:119: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 )
            	    // ./scenariotestTemp/generated2/FPath.g:304:120: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_3577);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_2_in_priority_3581);
            	    right=priority_2();

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
            	    // ./scenariotestTemp/generated2/FPath.g:307:3: ( ( MINUS ) () )=> ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:307:16: ( MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:307:17: MINUS ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,MINUS,FOLLOW_MINUS_in_priority_3602); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:307:100: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:307:101: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:307:101: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2 )
            	    // ./scenariotestTemp/generated2/FPath.g:307:102: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_2
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_3610);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_2_in_priority_3614);
            	    right=priority_2();

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
    // $ANTLR end "priority_3"


    // $ANTLR start "priority_4"
    // ./scenariotestTemp/generated2/FPath.g:317:1: priority_4 returns [Object ret2] : ( (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) ;
    public final Object priority_4() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:318:3: ( ( (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:319:4: ( (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:319:4: ( (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:319:6: (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:319:6: (ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )* )
            // ./scenariotestTemp/generated2/FPath.g:319:8: ret= priority_3 ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_3_in_priority_4661);
            ret=priority_3();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/FPath.g:319:22: ( ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) | ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) ) )*
            loop7:
            do {
                int alt7=7;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==LT) && (synpred14_FPath())) {
                    alt7=1;
                }
                else if ( (LA7_0==GT) && (synpred15_FPath())) {
                    alt7=2;
                }
                else if ( (LA7_0==LE) && (synpred16_FPath())) {
                    alt7=3;
                }
                else if ( (LA7_0==GE) && (synpred17_FPath())) {
                    alt7=4;
                }
                else if ( (LA7_0==EQEQ) && (synpred18_FPath())) {
                    alt7=5;
                }
                else if ( (LA7_0==NE) && (synpred19_FPath())) {
                    alt7=6;
                }


                switch (alt7) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:319:23: ( ( LT ) () )=> ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:319:33: ( LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:319:34: LT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LT,FOLLOW_LT_in_priority_4674); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:319:114: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:319:115: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:319:115: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:319:116: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4682);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4686);
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
            	    // ./scenariotestTemp/generated2/FPath.g:322:3: ( ( GT ) () )=> ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:322:13: ( GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:322:14: GT ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GT,FOLLOW_GT_in_priority_4707); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:322:94: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:322:95: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:322:95: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:322:96: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4715);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4719);
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
            	    // ./scenariotestTemp/generated2/FPath.g:325:3: ( ( LE ) () )=> ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:325:13: ( LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:325:14: LE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LE,FOLLOW_LE_in_priority_4740); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:325:96: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:325:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:325:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:325:98: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4748);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4752);
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
            	case 4 :
            	    // ./scenariotestTemp/generated2/FPath.g:328:3: ( ( GE ) () )=> ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:328:13: ( GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:328:14: GE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GE,FOLLOW_GE_in_priority_4773); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:328:96: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:328:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:328:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:328:98: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4781);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4785);
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
            	case 5 :
            	    // ./scenariotestTemp/generated2/FPath.g:331:3: ( ( EQEQ ) () )=> ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:331:15: ( EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:331:16: EQEQ ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("==", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQEQ,FOLLOW_EQEQ_in_priority_4806); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "==";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:331:100: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:331:101: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:331:101: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:331:102: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4814);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4818);
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
            	case 6 :
            	    // ./scenariotestTemp/generated2/FPath.g:334:3: ( ( NE ) () )=> ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:334:13: ( NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:334:14: NE ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<>", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,NE,FOLLOW_NE_in_priority_4839); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<>";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:334:96: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:334:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:334:97: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3 )
            	    // ./scenariotestTemp/generated2/FPath.g:334:98: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_3
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4847);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_3_in_priority_4851);
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
    // $ANTLR end "priority_4"


    // $ANTLR start "priority_5"
    // ./scenariotestTemp/generated2/FPath.g:344:1: priority_5 returns [Object ret2] : ( (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) ;
    public final Object priority_5() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/FPath.g:345:3: ( ( (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:346:4: ( (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:346:4: ( (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:346:6: (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:346:6: (ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )* )
            // ./scenariotestTemp/generated2/FPath.g:346:8: ret= priority_4 ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            {
            pushFollow(FOLLOW_priority_4_in_priority_5898);
            ret=priority_4();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/FPath.g:346:22: ( ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==44) && (synpred20_FPath())) {
                    alt8=1;
                }
                else if ( (LA8_0==45) && (synpred21_FPath())) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:346:23: ( ( 'and' ) () )=> ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:346:36: ( 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:346:37: 'and' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("and", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,44,FOLLOW_44_in_priority_5911); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "and";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:346:123: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:346:124: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:346:124: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/FPath.g:346:125: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_5918);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5922);
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
            	    // ./scenariotestTemp/generated2/FPath.g:349:3: ( ( 'or' ) () )=> ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:349:15: ( 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) ) )
            	    // ./scenariotestTemp/generated2/FPath.g:349:16: 'or' ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("or", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,45,FOLLOW_45_in_priority_5943); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "or";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:349:99: ( (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 ) )
            	    // ./scenariotestTemp/generated2/FPath.g:349:100: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    {
            	    // ./scenariotestTemp/generated2/FPath.g:349:100: (ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4 )
            	    // ./scenariotestTemp/generated2/FPath.g:349:101: ret= fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken] right= priority_4
            	    {
            	    pushFollow(FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_5950);
            	    ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_priority_4_in_priority_5954);
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
    // $ANTLR end "priority_5"


    // $ANTLR start "fpath_expression"
    // ./scenariotestTemp/generated2/FPath.g:359:1: fpath_expression returns [Object ret2] : ret= priority_5 ;
    public final Object fpath_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:360:3: (ret= priority_5 )
            // ./scenariotestTemp/generated2/FPath.g:361:3: ret= priority_5
            {
            pushFollow(FOLLOW_priority_5_in_fpath_expression992);
            ret=priority_5();

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
    // $ANTLR end "fpath_expression"


    // $ANTLR start "fpath_contextexp"
    // ./scenariotestTemp/generated2/FPath.g:368:1: fpath_contextexp returns [Object ret2] : ( POINT ) ;
    public final Object fpath_contextexp() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("FPath","ContextExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:373:3: ( ( POINT ) )
            // ./scenariotestTemp/generated2/FPath.g:374:3: ( POINT )
            {
            // ./scenariotestTemp/generated2/FPath.g:374:3: ( POINT )
            // ./scenariotestTemp/generated2/FPath.g:374:4: POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,POINT,FOLLOW_POINT_in_fpath_contextexp1022); if (state.failed) return ret2;
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
    // $ANTLR end "fpath_contextexp"


    // $ANTLR start "fpath_variableexp"
    // ./scenariotestTemp/generated2/FPath.g:382:1: fpath_variableexp returns [Object ret2] : ( '$' (temp= identifier ) ) ;
    public final Object fpath_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","VariableExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:387:3: ( ( '$' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/FPath.g:388:3: ( '$' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:388:3: ( '$' (temp= identifier ) )
            // ./scenariotestTemp/generated2/FPath.g:388:4: '$' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,46,FOLLOW_46_in_fpath_variableexp1063); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:388:57: (temp= identifier )
            // ./scenariotestTemp/generated2/FPath.g:388:59: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_fpath_variableexp1070);
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
    // $ANTLR end "fpath_variableexp"


    // $ANTLR start "fpath_functioncallexp"
    // ./scenariotestTemp/generated2/FPath.g:396:1: fpath_functioncallexp returns [Object ret2] : ( (temp= identifier ) LPAREN (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )? RPAREN ) ;
    public final Object fpath_functioncallexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","FunctionCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:401:3: ( ( (temp= identifier ) LPAREN (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )? RPAREN ) )
            // ./scenariotestTemp/generated2/FPath.g:402:3: ( (temp= identifier ) LPAREN (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )? RPAREN )
            {
            // ./scenariotestTemp/generated2/FPath.g:402:3: ( (temp= identifier ) LPAREN (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )? RPAREN )
            // ./scenariotestTemp/generated2/FPath.g:402:4: (temp= identifier ) LPAREN (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:402:21: (temp= identifier )
            // ./scenariotestTemp/generated2/FPath.g:402:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_fpath_functioncallexp1117);
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
            match(input,LPAREN,FOLLOW_LPAREN_in_fpath_functioncallexp1124); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:402:147: (temp= fpath_expression ( ( COMA ) temp= fpath_expression )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=NAME && LA10_0<=LPAREN)||LA10_0==MINUS||LA10_0==POINT||LA10_0==42||LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:402:149: temp= fpath_expression ( ( COMA ) temp= fpath_expression )*
                    {
                    pushFollow(FOLLOW_fpath_expression_in_fpath_functioncallexp1132);
                    temp=fpath_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                    }
                    // ./scenariotestTemp/generated2/FPath.g:402:210: ( ( COMA ) temp= fpath_expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/FPath.g:402:211: ( COMA ) temp= fpath_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/FPath.g:402:228: ( COMA )
                    	    // ./scenariotestTemp/generated2/FPath.g:402:229: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_fpath_functioncallexp1141); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_fpath_expression_in_fpath_functioncallexp1149);
                    	    temp=fpath_expression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
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

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_fpath_functioncallexp1161); if (state.failed) return ret2;
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
    // $ANTLR end "fpath_functioncallexp"


    // $ANTLR start "fpath_numberexp"
    // ./scenariotestTemp/generated2/FPath.g:410:1: fpath_numberexp returns [Object ret2] : ( (temp= floatSymbol ) ) ;
    public final Object fpath_numberexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","NumberExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:415:3: ( ( (temp= floatSymbol ) ) )
            // ./scenariotestTemp/generated2/FPath.g:416:3: ( (temp= floatSymbol ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:416:3: ( (temp= floatSymbol ) )
            // ./scenariotestTemp/generated2/FPath.g:416:4: (temp= floatSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:416:21: (temp= floatSymbol )
            // ./scenariotestTemp/generated2/FPath.g:416:23: temp= floatSymbol
            {
            pushFollow(FOLLOW_floatSymbol_in_fpath_numberexp1206);
            temp=floatSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
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
    // $ANTLR end "fpath_numberexp"


    // $ANTLR start "fpath_stringexp"
    // ./scenariotestTemp/generated2/FPath.g:424:1: fpath_stringexp returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object fpath_stringexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","StringExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:429:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/FPath.g:430:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:430:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/FPath.g:430:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:430:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/FPath.g:430:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_fpath_stringexp1253);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
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
    // $ANTLR end "fpath_stringexp"


    // $ANTLR start "fpath_pathexp_FPath_PathExp_opSlash"
    // ./scenariotestTemp/generated2/FPath.g:438:1: fpath_pathexp_FPath_PathExp_opSlash[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= fpath_step ( ( SLASH ) temp= fpath_step )* ) ) ;
    public final Object fpath_pathexp_FPath_PathExp_opSlash(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","PathExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:443:3: ( ( (temp= fpath_step ( ( SLASH ) temp= fpath_step )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:444:3: ( (temp= fpath_step ( ( SLASH ) temp= fpath_step )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:444:3: ( (temp= fpath_step ( ( SLASH ) temp= fpath_step )* ) )
            // ./scenariotestTemp/generated2/FPath.g:444:4: (temp= fpath_step ( ( SLASH ) temp= fpath_step )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:444:21: (temp= fpath_step ( ( SLASH ) temp= fpath_step )* )
            // ./scenariotestTemp/generated2/FPath.g:444:23: temp= fpath_step ( ( SLASH ) temp= fpath_step )*
            {
            pushFollow(FOLLOW_fpath_step_in_fpath_pathexp_FPath_PathExp_opSlash1301);
            temp=fpath_step();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "steps", temp);
            }
            // ./scenariotestTemp/generated2/FPath.g:444:74: ( ( SLASH ) temp= fpath_step )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:444:75: ( SLASH ) temp= fpath_step
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/FPath.g:444:92: ( SLASH )
            	    // ./scenariotestTemp/generated2/FPath.g:444:93: SLASH
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,SLASH,FOLLOW_SLASH_in_fpath_pathexp_FPath_PathExp_opSlash1310); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_fpath_step_in_fpath_pathexp_FPath_PathExp_opSlash1318);
            	    temp=fpath_step();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "steps", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"initialNodeSet" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "fpath_pathexp_FPath_PathExp_opSlash"


    // $ANTLR start "fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr"
    // ./scenariotestTemp/generated2/FPath.g:454:1: fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("FPath","BinaryOperatorExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:459:3: ()
            // ./scenariotestTemp/generated2/FPath.g:460:3: 
            {
            if ( state.backtracking==0 ) {

              setProperty(ret,"operator" , opName);
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
    // $ANTLR end "fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr"


    // $ANTLR start "fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1"
    // ./scenariotestTemp/generated2/FPath.g:470:1: fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("FPath","UnaryOperatorExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:475:3: ()
            // ./scenariotestTemp/generated2/FPath.g:476:3: 
            {
            if ( state.backtracking==0 ) {

              setProperty(ret,"operator" , opName);
              setProperty(ret,"operand" , left);
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
    // $ANTLR end "fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1"


    // $ANTLR start "fpath_step"
    // ./scenariotestTemp/generated2/FPath.g:486:1: fpath_step returns [Object ret2] : ( (temp= fpath_axis ) COLONCOLON (temp= fpath_test ) ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | ) ) ;
    public final Object fpath_step() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","Step");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:491:3: ( ( (temp= fpath_axis ) COLONCOLON (temp= fpath_test ) ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | ) ) )
            // ./scenariotestTemp/generated2/FPath.g:492:3: ( (temp= fpath_axis ) COLONCOLON (temp= fpath_test ) ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:492:3: ( (temp= fpath_axis ) COLONCOLON (temp= fpath_test ) ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | ) )
            // ./scenariotestTemp/generated2/FPath.g:492:4: (temp= fpath_axis ) COLONCOLON (temp= fpath_test ) ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:492:21: (temp= fpath_axis )
            // ./scenariotestTemp/generated2/FPath.g:492:23: temp= fpath_axis
            {
            pushFollow(FOLLOW_fpath_axis_in_fpath_step1416);
            temp=fpath_axis();

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
            match(input,COLONCOLON,FOLLOW_COLONCOLON_in_fpath_step1423); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:492:151: (temp= fpath_test )
            // ./scenariotestTemp/generated2/FPath.g:492:153: temp= fpath_test
            {
            pushFollow(FOLLOW_fpath_test_in_fpath_step1431);
            temp=fpath_test();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "test", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:492:237: ( ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LSQUARE) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||(LA14_0>=RPAREN && LA14_0<=NE)||LA14_0==COMA||LA14_0==RSQUARE||(LA14_0>=43 && LA14_0<=45)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:492:238: ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/FPath.g:492:254: ( LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE )
                    // ./scenariotestTemp/generated2/FPath.g:492:255: LSQUARE (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )? RSQUARE
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LSQUARE,FOLLOW_LSQUARE_in_fpath_step1444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/FPath.g:492:314: (temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=NAME && LA13_0<=LPAREN)||LA13_0==MINUS||LA13_0==POINT||LA13_0==42||LA13_0==46) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ./scenariotestTemp/generated2/FPath.g:492:316: temp= fpath_expression ( ( RSQUARE LSQUARE ) temp= fpath_expression )*
                            {
                            pushFollow(FOLLOW_fpath_expression_in_fpath_step1452);
                            temp=fpath_expression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicates", temp);
                            }
                            // ./scenariotestTemp/generated2/FPath.g:492:378: ( ( RSQUARE LSQUARE ) temp= fpath_expression )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RSQUARE) ) {
                                    int LA12_1 = input.LA(2);

                                    if ( (LA12_1==LSQUARE) ) {
                                        alt12=1;
                                    }


                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/FPath.g:492:379: ( RSQUARE LSQUARE ) temp= fpath_expression
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/FPath.g:492:396: ( RSQUARE LSQUARE )
                            	    // ./scenariotestTemp/generated2/FPath.g:492:397: RSQUARE LSQUARE
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,RSQUARE,FOLLOW_RSQUARE_in_fpath_step1461); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,LSQUARE,FOLLOW_LSQUARE_in_fpath_step1466); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_fpath_expression_in_fpath_step1474);
                            	    temp=fpath_expression();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "predicates", temp);
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

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RSQUARE,FOLLOW_RSQUARE_in_fpath_step1486); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/FPath.g:492:642: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
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
    // $ANTLR end "fpath_step"


    // $ANTLR start "fpath_test"
    // ./scenariotestTemp/generated2/FPath.g:501:1: fpath_test returns [Object ret2] : (ret= fpath_wildcardtest | ret= fpath_nametest ) ;
    public final Object fpath_test() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/FPath.g:502:3: ( (ret= fpath_wildcardtest | ret= fpath_nametest ) )
            // ./scenariotestTemp/generated2/FPath.g:503:3: (ret= fpath_wildcardtest | ret= fpath_nametest )
            {
            // ./scenariotestTemp/generated2/FPath.g:503:3: (ret= fpath_wildcardtest | ret= fpath_nametest )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==STAR) ) {
                alt15=1;
            }
            else if ( (LA15_0==NAME) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:503:4: ret= fpath_wildcardtest
                    {
                    pushFollow(FOLLOW_fpath_wildcardtest_in_fpath_test1537);
                    ret=fpath_wildcardtest();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:504:5: ret= fpath_nametest
                    {
                    pushFollow(FOLLOW_fpath_nametest_in_fpath_test1545);
                    ret=fpath_nametest();

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
    // $ANTLR end "fpath_test"


    // $ANTLR start "fpath_wildcardtest"
    // ./scenariotestTemp/generated2/FPath.g:511:1: fpath_wildcardtest returns [Object ret2] : ( STAR ) ;
    public final Object fpath_wildcardtest() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("FPath","WildcardTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:516:3: ( ( STAR ) )
            // ./scenariotestTemp/generated2/FPath.g:517:3: ( STAR )
            {
            // ./scenariotestTemp/generated2/FPath.g:517:3: ( STAR )
            // ./scenariotestTemp/generated2/FPath.g:517:4: STAR
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,STAR,FOLLOW_STAR_in_fpath_wildcardtest1576); if (state.failed) return ret2;
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
    // $ANTLR end "fpath_wildcardtest"


    // $ANTLR start "fpath_nametest"
    // ./scenariotestTemp/generated2/FPath.g:525:1: fpath_nametest returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object fpath_nametest() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("FPath","NameTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/FPath.g:530:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/FPath.g:531:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:531:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/FPath.g:531:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/FPath.g:531:21: (temp= identifier )
            // ./scenariotestTemp/generated2/FPath.g:531:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_fpath_nametest1621);
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
    // $ANTLR end "fpath_nametest"


    // $ANTLR start "fpath_axis"
    // ./scenariotestTemp/generated2/FPath.g:539:1: fpath_axis returns [Object ret2] : ( ( 'component' ) | ( 'internal-interface' ) | ( 'interface' ) | ( 'attribute' ) | ( 'binding' ) | ( 'child' ) | ( 'parent' ) | ( 'descendant' ) | ( 'ancestor' ) | ( 'sibling' ) | ( 'descendant-or-self' ) | ( 'ancestor-or-self' ) | ( 'sibling-or-self' ) ) ;
    public final Object fpath_axis() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/FPath.g:540:3: ( ( ( 'component' ) | ( 'internal-interface' ) | ( 'interface' ) | ( 'attribute' ) | ( 'binding' ) | ( 'child' ) | ( 'parent' ) | ( 'descendant' ) | ( 'ancestor' ) | ( 'sibling' ) | ( 'descendant-or-self' ) | ( 'ancestor-or-self' ) | ( 'sibling-or-self' ) ) )
            // ./scenariotestTemp/generated2/FPath.g:541:3: ( ( 'component' ) | ( 'internal-interface' ) | ( 'interface' ) | ( 'attribute' ) | ( 'binding' ) | ( 'child' ) | ( 'parent' ) | ( 'descendant' ) | ( 'ancestor' ) | ( 'sibling' ) | ( 'descendant-or-self' ) | ( 'ancestor-or-self' ) | ( 'sibling-or-self' ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:541:3: ( ( 'component' ) | ( 'internal-interface' ) | ( 'interface' ) | ( 'attribute' ) | ( 'binding' ) | ( 'child' ) | ( 'parent' ) | ( 'descendant' ) | ( 'ancestor' ) | ( 'sibling' ) | ( 'descendant-or-self' ) | ( 'ancestor-or-self' ) | ( 'sibling-or-self' ) )
            int alt16=13;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt16=1;
                }
                break;
            case 48:
                {
                alt16=2;
                }
                break;
            case 49:
                {
                alt16=3;
                }
                break;
            case 50:
                {
                alt16=4;
                }
                break;
            case 51:
                {
                alt16=5;
                }
                break;
            case 52:
                {
                alt16=6;
                }
                break;
            case 53:
                {
                alt16=7;
                }
                break;
            case 54:
                {
                alt16=8;
                }
                break;
            case 55:
                {
                alt16=9;
                }
                break;
            case 56:
                {
                alt16=10;
                }
                break;
            case 57:
                {
                alt16=11;
                }
                break;
            case 58:
                {
                alt16=12;
                }
                break;
            case 59:
                {
                alt16=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:541:4: ( 'component' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:541:4: ( 'component' )
                    // ./scenariotestTemp/generated2/FPath.g:541:5: 'component'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,47,FOLLOW_47_in_fpath_axis1665); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "component");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:542:4: ( 'internal-interface' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:542:4: ( 'internal-interface' )
                    // ./scenariotestTemp/generated2/FPath.g:542:5: 'internal-interface'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,48,FOLLOW_48_in_fpath_axis1675); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "internal-interface");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/FPath.g:543:4: ( 'interface' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:543:4: ( 'interface' )
                    // ./scenariotestTemp/generated2/FPath.g:543:5: 'interface'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,49,FOLLOW_49_in_fpath_axis1685); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "interface");
                    }

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/FPath.g:544:4: ( 'attribute' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:544:4: ( 'attribute' )
                    // ./scenariotestTemp/generated2/FPath.g:544:5: 'attribute'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_fpath_axis1695); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "attribute");
                    }

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/FPath.g:545:4: ( 'binding' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:545:4: ( 'binding' )
                    // ./scenariotestTemp/generated2/FPath.g:545:5: 'binding'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,51,FOLLOW_51_in_fpath_axis1705); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "binding");
                    }

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/FPath.g:546:4: ( 'child' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:546:4: ( 'child' )
                    // ./scenariotestTemp/generated2/FPath.g:546:5: 'child'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,52,FOLLOW_52_in_fpath_axis1715); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "child");
                    }

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/FPath.g:547:4: ( 'parent' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:547:4: ( 'parent' )
                    // ./scenariotestTemp/generated2/FPath.g:547:5: 'parent'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,53,FOLLOW_53_in_fpath_axis1725); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "parent");
                    }

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/FPath.g:548:4: ( 'descendant' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:548:4: ( 'descendant' )
                    // ./scenariotestTemp/generated2/FPath.g:548:5: 'descendant'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,54,FOLLOW_54_in_fpath_axis1735); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "descendant");
                    }

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/FPath.g:549:4: ( 'ancestor' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:549:4: ( 'ancestor' )
                    // ./scenariotestTemp/generated2/FPath.g:549:5: 'ancestor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,55,FOLLOW_55_in_fpath_axis1745); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "ancestor");
                    }

                    }
                    break;
                case 10 :
                    // ./scenariotestTemp/generated2/FPath.g:550:4: ( 'sibling' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:550:4: ( 'sibling' )
                    // ./scenariotestTemp/generated2/FPath.g:550:5: 'sibling'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,56,FOLLOW_56_in_fpath_axis1755); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "sibling");
                    }

                    }
                    break;
                case 11 :
                    // ./scenariotestTemp/generated2/FPath.g:551:4: ( 'descendant-or-self' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:551:4: ( 'descendant-or-self' )
                    // ./scenariotestTemp/generated2/FPath.g:551:5: 'descendant-or-self'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,57,FOLLOW_57_in_fpath_axis1765); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "descendant-or-self");
                    }

                    }
                    break;
                case 12 :
                    // ./scenariotestTemp/generated2/FPath.g:552:4: ( 'ancestor-or-self' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:552:4: ( 'ancestor-or-self' )
                    // ./scenariotestTemp/generated2/FPath.g:552:5: 'ancestor-or-self'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,58,FOLLOW_58_in_fpath_axis1775); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "ancestor-or-self");
                    }

                    }
                    break;
                case 13 :
                    // ./scenariotestTemp/generated2/FPath.g:553:4: ( 'sibling-or-self' )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:553:4: ( 'sibling-or-self' )
                    // ./scenariotestTemp/generated2/FPath.g:553:5: 'sibling-or-self'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,59,FOLLOW_59_in_fpath_axis1785); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FPath","Axis"), "sibling-or-self");
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
    // $ANTLR end "fpath_axis"

    // $ANTLR start synpred6_FPath
    public final void synpred6_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:262:37: ( ( SLASH ) () )
        // ./scenariotestTemp/generated2/FPath.g:262:38: ( SLASH ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:262:38: ( SLASH )
        // ./scenariotestTemp/generated2/FPath.g:262:39: SLASH
        {
        match(input,SLASH,FOLLOW_SLASH_in_synpred6_FPath283); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:262:45: ()
        // ./scenariotestTemp/generated2/FPath.g:262:46: 
        {
        }


        }
    }
    // $ANTLR end synpred6_FPath

    // $ANTLR start synpred7_FPath
    public final void synpred7_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:272:6: ( ( 'not' ) () )
        // ./scenariotestTemp/generated2/FPath.g:272:7: ( 'not' ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:272:7: ( 'not' )
        // ./scenariotestTemp/generated2/FPath.g:272:8: 'not'
        {
        match(input,42,FOLLOW_42_in_synpred7_FPath344); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:272:14: ()
        // ./scenariotestTemp/generated2/FPath.g:272:15: 
        {
        }


        }
    }
    // $ANTLR end synpred7_FPath

    // $ANTLR start synpred8_FPath
    public final void synpred8_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:275:3: ( ( MINUS ) () )
        // ./scenariotestTemp/generated2/FPath.g:275:4: ( MINUS ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:275:4: ( MINUS )
        // ./scenariotestTemp/generated2/FPath.g:275:5: MINUS
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred8_FPath376); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:275:11: ()
        // ./scenariotestTemp/generated2/FPath.g:275:12: 
        {
        }


        }
    }
    // $ANTLR end synpred8_FPath

    // $ANTLR start synpred10_FPath
    public final void synpred10_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:289:23: ( ( STAR ) () )
        // ./scenariotestTemp/generated2/FPath.g:289:24: ( STAR ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:289:24: ( STAR )
        // ./scenariotestTemp/generated2/FPath.g:289:25: STAR
        {
        match(input,STAR,FOLLOW_STAR_in_synpred10_FPath456); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:289:30: ()
        // ./scenariotestTemp/generated2/FPath.g:289:31: 
        {
        }


        }
    }
    // $ANTLR end synpred10_FPath

    // $ANTLR start synpred11_FPath
    public final void synpred11_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:292:3: ( ( 'div' ) () )
        // ./scenariotestTemp/generated2/FPath.g:292:4: ( 'div' ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:292:4: ( 'div' )
        // ./scenariotestTemp/generated2/FPath.g:292:5: 'div'
        {
        match(input,43,FOLLOW_43_in_synpred11_FPath489); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:292:11: ()
        // ./scenariotestTemp/generated2/FPath.g:292:12: 
        {
        }


        }
    }
    // $ANTLR end synpred11_FPath

    // $ANTLR start synpred12_FPath
    public final void synpred12_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:304:23: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/FPath.g:304:24: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:304:24: ( PLUS )
        // ./scenariotestTemp/generated2/FPath.g:304:25: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred12_FPath560); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:304:30: ()
        // ./scenariotestTemp/generated2/FPath.g:304:31: 
        {
        }


        }
    }
    // $ANTLR end synpred12_FPath

    // $ANTLR start synpred13_FPath
    public final void synpred13_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:307:3: ( ( MINUS ) () )
        // ./scenariotestTemp/generated2/FPath.g:307:4: ( MINUS ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:307:4: ( MINUS )
        // ./scenariotestTemp/generated2/FPath.g:307:5: MINUS
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred13_FPath593); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:307:11: ()
        // ./scenariotestTemp/generated2/FPath.g:307:12: 
        {
        }


        }
    }
    // $ANTLR end synpred13_FPath

    // $ANTLR start synpred14_FPath
    public final void synpred14_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:319:23: ( ( LT ) () )
        // ./scenariotestTemp/generated2/FPath.g:319:24: ( LT ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:319:24: ( LT )
        // ./scenariotestTemp/generated2/FPath.g:319:25: LT
        {
        match(input,LT,FOLLOW_LT_in_synpred14_FPath665); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:319:28: ()
        // ./scenariotestTemp/generated2/FPath.g:319:29: 
        {
        }


        }
    }
    // $ANTLR end synpred14_FPath

    // $ANTLR start synpred15_FPath
    public final void synpred15_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:322:3: ( ( GT ) () )
        // ./scenariotestTemp/generated2/FPath.g:322:4: ( GT ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:322:4: ( GT )
        // ./scenariotestTemp/generated2/FPath.g:322:5: GT
        {
        match(input,GT,FOLLOW_GT_in_synpred15_FPath698); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:322:8: ()
        // ./scenariotestTemp/generated2/FPath.g:322:9: 
        {
        }


        }
    }
    // $ANTLR end synpred15_FPath

    // $ANTLR start synpred16_FPath
    public final void synpred16_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:325:3: ( ( LE ) () )
        // ./scenariotestTemp/generated2/FPath.g:325:4: ( LE ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:325:4: ( LE )
        // ./scenariotestTemp/generated2/FPath.g:325:5: LE
        {
        match(input,LE,FOLLOW_LE_in_synpred16_FPath731); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:325:8: ()
        // ./scenariotestTemp/generated2/FPath.g:325:9: 
        {
        }


        }
    }
    // $ANTLR end synpred16_FPath

    // $ANTLR start synpred17_FPath
    public final void synpred17_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:328:3: ( ( GE ) () )
        // ./scenariotestTemp/generated2/FPath.g:328:4: ( GE ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:328:4: ( GE )
        // ./scenariotestTemp/generated2/FPath.g:328:5: GE
        {
        match(input,GE,FOLLOW_GE_in_synpred17_FPath764); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:328:8: ()
        // ./scenariotestTemp/generated2/FPath.g:328:9: 
        {
        }


        }
    }
    // $ANTLR end synpred17_FPath

    // $ANTLR start synpred18_FPath
    public final void synpred18_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:331:3: ( ( EQEQ ) () )
        // ./scenariotestTemp/generated2/FPath.g:331:4: ( EQEQ ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:331:4: ( EQEQ )
        // ./scenariotestTemp/generated2/FPath.g:331:5: EQEQ
        {
        match(input,EQEQ,FOLLOW_EQEQ_in_synpred18_FPath797); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:331:10: ()
        // ./scenariotestTemp/generated2/FPath.g:331:11: 
        {
        }


        }
    }
    // $ANTLR end synpred18_FPath

    // $ANTLR start synpred19_FPath
    public final void synpred19_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:334:3: ( ( NE ) () )
        // ./scenariotestTemp/generated2/FPath.g:334:4: ( NE ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:334:4: ( NE )
        // ./scenariotestTemp/generated2/FPath.g:334:5: NE
        {
        match(input,NE,FOLLOW_NE_in_synpred19_FPath830); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:334:8: ()
        // ./scenariotestTemp/generated2/FPath.g:334:9: 
        {
        }


        }
    }
    // $ANTLR end synpred19_FPath

    // $ANTLR start synpred20_FPath
    public final void synpred20_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:346:23: ( ( 'and' ) () )
        // ./scenariotestTemp/generated2/FPath.g:346:24: ( 'and' ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:346:24: ( 'and' )
        // ./scenariotestTemp/generated2/FPath.g:346:25: 'and'
        {
        match(input,44,FOLLOW_44_in_synpred20_FPath902); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:346:31: ()
        // ./scenariotestTemp/generated2/FPath.g:346:32: 
        {
        }


        }
    }
    // $ANTLR end synpred20_FPath

    // $ANTLR start synpred21_FPath
    public final void synpred21_FPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/FPath.g:349:3: ( ( 'or' ) () )
        // ./scenariotestTemp/generated2/FPath.g:349:4: ( 'or' ) ()
        {
        // ./scenariotestTemp/generated2/FPath.g:349:4: ( 'or' )
        // ./scenariotestTemp/generated2/FPath.g:349:5: 'or'
        {
        match(input,45,FOLLOW_45_in_synpred21_FPath934); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/FPath.g:349:10: ()
        // ./scenariotestTemp/generated2/FPath.g:349:11: 
        {
        }


        }
    }
    // $ANTLR end synpred21_FPath

    // $ANTLR start synpred24_FPath
    public final void synpred24_FPath_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/FPath.g:444:75: ( ( SLASH ) temp= fpath_step )
        // ./scenariotestTemp/generated2/FPath.g:444:75: ( SLASH ) temp= fpath_step
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/FPath.g:444:92: ( SLASH )
        // ./scenariotestTemp/generated2/FPath.g:444:93: SLASH
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,SLASH,FOLLOW_SLASH_in_synpred24_FPath1310); if (state.failed) return ;

        }

        pushFollow(FOLLOW_fpath_step_in_synpred24_FPath1318);
        temp=fpath_step();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_FPath

    // Delegated rules

    public final boolean synpred20_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_FPath_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_FPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_FPath_fragment(); // can never throw exception
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
        "\24\uffff";
    static final String DFA11_eofS =
        "\1\1\23\uffff";
    static final String DFA11_minS =
        "\1\10\1\uffff\1\57\15\25\1\4\2\0\1\uffff";
    static final String DFA11_maxS =
        "\1\55\1\uffff\1\73\15\25\1\13\2\0\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA11_specialS =
        "\21\uffff\1\1\1\0\1\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\1\2\11\1\1\uffff\1\1\2\uffff\1\1\23\uffff\3\1",
            "",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\20",
            "\1\22\6\uffff\1\21",
            "\1\uffff",
            "\1\uffff",
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
            return "()* loopback of 444:74: ( ( SLASH ) temp= fpath_step )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_18 = input.LA(1);

                         
                        int index11_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_FPath()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index11_18);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_17 = input.LA(1);

                         
                        int index11_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_FPath()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index11_17);
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
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_expression_in_main159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_contextexp_in_primary_fpath_expression190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_functioncallexp_in_primary_fpath_expression198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_numberexp_in_primary_fpath_expression206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_stringexp_in_primary_fpath_expression214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_variableexp_in_primary_fpath_expression222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_fpath_expression231 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_expression_in_primary_fpath_expression237 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_primary_fpath_expression241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_fpath_expression_in_priority_0279 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_SLASH_in_priority_0292 = new BitSet(new long[]{0x0FFF800000000000L});
    public static final BitSet FOLLOW_fpath_pathexp_FPath_PathExp_opSlash_in_priority_0300 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_42_in_priority_1353 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1_in_priority_1360 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_0_in_priority_1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_priority_1385 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1_in_priority_1393 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_0_in_priority_1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_priority_1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_1_in_priority_2452 = new BitSet(new long[]{0x0000080000000802L});
    public static final BitSet FOLLOW_STAR_in_priority_2465 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_2473 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_1_in_priority_2477 = new BitSet(new long[]{0x0000080000000802L});
    public static final BitSet FOLLOW_43_in_priority_2498 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_2505 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_1_in_priority_2509 = new BitSet(new long[]{0x0000080000000802L});
    public static final BitSet FOLLOW_priority_2_in_priority_3556 = new BitSet(new long[]{0x0000000000001402L});
    public static final BitSet FOLLOW_PLUS_in_priority_3569 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_3577 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_2_in_priority_3581 = new BitSet(new long[]{0x0000000000001402L});
    public static final BitSet FOLLOW_MINUS_in_priority_3602 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_3610 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_2_in_priority_3614 = new BitSet(new long[]{0x0000000000001402L});
    public static final BitSet FOLLOW_priority_3_in_priority_4661 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_LT_in_priority_4674 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4682 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4686 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_GT_in_priority_4707 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4715 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4719 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_LE_in_priority_4740 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4748 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4752 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_GE_in_priority_4773 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4781 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4785 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_EQEQ_in_priority_4806 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4814 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4818 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_NE_in_priority_4839 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_4847 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_3_in_priority_4851 = new BitSet(new long[]{0x000000000007E002L});
    public static final BitSet FOLLOW_priority_4_in_priority_5898 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_44_in_priority_5911 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_5918 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_4_in_priority_5922 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_45_in_priority_5943 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr_in_priority_5950 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_priority_4_in_priority_5954 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_priority_5_in_fpath_expression992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_fpath_contextexp1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_fpath_variableexp1063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_fpath_variableexp1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_fpath_functioncallexp1117 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LPAREN_in_fpath_functioncallexp1124 = new BitSet(new long[]{0x00004400000805F0L});
    public static final BitSet FOLLOW_fpath_expression_in_fpath_functioncallexp1132 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_COMA_in_fpath_functioncallexp1141 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_expression_in_fpath_functioncallexp1149 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_RPAREN_in_fpath_functioncallexp1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatSymbol_in_fpath_numberexp1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_fpath_stringexp1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_step_in_fpath_pathexp_FPath_PathExp_opSlash1301 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_SLASH_in_fpath_pathexp_FPath_PathExp_opSlash1310 = new BitSet(new long[]{0x0FFF800000000000L});
    public static final BitSet FOLLOW_fpath_step_in_fpath_pathexp_FPath_PathExp_opSlash1318 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_fpath_axis_in_fpath_step1416 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLONCOLON_in_fpath_step1423 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_fpath_test_in_fpath_step1431 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LSQUARE_in_fpath_step1444 = new BitSet(new long[]{0x00004400008804F0L});
    public static final BitSet FOLLOW_fpath_expression_in_fpath_step1452 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RSQUARE_in_fpath_step1461 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LSQUARE_in_fpath_step1466 = new BitSet(new long[]{0x00004400000804F0L});
    public static final BitSet FOLLOW_fpath_expression_in_fpath_step1474 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RSQUARE_in_fpath_step1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_wildcardtest_in_fpath_test1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpath_nametest_in_fpath_test1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_fpath_wildcardtest1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_fpath_nametest1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_fpath_axis1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_fpath_axis1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_fpath_axis1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_fpath_axis1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_fpath_axis1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_fpath_axis1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_fpath_axis1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_fpath_axis1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_fpath_axis1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_fpath_axis1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_fpath_axis1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_fpath_axis1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_fpath_axis1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_synpred6_FPath283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred7_FPath344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred8_FPath376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred10_FPath456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred11_FPath489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred12_FPath560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred13_FPath593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_synpred14_FPath665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_synpred15_FPath698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_synpred16_FPath731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_synpred17_FPath764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQEQ_in_synpred18_FPath797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NE_in_synpred19_FPath830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred20_FPath902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred21_FPath934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_synpred24_FPath1310 = new BitSet(new long[]{0x0FFF800000000000L});
    public static final BitSet FOLLOW_fpath_step_in_synpred24_FPath1318 = new BitSet(new long[]{0x0000000000000002L});

}