// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g 2010-02-11 14:42:57

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
public class ModuleLexer extends Lexer {
    public static final int EXCLUDINGAT=35;
    public static final int STAR=41;
    public static final int RBRACK_RCURL=40;
    public static final int LANGLE=17;
    public static final int EQUALS=22;
    public static final int EXCL=21;
    public static final int FLOAT=7;
    public static final int INCLUDINGAT=34;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int LBRACKET=13;
    public static final int RPAREN=20;
    public static final int DCOLON=30;
    public static final int NAME=4;
    public static final int OBJECT=47;
    public static final int LBRACK_LCURL=38;
    public static final int PIPE=28;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int RANGE_OR_INT=48;
    public static final int RANGLE=18;
    public static final int RBRACKET=14;
    public static final int COMMENT=11;
    public static final int DOT=25;
    public static final int EQUALSEQUALS=23;
    public static final int RCURL_RBRACK=39;
    public static final int LCURL_LBRACK=37;
    public static final int DDOT=26;
    public static final int BOOL=8;
    public static final int INT=6;
    public static final int SEMICOLON=31;
    public static final int EXCLUDING=33;
    public static final int MULTI_LINE_COMMENT=12;
    public static final int ALPHA=45;
    public static final int COLON=29;
    public static final int ITERATE=36;
    public static final int LCURL=15;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURL=16;
    public static final int ASSIGN=24;
    public static final int ARROW=27;
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

    public ModuleLexer() {;} 
    public ModuleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ModuleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g"; }

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:331:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:332:15: ~ ( '\\r' | '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:337:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:338:43: ( '\\n' | ~ '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:343:3: ( '[' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:344:3: '['
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:349:3: ( ']' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:350:3: ']'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:355:3: ( '{' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:356:3: '{'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:361:3: ( '}' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:362:3: '}'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:367:3: ( '<' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:368:3: '<'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:373:3: ( '>' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:374:3: '>'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:379:3: ( '(' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:380:3: '('
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:385:3: ( ')' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:386:3: ')'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:391:3: ( '!' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:392:3: '!'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:397:3: ( '=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:398:3: '='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:403:3: ( '==' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:404:3: '=='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:409:3: ( ':=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:410:3: ':='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:415:3: ( '.' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:416:3: '.'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:421:3: ( '..' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:422:3: '..'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:427:3: ( '->' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:428:3: '->'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:433:3: ( '|' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:434:3: '|'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:439:3: ( ':' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:440:3: ':'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:445:3: ( '::' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:446:3: '::'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:451:3: ( ';' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:452:3: ';'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:457:3: ( 'including' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:458:3: 'including'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:463:3: ( 'excluding' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:464:3: 'excluding'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:469:3: ( 'includingAt' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:470:3: 'includingAt'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:475:3: ( 'excludingAt' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:476:3: 'excludingAt'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:481:3: ( 'iterate' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:482:3: 'iterate'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:487:3: ( '{[' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:488:3: '{['
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:493:3: ( '[{' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:494:3: '[{'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:499:3: ( '}]' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:500:3: '}]'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:505:3: ( ']}' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:506:3: ']}'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:511:3: ( '*' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:512:3: '*'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:521:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:521:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:521:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:521:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:522:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:523:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:524:5: '\\n'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:530:2: ( ( ' ' | '\\t' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:530:4: ( ' ' | '\\t' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:537:2: ( '0' .. '9' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:537:4: '0' .. '9'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:542:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:553:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:553:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:553:4: ( ALPHA )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:553:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:553:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:556:6: ( 'true' | 'false' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:556:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:556:17: 'false'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:558:8: ( 'o:' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:558:10: 'o:'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:561:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:561:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:561:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:562:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:563:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:564:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:566:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:567:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:574:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:574:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:574:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='F')||(LA8_0>='a' && LA8_0<='f')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:574:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:579:2: ( ( DIGIT )+ )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:579:4: ( DIGIT )+
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:579:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:579:5: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:4: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:584:15: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:588:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred3_Module())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred3_Module())) {
                    alt12=3;
                }
                else if ( (synpred1_Module()) ) {
                    alt12=1;
                }
                else if ( (synpred2_Module()) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:588:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:589:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:590:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:597:9: INT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:601:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:601:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:601:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==' '||LA17_0=='T') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:601:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:602:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==','||LA14_0=='.') && (synpred4_Module())) {
                        alt14=1;
                    }
                    else {
                        alt14=2;}
                    switch (alt14) {
                        case 1 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:41: ( ',' | '.' ) ( DIGIT )+
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

                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:53: ( DIGIT )+
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
                            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:54: DIGIT
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


                            }
                            break;
                        case 2 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:605:13: 
                            {
                            }
                            break;

                    }

                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:606:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='Z') ) {
                        alt16=1;
                    }
                    else {
                        alt16=2;}
                    switch (alt16) {
                        case 1 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:606:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:606:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:606:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:606:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:609:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:609:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:610:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:612:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:613:5: ~ ( '\\\\' | '\"' | '\\n' )
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:8: ( COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt19=41;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:10: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:18: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:37: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:46: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:55: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:61: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:67: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:74: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:81: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:88: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:95: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:100: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:107: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:120: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:127: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:131: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:136: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:142: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:147: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:153: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:160: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:170: INCLUDING
                {
                mINCLUDING(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:180: EXCLUDING
                {
                mEXCLUDING(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:190: INCLUDINGAT
                {
                mINCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:202: EXCLUDINGAT
                {
                mEXCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:214: ITERATE
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:222: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:235: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:248: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:261: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:274: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:279: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:282: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:285: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:290: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:297: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:302: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:309: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:313: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:326: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:1:331: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Module
    public final void synpred1_Module_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:588:9: ( INT '..' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:588:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_Module

    // $ANTLR start synpred2_Module
    public final void synpred2_Module_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:589:7: ( INT '.' NAME )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:589:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Module

    // $ANTLR start synpred3_Module
    public final void synpred3_Module_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:590:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:590:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred3_Module

    // $ANTLR start synpred4_Module
    public final void synpred4_Module_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:15: ( ( ',' | '.' ) DIGIT )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:603:17: ( ',' | '.' ) DIGIT
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

        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Module

    public final boolean synpred4_Module() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Module_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Module() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Module_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Module() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Module_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Module() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Module_fragment(); // can never throw exception
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
        "\2\uffff\1\40\1\42\1\44\1\46\5\uffff\1\50\1\53\1\55\3\uffff\2\31"+
        "\3\uffff\3\31\1\uffff\2\65\22\uffff\5\31\3\uffff\1\65\1\uffff\5"+
        "\31\1\65\3\31\1\107\1\31\1\65\3\31\1\uffff\1\107\1\65\1\uffff\4"+
        "\31\1\122\2\31\1\uffff\1\31\1\127\1\131\1\31\1\uffff\1\31\1\uffff"+
        "\1\134\1\135\2\uffff";
    static final String DFA19_eofS =
        "\136\uffff";
    static final String DFA19_minS =
        "\1\11\1\52\1\173\1\175\1\133\1\135\5\uffff\1\75\1\72\1\56\3\uffff"+
        "\1\156\1\170\3\uffff\1\162\1\141\1\72\1\uffff\2\56\22\uffff\1\143"+
        "\1\145\1\143\1\165\1\154\3\uffff\1\56\1\uffff\1\154\1\162\1\154"+
        "\1\145\1\163\1\56\1\165\1\141\1\165\1\60\1\145\1\55\1\144\1\164"+
        "\1\144\1\uffff\1\60\1\56\1\uffff\1\151\1\145\1\151\1\156\1\60\1"+
        "\156\1\147\1\uffff\1\147\2\60\1\164\1\uffff\1\164\1\uffff\2\60\2"+
        "\uffff";
    static final String DFA19_maxS =
        "\1\u00ff\1\57\1\173\1\175\1\133\1\135\5\uffff\2\75\1\56\3\uffff"+
        "\1\164\1\170\3\uffff\1\162\1\141\1\72\1\uffff\1\170\1\71\22\uffff"+
        "\1\143\1\145\1\143\1\165\1\154\3\uffff\1\71\1\uffff\1\154\1\162"+
        "\1\154\1\145\1\163\1\71\1\165\1\141\1\165\1\u00ff\1\145\1\71\1\144"+
        "\1\164\1\144\1\uffff\1\u00ff\1\71\1\uffff\1\151\1\145\1\151\1\156"+
        "\1\u00ff\1\156\1\147\1\uffff\1\147\2\u00ff\1\164\1\uffff\1\164\1"+
        "\uffff\2\u00ff\2\uffff";
    static final String DFA19_acceptS =
        "\6\uffff\1\7\1\10\1\11\1\12\1\13\3\uffff\1\21\1\22\1\25\2\uffff"+
        "\1\37\1\40\1\41\3\uffff\1\44\2\uffff\1\51\1\1\1\2\1\34\1\3\1\36"+
        "\1\4\1\33\1\5\1\35\1\6\1\15\1\14\1\16\1\24\1\23\1\20\1\17\5\uffff"+
        "\1\43\1\45\1\46\1\uffff\1\47\17\uffff\1\42\2\uffff\1\50\7\uffff"+
        "\1\32\4\uffff\1\26\1\uffff\1\27\2\uffff\1\30\1\31";
    static final String DFA19_specialS =
        "\136\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\25\1\24\2\uffff\1\24\22\uffff\1\25\1\12\1\34\4\uffff\1\31"+
            "\1\10\1\11\1\23\2\uffff\1\16\1\15\1\1\1\32\11\33\1\14\1\20\1"+
            "\6\1\13\1\7\2\uffff\32\31\1\2\1\uffff\1\3\1\uffff\1\31\1\uffff"+
            "\4\31\1\22\1\27\2\31\1\21\5\31\1\30\4\31\1\26\6\31\1\4\1\17"+
            "\1\5\102\uffff\27\31\1\uffff\37\31\1\uffff\10\31",
            "\1\36\4\uffff\1\35",
            "\1\37",
            "\1\41",
            "\1\43",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\52\2\uffff\1\51",
            "\1\54",
            "",
            "",
            "",
            "\1\56\5\uffff\1\57",
            "\1\60",
            "",
            "",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\67\1\uffff\12\66\76\uffff\1\64",
            "\1\67\1\uffff\12\66",
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
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "\1\67\1\uffff\12\75",
            "",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\67\1\uffff\12\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31\105\uffff"+
            "\27\31\1\uffff\37\31\1\uffff\10\31",
            "\1\110",
            "\1\112\1\67\1\uffff\12\111",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31\105\uffff"+
            "\27\31\1\uffff\37\31\1\uffff\10\31",
            "\1\67\1\uffff\12\111",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31\105\uffff"+
            "\27\31\1\uffff\37\31\1\uffff\10\31",
            "\1\123",
            "\1\124",
            "",
            "\1\125",
            "\12\31\7\uffff\1\126\31\31\4\uffff\1\31\1\uffff\32\31\105"+
            "\uffff\27\31\1\uffff\37\31\1\uffff\10\31",
            "\12\31\7\uffff\1\130\31\31\4\uffff\1\31\1\uffff\32\31\105"+
            "\uffff\27\31\1\uffff\37\31\1\uffff\10\31",
            "\1\132",
            "",
            "\1\133",
            "",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31\105\uffff"+
            "\27\31\1\uffff\37\31\1\uffff\10\31",
            "\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31\105\uffff"+
            "\27\31\1\uffff\37\31\1\uffff\10\31",
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
            return "1:1: Tokens : ( COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}