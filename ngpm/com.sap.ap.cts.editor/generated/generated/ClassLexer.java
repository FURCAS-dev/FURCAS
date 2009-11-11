<<<<<<< .mine
// $ANTLR 3.1.1 C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g 2009-11-03 11:39:54
=======
// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g 2009-11-10 12:31:44
>>>>>>> .r8534

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
<<<<<<< .mine
    public String getGrammarFileName() { return "C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g"; }
=======
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g"; }
>>>>>>> .r8534

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:7: ( 'native' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:9: 'native'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:7: ( 'const' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:117:9: 'const'
>>>>>>> .r8534
            {
            match("const"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:7: ( 'replace' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:9: 'replace'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:7: ( 'return' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:118:9: 'return'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("replace"); if (state.failed) return ;
=======
            match("return"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:7: ( 'function' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:9: 'function'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:7: ( 'store' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:119:9: 'store'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("function"); if (state.failed) return ;
=======
            match("store"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:7: ( 'var' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:9: 'var'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:7: ( 'rollback' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:120:9: 'rollback'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("var"); if (state.failed) return ;
=======
            match("rollback"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:7: ( 'else' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:9: 'else'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:7: ( 'by' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:121:9: 'by'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("else"); if (state.failed) return ;
=======
            match("by"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:7: ( 'void' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:9: 'void'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:7: ( 'RemoveLink' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:122:9: 'RemoveLink'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("void"); if (state.failed) return ;
=======
            match("RemoveLink"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:7: ( 'dim' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:9: 'dim'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:7: ( 'snapshot' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:123:9: 'snapshot'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("dim"); if (state.failed) return ;
=======
            match("snapshot"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:7: ( 'by' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:9: 'by'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:7: ( 'changed' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:124:9: 'changed'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("by"); if (state.failed) return ;
=======
            match("changed"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:7: ( 'aggregate' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:9: 'aggregate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:7: ( 'head' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:125:9: 'head'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("aggregate"); if (state.failed) return ;
=======
            match("head"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:7: ( 'rollback' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:9: 'rollback'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:7: ( ',' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:126:9: ','
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("rollback"); if (state.failed) return ;
=======
            match(','); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:7: ( 'implements' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:9: 'implements'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:7: ( '-=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:127:9: '-='
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("implements"); if (state.failed) return ;
=======
            match("-="); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:7: ( 'all' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:9: 'all'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:7: ( 'function' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:128:9: 'function'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("all"); if (state.failed) return ;
=======
            match("function"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:7: ( 'count' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:9: 'count'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:7: ( 'converter' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:129:9: 'converter'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("count"); if (state.failed) return ;
=======
            match("converter"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:7: ( 'while' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:9: 'while'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:7: ( 'owns' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:130:9: 'owns'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("while"); if (state.failed) return ;
=======
            match("owns"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:7: ( 'return' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:9: 'return'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:7: ( 'implements' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:131:9: 'implements'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("return"); if (state.failed) return ;
=======
            match("implements"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:7: ( 'head' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:9: 'head'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:7: ( '?' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:132:9: '?'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("head"); if (state.failed) return ;
=======
            match('?'); if (state.failed) return ;
>>>>>>> .r8534

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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:7: ( 'if' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:9: 'if'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:7: ( 'var' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:133:9: 'var'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("if"); if (state.failed) return ;
=======
            match("var"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:7: ( 'foreach' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:9: 'foreach'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:7: ( 'key' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:134:9: 'key'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("foreach"); if (state.failed) return ;
=======
            match("key"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:7: ( ',' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:9: ','
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:7: ( 'this' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:135:9: 'this'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match(','); if (state.failed) return ;
=======
            match("this"); if (state.failed) return ;
>>>>>>> .r8534

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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:7: ( 'changed' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:9: 'changed'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:7: ( 'else' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:136:9: 'else'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("changed"); if (state.failed) return ;
=======
            match("else"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:7: ( '-=' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:9: '-='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:7: ( '<$' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:137:9: '<$'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("-="); if (state.failed) return ;
=======
            match("<$"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:7: ( 'key' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:9: 'key'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:7: ( 'value' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:138:9: 'value'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("key"); if (state.failed) return ;
=======
            match("value"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:7: ( 'store' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:9: 'store'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:7: ( 'replace' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:139:9: 'replace'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("store"); if (state.failed) return ;
=======
            match("replace"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:7: ( 'AddLink' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:9: 'AddLink'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:7: ( 'tail' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:140:9: 'tail'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("AddLink"); if (state.failed) return ;
=======
            match("tail"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:7: ( 'snapshot' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:9: 'snapshot'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:7: ( 'delete' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:141:9: 'delete'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("snapshot"); if (state.failed) return ;
=======
            match("delete"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:7: ( 'delete' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:9: 'delete'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:7: ( 'if' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:142:9: 'if'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("delete"); if (state.failed) return ;
=======
            match("if"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:7: ( 'const' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:9: 'const'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:7: ( 'AddLink' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:143:9: 'AddLink'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("const"); if (state.failed) return ;
=======
            match("AddLink"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:7: ( 'tail' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:9: 'tail'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:7: ( 'class' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:144:9: 'class'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("tail"); if (state.failed) return ;
=======
            match("class"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:7: ( 'owns' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:9: 'owns'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:7: ( 'count' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:145:9: 'count'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("owns"); if (state.failed) return ;
=======
            match("count"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:7: ( '?' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:9: '?'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:7: ( 'while' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:146:9: 'while'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match('?'); if (state.failed) return ;
=======
            match("while"); if (state.failed) return ;
>>>>>>> .r8534

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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:7: ( '<$' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:9: '<$'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:7: ( 'commit' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:147:9: 'commit'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("<$"); if (state.failed) return ;
=======
            match("commit"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:7: ( 'RemoveLink' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:9: 'RemoveLink'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:7: ( '+=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:148:9: '+='
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("RemoveLink"); if (state.failed) return ;
=======
            match("+="); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:7: ( 'commit' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:9: 'commit'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:7: ( 'aggregate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:149:9: 'aggregate'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("commit"); if (state.failed) return ;
=======
            match("aggregate"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:7: ( 'converter' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:9: 'converter'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:7: ( 'native' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:150:9: 'native'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("converter"); if (state.failed) return ;
=======
            match("native"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:7: ( 'class' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:9: 'class'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:7: ( '$>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:151:9: '$>'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("class"); if (state.failed) return ;
=======
            match("$>"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:7: ( 'value' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:9: 'value'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:7: ( 'foreach' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:152:9: 'foreach'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("value"); if (state.failed) return ;
=======
            match("foreach"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:7: ( 'this' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:9: 'this'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:7: ( 'dim' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:153:9: 'dim'
>>>>>>> .r8534
            {
            match("dim"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:7: ( 'new' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:9: 'new'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:7: ( 'void' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:154:9: 'void'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("new"); if (state.failed) return ;
=======
            match("void"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:7: ( '+=' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:9: '+='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:7: ( 'NULL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:155:9: 'NULL'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("+="); if (state.failed) return ;
=======
            match("NULL"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:7: ( 'NULL' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:9: 'NULL'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:7: ( 'new' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:156:9: 'new'
>>>>>>> .r8534
            {
<<<<<<< .mine
            match("NULL"); if (state.failed) return ;
=======
            match("new"); if (state.failed) return ;
>>>>>>> .r8534


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:7: ( '$>' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:9: '$>'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:7: ( 'all' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:157:9: 'all'
>>>>>>> .r8534
            {
            match("all"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:7: ( '1000' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:9: '1000'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:7: ( '1000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:158:9: '1000'
>>>>>>> .r8534
            {
            match("1000"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:7: ( '2000' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:9: '2000'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:7: ( '2000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:159:9: '2000'
>>>>>>> .r8534
            {
            match("2000"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:7: ( '3000' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:9: '3000'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:7: ( '3000' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:160:9: '3000'
>>>>>>> .r8534
            {
            match("3000"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:7: ( '1002' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:9: '1002'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:7: ( '1002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:161:9: '1002'
>>>>>>> .r8534
            {
            match("1002"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:7: ( '2002' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:9: '2002'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:7: ( '2002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:162:9: '2002'
>>>>>>> .r8534
            {
            match("2002"); if (state.failed) return ;


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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:7: ( '3002' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:9: '3002'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:7: ( '3002' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:163:9: '3002'
>>>>>>> .r8534
            {
            match("3002"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2593:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2623:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:9: '//' (~ ( '\\r' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:9: '//' (~ ( '\\r' | '\\n' ) )*
>>>>>>> .r8534
            {
            match("//"); if (state.failed) return ;

<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:14: (~ ( '\\r' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:14: (~ ( '\\r' | '\\n' ) )*
>>>>>>> .r8534
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2594:15: ~ ( '\\r' | '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:15: ~ ( '\\r' | '\\n' )
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2599:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2629:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
>>>>>>> .r8534
            {
            match("/*"); if (state.failed) return ;

<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
>>>>>>> .r8534
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
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2600:43: ( '\\n' | ~ '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:43: ( '\\n' | ~ '\\n' )
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2605:3: ( '[' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2606:3: '['
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2635:3: ( '[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2636:3: '['
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2611:3: ( ']' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2612:3: ']'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2641:3: ( ']' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2642:3: ']'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2617:3: ( '{' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2618:3: '{'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2647:3: ( '{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2648:3: '{'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2623:3: ( '}' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2624:3: '}'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2653:3: ( '}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2654:3: '}'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2629:3: ( '<' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2630:3: '<'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2659:3: ( '<' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2660:3: '<'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2635:3: ( '>' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2636:3: '>'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2665:3: ( '>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2666:3: '>'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2641:3: ( '(' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2642:3: '('
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2671:3: ( '(' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2672:3: '('
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2647:3: ( ')' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2648:3: ')'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2677:3: ( ')' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2678:3: ')'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2653:3: ( '!' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2654:3: '!'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2683:3: ( '!' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2684:3: '!'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2659:3: ( '=' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2660:3: '='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2689:3: ( '=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2690:3: '='
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2665:3: ( '==' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2666:3: '=='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2695:3: ( '==' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2696:3: '=='
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2671:3: ( ':=' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2672:3: ':='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2701:3: ( ':=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2702:3: ':='
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2677:3: ( '.' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2678:3: '.'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2707:3: ( '.' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2708:3: '.'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2683:3: ( '..' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2684:3: '..'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2713:3: ( '..' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2714:3: '..'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2689:3: ( '->' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2690:3: '->'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2719:3: ( '->' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2720:3: '->'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2695:3: ( '|' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2696:3: '|'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2725:3: ( '|' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2726:3: '|'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2701:3: ( ':' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2702:3: ':'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2731:3: ( ':' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2732:3: ':'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2707:3: ( '::' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2708:3: '::'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2737:3: ( '::' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2738:3: '::'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2713:3: ( ';' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2714:3: ';'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2743:3: ( ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2744:3: ';'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2719:3: ( 'including' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2720:3: 'including'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2749:3: ( 'including' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2750:3: 'including'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2725:3: ( 'excluding' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2726:3: 'excluding'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2755:3: ( 'excluding' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2756:3: 'excluding'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2731:3: ( 'includingAt' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2732:3: 'includingAt'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2761:3: ( 'includingAt' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2762:3: 'includingAt'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2737:3: ( 'excludingAt' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2738:3: 'excludingAt'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2767:3: ( 'excludingAt' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2768:3: 'excludingAt'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2743:3: ( 'iterate' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2744:3: 'iterate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2773:3: ( 'iterate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2774:3: 'iterate'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2749:3: ( '{[' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2750:3: '{['
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2779:3: ( '{[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2780:3: '{['
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2755:3: ( '[{' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2756:3: '[{'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2785:3: ( '[{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2786:3: '[{'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2761:3: ( '}]' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2762:3: '}]'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2791:3: ( '}]' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2792:3: '}]'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2767:3: ( ']}' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2768:3: ']}'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2797:3: ( ']}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2798:3: ']}'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2773:3: ( '*' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2774:3: '*'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2803:3: ( '*' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2804:3: '*'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2783:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2783:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2813:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2813:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2783:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2813:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
>>>>>>> .r8534
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
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2783:6: '\\r' '\\n'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2813:6: '\\r' '\\n'
>>>>>>> .r8534
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2784:5: '\\n' '\\r'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2814:5: '\\n' '\\r'
>>>>>>> .r8534
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2785:5: '\\r'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:5: '\\r'
>>>>>>> .r8534
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2786:5: '\\n'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2816:5: '\\n'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2792:2: ( ( ' ' | '\\t' ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2792:4: ( ' ' | '\\t' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2822:2: ( ( ' ' | '\\t' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2822:4: ( ' ' | '\\t' )
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2799:2: ( '0' .. '9' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2799:4: '0' .. '9'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2829:2: ( '0' .. '9' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2829:4: '0' .. '9'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2804:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2834:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:4: ( ALPHA ) ( ALPHA | DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2845:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2845:4: ( ALPHA ) ( ALPHA | DIGIT )*
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:4: ( ALPHA )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:5: ALPHA
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2845:4: ( ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2845:5: ALPHA
>>>>>>> .r8534
            {
            mALPHA(); if (state.failed) return ;

            }

<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2815:12: ( ALPHA | DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2845:12: ( ALPHA | DIGIT )*
>>>>>>> .r8534
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2818:6: ( 'true' | 'false' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2848:6: ( 'true' | 'false' )
>>>>>>> .r8534
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
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2818:8: 'true'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2848:8: 'true'
>>>>>>> .r8534
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2818:17: 'false'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2848:17: 'false'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2820:8: ( 'o:' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2820:10: 'o:'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:8: ( 'o:' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:10: 'o:'
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2823:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2823:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2853:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2853:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2823:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2853:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
>>>>>>> .r8534
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
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2824:4: SNAME
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2854:4: SNAME
>>>>>>> .r8534
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2825:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2855:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
>>>>>>> .r8534
                    {
                    match('\''); if (state.failed) return ;
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2826:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2856:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
>>>>>>> .r8534
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
<<<<<<< .mine
                    	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2828:4: '\\n'
=======
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2858:4: '\\n'
>>>>>>> .r8534
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
<<<<<<< .mine
                    	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2829:6: ~ ( '\\\\' | '\\'' | '\\n' )
=======
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2859:6: ~ ( '\\\\' | '\\'' | '\\n' )
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2836:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2836:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2866:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2866:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
>>>>>>> .r8534
            {
            match("0x"); if (state.failed) return ;

<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2836:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2866:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
>>>>>>> .r8534
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
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2836:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2866:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2841:2: ( ( DIGIT )+ )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2841:4: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:2: ( ( DIGIT )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:4: ( DIGIT )+
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2841:4: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:4: ( DIGIT )+
>>>>>>> .r8534
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
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2841:5: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:5: DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:4: ( DIGIT )+ '.' ( DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:4: ( DIGIT )+ '.' ( DIGIT )*
>>>>>>> .r8534
            {
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:4: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:4: ( DIGIT )+
>>>>>>> .r8534
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
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:4: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:4: DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:15: ( DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:15: ( DIGIT )*
>>>>>>> .r8534
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2846:15: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2876:15: DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2880:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
>>>>>>> .r8534
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
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:9: ( INT '..' )=> INT
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2880:9: ( INT '..' )=> INT
>>>>>>> .r8534
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2851:7: ( INT '.' NAME )=> INT
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2881:7: ( INT '.' NAME )=> INT
>>>>>>> .r8534
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2852:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2882:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
>>>>>>> .r8534
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 4 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2859:9: INT
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2889:9: INT
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2863:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2863:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2893:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2893:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2863:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2893:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
>>>>>>> .r8534
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==' '||LA17_0=='T') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2863:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2893:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
>>>>>>> .r8534
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
<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2864:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2894:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
>>>>>>> .r8534
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==','||LA14_0=='.') && (synpred4_Class())) {
                        alt14=1;
                    }
                    else {
                        alt14=2;}
                    switch (alt14) {
                        case 1 :
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
>>>>>>> .r8534
                            {
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:41: ( ',' | '.' ) ( DIGIT )+
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:41: ( ',' | '.' ) ( DIGIT )+
>>>>>>> .r8534
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

<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:53: ( DIGIT )+
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:53: ( DIGIT )+
>>>>>>> .r8534
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
<<<<<<< .mine
                            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:54: DIGIT
=======
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:54: DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2867:13: 
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2897:13: 
>>>>>>> .r8534
                            {
                            }
                            break;

                    }

<<<<<<< .mine
                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2898:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
>>>>>>> .r8534
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='Z') ) {
                        alt16=1;
                    }
                    else {
                        alt16=2;}
                    switch (alt16) {
                        case 1 :
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:14: 'Z'
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2898:14: 'Z'
>>>>>>> .r8534
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2898:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
>>>>>>> .r8534
                            {
<<<<<<< .mine
                            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2898:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
>>>>>>> .r8534
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
<<<<<<< .mine
                                    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2868:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2898:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2871:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2901:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2901:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
>>>>>>> .r8534
            {
            match('\"'); if (state.failed) return ;
<<<<<<< .mine
            // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2872:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2902:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
>>>>>>> .r8534
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
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2874:4: '\\n'
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2904:4: '\\n'
>>>>>>> .r8534
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
<<<<<<< .mine
            	    // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2875:5: ~ ( '\\\\' | '\"' | '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2905:5: ~ ( '\\\\' | '\"' | '\\n' )
>>>>>>> .r8534
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
<<<<<<< .mine
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
>>>>>>> .r8534
        int alt19=88;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:10: T__49
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:10: T__49
>>>>>>> .r8534
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 2 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:16: T__50
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:16: T__50
>>>>>>> .r8534
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 3 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:22: T__51
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:22: T__51
>>>>>>> .r8534
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 4 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:28: T__52
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:28: T__52
>>>>>>> .r8534
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 5 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:34: T__53
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:34: T__53
>>>>>>> .r8534
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 6 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:40: T__54
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:40: T__54
>>>>>>> .r8534
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 7 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:46: T__55
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:46: T__55
>>>>>>> .r8534
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 8 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:52: T__56
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:52: T__56
>>>>>>> .r8534
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 9 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:58: T__57
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:58: T__57
>>>>>>> .r8534
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 10 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:64: T__58
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:64: T__58
>>>>>>> .r8534
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 11 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:70: T__59
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:70: T__59
>>>>>>> .r8534
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 12 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:76: T__60
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:76: T__60
>>>>>>> .r8534
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 13 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:82: T__61
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:82: T__61
>>>>>>> .r8534
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 14 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:88: T__62
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:88: T__62
>>>>>>> .r8534
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 15 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:94: T__63
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:94: T__63
>>>>>>> .r8534
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 16 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:100: T__64
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:100: T__64
>>>>>>> .r8534
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 17 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:106: T__65
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:106: T__65
>>>>>>> .r8534
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 18 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:112: T__66
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:112: T__66
>>>>>>> .r8534
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 19 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:118: T__67
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:118: T__67
>>>>>>> .r8534
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 20 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:124: T__68
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:124: T__68
>>>>>>> .r8534
                {
                mT__68(); if (state.failed) return ;

                }
                break;
            case 21 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:130: T__69
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:130: T__69
>>>>>>> .r8534
                {
                mT__69(); if (state.failed) return ;

                }
                break;
            case 22 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:136: T__70
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:136: T__70
>>>>>>> .r8534
                {
                mT__70(); if (state.failed) return ;

                }
                break;
            case 23 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:142: T__71
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:142: T__71
>>>>>>> .r8534
                {
                mT__71(); if (state.failed) return ;

                }
                break;
            case 24 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:148: T__72
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:148: T__72
>>>>>>> .r8534
                {
                mT__72(); if (state.failed) return ;

                }
                break;
            case 25 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:154: T__73
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:154: T__73
>>>>>>> .r8534
                {
                mT__73(); if (state.failed) return ;

                }
                break;
            case 26 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:160: T__74
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:160: T__74
>>>>>>> .r8534
                {
                mT__74(); if (state.failed) return ;

                }
                break;
            case 27 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:166: T__75
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:166: T__75
>>>>>>> .r8534
                {
                mT__75(); if (state.failed) return ;

                }
                break;
            case 28 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:172: T__76
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:172: T__76
>>>>>>> .r8534
                {
                mT__76(); if (state.failed) return ;

                }
                break;
            case 29 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:178: T__77
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:178: T__77
>>>>>>> .r8534
                {
                mT__77(); if (state.failed) return ;

                }
                break;
            case 30 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:184: T__78
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:184: T__78
>>>>>>> .r8534
                {
                mT__78(); if (state.failed) return ;

                }
                break;
            case 31 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:190: T__79
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:190: T__79
>>>>>>> .r8534
                {
                mT__79(); if (state.failed) return ;

                }
                break;
            case 32 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:196: T__80
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:196: T__80
>>>>>>> .r8534
                {
                mT__80(); if (state.failed) return ;

                }
                break;
            case 33 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:202: T__81
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:202: T__81
>>>>>>> .r8534
                {
                mT__81(); if (state.failed) return ;

                }
                break;
            case 34 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:208: T__82
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:208: T__82
>>>>>>> .r8534
                {
                mT__82(); if (state.failed) return ;

                }
                break;
            case 35 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:214: T__83
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:214: T__83
>>>>>>> .r8534
                {
                mT__83(); if (state.failed) return ;

                }
                break;
            case 36 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:220: T__84
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:220: T__84
>>>>>>> .r8534
                {
                mT__84(); if (state.failed) return ;

                }
                break;
            case 37 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:226: T__85
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:226: T__85
>>>>>>> .r8534
                {
                mT__85(); if (state.failed) return ;

                }
                break;
            case 38 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:232: T__86
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:232: T__86
>>>>>>> .r8534
                {
                mT__86(); if (state.failed) return ;

                }
                break;
            case 39 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:238: T__87
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:238: T__87
>>>>>>> .r8534
                {
                mT__87(); if (state.failed) return ;

                }
                break;
            case 40 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:244: T__88
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:244: T__88
>>>>>>> .r8534
                {
                mT__88(); if (state.failed) return ;

                }
                break;
            case 41 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:250: T__89
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:250: T__89
>>>>>>> .r8534
                {
                mT__89(); if (state.failed) return ;

                }
                break;
            case 42 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:256: T__90
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:256: T__90
>>>>>>> .r8534
                {
                mT__90(); if (state.failed) return ;

                }
                break;
            case 43 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:262: T__91
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:262: T__91
>>>>>>> .r8534
                {
                mT__91(); if (state.failed) return ;

                }
                break;
            case 44 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:268: T__92
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:268: T__92
>>>>>>> .r8534
                {
                mT__92(); if (state.failed) return ;

                }
                break;
            case 45 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:274: T__93
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:274: T__93
>>>>>>> .r8534
                {
                mT__93(); if (state.failed) return ;

                }
                break;
            case 46 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:280: T__94
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:280: T__94
>>>>>>> .r8534
                {
                mT__94(); if (state.failed) return ;

                }
                break;
            case 47 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:286: T__95
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:286: T__95
>>>>>>> .r8534
                {
                mT__95(); if (state.failed) return ;

                }
                break;
            case 48 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:292: COMMENT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:292: COMMENT
>>>>>>> .r8534
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 49 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:300: MULTI_LINE_COMMENT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:300: MULTI_LINE_COMMENT
>>>>>>> .r8534
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 50 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:319: LBRACKET
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:319: LBRACKET
>>>>>>> .r8534
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 51 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:328: RBRACKET
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:328: RBRACKET
>>>>>>> .r8534
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 52 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:337: LCURL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:337: LCURL
>>>>>>> .r8534
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 53 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:343: RCURL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:343: RCURL
>>>>>>> .r8534
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 54 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:349: LANGLE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:349: LANGLE
>>>>>>> .r8534
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 55 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:356: RANGLE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:356: RANGLE
>>>>>>> .r8534
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 56 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:363: LPAREN
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:363: LPAREN
>>>>>>> .r8534
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 57 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:370: RPAREN
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:370: RPAREN
>>>>>>> .r8534
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 58 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:377: EXCL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:377: EXCL
>>>>>>> .r8534
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 59 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:382: EQUALS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:382: EQUALS
>>>>>>> .r8534
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 60 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:389: EQUALSEQUALS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:389: EQUALSEQUALS
>>>>>>> .r8534
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 61 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:402: ASSIGN
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:402: ASSIGN
>>>>>>> .r8534
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 62 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:409: DOT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:409: DOT
>>>>>>> .r8534
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 63 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:413: DDOT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:413: DDOT
>>>>>>> .r8534
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 64 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:418: ARROW
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:418: ARROW
>>>>>>> .r8534
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 65 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:424: PIPE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:424: PIPE
>>>>>>> .r8534
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 66 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:429: COLON
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:429: COLON
>>>>>>> .r8534
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 67 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:435: DCOLON
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:435: DCOLON
>>>>>>> .r8534
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 68 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:442: SEMICOLON
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:442: SEMICOLON
>>>>>>> .r8534
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 69 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:452: INCLUDING
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:452: INCLUDING
>>>>>>> .r8534
                {
                mINCLUDING(); if (state.failed) return ;

                }
                break;
            case 70 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:462: EXCLUDING
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:462: EXCLUDING
>>>>>>> .r8534
                {
                mEXCLUDING(); if (state.failed) return ;

                }
                break;
            case 71 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:472: INCLUDINGAT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:472: INCLUDINGAT
>>>>>>> .r8534
                {
                mINCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 72 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:484: EXCLUDINGAT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:484: EXCLUDINGAT
>>>>>>> .r8534
                {
                mEXCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 73 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:496: ITERATE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:496: ITERATE
>>>>>>> .r8534
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 74 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:504: LCURL_LBRACK
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:504: LCURL_LBRACK
>>>>>>> .r8534
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 75 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:517: LBRACK_LCURL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:517: LBRACK_LCURL
>>>>>>> .r8534
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 76 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:530: RCURL_RBRACK
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:530: RCURL_RBRACK
>>>>>>> .r8534
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 77 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:543: RBRACK_RCURL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:543: RBRACK_RCURL
>>>>>>> .r8534
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 78 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:556: STAR
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:556: STAR
>>>>>>> .r8534
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 79 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:561: NL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:561: NL
>>>>>>> .r8534
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 80 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:564: WS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:564: WS
>>>>>>> .r8534
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 81 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:567: BOOL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:567: BOOL
>>>>>>> .r8534
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 82 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:572: OBJECT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:572: OBJECT
>>>>>>> .r8534
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 83 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:579: NAME
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:579: NAME
>>>>>>> .r8534
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 84 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:584: BINARY
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:584: BINARY
>>>>>>> .r8534
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 85 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:591: INT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:591: INT
>>>>>>> .r8534
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 86 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:595: RANGE_OR_INT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:595: RANGE_OR_INT
>>>>>>> .r8534
                {
                mRANGE_OR_INT(); if (state.failed) return ;

                }
                break;
            case 87 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:608: DATE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:608: DATE
>>>>>>> .r8534
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 88 :
<<<<<<< .mine
                // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:613: STRING
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:1:613: STRING
>>>>>>> .r8534
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Class
    public final void synpred1_Class_fragment() throws RecognitionException {   
<<<<<<< .mine
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:9: ( INT '..' )
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2850:11: INT '..'
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2880:9: ( INT '..' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2880:11: INT '..'
>>>>>>> .r8534
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_Class

    // $ANTLR start synpred2_Class
    public final void synpred2_Class_fragment() throws RecognitionException {   
<<<<<<< .mine
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2851:7: ( INT '.' NAME )
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2851:9: INT '.' NAME
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2881:7: ( INT '.' NAME )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2881:9: INT '.' NAME
>>>>>>> .r8534
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Class

    // $ANTLR start synpred3_Class
    public final void synpred3_Class_fragment() throws RecognitionException {   
<<<<<<< .mine
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2852:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2852:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2882:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2882:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
>>>>>>> .r8534
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
<<<<<<< .mine
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:15: ( ( ',' | '.' ) DIGIT )
        // C:\\data\\cts\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2865:17: ( ',' | '.' ) DIGIT
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:15: ( ( ',' | '.' ) DIGIT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.ap.cts.editor\\generated\\generated\\Class.g:2895:17: ( ',' | '.' ) DIGIT
>>>>>>> .r8534
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
<<<<<<< .mine
        "\1\uffff\14\56\2\uffff\5\56\1\uffff\1\127\1\56\1\uffff\1\56\1\uffff"+
        "\3\133\1\uffff\1\143\1\145\1\147\1\151\4\uffff\1\153\1\156\1\160"+
        "\6\uffff\2\133\1\uffff\15\56\1\u0081\3\56\1\u0085\7\56\2\uffff\10"+
        "\56\3\uffff\2\56\1\133\2\uffff\3\133\22\uffff\1\56\1\u009e\6\56"+
        "\1\u00a5\4\56\1\u00aa\1\56\1\uffff\1\56\1\u00ad\1\56\1\uffff\11"+
        "\56\1\u00b9\11\56\4\133\1\56\1\uffff\6\56\1\uffff\1\56\1\u00d2\1"+
        "\u00d3\1\56\1\uffff\2\56\1\uffff\12\56\1\u00e1\1\uffff\3\56\1\u00e5"+
        "\1\u00e6\1\u00e7\1\u00e8\1\56\1\u00ea\1\u00eb\1\u00ee\1\133\1\u00ef"+
        "\1\u00f0\1\u00f1\1\u00f2\6\56\1\u00e7\1\u00f9\2\uffff\6\56\1\u0100"+
        "\1\u0101\3\56\1\u0105\1\u0106\1\uffff\1\u0107\2\56\4\uffff\1\56"+
        "\2\uffff\1\133\6\uffff\1\u010b\1\56\1\u010d\3\56\1\uffff\1\56\1"+
        "\u0112\4\56\2\uffff\1\56\1\u0118\1\56\3\uffff\3\56\1\uffff\1\u011d"+
        "\1\uffff\2\56\1\u0120\1\56\1\uffff\3\56\1\u0125\1\56\1\uffff\1\u0127"+
        "\1\56\1\u0129\1\56\1\uffff\1\u012b\1\u012c\1\uffff\4\56\1\uffff"+
        "\1\56\1\uffff\1\u0132\1\uffff\1\56\2\uffff\1\u0135\1\u0136\1\56"+
        "\1\u0139\1\u013a\1\uffff\2\56\2\uffff\1\u013d\1\56\2\uffff\1\u013f"+
        "\1\u0140\1\uffff\1\u0141\3\uffff";
=======
        "\1\uffff\6\56\2\uffff\3\56\1\uffff\4\56\1\120\3\56\1\uffff\2\56"+
        "\1\uffff\1\56\3\133\1\uffff\1\143\1\145\1\147\1\151\4\uffff\1\153"+
        "\1\156\1\160\6\uffff\2\133\1\uffff\7\56\1\174\2\56\2\uffff\4\56"+
        "\1\uffff\1\56\1\u0084\12\56\2\uffff\11\56\1\133\2\uffff\3\133\22"+
        "\uffff\12\56\1\uffff\7\56\1\uffff\2\56\1\u00b1\2\56\1\u00b4\6\56"+
        "\1\u00bb\3\56\1\u00bf\1\56\1\u00c1\1\56\4\133\14\56\1\u00d6\3\56"+
        "\1\u00da\3\56\1\uffff\1\56\1\u00df\1\uffff\1\u00e0\1\u00e1\1\u00e2"+
        "\1\u00e3\2\56\1\uffff\3\56\1\uffff\1\56\1\uffff\1\u00ea\1\u00eb"+
        "\1\u00ee\1\133\1\u00ef\1\u00f0\1\u00f1\1\u00f2\1\u00f3\1\56\1\u00f5"+
        "\2\56\1\u00f8\3\56\1\u00fc\2\56\1\uffff\2\56\1\u00e2\1\uffff\3\56"+
        "\1\u0104\5\uffff\3\56\1\u0108\2\56\2\uffff\1\133\7\uffff\1\56\1"+
        "\uffff\1\u010c\1\56\1\uffff\1\u010e\2\56\1\uffff\7\56\1\uffff\1"+
        "\56\1\u0119\1\56\1\uffff\1\56\1\u011c\1\56\1\uffff\1\u011e\1\uffff"+
        "\1\u011f\4\56\1\u0124\2\56\1\u0127\1\56\1\uffff\1\u0129\1\56\1\uffff"+
        "\1\56\2\uffff\1\u012c\1\u012d\1\56\1\u012f\1\uffff\2\56\1\uffff"+
        "\1\56\1\uffff\1\56\1\u0134\2\uffff\1\56\1\uffff\1\56\1\u0138\1\u013a"+
        "\1\u013b\1\uffff\1\u013c\1\u013d\1\56\1\uffff\1\56\4\uffff\1\u0140"+
        "\1\u0141\2\uffff";
>>>>>>> .r8534
    static final String DFA19_eofS =
        "\u0142\uffff";
    static final String DFA19_minS =
<<<<<<< .mine
        "\1\11\1\141\1\145\2\141\1\154\1\145\1\171\1\147\1\146\2\150\1\145"+
        "\1\uffff\1\75\1\145\1\156\1\144\1\141\1\72\1\uffff\1\44\1\145\1"+
        "\uffff\1\125\1\uffff\3\56\1\52\1\173\1\175\1\133\1\135\4\uffff\1"+
        "\75\1\72\1\56\6\uffff\2\56\1\uffff\1\164\1\167\1\160\1\154\1\156"+
        "\1\162\2\154\1\151\1\163\1\143\1\155\1\154\1\60\1\147\1\154\1\160"+
        "\1\60\1\143\1\145\1\155\2\141\1\151\1\141\2\uffff\1\171\1\157\1"+
        "\141\1\144\2\151\1\165\1\156\3\uffff\1\155\1\114\1\56\2\uffff\3"+
        "\56\22\uffff\1\151\1\60\1\154\1\165\1\154\1\143\1\145\1\163\1\60"+
        "\1\165\1\144\1\145\1\154\1\60\1\145\1\uffff\1\162\1\60\1\154\1\uffff"+
        "\1\154\1\162\1\156\1\163\1\155\1\156\1\163\1\154\1\144\1\60\1\162"+
        "\1\160\1\114\1\154\1\163\1\145\1\163\1\157\1\114\4\56\1\166\1\uffff"+
        "\1\141\1\162\1\142\1\164\1\141\1\145\1\uffff\1\145\2\60\1\165\1"+
        "\uffff\1\164\1\145\1\uffff\1\145\1\165\1\141\2\164\1\145\1\151\1"+
        "\147\1\163\1\145\1\60\1\uffff\1\145\1\163\1\151\4\60\1\166\1\60"+
        "\7\55\1\145\1\143\1\156\1\141\1\151\1\143\2\60\2\uffff\1\144\1\145"+
        "\1\147\1\155\1\144\1\164\2\60\1\162\1\164\1\145\2\60\1\uffff\1\60"+
        "\1\150\1\156\4\uffff\1\145\2\uffff\1\56\6\uffff\1\60\1\145\1\60"+
        "\1\143\1\157\1\150\1\uffff\1\151\1\60\1\141\1\145\1\151\1\145\2"+
        "\uffff\1\164\1\60\1\144\3\uffff\1\157\1\153\1\114\1\uffff\1\60\1"+
        "\uffff\1\153\1\156\1\60\1\156\1\uffff\1\164\2\156\1\60\1\145\1\uffff"+
        "\1\60\1\164\1\60\1\151\1\uffff\2\60\1\uffff\1\147\1\145\1\164\1"+
        "\147\1\uffff\1\162\1\uffff\1\60\1\uffff\1\156\2\uffff\2\60\1\163"+
        "\2\60\1\uffff\1\153\1\164\2\uffff\1\60\1\164\2\uffff\2\60\1\uffff"+
        "\1\60\3\uffff";
=======
        "\1\11\1\150\1\145\1\156\1\171\2\145\1\uffff\1\75\1\141\1\72\1\146"+
        "\1\uffff\1\141\1\145\1\141\1\154\1\44\1\145\1\144\1\150\1\uffff"+
        "\1\147\1\141\1\uffff\1\125\3\56\1\52\1\173\1\175\1\133\1\135\4\uffff"+
        "\1\75\1\72\1\56\6\uffff\2\56\1\uffff\1\155\2\141\1\160\1\154\1\157"+
        "\1\141\1\60\1\155\1\141\2\uffff\1\156\1\162\1\154\1\156\1\uffff"+
        "\1\160\1\60\1\143\1\145\1\154\1\151\1\171\2\151\1\165\1\163\1\143"+
        "\2\uffff\1\154\1\155\1\144\1\151\1\147\1\154\1\164\1\167\1\114\1"+
        "\56\2\uffff\3\56\22\uffff\1\163\1\156\1\155\1\156\1\163\1\165\2"+
        "\154\1\162\1\160\1\uffff\1\157\1\144\1\143\1\145\2\163\1\154\1\uffff"+
        "\1\154\1\162\1\60\1\165\1\144\1\60\1\163\1\154\2\145\1\154\1\145"+
        "\1\60\1\114\1\154\1\162\1\60\1\151\1\60\1\114\4\56\1\164\1\145\1"+
        "\164\1\151\1\147\1\163\1\162\1\141\1\142\1\145\1\163\1\166\1\60"+
        "\1\164\1\141\1\145\1\60\1\145\1\165\1\141\1\uffff\1\145\1\60\1\uffff"+
        "\4\60\1\165\1\164\1\uffff\1\151\2\145\1\uffff\1\166\1\uffff\1\60"+
        "\7\55\1\60\1\162\1\60\1\164\1\145\1\60\1\156\1\143\1\141\1\60\1"+
        "\150\1\145\1\uffff\1\151\1\143\1\60\1\uffff\1\155\1\144\1\164\1"+
        "\60\5\uffff\1\144\1\145\1\156\1\60\1\147\1\145\2\uffff\1\56\7\uffff"+
        "\1\164\1\uffff\1\60\1\144\1\uffff\1\60\1\145\1\143\1\uffff\1\157"+
        "\1\114\1\157\1\150\1\145\1\151\1\145\1\uffff\1\151\1\60\1\153\1"+
        "\uffff\1\141\1\60\1\145\1\uffff\1\60\1\uffff\1\60\1\153\1\164\1"+
        "\151\1\156\1\60\2\156\1\60\1\156\1\uffff\1\60\1\164\1\uffff\1\162"+
        "\2\uffff\2\60\1\156\1\60\1\uffff\1\164\1\147\1\uffff\1\147\1\uffff"+
        "\1\145\1\60\2\uffff\1\153\1\uffff\1\163\3\60\1\uffff\2\60\1\164"+
        "\1\uffff\1\164\4\uffff\2\60\2\uffff";
>>>>>>> .r8534
    static final String DFA19_maxS =
<<<<<<< .mine
        "\1\u00ff\1\145\1\157\1\165\1\157\1\170\1\151\1\171\1\154\1\164\1"+
        "\157\1\150\1\145\1\uffff\1\76\1\145\1\164\1\144\1\162\1\167\1\uffff"+
        "\1\44\1\145\1\uffff\1\125\1\uffff\3\71\1\57\1\173\1\175\1\133\1"+
        "\135\4\uffff\2\75\1\56\6\uffff\1\170\1\71\1\uffff\1\164\1\167\1"+
        "\164\1\154\1\156\1\162\1\154\1\162\1\151\1\163\1\143\1\155\1\154"+
        "\1\u00ff\1\147\1\154\1\160\1\u00ff\1\143\1\145\1\165\2\141\1\151"+
        "\1\141\2\uffff\1\171\1\157\1\141\1\144\2\151\1\165\1\156\3\uffff"+
        "\1\155\1\114\1\71\2\uffff\3\71\22\uffff\1\151\1\u00ff\1\154\1\165"+
        "\1\154\1\143\1\145\1\163\1\u00ff\1\165\1\144\1\145\1\154\1\u00ff"+
        "\1\145\1\uffff\1\162\1\u00ff\1\154\1\uffff\1\154\1\162\1\156\1\166"+
        "\1\155\1\156\1\163\1\154\1\144\1\u00ff\1\162\1\160\1\114\1\154\1"+
        "\163\1\145\1\163\1\157\1\114\4\71\1\166\1\uffff\1\141\1\162\1\142"+
        "\1\164\1\141\1\145\1\uffff\1\145\2\u00ff\1\165\1\uffff\1\164\1\145"+
        "\1\uffff\1\145\1\165\1\141\2\164\1\145\1\151\1\147\1\163\1\145\1"+
        "\u00ff\1\uffff\1\145\1\163\1\151\4\u00ff\1\166\1\u00ff\7\71\1\145"+
        "\1\143\1\156\1\141\1\151\1\143\2\u00ff\2\uffff\1\144\1\145\1\147"+
        "\1\155\1\144\1\164\2\u00ff\1\162\1\164\1\145\2\u00ff\1\uffff\1\u00ff"+
        "\1\150\1\156\4\uffff\1\145\2\uffff\1\71\6\uffff\1\u00ff\1\145\1"+
        "\u00ff\1\143\1\157\1\150\1\uffff\1\151\1\u00ff\1\141\1\145\1\151"+
        "\1\145\2\uffff\1\164\1\u00ff\1\144\3\uffff\1\157\1\153\1\114\1\uffff"+
        "\1\u00ff\1\uffff\1\153\1\156\1\u00ff\1\156\1\uffff\1\164\2\156\1"+
        "\u00ff\1\145\1\uffff\1\u00ff\1\164\1\u00ff\1\151\1\uffff\2\u00ff"+
        "\1\uffff\1\147\1\145\1\164\1\147\1\uffff\1\162\1\uffff\1\u00ff\1"+
        "\uffff\1\156\2\uffff\2\u00ff\1\163\2\u00ff\1\uffff\1\153\1\164\2"+
        "\uffff\1\u00ff\1\164\2\uffff\2\u00ff\1\uffff\1\u00ff\3\uffff";
=======
        "\1\u00ff\2\157\1\164\1\171\2\145\1\uffff\1\76\1\165\1\167\1\164"+
        "\1\uffff\1\157\1\145\1\162\1\170\1\44\1\151\1\144\1\150\1\uffff"+
        "\1\154\1\145\1\uffff\1\125\3\71\1\57\1\173\1\175\1\133\1\135\4\uffff"+
        "\2\75\1\56\6\uffff\1\170\1\71\1\uffff\1\165\2\141\1\164\1\154\1"+
        "\157\1\141\1\u00ff\1\155\1\141\2\uffff\1\156\1\162\1\154\1\156\1"+
        "\uffff\1\160\1\u00ff\1\143\1\145\1\162\1\151\1\171\2\151\1\165\1"+
        "\163\1\143\2\uffff\1\154\1\155\1\144\1\151\1\147\1\154\1\164\1\167"+
        "\1\114\1\71\2\uffff\3\71\22\uffff\1\166\1\156\1\155\1\156\1\163"+
        "\1\165\2\154\1\162\1\160\1\uffff\1\157\1\144\1\143\1\145\2\163\1"+
        "\154\1\uffff\1\154\1\162\1\u00ff\1\165\1\144\1\u00ff\1\163\1\154"+
        "\2\145\1\154\1\145\1\u00ff\1\114\1\154\1\162\1\u00ff\1\151\1\u00ff"+
        "\1\114\4\71\1\164\1\145\1\164\1\151\1\147\1\163\1\162\1\141\1\142"+
        "\1\145\1\163\1\166\1\u00ff\1\164\1\141\1\145\1\u00ff\1\145\1\165"+
        "\1\141\1\uffff\1\145\1\u00ff\1\uffff\4\u00ff\1\165\1\164\1\uffff"+
        "\1\151\2\145\1\uffff\1\166\1\uffff\1\u00ff\7\71\1\u00ff\1\162\1"+
        "\u00ff\1\164\1\145\1\u00ff\1\156\1\143\1\141\1\u00ff\1\150\1\145"+
        "\1\uffff\1\151\1\143\1\u00ff\1\uffff\1\155\1\144\1\164\1\u00ff\5"+
        "\uffff\1\144\1\145\1\156\1\u00ff\1\147\1\145\2\uffff\1\71\7\uffff"+
        "\1\164\1\uffff\1\u00ff\1\144\1\uffff\1\u00ff\1\145\1\143\1\uffff"+
        "\1\157\1\114\1\157\1\150\1\145\1\151\1\145\1\uffff\1\151\1\u00ff"+
        "\1\153\1\uffff\1\141\1\u00ff\1\145\1\uffff\1\u00ff\1\uffff\1\u00ff"+
        "\1\153\1\164\1\151\1\156\1\u00ff\2\156\1\u00ff\1\156\1\uffff\1\u00ff"+
        "\1\164\1\uffff\1\162\2\uffff\2\u00ff\1\156\1\u00ff\1\uffff\1\164"+
        "\1\147\1\uffff\1\147\1\uffff\1\145\1\u00ff\2\uffff\1\153\1\uffff"+
        "\1\163\3\u00ff\1\uffff\2\u00ff\1\164\1\uffff\1\164\4\uffff\2\u00ff"+
        "\2\uffff";
>>>>>>> .r8534
    static final String DFA19_acceptS =
<<<<<<< .mine
        "\15\uffff\1\23\6\uffff\1\36\2\uffff\1\47\1\uffff\1\51\10\uffff\1"+
        "\67\1\70\1\71\1\72\3\uffff\1\101\1\104\1\116\1\117\1\120\1\123\2"+
        "\uffff\1\130\31\uffff\1\25\1\100\10\uffff\1\122\1\37\1\66\3\uffff"+
        "\1\125\1\126\3\uffff\1\60\1\61\1\113\1\62\1\115\1\63\1\112\1\64"+
        "\1\114\1\65\1\74\1\73\1\75\1\103\1\102\1\77\1\76\1\124\17\uffff"+
        "\1\10\3\uffff\1\21\30\uffff\1\46\6\uffff\1\4\4\uffff\1\7\2\uffff"+
        "\1\14\13\uffff\1\26\30\uffff\1\6\1\5\15\uffff\1\20\3\uffff\1\34"+
        "\1\45\1\121\1\35\1\uffff\1\50\1\52\1\uffff\1\127\1\55\1\53\1\56"+
        "\1\54\1\57\6\uffff\1\44\6\uffff\1\15\1\33\3\uffff\1\43\1\16\1\27"+
        "\3\uffff\1\1\1\uffff\1\17\4\uffff\1\32\5\uffff\1\41\4\uffff\1\2"+
        "\2\uffff\1\22\4\uffff\1\111\1\uffff\1\24\1\uffff\1\30\1\uffff\1"+
        "\12\1\3\5\uffff\1\31\2\uffff\1\106\1\11\2\uffff\1\105\1\42\2\uffff"+
        "\1\13\1\uffff\1\40\1\110\1\107";
=======
        "\7\uffff\1\12\4\uffff\1\20\10\uffff\1\40\2\uffff\1\43\11\uffff\1"+
        "\67\1\70\1\71\1\72\3\uffff\1\101\1\104\1\116\1\117\1\120\1\123\2"+
        "\uffff\1\130\12\uffff\1\13\1\100\4\uffff\1\122\14\uffff\1\25\1\66"+
        "\12\uffff\1\125\1\126\3\uffff\1\60\1\61\1\113\1\62\1\115\1\63\1"+
        "\112\1\64\1\114\1\65\1\74\1\73\1\75\1\103\1\102\1\77\1\76\1\124"+
        "\12\uffff\1\5\7\uffff\1\32\54\uffff\1\21\2\uffff\1\22\6\uffff\1"+
        "\45\3\uffff\1\51\1\uffff\1\50\24\uffff\1\11\3\uffff\1\16\4\uffff"+
        "\1\46\1\23\1\30\1\121\1\24\6\uffff\1\47\1\52\1\uffff\1\127\1\55"+
        "\1\53\1\56\1\54\1\57\1\1\1\uffff\1\35\2\uffff\1\34\3\uffff\1\3\7"+
        "\uffff\1\26\3\uffff\1\36\3\uffff\1\37\1\uffff\1\2\12\uffff\1\31"+
        "\2\uffff\1\42\1\uffff\1\10\1\27\4\uffff\1\44\2\uffff\1\111\1\uffff"+
        "\1\33\2\uffff\1\4\1\7\1\uffff\1\14\4\uffff\1\15\3\uffff\1\105\1"+
        "\uffff\1\106\1\41\1\6\1\17\2\uffff\1\107\1\110";
>>>>>>> .r8534
    static final String DFA19_specialS =
        "\u0142\uffff}>";
    static final String[] DFA19_transitionS = {
<<<<<<< .mine
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\45\1\61\1\uffff\1\31"+
            "\2\uffff\1\56\1\43\1\44\1\53\1\27\1\15\1\16\1\50\1\35\1\57\1"+
            "\32\1\33\1\34\6\60\1\47\1\52\1\25\1\46\1\42\1\24\1\uffff\1\21"+
            "\14\56\1\30\3\56\1\26\10\56\1\36\1\uffff\1\37\1\uffff\1\56\1"+
            "\uffff\1\10\1\7\1\12\1\6\1\5\1\3\1\56\1\14\1\11\1\56\1\17\2"+
            "\56\1\1\1\23\2\56\1\2\1\20\1\22\1\56\1\4\1\13\3\56\1\40\1\51"+
            "\1\41\102\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\62\3\uffff\1\63",
            "\1\64\11\uffff\1\65",
            "\1\70\15\uffff\1\67\5\uffff\1\66",
            "\1\71\15\uffff\1\72",
            "\1\73\13\uffff\1\74",
            "\1\76\3\uffff\1\75",
            "\1\77",
            "\1\100\4\uffff\1\101",
            "\1\103\6\uffff\1\102\1\104\5\uffff\1\105",
            "\1\107\3\uffff\1\110\2\uffff\1\106",
            "\1\111",
            "\1\112",
=======
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\45\1\61\1\uffff\1\30"+
            "\2\uffff\1\56\1\43\1\44\1\53\1\25\1\7\1\10\1\50\1\35\1\57\1"+
            "\32\1\33\1\34\6\60\1\47\1\52\1\21\1\46\1\42\1\14\1\uffff\1\23"+
            "\14\56\1\31\3\56\1\5\10\56\1\36\1\uffff\1\37\1\uffff\1\56\1"+
            "\uffff\1\26\1\4\1\1\1\22\1\20\1\11\1\56\1\6\1\13\1\56\1\16\2"+
            "\56\1\27\1\12\2\56\1\2\1\3\1\17\1\56\1\15\1\24\3\56\1\40\1\51"+
            "\1\41\102\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\63\3\uffff\1\64\2\uffff\1\62",
            "\1\65\11\uffff\1\66",
            "\1\70\5\uffff\1\67",
            "\1\71",
            "\1\72",
            "\1\73",
>>>>>>> .r8534
            "",
<<<<<<< .mine
            "\1\113\1\114",
            "\1\115",
            "\1\117\5\uffff\1\116",
            "\1\120",
            "\1\121\6\uffff\1\122\11\uffff\1\123",
            "\1\125\74\uffff\1\124",
=======
            "\1\74\1\75",
            "\1\100\15\uffff\1\77\5\uffff\1\76",
            "\1\102\74\uffff\1\101",
            "\1\104\6\uffff\1\103\1\105\5\uffff\1\106",
>>>>>>> .r8534
            "",
<<<<<<< .mine
            "\1\126",
            "\1\130",
            "",
            "\1\131",
=======
            "\1\107\15\uffff\1\110",
            "\1\111",
            "\1\113\6\uffff\1\112\11\uffff\1\114",
            "\1\115\13\uffff\1\116",
            "\1\117",
            "\1\121\3\uffff\1\122",
            "\1\123",
            "\1\124",
>>>>>>> .r8534
            "",
            "\1\125\4\uffff\1\126",
            "\1\127\3\uffff\1\130",
            "",
            "\1\131",
            "\1\134\1\uffff\1\132\11\135",
            "\1\134\1\uffff\1\136\11\135",
            "\1\134\1\uffff\1\137\11\135",
            "\1\141\4\uffff\1\140",
            "\1\142",
            "\1\144",
            "\1\146",
            "\1\150",
            "",
            "",
            "",
            "",
            "\1\152",
            "\1\155\2\uffff\1\154",
            "\1\157",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134\1\uffff\12\135\76\uffff\1\161",
            "\1\134\1\uffff\12\135",
            "",
<<<<<<< .mine
            "\1\162",
            "\1\163",
            "\1\164\3\uffff\1\165",
=======
            "\1\164\1\162\6\uffff\1\163",
            "\1\165",
>>>>>>> .r8534
            "\1\166",
<<<<<<< .mine
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\173\5\uffff\1\172",
=======
            "\1\170\3\uffff\1\167",
            "\1\171",
            "\1\172",
            "\1\173",
>>>>>>> .r8534
<<<<<<< .mine
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\175",
            "\1\176",
            "",
            "",
            "\1\177",
>>>>>>> .r8534
            "\1\u0080",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0082",
=======
            "\1\u0081",
            "\1\u0082",
            "",
>>>>>>> .r8534
            "\1\u0083",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0086",
<<<<<<< .mine
            "\1\u0087",
            "\1\u008a\1\u0089\6\uffff\1\u0088",
=======
            "\1\u0088\5\uffff\1\u0087",
            "\1\u0089",
            "\1\u008a",
>>>>>>> .r8534
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "\1\u008f",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\134\1\uffff\1\u0099\11\u009a",
            "",
            "",
            "\1\134\1\uffff\12\u009a",
            "\1\134\1\uffff\1\u009b\11\u009a",
            "\1\134\1\uffff\1\u009c\11\u009a",
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
            "\1\u009d\2\uffff\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a6",
            "\1\u00a7",
            "",
            "\1\u00a8",
<<<<<<< .mine
            "\1\u00a9",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u00a9",
            "\1\u00aa",
>>>>>>> .r8534
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\1\u00ae",
            "",
            "\1\u00ae",
            "",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2\2\uffff\1\u00b3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ba",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00bc",
            "\1\u00bd",
<<<<<<< .mine
            "\1\u00be",
=======
            "\1\u00be",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
<<<<<<< .mine
            "\1\u00bf",
            "\1\u00c0",
=======
            "\1\u00c0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
            "\1\u00c2",
            "\1\134\1\uffff\1\u00c3\1\u00c5\1\u00c4\7\u00c5",
            "\1\134\1\uffff\12\u00c5",
            "\1\134\1\uffff\1\u00c6\1\u00c5\1\u00c7\7\u00c5",
            "\1\134\1\uffff\1\u00c8\1\u00c5\1\u00c9\7\u00c5",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "\1\u00d1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d4",
            "",
            "\1\u00d5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
<<<<<<< .mine
            "\1\u00da",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
            "\1\u00db",
<<<<<<< .mine
            "\1\u00dc",
=======
            "\1\u00dc",
            "\1\u00dd",
            "",
            "\1\u00de",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
<<<<<<< .mine
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00e2",
            "\1\u00e3",
=======
            "",
>>>>>>> .r8534
            "\1\u00e4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u00e9",
=======
            "\1\u00e4",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "",
>>>>>>> .r8534
            "\1\u00e9",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\1\u00ed\1\134\1\uffff\12\u00ec",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fb",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u00fd",
>>>>>>> .r8534
            "",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
<<<<<<< .mine
            "\1\u00ff",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
            "",
            "\1\u00ff",
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
<<<<<<< .mine
            "\1\u0104",
=======
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0108",
=======
>>>>>>> .r8534
            "\1\u0109",
            "",
            "",
            "",
            "",
<<<<<<< .mine
            "\1\u010a",
=======
>>>>>>> .r8534
            "",
<<<<<<< .mine
=======
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
            "\1\u0109",
            "\1\u010a",
            "",
            "",
            "\1\134\1\uffff\12\u00ec",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u010b",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u010c",
=======
            "\1\u010d",
            "",
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u010e",
            "\1\u010f",
=======
            "\1\u010f",
>>>>>>> .r8534
            "\1\u0110",
            "",
<<<<<<< .mine
            "\1\u0111",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u0111",
            "\1\u0112",
>>>>>>> .r8534
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "",
            "",
            "\1\u0117",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
            "",
            "\1\u0118",
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "",
            "\1\u011a",
            "",
            "\1\u011b",
            "\1\u011c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "\1\u011e",
            "\1\u011f",
=======
            "\1\u011d",
>>>>>>> .r8534
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0120",
>>>>>>> .r8534
            "\1\u0121",
            "\1\u0122",
<<<<<<< .mine
            "\1\u0123",
            "\1\u0124",
=======
            "\1\u0123",
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u0126",
            "",
=======
            "\1\u0125",
>>>>>>> .r8534
            "\1\u0126",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0128",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
>>>>>>> .r8534
            "\1\u012a",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "\1\u012a",
            "",
            "\1\u012b",
            "",
>>>>>>> .r8534
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "\1\u012d",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
            "\1\u012e",
<<<<<<< .mine
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
>>>>>>> .r8534
            "\1\u0130",
            "\1\u0131",
            "",
<<<<<<< .mine
            "\1\u0131",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
=======
>>>>>>> .r8534
            "",
            "",
            "\1\u0133",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
<<<<<<< .mine
            "\12\56\7\uffff\1\u0134\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0137",
            "\12\56\7\uffff\1\u0138\31\56\4\uffff\1\56\1\uffff\32\56\105"+
=======
            "\1\u0135",
            "",
            "\1\u0136",
            "\12\56\7\uffff\1\u0137\31\56\4\uffff\1\56\1\uffff\32\56\105"+
>>>>>>> .r8534
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "\12\56\7\uffff\1\u0139\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
<<<<<<< .mine
            "\1\u013b",
            "\1\u013c",
            "",
            "",
=======
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u013e",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u013e",
            "",
            "\1\u013f",
>>>>>>> .r8534
            "",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
=======
>>>>>>> .r8534
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
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
            return "1:1: Tokens : ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}