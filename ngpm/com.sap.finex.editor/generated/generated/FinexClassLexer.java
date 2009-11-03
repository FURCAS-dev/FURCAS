// $ANTLR 3.1.1 C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-10-27 16:44:11

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
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LANGLE=25;
    public static final int FLOAT=8;
    public static final int EQUALS=23;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int LBRACKET=14;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=20;
    public static final int T__57=57;
    public static final int NAME=40;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=38;
    public static final int T__59=59;
    public static final int PIPE=29;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int RANGE_OR_INT=39;
    public static final int RANGLE=24;
    public static final int RBRACKET=15;
    public static final int COMMENT=26;
    public static final int DOT=16;
    public static final int T__50=50;
    public static final int FIRST_LOWERCASE_SNAME=36;
    public static final int T__42=42;
    public static final int LOWERCASE_ALPHA=33;
    public static final int EQUALSEQUALS=28;
    public static final int T__43=43;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=17;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=9;
    public static final int SEMICOLON=13;
    public static final int INT=7;
    public static final int UPPERCASE_ALPHA=34;
    public static final int MULTI_LINE_COMMENT=27;
    public static final int ALPHA=35;
    public static final int COLON=12;
    public static final int LCURL=21;
    public static final int WS=31;
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
    public String getGrammarFileName() { return "C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g"; }

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:117:7: ( 'opposite' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:117:9: 'opposite'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:118:7: ( 'DEFAULT' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:118:9: 'DEFAULT'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:119:7: ( 'AS' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:119:9: 'AS'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:120:7: ( 'KEY' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:120:9: 'KEY'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:121:7: ( 'function' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:121:9: 'function'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:122:7: ( 'IN' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:122:9: 'IN'
            {
            match("IN"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:123:7: ( ',' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:123:9: ','
            {
            match(','); if (state.failed) return ;

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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:124:7: ( 'OUT' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:124:9: 'OUT'
            {
            match("OUT"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:125:7: ( '-' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:125:9: '-'
            {
            match('-'); if (state.failed) return ;

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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:126:7: ( 'not' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:126:9: 'not'
            {
            match("not"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:127:7: ( '*' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:127:9: '*'
            {
            match('*'); if (state.failed) return ;

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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:128:7: ( '/' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:128:9: '/'
            {
            match('/'); if (state.failed) return ;

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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:129:7: ( 'AND' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:129:9: 'AND'
            {
            match("AND"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:130:7: ( 'OR' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:130:9: 'OR'
            {
            match("OR"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:131:7: ( '+' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:131:9: '+'
            {
            match('+'); if (state.failed) return ;

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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:132:7: ( '>=' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:132:9: '>='
            {
            match(">="); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:133:7: ( '<=' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:133:9: '<='
            {
            match("<="); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:134:7: ( '!=' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:134:9: '!='
            {
            match("!="); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:135:7: ( 'and' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:135:9: 'and'
            {
            match("and"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:136:7: ( 'or' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:136:9: 'or'
            {
            match("or"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:137:7: ( 'xor' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:137:9: 'xor'
            {
            match("xor"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:138:7: ( 'count' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:138:9: 'count'
            {
            match("count"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:139:7: ( 'single' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:139:9: 'single'
            {
            match("single"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:140:7: ( 'sum' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:140:9: 'sum'
            {
            match("sum"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:141:7: ( 'avg' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:141:9: 'avg'
            {
            match("avg"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:142:7: ( 'min' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:142:9: 'min'
            {
            match("min"); if (state.failed) return ;


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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:143:7: ( 'max' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:143:9: 'max'
            {
            match("max"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:15: ~ ( '\\r' | '\\n' )
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:983:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:43: ( '\\n' | ~ '\\n' )
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:989:3: ( '[' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:990:3: '['
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:995:3: ( ']' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:996:3: ']'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1001:3: ( '{' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1002:3: '{'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:3: ( '}' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:3: '}'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1013:3: ( '<' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1014:3: '<'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1019:3: ( '>' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1020:3: '>'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1025:3: ( '(' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:3: '('
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1031:3: ( ')' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1032:3: ')'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:3: ( '=' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:3: '='
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1043:3: ( '==' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1044:3: '=='
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1049:3: ( ':=' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1050:3: ':='
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1055:3: ( '.' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1056:3: '.'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1061:3: ( '..' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1062:3: '..'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:3: ( '|' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:3: '|'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:3: ( ':' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:3: ':'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1079:3: ( ';' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1080:3: ';'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1091:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1092:5: '\\n'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1098:2: ( ( ' ' | '\\t' ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1098:4: ( ' ' | '\\t' )
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:2: ( '0' .. '9' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:4: '0' .. '9'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1110:2: ( LOWERCASE_ALPHA | UPPERCASE_ALPHA )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1115:2: ( 'a' .. 'z' | '_' | '\\u00DE' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1124:2: ( 'A' .. 'Z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DD' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1132:2: ( ( LOWERCASE_ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1132:4: ( LOWERCASE_ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1132:4: ( LOWERCASE_ALPHA )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1132:5: LOWERCASE_ALPHA
            {
            mLOWERCASE_ALPHA(); if (state.failed) return ;

            }

            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1132:22: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:2: ( ( UPPERCASE_ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:4: ( UPPERCASE_ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:4: ( UPPERCASE_ALPHA )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:5: UPPERCASE_ALPHA
            {
            mUPPERCASE_ALPHA(); if (state.failed) return ;

            }

            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:22: ( ALPHA | DIGIT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1140:6: ( 'true' | 'false' )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1140:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1140:17: 'false'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1142:8: ( 'o:' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1142:10: 'o:'
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1145:2: ( FIRST_UPPERCASE_SNAME )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1145:4: FIRST_UPPERCASE_SNAME
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:2: ( FIRST_LOWERCASE_SNAME )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:4: FIRST_LOWERCASE_SNAME
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1158:2: ( ( DIGIT )+ )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1158:4: ( DIGIT )+
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1158:4: ( DIGIT )+
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1158:5: DIGIT
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:4: ( DIGIT )+
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:4: DIGIT
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:15: ( DIGIT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1163:15: DIGIT
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:5: ( ( INT '..' )=> INT | ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:7: ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1169:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:9: INT
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==' '||LA16_0=='T') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==','||LA13_0=='.') && (synpred4_FinexClass())) {
                        alt13=1;
                    }
                    else {
                        alt13=2;}
                    switch (alt13) {
                        case 1 :
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:41: ( ',' | '.' ) ( DIGIT )+
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

                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:53: ( DIGIT )+
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
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:54: DIGIT
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1184:13: 
                            {
                            }
                            break;

                    }

                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1185:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='Z') ) {
                        alt15=1;
                    }
                    else {
                        alt15=2;}
                    switch (alt15) {
                        case 1 :
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1185:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1185:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1185:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( (LA14_0=='+'||LA14_0=='-') ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1185:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1191:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1192:5: ~ ( '\\\\' | '\"' | '\\n' )
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:8: ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | PIPE | COLON | SEMICOLON | NL | WS | BOOL | OBJECT | FIRST_UPPERCASE_NAME | FIRST_LOWERCASE_NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt18=56;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:10: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:16: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:22: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:28: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:34: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:40: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:46: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:52: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:58: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:64: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:70: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:76: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:82: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:88: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:94: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:100: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:106: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:112: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:118: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:124: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:130: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:136: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:142: T__63
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:148: T__64
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:154: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:160: T__66
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:166: T__67
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:172: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:180: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:199: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:208: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:217: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:223: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:229: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:236: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:243: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:250: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:257: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:264: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:277: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:284: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:288: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:293: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:298: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:304: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:314: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 47 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:317: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 48 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:320: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 49 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:325: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 50 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:332: FIRST_UPPERCASE_NAME
                {
                mFIRST_UPPERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 51 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:353: FIRST_LOWERCASE_NAME
                {
                mFIRST_LOWERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 52 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:374: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 53 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:381: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 54 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:385: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 55 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:398: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 56 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1:403: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_FinexClass
    public final void synpred1_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:9: ( INT '..' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_FinexClass

    // $ANTLR start synpred2_FinexClass
    public final void synpred2_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:7: ( INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:9: INT '.' ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME )
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:17: ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME )
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
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:18: FIRST_LOWERCASE_NAME
                {
                mFIRST_LOWERCASE_NAME(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:41: FIRST_UPPERCASE_NAME
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1169:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1169:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:15: ( ( ',' | '.' ) DIGIT )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:17: ( ',' | '.' ) DIGIT
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
        "\1\uffff\1\45\3\44\1\45\1\44\1\uffff\1\44\1\uffff\1\45\1\uffff\1"+
        "\70\1\uffff\1\72\1\74\1\uffff\5\45\6\uffff\1\106\1\110\1\112\4\uffff"+
        "\1\45\2\uffff\2\115\1\uffff\1\45\1\121\1\uffff\1\44\1\123\2\44\2"+
        "\45\1\130\1\44\1\132\1\45\7\uffff\10\45\6\uffff\1\45\2\uffff\1\115"+
        "\1\uffff\1\45\1\uffff\1\44\1\uffff\1\150\1\151\2\45\1\uffff\1\154"+
        "\1\uffff\1\155\1\156\1\157\1\160\2\45\1\163\1\164\1\165\1\45\1\115"+
        "\1\45\1\44\2\uffff\2\45\5\uffff\2\45\3\uffff\1\176\1\115\1\45\1"+
        "\44\1\45\1\176\1\u0084\1\45\2\uffff\1\115\1\45\1\44\1\45\1\uffff"+
        "\1\u0089\1\45\1\u008b\1\45\1\uffff\1\u008d\1\uffff\1\u008e\2\uffff";
    static final String DFA18_eofS =
        "\u008f\uffff";
    static final String DFA18_minS =
        "\1\11\1\72\1\105\1\116\1\105\1\141\1\116\1\uffff\1\122\1\uffff\1"+
        "\157\1\uffff\1\52\1\uffff\2\75\1\uffff\1\156\2\157\1\151\1\141\6"+
        "\uffff\2\75\1\56\4\uffff\1\162\2\uffff\2\56\1\uffff\1\160\1\60\1"+
        "\uffff\1\106\1\60\1\104\1\131\1\156\1\154\1\60\1\124\1\60\1\164"+
        "\7\uffff\1\144\1\147\1\162\1\165\1\156\1\155\1\156\1\170\6\uffff"+
        "\1\165\2\uffff\1\56\1\uffff\1\157\1\uffff\1\101\1\uffff\2\60\1\143"+
        "\1\163\1\uffff\1\60\1\uffff\4\60\1\156\1\147\3\60\1\145\1\56\1\163"+
        "\1\125\2\uffff\1\164\1\145\5\uffff\1\164\1\154\3\uffff\1\60\1\55"+
        "\1\151\1\114\1\151\2\60\1\145\2\uffff\1\56\1\164\1\124\1\157\1\uffff"+
        "\1\60\1\145\1\60\1\156\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA18_maxS =
        "\1\u00ff\1\162\1\105\1\123\1\105\1\165\1\116\1\uffff\1\125\1\uffff"+
        "\1\157\1\uffff\1\57\1\uffff\2\75\1\uffff\1\166\2\157\1\165\1\151"+
        "\6\uffff\2\75\1\56\4\uffff\1\162\2\uffff\1\170\1\71\1\uffff\1\160"+
        "\1\u00ff\1\uffff\1\106\1\u00ff\1\104\1\131\1\156\1\154\1\u00ff\1"+
        "\124\1\u00ff\1\164\7\uffff\1\144\1\147\1\162\1\165\1\156\1\155\1"+
        "\156\1\170\6\uffff\1\165\2\uffff\1\71\1\uffff\1\157\1\uffff\1\101"+
        "\1\uffff\2\u00ff\1\143\1\163\1\uffff\1\u00ff\1\uffff\4\u00ff\1\156"+
        "\1\147\3\u00ff\1\145\1\71\1\163\1\125\2\uffff\1\164\1\145\5\uffff"+
        "\1\164\1\154\3\uffff\1\u00ff\1\71\1\151\1\114\1\151\2\u00ff\1\145"+
        "\2\uffff\1\71\1\164\1\124\1\157\1\uffff\1\u00ff\1\145\1\u00ff\1"+
        "\156\1\uffff\1\u00ff\1\uffff\1\u00ff\2\uffff";
    static final String DFA18_acceptS =
        "\7\uffff\1\7\1\uffff\1\11\1\uffff\1\13\1\uffff\1\17\2\uffff\1\22"+
        "\5\uffff\1\36\1\37\1\40\1\41\1\44\1\45\3\uffff\1\53\1\55\1\56\1"+
        "\57\1\uffff\1\62\1\63\2\uffff\1\70\2\uffff\1\61\12\uffff\1\34\1"+
        "\35\1\14\1\20\1\43\1\21\1\42\10\uffff\1\47\1\46\1\50\1\54\1\52\1"+
        "\51\1\uffff\1\64\1\65\1\uffff\1\66\1\uffff\1\24\1\uffff\1\3\4\uffff"+
        "\1\6\1\uffff\1\16\15\uffff\1\15\1\4\2\uffff\1\10\1\12\1\23\1\31"+
        "\1\25\2\uffff\1\30\1\32\1\33\10\uffff\1\60\1\67\4\uffff\1\26\4\uffff"+
        "\1\27\1\uffff\1\2\1\uffff\1\1\1\5";
    static final String DFA18_specialS =
        "\u008f\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\42\1\41\2\uffff\1\41\22\uffff\1\42\1\20\1\50\5\uffff\1\32"+
            "\1\33\1\13\1\15\1\7\1\11\1\36\1\14\1\46\11\47\1\35\1\40\1\17"+
            "\1\34\1\16\2\uffff\1\3\2\44\1\2\4\44\1\6\1\44\1\4\3\44\1\10"+
            "\13\44\1\26\1\uffff\1\27\1\uffff\1\45\1\uffff\1\21\1\45\1\23"+
            "\2\45\1\5\6\45\1\25\1\12\1\1\3\45\1\24\1\43\3\45\1\22\2\45\1"+
            "\30\1\37\1\31\102\uffff\27\44\1\uffff\6\44\31\45\1\uffff\10"+
            "\45",
            "\1\53\65\uffff\1\51\1\uffff\1\52",
            "\1\54",
            "\1\56\4\uffff\1\55",
            "\1\57",
            "\1\61\23\uffff\1\60",
            "\1\62",
            "",
            "\1\64\2\uffff\1\63",
            "",
            "\1\65",
            "",
            "\1\67\4\uffff\1\66",
            "",
            "\1\71",
            "\1\73",
            "",
            "\1\75\7\uffff\1\76",
            "\1\77",
            "\1\100",
            "\1\101\13\uffff\1\102",
            "\1\104\7\uffff\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "\1\107",
            "\1\111",
            "",
            "",
            "",
            "",
            "\1\113",
            "",
            "",
            "\1\117\1\uffff\12\116\76\uffff\1\114",
            "\1\117\1\uffff\12\116",
            "",
            "\1\120",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\1\122",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\1\131",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\1\133",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\144",
            "",
            "",
            "\1\117\1\uffff\12\145",
            "",
            "\1\146",
            "",
            "\1\147",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\1\152",
            "\1\153",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\1\161",
            "\1\162",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\1\166",
            "\1\117\1\uffff\12\167",
            "\1\170",
            "\1\171",
            "",
            "",
            "\1\172",
            "\1\173",
            "",
            "",
            "",
            "",
            "",
            "\1\174",
            "\1\175",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\1\177\1\117\1\uffff\12\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u0085",
            "",
            "",
            "\1\117\1\uffff\12\u0080",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u008a",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44\105\uffff\27"+
            "\44\1\uffff\37\44\1\uffff\10\44",
            "\1\u008c",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff\27"+
            "\45\1\uffff\37\45\1\uffff\10\45",
            "",
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
            return "1:1: Tokens : ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | PIPE | COLON | SEMICOLON | NL | WS | BOOL | OBJECT | FIRST_UPPERCASE_NAME | FIRST_LOWERCASE_NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}