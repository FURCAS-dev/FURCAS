// $ANTLR 3.1.1 C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g 2011-01-17 11:53:22

package com.sap.furcas.parser.tcs.stable;
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
public class SyntaxConfigurationLexer extends Lexer {
    public static final int DOLLAR=29;
    public static final int DLCURLY=24;
    public static final int LT=34;
    public static final int STAR=16;
    public static final int LSQUARE=37;
    public static final int POINT=33;
    public static final int AROBAS=36;
    public static final int ESC=47;
    public static final int DLCOLON=19;
    public static final int DRCURLY=41;
    public static final int DRSQUARE=23;
    public static final int LARROW=35;
    public static final int EXCL=40;
    public static final int FLOAT=48;
    public static final int EOF=-1;
    public static final int LPAREN=27;
    public static final int RPAREN=15;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=17;
    public static final int PLUS=26;
    public static final int PIPE=28;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int EQ=38;
    public static final int COMMENT=14;
    public static final int T__50=50;
    public static final int NE=18;
    public static final int GE=32;
    public static final int SHARP=11;
    public static final int DLSQUARE=20;
    public static final int T__49=49;
    public static final int RARROW=39;
    public static final int LCURLY=7;
    public static final int INT=6;
    public static final int RSQUARE=25;
    public static final int MINUS=30;
    public static final int COMA=8;
    public static final int SEMI=12;
    public static final int MULTI_LINE_COMMENT=13;
    public static final int ALPHA=45;
    public static final int COLON=10;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURLY=9;
    public static final int GT=31;
    public static final int QMARK=21;
    public static final int LE=22;
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

    public SyntaxConfigurationLexer() {;} 
    public SyntaxConfigurationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SyntaxConfigurationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g"; }

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:117:7: ( 'bind' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:117:9: 'bind'
            {
            match("bind"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:118:7: ( 'Configuration' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:118:9: 'Configuration'
            {
            match("Configuration"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:119:7: ( 'to' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:119:9: 'to'
            {
            match("to"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "MULTI_LINE_COMMENT"
    public final void mMULTI_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTI_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:298:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); if (state.failed) return ;

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:299:44: ( '\\n' | ~ '\\n' )
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
            	    break loop1;
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:304:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:14: (~ ( '\\r' | '\\n' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:305:15: ~ ( '\\r' | '\\n' )
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
            	    break loop2;
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

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:310:3: ( ')' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:311:3: ')'
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:316:3: ( '*' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:317:3: '*'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:322:3: ( '/' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:323:3: '/'
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

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:328:3: ( '<>' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:329:3: '<>'
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

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:334:3: ( '{' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:335:3: '{'
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

    // $ANTLR start "DLCOLON"
    public final void mDLCOLON() throws RecognitionException {
        try {
            int _type = DLCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:340:3: ( '::' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:341:3: '::'
            {
            match("::"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLCOLON"

    // $ANTLR start "DLSQUARE"
    public final void mDLSQUARE() throws RecognitionException {
        try {
            int _type = DLSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:346:3: ( '[[' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:347:3: '[['
            {
            match("[["); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLSQUARE"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:352:3: ( '?' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:353:3: '?'
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

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:358:3: ( '<=' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:359:3: '<='
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

    // $ANTLR start "DRSQUARE"
    public final void mDRSQUARE() throws RecognitionException {
        try {
            int _type = DRSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:364:3: ( ']]' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:365:3: ']]'
            {
            match("]]"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DRSQUARE"

    // $ANTLR start "DLCURLY"
    public final void mDLCURLY() throws RecognitionException {
        try {
            int _type = DLCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:370:3: ( '{{' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:371:3: '{{'
            {
            match("{{"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLCURLY"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:376:3: ( ']' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:377:3: ']'
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

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:382:3: ( '+' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:383:3: '+'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:388:3: ( ':' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:389:3: ':'
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:394:3: ( '(' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:395:3: '('
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

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:400:3: ( ',' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:401:3: ','
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

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:406:3: ( ';' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:407:3: ';'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:412:3: ( '|' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:413:3: '|'
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

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:418:3: ( '$' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:419:3: '$'
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

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:424:3: ( '-' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:425:3: '-'
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

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:430:3: ( '>' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:431:3: '>'
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

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:436:3: ( '>=' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:437:3: '>='
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

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:442:3: ( '#' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:443:3: '#'
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

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:448:3: ( '.' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:449:3: '.'
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

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:454:3: ( '<' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:455:3: '<'
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

    // $ANTLR start "LARROW"
    public final void mLARROW() throws RecognitionException {
        try {
            int _type = LARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:460:3: ( '<-' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:461:3: '<-'
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

    // $ANTLR start "AROBAS"
    public final void mAROBAS() throws RecognitionException {
        try {
            int _type = AROBAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:466:3: ( '@' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:467:3: '@'
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

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:472:3: ( '[' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:473:3: '['
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

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:478:3: ( '=' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:479:3: '='
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

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:484:3: ( '->' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:485:3: '->'
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

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:490:3: ( '}' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:491:3: '}'
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

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:496:3: ( '!' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:497:3: '!'
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

    // $ANTLR start "DRCURLY"
    public final void mDRCURLY() throws RecognitionException {
        try {
            int _type = DRCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:502:3: ( '}}' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:503:3: '}}'
            {
            match("}}"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DRCURLY"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:508:5: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:508:9: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:508:9: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:508:13: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:509:13: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:510:13: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:511:13: '\\n'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:517:5: ( ( ' ' | '\\t' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:517:9: ( ' ' | '\\t' )
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:524:5: ( '0' .. '9' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:524:9: '0' .. '9'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:529:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:540:5: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:540:9: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:540:9: ( ALPHA )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:540:10: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:540:17: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:
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

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:544:5: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:544:9: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:544:9: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u00FF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\"') ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:545:13: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:546:13: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); if (state.failed) return ;
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:547:13: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
                    loop5:
                    do {
                        int alt5=4;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( (LA5_0=='\n') ) {
                            alt5=2;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=3;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:547:17: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:548:17: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:549:17: ~ ( '\\\\' | '\\\"' | '\\n' )
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
                    	    break loop5;
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:557:5: ( ( DIGIT )+ )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:557:9: ( DIGIT )+
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:557:9: ( DIGIT )+
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:557:10: DIGIT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:9: ( ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )? )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:13: ( DIGIT )+ ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:13: ( DIGIT )+
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:13: DIGIT
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

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:20: ( ( '.' DIGIT )=> '.' ( DIGIT )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='.') && (synpred1_SyntaxConfiguration())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:21: ( '.' DIGIT )=> '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:38: ( DIGIT )+
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
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:38: DIGIT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:564:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:564:9: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:565:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt15=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt15=1;
                }
                break;
            case 'r':
                {
                alt15=2;
                }
                break;
            case 't':
                {
                alt15=3;
                }
                break;
            case 'b':
                {
                alt15=4;
                }
                break;
            case 'f':
                {
                alt15=5;
                }
                break;
            case '\"':
                {
                alt15=6;
                }
                break;
            case '\'':
                {
                alt15=7;
                }
                break;
            case '\\':
                {
                alt15=8;
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
                alt15=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:565:13: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:566:13: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:567:13: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:568:13: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:569:13: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:570:13: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:571:13: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:572:13: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:573:13: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:573:13: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>='0' && LA14_0<='3')) ) {
                        alt14=1;
                    }
                    else if ( ((LA14_0>='4' && LA14_0<='7')) ) {
                        alt14=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:574:17: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:574:17: ( '0' .. '3' )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:574:18: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:575:17: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:576:21: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:576:21: ( '0' .. '7' )
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:576:22: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:577:21: ( '0' .. '7' )?
                                    int alt11=2;
                                    int LA11_0 = input.LA(1);

                                    if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                        alt11=1;
                                    }
                                    switch (alt11) {
                                        case 1 :
                                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:578:25: '0' .. '7'
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
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:581:17: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:581:17: ( '4' .. '7' )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:581:18: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:582:17: ( ( '0' .. '7' ) )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( ((LA13_0>='0' && LA13_0<='7')) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:583:21: ( '0' .. '7' )
                                    {
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:583:21: ( '0' .. '7' )
                                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:583:22: '0' .. '7'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:592:5: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:592:9: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); if (state.failed) return ;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:593:9: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
            loop16:
            do {
                int alt16=4;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\\') ) {
                    alt16=1;
                }
                else if ( (LA16_0=='\n') ) {
                    alt16=2;
                }
                else if ( ((LA16_0>='\u0000' && LA16_0<='\t')||(LA16_0>='\u000B' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='[')||(LA16_0>=']' && LA16_0<='\uFFFF')) ) {
                    alt16=3;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:593:13: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:594:13: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:595:13: ~ ( '\\\\' | '\\'' | '\\n' )
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
            	    break loop16;
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
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:8: ( T__49 | T__50 | T__51 | MULTI_LINE_COMMENT | COMMENT | RPAREN | STAR | SLASH | NE | LCURLY | DLCOLON | DLSQUARE | QMARK | LE | DRSQUARE | DLCURLY | RSQUARE | PLUS | COLON | LPAREN | COMA | SEMI | PIPE | DOLLAR | MINUS | GT | GE | SHARP | POINT | LT | LARROW | AROBAS | LSQUARE | EQ | RARROW | RCURLY | EXCL | DRCURLY | NL | WS | NAME | INT | FLOAT | STRING )
        int alt17=44;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:10: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:16: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:22: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:28: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:47: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:55: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:62: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:67: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:73: NE
                {
                mNE(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:76: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:83: DLCOLON
                {
                mDLCOLON(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:91: DLSQUARE
                {
                mDLSQUARE(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:100: QMARK
                {
                mQMARK(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:106: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:109: DRSQUARE
                {
                mDRSQUARE(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:118: DLCURLY
                {
                mDLCURLY(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:126: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:134: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:139: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:145: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:152: COMA
                {
                mCOMA(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:157: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:162: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:167: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:174: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:180: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:183: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:186: SHARP
                {
                mSHARP(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:192: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:198: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:201: LARROW
                {
                mLARROW(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:208: AROBAS
                {
                mAROBAS(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:215: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:223: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:226: RARROW
                {
                mRARROW(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:233: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:240: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:245: DRCURLY
                {
                mDRCURLY(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:253: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:256: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:259: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:264: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:268: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:1:274: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_SyntaxConfiguration
    public final void synpred1_SyntaxConfiguration_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:21: ( '.' DIGIT )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parser.tcs\\.\\generationTemp\\generated\\SyntaxConfiguration.g:560:22: '.' DIGIT
        {
        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_SyntaxConfiguration

    public final boolean synpred1_SyntaxConfiguration() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_SyntaxConfiguration_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\3\35\1\44\1\47\2\uffff\1\53\1\55\1\57\1\61\1\uffff\1\63"+
        "\6\uffff\1\65\4\uffff\1\67\4\uffff\1\70\1\uffff\2\35\1\74\27\uffff"+
        "\2\35\1\uffff\1\77\1\35\1\uffff\10\35\1\111\1\uffff";
    static final String DFA17_eofS =
        "\112\uffff";
    static final String DFA17_minS =
        "\1\11\1\151\2\157\1\52\1\55\2\uffff\1\55\1\173\1\72\1\133\1\uffff"+
        "\1\135\6\uffff\1\75\4\uffff\1\175\4\uffff\1\56\1\uffff\2\156\1\60"+
        "\27\uffff\1\144\1\146\1\uffff\1\60\1\151\1\uffff\1\147\1\165\1\162"+
        "\1\141\1\164\1\151\1\157\1\156\1\60\1\uffff";
    static final String DFA17_maxS =
        "\1\u00ff\1\151\2\157\1\52\1\76\2\uffff\1\76\1\173\1\72\1\133\1"+
        "\uffff\1\135\6\uffff\1\75\4\uffff\1\175\4\uffff\1\71\1\uffff\2\156"+
        "\1\u00ff\27\uffff\1\144\1\146\1\uffff\1\u00ff\1\151\1\uffff\1\147"+
        "\1\165\1\162\1\141\1\164\1\151\1\157\1\156\1\u00ff\1\uffff";
    static final String DFA17_acceptS =
        "\6\uffff\1\6\1\7\4\uffff\1\15\1\uffff\1\22\1\24\1\25\1\26\1\27"+
        "\1\30\1\uffff\1\34\1\35\1\40\1\42\1\uffff\1\45\1\47\1\50\1\51\1"+
        "\uffff\1\54\3\uffff\1\4\1\10\1\5\1\43\1\31\1\11\1\16\1\37\1\36\1"+
        "\20\1\12\1\13\1\23\1\14\1\41\1\17\1\21\1\33\1\32\1\46\1\44\1\52"+
        "\1\53\2\uffff\1\3\2\uffff\1\1\11\uffff\1\2";
    static final String DFA17_specialS =
        "\112\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\34\1\33\2\uffff\1\33\22\uffff\1\34\1\32\1\35\1\25\1\23\2"+
            "\uffff\1\37\1\17\1\6\1\7\1\16\1\20\1\5\1\26\1\4\12\36\1\12\1"+
            "\21\1\10\1\30\1\24\1\14\1\27\2\35\1\2\27\35\1\13\1\uffff\1\15"+
            "\1\uffff\1\35\1\uffff\1\35\1\1\21\35\1\3\6\35\1\11\1\22\1\31"+
            "\102\uffff\27\35\1\uffff\37\35\1\uffff\10\35",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\20\uffff\1\46",
            "",
            "",
            "\1\52\17\uffff\1\51\1\50",
            "\1\54",
            "\1\56",
            "\1\60",
            "",
            "\1\62",
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
            "\1\66",
            "",
            "",
            "",
            "",
            "\1\71\1\uffff\12\36",
            "",
            "\1\72",
            "\1\73",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35\105\uffff"+
            "\27\35\1\uffff\37\35\1\uffff\10\35",
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
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35\105\uffff"+
            "\27\35\1\uffff\37\35\1\uffff\10\35",
            "\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35\105\uffff"+
            "\27\35\1\uffff\37\35\1\uffff\10\35",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__49 | T__50 | T__51 | MULTI_LINE_COMMENT | COMMENT | RPAREN | STAR | SLASH | NE | LCURLY | DLCOLON | DLSQUARE | QMARK | LE | DRSQUARE | DLCURLY | RSQUARE | PLUS | COLON | LPAREN | COMA | SEMI | PIPE | DOLLAR | MINUS | GT | GE | SHARP | POINT | LT | LARROW | AROBAS | LSQUARE | EQ | RARROW | RCURLY | EXCL | DRCURLY | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}