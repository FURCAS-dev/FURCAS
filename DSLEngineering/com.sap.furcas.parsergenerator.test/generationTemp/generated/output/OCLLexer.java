// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g 2011-02-07 13:18:30

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
public class OCLLexer extends Lexer {
    public static final int STAR=24;
    public static final int RBRACK_RCURL=27;
    public static final int FLOAT=10;
    public static final int EOF=-1;
    public static final int LPAREN=12;
    public static final int LBRACKET=22;
    public static final int RPAREN=13;
    public static final int DCOLON=14;
    public static final int NAME=5;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int COMMA=16;
    public static final int LBRACK_LCURL=21;
    public static final int NL=28;
    public static final int DIGIT=30;
    public static final int RANGE_OR_INT=32;
    public static final int RBRACKET=26;
    public static final int COMMENT=20;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int RCURL_RBRACK=23;
    public static final int T__43=43;
    public static final int LCURL_LBRACK=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=18;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=11;
    public static final int INT=9;
    public static final int MULTI_LINE_COMMENT=8;
    public static final int ALPHA=31;
    public static final int COLON=19;
    public static final int LCURL=15;
    public static final int QNAME=7;
    public static final int WS=29;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int SNAME=4;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=17;
    public static final int STRING=6;
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

    public OCLLexer() {;} 
    public OCLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OCLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g"; }

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:117:7: ( 'then' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:117:9: 'then'
            {
            match("then"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:118:7: ( 'Bag' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:118:9: 'Bag'
            {
            match("Bag"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:119:7: ( ';' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:119:9: ';'
            {
            match(';'); if (state.failed) return ;

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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:120:7: ( 'self' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:120:9: 'self'
            {
            match("self"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:121:7: ( '.' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:121:9: '.'
            {
            match('.'); if (state.failed) return ;

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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:122:7: ( 'collect' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:122:9: 'collect'
            {
            match("collect"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:123:7: ( '=' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:123:9: '='
            {
            match('='); if (state.failed) return ;

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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:124:7: ( 'iterate' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:124:9: 'iterate'
            {
            match("iterate"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:125:7: ( '|' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:125:9: '|'
            {
            match('|'); if (state.failed) return ;

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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:126:7: ( 'in' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:126:9: 'in'
            {
            match("in"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:127:7: ( 'OrderedSet' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:127:9: 'OrderedSet'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:128:7: ( 'Sequence' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:128:9: 'Sequence'
            {
            match("Sequence"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:129:7: ( 'else' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:129:9: 'else'
            {
            match("else"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:130:7: ( '\\'' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:130:9: '\\''
            {
            match('\''); if (state.failed) return ;

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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:131:7: ( 'let' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:131:9: 'let'
            {
            match("let"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:132:7: ( 'endif' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:132:9: 'endif'
            {
            match("endif"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:133:7: ( 'Set' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:133:9: 'Set'
            {
            match("Set"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:134:7: ( 'forAll' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:134:9: 'forAll'
            {
            match("forAll"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:135:7: ( 'if' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:135:9: 'if'
            {
            match("if"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:136:7: ( 'Collection' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:136:9: 'Collection'
            {
            match("Collection"); if (state.failed) return ;


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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:137:7: ( '->' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:137:9: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1039:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1040:15: ~ ( '\\r' | '\\n' )
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1045:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); if (state.failed) return ;

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1046:44: ( '\\n' | ~ '\\n' )
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

    // $ANTLR start "DCOLON"
    public final void mDCOLON() throws RecognitionException {
        try {
            int _type = DCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1051:3: ( '::' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1052:3: '::'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1057:3: ( ',' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1058:3: ','
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

    // $ANTLR start "LBRACK_LCURL"
    public final void mLBRACK_LCURL() throws RecognitionException {
        try {
            int _type = LBRACK_LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1063:3: ( '[{' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1064:3: '[{'
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

    // $ANTLR start "LCURL"
    public final void mLCURL() throws RecognitionException {
        try {
            int _type = LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1069:3: ( '{' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1070:3: '{'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1075:3: ( '}' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1076:3: '}'
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

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1081:3: ( '[' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1082:3: '['
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

    // $ANTLR start "RCURL_RBRACK"
    public final void mRCURL_RBRACK() throws RecognitionException {
        try {
            int _type = RCURL_RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1087:3: ( '}]' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1088:3: '}]'
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

    // $ANTLR start "DDOT"
    public final void mDDOT() throws RecognitionException {
        try {
            int _type = DDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1093:3: ( '..' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1094:3: '..'
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

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1099:3: ( ')' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1100:3: ')'
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1105:3: ( '(' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1106:3: '('
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1111:3: ( '*' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1112:3: '*'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1117:3: ( ':' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1118:3: ':'
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

    // $ANTLR start "LCURL_LBRACK"
    public final void mLCURL_LBRACK() throws RecognitionException {
        try {
            int _type = LCURL_LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1123:3: ( '{[' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1124:3: '{['
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

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1129:3: ( ']' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1130:3: ']'
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

    // $ANTLR start "RBRACK_RCURL"
    public final void mRBRACK_RCURL() throws RecognitionException {
        try {
            int _type = RBRACK_RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1135:3: ( ']}' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1136:3: ']}'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1145:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1145:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1145:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1145:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1146:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1147:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1148:5: '\\n'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1154:2: ( ( ' ' | '\\t' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1154:4: ( ' ' | '\\t' )
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1161:2: ( '0' .. '9' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1161:4: '0' .. '9'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1166:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1177:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1177:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1177:4: ( ALPHA )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1177:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1177:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1180:6: ( 'true' | 'false' )
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1180:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1180:17: 'false'
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1183:2: ( ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1183:4: ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1183:4: ( ( SNAME ~ DCOLON )=> SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1184:4: ( SNAME ~ DCOLON )=> SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1185:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1186:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1187:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1188:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1195:2: ( SNAME DCOLON SNAME ( DCOLON SNAME )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1195:4: SNAME DCOLON SNAME ( DCOLON SNAME )*
            {
            mSNAME(); if (state.failed) return ;
            mDCOLON(); if (state.failed) return ;
            mSNAME(); if (state.failed) return ;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1195:23: ( DCOLON SNAME )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==':') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1195:24: DCOLON SNAME
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1200:2: ( ( DIGIT )+ )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1200:4: ( DIGIT )+
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1200:4: ( DIGIT )+
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1200:5: DIGIT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:4: ( DIGIT )+
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:4: DIGIT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1205:15: DIGIT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1209:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1209:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1210:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1211:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1218:9: INT
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
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1223:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1223:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1224:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1226:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1227:5: ~ ( '\\\\' | '\"' | '\\n' )
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
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | COMMENT | MULTI_LINE_COMMENT | DCOLON | COMMA | LBRACK_LCURL | LCURL | RCURL | LBRACKET | RCURL_RBRACK | DDOT | RPAREN | LPAREN | STAR | COLON | LCURL_LBRACK | RBRACKET | RBRACK_RCURL | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING )
        int alt14=46;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:10: T__33
                {
                mT__33(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:16: T__34
                {
                mT__34(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:22: T__35
                {
                mT__35(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:28: T__36
                {
                mT__36(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:34: T__37
                {
                mT__37(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:40: T__38
                {
                mT__38(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:46: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:52: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:58: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:64: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:70: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:76: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:82: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:88: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:94: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:100: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:106: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:112: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:118: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:124: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:130: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:136: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:144: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:163: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:170: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:176: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:189: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:195: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:201: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:210: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:223: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:228: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:235: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:242: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:247: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:253: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:266: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:275: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:288: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:291: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:294: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:299: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:304: QNAME
                {
                mQNAME(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:310: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:314: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1:327: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_OCL
    public final void synpred1_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1184:4: ( SNAME ~ DCOLON )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1184:5: SNAME ~ DCOLON
        {
        mSNAME(); if (state.failed) return ;
        if ( (input.LA(1)>='\u0000' && input.LA(1)<='\r')||(input.LA(1)>='\u000F' && input.LA(1)<='\uFFFF') ) {
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
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1209:9: ( INT '..' )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1209:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred2_OCL

    // $ANTLR start synpred3_OCL
    public final void synpred3_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1210:7: ( INT '.' NAME )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1210:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_OCL

    // $ANTLR start synpred4_OCL
    public final void synpred4_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1211:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1211:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
        "\1\uffff\2\43\1\uffff\1\43\1\51\1\43\1\uffff\1\43\1\uffff\3\43"+
        "\1\62\3\43\2\uffff\1\72\1\uffff\1\74\1\76\1\100\3\uffff\1\102\2"+
        "\uffff\1\43\1\103\1\uffff\2\43\1\uffff\1\43\1\uffff\2\43\2\uffff"+
        "\2\43\1\113\1\114\4\43\1\uffff\4\43\16\uffff\2\43\1\130\3\43\2\uffff"+
        "\2\43\1\136\2\43\1\141\3\43\1\145\1\146\1\uffff\1\147\4\43\1\uffff"+
        "\1\154\1\43\1\uffff\3\43\3\uffff\4\43\1\uffff\1\165\1\43\1\146\5"+
        "\43\1\uffff\1\174\1\43\1\176\1\177\2\43\1\uffff\1\43\2\uffff\1\43"+
        "\1\u0084\2\43\1\uffff\1\43\1\u0088\1\u0089\2\uffff";
    static final String DFA14_eofS =
        "\u008a\uffff";
    static final String DFA14_minS =
        "\1\11\2\60\1\uffff\1\60\1\56\1\60\1\uffff\1\60\1\uffff\3\60\1\0"+
        "\3\60\1\uffff\1\52\1\72\1\uffff\1\173\1\133\1\135\3\uffff\1\175"+
        "\2\uffff\1\60\1\56\1\uffff\2\60\1\uffff\1\60\1\uffff\2\60\2\uffff"+
        "\10\60\1\uffff\4\60\16\uffff\6\60\2\uffff\13\60\1\uffff\5\60\1\uffff"+
        "\2\60\1\uffff\3\60\3\uffff\4\60\1\uffff\10\60\1\uffff\6\60\1\uffff"+
        "\1\60\2\uffff\4\60\1\uffff\3\60\2\uffff";
    static final String DFA14_maxS =
        "\3\u00ff\1\uffff\1\u00ff\1\56\1\u00ff\1\uffff\1\u00ff\1\uffff\3"+
        "\u00ff\1\uffff\3\u00ff\1\uffff\1\57\1\72\1\uffff\1\173\1\133\1\135"+
        "\3\uffff\1\175\2\uffff\1\u00ff\1\71\1\uffff\2\u00ff\1\uffff\1\u00ff"+
        "\1\uffff\2\u00ff\2\uffff\10\u00ff\1\uffff\4\u00ff\16\uffff\6\u00ff"+
        "\2\uffff\13\u00ff\1\uffff\5\u00ff\1\uffff\2\u00ff\1\uffff\3\u00ff"+
        "\3\uffff\4\u00ff\1\uffff\10\u00ff\1\uffff\6\u00ff\1\uffff\1\u00ff"+
        "\2\uffff\4\u00ff\1\uffff\3\u00ff\2\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\3\3\uffff\1\7\1\uffff\1\11\7\uffff\1\25\2\uffff\1\31"+
        "\3\uffff\1\40\1\41\1\42\1\uffff\1\47\1\50\2\uffff\1\56\2\uffff\1"+
        "\52\1\uffff\1\53\2\uffff\1\37\1\5\10\uffff\1\16\4\uffff\1\26\1\27"+
        "\1\30\1\43\1\32\1\35\1\44\1\33\1\36\1\34\1\46\1\45\1\54\1\55\6\uffff"+
        "\1\12\1\23\13\uffff\1\2\5\uffff\1\21\2\uffff\1\17\3\uffff\1\1\1"+
        "\51\1\4\4\uffff\1\15\10\uffff\1\20\6\uffff\1\22\1\uffff\1\6\1\10"+
        "\4\uffff\1\14\3\uffff\1\13\1\24";
    static final String DFA14_specialS =
        "\15\uffff\1\0\174\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\35\1\34\2\uffff\1\34\22\uffff\1\35\1\uffff\1\40\4\uffff"+
            "\1\15\1\31\1\30\1\32\1\uffff\1\24\1\21\1\5\1\22\12\37\1\23\1"+
            "\3\1\uffff\1\7\3\uffff\1\36\1\2\1\20\13\36\1\12\3\36\1\13\7"+
            "\36\1\25\1\uffff\1\33\1\uffff\1\36\1\uffff\2\36\1\6\1\36\1\14"+
            "\1\17\2\36\1\10\2\36\1\16\6\36\1\4\1\1\6\36\1\26\1\11\1\27\102"+
            "\uffff\27\36\1\uffff\37\36\1\uffff\10\36",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\7\44\1\41\11"+
            "\44\1\42\10\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\1\46\31\44"+
            "\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\47\25"+
            "\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\1\50",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\52"+
            "\13\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\5\44\1\55\7"+
            "\44\1\54\5\44\1\53\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff"+
            "\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\56"+
            "\10\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\57\25"+
            "\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\60"+
            "\1\44\1\61\14\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\134\43\1\uffff\uffa3\43",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\63\25"+
            "\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\1\65\15\44"+
            "\1\64\13\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\66"+
            "\13\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\1\70\4\uffff\1\67",
            "\1\71",
            "",
            "\1\73",
            "\1\75",
            "\1\77",
            "",
            "",
            "",
            "\1\101",
            "",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\1\104\1\uffff\12\37",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\105"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\106"+
            "\5\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\6\44\1\107"+
            "\23\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\110"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\111"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\112"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\115"+
            "\26\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\20\44\1\116"+
            "\2\44\1\117\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\120"+
            "\7\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\121"+
            "\26\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\122"+
            "\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\123"+
            "\10\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\124"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\125"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
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
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\126"+
            "\14\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\127"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\5\44\1\131"+
            "\24\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\132"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\133"+
            "\10\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\134"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\24\44\1\135"+
            "\5\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\137"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\140"+
            "\21\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\1\142\31\44\4\uffff\1\44\1\uffff\32\44"+
            "\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\143"+
            "\7\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\144"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\150"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\1\151\31\44"+
            "\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\152"+
            "\10\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\153"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\5\44\1\155"+
            "\24\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\156"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\157"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\160"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\161"+
            "\27\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\162"+
            "\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\163"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\164"+
            "\14\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\13\44\1\166"+
            "\16\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\167"+
            "\27\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\170"+
            "\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\171"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\3\44\1\172"+
            "\26\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\173"+
            "\27\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\175"+
            "\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\22\44\1\u0080\7\44\4\uffff\1\44\1\uffff"+
            "\32\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u0081"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\10\44\1\u0082"+
            "\21\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\4\44\1\u0083"+
            "\25\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\16\44\1\u0085"+
            "\13\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\u0086"+
            "\6\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\15\44\1\u0087"+
            "\14\44\105\uffff\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\1\45\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff"+
            "\27\44\1\uffff\37\44\1\uffff\10\44",
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
            return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | COMMENT | MULTI_LINE_COMMENT | DCOLON | COMMA | LBRACK_LCURL | LCURL | RCURL | LBRACKET | RCURL_RBRACK | DDOT | RPAREN | LPAREN | STAR | COLON | LCURL_LBRACK | RBRACKET | RBRACK_RCURL | NL | WS | BOOL | NAME | QNAME | INT | RANGE_OR_INT | STRING );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_13 = input.LA(1);

                        s = -1;
                        if ( ((LA14_13>='\u0000' && LA14_13<='[')||(LA14_13>=']' && LA14_13<='\uFFFF')) ) {s = 35;}

                        else s = 50;

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