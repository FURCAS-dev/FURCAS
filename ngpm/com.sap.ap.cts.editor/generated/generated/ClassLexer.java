// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g 2009-11-27 18:50:14

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
public class ClassLexer extends Lexer {
    public static final int EXCLUDINGAT=41;
    public static final int STAR=31;
    public static final int LANGLE=14;
    public static final int EQUALS=20;
    public static final int EXCL=38;
    public static final int INCLUDINGAT=40;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int LBRACKET=24;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int RPAREN=19;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int DCOLON=22;
    public static final int T__90=90;
    public static final int LBRACK_LCURL=32;
    public static final int NL=42;
    public static final int RANGLE=15;
    public static final int COMMENT=36;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int LCURL_LBRACK=34;
    public static final int T__80=80;
    public static final int DDOT=30;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int BOOL=8;
    public static final int SEMICOLON=17;
    public static final int INT=6;
    public static final int T__85=85;
    public static final int EXCLUDING=28;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int ALPHA=45;
    public static final int WS=43;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int SNAME=46;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RBRACK_RCURL=35;
    public static final int FLOAT=7;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=47;
    public static final int T__59=59;
    public static final int PIPE=11;
    public static final int DIGIT=44;
    public static final int RANGE_OR_INT=48;
    public static final int RBRACKET=26;
    public static final int DOT=21;
    public static final int T__50=50;
    public static final int EQUALSEQUALS=25;
    public static final int RCURL_RBRACK=33;
    public static final int T__49=49;
    public static final int MULTI_LINE_COMMENT=37;
    public static final int COLON=16;
    public static final int ITERATE=29;
    public static final int LCURL=12;
    public static final int RCURL=13;
    public static final int ASSIGN=39;
    public static final int ARROW=23;
    public static final int BINARY=9;
    public static final int DATE=10;
    public static final int INCLUDING=27;
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

    public ClassLexer() {;} 
    public ClassLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ClassLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g"; }

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:7: ( 'converter' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:9: 'converter'
            {
            match("converter"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:7: ( 'aggregate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:9: 'aggregate'
            {
            match("aggregate"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:7: ( '+=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:9: '+='
            {
            match("+="); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:7: ( 'foreach' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:9: 'foreach'
            {
            match("foreach"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:7: ( 'void' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:9: 'void'
            {
            match("void"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:7: ( 'if' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:9: 'if'
            {
            match("if"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:7: ( 'commit' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:9: 'commit'
            {
            match("commit"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:7: ( '<=>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:9: '<=>'
            {
            match("<=>"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:7: ( 'function' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:9: 'function'
            {
            match("function"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:7: ( 'by' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:9: 'by'
            {
            match("by"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:7: ( 'new' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:9: 'new'
            {
            match("new"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:7: ( 'delete' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:9: 'delete'
            {
            match("delete"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:7: ( 'implements' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:9: 'implements'
            {
            match("implements"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:7: ( 'key' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:9: 'key'
            {
            match("key"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:7: ( 'NULL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:9: 'NULL'
            {
            match("NULL"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:7: ( 'all' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:9: 'all'
            {
            match("all"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:7: ( 'AddLink' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:9: 'AddLink'
            {
            match("AddLink"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:7: ( 'RemoveLink' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:9: 'RemoveLink'
            {
            match("RemoveLink"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:7: ( 'value' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:9: 'value'
            {
            match("value"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:7: ( 'const' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:9: 'const'
            {
            match("const"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:7: ( 'replace' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:9: 'replace'
            {
            match("replace"); if (state.failed) return ;


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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:7: ( 'head' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:9: 'head'
            {
            match("head"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:7: ( 'count' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:9: 'count'
            {
            match("count"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:7: ( 'store' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:9: 'store'
            {
            match("store"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:7: ( ',' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:7: ( 'native' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:9: 'native'
            {
            match("native"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:7: ( 'return' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:9: 'return'
            {
            match("return"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:7: ( 'snapshot' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:9: 'snapshot'
            {
            match("snapshot"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:7: ( 'rollback' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:9: 'rollback'
            {
            match("rollback"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:7: ( 'dim' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:9: 'dim'
            {
            match("dim"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:7: ( 'owns' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:9: 'owns'
            {
            match("owns"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:7: ( '-=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:9: '-='
            {
            match("-="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:7: ( 'changed' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:9: 'changed'
            {
            match("changed"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:7: ( 'while' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:9: 'while'
            {
            match("while"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:7: ( 'else' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:9: 'else'
            {
            match("else"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:7: ( '$>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:9: '$>'
            {
            match("$>"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:7: ( 'class' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:9: 'class'
            {
            match("class"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:7: ( 'tail' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:9: 'tail'
            {
            match("tail"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:7: ( 'var' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:9: 'var'
            {
            match("var"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:7: ( 'this' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:9: 'this'
            {
            match("this"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:7: ( '?' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:9: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:7: ( '<$' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:9: '<$'
            {
            match("<$"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:7: ( '1000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:9: '1000'
            {
            match("1000"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:7: ( '2000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:9: '2000'
            {
            match("2000"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:7: ( '3000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:9: '3000'
            {
            match("3000"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:7: ( '1002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:9: '1002'
            {
            match("1002"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:7: ( '2002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:9: '2002'
            {
            match("2002"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:164:7: ( '3002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:164:9: '3002'
            {
            match("3002"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2643:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2644:15: ~ ( '\\r' | '\\n' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2649:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2650:43: ( '\\n' | ~ '\\n' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2655:3: ( '[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2656:3: '['
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2661:3: ( ']' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2662:3: ']'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2667:3: ( '{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2668:3: '{'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2673:3: ( '}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2674:3: '}'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2679:3: ( '<' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2680:3: '<'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2685:3: ( '>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2686:3: '>'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2691:3: ( '(' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2692:3: '('
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2697:3: ( ')' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2698:3: ')'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2703:3: ( '!' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2704:3: '!'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2709:3: ( '=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2710:3: '='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2715:3: ( '==' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2716:3: '=='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2721:3: ( ':=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2722:3: ':='
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2727:3: ( '.' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2728:3: '.'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2733:3: ( '..' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2734:3: '..'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2739:3: ( '->' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2740:3: '->'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2745:3: ( '|' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2746:3: '|'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2751:3: ( ':' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2752:3: ':'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2757:3: ( '::' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2758:3: '::'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2763:3: ( ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2764:3: ';'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2769:3: ( 'including' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2770:3: 'including'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2775:3: ( 'excluding' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2776:3: 'excluding'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2781:3: ( 'includingAt' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2782:3: 'includingAt'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2787:3: ( 'excludingAt' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2788:3: 'excludingAt'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2793:3: ( 'iterate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2794:3: 'iterate'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2799:3: ( '{[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2800:3: '{['
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2805:3: ( '[{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2806:3: '[{'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2811:3: ( '}]' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2812:3: '}]'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2817:3: ( ']}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2818:3: ']}'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2823:3: ( '*' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2824:3: '*'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2833:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2833:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2833:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2833:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2834:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2835:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2836:5: '\\n'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2842:2: ( ( ' ' | '\\t' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2842:4: ( ' ' | '\\t' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2849:2: ( '0' .. '9' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2849:4: '0' .. '9'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2854:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:4: ( ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:6: ( 'true' | 'false' )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:17: 'false'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2870:8: ( 'o:' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2870:10: 'o:'
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2873:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2873:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2873:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2874:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2875:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2878:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2879:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2886:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2886:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2886:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2886:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2891:2: ( ( DIGIT )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2891:4: ( DIGIT )+
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2891:4: ( DIGIT )+
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2891:5: DIGIT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:4: ( DIGIT )+
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:4: DIGIT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2896:15: DIGIT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2900:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred3_Class())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred3_Class())) {
                    alt12=3;
                }
                else if ( (synpred1_Class()) ) {
                    alt12=1;
                }
                else if ( (synpred2_Class()) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2900:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2901:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2902:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2909:9: INT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2913:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2913:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2913:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==' '||LA17_0=='T') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2913:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2914:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==','||LA14_0=='.') && (synpred4_Class())) {
                        alt14=1;
                    }
                    else {
                        alt14=2;}
                    switch (alt14) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:41: ( ',' | '.' ) ( DIGIT )+
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

                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:53: ( DIGIT )+
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
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:54: DIGIT
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2917:13: 
                            {
                            }
                            break;

                    }

                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2918:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='Z') ) {
                        alt16=1;
                    }
                    else {
                        alt16=2;}
                    switch (alt16) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2918:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2918:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2918:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2918:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2921:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2921:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2922:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2924:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2925:5: ~ ( '\\\\' | '\"' | '\\n' )
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
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt19=89;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:10: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:16: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 3 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:22: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 4 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:28: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 5 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:34: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 6 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:40: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 7 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:46: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 8 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:52: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 9 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:58: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 10 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:64: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 11 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:70: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 12 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:76: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 13 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:82: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 14 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:88: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 15 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:94: T__63
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 16 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:100: T__64
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 17 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:106: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 18 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:112: T__66
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 19 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:118: T__67
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 20 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:124: T__68
                {
                mT__68(); if (state.failed) return ;

                }
                break;
            case 21 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:130: T__69
                {
                mT__69(); if (state.failed) return ;

                }
                break;
            case 22 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:136: T__70
                {
                mT__70(); if (state.failed) return ;

                }
                break;
            case 23 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:142: T__71
                {
                mT__71(); if (state.failed) return ;

                }
                break;
            case 24 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:148: T__72
                {
                mT__72(); if (state.failed) return ;

                }
                break;
            case 25 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:154: T__73
                {
                mT__73(); if (state.failed) return ;

                }
                break;
            case 26 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:160: T__74
                {
                mT__74(); if (state.failed) return ;

                }
                break;
            case 27 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:166: T__75
                {
                mT__75(); if (state.failed) return ;

                }
                break;
            case 28 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:172: T__76
                {
                mT__76(); if (state.failed) return ;

                }
                break;
            case 29 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:178: T__77
                {
                mT__77(); if (state.failed) return ;

                }
                break;
            case 30 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:184: T__78
                {
                mT__78(); if (state.failed) return ;

                }
                break;
            case 31 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:190: T__79
                {
                mT__79(); if (state.failed) return ;

                }
                break;
            case 32 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:196: T__80
                {
                mT__80(); if (state.failed) return ;

                }
                break;
            case 33 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:202: T__81
                {
                mT__81(); if (state.failed) return ;

                }
                break;
            case 34 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:208: T__82
                {
                mT__82(); if (state.failed) return ;

                }
                break;
            case 35 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:214: T__83
                {
                mT__83(); if (state.failed) return ;

                }
                break;
            case 36 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:220: T__84
                {
                mT__84(); if (state.failed) return ;

                }
                break;
            case 37 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:226: T__85
                {
                mT__85(); if (state.failed) return ;

                }
                break;
            case 38 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:232: T__86
                {
                mT__86(); if (state.failed) return ;

                }
                break;
            case 39 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:238: T__87
                {
                mT__87(); if (state.failed) return ;

                }
                break;
            case 40 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:244: T__88
                {
                mT__88(); if (state.failed) return ;

                }
                break;
            case 41 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:250: T__89
                {
                mT__89(); if (state.failed) return ;

                }
                break;
            case 42 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:256: T__90
                {
                mT__90(); if (state.failed) return ;

                }
                break;
            case 43 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:262: T__91
                {
                mT__91(); if (state.failed) return ;

                }
                break;
            case 44 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:268: T__92
                {
                mT__92(); if (state.failed) return ;

                }
                break;
            case 45 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:274: T__93
                {
                mT__93(); if (state.failed) return ;

                }
                break;
            case 46 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:280: T__94
                {
                mT__94(); if (state.failed) return ;

                }
                break;
            case 47 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:286: T__95
                {
                mT__95(); if (state.failed) return ;

                }
                break;
            case 48 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:292: T__96
                {
                mT__96(); if (state.failed) return ;

                }
                break;
            case 49 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:298: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 50 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:306: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 51 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:325: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 52 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:334: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 53 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:343: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 54 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:349: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 55 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:355: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 56 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:362: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 57 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:369: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 58 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:376: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 59 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:383: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 60 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:388: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 61 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:395: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 62 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:408: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 63 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:415: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 64 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:419: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 65 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:424: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 66 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:430: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 67 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:435: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 68 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:441: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 69 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:448: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 70 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:458: INCLUDING
                {
                mINCLUDING(); if (state.failed) return ;

                }
                break;
            case 71 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:468: EXCLUDING
                {
                mEXCLUDING(); if (state.failed) return ;

                }
                break;
            case 72 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:478: INCLUDINGAT
                {
                mINCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 73 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:490: EXCLUDINGAT
                {
                mEXCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 74 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:502: ITERATE
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 75 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:510: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 76 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:523: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 77 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:536: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 78 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:549: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 79 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:562: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 80 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:567: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 81 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:570: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 82 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:573: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 83 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:578: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 84 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:585: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 85 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:590: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 86 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:597: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 87 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:601: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 88 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:614: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 89 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:619: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Class
    public final void synpred1_Class_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2900:9: ( INT '..' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2900:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_Class

    // $ANTLR start synpred2_Class
    public final void synpred2_Class_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2901:7: ( INT '.' NAME )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2901:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Class

    // $ANTLR start synpred3_Class
    public final void synpred3_Class_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2902:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2902:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred3_Class

    // $ANTLR start synpred4_Class
    public final void synpred4_Class_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:15: ( ( ',' | '.' ) DIGIT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2915:17: ( ',' | '.' ) DIGIT
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
    // $ANTLR end synpred4_Class

    public final boolean synpred3_Class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Class_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Class() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Class_fragment(); // can never throw exception
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
        "\1\uffff\2\56\1\uffff\3\56\1\102\12\56\1\uffff\1\56\1\uffff\2\56"+
        "\1\uffff\1\56\1\uffff\3\134\1\uffff\1\144\1\146\1\150\1\152\4\uffff"+
        "\1\154\1\157\1\161\6\uffff\2\134\1\uffff\12\56\1\u0080\3\56\3\uffff"+
        "\1\u0084\16\56\3\uffff\6\56\1\134\1\uffff\1\134\1\uffff\2\134\22"+
        "\uffff\6\56\1\u00a5\5\56\1\u00ab\1\uffff\3\56\1\uffff\1\u00af\2"+
        "\56\1\u00b2\1\u00b3\20\56\4\134\7\56\1\uffff\3\56\1\u00d5\1\56\1"+
        "\uffff\3\56\1\uffff\2\56\2\uffff\1\u00dc\5\56\1\u00e2\2\56\1\u00e5"+
        "\1\56\1\u00e7\1\56\1\u00e9\1\u00ea\1\u00eb\1\u00ec\1\u00ef\1\134"+
        "\1\u00f0\1\u00f1\1\u00f2\1\u00f3\1\56\1\u00f5\1\56\1\u00f7\1\56"+
        "\1\u00f9\3\56\1\u00eb\1\uffff\1\u00fd\5\56\1\uffff\5\56\1\uffff"+
        "\1\u0108\1\56\1\uffff\1\u010a\1\uffff\1\56\5\uffff\1\134\5\uffff"+
        "\1\56\1\uffff\1\u010d\1\uffff\1\56\1\uffff\3\56\1\uffff\3\56\1\u0115"+
        "\1\u0116\3\56\1\u011a\1\56\1\uffff\1\56\1\uffff\2\56\1\uffff\1\u011f"+
        "\1\56\1\u0121\3\56\1\u0125\2\uffff\1\u0126\1\56\1\u0128\1\uffff"+
        "\4\56\1\uffff\1\56\1\uffff\1\u012e\2\56\2\uffff\1\56\1\uffff\1\u0132"+
        "\1\u0133\1\56\1\u0135\1\u0136\1\uffff\1\56\1\u0139\1\56\2\uffff"+
        "\1\u013c\2\uffff\1\u013d\1\56\1\uffff\1\u013f\1\56\2\uffff\1\u0141"+
        "\1\uffff\1\u0142\2\uffff";
    static final String DFA19_eofS =
        "\u0143\uffff";
    static final String DFA19_minS =
        "\1\11\1\150\1\147\1\uffff\2\141\1\146\1\44\1\171\1\141\2\145\1"+
        "\125\1\144\3\145\1\156\1\uffff\1\72\1\75\1\150\1\154\1\uffff\1\141"+
        "\1\uffff\3\56\1\52\1\173\1\175\1\133\1\135\4\uffff\1\75\1\72\1\56"+
        "\6\uffff\2\56\1\uffff\1\155\2\141\1\147\1\154\1\162\1\156\1\154"+
        "\1\151\1\154\1\60\1\160\1\143\1\145\3\uffff\1\60\1\167\1\164\1\154"+
        "\1\155\1\171\1\114\1\144\1\155\1\160\1\154\1\141\1\157\1\141\1\156"+
        "\3\uffff\1\151\1\163\1\143\2\151\1\165\1\56\1\uffff\1\56\1\uffff"+
        "\2\56\22\uffff\1\163\1\155\2\156\1\163\1\162\1\60\1\145\1\143\1"+
        "\163\1\144\1\165\1\60\1\uffff\2\154\1\162\1\uffff\1\60\1\151\1\145"+
        "\2\60\2\114\1\157\1\154\1\165\1\154\1\144\1\162\1\160\1\163\1\154"+
        "\1\145\2\154\1\163\1\145\4\56\1\145\1\164\1\151\1\164\1\147\1\163"+
        "\1\145\1\uffff\1\141\1\164\1\145\1\60\1\145\1\uffff\1\145\1\165"+
        "\1\141\1\uffff\1\166\1\164\2\uffff\1\60\1\151\1\166\1\141\1\162"+
        "\1\142\1\60\1\145\1\163\1\60\1\145\1\60\1\165\3\60\7\55\1\162\1"+
        "\60\1\164\1\60\1\145\1\60\1\147\1\143\1\151\1\60\1\uffff\1\60\1"+
        "\155\1\144\1\164\2\145\1\uffff\1\156\1\145\1\143\1\156\1\141\1\uffff"+
        "\1\60\1\150\1\uffff\1\60\1\uffff\1\144\5\uffff\1\56\5\uffff\1\164"+
        "\1\uffff\1\60\1\uffff\1\144\1\uffff\1\141\1\150\1\157\1\uffff\1"+
        "\145\1\151\1\145\2\60\1\153\1\114\1\145\1\60\1\143\1\uffff\1\157"+
        "\1\uffff\1\151\1\145\1\uffff\1\60\1\164\1\60\3\156\1\60\2\uffff"+
        "\1\60\1\151\1\60\1\uffff\1\153\1\164\1\156\1\162\1\uffff\1\145\1"+
        "\uffff\1\60\1\164\1\147\2\uffff\1\156\1\uffff\2\60\1\147\2\60\1"+
        "\uffff\1\163\1\60\1\153\2\uffff\1\60\2\uffff\1\60\1\164\1\uffff"+
        "\1\60\1\164\2\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA19_maxS =
        "\1\u00ff\1\157\1\154\1\uffff\1\165\1\157\1\164\1\75\1\171\1\145"+
        "\1\151\1\145\1\125\1\144\1\145\1\157\1\145\1\164\1\uffff\1\167\1"+
        "\76\1\150\1\170\1\uffff\1\162\1\uffff\3\71\1\57\1\173\1\175\1\133"+
        "\1\135\4\uffff\2\75\1\56\6\uffff\1\170\1\71\1\uffff\1\165\2\141"+
        "\1\147\1\154\1\162\1\156\1\154\1\151\1\162\1\u00ff\1\160\1\143\1"+
        "\145\3\uffff\1\u00ff\1\167\1\164\1\154\1\155\1\171\1\114\1\144\1"+
        "\155\1\164\1\154\1\141\1\157\1\141\1\156\3\uffff\1\151\1\163\1\143"+
        "\2\151\1\165\1\71\1\uffff\1\71\1\uffff\2\71\22\uffff\1\166\1\155"+
        "\2\156\1\163\1\162\1\u00ff\1\145\1\143\1\163\1\144\1\165\1\u00ff"+
        "\1\uffff\2\154\1\162\1\uffff\1\u00ff\1\151\1\145\2\u00ff\2\114\1"+
        "\157\1\154\1\165\1\154\1\144\1\162\1\160\1\163\1\154\1\145\2\154"+
        "\1\163\1\145\4\71\1\145\1\164\1\151\1\164\1\147\1\163\1\145\1\uffff"+
        "\1\141\1\164\1\145\1\u00ff\1\145\1\uffff\1\145\1\165\1\141\1\uffff"+
        "\1\166\1\164\2\uffff\1\u00ff\1\151\1\166\1\141\1\162\1\142\1\u00ff"+
        "\1\145\1\163\1\u00ff\1\145\1\u00ff\1\165\3\u00ff\7\71\1\162\1\u00ff"+
        "\1\164\1\u00ff\1\145\1\u00ff\1\147\1\143\1\151\1\u00ff\1\uffff\1"+
        "\u00ff\1\155\1\144\1\164\2\145\1\uffff\1\156\1\145\1\143\1\156\1"+
        "\141\1\uffff\1\u00ff\1\150\1\uffff\1\u00ff\1\uffff\1\144\5\uffff"+
        "\1\71\5\uffff\1\164\1\uffff\1\u00ff\1\uffff\1\144\1\uffff\1\141"+
        "\1\150\1\157\1\uffff\1\145\1\151\1\145\2\u00ff\1\153\1\114\1\145"+
        "\1\u00ff\1\143\1\uffff\1\157\1\uffff\1\151\1\145\1\uffff\1\u00ff"+
        "\1\164\1\u00ff\3\156\1\u00ff\2\uffff\1\u00ff\1\151\1\u00ff\1\uffff"+
        "\1\153\1\164\1\156\1\162\1\uffff\1\145\1\uffff\1\u00ff\1\164\1\147"+
        "\2\uffff\1\156\1\uffff\2\u00ff\1\147\2\u00ff\1\uffff\1\163\1\u00ff"+
        "\1\153\2\uffff\1\u00ff\2\uffff\1\u00ff\1\164\1\uffff\1\u00ff\1\164"+
        "\2\uffff\1\u00ff\1\uffff\1\u00ff\2\uffff";
    static final String DFA19_acceptS =
        "\3\uffff\1\3\16\uffff\1\31\4\uffff\1\44\1\uffff\1\51\10\uffff\1"+
        "\70\1\71\1\72\1\73\3\uffff\1\102\1\105\1\117\1\120\1\121\1\124\2"+
        "\uffff\1\131\16\uffff\1\10\1\52\1\67\17\uffff\1\123\1\40\1\101\7"+
        "\uffff\1\126\1\uffff\1\127\2\uffff\1\61\1\62\1\114\1\63\1\116\1"+
        "\64\1\113\1\65\1\115\1\66\1\75\1\74\1\76\1\104\1\103\1\100\1\77"+
        "\1\125\15\uffff\1\6\3\uffff\1\12\40\uffff\1\20\5\uffff\1\47\3\uffff"+
        "\1\13\2\uffff\1\36\1\16\41\uffff\1\5\6\uffff\1\17\5\uffff\1\26\2"+
        "\uffff\1\37\1\uffff\1\43\1\uffff\1\46\1\50\1\122\1\53\1\130\1\uffff"+
        "\1\56\1\54\1\57\1\55\1\60\1\uffff\1\24\1\uffff\1\27\1\uffff\1\45"+
        "\3\uffff\1\23\12\uffff\1\30\1\uffff\1\42\2\uffff\1\7\7\uffff\1\32"+
        "\1\14\3\uffff\1\33\4\uffff\1\41\1\uffff\1\4\3\uffff\1\112\1\21\1"+
        "\uffff\1\25\5\uffff\1\11\3\uffff\1\35\1\34\1\uffff\1\1\1\2\2\uffff"+
        "\1\106\2\uffff\1\107\1\15\1\uffff\1\22\1\uffff\1\110\1\111";
    static final String DFA19_specialS =
        "\u0143\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\45\1\61\1\uffff\1\27"+
            "\2\uffff\1\56\1\43\1\44\1\53\1\3\1\22\1\24\1\50\1\35\1\57\1"+
            "\32\1\33\1\34\6\60\1\47\1\52\1\7\1\46\1\42\1\31\1\uffff\1\15"+
            "\14\56\1\14\3\56\1\16\10\56\1\36\1\uffff\1\37\1\uffff\1\56\1"+
            "\uffff\1\2\1\10\1\1\1\12\1\26\1\4\1\56\1\20\1\6\1\56\1\13\2"+
            "\56\1\11\1\23\2\56\1\17\1\21\1\30\1\56\1\5\1\25\3\56\1\40\1"+
            "\51\1\41\102\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\63\3\uffff\1\64\2\uffff\1\62",
            "\1\65\4\uffff\1\66",
            "",
            "\1\71\15\uffff\1\67\5\uffff\1\70",
            "\1\73\15\uffff\1\72",
            "\1\74\6\uffff\1\75\1\76\5\uffff\1\77",
            "\1\101\30\uffff\1\100",
            "\1\103",
            "\1\105\3\uffff\1\104",
            "\1\106\3\uffff\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114\11\uffff\1\115",
            "\1\116",
            "\1\120\5\uffff\1\117",
            "",
            "\1\122\74\uffff\1\121",
            "\1\123\1\124",
            "\1\125",
            "\1\126\13\uffff\1\127",
            "",
            "\1\130\6\uffff\1\131\11\uffff\1\132",
            "",
            "\1\136\1\uffff\1\133\11\135",
            "\1\136\1\uffff\1\137\11\135",
            "\1\136\1\uffff\1\140\11\135",
            "\1\142\4\uffff\1\141",
            "\1\143",
            "\1\145",
            "\1\147",
            "\1\151",
            "",
            "",
            "",
            "",
            "\1\153",
            "\1\156\2\uffff\1\155",
            "\1\160",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\136\1\uffff\12\135\76\uffff\1\162",
            "\1\136\1\uffff\12\135",
            "",
            "\1\164\1\163\6\uffff\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176\5\uffff\1\177",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\3\uffff\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "",
            "",
            "",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\136\1\uffff\1\u009a\11\u009b",
            "",
            "\1\136\1\uffff\12\u009b",
            "",
            "\1\136\1\uffff\1\u009c\11\u009b",
            "\1\136\1\uffff\1\u009d\11\u009b",
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
            "\1\u009f\2\uffff\1\u009e",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00b0",
            "\1\u00b1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\136\1\uffff\1\u00c4\1\u00c6\1\u00c5\7\u00c6",
            "\1\136\1\uffff\12\u00c6",
            "\1\136\1\uffff\1\u00c7\1\u00c6\1\u00c8\7\u00c6",
            "\1\136\1\uffff\1\u00c9\1\u00c6\1\u00ca\7\u00c6",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d6",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e3",
            "\1\u00e4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00ed\1\136\1\uffff\12\u00ee",
            "\1\u00f4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0109",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u010b",
            "",
            "",
            "",
            "",
            "",
            "\1\136\1\uffff\12\u00ee",
            "",
            "",
            "",
            "",
            "",
            "\1\u010c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u010e",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011b",
            "",
            "\1\u011c",
            "",
            "\1\u011d",
            "\1\u011e",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0120",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0127",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u012f",
            "\1\u0130",
            "",
            "",
            "\1\u0131",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0134",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0137",
            "\12\56\7\uffff\1\u0138\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u013a",
            "",
            "",
            "\12\56\7\uffff\1\u013b\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u013e",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0140",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
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
            return "1:1: Tokens : ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}