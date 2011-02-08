// $ANTLR 3.1.1 C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g 2011-02-04 17:32:45

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
public class BibtexLexer extends Lexer {
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int ESC=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int FLOAT=13;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int ALPHA=10;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int T__16=16;
    public static final int WS=8;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int SNAME=11;
    public static final int DIGIT=9;
    public static final int NL=7;
    public static final int COMMENT=6;
    public static final int STRING=14;
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

    public BibtexLexer() {;} 
    public BibtexLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BibtexLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:62:7: ( 'Entries:' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:62:9: 'Entries:'
            {
            match("Entries:"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:63:7: ( '{' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:63:9: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:64:7: ( '}' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:64:9: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:65:7: ( 'Authors:' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:65:9: 'Authors:'
            {
            match("Authors:"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:66:7: ( '@article' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:66:9: '@article'
            {
            match("@article"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:67:7: ( ',' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:67:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:68:7: ( 'title' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:68:9: 'title'
            {
            match("title"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:69:7: ( '=' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:69:9: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:70:7: ( 'author' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:70:9: 'author'
            {
            match("author"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:71:7: ( 'and' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:71:9: 'and'
            {
            match("and"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:178:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:179:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:184:5: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:184:9: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:184:9: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:184:13: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:185:13: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:186:13: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:187:13: '\\n'
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:193:5: ( ( ' ' | '\\t' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:193:9: ( ' ' | '\\t' )
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:200:5: ( '0' .. '9' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:200:9: '0' .. '9'
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:205:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:216:5: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:216:9: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:216:9: ( ALPHA )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:216:10: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:216:17: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:220:5: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:220:9: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:220:9: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
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
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:221:13: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:222:13: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:223:13: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:223:17: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:224:17: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:225:17: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:233:5: ( ( DIGIT )+ )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:233:9: ( DIGIT )+
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:233:9: ( DIGIT )+
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
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:233:10: DIGIT
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:9: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:13: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:13: ( DIGIT )+
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
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:13: DIGIT
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

            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:20: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') && (synpred1_Bibtex())) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:21: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:38: ( DIGIT )+
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
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:38: DIGIT
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:240:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:240:9: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:241:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:241:13: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:242:13: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:243:13: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:244:13: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:245:13: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:246:13: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:247:13: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:248:13: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:249:13: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:249:13: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:250:17: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:250:17: ( '0' .. '3' )
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:250:18: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:251:17: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:252:21: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:252:21: ( '0' .. '7' )
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:252:22: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:253:21: ( '0' .. '7' )?
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
                                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:254:25: '0' .. '7'
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
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:257:17: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:257:17: ( '4' .. '7' )
                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:257:18: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:258:17: ( ( '0' .. '7' ) )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:259:21: ( '0' .. '7' )
                                    {
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:259:21: ( '0' .. '7' )
                                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:259:22: '0' .. '7'
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
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:268:5: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:268:9: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:269:9: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:269:13: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:270:13: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:271:13: ~ ( '\\\\' | '\\'' | '\\n' )
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

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | COMMENT | NL | WS | NAME | INT | FLOAT | STRING )
        int alt16=17;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:10: T__15
                {
                mT__15(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:16: T__16
                {
                mT__16(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:22: T__17
                {
                mT__17(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:28: T__18
                {
                mT__18(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:34: T__19
                {
                mT__19(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:40: T__20
                {
                mT__20(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:46: T__21
                {
                mT__21(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:52: T__22
                {
                mT__22(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:58: T__23
                {
                mT__23(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:64: T__24
                {
                mT__24(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:70: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:78: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:81: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:84: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:89: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:93: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:1:99: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Bibtex
    public final void synpred1_Bibtex_fragment() throws RecognitionException {   
        // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:21: ( '.' DIGIT )
        // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:236:22: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Bibtex

    public final boolean synpred1_Bibtex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Bibtex_fragment(); // can never throw exception
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
        "\1\uffff\1\15\2\uffff\1\15\2\uffff\1\15\1\uffff\1\15\4\uffff\1"+
        "\25\1\uffff\5\15\2\uffff\4\15\1\40\4\15\1\uffff\2\15\1\47\3\15\1"+
        "\uffff\1\53\2\15\3\uffff";
    static final String DFA16_eofS =
        "\56\uffff";
    static final String DFA16_minS =
        "\1\11\1\156\2\uffff\1\165\2\uffff\1\151\1\uffff\1\156\4\uffff\1"+
        "\56\1\uffff\4\164\1\144\2\uffff\1\162\1\150\1\154\1\150\1\60\1\151"+
        "\1\157\1\145\1\157\1\uffff\1\145\1\162\1\60\1\162\2\163\1\uffff"+
        "\1\60\2\72\3\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\156\2\uffff\1\165\2\uffff\1\151\1\uffff\1\165\4\uffff"+
        "\1\71\1\uffff\4\164\1\144\2\uffff\1\162\1\150\1\154\1\150\1\u00ff"+
        "\1\151\1\157\1\145\1\157\1\uffff\1\145\1\162\1\u00ff\1\162\2\163"+
        "\1\uffff\1\u00ff\2\72\3\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\1\6\1\uffff\1\10\1\uffff\1\13\1\14"+
        "\1\15\1\16\1\uffff\1\21\5\uffff\1\17\1\20\11\uffff\1\12\6\uffff"+
        "\1\7\3\uffff\1\11\1\1\1\4";
    static final String DFA16_specialS =
        "\56\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\14\1\13\2\uffff\1\13\22\uffff\1\14\1\uffff\1\15\4\uffff"+
            "\1\17\4\uffff\1\6\1\12\2\uffff\12\16\3\uffff\1\10\2\uffff\1"+
            "\5\1\4\3\15\1\1\25\15\4\uffff\1\15\1\uffff\1\11\22\15\1\7\6"+
            "\15\1\2\1\uffff\1\3\102\uffff\27\15\1\uffff\37\15\1\uffff\10"+
            "\15",
            "\1\20",
            "",
            "",
            "\1\21",
            "",
            "",
            "\1\22",
            "",
            "\1\24\6\uffff\1\23",
            "",
            "",
            "",
            "",
            "\1\26\1\uffff\12\16",
            "",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15\105\uffff"+
            "\27\15\1\uffff\37\15\1\uffff\10\15",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "\1\45",
            "\1\46",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15\105\uffff"+
            "\27\15\1\uffff\37\15\1\uffff\10\15",
            "\1\50",
            "\1\51",
            "\1\52",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15\105\uffff"+
            "\27\15\1\uffff\37\15\1\uffff\10\15",
            "\1\54",
            "\1\55",
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
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | COMMENT | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}