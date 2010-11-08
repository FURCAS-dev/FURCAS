// $ANTLR 3.1.1 ./scenariotestTemp/generated2/FPath.g 2010-11-04 23:27:13

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

public class FPathLexer extends Lexer {
    public static final int LT=13;
    public static final int STAR=11;
    public static final int LSQUARE=22;
    public static final int POINT=19;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int EXCL=25;
    public static final int FLOAT=6;
    public static final int EOF=-1;
    public static final int LPAREN=7;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=8;
    public static final int T__57=57;
    public static final int NAME=4;
    public static final int T__58=58;
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
    public static final int RSQUARE=23;
    public static final int MINUS=10;
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

    public FPathLexer() {;} 
    public FPathLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public FPathLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/FPath.g"; }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:117:7: ( 'not' )
            // ./scenariotestTemp/generated2/FPath.g:117:9: 'not'
            {
            match("not"); 


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
            // ./scenariotestTemp/generated2/FPath.g:118:7: ( 'div' )
            // ./scenariotestTemp/generated2/FPath.g:118:9: 'div'
            {
            match("div"); 


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
            // ./scenariotestTemp/generated2/FPath.g:119:7: ( 'and' )
            // ./scenariotestTemp/generated2/FPath.g:119:9: 'and'
            {
            match("and"); 


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
            // ./scenariotestTemp/generated2/FPath.g:120:7: ( 'or' )
            // ./scenariotestTemp/generated2/FPath.g:120:9: 'or'
            {
            match("or"); 


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
            // ./scenariotestTemp/generated2/FPath.g:121:7: ( '$' )
            // ./scenariotestTemp/generated2/FPath.g:121:9: '$'
            {
            match('$'); 

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
            // ./scenariotestTemp/generated2/FPath.g:122:7: ( 'component' )
            // ./scenariotestTemp/generated2/FPath.g:122:9: 'component'
            {
            match("component"); 


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
            // ./scenariotestTemp/generated2/FPath.g:123:7: ( 'internal-interface' )
            // ./scenariotestTemp/generated2/FPath.g:123:9: 'internal-interface'
            {
            match("internal-interface"); 


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
            // ./scenariotestTemp/generated2/FPath.g:124:7: ( 'interface' )
            // ./scenariotestTemp/generated2/FPath.g:124:9: 'interface'
            {
            match("interface"); 


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
            // ./scenariotestTemp/generated2/FPath.g:125:7: ( 'attribute' )
            // ./scenariotestTemp/generated2/FPath.g:125:9: 'attribute'
            {
            match("attribute"); 


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
            // ./scenariotestTemp/generated2/FPath.g:126:7: ( 'binding' )
            // ./scenariotestTemp/generated2/FPath.g:126:9: 'binding'
            {
            match("binding"); 


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
            // ./scenariotestTemp/generated2/FPath.g:127:7: ( 'child' )
            // ./scenariotestTemp/generated2/FPath.g:127:9: 'child'
            {
            match("child"); 


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
            // ./scenariotestTemp/generated2/FPath.g:128:7: ( 'parent' )
            // ./scenariotestTemp/generated2/FPath.g:128:9: 'parent'
            {
            match("parent"); 


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
            // ./scenariotestTemp/generated2/FPath.g:129:7: ( 'descendant' )
            // ./scenariotestTemp/generated2/FPath.g:129:9: 'descendant'
            {
            match("descendant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:130:7: ( 'ancestor' )
            // ./scenariotestTemp/generated2/FPath.g:130:9: 'ancestor'
            {
            match("ancestor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:131:7: ( 'sibling' )
            // ./scenariotestTemp/generated2/FPath.g:131:9: 'sibling'
            {
            match("sibling"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:132:7: ( 'descendant-or-self' )
            // ./scenariotestTemp/generated2/FPath.g:132:9: 'descendant-or-self'
            {
            match("descendant-or-self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:133:7: ( 'ancestor-or-self' )
            // ./scenariotestTemp/generated2/FPath.g:133:9: 'ancestor-or-self'
            {
            match("ancestor-or-self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:134:7: ( 'sibling-or-self' )
            // ./scenariotestTemp/generated2/FPath.g:134:9: 'sibling-or-self'
            {
            match("sibling-or-self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:561:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/FPath.g:562:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:562:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/FPath.g:562:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/FPath.g:562:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/FPath.g:562:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/FPath.g:562:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/FPath.g:562:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // ./scenariotestTemp/generated2/FPath.g:562:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:562:15: ~ ( '\\r' | '\\n' )
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
            // ./scenariotestTemp/generated2/FPath.g:567:3: ( '[' )
            // ./scenariotestTemp/generated2/FPath.g:568:3: '['
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
            // ./scenariotestTemp/generated2/FPath.g:573:3: ( ']' )
            // ./scenariotestTemp/generated2/FPath.g:574:3: ']'
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
            // ./scenariotestTemp/generated2/FPath.g:579:3: ( '!' )
            // ./scenariotestTemp/generated2/FPath.g:580:3: '!'
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
            // ./scenariotestTemp/generated2/FPath.g:585:3: ( ',' )
            // ./scenariotestTemp/generated2/FPath.g:586:3: ','
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
            // ./scenariotestTemp/generated2/FPath.g:591:3: ( '(' )
            // ./scenariotestTemp/generated2/FPath.g:592:3: '('
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
            // ./scenariotestTemp/generated2/FPath.g:597:3: ( ')' )
            // ./scenariotestTemp/generated2/FPath.g:598:3: ')'
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
            // ./scenariotestTemp/generated2/FPath.g:603:3: ( '{' )
            // ./scenariotestTemp/generated2/FPath.g:604:3: '{'
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
            // ./scenariotestTemp/generated2/FPath.g:609:3: ( '}' )
            // ./scenariotestTemp/generated2/FPath.g:610:3: '}'
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
            // ./scenariotestTemp/generated2/FPath.g:615:3: ( ';' )
            // ./scenariotestTemp/generated2/FPath.g:616:3: ';'
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
            // ./scenariotestTemp/generated2/FPath.g:621:3: ( ':' )
            // ./scenariotestTemp/generated2/FPath.g:622:3: ':'
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

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:627:3: ( '::' )
            // ./scenariotestTemp/generated2/FPath.g:628:3: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLONCOLON"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:633:3: ( '|' )
            // ./scenariotestTemp/generated2/FPath.g:634:3: '|'
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
            // ./scenariotestTemp/generated2/FPath.g:639:3: ( '#' )
            // ./scenariotestTemp/generated2/FPath.g:640:3: '#'
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
            // ./scenariotestTemp/generated2/FPath.g:645:3: ( '?' )
            // ./scenariotestTemp/generated2/FPath.g:646:3: '?'
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
            // ./scenariotestTemp/generated2/FPath.g:651:3: ( '.' )
            // ./scenariotestTemp/generated2/FPath.g:652:3: '.'
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
            // ./scenariotestTemp/generated2/FPath.g:657:3: ( '->' )
            // ./scenariotestTemp/generated2/FPath.g:658:3: '->'
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
            // ./scenariotestTemp/generated2/FPath.g:663:3: ( '-' )
            // ./scenariotestTemp/generated2/FPath.g:664:3: '-'
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
            // ./scenariotestTemp/generated2/FPath.g:669:3: ( '*' )
            // ./scenariotestTemp/generated2/FPath.g:670:3: '*'
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
            // ./scenariotestTemp/generated2/FPath.g:675:3: ( '/' )
            // ./scenariotestTemp/generated2/FPath.g:676:3: '/'
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
            // ./scenariotestTemp/generated2/FPath.g:681:3: ( '+' )
            // ./scenariotestTemp/generated2/FPath.g:682:3: '+'
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
            // ./scenariotestTemp/generated2/FPath.g:687:3: ( '=' )
            // ./scenariotestTemp/generated2/FPath.g:688:3: '='
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

    // $ANTLR start "EQEQ"
    public final void mEQEQ() throws RecognitionException {
        try {
            int _type = EQEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:693:3: ( '==' )
            // ./scenariotestTemp/generated2/FPath.g:694:3: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQEQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:699:3: ( '>' )
            // ./scenariotestTemp/generated2/FPath.g:700:3: '>'
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
            // ./scenariotestTemp/generated2/FPath.g:705:3: ( '<' )
            // ./scenariotestTemp/generated2/FPath.g:706:3: '<'
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
            // ./scenariotestTemp/generated2/FPath.g:711:3: ( '>=' )
            // ./scenariotestTemp/generated2/FPath.g:712:3: '>='
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
            // ./scenariotestTemp/generated2/FPath.g:717:3: ( '<=' )
            // ./scenariotestTemp/generated2/FPath.g:718:3: '<='
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
            // ./scenariotestTemp/generated2/FPath.g:723:3: ( '<>' )
            // ./scenariotestTemp/generated2/FPath.g:724:3: '<>'
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
            // ./scenariotestTemp/generated2/FPath.g:729:3: ( '<-' )
            // ./scenariotestTemp/generated2/FPath.g:730:3: '<-'
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
            // ./scenariotestTemp/generated2/FPath.g:738:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/FPath.g:738:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/FPath.g:738:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/FPath.g:738:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:739:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/FPath.g:740:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/FPath.g:741:5: '\\n'
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
            // ./scenariotestTemp/generated2/FPath.g:747:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/FPath.g:747:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/FPath.g:754:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/FPath.g:754:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/FPath.g:759:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/FPath.g:
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
            // ./scenariotestTemp/generated2/FPath.g:770:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/FPath.g:770:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/FPath.g:770:4: ( ALPHA )
            // ./scenariotestTemp/generated2/FPath.g:770:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/FPath.g:770:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/FPath.g:
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
            // ./scenariotestTemp/generated2/FPath.g:774:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/FPath.g:774:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/FPath.g:774:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    // ./scenariotestTemp/generated2/FPath.g:775:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:776:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/FPath.g:777:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/FPath.g:777:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/FPath.g:778:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/FPath.g:779:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/FPath.g:786:7: ( ( DIGIT )+ ( '.' ( DIGIT )* )? )
            // ./scenariotestTemp/generated2/FPath.g:786:9: ( DIGIT )+ ( '.' ( DIGIT )* )?
            {
            // ./scenariotestTemp/generated2/FPath.g:786:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/FPath.g:786:9: DIGIT
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

            // ./scenariotestTemp/generated2/FPath.g:786:16: ( '.' ( DIGIT )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='.') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/FPath.g:786:17: '.' ( DIGIT )*
                    {
                    match('.'); 
                    // ./scenariotestTemp/generated2/FPath.g:786:21: ( DIGIT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/FPath.g:786:21: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
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
            // ./scenariotestTemp/generated2/FPath.g:790:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/FPath.g:790:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/FPath.g:791:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // ./scenariotestTemp/generated2/FPath.g:791:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/FPath.g:792:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/FPath.g:793:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/FPath.g:794:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/FPath.g:795:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/FPath.g:796:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/FPath.g:797:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/FPath.g:798:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/FPath.g:799:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/FPath.g:799:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // ./scenariotestTemp/generated2/FPath.g:800:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/FPath.g:800:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/FPath.g:800:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/FPath.g:801:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/FPath.g:802:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/FPath.g:802:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/FPath.g:802:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/FPath.g:803:6: ( '0' .. '7' )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/FPath.g:804:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/FPath.g:807:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/FPath.g:807:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/FPath.g:807:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/FPath.g:808:5: ( ( '0' .. '7' ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/FPath.g:810:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/FPath.g:810:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/FPath.g:810:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/FPath.g:819:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/FPath.g:819:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/FPath.g:820:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // ./scenariotestTemp/generated2/FPath.g:820:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/FPath.g:821:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/FPath.g:822:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
        // ./scenariotestTemp/generated2/FPath.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONCOLON | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | EQEQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | FLOAT | STRING )
        int alt15=52;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // ./scenariotestTemp/generated2/FPath.g:1:10: T__42
                {
                mT__42(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/FPath.g:1:16: T__43
                {
                mT__43(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/FPath.g:1:22: T__44
                {
                mT__44(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/FPath.g:1:28: T__45
                {
                mT__45(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/FPath.g:1:34: T__46
                {
                mT__46(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/FPath.g:1:40: T__47
                {
                mT__47(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/FPath.g:1:46: T__48
                {
                mT__48(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/FPath.g:1:52: T__49
                {
                mT__49(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/FPath.g:1:58: T__50
                {
                mT__50(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/FPath.g:1:64: T__51
                {
                mT__51(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/FPath.g:1:70: T__52
                {
                mT__52(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/FPath.g:1:76: T__53
                {
                mT__53(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/FPath.g:1:82: T__54
                {
                mT__54(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/FPath.g:1:88: T__55
                {
                mT__55(); 

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/FPath.g:1:94: T__56
                {
                mT__56(); 

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/FPath.g:1:100: T__57
                {
                mT__57(); 

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/FPath.g:1:106: T__58
                {
                mT__58(); 

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/FPath.g:1:112: T__59
                {
                mT__59(); 

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/FPath.g:1:118: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/FPath.g:1:126: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/FPath.g:1:134: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/FPath.g:1:142: EXCL
                {
                mEXCL(); 

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/FPath.g:1:147: COMA
                {
                mCOMA(); 

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/FPath.g:1:152: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/FPath.g:1:159: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/FPath.g:1:166: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/FPath.g:1:173: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/FPath.g:1:180: SEMI
                {
                mSEMI(); 

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/FPath.g:1:185: COLON
                {
                mCOLON(); 

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/FPath.g:1:191: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/FPath.g:1:202: PIPE
                {
                mPIPE(); 

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/FPath.g:1:207: SHARP
                {
                mSHARP(); 

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/FPath.g:1:213: QMARK
                {
                mQMARK(); 

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/FPath.g:1:219: POINT
                {
                mPOINT(); 

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/FPath.g:1:225: RARROW
                {
                mRARROW(); 

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/FPath.g:1:232: MINUS
                {
                mMINUS(); 

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/FPath.g:1:238: STAR
                {
                mSTAR(); 

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/FPath.g:1:243: SLASH
                {
                mSLASH(); 

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/FPath.g:1:249: PLUS
                {
                mPLUS(); 

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/FPath.g:1:254: EQ
                {
                mEQ(); 

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/FPath.g:1:257: EQEQ
                {
                mEQEQ(); 

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/FPath.g:1:262: GT
                {
                mGT(); 

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/FPath.g:1:265: LT
                {
                mLT(); 

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/FPath.g:1:268: GE
                {
                mGE(); 

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/FPath.g:1:271: LE
                {
                mLE(); 

                }
                break;
            case 46 :
                // ./scenariotestTemp/generated2/FPath.g:1:274: NE
                {
                mNE(); 

                }
                break;
            case 47 :
                // ./scenariotestTemp/generated2/FPath.g:1:277: LARROW
                {
                mLARROW(); 

                }
                break;
            case 48 :
                // ./scenariotestTemp/generated2/FPath.g:1:284: NL
                {
                mNL(); 

                }
                break;
            case 49 :
                // ./scenariotestTemp/generated2/FPath.g:1:287: WS
                {
                mWS(); 

                }
                break;
            case 50 :
                // ./scenariotestTemp/generated2/FPath.g:1:290: NAME
                {
                mNAME(); 

                }
                break;
            case 51 :
                // ./scenariotestTemp/generated2/FPath.g:1:295: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 52 :
                // ./scenariotestTemp/generated2/FPath.g:1:301: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\4\42\1\uffff\5\42\1\63\11\uffff\1\65\7\uffff\1\67\1\71"+
        "\1\75\5\uffff\5\42\1\104\6\42\15\uffff\1\113\1\114\1\42\1\116\2"+
        "\42\1\uffff\6\42\2\uffff\1\42\1\uffff\14\42\1\144\10\42\1\uffff"+
        "\3\42\1\161\7\42\1\171\1\uffff\1\173\1\42\1\176\4\42\3\uffff\1\42"+
        "\2\uffff\1\u0084\1\u0085\1\uffff\1\u0086\1\u0088\5\uffff";
    static final String DFA15_eofS =
        "\u0089\uffff";
    static final String DFA15_minS =
        "\1\11\1\157\1\145\1\156\1\162\1\uffff\1\150\1\156\1\151\1\141\1"+
        "\151\1\55\11\uffff\1\72\7\uffff\2\75\1\55\5\uffff\1\164\1\166\1"+
        "\163\1\143\1\164\1\60\1\155\1\151\1\164\1\156\1\162\1\142\15\uffff"+
        "\2\60\1\143\1\60\1\145\1\162\1\uffff\1\160\1\154\1\145\1\144\1\145"+
        "\1\154\2\uffff\1\145\1\uffff\1\163\1\151\1\157\1\144\1\162\1\151"+
        "\1\156\1\151\1\156\1\164\1\142\1\156\1\60\1\146\1\156\1\164\1\156"+
        "\1\144\1\157\1\165\1\145\1\uffff\2\141\1\147\1\60\1\147\1\141\1"+
        "\162\1\164\1\156\1\154\1\143\1\60\1\uffff\1\55\1\156\1\55\1\145"+
        "\1\164\1\55\1\145\3\uffff\1\164\2\uffff\2\60\1\uffff\1\60\1\55\5"+
        "\uffff";
    static final String DFA15_maxS =
        "\1\u00ff\1\157\1\151\1\164\1\162\1\uffff\1\157\1\156\1\151\1\141"+
        "\1\151\1\76\11\uffff\1\72\7\uffff\2\75\1\76\5\uffff\1\164\1\166"+
        "\1\163\1\144\1\164\1\u00ff\1\155\1\151\1\164\1\156\1\162\1\142\15"+
        "\uffff\2\u00ff\1\143\1\u00ff\1\145\1\162\1\uffff\1\160\1\154\1\145"+
        "\1\144\1\145\1\154\2\uffff\1\145\1\uffff\1\163\1\151\1\157\1\144"+
        "\1\162\1\151\1\156\1\151\1\156\1\164\1\142\1\156\1\u00ff\2\156\1"+
        "\164\1\156\1\144\1\157\1\165\1\145\1\uffff\2\141\1\147\1\u00ff\1"+
        "\147\1\141\1\162\1\164\1\156\1\154\1\143\1\u00ff\1\uffff\1\u00ff"+
        "\1\156\1\u00ff\1\145\1\164\1\55\1\145\3\uffff\1\164\2\uffff\2\u00ff"+
        "\1\uffff\2\u00ff\5\uffff";
    static final String DFA15_acceptS =
        "\5\uffff\1\5\6\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
        "\1\uffff\1\37\1\40\1\41\1\42\1\45\1\46\1\47\3\uffff\1\60\1\61\1"+
        "\62\1\63\1\64\14\uffff\1\23\1\43\1\44\1\36\1\35\1\51\1\50\1\54\1"+
        "\52\1\55\1\56\1\57\1\53\6\uffff\1\4\6\uffff\1\1\1\2\1\uffff\1\3"+
        "\25\uffff\1\13\14\uffff\1\14\7\uffff\1\12\1\22\1\17\1\uffff\1\21"+
        "\1\16\2\uffff\1\7\2\uffff\1\11\1\6\1\10\1\20\1\15";
    static final String DFA15_specialS =
        "\u0089\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\41\1\40\2\uffff\1\40\22\uffff\1\41\1\16\1\42\1\27\1\5\2\uffff"+
            "\1\44\1\20\1\21\1\32\1\34\1\17\1\13\1\31\1\33\12\43\1\25\1\24"+
            "\1\37\1\35\1\36\1\30\1\uffff\32\42\1\14\1\uffff\1\15\1\uffff"+
            "\1\42\1\uffff\1\3\1\10\1\6\1\2\4\42\1\7\4\42\1\1\1\4\1\11\2"+
            "\42\1\12\7\42\1\22\1\26\1\23\102\uffff\27\42\1\uffff\37\42\1"+
            "\uffff\10\42",
            "\1\45",
            "\1\47\3\uffff\1\46",
            "\1\50\5\uffff\1\51",
            "\1\52",
            "",
            "\1\54\6\uffff\1\53",
            "\1\55",
            "\1\56",
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
            "\1\66",
            "\1\70",
            "\1\74\17\uffff\1\72\1\73",
            "",
            "",
            "",
            "",
            "",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\102\1\101",
            "\1\103",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
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
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\115",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "",
            "\1\127",
            "",
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
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\146\7\uffff\1\145",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "\1\156",
            "\1\157",
            "\1\160",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "\1\172\2\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42\105\uffff\27\42\1\uffff\37\42\1\uffff\10\42",
            "\1\174",
            "\1\175\2\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42\105\uffff\27\42\1\uffff\37\42\1\uffff\10\42",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "",
            "",
            "\1\u0083",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\u0087\2\uffff\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32"+
            "\42\105\uffff\27\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | COMMENT | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | COLONCOLON | PIPE | SHARP | QMARK | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | EQEQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | FLOAT | STRING );";
        }
    }
 

}