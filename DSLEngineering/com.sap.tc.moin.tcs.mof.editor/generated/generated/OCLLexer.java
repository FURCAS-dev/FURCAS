// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g 2010-08-18 16:52:55

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
public class OCLLexer extends Lexer {
    public static final int STAR=21;
    public static final int RBRACK_RCURL=23;
    public static final int FLOAT=9;
    public static final int EOF=-1;
    public static final int LPAREN=11;
    public static final int LBRACKET=19;
    public static final int RPAREN=12;
    public static final int DCOLON=13;
    public static final int NAME=4;
    public static final int LBRACK_LCURL=24;
    public static final int NL=26;
    public static final int DIGIT=28;
    public static final int RBRACKET=20;
    public static final int RANGE_OR_INT=31;
    public static final int COMMENT=18;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int RCURL_RBRACK=25;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int LCURL_LBRACK=22;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=16;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=29;
    public static final int COLON=17;
    public static final int T__32=32;
    public static final int LCURL=14;
    public static final int WS=27;
    public static final int T__33=33;
    public static final int QNAME=6;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SNAME=30;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=15;
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

    public OCLLexer() {;} 
    public OCLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OCLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g"; }

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:117:7: ( 'Collection' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:117:9: 'Collection'
            {
            match("Collection"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:118:7: ( '=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:118:9: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:119:7: ( '|' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:119:9: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:120:7: ( 'let' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:120:9: 'let'
            {
            match("let"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:121:7: ( 'in' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:121:9: 'in'
            {
            match("in"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:122:7: ( 'else' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:122:9: 'else'
            {
            match("else"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:123:7: ( 'self' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:123:9: 'self'
            {
            match("self"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:124:7: ( 'endif' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:124:9: 'endif'
            {
            match("endif"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:125:7: ( 'Sequence' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:125:9: 'Sequence'
            {
            match("Sequence"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:126:7: ( 'Bag' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:126:9: 'Bag'
            {
            match("Bag"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:127:7: ( ',' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:127:9: ','
            {
            match(','); if (state.failed) return ;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:128:7: ( 'OrderedSet' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:128:9: 'OrderedSet'
            {
            match("OrderedSet"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:129:7: ( 'then' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:129:9: 'then'
            {
            match("then"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:130:7: ( 'iterate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:130:9: 'iterate'
            {
            match("iterate"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:131:7: ( ';' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:131:9: ';'
            {
            match(';'); if (state.failed) return ;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:132:7: ( '.' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:132:9: '.'
            {
            match('.'); if (state.failed) return ;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:133:7: ( 'if' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:133:9: 'if'
            {
            match("if"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:134:7: ( '->' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:134:9: '->'
            {
            match("->"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:135:7: ( 'Set' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:135:9: 'Set'
            {
            match("Set"); if (state.failed) return ;


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1015:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1016:15: ~ ( '\\r' | '\\n' )
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
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTI_LINE_COMMENT"
    public final void mMULTI_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1021:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1022:44: ( '\\n' | ~ '\\n' )
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
    // $ANTLR end "MULTI_LINE_COMMENT"

    // $ANTLR start "DDOT"
    public final void mDDOT() throws RecognitionException {
        try {
            int _type = DDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1027:3: ( '..' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1028:3: '..'
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

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1033:3: ( '[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1034:3: '['
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1039:3: ( ']' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1040:3: ']'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1045:3: ( '{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1046:3: '{'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1051:3: ( '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1052:3: '}'
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1057:3: ( '*' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1058:3: '*'
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

    // $ANTLR start "LCURL_LBRACK"
    public final void mLCURL_LBRACK() throws RecognitionException {
        try {
            int _type = LCURL_LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1063:3: ( '{[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1064:3: '{['
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

    // $ANTLR start "RBRACK_RCURL"
    public final void mRBRACK_RCURL() throws RecognitionException {
        try {
            int _type = RBRACK_RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1069:3: ( ']}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1070:3: ']}'
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

    // $ANTLR start "LBRACK_LCURL"
    public final void mLBRACK_LCURL() throws RecognitionException {
        try {
            int _type = LBRACK_LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1075:3: ( '[{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1076:3: '[{'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1081:3: ( '}]' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1082:3: '}]'
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1087:3: ( '(' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1088:3: '('
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1093:3: ( ')' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1094:3: ')'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1099:3: ( ':' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1100:3: ':'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1105:3: ( '::' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1106:3: '::'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1115:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1115:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1115:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1115:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1116:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1117:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1118:5: '\\n'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1124:2: ( ( ' ' | '\\t' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1124:4: ( ' ' | '\\t' )
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1131:2: ( '0' .. '9' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1131:4: '0' .. '9'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1136:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1147:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1147:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1147:4: ( ALPHA )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1147:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1147:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1150:6: ( 'true' | 'false' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1150:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1150:17: 'false'
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

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1153:2: ( ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1153:4: ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1153:4: ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u00FF')) && (synpred1_OCL())) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1154:4: ( SNAME ~ DCOLON )=> SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1155:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1156:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1157:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1158:6: ~ ( '\\\\' | '\\'' | '\\n' )
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

    // $ANTLR start "QNAME"
    public final void mQNAME() throws RecognitionException {
        try {
            int _type = QNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1165:2: ( SNAME DCOLON SNAME ( DCOLON SNAME )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1165:4: SNAME DCOLON SNAME ( DCOLON SNAME )*
            {
            mSNAME(); if (state.failed) return ;
            mDCOLON(); if (state.failed) return ;
            mSNAME(); if (state.failed) return ;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1165:23: ( DCOLON SNAME )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==':') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1165:24: DCOLON SNAME
            	    {
            	    mDCOLON(); if (state.failed) return ;
            	    mSNAME(); if (state.failed) return ;

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
    // $ANTLR end "QNAME"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1170:2: ( ( DIGIT )+ )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1170:4: ( DIGIT )+
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1170:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1170:5: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:4: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1175:15: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1179:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred4_OCL())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred4_OCL())) {
                    alt12=3;
                }
                else if ( (synpred2_OCL()) ) {
                    alt12=1;
                }
                else if ( (synpred3_OCL()) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1179:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1180:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1181:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1188:9: INT
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1193:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1193:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1194:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\n') ) {
                    alt13=1;
                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1196:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1197:5: ~ ( '\\\\' | '\"' | '\\n' )
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
            	    break loop13;
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
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:8: ( T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | COMMENT | MULTI_LINE_COMMENT | DDOT | LBRACKET | RBRACKET | LCURL | RCURL | STAR | LCURL_LBRACK | RBRACK_RCURL | LBRACK_LCURL | RCURL_RBRACK | LPAREN | RPAREN | COLON | DCOLON | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING )
        int alt14=43;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:10: T__32
                {
                mT__32(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:16: T__33
                {
                mT__33(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:22: T__34
                {
                mT__34(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:28: T__35
                {
                mT__35(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:34: T__36
                {
                mT__36(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:40: T__37
                {
                mT__37(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:46: T__38
                {
                mT__38(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:52: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:58: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:64: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:70: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:76: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:82: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:88: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:94: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:100: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:106: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:112: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:118: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:124: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:132: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:151: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:156: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:165: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:174: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:180: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:186: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:191: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:204: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:217: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:230: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:243: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:250: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:257: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:263: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:270: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:273: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:276: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:281: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:286: QNAME
                {
                mQNAME(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:292: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:296: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1:309: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_OCL
    public final void synpred1_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1154:4: ( SNAME ~ DCOLON )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1154:5: SNAME ~ DCOLON
        {
        mSNAME(); if (state.failed) return ;
        if ( (input.LA(1)>='\u0000' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
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
    // $ANTLR end synpred1_OCL

    // $ANTLR start synpred2_OCL
    public final void synpred2_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1179:9: ( INT '..' )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1179:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred2_OCL

    // $ANTLR start synpred3_OCL
    public final void synpred3_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1180:7: ( INT '.' NAME )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1180:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_OCL

    // $ANTLR start synpred4_OCL
    public final void synpred4_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1181:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1181:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred4_OCL

    public final boolean synpred2_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\35\2\uffff\6\35\1\uffff\2\35\1\uffff\1\60\2\uffff\1"+
        "\64\1\66\1\70\1\72\3\uffff\1\74\2\uffff\2\35\1\uffff\1\76\1\uffff"+
        "\2\35\1\uffff\1\35\1\102\1\35\1\104\10\35\16\uffff\1\35\2\uffff"+
        "\1\35\1\120\1\uffff\1\35\1\uffff\4\35\1\126\1\127\5\35\1\uffff\1"+
        "\35\1\136\1\35\1\140\1\35\2\uffff\1\35\1\143\1\144\3\35\1\uffff"+
        "\1\150\1\uffff\2\35\2\uffff\1\144\2\35\1\uffff\3\35\1\160\3\35\1"+
        "\uffff\1\164\2\35\1\uffff\1\35\1\170\1\171\2\uffff";
    static final String DFA14_eofS =
        "\172\uffff";
    static final String DFA14_minS =
        "\1\11\1\60\2\uffff\6\60\1\uffff\2\60\1\uffff\1\56\1\uffff\1\52"+
        "\1\173\1\175\1\133\1\135\3\uffff\1\72\2\uffff\2\60\1\uffff\1\56"+
        "\1\uffff\2\60\1\uffff\14\60\16\uffff\1\60\2\uffff\2\60\1\uffff\1"+
        "\60\1\uffff\13\60\1\uffff\5\60\2\uffff\6\60\1\uffff\1\60\1\uffff"+
        "\2\60\2\uffff\3\60\1\uffff\7\60\1\uffff\3\60\1\uffff\3\60\2\uffff";
    static final String DFA14_maxS =
        "\2\u00ff\2\uffff\6\u00ff\1\uffff\2\u00ff\1\uffff\1\56\1\uffff\1"+
        "\57\1\173\1\175\1\133\1\135\3\uffff\1\72\2\uffff\2\u00ff\1\uffff"+
        "\1\71\1\uffff\2\u00ff\1\uffff\14\u00ff\16\uffff\1\u00ff\2\uffff"+
        "\2\u00ff\1\uffff\1\u00ff\1\uffff\13\u00ff\1\uffff\5\u00ff\2\uffff"+
        "\6\u00ff\1\uffff\1\u00ff\1\uffff\2\u00ff\2\uffff\3\u00ff\1\uffff"+
        "\7\u00ff\1\uffff\3\u00ff\1\uffff\3\u00ff\2\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\6\uffff\1\13\2\uffff\1\17\1\uffff\1\22\5\uffff"+
        "\1\33\1\40\1\41\1\uffff\1\44\1\45\2\uffff\1\47\1\uffff\1\53\2\uffff"+
        "\1\50\14\uffff\1\26\1\20\1\24\1\25\1\36\1\27\1\35\1\30\1\34\1\31"+
        "\1\37\1\32\1\43\1\42\1\uffff\1\51\1\52\2\uffff\1\5\1\uffff\1\21"+
        "\13\uffff\1\4\5\uffff\1\23\1\12\6\uffff\1\6\1\uffff\1\7\2\uffff"+
        "\1\15\1\46\3\uffff\1\10\7\uffff\1\16\3\uffff\1\11\3\uffff\1\1\1"+
        "\14";
    static final String DFA14_specialS =
        "\172\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\32\1\31\2\uffff\1\31\22\uffff\1\32\1\uffff\1\37\4\uffff"+
            "\1\35\1\26\1\27\1\25\1\uffff\1\12\1\17\1\16\1\20\12\36\1\30"+
            "\1\15\1\uffff\1\2\3\uffff\1\34\1\11\1\1\13\34\1\13\3\34\1\10"+
            "\7\34\1\21\1\uffff\1\22\1\uffff\1\34\1\uffff\4\34\1\6\1\33\2"+
            "\34\1\5\2\34\1\4\6\34\1\7\1\14\6\34\1\23\1\3\1\24\102\uffff"+
            "\27\34\1\uffff\37\34\1\uffff\10\34",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\40"+
            "\13\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\43\25"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\5\41\1\46\7"+
            "\41\1\44\5\41\1\45\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff"+
            "\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\47"+
            "\1\41\1\50\14\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\51\25"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\52\25"+
            "\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\1\53\31\41"+
            "\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\54"+
            "\10\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\7\41\1\55\11"+
            "\41\1\56\10\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\1\57",
            "",
            "\1\62\4\uffff\1\61",
            "\1\63",
            "\1\65",
            "\1\67",
            "\1\71",
            "",
            "",
            "",
            "\1\73",
            "",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\1\75\31\41"+
            "\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\1\77\1\uffff\12\36",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\100"+
            "\16\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\101"+
            "\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\103"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\105"+
            "\7\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\106"+
            "\26\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\107"+
            "\16\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\20\41\1\110"+
            "\2\41\1\111\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\6\41\1\112"+
            "\23\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\113"+
            "\26\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\114"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\115"+
            "\5\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
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
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\116"+
            "\16\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\13\41\1\117"+
            "\16\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\121"+
            "\10\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\122"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\123"+
            "\21\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\5\41\1\124"+
            "\24\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\24\41\1\125"+
            "\5\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\130"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\131"+
            "\14\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\132"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\133"+
            "\7\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\134"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\1\135\31\41"+
            "\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\5\41\1\137"+
            "\24\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\141"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\21\41\1\142"+
            "\10\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\145"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\2\41\1\146"+
            "\27\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\147"+
            "\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\151"+
            "\14\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\152"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\153"+
            "\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\154"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\2\41\1\155"+
            "\27\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\3\41\1\156"+
            "\26\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\157"+
            "\21\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\161"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\22\41\1\162\7\41\4\uffff\1\41\1\uffff"+
            "\32\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\16\41\1\163"+
            "\13\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\4\41\1\165"+
            "\25\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\15\41\1\166"+
            "\14\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\23\41\1\167"+
            "\6\41\105\uffff\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "\12\41\1\42\6\uffff\32\41\4\uffff\1\41\1\uffff\32\41\105\uffff"+
            "\27\41\1\uffff\37\41\1\uffff\10\41",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | COMMENT | MULTI_LINE_COMMENT | DDOT | LBRACKET | RBRACKET | LCURL | RCURL | STAR | LCURL_LBRACK | RBRACK_RCURL | LBRACK_LCURL | RCURL_RBRACK | LPAREN | RPAREN | COLON | DCOLON | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING );";
        }
    }
 

}