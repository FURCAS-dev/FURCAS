// $ANTLR 3.1.1 ./scenariotestTemp/generated2/XPathReduced.g 2010-11-04 23:27:39

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class XPathReducedLexer extends Lexer {
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
    public static final int SLASH=28;
    public static final int WS=31;
    public static final int SLASHSLASH=29;
    public static final int T__36=36;
    public static final int SNAME=34;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int POINTPOINT=26;
    public static final int T__39=39;
    public static final int GT=16;
    public static final int PLUS=13;
    public static final int PIPE=10;
    public static final int NL=30;
    public static final int DIGIT=32;
    public static final int EQ=18;
    public static final int COMMENT=21;
    public static final int LE=15;
    public static final int STRING=5;
      public com.sap.furcas.runtime.parser.IModelInjector ei = null;
    public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
      /*************** Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
      private void newline() {}

      public final Token emit() {
    	// override emit() to generate own token class
    	ANTLR3LocationToken ret = null;
            ITokenFactory<? extends ANTLR3LocationToken> tokenFactory = getTokenFactory();
            ret = tokenFactory.createToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
        	   ret.setLine(state.tokenStartLine);
            String newtext = input.substring(state.tokenStartCharIndex,getCharIndex()-1);
            ret.setText(newtext); // sets the text as exactly what has been read
            ret.setCharPositionInLine(state.tokenStartCharPositionInLine);
            ret.setEndLine(getLine());
            ret.setEndColumn(getCharPositionInLine());
            emit(ret);
            return ret;
          }
          
          private ITokenFactory<? extends ANTLR3LocationToken> getTokenFactory() {
              if (tokenFactory == null) {
                  tokenFactory = new DefaultANTLR3LocationTokenFactory();
              }
              return tokenFactory;
          }
       /**
         * Unescape string.
         * 
         * @param s the s
         * @param delimLength the delim length
         * 
         * @return the string
         * @deprecated
         */
        public String unescapeString(String s, int delimLength) {
            StringBuilder ret = new StringBuilder();
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
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

          public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
              if (ei != null) {
                  ei.reportError(e);
              } else {
                  super.displayRecognitionError(tokenNames, e);
              }
              
           }
      /*************** End of Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/


    // delegates
    // delegators

    public XPathReducedLexer() {;} 
    public XPathReducedLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XPathReducedLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/XPathReduced.g"; }

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:117:7: ( 'div' )
            // ./scenariotestTemp/generated2/XPathReduced.g:117:9: 'div'
            {
            match("div"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:118:7: ( 'mod' )
            // ./scenariotestTemp/generated2/XPathReduced.g:118:9: 'mod'
            {
            match("mod"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:119:7: ( 'and' )
            // ./scenariotestTemp/generated2/XPathReduced.g:119:9: 'and'
            {
            match("and"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:120:7: ( 'or' )
            // ./scenariotestTemp/generated2/XPathReduced.g:120:9: 'or'
            {
            match("or"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:484:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:485:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:485:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:485:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:485:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:485:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:485:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:485:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // ./scenariotestTemp/generated2/XPathReduced.g:485:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:485:15: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:490:3: ( '$' )
            // ./scenariotestTemp/generated2/XPathReduced.g:491:3: '$'
            {
            match('$'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:496:3: ( '[' )
            // ./scenariotestTemp/generated2/XPathReduced.g:497:3: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:502:3: ( ']' )
            // ./scenariotestTemp/generated2/XPathReduced.g:503:3: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:508:3: ( '(' )
            // ./scenariotestTemp/generated2/XPathReduced.g:509:3: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:514:3: ( ')' )
            // ./scenariotestTemp/generated2/XPathReduced.g:515:3: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "COLONS"
    public final void mCOLONS() throws RecognitionException {
        try {
            int _type = COLONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:520:3: ( '::' )
            // ./scenariotestTemp/generated2/XPathReduced.g:521:3: '::'
            {
            match("::"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLONS"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:526:3: ( '.' )
            // ./scenariotestTemp/generated2/XPathReduced.g:527:3: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POINT"

    // $ANTLR start "POINTPOINT"
    public final void mPOINTPOINT() throws RecognitionException {
        try {
            int _type = POINTPOINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:532:3: ( '..' )
            // ./scenariotestTemp/generated2/XPathReduced.g:533:3: '..'
            {
            match(".."); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POINTPOINT"

    // $ANTLR start "AROBAS"
    public final void mAROBAS() throws RecognitionException {
        try {
            int _type = AROBAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:538:3: ( '@' )
            // ./scenariotestTemp/generated2/XPathReduced.g:539:3: '@'
            {
            match('@'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AROBAS"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:544:3: ( '/' )
            // ./scenariotestTemp/generated2/XPathReduced.g:545:3: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:550:3: ( '|' )
            // ./scenariotestTemp/generated2/XPathReduced.g:551:3: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:556:3: ( '-' )
            // ./scenariotestTemp/generated2/XPathReduced.g:557:3: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:562:3: ( '*' )
            // ./scenariotestTemp/generated2/XPathReduced.g:563:3: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "SLASHSLASH"
    public final void mSLASHSLASH() throws RecognitionException {
        try {
            int _type = SLASHSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:568:3: ( '//' )
            // ./scenariotestTemp/generated2/XPathReduced.g:569:3: '//'
            {
            match("//"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASHSLASH"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:574:3: ( '+' )
            // ./scenariotestTemp/generated2/XPathReduced.g:575:3: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:580:3: ( '=' )
            // ./scenariotestTemp/generated2/XPathReduced.g:581:3: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:586:3: ( '>' )
            // ./scenariotestTemp/generated2/XPathReduced.g:587:3: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:592:3: ( '<' )
            // ./scenariotestTemp/generated2/XPathReduced.g:593:3: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:598:3: ( '>=' )
            // ./scenariotestTemp/generated2/XPathReduced.g:599:3: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:604:3: ( '<=' )
            // ./scenariotestTemp/generated2/XPathReduced.g:605:3: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "EXCLEQ"
    public final void mEXCLEQ() throws RecognitionException {
        try {
            int _type = EXCLEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:610:3: ( '!=' )
            // ./scenariotestTemp/generated2/XPathReduced.g:611:3: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLEQ"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:617:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:617:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:617:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=3;}
            }
            else if ( (LA2_0=='\n') ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2=='\r') ) {
                    alt2=2;
                }
                else {
                    alt2=4;}
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:617:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:618:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:619:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:620:5: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              newline();
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:626:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:626:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:633:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/XPathReduced.g:633:4: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:638:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/XPathReduced.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "SNAME"
    public final void mSNAME() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:649:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/XPathReduced.g:649:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:649:4: ( ALPHA )
            // ./scenariotestTemp/generated2/XPathReduced.g:649:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // ./scenariotestTemp/generated2/XPathReduced.g:649:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "SNAME"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:653:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:653:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:653:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='\"') ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:654:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:655:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/XPathReduced.g:656:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
                    loop4:
                    do {
                        int alt4=4;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( (LA4_0=='\n') ) {
                            alt4=2;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=3;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/XPathReduced.g:656:6: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/XPathReduced.g:657:6: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/XPathReduced.g:658:6: ~ ( '\\\\' | '\\\"' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();
                    	    state.failed=false;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setText(unescapeString(getText(), 1));
                    }

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:666:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/XPathReduced.g:666:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:666:4: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:666:5: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:669:7: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // ./scenariotestTemp/generated2/XPathReduced.g:669:9: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // ./scenariotestTemp/generated2/XPathReduced.g:669:9: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:669:9: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // ./scenariotestTemp/generated2/XPathReduced.g:669:16: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') && (synpred1_XPathReduced())) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:669:17: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/XPathReduced.g:669:34: ( DIGIT )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/XPathReduced.g:669:34: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/XPathReduced.g:673:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/XPathReduced.g:673:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // ./scenariotestTemp/generated2/XPathReduced.g:674:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt14=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt14=1;
                }
                break;
            case 'r':
                {
                alt14=2;
                }
                break;
            case 't':
                {
                alt14=3;
                }
                break;
            case 'b':
                {
                alt14=4;
                }
                break;
            case 'f':
                {
                alt14=5;
                }
                break;
            case '\"':
                {
                alt14=6;
                }
                break;
            case '\'':
                {
                alt14=7;
                }
                break;
            case '\\':
                {
                alt14=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
                {
                alt14=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:674:5: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:675:5: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:676:5: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:677:5: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:678:5: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:679:5: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:680:5: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:681:5: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/XPathReduced.g:682:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/XPathReduced.g:682:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>='0' && LA13_0<='3')) ) {
                        alt13=1;
                    }
                    else if ( ((LA13_0>='4' && LA13_0<='7')) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ./scenariotestTemp/generated2/XPathReduced.g:683:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/XPathReduced.g:683:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/XPathReduced.g:683:6: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/XPathReduced.g:684:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/XPathReduced.g:685:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/XPathReduced.g:685:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/XPathReduced.g:685:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // ./scenariotestTemp/generated2/XPathReduced.g:686:6: ( '0' .. '7' )?
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/XPathReduced.g:687:8: '0' .. '7'
                                            {
                                            matchRange('0','7'); if (state.failed) return ;

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./scenariotestTemp/generated2/XPathReduced.g:690:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/XPathReduced.g:690:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/XPathReduced.g:690:7: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/XPathReduced.g:691:5: ( ( '0' .. '7' ) )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/XPathReduced.g:692:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/XPathReduced.g:692:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/XPathReduced.g:692:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				
                    }

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPathReduced.g:701:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/XPathReduced.g:701:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // ./scenariotestTemp/generated2/XPathReduced.g:702:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
            loop15:
            do {
                int alt15=4;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    alt15=1;
                }
                else if ( (LA15_0=='\n') ) {
                    alt15=2;
                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                    alt15=3;
                }


                switch (alt15) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:702:5: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:703:5: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/XPathReduced.g:704:5: ~ ( '\\\\' | '\\'' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\''); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              setText(unescapeString(getText(), 1));
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // ./scenariotestTemp/generated2/XPathReduced.g:1:8: ( T__36 | T__37 | T__38 | T__39 | COMMENT | DOLLAR | LSQUARE | RSQUARE | LPAREN | RPAREN | COLONS | POINT | POINTPOINT | AROBAS | SLASH | PIPE | MINUS | STAR | SLASHSLASH | PLUS | EQ | GT | LT | GE | LE | EXCLEQ | NL | WS | NAME | INT | FLOAT | STRING )
        int alt16=32;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:10: T__36
                {
                mT__36(); if (state.failed) return ;

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:16: T__37
                {
                mT__37(); if (state.failed) return ;

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:22: T__38
                {
                mT__38(); if (state.failed) return ;

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:28: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:34: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:42: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:49: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:57: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:65: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:72: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:79: COLONS
                {
                mCOLONS(); if (state.failed) return ;

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:86: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:92: POINTPOINT
                {
                mPOINTPOINT(); if (state.failed) return ;

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:103: AROBAS
                {
                mAROBAS(); if (state.failed) return ;

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:110: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:116: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:121: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:127: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:132: SLASHSLASH
                {
                mSLASHSLASH(); if (state.failed) return ;

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:143: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:148: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:151: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:154: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:157: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:160: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:163: EXCLEQ
                {
                mEXCLEQ(); if (state.failed) return ;

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:170: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:173: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:176: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:181: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:185: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/XPathReduced.g:1:191: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_XPathReduced
    public final void synpred1_XPathReduced_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPathReduced.g:669:17: ( '.' DIGIT )
        // ./scenariotestTemp/generated2/XPathReduced.g:669:18: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_XPathReduced

    public final boolean synpred1_XPathReduced() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_XPathReduced_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\4\30\1\40\6\uffff\1\42\1\uffff\1\44\4\uffff\1\46\1\50\4"+
        "\uffff\1\51\1\uffff\3\30\1\56\14\uffff\1\57\1\60\1\61\4\uffff";
    static final String DFA16_eofS =
        "\62\uffff";
    static final String DFA16_minS =
        "\1\11\1\151\1\157\1\156\1\162\1\55\6\uffff\1\56\1\uffff\1\57\4\uffff"+
        "\2\75\4\uffff\1\56\1\uffff\1\166\2\144\1\60\14\uffff\3\60\4\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\151\1\157\1\156\1\162\1\55\6\uffff\1\56\1\uffff\1\57"+
        "\4\uffff\2\75\4\uffff\1\71\1\uffff\1\166\2\144\1\u00ff\14\uffff"+
        "\3\u00ff\4\uffff";
    static final String DFA16_acceptS =
        "\6\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff\1\16\1\uffff\1\20\1"+
        "\22\1\24\1\25\2\uffff\1\32\1\33\1\34\1\35\1\uffff\1\40\4\uffff\1"+
        "\5\1\21\1\15\1\14\1\23\1\17\1\30\1\26\1\31\1\27\1\36\1\37\3\uffff"+
        "\1\4\1\1\1\2\1\3";
    static final String DFA16_specialS =
        "\62\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\27\1\26\2\uffff\1\26\22\uffff\1\27\1\25\1\30\1\uffff\1\6"+
            "\2\uffff\1\32\1\11\1\12\1\20\1\21\1\uffff\1\5\1\14\1\16\12\31"+
            "\1\13\1\uffff\1\24\1\22\1\23\1\uffff\1\15\32\30\1\7\1\uffff"+
            "\1\10\1\uffff\1\30\1\uffff\1\3\2\30\1\1\10\30\1\2\1\30\1\4\13"+
            "\30\1\uffff\1\17\103\uffff\27\30\1\uffff\37\30\1\uffff\10\30",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\41",
            "",
            "\1\43",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\47",
            "",
            "",
            "",
            "",
            "\1\52\1\uffff\12\31",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\105\uffff\27"+
            "\30\1\uffff\37\30\1\uffff\10\30",
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
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\105\uffff\27"+
            "\30\1\uffff\37\30\1\uffff\10\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\105\uffff\27"+
            "\30\1\uffff\37\30\1\uffff\10\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30\105\uffff\27"+
            "\30\1\uffff\37\30\1\uffff\10\30",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__36 | T__37 | T__38 | T__39 | COMMENT | DOLLAR | LSQUARE | RSQUARE | LPAREN | RPAREN | COLONS | POINT | POINTPOINT | AROBAS | SLASH | PIPE | MINUS | STAR | SLASHSLASH | PLUS | EQ | GT | LT | GE | LE | EXCLEQ | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}