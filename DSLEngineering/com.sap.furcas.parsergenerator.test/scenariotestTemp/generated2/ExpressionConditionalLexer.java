// $ANTLR 3.1.1 ./scenariotestTemp/generated2/ExpressionConditional.g 2010-11-04 23:29:47

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

public class ExpressionConditionalLexer extends Lexer {
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ESC=18;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=11;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int COMA=6;
    public static final int ALPHA=16;
    public static final int LPAREN=7;
    public static final int RPAREN=8;
    public static final int NAME=4;
    public static final int WS=14;
    public static final int SNAME=17;
    public static final int RCURLY=12;
    public static final int PLUS=9;
    public static final int NL=13;
    public static final int DIGIT=15;
    public static final int COMMENT=10;
    public static final int STRING=19;
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

    public ExpressionConditionalLexer() {;} 
    public ExpressionConditionalLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExpressionConditionalLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/ExpressionConditional.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:117:7: ( 'fourty-two' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:117:9: 'fourty-two'
            {
            match("fourty-two"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:118:7: ( 'noInt' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:118:9: 'noInt'
            {
            match("noInt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:119:7: ( 'Hello' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:119:9: 'Hello'
            {
            match("Hello"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:120:7: ( 'Bye' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:120:9: 'Bye'
            {
            match("Bye"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:121:7: ( 'trueS' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:121:9: 'trueS'
            {
            match("trueS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:122:7: ( 'falseS' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:122:9: 'falseS'
            {
            match("falseS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:123:7: ( '-twelve' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:123:9: '-twelve'
            {
            match("-twelve"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:124:7: ( 'nothing' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:124:9: 'nothing'
            {
            match("nothing"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:371:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ./scenariotestTemp/generated2/ExpressionConditional.g:372:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:372:15: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
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

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:377:3: ( ',' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:378:3: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:383:3: ( '(' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:384:3: '('
            {
            match('('); 

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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:389:3: ( ')' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:390:3: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:395:3: ( '{' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:396:3: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:401:3: ( '}' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:402:3: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:407:3: ( '+' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:408:3: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:416:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:416:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:416:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:416:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:417:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:418:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:419:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

            newline();

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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:425:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:425:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:432:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:432:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:436:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:436:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:436:4: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:436:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:441:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:452:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:452:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:452:4: ( ALPHA )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:452:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/ExpressionConditional.g:452:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:456:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:456:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:456:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u00FF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\"') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:457:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:458:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:459:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
                    loop5:
                    do {
                        int alt5=4;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( (LA5_0=='\n') ) {
                            alt5=2;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=3;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:459:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:460:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:461:6: ~ ( '\\\\' | '\\\"' | '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

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

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:469:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:469:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/ExpressionConditional.g:470:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt11=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt11=1;
                }
                break;
            case 'r':
                {
                alt11=2;
                }
                break;
            case 't':
                {
                alt11=3;
                }
                break;
            case 'b':
                {
                alt11=4;
                }
                break;
            case 'f':
                {
                alt11=5;
                }
                break;
            case '\"':
                {
                alt11=6;
                }
                break;
            case '\'':
                {
                alt11=7;
                }
                break;
            case '\\':
                {
                alt11=8;
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
                alt11=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:470:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:471:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:472:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:473:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:474:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:475:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:476:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:477:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:478:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:478:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>='0' && LA10_0<='3')) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_0>='4' && LA10_0<='7')) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:479:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:479:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:479:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/ExpressionConditional.g:480:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( ((LA8_0>='0' && LA8_0<='7')) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:481:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:481:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:481:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:482:6: ( '0' .. '7' )?
                                    int alt7=2;
                                    int LA7_0 = input.LA(1);

                                    if ( ((LA7_0>='0' && LA7_0<='7')) ) {
                                        alt7=1;
                                    }
                                    switch (alt7) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/ExpressionConditional.g:483:8: '0' .. '7'
                                            {
                                            matchRange('0','7'); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:486:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:486:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/ExpressionConditional.g:486:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/ExpressionConditional.g:487:5: ( ( '0' .. '7' ) )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:488:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:488:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/ExpressionConditional.g:488:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }


                                    }
                                    break;

                            }


                            }
                            break;

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
            // ./scenariotestTemp/generated2/ExpressionConditional.g:497:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:497:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/ExpressionConditional.g:498:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
            loop12:
            do {
                int alt12=4;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    alt12=1;
                }
                else if ( (LA12_0=='\n') ) {
                    alt12=2;
                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                    alt12=3;
                }


                switch (alt12) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:498:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:499:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:500:5: ~ ( '\\\\' | '\\'' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match('\''); 
            setText(unescapeString(getText(), 1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // ./scenariotestTemp/generated2/ExpressionConditional.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | COMMENT | COMA | LPAREN | RPAREN | LCURLY | RCURLY | PLUS | NL | WS | INT | NAME | STRING )
        int alt13=20;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:58: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:66: COMA
                {
                mCOMA(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:71: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:78: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:85: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:92: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:99: PLUS
                {
                mPLUS(); 

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:104: NL
                {
                mNL(); 

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:107: WS
                {
                mWS(); 

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:110: INT
                {
                mINT(); 

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:114: NAME
                {
                mNAME(); 

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/ExpressionConditional.g:1:119: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\5\20\14\uffff\6\20\2\uffff\5\20\1\46\6\20\1\uffff\3\20"+
        "\1\60\1\20\1\62\1\63\1\20\1\65\1\uffff\1\20\4\uffff\1\67\1\uffff";
    static final String DFA13_eofS =
        "\70\uffff";
    static final String DFA13_minS =
        "\1\11\1\141\1\157\1\145\1\171\1\162\1\55\13\uffff\1\165\1\154\1"+
        "\111\1\154\1\145\1\165\2\uffff\1\162\1\163\1\156\1\150\1\154\1\60"+
        "\1\145\1\164\1\145\1\164\1\151\1\157\1\uffff\1\123\1\171\1\123\1"+
        "\60\1\156\2\60\1\55\1\60\1\uffff\1\147\4\uffff\1\60\1\uffff";
    static final String DFA13_maxS =
        "\1\u00ff\2\157\1\145\1\171\1\162\1\164\13\uffff\1\165\1\154\1\164"+
        "\1\154\1\145\1\165\2\uffff\1\162\1\163\1\156\1\150\1\154\1\u00ff"+
        "\1\145\1\164\1\145\1\164\1\151\1\157\1\uffff\1\123\1\171\1\123\1"+
        "\u00ff\1\156\2\u00ff\1\55\1\u00ff\1\uffff\1\147\4\uffff\1\u00ff"+
        "\1\uffff";
    static final String DFA13_acceptS =
        "\7\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
        "\6\uffff\1\7\1\11\14\uffff\1\4\11\uffff\1\2\1\uffff\1\3\1\5\1\1"+
        "\1\6\1\uffff\1\10";
    static final String DFA13_specialS =
        "\70\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\16\1\15\2\uffff\1\15\22\uffff\1\16\1\uffff\1\20\4\uffff\1"+
            "\21\1\10\1\11\1\uffff\1\14\1\7\1\6\2\uffff\12\17\7\uffff\1\20"+
            "\1\4\5\20\1\3\22\20\4\uffff\1\20\1\uffff\5\20\1\1\7\20\1\2\5"+
            "\20\1\5\6\20\1\12\1\uffff\1\13\102\uffff\27\20\1\uffff\37\20"+
            "\1\uffff\10\20",
            "\1\23\15\uffff\1\22",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\31\106\uffff\1\30",
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
            "\1\32",
            "\1\33",
            "\1\34\52\uffff\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            "\1\61",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            "\1\64",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            "",
            "\1\66",
            "",
            "",
            "",
            "",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20\105\uffff\27"+
            "\20\1\uffff\37\20\1\uffff\10\20",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | COMMENT | COMA | LPAREN | RPAREN | LCURLY | RCURLY | PLUS | NL | WS | INT | NAME | STRING );";
        }
    }
 

}