// $ANTLR 3.1.1 ./scenariotestTemp/generated2/XPath.g 2010-11-04 23:26:47

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
public class XPathLexer extends Lexer {
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
    public static final int SLASH=21;
    public static final int T__51=51;
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
    public static final int MINUS=11;
    public static final int RSQUARE=25;
    public static final int ALPHA=33;
    public static final int WS=31;
    public static final int SLASHSLASH=29;
    public static final int T__36=36;
    public static final int SNAME=34;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int GT=16;
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

    public XPathLexer() {;} 
    public XPathLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XPathLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/XPath.g"; }

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPath.g:117:7: ( 'div' )
            // ./scenariotestTemp/generated2/XPath.g:117:9: 'div'
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
            // ./scenariotestTemp/generated2/XPath.g:118:7: ( 'mod' )
            // ./scenariotestTemp/generated2/XPath.g:118:9: 'mod'
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
            // ./scenariotestTemp/generated2/XPath.g:119:7: ( 'and' )
            // ./scenariotestTemp/generated2/XPath.g:119:9: 'and'
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
            // ./scenariotestTemp/generated2/XPath.g:120:7: ( 'or' )
            // ./scenariotestTemp/generated2/XPath.g:120:9: 'or'
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

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPath.g:121:7: ( ',' )
            // ./scenariotestTemp/generated2/XPath.g:121:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPath.g:122:7: ( 'node' )
            // ./scenariotestTemp/generated2/XPath.g:122:9: 'node'
            {
            match("node"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPath.g:123:7: ( 'text' )
            // ./scenariotestTemp/generated2/XPath.g:123:9: 'text'
            {
            match("text"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:124:7: ( 'ancestor' )
            // ./scenariotestTemp/generated2/XPath.g:124:9: 'ancestor'
            {
            match("ancestor"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:125:7: ( 'ancestor-or-self' )
            // ./scenariotestTemp/generated2/XPath.g:125:9: 'ancestor-or-self'
            {
            match("ancestor-or-self"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:126:7: ( 'attribute' )
            // ./scenariotestTemp/generated2/XPath.g:126:9: 'attribute'
            {
            match("attribute"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:127:7: ( 'child' )
            // ./scenariotestTemp/generated2/XPath.g:127:9: 'child'
            {
            match("child"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:128:7: ( 'descendant' )
            // ./scenariotestTemp/generated2/XPath.g:128:9: 'descendant'
            {
            match("descendant"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:129:7: ( 'descendant-or-self' )
            // ./scenariotestTemp/generated2/XPath.g:129:9: 'descendant-or-self'
            {
            match("descendant-or-self"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:130:7: ( 'following' )
            // ./scenariotestTemp/generated2/XPath.g:130:9: 'following'
            {
            match("following"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:131:7: ( 'following-sibling' )
            // ./scenariotestTemp/generated2/XPath.g:131:9: 'following-sibling'
            {
            match("following-sibling"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:132:7: ( 'namespace' )
            // ./scenariotestTemp/generated2/XPath.g:132:9: 'namespace'
            {
            match("namespace"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:133:7: ( 'parent' )
            // ./scenariotestTemp/generated2/XPath.g:133:9: 'parent'
            {
            match("parent"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:134:7: ( 'preceding' )
            // ./scenariotestTemp/generated2/XPath.g:134:9: 'preceding'
            {
            match("preceding"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:135:7: ( 'preceding-sibling' )
            // ./scenariotestTemp/generated2/XPath.g:135:9: 'preceding-sibling'
            {
            match("preceding-sibling"); if (state.failed) return ;


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
            // ./scenariotestTemp/generated2/XPath.g:136:7: ( 'self' )
            // ./scenariotestTemp/generated2/XPath.g:136:9: 'self'
            {
            match("self"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/XPath.g:818:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // ./scenariotestTemp/generated2/XPath.g:819:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:819:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // ./scenariotestTemp/generated2/XPath.g:819:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // ./scenariotestTemp/generated2/XPath.g:819:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // ./scenariotestTemp/generated2/XPath.g:819:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // ./scenariotestTemp/generated2/XPath.g:819:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // ./scenariotestTemp/generated2/XPath.g:819:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // ./scenariotestTemp/generated2/XPath.g:819:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:819:15: ~ ( '\\r' | '\\n' )
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
            // ./scenariotestTemp/generated2/XPath.g:824:3: ( '$' )
            // ./scenariotestTemp/generated2/XPath.g:825:3: '$'
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
            // ./scenariotestTemp/generated2/XPath.g:830:3: ( '[' )
            // ./scenariotestTemp/generated2/XPath.g:831:3: '['
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
            // ./scenariotestTemp/generated2/XPath.g:836:3: ( ']' )
            // ./scenariotestTemp/generated2/XPath.g:837:3: ']'
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
            // ./scenariotestTemp/generated2/XPath.g:842:3: ( '(' )
            // ./scenariotestTemp/generated2/XPath.g:843:3: '('
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
            // ./scenariotestTemp/generated2/XPath.g:848:3: ( ')' )
            // ./scenariotestTemp/generated2/XPath.g:849:3: ')'
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
            // ./scenariotestTemp/generated2/XPath.g:854:3: ( '::' )
            // ./scenariotestTemp/generated2/XPath.g:855:3: '::'
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
            // ./scenariotestTemp/generated2/XPath.g:860:3: ( '.' )
            // ./scenariotestTemp/generated2/XPath.g:861:3: '.'
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
            // ./scenariotestTemp/generated2/XPath.g:866:3: ( '..' )
            // ./scenariotestTemp/generated2/XPath.g:867:3: '..'
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
            // ./scenariotestTemp/generated2/XPath.g:872:3: ( '@' )
            // ./scenariotestTemp/generated2/XPath.g:873:3: '@'
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
            // ./scenariotestTemp/generated2/XPath.g:878:3: ( '/' )
            // ./scenariotestTemp/generated2/XPath.g:879:3: '/'
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
            // ./scenariotestTemp/generated2/XPath.g:884:3: ( '|' )
            // ./scenariotestTemp/generated2/XPath.g:885:3: '|'
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
            // ./scenariotestTemp/generated2/XPath.g:890:3: ( '-' )
            // ./scenariotestTemp/generated2/XPath.g:891:3: '-'
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
            // ./scenariotestTemp/generated2/XPath.g:896:3: ( '*' )
            // ./scenariotestTemp/generated2/XPath.g:897:3: '*'
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
            // ./scenariotestTemp/generated2/XPath.g:902:3: ( '//' )
            // ./scenariotestTemp/generated2/XPath.g:903:3: '//'
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
            // ./scenariotestTemp/generated2/XPath.g:908:3: ( '+' )
            // ./scenariotestTemp/generated2/XPath.g:909:3: '+'
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
            // ./scenariotestTemp/generated2/XPath.g:914:3: ( '=' )
            // ./scenariotestTemp/generated2/XPath.g:915:3: '='
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
            // ./scenariotestTemp/generated2/XPath.g:920:3: ( '>' )
            // ./scenariotestTemp/generated2/XPath.g:921:3: '>'
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
            // ./scenariotestTemp/generated2/XPath.g:926:3: ( '<' )
            // ./scenariotestTemp/generated2/XPath.g:927:3: '<'
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
            // ./scenariotestTemp/generated2/XPath.g:932:3: ( '>=' )
            // ./scenariotestTemp/generated2/XPath.g:933:3: '>='
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
            // ./scenariotestTemp/generated2/XPath.g:938:3: ( '<=' )
            // ./scenariotestTemp/generated2/XPath.g:939:3: '<='
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
            // ./scenariotestTemp/generated2/XPath.g:944:3: ( '!=' )
            // ./scenariotestTemp/generated2/XPath.g:945:3: '!='
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
            // ./scenariotestTemp/generated2/XPath.g:951:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/XPath.g:951:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/XPath.g:951:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/XPath.g:951:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:952:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:953:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPath.g:954:5: '\\n'
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
            // ./scenariotestTemp/generated2/XPath.g:960:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/XPath.g:960:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/XPath.g:967:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/XPath.g:967:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/XPath.g:972:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/XPath.g:
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
            // ./scenariotestTemp/generated2/XPath.g:983:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/XPath.g:983:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/XPath.g:983:4: ( ALPHA )
            // ./scenariotestTemp/generated2/XPath.g:983:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // ./scenariotestTemp/generated2/XPath.g:983:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/XPath.g:
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
            // ./scenariotestTemp/generated2/XPath.g:987:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/XPath.g:987:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/XPath.g:987:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    // ./scenariotestTemp/generated2/XPath.g:988:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:989:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/XPath.g:990:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/XPath.g:990:6: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/XPath.g:991:6: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/XPath.g:992:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            // ./scenariotestTemp/generated2/XPath.g:1000:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/XPath.g:1000:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/XPath.g:1000:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/XPath.g:1000:5: DIGIT
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
            // ./scenariotestTemp/generated2/XPath.g:1003:7: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // ./scenariotestTemp/generated2/XPath.g:1003:9: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // ./scenariotestTemp/generated2/XPath.g:1003:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/XPath.g:1003:9: DIGIT
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

            // ./scenariotestTemp/generated2/XPath.g:1003:16: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') && (synpred1_XPath())) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/XPath.g:1003:17: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // ./scenariotestTemp/generated2/XPath.g:1003:34: ( DIGIT )+
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
                    	    // ./scenariotestTemp/generated2/XPath.g:1003:34: DIGIT
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
            // ./scenariotestTemp/generated2/XPath.g:1007:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/XPath.g:1007:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // ./scenariotestTemp/generated2/XPath.g:1008:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // ./scenariotestTemp/generated2/XPath.g:1008:5: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/XPath.g:1009:5: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/XPath.g:1010:5: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/XPath.g:1011:5: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/XPath.g:1012:5: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/XPath.g:1013:5: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/XPath.g:1014:5: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/XPath.g:1015:5: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/XPath.g:1016:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/XPath.g:1016:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // ./scenariotestTemp/generated2/XPath.g:1017:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/XPath.g:1017:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/XPath.g:1017:6: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/XPath.g:1018:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/XPath.g:1019:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/XPath.g:1019:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/XPath.g:1019:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // ./scenariotestTemp/generated2/XPath.g:1020:6: ( '0' .. '7' )?
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/XPath.g:1021:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/XPath.g:1024:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/XPath.g:1024:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/XPath.g:1024:7: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // ./scenariotestTemp/generated2/XPath.g:1025:5: ( ( '0' .. '7' ) )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/XPath.g:1026:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/XPath.g:1026:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/XPath.g:1026:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/XPath.g:1035:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/XPath.g:1035:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // ./scenariotestTemp/generated2/XPath.g:1036:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // ./scenariotestTemp/generated2/XPath.g:1036:5: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/XPath.g:1037:5: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/XPath.g:1038:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
        // ./scenariotestTemp/generated2/XPath.g:1:8: ( T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | COMMENT | DOLLAR | LSQUARE | RSQUARE | LPAREN | RPAREN | COLONS | POINT | POINTPOINT | AROBAS | SLASH | PIPE | MINUS | STAR | SLASHSLASH | PLUS | EQ | GT | LT | GE | LE | EXCLEQ | NL | WS | NAME | INT | FLOAT | STRING )
        int alt16=48;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ./scenariotestTemp/generated2/XPath.g:1:10: T__36
                {
                mT__36(); if (state.failed) return ;

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/XPath.g:1:16: T__37
                {
                mT__37(); if (state.failed) return ;

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/XPath.g:1:22: T__38
                {
                mT__38(); if (state.failed) return ;

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/XPath.g:1:28: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/XPath.g:1:34: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/XPath.g:1:40: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/XPath.g:1:46: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/XPath.g:1:52: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/XPath.g:1:58: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/XPath.g:1:64: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/XPath.g:1:70: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/XPath.g:1:76: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/XPath.g:1:82: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/XPath.g:1:88: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/XPath.g:1:94: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/XPath.g:1:100: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/XPath.g:1:106: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/XPath.g:1:112: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/XPath.g:1:118: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/XPath.g:1:124: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/XPath.g:1:130: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/XPath.g:1:138: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/XPath.g:1:145: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/XPath.g:1:153: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/XPath.g:1:161: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/XPath.g:1:168: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/XPath.g:1:175: COLONS
                {
                mCOLONS(); if (state.failed) return ;

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/XPath.g:1:182: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/XPath.g:1:188: POINTPOINT
                {
                mPOINTPOINT(); if (state.failed) return ;

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/XPath.g:1:199: AROBAS
                {
                mAROBAS(); if (state.failed) return ;

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/XPath.g:1:206: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/XPath.g:1:212: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/XPath.g:1:217: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/XPath.g:1:223: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/XPath.g:1:228: SLASHSLASH
                {
                mSLASHSLASH(); if (state.failed) return ;

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/XPath.g:1:239: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/XPath.g:1:244: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/XPath.g:1:247: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/XPath.g:1:250: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/XPath.g:1:253: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/XPath.g:1:256: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/XPath.g:1:259: EXCLEQ
                {
                mEXCLEQ(); if (state.failed) return ;

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/XPath.g:1:266: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/XPath.g:1:269: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/XPath.g:1:272: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 46 :
                // ./scenariotestTemp/generated2/XPath.g:1:277: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 47 :
                // ./scenariotestTemp/generated2/XPath.g:1:281: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 48 :
                // ./scenariotestTemp/generated2/XPath.g:1:287: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_XPath
    public final void synpred1_XPath_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/XPath.g:1003:17: ( '.' DIGIT )
        // ./scenariotestTemp/generated2/XPath.g:1003:18: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_XPath

    public final boolean synpred1_XPath() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_XPath_fragment(); // can never throw exception
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
        "\1\uffff\4\37\1\uffff\6\37\1\61\6\uffff\1\63\1\uffff\1\65\4\uffff"+
        "\1\67\1\71\4\uffff\1\72\1\uffff\5\37\1\102\10\37\14\uffff\1\113"+
        "\1\37\1\115\1\116\2\37\1\uffff\10\37\1\uffff\1\37\2\uffff\2\37\1"+
        "\134\1\37\1\136\4\37\1\143\3\37\1\uffff\1\37\1\uffff\1\150\3\37"+
        "\1\uffff\4\37\1\uffff\1\37\1\161\6\37\1\uffff\2\37\1\173\5\37\2"+
        "\uffff\1\u0081\1\u0082\1\u0084\1\u0086\1\u0088\10\uffff";
    static final String DFA16_eofS =
        "\u0089\uffff";
    static final String DFA16_minS =
        "\1\11\1\145\1\157\1\156\1\162\1\uffff\1\141\1\145\1\150\1\157\1"+
        "\141\1\145\1\55\6\uffff\1\56\1\uffff\1\57\4\uffff\2\75\4\uffff\1"+
        "\56\1\uffff\1\166\1\163\1\144\1\143\1\164\1\60\1\144\1\155\1\170"+
        "\1\151\1\154\1\162\1\145\1\154\14\uffff\1\60\1\143\2\60\1\145\1"+
        "\162\1\uffff\2\145\1\164\2\154\1\145\1\143\1\146\1\uffff\1\145\2"+
        "\uffff\1\163\1\151\1\60\1\163\1\60\1\144\1\157\1\156\1\145\1\60"+
        "\1\156\1\164\1\142\1\uffff\1\160\1\uffff\1\60\1\167\1\164\1\144"+
        "\1\uffff\1\144\1\157\1\165\1\141\1\uffff\1\151\1\60\1\151\1\141"+
        "\1\162\1\164\1\143\1\156\1\uffff\2\156\1\55\2\145\2\147\1\164\2"+
        "\uffff\2\60\3\55\10\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\151\1\157\1\164\1\162\1\uffff\1\157\1\145\1\150\1\157"+
        "\1\162\1\145\1\55\6\uffff\1\56\1\uffff\1\57\4\uffff\2\75\4\uffff"+
        "\1\71\1\uffff\1\166\1\163\2\144\1\164\1\u00ff\1\144\1\155\1\170"+
        "\1\151\1\154\1\162\1\145\1\154\14\uffff\1\u00ff\1\143\2\u00ff\1"+
        "\145\1\162\1\uffff\2\145\1\164\2\154\1\145\1\143\1\146\1\uffff\1"+
        "\145\2\uffff\1\163\1\151\1\u00ff\1\163\1\u00ff\1\144\1\157\1\156"+
        "\1\145\1\u00ff\1\156\1\164\1\142\1\uffff\1\160\1\uffff\1\u00ff\1"+
        "\167\1\164\1\144\1\uffff\1\144\1\157\1\165\1\141\1\uffff\1\151\1"+
        "\u00ff\1\151\1\141\1\162\1\164\1\143\1\156\1\uffff\2\156\1\u00ff"+
        "\2\145\2\147\1\164\2\uffff\5\u00ff\10\uffff";
    static final String DFA16_acceptS =
        "\5\uffff\1\5\7\uffff\1\26\1\27\1\30\1\31\1\32\1\33\1\uffff\1\36"+
        "\1\uffff\1\40\1\42\1\44\1\45\2\uffff\1\52\1\53\1\54\1\55\1\uffff"+
        "\1\60\16\uffff\1\25\1\41\1\35\1\34\1\43\1\37\1\50\1\46\1\51\1\47"+
        "\1\56\1\57\6\uffff\1\4\10\uffff\1\1\1\uffff\1\2\1\3\15\uffff\1\6"+
        "\1\uffff\1\7\4\uffff\1\24\4\uffff\1\13\10\uffff\1\21\10\uffff\1"+
        "\11\1\10\5\uffff\1\12\1\20\1\17\1\16\1\23\1\22\1\15\1\14";
    static final String DFA16_specialS =
        "\u0089\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\36\1\35\2\uffff\1\35\22\uffff\1\36\1\34\1\37\1\uffff\1\15"+
            "\2\uffff\1\41\1\20\1\21\1\27\1\30\1\5\1\14\1\23\1\25\12\40\1"+
            "\22\1\uffff\1\33\1\31\1\32\1\uffff\1\24\32\37\1\16\1\uffff\1"+
            "\17\1\uffff\1\37\1\uffff\1\3\1\37\1\10\1\1\1\37\1\11\6\37\1"+
            "\2\1\6\1\4\1\12\2\37\1\13\1\7\6\37\1\uffff\1\26\103\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\43\3\uffff\1\42",
            "\1\44",
            "\1\45\5\uffff\1\46",
            "\1\47",
            "",
            "\1\51\15\uffff\1\50",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55\20\uffff\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\62",
            "",
            "\1\64",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\70",
            "",
            "",
            "",
            "",
            "\1\73\1\uffff\12\40",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\100\1\77",
            "\1\101",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
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
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\114",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "",
            "",
            "\1\132",
            "\1\133",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\135",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "\1\147",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\151",
            "\1\152",
            "\1\153",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\1\160",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\1\170",
            "\1\171",
            "\1\172\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32"+
            "\37\105\uffff\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff\27"+
            "\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u0083\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32"+
            "\37\105\uffff\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u0085\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32"+
            "\37\105\uffff\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u0087\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32"+
            "\37\105\uffff\27\37\1\uffff\37\37\1\uffff\10\37",
            "",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | COMMENT | DOLLAR | LSQUARE | RSQUARE | LPAREN | RPAREN | COLONS | POINT | POINTPOINT | AROBAS | SLASH | PIPE | MINUS | STAR | SLASHSLASH | PLUS | EQ | GT | LT | GE | LE | EXCLEQ | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}