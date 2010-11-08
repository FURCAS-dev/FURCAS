// $ANTLR 3.1.1 ./scenariotestTemp/generated2/SQLDDL.g 2010-11-04 23:27:47

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
public class SQLDDLLexer extends Lexer {
    public static final int LT=31;
    public static final int STAR=27;
    public static final int LSQUARE=14;
    public static final int POINT=24;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int EXCL=16;
    public static final int FLOAT=7;
    public static final int EOF=-1;
    public static final int LPAREN=8;
    public static final int COLONS=20;
    public static final int RPAREN=10;
    public static final int NAME=4;
    public static final int SLASH=28;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int PIPE=21;
    public static final int PLUS=29;
    public static final int DIGIT=38;
    public static final int NL=36;
    public static final int EQ=12;
    public static final int COMMENT=13;
    public static final int T__50=50;
    public static final int NE=34;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int GE=32;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int SHARP=22;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=25;
    public static final int LCURLY=17;
    public static final int INT=6;
    public static final int RSQUARE=15;
    public static final int MINUS=26;
    public static final int COMA=9;
    public static final int SEMI=11;
    public static final int ALPHA=39;
    public static final int COLON=19;
    public static final int WS=37;
    public static final int SNAME=40;
    public static final int RCURLY=18;
    public static final int GT=30;
    public static final int QMARK=23;
    public static final int LE=33;
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

    public SQLDDLLexer() {;} 
    public SQLDDLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQLDDLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/SQLDDL.g"; }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:117:7: ( 'CREATE' )
            // ./scenariotestTemp/generated2/SQLDDL.g:117:9: 'CREATE'
            {
            match("CREATE"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:118:7: ( 'TABLE' )
            // ./scenariotestTemp/generated2/SQLDDL.g:118:9: 'TABLE'
            {
            match("TABLE"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:119:7: ( 'NOT' )
            // ./scenariotestTemp/generated2/SQLDDL.g:119:9: 'NOT'
            {
            match("NOT"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:120:7: ( 'NULL' )
            // ./scenariotestTemp/generated2/SQLDDL.g:120:9: 'NULL'
            {
            match("NULL"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:121:7: ( 'default' )
            // ./scenariotestTemp/generated2/SQLDDL.g:121:9: 'default'
            {
            match("default"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:122:7: ( 'UNIQUE' )
            // ./scenariotestTemp/generated2/SQLDDL.g:122:9: 'UNIQUE'
            {
            match("UNIQUE"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:123:7: ( 'KEY' )
            // ./scenariotestTemp/generated2/SQLDDL.g:123:9: 'KEY'
            {
            match("KEY"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:124:7: ( 'PRIMARY' )
            // ./scenariotestTemp/generated2/SQLDDL.g:124:9: 'PRIMARY'
            {
            match("PRIMARY"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:125:7: ( 'FOREIGN' )
            // ./scenariotestTemp/generated2/SQLDDL.g:125:9: 'FOREIGN'
            {
            match("FOREIGN"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:126:7: ( 'REFERENCES' )
            // ./scenariotestTemp/generated2/SQLDDL.g:126:9: 'REFERENCES'
            {
            match("REFERENCES"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:127:7: ( 'unsigned' )
            // ./scenariotestTemp/generated2/SQLDDL.g:127:9: 'unsigned'
            {
            match("unsigned"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:454:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:455:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:455:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:455:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:455:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:455:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:455:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:455:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // ./scenariotestTemp/generated2/SQLDDL.g:455:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:455:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:460:3: ( '[' )
            // ./scenariotestTemp/generated2/SQLDDL.g:461:3: '['
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
            // ./scenariotestTemp/generated2/SQLDDL.g:466:3: ( ']' )
            // ./scenariotestTemp/generated2/SQLDDL.g:467:3: ']'
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

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:472:3: ( '!' )
            // ./scenariotestTemp/generated2/SQLDDL.g:473:3: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCL"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:478:3: ( ',' )
            // ./scenariotestTemp/generated2/SQLDDL.g:479:3: ','
            {
            match(','); if (state.failed) return ;

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
            // ./scenariotestTemp/generated2/SQLDDL.g:484:3: ( '(' )
            // ./scenariotestTemp/generated2/SQLDDL.g:485:3: '('
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
            // ./scenariotestTemp/generated2/SQLDDL.g:490:3: ( ')' )
            // ./scenariotestTemp/generated2/SQLDDL.g:491:3: ')'
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

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:496:3: ( '{' )
            // ./scenariotestTemp/generated2/SQLDDL.g:497:3: '{'
            {
            match('{'); if (state.failed) return ;

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
            // ./scenariotestTemp/generated2/SQLDDL.g:502:3: ( '}' )
            // ./scenariotestTemp/generated2/SQLDDL.g:503:3: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:508:3: ( ';' )
            // ./scenariotestTemp/generated2/SQLDDL.g:509:3: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:514:3: ( ':' )
            // ./scenariotestTemp/generated2/SQLDDL.g:515:3: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COLONS"
    public final void mCOLONS() throws RecognitionException {
        try {
            int _type = COLONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:520:3: ( '::' )
            // ./scenariotestTemp/generated2/SQLDDL.g:521:3: '::'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:526:3: ( '|' )
            // ./scenariotestTemp/generated2/SQLDDL.g:527:3: '|'
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

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:532:3: ( '#' )
            // ./scenariotestTemp/generated2/SQLDDL.g:533:3: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHARP"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:538:3: ( '?' )
            // ./scenariotestTemp/generated2/SQLDDL.g:539:3: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:544:3: ( '.' )
            // ./scenariotestTemp/generated2/SQLDDL.g:545:3: '.'
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

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:550:3: ( '->' )
            // ./scenariotestTemp/generated2/SQLDDL.g:551:3: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RARROW"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:556:3: ( '-' )
            // ./scenariotestTemp/generated2/SQLDDL.g:557:3: '-'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:562:3: ( '*' )
            // ./scenariotestTemp/generated2/SQLDDL.g:563:3: '*'
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

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:568:3: ( '/' )
            // ./scenariotestTemp/generated2/SQLDDL.g:569:3: '/'
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

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:574:3: ( '+' )
            // ./scenariotestTemp/generated2/SQLDDL.g:575:3: '+'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:580:3: ( '=' )
            // ./scenariotestTemp/generated2/SQLDDL.g:581:3: '='
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
            // ./scenariotestTemp/generated2/SQLDDL.g:586:3: ( '>' )
            // ./scenariotestTemp/generated2/SQLDDL.g:587:3: '>'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:592:3: ( '<' )
            // ./scenariotestTemp/generated2/SQLDDL.g:593:3: '<'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:598:3: ( '>=' )
            // ./scenariotestTemp/generated2/SQLDDL.g:599:3: '>='
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
            // ./scenariotestTemp/generated2/SQLDDL.g:604:3: ( '<=' )
            // ./scenariotestTemp/generated2/SQLDDL.g:605:3: '<='
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

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:610:3: ( '<>' )
            // ./scenariotestTemp/generated2/SQLDDL.g:611:3: '<>'
            {
            match("<>"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "LARROW"
    public final void mLARROW() throws RecognitionException {
        try {
            int _type = LARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:616:3: ( '<-' )
            // ./scenariotestTemp/generated2/SQLDDL.g:617:3: '<-'
            {
            match("<-"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LARROW"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/SQLDDL.g:624:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:624:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:624:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/SQLDDL.g:624:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:625:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:626:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:627:5: '\\n'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:633:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:633:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/SQLDDL.g:640:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/SQLDDL.g:640:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:645:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/SQLDDL.g:
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
            // ./scenariotestTemp/generated2/SQLDDL.g:659:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:659:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:659:4: ( ALPHA )
            // ./scenariotestTemp/generated2/SQLDDL.g:659:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // ./scenariotestTemp/generated2/SQLDDL.g:659:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:
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
            // ./scenariotestTemp/generated2/SQLDDL.g:663:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:663:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:663:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    // ./scenariotestTemp/generated2/SQLDDL.g:664:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:666:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/SQLDDL.g:667:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:667:6: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:668:6: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:669:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            // ./scenariotestTemp/generated2/SQLDDL.g:677:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/SQLDDL.g:677:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:677:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/SQLDDL.g:677:5: DIGIT
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
            // ./scenariotestTemp/generated2/SQLDDL.g:681:7: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // ./scenariotestTemp/generated2/SQLDDL.g:681:9: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:681:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/SQLDDL.g:681:9: DIGIT
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

            // ./scenariotestTemp/generated2/SQLDDL.g:681:16: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') && (synpred1_SQLDDL())) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:681:17: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/SQLDDL.g:681:34: ( DIGIT )+
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
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:681:34: DIGIT
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
            // ./scenariotestTemp/generated2/SQLDDL.g:685:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:685:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // ./scenariotestTemp/generated2/SQLDDL.g:686:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // ./scenariotestTemp/generated2/SQLDDL.g:686:5: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:687:5: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:688:5: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:689:5: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:690:5: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:691:5: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:692:5: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:693:5: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:694:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/SQLDDL.g:694:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // ./scenariotestTemp/generated2/SQLDDL.g:695:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/SQLDDL.g:695:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/SQLDDL.g:695:6: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/SQLDDL.g:696:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/SQLDDL.g:700:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/SQLDDL.g:700:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/SQLDDL.g:700:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // ./scenariotestTemp/generated2/SQLDDL.g:701:6: ( '0' .. '7' )?
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/SQLDDL.g:705:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/SQLDDL.g:708:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/SQLDDL.g:708:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/SQLDDL.g:708:7: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/SQLDDL.g:709:5: ( ( '0' .. '7' ) )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/SQLDDL.g:713:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/SQLDDL.g:713:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/SQLDDL.g:713:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/SQLDDL.g:730:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/SQLDDL.g:730:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // ./scenariotestTemp/generated2/SQLDDL.g:731:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // ./scenariotestTemp/generated2/SQLDDL.g:731:5: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:732:5: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:733:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
        // ./scenariotestTemp/generated2/SQLDDL.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONS | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt16=45;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:10: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:16: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:22: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:28: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:34: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:40: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:46: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:52: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:58: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:64: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:70: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:76: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:84: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:92: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:100: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:105: COMA
                {
                mCOMA(); if (state.failed) return ;

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:110: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:117: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:124: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:131: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:138: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:143: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:149: COLONS
                {
                mCOLONS(); if (state.failed) return ;

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:156: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:161: SHARP
                {
                mSHARP(); if (state.failed) return ;

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:167: QMARK
                {
                mQMARK(); if (state.failed) return ;

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:173: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:179: RARROW
                {
                mRARROW(); if (state.failed) return ;

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:186: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:192: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:197: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:203: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:208: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:211: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:214: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:217: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:220: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:223: NE
                {
                mNE(); if (state.failed) return ;

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:226: LARROW
                {
                mLARROW(); if (state.failed) return ;

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:233: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:236: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:239: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:244: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:248: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/SQLDDL.g:1:254: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_SQLDDL
    public final void synpred1_SQLDDL_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/SQLDDL.g:681:17: ( '.' DIGIT )
        // ./scenariotestTemp/generated2/SQLDDL.g:681:18: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_SQLDDL

    public final boolean synpred1_SQLDDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_SQLDDL_fragment(); // can never throw exception
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
        "\1\uffff\12\42\1\62\11\uffff\1\64\10\uffff\1\66\1\72\3\uffff\1\73"+
        "\1\uffff\13\42\15\uffff\2\42\1\112\3\42\1\116\6\42\1\uffff\1\125"+
        "\2\42\1\uffff\5\42\1\135\1\uffff\6\42\1\144\1\uffff\1\42\1\146\4"+
        "\42\1\uffff\1\153\1\uffff\1\154\1\155\2\42\3\uffff\1\42\1\161\1"+
        "\42\1\uffff\1\163\1\uffff";
    static final String DFA16_eofS =
        "\164\uffff";
    static final String DFA16_minS =
        "\1\11\1\122\1\101\1\117\1\145\1\116\1\105\1\122\1\117\1\105\1\156"+
        "\1\55\11\uffff\1\72\10\uffff\1\75\1\55\3\uffff\1\56\1\uffff\1\105"+
        "\1\102\1\124\1\114\1\146\1\111\1\131\1\111\1\122\1\106\1\163\15"+
        "\uffff\1\101\1\114\1\60\1\114\1\141\1\121\1\60\1\115\2\105\1\151"+
        "\1\124\1\105\1\uffff\1\60\1\165\1\125\1\uffff\1\101\1\111\1\122"+
        "\1\147\1\105\1\60\1\uffff\1\154\1\105\1\122\1\107\1\105\1\156\1"+
        "\60\1\uffff\1\164\1\60\1\131\2\116\1\145\1\uffff\1\60\1\uffff\2"+
        "\60\1\103\1\144\3\uffff\1\105\1\60\1\123\1\uffff\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\122\1\101\1\125\1\145\1\116\1\105\1\122\1\117\1\105\1"+
        "\156\1\76\11\uffff\1\72\10\uffff\1\75\1\76\3\uffff\1\71\1\uffff"+
        "\1\105\1\102\1\124\1\114\1\146\1\111\1\131\1\111\1\122\1\106\1\163"+
        "\15\uffff\1\101\1\114\1\u00ff\1\114\1\141\1\121\1\u00ff\1\115\2"+
        "\105\1\151\1\124\1\105\1\uffff\1\u00ff\1\165\1\125\1\uffff\1\101"+
        "\1\111\1\122\1\147\1\105\1\u00ff\1\uffff\1\154\1\105\1\122\1\107"+
        "\1\105\1\156\1\u00ff\1\uffff\1\164\1\u00ff\1\131\2\116\1\145\1\uffff"+
        "\1\u00ff\1\uffff\2\u00ff\1\103\1\144\3\uffff\1\105\1\u00ff\1\123"+
        "\1\uffff\1\u00ff\1\uffff";
    static final String DFA16_acceptS =
        "\14\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\uffff\1"+
        "\30\1\31\1\32\1\33\1\36\1\37\1\40\1\41\2\uffff\1\50\1\51\1\52\1"+
        "\uffff\1\55\13\uffff\1\14\1\34\1\35\1\27\1\26\1\44\1\42\1\45\1\46"+
        "\1\47\1\43\1\53\1\54\15\uffff\1\3\3\uffff\1\7\6\uffff\1\4\7\uffff"+
        "\1\2\6\uffff\1\1\1\uffff\1\6\4\uffff\1\5\1\10\1\11\3\uffff\1\13"+
        "\1\uffff\1\12";
    static final String DFA16_specialS =
        "\164\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\41\1\40\2\uffff\1\40\22\uffff\1\41\1\16\1\42\1\27\3\uffff"+
            "\1\44\1\20\1\21\1\32\1\34\1\17\1\13\1\31\1\33\12\43\1\25\1\24"+
            "\1\37\1\35\1\36\1\30\1\uffff\2\42\1\1\2\42\1\10\4\42\1\6\2\42"+
            "\1\3\1\42\1\7\1\42\1\11\1\42\1\2\1\5\5\42\1\14\1\uffff\1\15"+
            "\1\uffff\1\42\1\uffff\3\42\1\4\20\42\1\12\5\42\1\22\1\26\1\23"+
            "\102\uffff\27\42\1\uffff\37\42\1\uffff\10\42",
            "\1\45",
            "\1\46",
            "\1\47\5\uffff\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60\20\uffff\1\61",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\63",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\71\17\uffff\1\67\1\70",
            "",
            "",
            "",
            "\1\74\1\uffff\12\43",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
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
            "\1\110",
            "\1\111",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\113",
            "\1\114",
            "\1\115",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\126",
            "\1\127",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "\1\145",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "\1\160",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\162",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
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
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONS | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}