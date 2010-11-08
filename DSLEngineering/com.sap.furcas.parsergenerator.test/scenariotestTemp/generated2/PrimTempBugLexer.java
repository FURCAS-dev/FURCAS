// $ANTLR 3.1.1 ./scenariotestTemp/generated2/PrimTempBug.g 2010-11-04 23:30:59

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

public class PrimTempBugLexer extends Lexer {
    public static final int ESC=18;
    public static final int LCURLY=11;
    public static final int INT=5;
    public static final int COMA=6;
    public static final int EOF=-1;
    public static final int LPAREN=7;
    public static final int ALPHA=16;
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

    public PrimTempBugLexer() {;} 
    public PrimTempBugLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PrimTempBugLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/PrimTempBug.g"; }

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/PrimTempBug.g:357:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/PrimTempBug.g:358:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ./scenariotestTemp/generated2/PrimTempBug.g:358:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:358:15: ~ ( '\\r' | '\\n' )
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:363:3: ( ',' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:364:3: ','
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:369:3: ( '(' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:370:3: '('
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:375:3: ( ')' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:376:3: ')'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:381:3: ( '{' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:382:3: '{'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:387:3: ( '}' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:388:3: '}'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:393:3: ( '+' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:394:3: '+'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:402:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:402:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:402:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/PrimTempBug.g:402:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:403:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:404:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:405:5: '\\n'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:411:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:411:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:418:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:418:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:422:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/PrimTempBug.g:422:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:422:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:422:5: DIGIT
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:427:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:438:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/PrimTempBug.g:438:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:438:4: ( ALPHA )
            // ./scenariotestTemp/generated2/PrimTempBug.g:438:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/PrimTempBug.g:438:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:442:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:442:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:442:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    // ./scenariotestTemp/generated2/PrimTempBug.g:443:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:444:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/PrimTempBug.g:445:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:445:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:446:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:447:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:455:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:455:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/PrimTempBug.g:456:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // ./scenariotestTemp/generated2/PrimTempBug.g:456:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:457:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:458:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:459:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:460:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:461:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:462:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:463:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:464:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/PrimTempBug.g:464:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // ./scenariotestTemp/generated2/PrimTempBug.g:465:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/PrimTempBug.g:465:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/PrimTempBug.g:465:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/PrimTempBug.g:466:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( ((LA8_0>='0' && LA8_0<='7')) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:467:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:467:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:467:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/PrimTempBug.g:468:6: ( '0' .. '7' )?
                                    int alt7=2;
                                    int LA7_0 = input.LA(1);

                                    if ( ((LA7_0>='0' && LA7_0<='7')) ) {
                                        alt7=1;
                                    }
                                    switch (alt7) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/PrimTempBug.g:469:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/PrimTempBug.g:472:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/PrimTempBug.g:472:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/PrimTempBug.g:472:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/PrimTempBug.g:473:5: ( ( '0' .. '7' ) )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:474:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:474:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/PrimTempBug.g:474:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/PrimTempBug.g:483:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/PrimTempBug.g:483:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/PrimTempBug.g:484:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:484:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:485:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:486:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
        // ./scenariotestTemp/generated2/PrimTempBug.g:1:8: ( COMMENT | COMA | LPAREN | RPAREN | LCURLY | RCURLY | PLUS | NL | WS | INT | NAME | STRING )
        int alt13=12;
        switch ( input.LA(1) ) {
        case '-':
            {
            alt13=1;
            }
            break;
        case ',':
            {
            alt13=2;
            }
            break;
        case '(':
            {
            alt13=3;
            }
            break;
        case ')':
            {
            alt13=4;
            }
            break;
        case '{':
            {
            alt13=5;
            }
            break;
        case '}':
            {
            alt13=6;
            }
            break;
        case '+':
            {
            alt13=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt13=8;
            }
            break;
        case '\t':
        case ' ':
            {
            alt13=9;
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
        case '8':
        case '9':
            {
            alt13=10;
            }
            break;
        case '\"':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
        case '\u00C0':
        case '\u00C1':
        case '\u00C2':
        case '\u00C3':
        case '\u00C4':
        case '\u00C5':
        case '\u00C6':
        case '\u00C7':
        case '\u00C8':
        case '\u00C9':
        case '\u00CA':
        case '\u00CB':
        case '\u00CC':
        case '\u00CD':
        case '\u00CE':
        case '\u00CF':
        case '\u00D0':
        case '\u00D1':
        case '\u00D2':
        case '\u00D3':
        case '\u00D4':
        case '\u00D5':
        case '\u00D6':
        case '\u00D8':
        case '\u00D9':
        case '\u00DA':
        case '\u00DB':
        case '\u00DC':
        case '\u00DD':
        case '\u00DE':
        case '\u00DF':
        case '\u00E0':
        case '\u00E1':
        case '\u00E2':
        case '\u00E3':
        case '\u00E4':
        case '\u00E5':
        case '\u00E6':
        case '\u00E7':
        case '\u00E8':
        case '\u00E9':
        case '\u00EA':
        case '\u00EB':
        case '\u00EC':
        case '\u00ED':
        case '\u00EE':
        case '\u00EF':
        case '\u00F0':
        case '\u00F1':
        case '\u00F2':
        case '\u00F3':
        case '\u00F4':
        case '\u00F5':
        case '\u00F6':
        case '\u00F8':
        case '\u00F9':
        case '\u00FA':
        case '\u00FB':
        case '\u00FC':
        case '\u00FD':
        case '\u00FE':
        case '\u00FF':
            {
            alt13=11;
            }
            break;
        case '\'':
            {
            alt13=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 13, 0, input);

            throw nvae;
        }

        switch (alt13) {
            case 1 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:10: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:18: COMA
                {
                mCOMA(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:23: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:30: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:37: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:44: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:51: PLUS
                {
                mPLUS(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:56: NL
                {
                mNL(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:59: WS
                {
                mWS(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:62: INT
                {
                mINT(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:66: NAME
                {
                mNAME(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/PrimTempBug.g:1:71: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


 

}