// $ANTLR 3.1.1 /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g 2011-02-28 20:11:35

package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
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
public class OclLexer extends Lexer {
    public static final int LT=31;
    public static final int STAR=28;
    public static final int FLOAT=9;
    public static final int EQUALS=15;
    public static final int EOF=-1;
    public static final int GTRQULAS=30;
    public static final int LPAREN=11;
    public static final int LBRACKET=26;
    public static final int RPAREN=12;
    public static final int DCOLON=17;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int COMMA=19;
    public static final int DIGIT=35;
    public static final int NL=33;
    public static final int APOSTROPHE=16;
    public static final int RANGE_OR_INT=38;
    public static final int RBRACKET=27;
    public static final int DOT=13;
    public static final int COMMENT=25;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=21;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int SEMI=23;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=36;
    public static final int COLON=22;
    public static final int LCURL=18;
    public static final int QNAME=6;
    public static final int WS=34;
    public static final int SNAME=37;
    public static final int T__39=39;
    public static final int RCURL=20;
    public static final int ARROW=14;
    public static final int GT=29;
    public static final int LTEQUALS=32;
    public static final int BAR=24;
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
         * Removing starting/ending delimiters.
         * @deprecated
         */
        public String unescapeString(String s, int delimLength) {
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
            }
            return s;
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

    public OclLexer() {;} 
    public OclLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OclLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g"; }

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:62:7: ( 'if' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:62:9: 'if'
            {
            match("if"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:63:7: ( 'endif' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:63:9: 'endif'
            {
            match("endif"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:64:7: ( 'then' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:64:9: 'then'
            {
            match("then"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:65:7: ( 'forAll' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:65:9: 'forAll'
            {
            match("forAll"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:66:7: ( 'self' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:66:9: 'self'
            {
            match("self"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:67:7: ( 'else' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:67:9: 'else'
            {
            match("else"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:68:7: ( 'Sequence' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:68:9: 'Sequence'
            {
            match("Sequence"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:69:7: ( 'collect' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:69:9: 'collect'
            {
            match("collect"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:70:7: ( 'Set' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:70:9: 'Set'
            {
            match("Set"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:71:7: ( 'select' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:71:9: 'select'
            {
            match("select"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:72:7: ( 'Collection' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:72:9: 'Collection'
            {
            match("Collection"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:73:7: ( 'in' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:73:9: 'in'
            {
            match("in"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:74:7: ( 'Bag' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:74:9: 'Bag'
            {
            match("Bag"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:75:7: ( 'iterate' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:75:9: 'iterate'
            {
            match("iterate"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:76:7: ( 'OrderedSet' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:76:9: 'OrderedSet'
            {
            match("OrderedSet"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:77:7: ( 'let' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:77:9: 'let'
            {
            match("let"); if (state.failed) return ;


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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1020:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1021:15: ~ ( '\\r' | '\\n' )
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1026:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); if (state.failed) return ;

            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1027:44: ( '\\n' | ~ '\\n' )
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1032:3: ( '..' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1033:3: '..'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1038:3: ( '[' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1039:3: '['
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1044:3: ( ']' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1045:3: ']'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1050:3: ( '{' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1051:3: '{'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1056:3: ( '}' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1057:3: '}'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1062:3: ( '*' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1063:3: '*'
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1068:3: ( '(' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1069:3: '('
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1074:3: ( ')' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1075:3: ')'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1080:3: ( ':' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1081:3: ':'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1086:3: ( '::' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1087:3: '::'
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

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1092:3: ( ',' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1093:3: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1098:3: ( ';' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1099:3: ';'
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

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1104:3: ( '.' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1105:3: '.'
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

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1110:3: ( '=' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1111:3: '='
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

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1116:3: ( '>' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1117:3: '>'
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

    // $ANTLR start "GTRQULAS"
    public final void mGTRQULAS() throws RecognitionException {
        try {
            int _type = GTRQULAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1122:3: ( '>=' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1123:3: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GTRQULAS"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1128:3: ( '<' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1129:3: '<'
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

    // $ANTLR start "LTEQUALS"
    public final void mLTEQUALS() throws RecognitionException {
        try {
            int _type = LTEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1134:3: ( '<=' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1135:3: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTEQUALS"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1140:3: ( '->' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1141:3: '->'
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

    // $ANTLR start "BAR"
    public final void mBAR() throws RecognitionException {
        try {
            int _type = BAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1146:3: ( '|' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1147:3: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BAR"

    // $ANTLR start "APOSTROPHE"
    public final void mAPOSTROPHE() throws RecognitionException {
        try {
            int _type = APOSTROPHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1152:3: ( '\\'' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1153:3: '\\''
            {
            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APOSTROPHE"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1162:9: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1162:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1162:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1162:25: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1163:25: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1164:25: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1165:25: '\\n'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1171:9: ( ( ' ' | '\\t' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1171:17: ( ' ' | '\\t' )
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1178:9: ( '0' .. '9' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1178:17: '0' .. '9'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1183:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1194:9: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1194:17: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1194:17: ( ALPHA )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1194:18: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1194:25: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1197:9: ( 'true' | 'false' )
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1197:17: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1197:26: 'false'
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1200:9: ( ( ( SNAME (~ DCOLON | EOF ) )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1200:17: ( ( SNAME (~ DCOLON | EOF ) )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1200:17: ( ( SNAME (~ DCOLON | EOF ) )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u00FF')) && (synpred1_Ocl())) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:25: ( SNAME (~ DCOLON | EOF ) )=> SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1202:25: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1203:25: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1204:25: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1205:33: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1212:9: ( SNAME DCOLON SNAME ( DCOLON SNAME )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1212:11: SNAME DCOLON SNAME ( DCOLON SNAME )*
            {
            mSNAME(); if (state.failed) return ;
            mDCOLON(); if (state.failed) return ;
            mSNAME(); if (state.failed) return ;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1212:30: ( DCOLON SNAME )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==':') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1212:31: DCOLON SNAME
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1217:2: ( ( DIGIT )+ )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1217:4: ( DIGIT )+
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1217:4: ( DIGIT )+
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
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1217:5: DIGIT
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:9: ( ( DIGIT )+ '.' ( DIGIT )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:17: ( DIGIT )+ '.' ( DIGIT )*
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:17: ( DIGIT )+
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
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:17: DIGIT
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:28: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1222:28: DIGIT
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1226:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred4_Ocl())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred4_Ocl())) {
                    alt12=3;
                }
                else if ( (synpred2_Ocl()) ) {
                    alt12=1;
                }
                else if ( (synpred3_Ocl()) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1226:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1227:9: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1228:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1235:9: INT
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
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1240:9: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1240:17: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1241:17: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1243:25: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1244:25: ~ ( '\\\\' | '\"' | '\\n' )
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
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:8: ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | COMMENT | MULTI_LINE_COMMENT | DDOT | LBRACKET | RBRACKET | LCURL | RCURL | STAR | LPAREN | RPAREN | COLON | DCOLON | COMMA | SEMI | DOT | EQUALS | GT | GTRQULAS | LT | LTEQUALS | ARROW | BAR | APOSTROPHE | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING )
        int alt14=47;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:10: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:16: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:22: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:28: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:34: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:40: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:46: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:52: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:58: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:64: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:70: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:76: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:82: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:88: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:94: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:100: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:106: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 18 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:114: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 19 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:133: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 20 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:138: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 21 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:147: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 22 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:156: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 23 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:162: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 24 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:168: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 25 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:173: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 26 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:180: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 27 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:187: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 28 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:193: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 29 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:200: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 30 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:206: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 31 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:211: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 32 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:215: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 33 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:222: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 34 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:225: GTRQULAS
                {
                mGTRQULAS(); if (state.failed) return ;

                }
                break;
            case 35 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:234: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 36 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:237: LTEQUALS
                {
                mLTEQUALS(); if (state.failed) return ;

                }
                break;
            case 37 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:246: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 38 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:252: BAR
                {
                mBAR(); if (state.failed) return ;

                }
                break;
            case 39 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:256: APOSTROPHE
                {
                mAPOSTROPHE(); if (state.failed) return ;

                }
                break;
            case 40 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:267: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 41 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:270: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 42 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:273: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 43 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:278: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 44 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:283: QNAME
                {
                mQNAME(); if (state.failed) return ;

                }
                break;
            case 45 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:289: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 46 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:293: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 47 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1:306: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Ocl
    public final void synpred1_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:25: ( SNAME (~ DCOLON | EOF ) )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:26: SNAME (~ DCOLON | EOF )
        {
        mSNAME(); if (state.failed) return ;
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:32: (~ DCOLON | EOF )
        int alt15=2;
        int LA15_0 = input.LA(1);

        if ( ((LA15_0>='\u0000' && LA15_0<='\uFFFF')) ) {
            alt15=1;
        }
        else {
            alt15=2;}
        switch (alt15) {
            case 1 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:33: ~ DCOLON
                {
                if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0010')||(input.LA(1)>='\u0012' && input.LA(1)<='\uFFFF') ) {
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
            case 2 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1201:41: EOF
                {
                match(EOF); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred1_Ocl

    // $ANTLR start synpred2_Ocl
    public final void synpred2_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1226:9: ( INT '..' )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1226:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred2_Ocl

    // $ANTLR start synpred3_Ocl
    public final void synpred3_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1227:9: ( INT '.' NAME )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1227:11: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Ocl

    // $ANTLR start synpred4_Ocl
    public final void synpred4_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1228:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1228:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred4_Ocl

    public final boolean synpred3_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Ocl_fragment(); // can never throw exception
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
        "\1\uffff\13\46\1\uffff\1\71\7\uffff\1\73\3\uffff\1\75\1\77\2\uffff"+
        "\1\100\2\uffff\1\46\1\101\1\uffff\1\103\1\104\1\46\1\uffff\1\46"+
        "\1\uffff\15\46\17\uffff\11\46\1\136\2\46\1\141\1\46\1\143\2\46\1"+
        "\146\1\147\1\150\2\46\1\153\2\46\1\uffff\2\46\1\uffff\1\46\1\uffff"+
        "\1\46\1\162\3\uffff\1\46\1\150\1\uffff\6\46\1\uffff\1\172\1\173"+
        "\4\46\1\u0080\2\uffff\1\46\1\u0082\2\46\1\uffff\1\u0085\1\uffff"+
        "\2\46\1\uffff\2\46\1\u008a\1\u008b\2\uffff";
    static final String DFA14_eofS =
        "\u008c\uffff";
    static final String DFA14_minS =
        "\1\11\13\60\1\52\1\56\7\uffff\1\72\3\uffff\2\75\2\uffff\1\0\2\uffff"+
        "\1\60\1\56\1\uffff\3\60\1\uffff\1\60\1\uffff\15\60\17\uffff\31\60"+
        "\1\uffff\2\60\1\uffff\1\60\1\uffff\2\60\3\uffff\2\60\1\uffff\6\60"+
        "\1\uffff\7\60\2\uffff\4\60\1\uffff\1\60\1\uffff\2\60\1\uffff\4\60"+
        "\2\uffff";
    static final String DFA14_maxS =
        "\14\u00ff\1\57\1\56\7\uffff\1\72\3\uffff\2\75\2\uffff\1\uffff\2"+
        "\uffff\1\u00ff\1\71\1\uffff\3\u00ff\1\uffff\1\u00ff\1\uffff\15\u00ff"+
        "\17\uffff\31\u00ff\1\uffff\2\u00ff\1\uffff\1\u00ff\1\uffff\2\u00ff"+
        "\3\uffff\2\u00ff\1\uffff\6\u00ff\1\uffff\7\u00ff\2\uffff\4\u00ff"+
        "\1\uffff\1\u00ff\1\uffff\2\u00ff\1\uffff\4\u00ff\2\uffff";
    static final String DFA14_acceptS =
        "\16\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\uffff\1\35\1\36\1"+
        "\40\2\uffff\1\45\1\46\1\uffff\1\50\1\51\2\uffff\1\57\3\uffff\1\53"+
        "\1\uffff\1\54\15\uffff\1\21\1\22\1\23\1\37\1\34\1\33\1\42\1\41\1"+
        "\44\1\43\1\47\1\55\1\56\1\1\1\14\31\uffff\1\11\2\uffff\1\15\1\uffff"+
        "\1\20\2\uffff\1\6\1\3\1\52\2\uffff\1\5\6\uffff\1\2\7\uffff\1\4\1"+
        "\12\4\uffff\1\16\1\uffff\1\10\2\uffff\1\7\4\uffff\1\13\1\17";
    static final String DFA14_specialS =
        "\35\uffff\1\0\156\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\37\1\36\2\uffff\1\36\22\uffff\1\37\1\uffff\1\42\4\uffff\1"+
            "\35\1\23\1\24\1\22\1\uffff\1\26\1\33\1\15\1\14\12\41\1\25\1"+
            "\27\1\32\1\30\1\31\2\uffff\1\40\1\11\1\10\13\40\1\12\3\40\1"+
            "\6\7\40\1\16\1\uffff\1\17\1\uffff\1\40\1\uffff\2\40\1\7\1\40"+
            "\1\2\1\4\2\40\1\1\2\40\1\13\6\40\1\5\1\3\6\40\1\20\1\34\1\21"+
            "\102\uffff\27\40\1\uffff\37\40\1\uffff\10\40",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\5\47\1\43\7"+
            "\47\1\44\5\47\1\45\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff"+
            "\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\52\1"+
            "\47\1\51\14\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\7\47\1\53\11"+
            "\47\1\54\10\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\1\56\15\47\1"+
            "\55\13\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\57\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\60\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\16\47\1\61\13"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\16\47\1\62\13"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\1\63\31\47\105"+
            "\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\21\47\1\64\10"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\65\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\1\67\4\uffff\1\66",
            "\1\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\72",
            "",
            "",
            "",
            "\1\74",
            "\1\76",
            "",
            "",
            "\134\46\1\uffff\uffa3\46",
            "",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\1\102\1\uffff\12\41",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\105\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\3\47\1\106\26"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\107"+
            "\7\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\110\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\24\47\1\111"+
            "\5\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\21\47\1\112"+
            "\10\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\113"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\114"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\20\47\1\115"+
            "\2\47\1\116\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\117"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\120"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\6\47\1\121\23"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\3\47\1\122\26"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\123"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
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
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\21\47\1\124"+
            "\10\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\10\47\1\125"+
            "\21\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\126\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\15\47\1\127"+
            "\14\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\130\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\1\131\31\47\4\uffff\1\47\1\uffff\32\47"+
            "\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\132"+
            "\7\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\134\1"+
            "\133\24\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\24\47\1\135"+
            "\5\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\137"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\140"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\142\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\1\144\31\47"+
            "\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\5\47\1\145\24"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\151"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\152\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\2\47\1\154\27"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\155\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\156\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\157\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\21\47\1\160"+
            "\10\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\161"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\13\47\1\163"+
            "\16\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\164"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\15\47\1\165"+
            "\14\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\2\47\1\166\27"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\2\47\1\167\27"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\170\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\171\25"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\2\47\1\174\27"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\175"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\176"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\3\47\1\177\26"+
            "\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\u0081"+
            "\25\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\10\47\1\u0083"+
            "\21\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\22\47\1\u0084\7\47\4\uffff\1\47\1\uffff"+
            "\32\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\16\47\1\u0086"+
            "\13\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\u0087"+
            "\25\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\15\47\1\u0088"+
            "\14\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\23\47\1\u0089"+
            "\6\47\105\uffff\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
            "\12\47\1\50\6\uffff\32\47\4\uffff\1\47\1\uffff\32\47\105\uffff"+
            "\27\47\1\uffff\37\47\1\uffff\10\47",
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
            return "1:1: Tokens : ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | COMMENT | MULTI_LINE_COMMENT | DDOT | LBRACKET | RBRACKET | LCURL | RCURL | STAR | LPAREN | RPAREN | COLON | DCOLON | COMMA | SEMI | DOT | EQUALS | GT | GTRQULAS | LT | LTEQUALS | ARROW | BAR | APOSTROPHE | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_29 = input.LA(1);

                        s = -1;
                        if ( ((LA14_29>='\u0000' && LA14_29<='[')||(LA14_29>=']' && LA14_29<='\uFFFF')) ) {s = 38;}

                        else s = 64;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}