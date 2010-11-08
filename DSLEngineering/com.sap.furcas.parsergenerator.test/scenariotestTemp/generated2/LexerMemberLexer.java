// $ANTLR 3.1.1 ./scenariotestTemp/generated2/LexerMember.g 2010-11-04 23:30:47

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

public class LexerMemberLexer extends Lexer {
    public static final int T__20=20;
    public static final int BOOL=11;
    public static final int FLOAT=17;
    public static final int INT=14;
    public static final int EOF=-1;
    public static final int ALPHA=9;
    public static final int LBRACKET=15;
    public static final int NAME=4;
    public static final int WS=7;
    public static final int SNAME=10;
    public static final int OBJECT=12;
    public static final int NL=6;
    public static final int DIGIT=8;
    public static final int BINARY=13;
    public static final int RBRACKET=16;
    public static final int COMMENT=5;
    public static final int DATE=18;
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


        boolean noFloatMode = false;


    // delegates
    // delegators

    public LexerMemberLexer() {;} 
    public LexerMemberLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LexerMemberLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/LexerMember.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:120:7: ( 'test' )
            // ./scenariotestTemp/generated2/LexerMember.g:120:9: 'test'
            {
            match("test"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:244:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/LexerMember.g:245:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:245:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/LexerMember.g:245:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:245:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/LexerMember.g:245:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:245:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/LexerMember.g:245:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ./scenariotestTemp/generated2/LexerMember.g:245:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:245:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:256:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/LexerMember.g:256:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:256:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/LexerMember.g:256:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LexerMember.g:257:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LexerMember.g:258:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LexerMember.g:259:5: '\\n'
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
            // ./scenariotestTemp/generated2/LexerMember.g:265:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/LexerMember.g:265:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/LexerMember.g:272:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/LexerMember.g:272:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/LexerMember.g:277:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/LexerMember.g:
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
            // ./scenariotestTemp/generated2/LexerMember.g:288:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/LexerMember.g:288:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/LexerMember.g:288:4: ( ALPHA )
            // ./scenariotestTemp/generated2/LexerMember.g:288:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/LexerMember.g:288:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:
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
            	    break loop3;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "SNAME"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:291:6: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/LexerMember.g:291:8: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LexerMember.g:291:17: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "OBJECT"
    public final void mOBJECT() throws RecognitionException {
        try {
            int _type = OBJECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:293:8: ( 'o:' )
            // ./scenariotestTemp/generated2/LexerMember.g:293:10: 'o:'
            {
            match("o:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OBJECT"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:296:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // ./scenariotestTemp/generated2/LexerMember.g:296:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:296:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u00FF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./scenariotestTemp/generated2/LexerMember.g:297:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LexerMember.g:298:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); 
                    // ./scenariotestTemp/generated2/LexerMember.g:299:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\n') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LexerMember.g:301:4: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/LexerMember.g:302:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 
                    setText(unescapeString(getText(), 1));

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

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:310:2: ( '0x' ( DIGIT )+ )
            // ./scenariotestTemp/generated2/LexerMember.g:310:4: '0x' ( DIGIT )+
            {
            match("0x"); 

            // ./scenariotestTemp/generated2/LexerMember.g:310:8: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/LexerMember.g:310:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BINARY"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:314:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/LexerMember.g:314:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/LexerMember.g:314:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/LexerMember.g:314:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:318:2: ( '[' )
            // ./scenariotestTemp/generated2/LexerMember.g:318:4: '['
            {
            match('['); 
             noFloatMode = true; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:322:2: ( ']' )
            // ./scenariotestTemp/generated2/LexerMember.g:322:4: ']'
            {
            match(']'); 
             noFloatMode = false; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:325:7: ({...}? => ( DIGIT )+ '.' ( DIGIT )* )
            // ./scenariotestTemp/generated2/LexerMember.g:325:9: {...}? => ( DIGIT )+ '.' ( DIGIT )*
            {
            if ( !((!noFloatMode)) ) {
                throw new FailedPredicateException(input, "FLOAT", "!noFloatMode");
            }
            // ./scenariotestTemp/generated2/LexerMember.g:325:26: ( DIGIT )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:325:26: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            match('.'); 
            // ./scenariotestTemp/generated2/LexerMember.g:325:37: ( DIGIT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:325:37: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:329:6: ( DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT DIGIT DIGIT )
            // ./scenariotestTemp/generated2/LexerMember.g:329:8: DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT DIGIT DIGIT
            {
            mDIGIT(); 
            mDIGIT(); 
            match(':'); 
            mDIGIT(); 
            mDIGIT(); 
            match(':'); 
            mDIGIT(); 
            mDIGIT(); 
            mDIGIT(); 
            mDIGIT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LexerMember.g:332:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // ./scenariotestTemp/generated2/LexerMember.g:332:4: '\"' ( '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // ./scenariotestTemp/generated2/LexerMember.g:333:3: ( '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\n') ) {
                    alt11=1;
                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:335:4: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/LexerMember.g:336:5: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            	    break loop11;
                }
            } while (true);

            match('\"'); 
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
        // ./scenariotestTemp/generated2/LexerMember.g:1:8: ( T__20 | COMMENT | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | LBRACKET | RBRACKET | FLOAT | DATE | STRING )
        int alt12=14;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:16: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:24: NL
                {
                mNL(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:27: WS
                {
                mWS(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:30: BOOL
                {
                mBOOL(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:35: OBJECT
                {
                mOBJECT(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:42: NAME
                {
                mNAME(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:47: BINARY
                {
                mBINARY(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:54: INT
                {
                mINT(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:58: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:67: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:76: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:82: DATE
                {
                mDATE(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/LexerMember.g:1:87: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\7\3\uffff\2\7\1\uffff\2\22\3\uffff\3\7\3\uffff\1\22\1"+
        "\uffff\3\7\1\22\1\uffff\1\35\1\36\1\7\2\uffff\1\36";
    static final String DFA12_eofS =
        "\40\uffff";
    static final String DFA12_minS =
        "\1\11\1\145\3\uffff\1\141\1\72\1\uffff\2\56\3\uffff\1\163\1\165"+
        "\1\154\3\uffff\1\56\1\uffff\1\164\1\145\1\163\1\56\1\uffff\2\60"+
        "\1\145\2\uffff\1\60";
    static final String DFA12_maxS =
        "\1\u00ff\1\162\3\uffff\1\141\1\72\1\uffff\1\170\1\71\3\uffff\1\163"+
        "\1\165\1\154\3\uffff\1\72\1\uffff\1\164\1\145\1\163\1\71\1\uffff"+
        "\2\u00ff\1\145\2\uffff\1\u00ff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\3\1\4\2\uffff\1\7\2\uffff\1\12\1\13\1\16\3\uffff"+
        "\1\6\1\10\1\11\1\uffff\1\14\4\uffff\1\15\3\uffff\1\1\1\5\1\uffff";
    static final String DFA12_specialS =
        "\10\uffff\1\3\1\0\11\uffff\1\1\4\uffff\1\2\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\4\1\3\2\uffff\1\3\22\uffff\1\4\1\uffff\1\14\4\uffff\1\7\5"+
            "\uffff\1\2\2\uffff\1\10\11\11\7\uffff\32\7\1\12\1\uffff\1\13"+
            "\1\uffff\1\7\1\uffff\5\7\1\5\10\7\1\6\4\7\1\1\6\7\105\uffff"+
            "\27\7\1\uffff\37\7\1\uffff\10\7",
            "\1\15\14\uffff\1\16",
            "",
            "",
            "",
            "\1\17",
            "\1\20",
            "",
            "\1\24\1\uffff\12\23\76\uffff\1\21",
            "\1\24\1\uffff\12\23",
            "",
            "",
            "",
            "\1\25",
            "\1\26",
            "\1\27",
            "",
            "",
            "",
            "\1\24\1\uffff\12\30\1\31",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\24\1\uffff\12\30",
            "",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7\105\uffff\27\7"+
            "\1\uffff\37\7\1\uffff\10\7",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7\105\uffff\27\7"+
            "\1\uffff\37\7\1\uffff\10\7",
            "\1\37",
            "",
            "",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7\105\uffff\27\7"+
            "\1\uffff\37\7\1\uffff\10\7"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | COMMENT | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | LBRACKET | RBRACKET | FLOAT | DATE | STRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_9 = input.LA(1);

                         
                        int index12_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA12_9>='0' && LA12_9<='9')) ) {s = 19;}

                        else if ( (LA12_9=='.') && ((!noFloatMode))) {s = 20;}

                        else s = 18;

                         
                        input.seek(index12_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_19 = input.LA(1);

                         
                        int index12_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA12_19>='0' && LA12_19<='9')) ) {s = 24;}

                        else if ( (LA12_19=='.') && ((!noFloatMode))) {s = 20;}

                        else if ( (LA12_19==':') ) {s = 25;}

                        else s = 18;

                         
                        input.seek(index12_19);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_24 = input.LA(1);

                         
                        int index12_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA12_24>='0' && LA12_24<='9')) ) {s = 24;}

                        else if ( (LA12_24=='.') && ((!noFloatMode))) {s = 20;}

                        else s = 18;

                         
                        input.seek(index12_24);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_8 = input.LA(1);

                         
                        int index12_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_8=='x') ) {s = 17;}

                        else if ( ((LA12_8>='0' && LA12_8<='9')) ) {s = 19;}

                        else if ( (LA12_8=='.') && ((!noFloatMode))) {s = 20;}

                        else s = 18;

                         
                        input.seek(index12_8);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}