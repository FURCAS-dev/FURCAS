// $ANTLR 3.1.1 C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g 2009-08-18 08:44:42

package generated;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.grammar.antlr3.DefaultANTLR3LocationTokenFactory;
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
public class RunletTestLexer extends Lexer {
    public static final int EXCLUDINGAT=35;
    public static final int STAR=41;
    public static final int RBRACK_RCURL=40;
    public static final int LANGLE=18;
    public static final int EQUALS=23;
    public static final int EXCL=22;
    public static final int FLOAT=7;
    public static final int INCLUDINGAT=34;
    public static final int EOF=-1;
    public static final int LPAREN=20;
    public static final int LBRACKET=16;
    public static final int RPAREN=21;
    public static final int DCOLON=31;
    public static final int NAME=4;
    public static final int OBJECT=47;
    public static final int LBRACK_LCURL=38;
    public static final int PIPE=29;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int RANGE_OR_INT=48;
    public static final int RBRACKET=17;
    public static final int RANGLE=19;
    public static final int COMMENT=14;
    public static final int DOT=26;
    public static final int T__50=50;
    public static final int EQUALSEQUALS=24;
    public static final int RCURL_RBRACK=39;
    public static final int LCURL_LBRACK=37;
    public static final int DDOT=27;
    public static final int T__49=49;
    public static final int BOOL=8;
    public static final int SEMICOLON=12;
    public static final int INT=6;
    public static final int EXCLUDING=33;
    public static final int MULTI_LINE_COMMENT=15;
    public static final int ALPHA=45;
    public static final int COLON=30;
    public static final int ITERATE=36;
    public static final int LCURL=11;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURL=13;
    public static final int ASSIGN=25;
    public static final int ARROW=28;
    public static final int BINARY=9;
    public static final int DATE=10;
    public static final int INCLUDING=32;
    public static final int STRING=5;
      public com.sap.mi.textual.grammar.IModelInjector ei = null;
    public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
      /*************** Code generated in class com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
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
      /*************** End of Code generated in class com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/


    // delegates
    // delegators

    public RunletTestLexer() {;} 
    public RunletTestLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RunletTestLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g"; }

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:117:7: ( 'sub' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:117:9: 'sub'
            {
            match("sub"); if (state.failed) return ;


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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:118:7: ( 'runlettest' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:118:9: 'runlettest'
            {
            match("runlettest"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:341:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:342:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "MULTI_LINE_COMMENT"
    public final void mMULTI_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:347:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:348:43: ( '\\n' | ~ '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\uFFFF') ) {
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
            	    break loop2;
                }
            } while (true);

            match("*/"); if (state.failed) return ;


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
    // $ANTLR end "MULTI_LINE_COMMENT"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:353:3: ( '[' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:354:3: '['
            {
            match('['); if (state.failed) return ;

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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:359:3: ( ']' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:360:3: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "LCURL"
    public final void mLCURL() throws RecognitionException {
        try {
            int _type = LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:365:3: ( '{' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:366:3: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURL"

    // $ANTLR start "RCURL"
    public final void mRCURL() throws RecognitionException {
        try {
            int _type = RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:371:3: ( '}' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:372:3: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURL"

    // $ANTLR start "LANGLE"
    public final void mLANGLE() throws RecognitionException {
        try {
            int _type = LANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:377:3: ( '<' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:378:3: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LANGLE"

    // $ANTLR start "RANGLE"
    public final void mRANGLE() throws RecognitionException {
        try {
            int _type = RANGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:383:3: ( '>' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:384:3: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGLE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:389:3: ( '(' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:390:3: '('
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:395:3: ( ')' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:396:3: ')'
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

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:401:3: ( '!' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:402:3: '!'
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

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:407:3: ( '=' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:408:3: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "EQUALSEQUALS"
    public final void mEQUALSEQUALS() throws RecognitionException {
        try {
            int _type = EQUALSEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:413:3: ( '==' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:414:3: '=='
            {
            match("=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALSEQUALS"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:419:3: ( ':=' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:420:3: ':='
            {
            match(":="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:425:3: ( '.' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:426:3: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DDOT"
    public final void mDDOT() throws RecognitionException {
        try {
            int _type = DDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:431:3: ( '..' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:432:3: '..'
            {
            match(".."); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DDOT"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:437:3: ( '->' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:438:3: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:443:3: ( '|' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:444:3: '|'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:449:3: ( ':' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:450:3: ':'
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

    // $ANTLR start "DCOLON"
    public final void mDCOLON() throws RecognitionException {
        try {
            int _type = DCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:455:3: ( '::' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:456:3: '::'
            {
            match("::"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DCOLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:461:3: ( ';' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:462:3: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "INCLUDING"
    public final void mINCLUDING() throws RecognitionException {
        try {
            int _type = INCLUDING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:467:3: ( 'including' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:468:3: 'including'
            {
            match("including"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDING"

    // $ANTLR start "EXCLUDING"
    public final void mEXCLUDING() throws RecognitionException {
        try {
            int _type = EXCLUDING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:473:3: ( 'excluding' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:474:3: 'excluding'
            {
            match("excluding"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLUDING"

    // $ANTLR start "INCLUDINGAT"
    public final void mINCLUDINGAT() throws RecognitionException {
        try {
            int _type = INCLUDINGAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:479:3: ( 'includingAt' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:480:3: 'includingAt'
            {
            match("includingAt"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDINGAT"

    // $ANTLR start "EXCLUDINGAT"
    public final void mEXCLUDINGAT() throws RecognitionException {
        try {
            int _type = EXCLUDINGAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:485:3: ( 'excludingAt' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:486:3: 'excludingAt'
            {
            match("excludingAt"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLUDINGAT"

    // $ANTLR start "ITERATE"
    public final void mITERATE() throws RecognitionException {
        try {
            int _type = ITERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:491:3: ( 'iterate' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:492:3: 'iterate'
            {
            match("iterate"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ITERATE"

    // $ANTLR start "LCURL_LBRACK"
    public final void mLCURL_LBRACK() throws RecognitionException {
        try {
            int _type = LCURL_LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:497:3: ( '{[' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:498:3: '{['
            {
            match("{["); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURL_LBRACK"

    // $ANTLR start "LBRACK_LCURL"
    public final void mLBRACK_LCURL() throws RecognitionException {
        try {
            int _type = LBRACK_LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:503:3: ( '[{' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:504:3: '[{'
            {
            match("[{"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK_LCURL"

    // $ANTLR start "RCURL_RBRACK"
    public final void mRCURL_RBRACK() throws RecognitionException {
        try {
            int _type = RCURL_RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:509:3: ( '}]' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:510:3: '}]'
            {
            match("}]"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURL_RBRACK"

    // $ANTLR start "RBRACK_RCURL"
    public final void mRBRACK_RCURL() throws RecognitionException {
        try {
            int _type = RBRACK_RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:515:3: ( ']}' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:516:3: ']}'
            {
            match("]}"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK_RCURL"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:521:3: ( '*' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:522:3: '*'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:531:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:531:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:531:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=3;}
            }
            else if ( (LA3_0=='\n') ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2=='\r') ) {
                    alt3=2;
                }
                else {
                    alt3=4;}
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:531:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:532:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:533:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:534:5: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              newline();_channel=HIDDEN;
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:540:2: ( ( ' ' | '\\t' ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:540:4: ( ' ' | '\\t' )
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

            if ( state.backtracking==0 ) {
              _channel=HIDDEN;
            }

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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:547:2: ( '0' .. '9' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:547:4: '0' .. '9'
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:552:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:563:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:563:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:563:4: ( ALPHA )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:563:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:563:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:
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
            	    break loop4;
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:566:6: ( 'true' | 'false' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='t') ) {
                alt5=1;
            }
            else if ( (LA5_0=='f') ) {
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
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:566:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:566:17: 'false'
                    {
                    match("false"); if (state.failed) return ;


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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:568:8: ( 'o:' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:568:10: 'o:'
            {
            match("o:"); if (state.failed) return ;


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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:571:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:571:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:571:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u00FF')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:572:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:573:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:574:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\n') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:576:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:577:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); if (state.failed) return ;

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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:584:2: ( '0x' ( DIGIT )+ )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:584:4: '0x' ( DIGIT )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:584:8: ( DIGIT )+
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
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:584:9: DIGIT
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:589:2: ( ( DIGIT )+ )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:589:4: ( DIGIT )+
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:589:4: ( DIGIT )+
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
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:589:5: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:4: ( DIGIT )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:4: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            match('.'); if (state.failed) return ;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:594:15: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "RANGE_OR_INT"
    public final void mRANGE_OR_INT() throws RecognitionException {
        try {
            int _type = RANGE_OR_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:598:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred3_RunletTest())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred3_RunletTest())) {
                    alt12=3;
                }
                else if ( (synpred1_RunletTest()) ) {
                    alt12=1;
                }
                else if ( (synpred2_RunletTest()) ) {
                    alt12=2;
                }
                else if ( (true) ) {
                    alt12=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:598:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:599:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:600:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:607:9: INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE_OR_INT"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:611:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ',' | '.' ) ( DIGIT )+ )? ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:611:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ',' | '.' ) ( DIGIT )+ )? ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            {
            mDIGIT(); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            match('-'); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            match('-'); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            mDIGIT(); if (state.failed) return ;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:611:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ',' | '.' ) ( DIGIT )+ )? ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==' '||LA17_0=='T') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:611:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ',' | '.' ) ( DIGIT )+ )? ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    {
                    if ( input.LA(1)==' '||input.LA(1)=='T' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mDIGIT(); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    match(':'); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    match(':'); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    mDIGIT(); if (state.failed) return ;
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:13: ( ( ',' | '.' ) ( DIGIT )+ )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==','||LA14_0=='.') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:14: ( ',' | '.' ) ( DIGIT )+
                            {
                            if ( input.LA(1)==','||input.LA(1)=='.' ) {
                                input.consume();
                            state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:24: ( DIGIT )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:25: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }

                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:35: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='Z') ) {
                        alt16=1;
                    }
                    else {
                        alt16=2;}
                    switch (alt16) {
                        case 1 :
                            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:36: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:42: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:42: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:612:43: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();
                                    state.failed=false;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}

                                    mDIGIT(); if (state.failed) return ;
                                    mDIGIT(); if (state.failed) return ;
                                    mDIGIT(); if (state.failed) return ;
                                    mDIGIT(); if (state.failed) return ;

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
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:615:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:615:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:616:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\n') ) {
                    alt18=1;
                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='\t')||(LA18_0>='\u000B' && LA18_0<='!')||(LA18_0>='#' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:618:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:619:5: ~ ( '\\\\' | '\"' | '\\n' )
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
            	    break loop18;
                }
            } while (true);

            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:8: ( T__49 | T__50 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt19=43;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:10: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:16: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:22: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:30: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:49: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:58: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:67: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:73: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:79: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:86: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:93: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:100: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:107: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:112: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:119: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:132: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:139: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:143: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:148: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:154: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:159: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:165: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:172: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:182: INCLUDING
                {
                mINCLUDING(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:192: EXCLUDING
                {
                mEXCLUDING(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:202: INCLUDINGAT
                {
                mINCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:214: EXCLUDINGAT
                {
                mEXCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:226: ITERATE
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:234: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:247: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:260: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:273: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:286: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:291: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:294: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:297: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:302: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:309: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:314: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:321: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:325: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:338: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:1:343: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_RunletTest
    public final void synpred1_RunletTest_fragment() throws RecognitionException {   
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:598:9: ( INT '..' )
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:598:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_RunletTest

    // $ANTLR start synpred2_RunletTest
    public final void synpred2_RunletTest_fragment() throws RecognitionException {   
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:599:7: ( INT '.' NAME )
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:599:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_RunletTest

    // $ANTLR start synpred3_RunletTest
    public final void synpred3_RunletTest_fragment() throws RecognitionException {   
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:600:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:600:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        if ( (input.LA(1)>='\u0000' && input.LA(1)<='-')||(input.LA(1)>='/' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='^')||input.LA(1)=='`'||(input.LA(1)>='{' && input.LA(1)<='\u00BF')||input.LA(1)=='\u00D7'||input.LA(1)=='\u00F7'||(input.LA(1)>='\u0100' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end synpred3_RunletTest

    public final boolean synpred1_RunletTest() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_RunletTest_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_RunletTest() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_RunletTest_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_RunletTest() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_RunletTest_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\2\33\1\uffff\1\44\1\46\1\50\1\52\5\uffff\1\54\1\57\1\61"+
        "\3\uffff\2\33\3\uffff\3\33\1\uffff\2\71\1\uffff\2\33\21\uffff\5"+
        "\33\3\uffff\1\71\1\uffff\1\104\6\33\1\71\1\uffff\4\33\1\120\1\33"+
        "\1\71\4\33\1\uffff\1\120\1\71\1\uffff\6\33\1\136\3\33\1\uffff\2"+
        "\33\1\145\1\147\1\150\1\33\1\uffff\1\33\2\uffff\1\153\1\154\2\uffff";
    static final String DFA19_eofS =
        "\155\uffff";
    static final String DFA19_minS =
        "\1\11\2\165\1\52\1\173\1\175\1\133\1\135\5\uffff\1\75\1\72\1\56"+
        "\3\uffff\1\156\1\170\3\uffff\1\162\1\141\1\72\1\uffff\2\56\1\uffff"+
        "\1\142\1\156\21\uffff\1\143\1\145\1\143\1\165\1\154\3\uffff\1\56"+
        "\1\uffff\1\60\2\154\1\162\1\154\1\145\1\163\1\56\1\uffff\1\145\1"+
        "\165\1\141\1\165\1\60\1\145\1\55\1\164\1\144\1\164\1\144\1\uffff"+
        "\1\60\1\56\1\uffff\1\164\1\151\1\145\1\151\1\145\1\156\1\60\1\156"+
        "\1\163\1\147\1\uffff\1\147\1\164\3\60\1\164\1\uffff\1\164\2\uffff"+
        "\2\60\2\uffff";
    static final String DFA19_maxS =
        "\1\u00ff\2\165\1\57\1\173\1\175\1\133\1\135\5\uffff\2\75\1\56\3"+
        "\uffff\1\164\1\170\3\uffff\1\162\1\141\1\72\1\uffff\1\170\1\71\1"+
        "\uffff\1\142\1\156\21\uffff\1\143\1\145\1\143\1\165\1\154\3\uffff"+
        "\1\71\1\uffff\1\u00ff\2\154\1\162\1\154\1\145\1\163\1\71\1\uffff"+
        "\1\145\1\165\1\141\1\165\1\u00ff\1\145\1\71\1\164\1\144\1\164\1"+
        "\144\1\uffff\1\u00ff\1\71\1\uffff\1\164\1\151\1\145\1\151\1\145"+
        "\1\156\1\u00ff\1\156\1\163\1\147\1\uffff\1\147\1\164\3\u00ff\1\164"+
        "\1\uffff\1\164\2\uffff\2\u00ff\2\uffff";
    static final String DFA19_acceptS =
        "\10\uffff\1\11\1\12\1\13\1\14\1\15\3\uffff\1\23\1\24\1\27\2\uffff"+
        "\1\41\1\42\1\43\3\uffff\1\46\2\uffff\1\53\2\uffff\1\3\1\4\1\36\1"+
        "\5\1\40\1\6\1\35\1\7\1\37\1\10\1\17\1\16\1\20\1\26\1\25\1\22\1\21"+
        "\5\uffff\1\45\1\47\1\50\1\uffff\1\51\10\uffff\1\1\13\uffff\1\44"+
        "\2\uffff\1\52\12\uffff\1\34\6\uffff\1\30\1\uffff\1\31\1\2\2\uffff"+
        "\1\32\1\33";
    static final String DFA19_specialS =
        "\155\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\27\1\26\2\uffff\1\26\22\uffff\1\27\1\14\1\36\4\uffff\1\33"+
            "\1\12\1\13\1\25\2\uffff\1\20\1\17\1\3\1\34\11\35\1\16\1\22\1"+
            "\10\1\15\1\11\2\uffff\32\33\1\4\1\uffff\1\5\1\uffff\1\33\1\uffff"+
            "\4\33\1\24\1\31\2\33\1\23\5\33\1\32\2\33\1\2\1\1\1\30\6\33\1"+
            "\6\1\21\1\7\102\uffff\27\33\1\uffff\37\33\1\uffff\10\33",
            "\1\37",
            "\1\40",
            "\1\42\4\uffff\1\41",
            "\1\43",
            "\1\45",
            "\1\47",
            "\1\51",
            "",
            "",
            "",
            "",
            "",
            "\1\53",
            "\1\56\2\uffff\1\55",
            "\1\60",
            "",
            "",
            "",
            "\1\62\5\uffff\1\63",
            "\1\64",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "\1\73\1\uffff\12\72\76\uffff\1\70",
            "\1\73\1\uffff\12\72",
            "",
            "\1\74",
            "\1\75",
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
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "",
            "",
            "",
            "\1\73\1\uffff\12\103",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\73\1\uffff\12\113",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\1\121",
            "\1\123\1\73\1\uffff\12\122",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\1\73\1\uffff\12\122",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "\1\142",
            "\1\143",
            "\12\33\7\uffff\1\144\31\33\4\uffff\1\33\1\uffff\32\33\105\uffff"+
            "\27\33\1\uffff\37\33\1\uffff\10\33",
            "\12\33\7\uffff\1\146\31\33\4\uffff\1\33\1\uffff\32\33\105\uffff"+
            "\27\33\1\uffff\37\33\1\uffff\10\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\1\151",
            "",
            "\1\152",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33\105\uffff\27"+
            "\33\1\uffff\37\33\1\uffff\10\33",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__49 | T__50 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}