// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-11-26 17:23:08

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
public class FinexClassLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LANGLE=26;
    public static final int FLOAT=8;
    public static final int EQUALS=24;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int T__55=55;
    public static final int LBRACKET=14;
    public static final int T__56=56;
    public static final int RPAREN=20;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=38;
    public static final int T__59=59;
    public static final int PIPE=23;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int RANGE_OR_INT=39;
    public static final int RANGLE=25;
    public static final int RBRACKET=15;
    public static final int COMMENT=28;
    public static final int DOT=16;
    public static final int T__50=50;
    public static final int FIRST_LOWERCASE_SNAME=36;
    public static final int T__42=42;
    public static final int LOWERCASE_ALPHA=33;
    public static final int EQUALSEQUALS=27;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=17;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=9;
    public static final int INT=7;
    public static final int SEMICOLON=13;
    public static final int UPPERCASE_ALPHA=34;
    public static final int MULTI_LINE_COMMENT=29;
    public static final int ALPHA=35;
    public static final int COLON=12;
    public static final int LCURL=21;
    public static final int WS=31;
    public static final int T__70=70;
    public static final int FIRST_UPPERCASE_SNAME=37;
    public static final int FIRST_LOWERCASE_NAME=4;
    public static final int RCURL=22;
    public static final int ASSIGN=18;
    public static final int FIRST_UPPERCASE_NAME=5;
    public static final int BINARY=10;
    public static final int DATE=11;
    public static final int STRING=6;
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

    public FinexClassLexer() {;} 
    public FinexClassLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public FinexClassLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g"; }

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:117:7: ( 'value' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:117:9: 'value'
            {
            match("value"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:118:7: ( 'opposite' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:118:9: 'opposite'
            {
            match("opposite"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:119:7: ( 'DEFAULT' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:119:9: 'DEFAULT'
            {
            match("DEFAULT"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:120:7: ( 'AS' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:120:9: 'AS'
            {
            match("AS"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:121:7: ( 'KEY' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:121:9: 'KEY'
            {
            match("KEY"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:122:7: ( 'function' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:122:9: 'function'
            {
            match("function"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:123:7: ( 'manipulator' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:123:9: 'manipulator'
            {
            match("manipulator"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:124:7: ( 'IN' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:124:9: 'IN'
            {
            match("IN"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:125:7: ( ',' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:125:9: ','
            {
            match(','); if (state.failed) return ;

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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:126:7: ( 'OUT' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:126:9: 'OUT'
            {
            match("OUT"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:127:7: ( '-' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:127:9: '-'
            {
            match('-'); if (state.failed) return ;

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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:128:7: ( 'not' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:128:9: 'not'
            {
            match("not"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:129:7: ( '*' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:129:9: '*'
            {
            match('*'); if (state.failed) return ;

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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:130:7: ( '/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:130:9: '/'
            {
            match('/'); if (state.failed) return ;

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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:131:7: ( 'AND' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:131:9: 'AND'
            {
            match("AND"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:132:7: ( 'OR' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:132:9: 'OR'
            {
            match("OR"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:133:7: ( '+' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:133:9: '+'
            {
            match('+'); if (state.failed) return ;

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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:134:7: ( '>=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:134:9: '>='
            {
            match(">="); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:135:7: ( '<=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:135:9: '<='
            {
            match("<="); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:136:7: ( '!=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:136:9: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:137:7: ( 'and' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:137:9: 'and'
            {
            match("and"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:138:7: ( 'or' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:138:9: 'or'
            {
            match("or"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:139:7: ( 'xor' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:139:9: 'xor'
            {
            match("xor"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:140:7: ( 'count' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:140:9: 'count'
            {
            match("count"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:141:7: ( 'single' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:141:9: 'single'
            {
            match("single"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:142:7: ( 'sum' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:142:9: 'sum'
            {
            match("sum"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:143:7: ( 'avg' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:143:9: 'avg'
            {
            match("avg"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:144:7: ( 'min' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:144:9: 'min'
            {
            match("min"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:145:7: ( 'max' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:145:9: 'max'
            {
            match("max"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:146:7: ( 'create' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:146:9: 'create'
            {
            match("create"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:147:7: ( 'this' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:147:9: 'this'
            {
            match("this"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1260:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1261:15: ~ ( '\\r' | '\\n' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1266:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1267:43: ( '\\n' | ~ '\\n' )
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

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1272:3: ( '[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1273:3: '['
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1278:3: ( ']' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1279:3: ']'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1284:3: ( '{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1285:3: '{'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1290:3: ( '}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1291:3: '}'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1296:3: ( '<' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1297:3: '<'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1302:3: ( '>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1303:3: '>'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:3: ( '(' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1309:3: '('
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1314:3: ( ')' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1315:3: ')'
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

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1320:3: ( '=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1321:3: '='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1326:3: ( '==' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1327:3: '=='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1332:3: ( ':=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1333:3: ':='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1338:3: ( '.' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:3: '.'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1344:3: ( '..' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1345:3: '..'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1350:3: ( '|' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1351:3: '|'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1356:3: ( ':' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1357:3: ':'
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

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1362:3: ( ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1363:3: ';'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1372:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1372:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1372:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1372:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1373:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1374:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1375:5: '\\n'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1381:2: ( ( ' ' | '\\t' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1381:4: ( ' ' | '\\t' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1388:2: ( '0' .. '9' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1388:4: '0' .. '9'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1393:2: ( LOWERCASE_ALPHA | UPPERCASE_ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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

    // $ANTLR start "LOWERCASE_ALPHA"
    public final void mLOWERCASE_ALPHA() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1398:2: ( 'a' .. 'z' | '_' | '\\u00DE' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
            {
            if ( input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00DE' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
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
    // $ANTLR end "LOWERCASE_ALPHA"

    // $ANTLR start "UPPERCASE_ALPHA"
    public final void mUPPERCASE_ALPHA() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1407:2: ( 'A' .. 'Z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DD' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00DD') ) {
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
    // $ANTLR end "UPPERCASE_ALPHA"

    // $ANTLR start "FIRST_LOWERCASE_SNAME"
    public final void mFIRST_LOWERCASE_SNAME() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1415:2: ( ( LOWERCASE_ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1415:4: ( LOWERCASE_ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1415:4: ( LOWERCASE_ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1415:5: LOWERCASE_ALPHA
            {
            mLOWERCASE_ALPHA(); if (state.failed) return ;

            }

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1415:22: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
    // $ANTLR end "FIRST_LOWERCASE_SNAME"

    // $ANTLR start "FIRST_UPPERCASE_SNAME"
    public final void mFIRST_UPPERCASE_SNAME() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1420:2: ( ( UPPERCASE_ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1420:4: ( UPPERCASE_ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1420:4: ( UPPERCASE_ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1420:5: UPPERCASE_ALPHA
            {
            mUPPERCASE_ALPHA(); if (state.failed) return ;

            }

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1420:22: ( ALPHA | DIGIT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            	    break loop5;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "FIRST_UPPERCASE_SNAME"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1423:6: ( 'true' | 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='t') ) {
                alt6=1;
            }
            else if ( (LA6_0=='f') ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1423:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1423:17: 'false'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:8: ( 'o:' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:10: 'o:'
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

    // $ANTLR start "FIRST_UPPERCASE_NAME"
    public final void mFIRST_UPPERCASE_NAME() throws RecognitionException {
        try {
            int _type = FIRST_UPPERCASE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1428:2: ( FIRST_UPPERCASE_SNAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1428:4: FIRST_UPPERCASE_SNAME
            {
            mFIRST_UPPERCASE_SNAME(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIRST_UPPERCASE_NAME"

    // $ANTLR start "FIRST_LOWERCASE_NAME"
    public final void mFIRST_LOWERCASE_NAME() throws RecognitionException {
        try {
            int _type = FIRST_LOWERCASE_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1432:2: ( FIRST_LOWERCASE_SNAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1432:4: FIRST_LOWERCASE_SNAME
            {
            mFIRST_LOWERCASE_SNAME(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIRST_LOWERCASE_NAME"

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1436:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1436:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1436:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='F')||(LA7_0>='a' && LA7_0<='f')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1436:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
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
    // $ANTLR end "BINARY"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1441:2: ( ( DIGIT )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1441:4: ( DIGIT )+
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1441:4: ( DIGIT )+
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1441:5: DIGIT
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
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:4: ( DIGIT )+
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:4: DIGIT
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

            match('.'); if (state.failed) return ;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:15: ( DIGIT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1446:15: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1450:5: ( ( INT '..' )=> INT | ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt11=4;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1>='0' && LA11_1<='9')) && (synpred3_FinexClass())) {
                    alt11=3;
                }
                else if ( (LA11_1=='.') && (synpred3_FinexClass())) {
                    alt11=3;
                }
                else if ( (synpred1_FinexClass()) ) {
                    alt11=1;
                }
                else if ( (synpred2_FinexClass()) ) {
                    alt11=2;
                }
                else if ( (true) ) {
                    alt11=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1450:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:7: ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1452:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1459:9: INT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1463:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1463:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1463:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==' '||LA16_0=='T') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1463:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1464:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==','||LA13_0=='.') && (synpred4_FinexClass())) {
                        alt13=1;
                    }
                    else {
                        alt13=2;}
                    switch (alt13) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:41: ( ',' | '.' ) ( DIGIT )+
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

                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:53: ( DIGIT )+
                            int cnt12=0;
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:54: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt12 >= 1 ) break loop12;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(12, input);
                                        throw eee;
                                }
                                cnt12++;
                            } while (true);


                            }


                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1467:13: 
                            {
                            }
                            break;

                    }

                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1468:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='Z') ) {
                        alt15=1;
                    }
                    else {
                        alt15=2;}
                    switch (alt15) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1468:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1468:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1468:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( (LA14_0=='+'||LA14_0=='-') ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1468:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1471:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1471:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1472:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\n') ) {
                    alt17=1;
                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1474:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1475:5: ~ ( '\\\\' | '\"' | '\\n' )
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
            	    break loop17;
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
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:8: ( T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | PIPE | COLON | SEMICOLON | NL | WS | BOOL | OBJECT | FIRST_UPPERCASE_NAME | FIRST_LOWERCASE_NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt18=60;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:10: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:16: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:22: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:28: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:34: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:40: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:46: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:52: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:58: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:64: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:70: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:76: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:82: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:88: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:94: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:100: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:106: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:112: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:118: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:124: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:130: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:136: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:142: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:148: T__63
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:154: T__64
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:160: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:166: T__66
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:172: T__67
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:178: T__68
                {
                mT__68(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:184: T__69
                {
                mT__69(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:190: T__70
                {
                mT__70(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:196: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:204: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:223: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:232: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:241: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:247: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:253: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:260: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:267: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:274: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:281: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:288: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:301: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:308: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:312: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 47 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:317: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 48 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:322: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 49 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:328: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 50 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:338: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 51 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:341: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 52 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:344: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 53 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:349: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 54 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:356: FIRST_UPPERCASE_NAME
                {
                mFIRST_UPPERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 55 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:377: FIRST_LOWERCASE_NAME
                {
                mFIRST_LOWERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 56 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:398: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 57 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:405: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 58 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:409: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 59 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:422: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 60 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:427: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_FinexClass
    public final void synpred1_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1450:9: ( INT '..' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1450:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_FinexClass

    // $ANTLR start synpred2_FinexClass
    public final void synpred2_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:7: ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:9: INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME )
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:17: ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME )
        int alt19=2;
        int LA19_0 = input.LA(1);

        if ( (LA19_0=='_'||(LA19_0>='a' && LA19_0<='z')||(LA19_0>='\u00DE' && LA19_0<='\u00F6')||(LA19_0>='\u00F8' && LA19_0<='\u00FF')) ) {
            alt19=1;
        }
        else if ( ((LA19_0>='A' && LA19_0<='Z')||(LA19_0>='\u00C0' && LA19_0<='\u00D6')||(LA19_0>='\u00D8' && LA19_0<='\u00DD')) ) {
            alt19=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 19, 0, input);

            throw nvae;
        }
        switch (alt19) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:18: FIRST_LOWERCASE_NAME
                {
                mFIRST_LOWERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1451:41: FIRST_UPPERCASE_NAME
                {
                mFIRST_UPPERCASE_NAME(); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred2_FinexClass

    // $ANTLR start synpred3_FinexClass
    public final void synpred3_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1452:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1452:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred3_FinexClass

    // $ANTLR start synpred4_FinexClass
    public final void synpred4_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:15: ( ( ',' | '.' ) DIGIT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1465:17: ( ',' | '.' ) DIGIT
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
    // $ANTLR end synpred4_FinexClass

    public final boolean synpred3_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\2\46\3\45\2\46\1\45\1\uffff\1\45\1\uffff\1\46\1\uffff"+
        "\1\74\1\uffff\1\76\1\100\1\uffff\5\46\6\uffff\1\113\1\115\1\117"+
        "\6\uffff\2\121\1\uffff\2\46\1\126\1\uffff\1\45\1\130\2\45\4\46\1"+
        "\140\1\45\1\142\1\46\7\uffff\11\46\10\uffff\1\121\1\uffff\2\46\1"+
        "\uffff\1\45\1\uffff\1\161\1\162\3\46\1\166\1\167\1\uffff\1\170\1"+
        "\uffff\1\171\1\172\1\173\1\174\3\46\1\u0080\2\46\1\121\2\46\1\45"+
        "\2\uffff\3\46\7\uffff\3\46\1\uffff\1\u008d\1\u008e\1\121\1\u0091"+
        "\1\46\1\45\1\46\1\u008e\1\46\1\u0096\2\46\3\uffff\1\121\1\uffff"+
        "\1\46\1\45\2\46\1\uffff\1\u009d\1\u009e\1\46\1\u00a0\2\46\2\uffff"+
        "\1\u00a3\1\uffff\1\u00a4\1\46\2\uffff\2\46\1\u00a8\1\uffff";
    static final String DFA18_eofS =
        "\u00a9\uffff";
    static final String DFA18_minS =
        "\1\11\1\141\1\72\1\105\1\116\1\105\2\141\1\116\1\uffff\1\122\1"+
        "\uffff\1\157\1\uffff\1\52\1\uffff\2\75\1\uffff\1\156\2\157\1\151"+
        "\1\150\6\uffff\2\75\1\56\6\uffff\2\56\1\uffff\1\154\1\160\1\60\1"+
        "\uffff\1\106\1\60\1\104\1\131\1\156\1\154\2\156\1\60\1\124\1\60"+
        "\1\164\7\uffff\1\144\1\147\1\162\1\165\1\145\1\156\1\155\1\151\1"+
        "\165\10\uffff\1\56\1\uffff\1\165\1\157\1\uffff\1\101\1\uffff\2\60"+
        "\1\143\1\163\1\151\2\60\1\uffff\1\60\1\uffff\4\60\1\156\1\141\1"+
        "\147\1\60\1\163\1\145\1\56\1\145\1\163\1\125\2\uffff\1\164\1\145"+
        "\1\160\7\uffff\2\164\1\154\1\uffff\2\60\1\55\1\60\1\151\1\114\1"+
        "\151\1\60\1\165\1\60\2\145\3\uffff\1\56\1\uffff\1\164\1\124\1\157"+
        "\1\154\1\uffff\2\60\1\145\1\60\1\156\1\141\2\uffff\1\60\1\uffff"+
        "\1\60\1\164\2\uffff\1\157\1\162\1\60\1\uffff";
    static final String DFA18_maxS =
        "\1\u00ff\1\141\1\162\1\105\1\123\1\105\1\165\1\151\1\116\1\uffff"+
        "\1\125\1\uffff\1\157\1\uffff\1\57\1\uffff\2\75\1\uffff\1\166\1\157"+
        "\1\162\1\165\1\162\6\uffff\2\75\1\56\6\uffff\1\170\1\71\1\uffff"+
        "\1\154\1\160\1\u00ff\1\uffff\1\106\1\u00ff\1\104\1\131\1\156\1\154"+
        "\1\170\1\156\1\u00ff\1\124\1\u00ff\1\164\7\uffff\1\144\1\147\1\162"+
        "\1\165\1\145\1\156\1\155\1\151\1\165\10\uffff\1\71\1\uffff\1\165"+
        "\1\157\1\uffff\1\101\1\uffff\2\u00ff\1\143\1\163\1\151\2\u00ff\1"+
        "\uffff\1\u00ff\1\uffff\4\u00ff\1\156\1\141\1\147\1\u00ff\1\163\1"+
        "\145\1\71\1\145\1\163\1\125\2\uffff\1\164\1\145\1\160\7\uffff\2"+
        "\164\1\154\1\uffff\2\u00ff\1\71\1\u00ff\1\151\1\114\1\151\1\u00ff"+
        "\1\165\1\u00ff\2\145\3\uffff\1\71\1\uffff\1\164\1\124\1\157\1\154"+
        "\1\uffff\2\u00ff\1\145\1\u00ff\1\156\1\141\2\uffff\1\u00ff\1\uffff"+
        "\1\u00ff\1\164\2\uffff\1\157\1\162\1\u00ff\1\uffff";
    static final String DFA18_acceptS =
        "\11\uffff\1\11\1\uffff\1\13\1\uffff\1\15\1\uffff\1\21\2\uffff\1"+
        "\24\5\uffff\1\42\1\43\1\44\1\45\1\50\1\51\3\uffff\1\57\1\61\1\62"+
        "\1\63\1\66\1\67\2\uffff\1\74\3\uffff\1\65\14\uffff\1\40\1\41\1\16"+
        "\1\22\1\47\1\23\1\46\11\uffff\1\53\1\52\1\54\1\60\1\56\1\55\1\70"+
        "\1\71\1\uffff\1\72\2\uffff\1\26\1\uffff\1\4\7\uffff\1\10\1\uffff"+
        "\1\20\16\uffff\1\17\1\5\3\uffff\1\35\1\34\1\12\1\14\1\25\1\33\1"+
        "\27\3\uffff\1\32\14\uffff\1\37\1\64\1\73\1\uffff\1\1\4\uffff\1\30"+
        "\6\uffff\1\36\1\31\1\uffff\1\3\2\uffff\1\2\1\6\3\uffff\1\7";
    static final String DFA18_specialS =
        "\u00a9\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\44\1\43\2\uffff\1\43\22\uffff\1\44\1\22\1\51\5\uffff\1\34"+
            "\1\35\1\15\1\17\1\11\1\13\1\40\1\16\1\47\11\50\1\37\1\42\1\21"+
            "\1\36\1\20\2\uffff\1\4\2\45\1\3\4\45\1\10\1\45\1\5\3\45\1\12"+
            "\13\45\1\30\1\uffff\1\31\1\uffff\1\46\1\uffff\1\23\1\46\1\25"+
            "\2\46\1\6\6\46\1\7\1\14\1\2\3\46\1\26\1\27\1\46\1\1\1\46\1\24"+
            "\2\46\1\32\1\41\1\33\102\uffff\27\45\1\uffff\6\45\31\46\1\uffff"+
            "\10\46",
            "\1\52",
            "\1\55\65\uffff\1\53\1\uffff\1\54",
            "\1\56",
            "\1\60\4\uffff\1\57",
            "\1\61",
            "\1\63\23\uffff\1\62",
            "\1\64\7\uffff\1\65",
            "\1\66",
            "",
            "\1\70\2\uffff\1\67",
            "",
            "\1\71",
            "",
            "\1\73\4\uffff\1\72",
            "",
            "\1\75",
            "\1\77",
            "",
            "\1\101\7\uffff\1\102",
            "\1\103",
            "\1\104\2\uffff\1\105",
            "\1\106\13\uffff\1\107",
            "\1\110\11\uffff\1\111",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\112",
            "\1\114",
            "\1\116",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123\1\uffff\12\122\76\uffff\1\120",
            "\1\123\1\uffff\12\122",
            "",
            "\1\124",
            "\1\125",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "\1\127",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135\11\uffff\1\136",
            "\1\137",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\141",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\143",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123\1\uffff\12\155",
            "",
            "\1\156",
            "\1\157",
            "",
            "\1\160",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\163",
            "\1\164",
            "\1\165",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\175",
            "\1\176",
            "\1\177",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0081",
            "\1\u0082",
            "\1\123\1\uffff\12\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u008f\1\123\1\uffff\12\u0090",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0095",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "",
            "\1\123\1\uffff\12\u0090",
            "",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u009f",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00a5",
            "",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff"+
            "\27\46\1\uffff\37\46\1\uffff\10\46",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | PIPE | COLON | SEMICOLON | NL | WS | BOOL | OBJECT | FIRST_UPPERCASE_NAME | FIRST_LOWERCASE_NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}