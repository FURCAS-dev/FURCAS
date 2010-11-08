// $ANTLR 3.1.1 ./scenariotestTemp/generated2/Kmelia.g 2010-11-04 23:31:18

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

public class KmeliaLexer extends Lexer {
    public static final int LT=33;
    public static final int STAR=28;
    public static final int LSQUARE=18;
    public static final int POINT=25;
    public static final int ESC=43;
    public static final int MINUSMINUS=14;
    public static final int LARROW=37;
    public static final int EXCL=20;
    public static final int FLOAT=7;
    public static final int EOF=-1;
    public static final int EXCLEXCL=16;
    public static final int LPAREN=12;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=13;
    public static final int T__57=57;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=29;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int PLUS=30;
    public static final int PIPE=22;
    public static final int DIGIT=40;
    public static final int NL=38;
    public static final int EQ=31;
    public static final int COMMENT=17;
    public static final int T__50=50;
    public static final int NE=36;
    public static final int GE=34;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=26;
    public static final int LCURLY=9;
    public static final int INT=6;
    public static final int MINUS=27;
    public static final int RSQUARE=19;
    public static final int COMA=10;
    public static final int SEMI=21;
    public static final int ALPHA=41;
    public static final int COLON=8;
    public static final int COLONCOLON=24;
    public static final int RLARROW=15;
    public static final int WS=39;
    public static final int SNAME=42;
    public static final int RCURLY=11;
    public static final int GT=32;
    public static final int QMARK=23;
    public static final int LE=35;
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

    public KmeliaLexer() {;} 
    public KmeliaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public KmeliaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/Kmelia.g"; }

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:117:7: ( 'COMPONENT' )
            // ./scenariotestTemp/generated2/Kmelia.g:117:9: 'COMPONENT'
            {
            match("COMPONENT"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:118:7: ( 'INTERFACE' )
            // ./scenariotestTemp/generated2/Kmelia.g:118:9: 'INTERFACE'
            {
            match("INTERFACE"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:119:7: ( 'provides' )
            // ./scenariotestTemp/generated2/Kmelia.g:119:9: 'provides'
            {
            match("provides"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:120:7: ( 'requires' )
            // ./scenariotestTemp/generated2/Kmelia.g:120:9: 'requires'
            {
            match("requires"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:121:7: ( 'SERVICES' )
            // ./scenariotestTemp/generated2/Kmelia.g:121:9: 'SERVICES'
            {
            match("SERVICES"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:122:7: ( 'END_SERVICES' )
            // ./scenariotestTemp/generated2/Kmelia.g:122:9: 'END_SERVICES'
            {
            match("END_SERVICES"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:123:7: ( 'required' )
            // ./scenariotestTemp/generated2/Kmelia.g:123:9: 'required'
            {
            match("required"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:124:7: ( 'provided' )
            // ./scenariotestTemp/generated2/Kmelia.g:124:9: 'provided'
            {
            match("provided"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:125:7: ( 'external' )
            // ./scenariotestTemp/generated2/Kmelia.g:125:9: 'external'
            {
            match("external"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:126:7: ( 'end' )
            // ./scenariotestTemp/generated2/Kmelia.g:126:9: 'end'
            {
            match("end"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:127:7: ( 'Behavior' )
            // ./scenariotestTemp/generated2/Kmelia.g:127:9: 'Behavior'
            {
            match("Behavior"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:128:7: ( 'Interface' )
            // ./scenariotestTemp/generated2/Kmelia.g:128:9: 'Interface'
            {
            match("Interface"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:129:7: ( 'init' )
            // ./scenariotestTemp/generated2/Kmelia.g:129:9: 'init'
            {
            match("init"); 


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
            // ./scenariotestTemp/generated2/Kmelia.g:130:7: ( 'final' )
            // ./scenariotestTemp/generated2/Kmelia.g:130:9: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:468:3: ( ( ( ( '#' (~ ( '\\r' | '\\n' ) )* ) ) | ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:469:6: ( ( ( '#' (~ ( '\\r' | '\\n' ) )* ) ) | ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:469:6: ( ( ( '#' (~ ( '\\r' | '\\n' ) )* ) ) | ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='#') ) {
                alt3=1;
            }
            else if ( (LA3_0=='/') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:469:7: ( ( '#' (~ ( '\\r' | '\\n' ) )* ) )
                    {
                    // ./scenariotestTemp/generated2/Kmelia.g:469:7: ( ( '#' (~ ( '\\r' | '\\n' ) )* ) )
                    // ./scenariotestTemp/generated2/Kmelia.g:469:8: ( '#' (~ ( '\\r' | '\\n' ) )* )
                    {
                    // ./scenariotestTemp/generated2/Kmelia.g:469:8: ( '#' (~ ( '\\r' | '\\n' ) )* )
                    // ./scenariotestTemp/generated2/Kmelia.g:469:9: '#' (~ ( '\\r' | '\\n' ) )*
                    {
                    match('#'); 
                    // ./scenariotestTemp/generated2/Kmelia.g:469:13: (~ ( '\\r' | '\\n' ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:469:14: ~ ( '\\r' | '\\n' )
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
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:469:34: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
                    {
                    // ./scenariotestTemp/generated2/Kmelia.g:469:34: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
                    // ./scenariotestTemp/generated2/Kmelia.g:469:35: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
                    {
                    // ./scenariotestTemp/generated2/Kmelia.g:469:35: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
                    // ./scenariotestTemp/generated2/Kmelia.g:469:36: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
                    {
                    match("/*"); 

                    // ./scenariotestTemp/generated2/Kmelia.g:469:41: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
                    	    // ./scenariotestTemp/generated2/Kmelia.g:469:70: ( '\\n' | ~ '\\n' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match("*/"); 


                    }


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
    // $ANTLR end "COMMENT"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:474:3: ( '[' )
            // ./scenariotestTemp/generated2/Kmelia.g:475:3: '['
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
            // ./scenariotestTemp/generated2/Kmelia.g:480:3: ( ']' )
            // ./scenariotestTemp/generated2/Kmelia.g:481:3: ']'
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
            // ./scenariotestTemp/generated2/Kmelia.g:486:3: ( '!' )
            // ./scenariotestTemp/generated2/Kmelia.g:487:3: '!'
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

    // $ANTLR start "EXCLEXCL"
    public final void mEXCLEXCL() throws RecognitionException {
        try {
            int _type = EXCLEXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:492:3: ( '!!' )
            // ./scenariotestTemp/generated2/Kmelia.g:493:3: '!!'
            {
            match("!!"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLEXCL"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:498:3: ( ',' )
            // ./scenariotestTemp/generated2/Kmelia.g:499:3: ','
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
            // ./scenariotestTemp/generated2/Kmelia.g:504:3: ( '(' )
            // ./scenariotestTemp/generated2/Kmelia.g:505:3: '('
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
            // ./scenariotestTemp/generated2/Kmelia.g:510:3: ( ')' )
            // ./scenariotestTemp/generated2/Kmelia.g:511:3: ')'
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
            // ./scenariotestTemp/generated2/Kmelia.g:516:3: ( '{' )
            // ./scenariotestTemp/generated2/Kmelia.g:517:3: '{'
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
            // ./scenariotestTemp/generated2/Kmelia.g:522:3: ( '}' )
            // ./scenariotestTemp/generated2/Kmelia.g:523:3: '}'
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
            // ./scenariotestTemp/generated2/Kmelia.g:528:3: ( ';' )
            // ./scenariotestTemp/generated2/Kmelia.g:529:3: ';'
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
            // ./scenariotestTemp/generated2/Kmelia.g:534:3: ( ':' )
            // ./scenariotestTemp/generated2/Kmelia.g:535:3: ':'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:540:3: ( '|' )
            // ./scenariotestTemp/generated2/Kmelia.g:541:3: '|'
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

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:546:3: ( '?' )
            // ./scenariotestTemp/generated2/Kmelia.g:547:3: '?'
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

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:552:3: ( '::' )
            // ./scenariotestTemp/generated2/Kmelia.g:553:3: '::'
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

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:558:3: ( '.' )
            // ./scenariotestTemp/generated2/Kmelia.g:559:3: '.'
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

    // $ANTLR start "MINUSMINUS"
    public final void mMINUSMINUS() throws RecognitionException {
        try {
            int _type = MINUSMINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:564:3: ( '--' )
            // ./scenariotestTemp/generated2/Kmelia.g:565:3: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUSMINUS"

    // $ANTLR start "RLARROW"
    public final void mRLARROW() throws RecognitionException {
        try {
            int _type = RLARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:570:3: ( '-->' )
            // ./scenariotestTemp/generated2/Kmelia.g:571:3: '-->'
            {
            match("-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RLARROW"

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:576:3: ( '->' )
            // ./scenariotestTemp/generated2/Kmelia.g:577:3: '->'
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
            // ./scenariotestTemp/generated2/Kmelia.g:582:3: ( '-' )
            // ./scenariotestTemp/generated2/Kmelia.g:583:3: '-'
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
            // ./scenariotestTemp/generated2/Kmelia.g:588:3: ( '*' )
            // ./scenariotestTemp/generated2/Kmelia.g:589:3: '*'
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
            // ./scenariotestTemp/generated2/Kmelia.g:594:3: ( '/' )
            // ./scenariotestTemp/generated2/Kmelia.g:595:3: '/'
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
            // ./scenariotestTemp/generated2/Kmelia.g:600:3: ( '+' )
            // ./scenariotestTemp/generated2/Kmelia.g:601:3: '+'
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
            // ./scenariotestTemp/generated2/Kmelia.g:606:3: ( '=' )
            // ./scenariotestTemp/generated2/Kmelia.g:607:3: '='
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
            // ./scenariotestTemp/generated2/Kmelia.g:612:3: ( '>' )
            // ./scenariotestTemp/generated2/Kmelia.g:613:3: '>'
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
            // ./scenariotestTemp/generated2/Kmelia.g:618:3: ( '<' )
            // ./scenariotestTemp/generated2/Kmelia.g:619:3: '<'
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
            // ./scenariotestTemp/generated2/Kmelia.g:624:3: ( '>=' )
            // ./scenariotestTemp/generated2/Kmelia.g:625:3: '>='
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
            // ./scenariotestTemp/generated2/Kmelia.g:630:3: ( '<=' )
            // ./scenariotestTemp/generated2/Kmelia.g:631:3: '<='
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
            // ./scenariotestTemp/generated2/Kmelia.g:636:3: ( '<>' )
            // ./scenariotestTemp/generated2/Kmelia.g:637:3: '<>'
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
            // ./scenariotestTemp/generated2/Kmelia.g:642:3: ( '<-' )
            // ./scenariotestTemp/generated2/Kmelia.g:643:3: '<-'
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
            // ./scenariotestTemp/generated2/Kmelia.g:651:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:651:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:651:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\n') ) {
                    alt4=1;
                }
                else {
                    alt4=3;}
            }
            else if ( (LA4_0=='\n') ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='\r') ) {
                    alt4=2;
                }
                else {
                    alt4=4;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:651:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:652:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/Kmelia.g:653:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/Kmelia.g:654:5: '\\n'
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
            // ./scenariotestTemp/generated2/Kmelia.g:660:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:660:4: ( ' ' | '\\t' )
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
            // ./scenariotestTemp/generated2/Kmelia.g:667:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/Kmelia.g:667:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/Kmelia.g:672:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/Kmelia.g:
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
            // ./scenariotestTemp/generated2/Kmelia.g:686:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/Kmelia.g:686:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/Kmelia.g:686:4: ( ALPHA )
            // ./scenariotestTemp/generated2/Kmelia.g:686:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/Kmelia.g:686:12: ( ALPHA | DIGIT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:
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
            	    break loop5;
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
            // ./scenariotestTemp/generated2/Kmelia.g:690:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:690:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:690:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u00FF')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='\"') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:691:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:693:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/Kmelia.g:694:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
                    loop6:
                    do {
                        int alt6=4;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( (LA6_0=='\n') ) {
                            alt6=2;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=3;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:694:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:695:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:696:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
                    	    break loop6;
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:704:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/Kmelia.g:704:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/Kmelia.g:704:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/Kmelia.g:704:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
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
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/Kmelia.g:708:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // ./scenariotestTemp/generated2/Kmelia.g:708:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // ./scenariotestTemp/generated2/Kmelia.g:708:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/Kmelia.g:708:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            match('.'); 
            // ./scenariotestTemp/generated2/Kmelia.g:708:20: ( DIGIT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:708:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // ./scenariotestTemp/generated2/Kmelia.g:712:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:712:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/Kmelia.g:713:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:713:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:714:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/Kmelia.g:715:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/Kmelia.g:716:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/Kmelia.g:717:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/Kmelia.g:718:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/Kmelia.g:719:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/Kmelia.g:720:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/Kmelia.g:721:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/Kmelia.g:721:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>='0' && LA14_0<='3')) ) {
                        alt14=1;
                    }
                    else if ( ((LA14_0>='4' && LA14_0<='7')) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ./scenariotestTemp/generated2/Kmelia.g:722:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/Kmelia.g:722:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/Kmelia.g:722:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/Kmelia.g:723:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/Kmelia.g:727:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/Kmelia.g:727:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/Kmelia.g:727:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/Kmelia.g:728:6: ( '0' .. '7' )?
                                    int alt11=2;
                                    int LA11_0 = input.LA(1);

                                    if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                        alt11=1;
                                    }
                                    switch (alt11) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/Kmelia.g:732:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/Kmelia.g:735:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/Kmelia.g:735:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/Kmelia.g:735:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/Kmelia.g:736:5: ( ( '0' .. '7' ) )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( ((LA13_0>='0' && LA13_0<='7')) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/Kmelia.g:740:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/Kmelia.g:740:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/Kmelia.g:740:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/Kmelia.g:757:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/Kmelia.g:757:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/Kmelia.g:758:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
            	    // ./scenariotestTemp/generated2/Kmelia.g:758:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:759:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:760:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
            	    break loop16;
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
        // ./scenariotestTemp/generated2/Kmelia.g:1:8: ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | COMMENT | LSQUARE | RSQUARE | EXCL | EXCLEXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | QMARK | COLONCOLON | POINT | MINUSMINUS | RLARROW | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt17=50;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:10: T__44
                {
                mT__44(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:16: T__45
                {
                mT__45(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:22: T__46
                {
                mT__46(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:28: T__47
                {
                mT__47(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:34: T__48
                {
                mT__48(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:40: T__49
                {
                mT__49(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:46: T__50
                {
                mT__50(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:52: T__51
                {
                mT__51(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:58: T__52
                {
                mT__52(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:64: T__53
                {
                mT__53(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:70: T__54
                {
                mT__54(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:76: T__55
                {
                mT__55(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:82: T__56
                {
                mT__56(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:88: T__57
                {
                mT__57(); 

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:94: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:102: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:110: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:118: EXCL
                {
                mEXCL(); 

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:123: EXCLEXCL
                {
                mEXCLEXCL(); 

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:132: COMA
                {
                mCOMA(); 

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:137: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:144: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:151: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:158: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:165: SEMI
                {
                mSEMI(); 

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:170: COLON
                {
                mCOLON(); 

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:176: PIPE
                {
                mPIPE(); 

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:181: QMARK
                {
                mQMARK(); 

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:187: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:198: POINT
                {
                mPOINT(); 

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:204: MINUSMINUS
                {
                mMINUSMINUS(); 

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:215: RLARROW
                {
                mRLARROW(); 

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:223: RARROW
                {
                mRARROW(); 

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:230: MINUS
                {
                mMINUS(); 

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:236: STAR
                {
                mSTAR(); 

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:241: SLASH
                {
                mSLASH(); 

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:247: PLUS
                {
                mPLUS(); 

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:252: EQ
                {
                mEQ(); 

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:255: GT
                {
                mGT(); 

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:258: LT
                {
                mLT(); 

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:261: GE
                {
                mGE(); 

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:264: LE
                {
                mLE(); 

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:267: NE
                {
                mNE(); 

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:270: LARROW
                {
                mLARROW(); 

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:277: NL
                {
                mNL(); 

                }
                break;
            case 46 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:280: WS
                {
                mWS(); 

                }
                break;
            case 47 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:283: NAME
                {
                mNAME(); 

                }
                break;
            case 48 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:288: INT
                {
                mINT(); 

                }
                break;
            case 49 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:292: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 50 :
                // ./scenariotestTemp/generated2/Kmelia.g:1:298: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\12\42\1\uffff\1\61\2\uffff\1\63\6\uffff\1\65\3\uffff\1"+
        "\70\3\uffff\1\72\1\76\3\uffff\1\77\1\uffff\14\42\5\uffff\1\116\12"+
        "\uffff\10\42\1\127\3\42\2\uffff\10\42\1\uffff\1\42\1\144\12\42\1"+
        "\uffff\1\157\11\42\1\uffff\14\42\1\u0087\1\u0088\1\u0089\1\u008a"+
        "\1\u008b\1\42\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\5\uffff\1"+
        "\42\5\uffff\2\42\1\u0095\1\uffff";
    static final String DFA17_eofS =
        "\u0096\uffff";
    static final String DFA17_minS =
        "\1\11\1\117\1\116\1\162\1\145\1\105\1\116\1\156\1\145\1\156\1\151"+
        "\1\uffff\1\52\2\uffff\1\41\6\uffff\1\72\3\uffff\1\55\3\uffff\1\75"+
        "\1\55\3\uffff\1\56\1\uffff\1\115\1\124\1\164\1\157\1\161\1\122\1"+
        "\104\1\164\1\144\1\150\1\151\1\156\5\uffff\1\76\12\uffff\1\120\1"+
        "\105\1\145\1\166\1\165\1\126\1\137\1\145\1\60\1\141\1\164\1\141"+
        "\2\uffff\1\117\1\122\1\162\2\151\1\111\1\123\1\162\1\uffff\1\166"+
        "\1\60\1\154\1\116\1\106\1\146\1\144\1\162\1\103\1\105\1\156\1\151"+
        "\1\uffff\1\60\1\105\1\101\1\141\2\145\1\105\1\122\1\141\1\157\1"+
        "\uffff\1\116\1\103\1\143\2\144\1\123\1\126\1\154\1\162\1\124\1\105"+
        "\1\145\5\60\1\111\5\60\5\uffff\1\103\5\uffff\1\105\1\123\1\60\1"+
        "\uffff";
    static final String DFA17_maxS =
        "\1\u00ff\1\117\1\156\1\162\1\145\1\105\1\116\1\170\1\145\1\156\1"+
        "\151\1\uffff\1\52\2\uffff\1\41\6\uffff\1\72\3\uffff\1\76\3\uffff"+
        "\1\75\1\76\3\uffff\1\71\1\uffff\1\115\1\124\1\164\1\157\1\161\1"+
        "\122\1\104\1\164\1\144\1\150\1\151\1\156\5\uffff\1\76\12\uffff\1"+
        "\120\1\105\1\145\1\166\1\165\1\126\1\137\1\145\1\u00ff\1\141\1\164"+
        "\1\141\2\uffff\1\117\1\122\1\162\2\151\1\111\1\123\1\162\1\uffff"+
        "\1\166\1\u00ff\1\154\1\116\1\106\1\146\1\144\1\162\1\103\1\105\1"+
        "\156\1\151\1\uffff\1\u00ff\1\105\1\101\1\141\2\145\1\105\1\122\1"+
        "\141\1\157\1\uffff\1\116\1\103\1\143\2\163\1\123\1\126\1\154\1\162"+
        "\1\124\1\105\1\145\5\u00ff\1\111\5\u00ff\5\uffff\1\103\5\uffff\1"+
        "\105\1\123\1\u00ff\1\uffff";
    static final String DFA17_acceptS =
        "\13\uffff\1\17\1\uffff\1\20\1\21\1\uffff\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\uffff\1\33\1\34\1\36\1\uffff\1\43\1\45\1\46\2\uffff\1\55"+
        "\1\56\1\57\1\uffff\1\62\14\uffff\1\44\1\23\1\22\1\35\1\32\1\uffff"+
        "\1\41\1\42\1\51\1\47\1\52\1\53\1\54\1\50\1\60\1\61\14\uffff\1\40"+
        "\1\37\10\uffff\1\12\14\uffff\1\15\12\uffff\1\16\27\uffff\1\3\1\10"+
        "\1\4\1\7\1\5\1\uffff\1\11\1\13\1\1\1\2\1\14\3\uffff\1\6";
    static final String DFA17_specialS =
        "\u0096\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\41\1\40\2\uffff\1\40\22\uffff\1\41\1\17\1\42\1\13\3\uffff"+
            "\1\44\1\21\1\22\1\33\1\34\1\20\1\32\1\31\1\14\12\43\1\26\1\25"+
            "\1\37\1\35\1\36\1\30\1\uffff\1\42\1\10\1\1\1\42\1\6\3\42\1\2"+
            "\11\42\1\5\7\42\1\15\1\uffff\1\16\1\uffff\1\42\1\uffff\4\42"+
            "\1\7\1\12\2\42\1\11\6\42\1\3\1\42\1\4\10\42\1\23\1\27\1\24\102"+
            "\uffff\27\42\1\uffff\37\42\1\uffff\10\42",
            "\1\45",
            "\1\46\37\uffff\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\55\11\uffff\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "\1\13",
            "",
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
            "\1\66\20\uffff\1\67",
            "",
            "",
            "",
            "\1\71",
            "\1\75\17\uffff\1\73\1\74",
            "",
            "",
            "",
            "\1\100\1\uffff\12\43",
            "",
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
            "\1\113",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
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
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\130",
            "\1\131",
            "\1\132",
            "",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\1\143",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\175\16\uffff\1\174",
            "\1\177\16\uffff\1\176",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\1\u008c",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
            "",
            "",
            "",
            "",
            "",
            "\1\u0092",
            "",
            "",
            "",
            "",
            "",
            "\1\u0093",
            "\1\u0094",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42\105\uffff\27"+
            "\42\1\uffff\37\42\1\uffff\10\42",
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
            return "1:1: Tokens : ( T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | COMMENT | LSQUARE | RSQUARE | EXCL | EXCLEXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | QMARK | COLONCOLON | POINT | MINUSMINUS | RLARROW | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}