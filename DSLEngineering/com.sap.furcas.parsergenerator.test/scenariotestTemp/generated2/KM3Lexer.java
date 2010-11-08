// $ANTLR 3.1.1 ./scenariotestTemp/generated2/KM3.g 2010-11-04 23:29:56

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

public class KM3Lexer extends Lexer {
    public static final int LT=31;
    public static final int STAR=14;
    public static final int LSQUARE=13;
    public static final int POINT=25;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int EXCL=18;
    public static final int FLOAT=7;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int COLONS=21;
    public static final int RPAREN=20;
    public static final int NAME=4;
    public static final int SLASH=27;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int PIPE=22;
    public static final int PLUS=28;
    public static final int DIGIT=38;
    public static final int NL=36;
    public static final int EQ=29;
    public static final int COMMENT=17;
    public static final int T__50=50;
    public static final int NE=34;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int GE=32;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int SHARP=23;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=26;
    public static final int LCURLY=8;
    public static final int INT=6;
    public static final int RSQUARE=15;
    public static final int MINUS=16;
    public static final int COMA=11;
    public static final int SEMI=10;
    public static final int ALPHA=39;
    public static final int COLON=12;
    public static final int WS=37;
    public static final int SNAME=40;
    public static final int RCURLY=9;
    public static final int GT=30;
    public static final int QMARK=24;
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

    public KM3Lexer() {;} 
    public KM3Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public KM3Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/KM3.g"; }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:117:7: ( 'package' )
            // ./scenariotestTemp/generated2/KM3.g:117:9: 'package'
            {
            match("package"); 


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
            // ./scenariotestTemp/generated2/KM3.g:118:7: ( 'datatype' )
            // ./scenariotestTemp/generated2/KM3.g:118:9: 'datatype'
            {
            match("datatype"); 


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
            // ./scenariotestTemp/generated2/KM3.g:119:7: ( 'abstract' )
            // ./scenariotestTemp/generated2/KM3.g:119:9: 'abstract'
            {
            match("abstract"); 


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
            // ./scenariotestTemp/generated2/KM3.g:120:7: ( 'class' )
            // ./scenariotestTemp/generated2/KM3.g:120:9: 'class'
            {
            match("class"); 


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
            // ./scenariotestTemp/generated2/KM3.g:121:7: ( 'extends' )
            // ./scenariotestTemp/generated2/KM3.g:121:9: 'extends'
            {
            match("extends"); 


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
            // ./scenariotestTemp/generated2/KM3.g:122:7: ( 'reference' )
            // ./scenariotestTemp/generated2/KM3.g:122:9: 'reference'
            {
            match("reference"); 


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
            // ./scenariotestTemp/generated2/KM3.g:123:7: ( 'ordered' )
            // ./scenariotestTemp/generated2/KM3.g:123:9: 'ordered'
            {
            match("ordered"); 


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
            // ./scenariotestTemp/generated2/KM3.g:124:7: ( 'container' )
            // ./scenariotestTemp/generated2/KM3.g:124:9: 'container'
            {
            match("container"); 


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
            // ./scenariotestTemp/generated2/KM3.g:125:7: ( 'oppositeOf' )
            // ./scenariotestTemp/generated2/KM3.g:125:9: 'oppositeOf'
            {
            match("oppositeOf"); 


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
            // ./scenariotestTemp/generated2/KM3.g:126:7: ( 'unique' )
            // ./scenariotestTemp/generated2/KM3.g:126:9: 'unique'
            {
            match("unique"); 


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
            // ./scenariotestTemp/generated2/KM3.g:127:7: ( 'attribute' )
            // ./scenariotestTemp/generated2/KM3.g:127:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:128:7: ( 'enumeration' )
            // ./scenariotestTemp/generated2/KM3.g:128:9: 'enumeration'
            {
            match("enumeration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:129:7: ( 'literal' )
            // ./scenariotestTemp/generated2/KM3.g:129:9: 'literal'
            {
            match("literal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:440:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/KM3.g:441:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/KM3.g:441:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/KM3.g:441:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/KM3.g:441:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/KM3.g:441:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/KM3.g:441:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/KM3.g:441:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ./scenariotestTemp/generated2/KM3.g:441:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/KM3.g:441:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:446:3: ( '[' )
            // ./scenariotestTemp/generated2/KM3.g:447:3: '['
            {
            match('['); 

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
            // ./scenariotestTemp/generated2/KM3.g:452:3: ( ']' )
            // ./scenariotestTemp/generated2/KM3.g:453:3: ']'
            {
            match(']'); 

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
            // ./scenariotestTemp/generated2/KM3.g:458:3: ( '!' )
            // ./scenariotestTemp/generated2/KM3.g:459:3: '!'
            {
            match('!'); 

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
            // ./scenariotestTemp/generated2/KM3.g:464:3: ( ',' )
            // ./scenariotestTemp/generated2/KM3.g:465:3: ','
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
            // ./scenariotestTemp/generated2/KM3.g:470:3: ( '(' )
            // ./scenariotestTemp/generated2/KM3.g:471:3: '('
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
            // ./scenariotestTemp/generated2/KM3.g:476:3: ( ')' )
            // ./scenariotestTemp/generated2/KM3.g:477:3: ')'
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
            // ./scenariotestTemp/generated2/KM3.g:482:3: ( '{' )
            // ./scenariotestTemp/generated2/KM3.g:483:3: '{'
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
            // ./scenariotestTemp/generated2/KM3.g:488:3: ( '}' )
            // ./scenariotestTemp/generated2/KM3.g:489:3: '}'
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

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:494:3: ( ';' )
            // ./scenariotestTemp/generated2/KM3.g:495:3: ';'
            {
            match(';'); 

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
            // ./scenariotestTemp/generated2/KM3.g:500:3: ( ':' )
            // ./scenariotestTemp/generated2/KM3.g:501:3: ':'
            {
            match(':'); 

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
            // ./scenariotestTemp/generated2/KM3.g:506:3: ( '::' )
            // ./scenariotestTemp/generated2/KM3.g:507:3: '::'
            {
            match("::"); 


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
            // ./scenariotestTemp/generated2/KM3.g:512:3: ( '|' )
            // ./scenariotestTemp/generated2/KM3.g:513:3: '|'
            {
            match('|'); 

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
            // ./scenariotestTemp/generated2/KM3.g:518:3: ( '#' )
            // ./scenariotestTemp/generated2/KM3.g:519:3: '#'
            {
            match('#'); 

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
            // ./scenariotestTemp/generated2/KM3.g:524:3: ( '?' )
            // ./scenariotestTemp/generated2/KM3.g:525:3: '?'
            {
            match('?'); 

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
            // ./scenariotestTemp/generated2/KM3.g:530:3: ( '.' )
            // ./scenariotestTemp/generated2/KM3.g:531:3: '.'
            {
            match('.'); 

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
            // ./scenariotestTemp/generated2/KM3.g:536:3: ( '->' )
            // ./scenariotestTemp/generated2/KM3.g:537:3: '->'
            {
            match("->"); 


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
            // ./scenariotestTemp/generated2/KM3.g:542:3: ( '-' )
            // ./scenariotestTemp/generated2/KM3.g:543:3: '-'
            {
            match('-'); 

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
            // ./scenariotestTemp/generated2/KM3.g:548:3: ( '*' )
            // ./scenariotestTemp/generated2/KM3.g:549:3: '*'
            {
            match('*'); 

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
            // ./scenariotestTemp/generated2/KM3.g:554:3: ( '/' )
            // ./scenariotestTemp/generated2/KM3.g:555:3: '/'
            {
            match('/'); 

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
            // ./scenariotestTemp/generated2/KM3.g:560:3: ( '+' )
            // ./scenariotestTemp/generated2/KM3.g:561:3: '+'
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

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:566:3: ( '=' )
            // ./scenariotestTemp/generated2/KM3.g:567:3: '='
            {
            match('='); 

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
            // ./scenariotestTemp/generated2/KM3.g:572:3: ( '>' )
            // ./scenariotestTemp/generated2/KM3.g:573:3: '>'
            {
            match('>'); 

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
            // ./scenariotestTemp/generated2/KM3.g:578:3: ( '<' )
            // ./scenariotestTemp/generated2/KM3.g:579:3: '<'
            {
            match('<'); 

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
            // ./scenariotestTemp/generated2/KM3.g:584:3: ( '>=' )
            // ./scenariotestTemp/generated2/KM3.g:585:3: '>='
            {
            match(">="); 


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
            // ./scenariotestTemp/generated2/KM3.g:590:3: ( '<=' )
            // ./scenariotestTemp/generated2/KM3.g:591:3: '<='
            {
            match("<="); 


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
            // ./scenariotestTemp/generated2/KM3.g:596:3: ( '<>' )
            // ./scenariotestTemp/generated2/KM3.g:597:3: '<>'
            {
            match("<>"); 


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
            // ./scenariotestTemp/generated2/KM3.g:602:3: ( '<-' )
            // ./scenariotestTemp/generated2/KM3.g:603:3: '<-'
            {
            match("<-"); 


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
            // ./scenariotestTemp/generated2/KM3.g:611:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/KM3.g:611:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/KM3.g:611:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/KM3.g:611:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:612:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/KM3.g:613:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/KM3.g:614:5: '\\n'
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
            // ./scenariotestTemp/generated2/KM3.g:620:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/KM3.g:620:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/KM3.g:627:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/KM3.g:627:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/KM3.g:632:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/KM3.g:
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
            // ./scenariotestTemp/generated2/KM3.g:646:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/KM3.g:646:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/KM3.g:646:4: ( ALPHA )
            // ./scenariotestTemp/generated2/KM3.g:646:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/KM3.g:646:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/KM3.g:
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

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:650:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/KM3.g:650:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/KM3.g:650:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='\"') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:651:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:657:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/KM3.g:658:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/KM3.g:658:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/KM3.g:659:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/KM3.g:660:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
                    	    break loop4;
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/KM3.g:667:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/KM3.g:667:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/KM3.g:667:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/KM3.g:667:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
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
            // ./scenariotestTemp/generated2/KM3.g:671:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // ./scenariotestTemp/generated2/KM3.g:671:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // ./scenariotestTemp/generated2/KM3.g:671:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/KM3.g:671:9: DIGIT
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

            match('.'); 
            // ./scenariotestTemp/generated2/KM3.g:671:20: ( DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/KM3.g:671:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop8;
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

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // ./scenariotestTemp/generated2/KM3.g:675:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/KM3.g:675:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/KM3.g:676:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt13=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt13=1;
                }
                break;
            case 'r':
                {
                alt13=2;
                }
                break;
            case 't':
                {
                alt13=3;
                }
                break;
            case 'b':
                {
                alt13=4;
                }
                break;
            case 'f':
                {
                alt13=5;
                }
                break;
            case '\"':
                {
                alt13=6;
                }
                break;
            case '\'':
                {
                alt13=7;
                }
                break;
            case '\\':
                {
                alt13=8;
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
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ./scenariotestTemp/generated2/KM3.g:676:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/KM3.g:677:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/KM3.g:678:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/KM3.g:679:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/KM3.g:680:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/KM3.g:681:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/KM3.g:682:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/KM3.g:683:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/KM3.g:684:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/KM3.g:684:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>='0' && LA12_0<='3')) ) {
                        alt12=1;
                    }
                    else if ( ((LA12_0>='4' && LA12_0<='7')) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ./scenariotestTemp/generated2/KM3.g:685:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/KM3.g:685:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/KM3.g:685:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/KM3.g:686:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/KM3.g:690:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/KM3.g:690:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/KM3.g:690:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/KM3.g:691:6: ( '0' .. '7' )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/KM3.g:695:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/KM3.g:698:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/KM3.g:698:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/KM3.g:698:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/KM3.g:699:5: ( ( '0' .. '7' ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/KM3.g:703:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/KM3.g:703:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/KM3.g:703:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/KM3.g:712:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/KM3.g:712:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/KM3.g:713:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
            loop14:
            do {
                int alt14=4;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\\') ) {
                    alt14=1;
                }
                else if ( (LA14_0=='\n') ) {
                    alt14=2;
                }
                else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                    alt14=3;
                }


                switch (alt14) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/KM3.g:713:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/KM3.g:714:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/KM3.g:715:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
            	    break loop14;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // ./scenariotestTemp/generated2/KM3.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONS | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt15=47;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // ./scenariotestTemp/generated2/KM3.g:1:10: T__42
                {
                mT__42(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/KM3.g:1:16: T__43
                {
                mT__43(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/KM3.g:1:22: T__44
                {
                mT__44(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/KM3.g:1:28: T__45
                {
                mT__45(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/KM3.g:1:34: T__46
                {
                mT__46(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/KM3.g:1:40: T__47
                {
                mT__47(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/KM3.g:1:46: T__48
                {
                mT__48(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/KM3.g:1:52: T__49
                {
                mT__49(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/KM3.g:1:58: T__50
                {
                mT__50(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/KM3.g:1:64: T__51
                {
                mT__51(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/KM3.g:1:70: T__52
                {
                mT__52(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/KM3.g:1:76: T__53
                {
                mT__53(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/KM3.g:1:82: T__54
                {
                mT__54(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/KM3.g:1:88: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/KM3.g:1:96: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/KM3.g:1:104: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/KM3.g:1:112: EXCL
                {
                mEXCL(); 

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/KM3.g:1:117: COMA
                {
                mCOMA(); 

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/KM3.g:1:122: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/KM3.g:1:129: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/KM3.g:1:136: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/KM3.g:1:143: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/KM3.g:1:150: SEMI
                {
                mSEMI(); 

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/KM3.g:1:155: COLON
                {
                mCOLON(); 

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/KM3.g:1:161: COLONS
                {
                mCOLONS(); 

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/KM3.g:1:168: PIPE
                {
                mPIPE(); 

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/KM3.g:1:173: SHARP
                {
                mSHARP(); 

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/KM3.g:1:179: QMARK
                {
                mQMARK(); 

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/KM3.g:1:185: POINT
                {
                mPOINT(); 

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/KM3.g:1:191: RARROW
                {
                mRARROW(); 

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/KM3.g:1:198: MINUS
                {
                mMINUS(); 

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/KM3.g:1:204: STAR
                {
                mSTAR(); 

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/KM3.g:1:209: SLASH
                {
                mSLASH(); 

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/KM3.g:1:215: PLUS
                {
                mPLUS(); 

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/KM3.g:1:220: EQ
                {
                mEQ(); 

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/KM3.g:1:223: GT
                {
                mGT(); 

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/KM3.g:1:226: LT
                {
                mLT(); 

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/KM3.g:1:229: GE
                {
                mGE(); 

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/KM3.g:1:232: LE
                {
                mLE(); 

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/KM3.g:1:235: NE
                {
                mNE(); 

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/KM3.g:1:238: LARROW
                {
                mLARROW(); 

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/KM3.g:1:245: NL
                {
                mNL(); 

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/KM3.g:1:248: WS
                {
                mWS(); 

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/KM3.g:1:251: NAME
                {
                mNAME(); 

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/KM3.g:1:256: INT
                {
                mINT(); 

                }
                break;
            case 46 :
                // ./scenariotestTemp/generated2/KM3.g:1:260: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 47 :
                // ./scenariotestTemp/generated2/KM3.g:1:266: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\11\41\1\63\11\uffff\1\65\10\uffff\1\67\1\73\3\uffff\1\74"+
        "\1\uffff\15\41\15\uffff\36\41\1\151\14\41\1\uffff\6\41\1\174\1\41"+
        "\1\176\4\41\1\u0083\2\41\1\u0086\1\41\1\uffff\1\u0088\1\uffff\1"+
        "\u0089\1\u008a\2\41\1\uffff\2\41\1\uffff\1\41\3\uffff\1\u0090\1"+
        "\u0091\1\41\1\u0093\1\41\2\uffff\1\41\1\uffff\1\u0096\1\u0097\2"+
        "\uffff";
    static final String DFA15_eofS =
        "\u0098\uffff";
    static final String DFA15_minS =
        "\1\11\2\141\1\142\1\154\1\156\1\145\1\160\1\156\1\151\1\55\11\uffff"+
        "\1\72\10\uffff\1\75\1\55\3\uffff\1\56\1\uffff\1\143\1\164\1\163"+
        "\1\164\1\141\1\156\1\164\1\165\1\146\1\144\1\160\1\151\1\164\15"+
        "\uffff\1\153\1\141\1\164\1\162\1\163\1\164\1\145\1\155\2\145\1\157"+
        "\1\161\1\145\1\141\1\164\1\162\1\151\1\163\1\141\1\156\1\145\2\162"+
        "\1\163\1\165\1\162\1\147\1\171\1\141\1\142\1\60\1\151\1\144\1\162"+
        "\2\145\1\151\1\145\1\141\1\145\1\160\1\143\1\165\1\uffff\1\156\1"+
        "\163\1\141\1\156\1\144\1\164\1\60\1\154\1\60\1\145\2\164\1\145\1"+
        "\60\1\164\1\143\1\60\1\145\1\uffff\1\60\1\uffff\2\60\1\145\1\162"+
        "\1\uffff\1\151\1\145\1\uffff\1\117\3\uffff\2\60\1\157\1\60\1\146"+
        "\2\uffff\1\156\1\uffff\2\60\2\uffff";
    static final String DFA15_maxS =
        "\1\u00ff\2\141\1\164\1\157\1\170\1\145\1\162\1\156\1\151\1\76\11"+
        "\uffff\1\72\10\uffff\1\75\1\76\3\uffff\1\71\1\uffff\1\143\1\164"+
        "\1\163\1\164\1\141\1\156\1\164\1\165\1\146\1\144\1\160\1\151\1\164"+
        "\15\uffff\1\153\1\141\1\164\1\162\1\163\1\164\1\145\1\155\2\145"+
        "\1\157\1\161\1\145\1\141\1\164\1\162\1\151\1\163\1\141\1\156\1\145"+
        "\2\162\1\163\1\165\1\162\1\147\1\171\1\141\1\142\1\u00ff\1\151\1"+
        "\144\1\162\2\145\1\151\1\145\1\141\1\145\1\160\1\143\1\165\1\uffff"+
        "\1\156\1\163\1\141\1\156\1\144\1\164\1\u00ff\1\154\1\u00ff\1\145"+
        "\2\164\1\145\1\u00ff\1\164\1\143\1\u00ff\1\145\1\uffff\1\u00ff\1"+
        "\uffff\2\u00ff\1\145\1\162\1\uffff\1\151\1\145\1\uffff\1\117\3\uffff"+
        "\2\u00ff\1\157\1\u00ff\1\146\2\uffff\1\156\1\uffff\2\u00ff\2\uffff";
    static final String DFA15_acceptS =
        "\13\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\uffff\1"+
        "\32\1\33\1\34\1\35\1\40\1\41\1\42\1\43\2\uffff\1\52\1\53\1\54\1"+
        "\uffff\1\57\15\uffff\1\16\1\36\1\37\1\31\1\30\1\46\1\44\1\47\1\50"+
        "\1\51\1\45\1\55\1\56\53\uffff\1\4\22\uffff\1\12\1\uffff\1\1\4\uffff"+
        "\1\5\2\uffff\1\7\1\uffff\1\15\1\2\1\3\5\uffff\1\13\1\10\1\uffff"+
        "\1\6\2\uffff\1\11\1\14";
    static final String DFA15_specialS =
        "\u0098\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\40\1\37\2\uffff\1\37\22\uffff\1\40\1\15\1\41\1\26\3\uffff"+
            "\1\43\1\17\1\20\1\31\1\33\1\16\1\12\1\30\1\32\12\42\1\24\1\23"+
            "\1\36\1\34\1\35\1\27\1\uffff\32\41\1\13\1\uffff\1\14\1\uffff"+
            "\1\41\1\uffff\1\3\1\41\1\4\1\2\1\5\6\41\1\11\2\41\1\7\1\1\1"+
            "\41\1\6\2\41\1\10\5\41\1\21\1\25\1\22\102\uffff\27\41\1\uffff"+
            "\37\41\1\uffff\10\41",
            "\1\44",
            "\1\45",
            "\1\46\21\uffff\1\47",
            "\1\50\2\uffff\1\51",
            "\1\53\11\uffff\1\52",
            "\1\54",
            "\1\56\1\uffff\1\55",
            "\1\57",
            "\1\60",
            "\1\61\20\uffff\1\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\72\17\uffff\1\70\1\71",
            "",
            "",
            "",
            "\1\75\1\uffff\12\42",
            "",
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
            "\1\110",
            "\1\111",
            "\1\112",
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
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\175",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\u0084",
            "\1\u0085",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\u0087",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\u008b",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\u0092",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\1\u0094",
            "",
            "",
            "\1\u0095",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff\27"+
            "\41\1\uffff\37\41\1\uffff\10\41",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONS | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}