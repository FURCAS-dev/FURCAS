<<<<<<< .mine
// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g 2010-03-19 11:54:11
=======
// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g 2010-05-04 13:46:31
>>>>>>> .r9710

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

public class TCSLexer extends Lexer {
    public static final int LT=19;
    public static final int DLCURLY=29;
    public static final int STAR=27;
    public static final int LSQUARE=21;
    public static final int DRCURLY=30;
    public static final int EXCL=36;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=10;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=43;
    public static final int EQ=11;
    public static final int COMMENT=34;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int NE=42;
    public static final int GE=40;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int SHARP=18;
    public static final int T__83=83;
    public static final int LCURLY=12;
    public static final int INT=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int ALPHA=46;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=44;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=47;
    public static final int T__70=70;
    public static final int GT=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int QMARK=23;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int DOLLAR=28;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int POINT=32;
    public static final int AROBAS=37;
    public static final int T__118=118;
    public static final int ESC=48;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int DLCOLON=8;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int DRSQUARE=26;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int LARROW=31;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int FLOAT=7;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=9;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int SLASH=38;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int PIPE=25;
    public static final int PLUS=39;
    public static final int DIGIT=45;
    public static final int T__50=50;
    public static final int DLSQUARE=24;
    public static final int T__49=49;
    public static final int RARROW=15;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RSQUARE=22;
    public static final int MINUS=33;
    public static final int COMA=17;
    public static final int SEMI=14;
    public static final int MULTI_LINE_COMMENT=35;
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=41;
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

    public TCSLexer() {;} 
    public TCSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TCSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
<<<<<<< .mine
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g"; }
=======
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g"; }
>>>>>>> .r9710

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:7: ( 'and' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:9: 'and'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:7: ( 'instanceOf' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:9: 'instanceOf'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("and"); 
=======
            match("instanceOf"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:7: ( 'template' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:9: 'template'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:7: ( 'createIn' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:9: 'createIn'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("template"); 
=======
            match("createIn"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:7: ( 'false' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:9: 'false'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:7: ( 'omitted' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:9: 'omitted'
>>>>>>> .r9710
            {
            match("false"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:7: ( 'true' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:9: 'true'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:7: ( 'addToContext' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:9: 'addToContext'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("true"); 
=======
            match("addToContext"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:7: ( 'createIn' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:9: 'createIn'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:7: ( 'value' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:9: 'value'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("createIn"); 
=======
            match("value"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:7: ( 'for' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:9: 'for'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:7: ( 'left' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:9: 'left'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("for"); 
=======
            match("left"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:7: ( 'nbNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:9: 'nbNL'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:7: ( 'endNL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:9: 'endNL'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("nbNL"); 
=======
            match("endNL"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:7: ( 'lookIn' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:9: 'lookIn'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:7: ( 'word' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:9: 'word'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("lookIn"); 
=======
            match("word"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:7: ( 'k' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:9: 'k'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:7: ( 'false' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:9: 'false'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match('k'); 
=======
            match("false"); 
>>>>>>> .r9710

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:7: ( 'never' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:9: 'never'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:7: ( 'all' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:9: 'all'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("never"); 
=======
            match("all"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:7: ( 'orKeyword' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:9: 'orKeyword'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:7: ( 'createAs' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:9: 'createAs'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("orKeyword"); 
=======
            match("createAs"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:7: ( 'createAs' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:9: 'createAs'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:7: ( 'template' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:9: 'template'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("createAs"); 
=======
            match("template"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:7: ( 'always' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:9: 'always'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:7: ( 'deep' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:9: 'deep'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("always"); 
=======
            match("deep"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:7: ( 'syntax' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:9: 'syntax'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:7: ( 'default' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:9: 'default'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("syntax"); 
=======
            match("default"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:7: ( 'addToContext' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:9: 'addToContext'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:7: ( 'primitiveTemplate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:9: 'primitiveTemplate'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("addToContext"); 
=======
            match("primitiveTemplate"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:7: ( 'auto' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:9: 'auto'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:7: ( 'start' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:9: 'start'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("auto"); 
=======
            match("start"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:7: ( 'octal' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:9: 'octal'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:7: ( 'for' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:9: 'for'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("octal"); 
=======
            match("for"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:7: ( 'invert' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:9: 'invert'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:7: ( 'endOfLine' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:9: 'endOfLine'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("invert"); 
=======
            match("endOfLine"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:7: ( 'end' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:9: 'end'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:7: ( 'ifmissing' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:9: 'ifmissing'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("end"); 
=======
            match("ifmissing"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:7: ( 'leftNone' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:9: 'leftNone'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:7: ( 'startNL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:9: 'startNL'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("leftNone"); 
=======
            match("startNL"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:7: ( 'main' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:9: 'main'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:7: ( 'right' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:9: 'right'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("main"); 
=======
            match("right"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:7: ( 'forcedLower' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:9: 'forcedLower'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:7: ( 'serializer' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:9: 'serializer'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("forcedLower"); 
=======
            match("serializer"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:7: ( 'using' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:9: 'using'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:7: ( 'importContext' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:9: 'importContext'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("using"); 
=======
            match("importContext"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:7: ( 'start' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:9: 'start'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:7: ( 'lexer' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:9: 'lexer'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("start"); 
=======
            match("lexer"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:7: ( 'token' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:9: 'token'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:7: ( 'rightSpace' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:9: 'rightSpace'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("token"); 
=======
            match("rightSpace"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:7: ( 'when' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:9: 'when'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:7: ( 'disambiguate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:9: 'disambiguate'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("when"); 
=======
            match("disambiguate"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:7: ( 'mode' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:9: 'mode'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:7: ( 'hex' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:9: 'hex'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("mode"); 
=======
            match("hex"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:7: ( 'word' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:9: 'word'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:7: ( 'prefix' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:9: 'prefix'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("word"); 
=======
            match("prefix"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:7: ( 'primitiveTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:9: 'primitiveTemplate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:7: ( 'syntax' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:9: 'syntax'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("primitiveTemplate"); 
=======
            match("syntax"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:7: ( 'disambiguateV3' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:9: 'disambiguateV3'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:7: ( 'indentIncr' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:9: 'indentIncr'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("disambiguateV3"); 
=======
            match("indentIncr"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:7: ( 'part' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:9: 'part'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:7: ( 'keywords' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:9: 'keywords'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("part"); 
=======
            match("keywords"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:7: ( 'nonPrimary' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:9: 'nonPrimary'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:7: ( 'part' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:9: 'part'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("nonPrimary"); 
=======
            match("part"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:7: ( 'esc' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:9: 'esc'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:7: ( 'never' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:9: 'never'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("esc"); 
=======
            match("never"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:7: ( 'foreach' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:9: 'foreach'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:7: ( 'autoCreate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:9: 'autoCreate'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("foreach"); 
=======
            match("autoCreate"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:7: ( 'operatored' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:9: 'operatored'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:7: ( 'octal' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:9: 'octal'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("operatored"); 
=======
            match("octal"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:7: ( 'hex' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:9: 'hex'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:7: ( 'foreach' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:9: 'foreach'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("hex"); 
=======
            match("foreach"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:7: ( 'symbols' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:9: 'symbols'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:7: ( 'multiLine' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:9: 'multiLine'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("symbols"); 
=======
            match("multiLine"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:7: ( 'forcedUpper' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:9: 'forcedUpper'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:7: ( 'nbNL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:9: 'nbNL'
>>>>>>> .r9710
            {
            match("nbNL"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:7: ( 'rightSpace' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:9: 'rightSpace'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:7: ( 'partial' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:9: 'partial'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("rightSpace"); 
=======
            match("partial"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:7: ( 'left' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:9: 'left'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:7: ( 'postfix' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:9: 'postfix'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("left"); 
=======
            match("postfix"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:7: ( 'filter' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:9: 'filter'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:7: ( 'main' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:9: 'main'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("filter"); 
=======
            match("main"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:7: ( 'storeRightTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:9: 'storeRightTo'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:7: ( 'end' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:9: 'end'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("storeRightTo"); 
=======
            match("end"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:7: ( 'context' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:9: 'context'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:7: ( 'rightNone' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:9: 'rightNone'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("context"); 
=======
            match("rightNone"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:7: ( 'storeOpTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:9: 'storeOpTo'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:7: ( 'enumerationTemplate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:9: 'enumerationTemplate'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("storeOpTo"); 
=======
            match("enumerationTemplate"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:7: ( 'drop' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:9: 'drop'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:7: ( 'always' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:9: 'always'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("drop"); 
=======
            match("always"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:7: ( 'operators' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:9: 'operators'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:7: ( 'as' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:9: 'as'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("operators"); 
=======
            match("as"); 
>>>>>>> .r9710


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:7: ( 'startNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:9: 'startNL'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:7: ( 'one' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:9: 'one'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("startNL"); 
=======
            match("one"); 
>>>>>>> .r9710


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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:7: ( 'deep' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:9: 'deep'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:7: ( 'symbols' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:9: 'symbols'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("deep"); 
=======
            match("symbols"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:7: ( 'query' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:9: 'query'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:7: ( 'isDefined' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:9: 'isDefined'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("query"); 
=======
            match("isDefined"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:7: ( 'ifmissing' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:9: 'ifmissing'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:7: ( 'forcedLower' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:9: 'forcedLower'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("ifmissing"); 
=======
            match("forcedLower"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:7: ( 'prefix' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:9: 'prefix'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:7: ( 'mode' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:9: 'mode'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("prefix"); 
=======
            match("mode"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:8: ( 'multiLine' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:10: 'multiLine'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:8: ( 'storeRightTo' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:10: 'storeRightTo'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("multiLine"); 
=======
            match("storeRightTo"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:8: ( 'isDefined' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:10: 'isDefined'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:8: ( 'leftSpace' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:10: 'leftSpace'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("isDefined"); 
=======
            match("leftSpace"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:8: ( 'omitted' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:10: 'omitted'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:8: ( 'and' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:10: 'and'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("omitted"); 
=======
            match("and"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:8: ( 'function' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:10: 'function'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:8: ( 'auto' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:10: 'auto'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("function"); 
=======
            match("auto"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:8: ( 'rightNone' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:10: 'rightNone'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:8: ( 'separator' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:10: 'separator'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("rightNone"); 
=======
            match("separator"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:8: ( 'startNbNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:10: 'startNbNL'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:8: ( 'leftNone' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:10: 'leftNone'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("startNbNL"); 
=======
            match("leftNone"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:8: ( 'multi' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:10: 'multi'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:8: ( 'function' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:10: 'function'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("multi"); 
=======
            match("function"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:8: ( 'one' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:10: 'one'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:8: ( 'disambiguateV3' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:10: 'disambiguateV3'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("one"); 
=======
            match("disambiguateV3"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:8: ( 'value' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:10: 'value'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:8: ( 'query' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:10: 'query'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("value"); 
=======
            match("query"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:8: ( 'default' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:10: 'default'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:8: ( 'referenceOnly' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:10: 'referenceOnly'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("default"); 
=======
            match("referenceOnly"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:8: ( 'autoCreate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:10: 'autoCreate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:8: ( 'lookIn' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:10: 'lookIn'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("autoCreate"); 
=======
            match("lookIn"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:8: ( 'postfix' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:10: 'postfix'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:8: ( 'token' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:10: 'token'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("postfix"); 
=======
            match("token"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:8: ( 'separator' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:10: 'separator'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:8: ( 'refersTo' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:10: 'refersTo'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("separator"); 
=======
            match("refersTo"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:8: ( 'right' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:10: 'right'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:8: ( 'using' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:10: 'using'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("right"); 
=======
            match("using"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:8: ( 'operatorTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:10: 'operatorTemplate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:8: ( 'source' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:10: 'source'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("operatorTemplate"); 
=======
            match("source"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:8: ( 'abstract' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:10: 'abstract'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:8: ( 'operatorTemplate' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:10: 'operatorTemplate'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("abstract"); 
=======
            match("operatorTemplate"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:8: ( 'instanceOf' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:10: 'instanceOf'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:8: ( 'abstract' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:10: 'abstract'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("instanceOf"); 
=======
            match("abstract"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:8: ( 'disambiguate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:10: 'disambiguate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:8: ( 'true' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:10: 'true'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("disambiguate"); 
=======
            match("true"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:8: ( 'priority' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:10: 'priority'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:8: ( 'nonPrimary' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:10: 'nonPrimary'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("priority"); 
=======
            match("nonPrimary"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:8: ( 'enumerationTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:10: 'enumerationTemplate'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:8: ( 'operators' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:10: 'operators'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("enumerationTemplate"); 
=======
            match("operators"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:8: ( 'partial' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:10: 'partial'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:8: ( 'forcedUpper' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:10: 'forcedUpper'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("partial"); 
=======
            match("forcedUpper"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:8: ( 'source' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:10: 'source'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:8: ( 'storeOpTo' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:10: 'storeOpTo'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("source"); 
=======
            match("storeOpTo"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:8: ( 'referenceOnly' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:10: 'referenceOnly'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:8: ( 'context' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:10: 'context'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("referenceOnly"); 
=======
            match("context"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:8: ( 'importContext' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:10: 'importContext'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:8: ( 'when' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:10: 'when'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("importContext"); 
=======
            match("when"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:8: ( 'endNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:10: 'endNL'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:8: ( 'multi' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:10: 'multi'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("endNL"); 
=======
            match("multi"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:8: ( 'all' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:10: 'all'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:8: ( 'filter' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:10: 'filter'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("all"); 
=======
            match("filter"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:8: ( 'leftSpace' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:10: 'leftSpace'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:8: ( 'priority' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:10: 'priority'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("leftSpace"); 
=======
            match("priority"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:8: ( 'indentIncr' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:10: 'indentIncr'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:8: ( 'operatored' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:10: 'operatored'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("indentIncr"); 
=======
            match("operatored"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:8: ( 'keywords' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:10: 'keywords'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:8: ( 'drop' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:10: 'drop'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("keywords"); 
=======
            match("drop"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "T__129"
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:8: ( 'refersTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:10: 'refersTo'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:8: ( 'k' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:10: 'k'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("refersTo"); 
=======
            match('k'); 
>>>>>>> .r9710

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__129"

    // $ANTLR start "T__130"
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:8: ( 'serializer' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:10: 'serializer'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:8: ( 'invert' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:10: 'invert'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("serializer"); 
=======
            match("invert"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__130"

    // $ANTLR start "T__131"
    public final void mT__131() throws RecognitionException {
        try {
            int _type = T__131;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:8: ( 'as' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:10: 'as'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:8: ( 'orKeyword' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:10: 'orKeyword'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("as"); 
=======
            match("orKeyword"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__131"

    // $ANTLR start "T__132"
    public final void mT__132() throws RecognitionException {
        try {
            int _type = T__132;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:8: ( 'lexer' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:10: 'lexer'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:8: ( 'esc' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:10: 'esc'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("lexer"); 
=======
            match("esc"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__132"

    // $ANTLR start "T__133"
    public final void mT__133() throws RecognitionException {
        try {
            int _type = T__133;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:8: ( 'endOfLine' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:10: 'endOfLine'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:8: ( 'startNbNL' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:10: 'startNbNL'
>>>>>>> .r9710
            {
<<<<<<< .mine
            match("endOfLine"); 
=======
            match("startNbNL"); 
>>>>>>> .r9710


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__133"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1707:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1697:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:9: '--' (~ ( '\\r' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:9: '--' (~ ( '\\r' | '\\n' ) )*
>>>>>>> .r9710
            {
            match("--"); 

<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:14: (~ ( '\\r' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:14: (~ ( '\\r' | '\\n' ) )*
>>>>>>> .r9710
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1708:15: ~ ( '\\r' | '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:15: ~ ( '\\r' | '\\n' )
>>>>>>> .r9710
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

            _channel=HIDDEN;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1713:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1703:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
>>>>>>> .r9710
            {
            match("/**"); 

<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
>>>>>>> .r9710
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1714:44: ( '\\n' | ~ '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:44: ( '\\n' | ~ '\\n' )
>>>>>>> .r9710
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

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTI_LINE_COMMENT"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1719:3: ( '[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1720:3: '['
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1709:3: ( '[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1710:3: '['
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1725:3: ( ']' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1726:3: ']'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1715:3: ( ']' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1716:3: ']'
>>>>>>> .r9710
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

    // $ANTLR start "DLSQUARE"
    public final void mDLSQUARE() throws RecognitionException {
        try {
            int _type = DLSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1731:3: ( '[[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1732:3: '[['
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1721:3: ( '[[' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1722:3: '[['
>>>>>>> .r9710
            {
            match("[["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLSQUARE"

    // $ANTLR start "DRSQUARE"
    public final void mDRSQUARE() throws RecognitionException {
        try {
            int _type = DRSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1737:3: ( ']]' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1738:3: ']]'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1727:3: ( ']]' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1728:3: ']]'
>>>>>>> .r9710
            {
            match("]]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DRSQUARE"

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1743:3: ( '!' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1744:3: '!'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1733:3: ( '!' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1734:3: '!'
>>>>>>> .r9710
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

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1749:3: ( ',' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1750:3: ','
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1739:3: ( ',' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1740:3: ','
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1755:3: ( '(' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1756:3: '('
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1745:3: ( '(' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1746:3: '('
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1761:3: ( ')' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1762:3: ')'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1751:3: ( ')' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1752:3: ')'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1767:3: ( '{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1768:3: '{'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1757:3: ( '{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1758:3: '{'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1773:3: ( '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1774:3: '}'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1763:3: ( '}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1764:3: '}'
>>>>>>> .r9710
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

    // $ANTLR start "DLCURLY"
    public final void mDLCURLY() throws RecognitionException {
        try {
            int _type = DLCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1779:3: ( '{{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1780:3: '{{'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1769:3: ( '{{' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1770:3: '{{'
>>>>>>> .r9710
            {
            match("{{"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLCURLY"

    // $ANTLR start "DRCURLY"
    public final void mDRCURLY() throws RecognitionException {
        try {
            int _type = DRCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1785:3: ( '}}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1786:3: '}}'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1775:3: ( '}}' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1776:3: '}}'
>>>>>>> .r9710
            {
            match("}}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DRCURLY"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1791:3: ( ';' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1792:3: ';'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1781:3: ( ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1782:3: ';'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1797:3: ( ':' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1798:3: ':'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1787:3: ( ':' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1788:3: ':'
>>>>>>> .r9710
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

    // $ANTLR start "DLCOLON"
    public final void mDLCOLON() throws RecognitionException {
        try {
            int _type = DLCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1803:3: ( '::' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1804:3: '::'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1793:3: ( '::' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1794:3: '::'
>>>>>>> .r9710
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DLCOLON"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1809:3: ( '|' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1810:3: '|'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1799:3: ( '|' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1800:3: '|'
>>>>>>> .r9710
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

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1815:3: ( '#' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1816:3: '#'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1805:3: ( '#' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1806:3: '#'
>>>>>>> .r9710
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHARP"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1821:3: ( '?' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1822:3: '?'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1811:3: ( '?' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1812:3: '?'
>>>>>>> .r9710
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

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1827:3: ( '$' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1828:3: '$'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1817:3: ( '$' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1818:3: '$'
>>>>>>> .r9710
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "AROBAS"
    public final void mAROBAS() throws RecognitionException {
        try {
            int _type = AROBAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1833:3: ( '@' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1834:3: '@'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1823:3: ( '@' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1824:3: '@'
>>>>>>> .r9710
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AROBAS"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1839:3: ( '.' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1840:3: '.'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1829:3: ( '.' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1830:3: '.'
>>>>>>> .r9710
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

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1845:3: ( '->' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1846:3: '->'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1835:3: ( '->' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1836:3: '->'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1851:3: ( '-' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1852:3: '-'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1841:3: ( '-' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1842:3: '-'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1857:3: ( '*' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1858:3: '*'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1847:3: ( '*' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1848:3: '*'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1863:3: ( '/' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1864:3: '/'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1853:3: ( '/' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1854:3: '/'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1869:3: ( '+' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1870:3: '+'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1859:3: ( '+' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1860:3: '+'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1875:3: ( '=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1876:3: '='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1865:3: ( '=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1866:3: '='
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1881:3: ( '>' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1882:3: '>'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1871:3: ( '>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1872:3: '>'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1887:3: ( '<' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1888:3: '<'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1877:3: ( '<' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1878:3: '<'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1893:3: ( '>=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1894:3: '>='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1883:3: ( '>=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1884:3: '>='
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1899:3: ( '<=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1900:3: '<='
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1889:3: ( '<=' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1890:3: '<='
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1905:3: ( '<>' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1906:3: '<>'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1895:3: ( '<>' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1896:3: '<>'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1911:3: ( '<-' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1912:3: '<-'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1901:3: ( '<-' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1902:3: '<-'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:9: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1910:9: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1910:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1910:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
>>>>>>> .r9710
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
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:25: '\\r' '\\n'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1910:25: '\\r' '\\n'
>>>>>>> .r9710
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1921:25: '\\n' '\\r'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1911:25: '\\n' '\\r'
>>>>>>> .r9710
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1922:25: '\\r'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1912:25: '\\r'
>>>>>>> .r9710
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1923:25: '\\n'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1913:25: '\\n'
>>>>>>> .r9710
                    {
                    match('\n'); 

                    }
                    break;

            }

            newline();_channel=HIDDEN;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1929:9: ( ( ' ' | '\\t' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1929:17: ( ' ' | '\\t' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1919:9: ( ( ' ' | '\\t' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1919:17: ( ' ' | '\\t' )
>>>>>>> .r9710
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1936:9: ( '0' .. '9' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1936:17: '0' .. '9'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1926:9: ( '0' .. '9' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1926:17: '0' .. '9'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1941:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1931:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1955:9: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:9: ( ALPHA ) ( ALPHA | DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1945:9: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:9: ( ALPHA ) ( ALPHA | DIGIT )*
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:9: ( ALPHA )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:10: ALPHA
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:9: ( ALPHA )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:10: ALPHA
>>>>>>> .r9710
            {
            mALPHA(); 

            }

<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:17: ( ALPHA | DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:17: ( ALPHA | DIGIT )*
>>>>>>> .r9710
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1975:9: ( ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1975:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1965:9: ( ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1965:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1975:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1965:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
>>>>>>> .r9710
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u00FF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1976:25: SNAME
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1966:25: SNAME
>>>>>>> .r9710
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1977:25: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1967:25: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
>>>>>>> .r9710
                    {
                    match('\''); 
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1978:25: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1968:25: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
>>>>>>> .r9710
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
                        else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=3;
                        }


                        switch (alt5) {
                    	case 1 :
<<<<<<< .mine
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1978:33: ESC
=======
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1968:33: ESC
>>>>>>> .r9710
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
<<<<<<< .mine
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1979:33: '\\n'
=======
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1969:33: '\\n'
>>>>>>> .r9710
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
<<<<<<< .mine
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1980:33: ~ ( '\\\\' | '\\'' | '\\n' )
=======
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1970:33: ~ ( '\\\\' | '\\'' | '\\n' )
>>>>>>> .r9710
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
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:9: ( ( DIGIT )+ )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:17: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1982:9: ( ( DIGIT )+ )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1982:17: ( DIGIT )+
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:17: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1982:17: ( DIGIT )+
>>>>>>> .r9710
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
<<<<<<< .mine
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:18: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1982:18: DIGIT
>>>>>>> .r9710
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:9: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:17: ( DIGIT )+ '.' ( DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:9: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:17: ( DIGIT )+ '.' ( DIGIT )*
>>>>>>> .r9710
            {
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:17: ( DIGIT )+
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:17: ( DIGIT )+
>>>>>>> .r9710
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
<<<<<<< .mine
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:17: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:17: DIGIT
>>>>>>> .r9710
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

            match('.'); 
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:28: ( DIGIT )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:28: ( DIGIT )*
>>>>>>> .r9710
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:28: DIGIT
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1985:28: DIGIT
>>>>>>> .r9710
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1999:9: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1999:17: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1989:9: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1989:17: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
>>>>>>> .r9710
            {
            match('\\'); 
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2000:17: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1990:17: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
>>>>>>> .r9710
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
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2000:25: 'n'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1990:25: 'n'
>>>>>>> .r9710
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2001:25: 'r'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1991:25: 'r'
>>>>>>> .r9710
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2002:25: 't'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:25: 't'
>>>>>>> .r9710
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2003:25: 'b'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1993:25: 'b'
>>>>>>> .r9710
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2004:25: 'f'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1994:25: 'f'
>>>>>>> .r9710
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2005:25: '\"'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:25: '\"'
>>>>>>> .r9710
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2006:25: '\\''
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1996:25: '\\''
>>>>>>> .r9710
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2007:25: '\\\\'
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1997:25: '\\\\'
>>>>>>> .r9710
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2008:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1998:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
>>>>>>> .r9710
                    {
<<<<<<< .mine
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2008:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
=======
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1998:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
>>>>>>> .r9710
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>='0' && LA13_0<='3')) ) {
                        alt13=1;
                    }
                    else if ( ((LA13_0>='4' && LA13_0<='7')) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2009:33: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1999:33: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
>>>>>>> .r9710
                            {
<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2009:33: ( '0' .. '3' )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2009:34: '0' .. '3'
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1999:33: ( '0' .. '3' )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1999:34: '0' .. '3'
>>>>>>> .r9710
                            {
                            matchRange('0','3'); 

                            }

<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2010:33: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2000:33: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
>>>>>>> .r9710
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
<<<<<<< .mine
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2011:41: ( '0' .. '7' ) ( '0' .. '7' )?
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2001:41: ( '0' .. '7' ) ( '0' .. '7' )?
>>>>>>> .r9710
                                    {
<<<<<<< .mine
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2011:41: ( '0' .. '7' )
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2011:42: '0' .. '7'
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2001:41: ( '0' .. '7' )
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2001:42: '0' .. '7'
>>>>>>> .r9710
                                    {
                                    matchRange('0','7'); 

                                    }

<<<<<<< .mine
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2012:41: ( '0' .. '7' )?
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2002:41: ( '0' .. '7' )?
>>>>>>> .r9710
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
<<<<<<< .mine
                                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2013:49: '0' .. '7'
=======
                                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2003:49: '0' .. '7'
>>>>>>> .r9710
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
<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2016:33: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2006:33: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
>>>>>>> .r9710
                            {
<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2016:33: ( '4' .. '7' )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2016:34: '4' .. '7'
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2006:33: ( '4' .. '7' )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2006:34: '4' .. '7'
>>>>>>> .r9710
                            {
                            matchRange('4','7'); 

                            }

<<<<<<< .mine
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2017:33: ( ( '0' .. '7' ) )?
=======
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2007:33: ( ( '0' .. '7' ) )?
>>>>>>> .r9710
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
<<<<<<< .mine
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2018:41: ( '0' .. '7' )
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2008:41: ( '0' .. '7' )
>>>>>>> .r9710
                                    {
<<<<<<< .mine
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2018:41: ( '0' .. '7' )
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2018:42: '0' .. '7'
=======
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2008:41: ( '0' .. '7' )
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2008:42: '0' .. '7'
>>>>>>> .r9710
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
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2027:9: ( '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2027:17: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2017:9: ( '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2017:17: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
>>>>>>> .r9710
            {
            match('\"'); 
<<<<<<< .mine
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2028:17: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
=======
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2018:17: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
>>>>>>> .r9710
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
                else if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                    alt15=3;
                }


                switch (alt15) {
            	case 1 :
<<<<<<< .mine
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2028:25: ESC
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2018:25: ESC
>>>>>>> .r9710
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
<<<<<<< .mine
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2029:25: '\\n'
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2019:25: '\\n'
>>>>>>> .r9710
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
<<<<<<< .mine
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2030:25: ~ ( '\\\\' | '\\\"' | '\\n' )
=======
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:2020:25: ~ ( '\\\\' | '\\\"' | '\\n' )
>>>>>>> .r9710
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
            	    break loop15;
                }
            } while (true);

            match('\"'); 

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
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
=======
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
>>>>>>> .r9710
        int alt16=126;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:10: T__49
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:10: T__49
>>>>>>> .r9710
                {
                mT__49(); 

                }
                break;
            case 2 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:16: T__50
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:16: T__50
>>>>>>> .r9710
                {
                mT__50(); 

                }
                break;
            case 3 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:22: T__51
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:22: T__51
>>>>>>> .r9710
                {
                mT__51(); 

                }
                break;
            case 4 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:28: T__52
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:28: T__52
>>>>>>> .r9710
                {
                mT__52(); 

                }
                break;
            case 5 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:34: T__53
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:34: T__53
>>>>>>> .r9710
                {
                mT__53(); 

                }
                break;
            case 6 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:40: T__54
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:40: T__54
>>>>>>> .r9710
                {
                mT__54(); 

                }
                break;
            case 7 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:46: T__55
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:46: T__55
>>>>>>> .r9710
                {
                mT__55(); 

                }
                break;
            case 8 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:52: T__56
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:52: T__56
>>>>>>> .r9710
                {
                mT__56(); 

                }
                break;
            case 9 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:58: T__57
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:58: T__57
>>>>>>> .r9710
                {
                mT__57(); 

                }
                break;
            case 10 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:64: T__58
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:64: T__58
>>>>>>> .r9710
                {
                mT__58(); 

                }
                break;
            case 11 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:70: T__59
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:70: T__59
>>>>>>> .r9710
                {
                mT__59(); 

                }
                break;
            case 12 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:76: T__60
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:76: T__60
>>>>>>> .r9710
                {
                mT__60(); 

                }
                break;
            case 13 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:82: T__61
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:82: T__61
>>>>>>> .r9710
                {
                mT__61(); 

                }
                break;
            case 14 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:88: T__62
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:88: T__62
>>>>>>> .r9710
                {
                mT__62(); 

                }
                break;
            case 15 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:94: T__63
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:94: T__63
>>>>>>> .r9710
                {
                mT__63(); 

                }
                break;
            case 16 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:100: T__64
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:100: T__64
>>>>>>> .r9710
                {
                mT__64(); 

                }
                break;
            case 17 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:106: T__65
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:106: T__65
>>>>>>> .r9710
                {
                mT__65(); 

                }
                break;
            case 18 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:112: T__66
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:112: T__66
>>>>>>> .r9710
                {
                mT__66(); 

                }
                break;
            case 19 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:118: T__67
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:118: T__67
>>>>>>> .r9710
                {
                mT__67(); 

                }
                break;
            case 20 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:124: T__68
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:124: T__68
>>>>>>> .r9710
                {
                mT__68(); 

                }
                break;
            case 21 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:130: T__69
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:130: T__69
>>>>>>> .r9710
                {
                mT__69(); 

                }
                break;
            case 22 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:136: T__70
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:136: T__70
>>>>>>> .r9710
                {
                mT__70(); 

                }
                break;
            case 23 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:142: T__71
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:142: T__71
>>>>>>> .r9710
                {
                mT__71(); 

                }
                break;
            case 24 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:148: T__72
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:148: T__72
>>>>>>> .r9710
                {
                mT__72(); 

                }
                break;
            case 25 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:154: T__73
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:154: T__73
>>>>>>> .r9710
                {
                mT__73(); 

                }
                break;
            case 26 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:160: T__74
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:160: T__74
>>>>>>> .r9710
                {
                mT__74(); 

                }
                break;
            case 27 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:166: T__75
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:166: T__75
>>>>>>> .r9710
                {
                mT__75(); 

                }
                break;
            case 28 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:172: T__76
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:172: T__76
>>>>>>> .r9710
                {
                mT__76(); 

                }
                break;
            case 29 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:178: T__77
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:178: T__77
>>>>>>> .r9710
                {
                mT__77(); 

                }
                break;
            case 30 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:184: T__78
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:184: T__78
>>>>>>> .r9710
                {
                mT__78(); 

                }
                break;
            case 31 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:190: T__79
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:190: T__79
>>>>>>> .r9710
                {
                mT__79(); 

                }
                break;
            case 32 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:196: T__80
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:196: T__80
>>>>>>> .r9710
                {
                mT__80(); 

                }
                break;
            case 33 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:202: T__81
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:202: T__81
>>>>>>> .r9710
                {
                mT__81(); 

                }
                break;
            case 34 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:208: T__82
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:208: T__82
>>>>>>> .r9710
                {
                mT__82(); 

                }
                break;
            case 35 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:214: T__83
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:214: T__83
>>>>>>> .r9710
                {
                mT__83(); 

                }
                break;
            case 36 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:220: T__84
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:220: T__84
>>>>>>> .r9710
                {
                mT__84(); 

                }
                break;
            case 37 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:226: T__85
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:226: T__85
>>>>>>> .r9710
                {
                mT__85(); 

                }
                break;
            case 38 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:232: T__86
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:232: T__86
>>>>>>> .r9710
                {
                mT__86(); 

                }
                break;
            case 39 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:238: T__87
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:238: T__87
>>>>>>> .r9710
                {
                mT__87(); 

                }
                break;
            case 40 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:244: T__88
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:244: T__88
>>>>>>> .r9710
                {
                mT__88(); 

                }
                break;
            case 41 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:250: T__89
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:250: T__89
>>>>>>> .r9710
                {
                mT__89(); 

                }
                break;
            case 42 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:256: T__90
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:256: T__90
>>>>>>> .r9710
                {
                mT__90(); 

                }
                break;
            case 43 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:262: T__91
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:262: T__91
>>>>>>> .r9710
                {
                mT__91(); 

                }
                break;
            case 44 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:268: T__92
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:268: T__92
>>>>>>> .r9710
                {
                mT__92(); 

                }
                break;
            case 45 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:274: T__93
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:274: T__93
>>>>>>> .r9710
                {
                mT__93(); 

                }
                break;
            case 46 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:280: T__94
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:280: T__94
>>>>>>> .r9710
                {
                mT__94(); 

                }
                break;
            case 47 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:286: T__95
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:286: T__95
>>>>>>> .r9710
                {
                mT__95(); 

                }
                break;
            case 48 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:292: T__96
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:292: T__96
>>>>>>> .r9710
                {
                mT__96(); 

                }
                break;
            case 49 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:298: T__97
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:298: T__97
>>>>>>> .r9710
                {
                mT__97(); 

                }
                break;
            case 50 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:304: T__98
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:304: T__98
>>>>>>> .r9710
                {
                mT__98(); 

                }
                break;
            case 51 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:310: T__99
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:310: T__99
>>>>>>> .r9710
                {
                mT__99(); 

                }
                break;
            case 52 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:316: T__100
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:316: T__100
>>>>>>> .r9710
                {
                mT__100(); 

                }
                break;
            case 53 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:323: T__101
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:323: T__101
>>>>>>> .r9710
                {
                mT__101(); 

                }
                break;
            case 54 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:330: T__102
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:330: T__102
>>>>>>> .r9710
                {
                mT__102(); 

                }
                break;
            case 55 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:337: T__103
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:337: T__103
>>>>>>> .r9710
                {
                mT__103(); 

                }
                break;
            case 56 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:344: T__104
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:344: T__104
>>>>>>> .r9710
                {
                mT__104(); 

                }
                break;
            case 57 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:351: T__105
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:351: T__105
>>>>>>> .r9710
                {
                mT__105(); 

                }
                break;
            case 58 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:358: T__106
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:358: T__106
>>>>>>> .r9710
                {
                mT__106(); 

                }
                break;
            case 59 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:365: T__107
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:365: T__107
>>>>>>> .r9710
                {
                mT__107(); 

                }
                break;
            case 60 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:372: T__108
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:372: T__108
>>>>>>> .r9710
                {
                mT__108(); 

                }
                break;
            case 61 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:379: T__109
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:379: T__109
>>>>>>> .r9710
                {
                mT__109(); 

                }
                break;
            case 62 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:386: T__110
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:386: T__110
>>>>>>> .r9710
                {
                mT__110(); 

                }
                break;
            case 63 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:393: T__111
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:393: T__111
>>>>>>> .r9710
                {
                mT__111(); 

                }
                break;
            case 64 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:400: T__112
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:400: T__112
>>>>>>> .r9710
                {
                mT__112(); 

                }
                break;
            case 65 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:407: T__113
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:407: T__113
>>>>>>> .r9710
                {
                mT__113(); 

                }
                break;
            case 66 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:414: T__114
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:414: T__114
>>>>>>> .r9710
                {
                mT__114(); 

                }
                break;
            case 67 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:421: T__115
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:421: T__115
>>>>>>> .r9710
                {
                mT__115(); 

                }
                break;
            case 68 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:428: T__116
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:428: T__116
>>>>>>> .r9710
                {
                mT__116(); 

                }
                break;
            case 69 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:435: T__117
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:435: T__117
>>>>>>> .r9710
                {
                mT__117(); 

                }
                break;
            case 70 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:442: T__118
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:442: T__118
>>>>>>> .r9710
                {
                mT__118(); 

                }
                break;
            case 71 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:449: T__119
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:449: T__119
>>>>>>> .r9710
                {
                mT__119(); 

                }
                break;
            case 72 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:456: T__120
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:456: T__120
>>>>>>> .r9710
                {
                mT__120(); 

                }
                break;
            case 73 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:463: T__121
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:463: T__121
>>>>>>> .r9710
                {
                mT__121(); 

                }
                break;
            case 74 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:470: T__122
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:470: T__122
>>>>>>> .r9710
                {
                mT__122(); 

                }
                break;
            case 75 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:477: T__123
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:477: T__123
>>>>>>> .r9710
                {
                mT__123(); 

                }
                break;
            case 76 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:484: T__124
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:484: T__124
>>>>>>> .r9710
                {
                mT__124(); 

                }
                break;
            case 77 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:491: T__125
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:491: T__125
>>>>>>> .r9710
                {
                mT__125(); 

                }
                break;
            case 78 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:498: T__126
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:498: T__126
>>>>>>> .r9710
                {
                mT__126(); 

                }
                break;
            case 79 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:505: T__127
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:505: T__127
>>>>>>> .r9710
                {
                mT__127(); 

                }
                break;
            case 80 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:512: T__128
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:512: T__128
>>>>>>> .r9710
                {
                mT__128(); 

                }
                break;
            case 81 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:519: T__129
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:519: T__129
>>>>>>> .r9710
                {
                mT__129(); 

                }
                break;
            case 82 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:526: T__130
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:526: T__130
>>>>>>> .r9710
                {
                mT__130(); 

                }
                break;
            case 83 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:533: T__131
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:533: T__131
>>>>>>> .r9710
                {
                mT__131(); 

                }
                break;
            case 84 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:540: T__132
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:540: T__132
>>>>>>> .r9710
                {
                mT__132(); 

                }
                break;
            case 85 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:547: T__133
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:547: T__133
>>>>>>> .r9710
                {
                mT__133(); 

                }
                break;
            case 86 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:554: COMMENT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:554: COMMENT
>>>>>>> .r9710
                {
                mCOMMENT(); 

                }
                break;
            case 87 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:562: MULTI_LINE_COMMENT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:562: MULTI_LINE_COMMENT
>>>>>>> .r9710
                {
                mMULTI_LINE_COMMENT(); 

                }
                break;
            case 88 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:581: LSQUARE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:581: LSQUARE
>>>>>>> .r9710
                {
                mLSQUARE(); 

                }
                break;
            case 89 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:589: RSQUARE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:589: RSQUARE
>>>>>>> .r9710
                {
                mRSQUARE(); 

                }
                break;
            case 90 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:597: DLSQUARE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:597: DLSQUARE
>>>>>>> .r9710
                {
                mDLSQUARE(); 

                }
                break;
            case 91 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:606: DRSQUARE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:606: DRSQUARE
>>>>>>> .r9710
                {
                mDRSQUARE(); 

                }
                break;
            case 92 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:615: EXCL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:615: EXCL
>>>>>>> .r9710
                {
                mEXCL(); 

                }
                break;
            case 93 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:620: COMA
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:620: COMA
>>>>>>> .r9710
                {
                mCOMA(); 

                }
                break;
            case 94 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:625: LPAREN
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:625: LPAREN
>>>>>>> .r9710
                {
                mLPAREN(); 

                }
                break;
            case 95 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:632: RPAREN
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:632: RPAREN
>>>>>>> .r9710
                {
                mRPAREN(); 

                }
                break;
            case 96 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:639: LCURLY
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:639: LCURLY
>>>>>>> .r9710
                {
                mLCURLY(); 

                }
                break;
            case 97 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:646: RCURLY
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:646: RCURLY
>>>>>>> .r9710
                {
                mRCURLY(); 

                }
                break;
            case 98 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:653: DLCURLY
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:653: DLCURLY
>>>>>>> .r9710
                {
                mDLCURLY(); 

                }
                break;
            case 99 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:661: DRCURLY
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:661: DRCURLY
>>>>>>> .r9710
                {
                mDRCURLY(); 

                }
                break;
            case 100 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:669: SEMI
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:669: SEMI
>>>>>>> .r9710
                {
                mSEMI(); 

                }
                break;
            case 101 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:674: COLON
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:674: COLON
>>>>>>> .r9710
                {
                mCOLON(); 

                }
                break;
            case 102 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:680: DLCOLON
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:680: DLCOLON
>>>>>>> .r9710
                {
                mDLCOLON(); 

                }
                break;
            case 103 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:688: PIPE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:688: PIPE
>>>>>>> .r9710
                {
                mPIPE(); 

                }
                break;
            case 104 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:693: SHARP
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:693: SHARP
>>>>>>> .r9710
                {
                mSHARP(); 

                }
                break;
            case 105 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:699: QMARK
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:699: QMARK
>>>>>>> .r9710
                {
                mQMARK(); 

                }
                break;
            case 106 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:705: DOLLAR
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:705: DOLLAR
>>>>>>> .r9710
                {
                mDOLLAR(); 

                }
                break;
            case 107 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:712: AROBAS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:712: AROBAS
>>>>>>> .r9710
                {
                mAROBAS(); 

                }
                break;
            case 108 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:719: POINT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:719: POINT
>>>>>>> .r9710
                {
                mPOINT(); 

                }
                break;
            case 109 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:725: RARROW
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:725: RARROW
>>>>>>> .r9710
                {
                mRARROW(); 

                }
                break;
            case 110 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:732: MINUS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:732: MINUS
>>>>>>> .r9710
                {
                mMINUS(); 

                }
                break;
            case 111 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:738: STAR
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:738: STAR
>>>>>>> .r9710
                {
                mSTAR(); 

                }
                break;
            case 112 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:743: SLASH
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:743: SLASH
>>>>>>> .r9710
                {
                mSLASH(); 

                }
                break;
            case 113 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:749: PLUS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:749: PLUS
>>>>>>> .r9710
                {
                mPLUS(); 

                }
                break;
            case 114 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:754: EQ
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:754: EQ
>>>>>>> .r9710
                {
                mEQ(); 

                }
                break;
            case 115 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:757: GT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:757: GT
>>>>>>> .r9710
                {
                mGT(); 

                }
                break;
            case 116 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:760: LT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:760: LT
>>>>>>> .r9710
                {
                mLT(); 

                }
                break;
            case 117 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:763: GE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:763: GE
>>>>>>> .r9710
                {
                mGE(); 

                }
                break;
            case 118 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:766: LE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:766: LE
>>>>>>> .r9710
                {
                mLE(); 

                }
                break;
            case 119 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:769: NE
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:769: NE
>>>>>>> .r9710
                {
                mNE(); 

                }
                break;
            case 120 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:772: LARROW
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:772: LARROW
>>>>>>> .r9710
                {
                mLARROW(); 

                }
                break;
            case 121 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:779: NL
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:779: NL
>>>>>>> .r9710
                {
                mNL(); 

                }
                break;
            case 122 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:782: WS
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:782: WS
>>>>>>> .r9710
                {
                mWS(); 

                }
                break;
            case 123 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:785: NAME
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:785: NAME
>>>>>>> .r9710
                {
                mNAME(); 

                }
                break;
            case 124 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:790: INT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:790: INT
>>>>>>> .r9710
                {
                mINT(); 

                }
                break;
            case 125 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:794: FLOAT
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:794: FLOAT
>>>>>>> .r9710
                {
                mFLOAT(); 

                }
                break;
            case 126 :
<<<<<<< .mine
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:800: STRING
=======
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:800: STRING
>>>>>>> .r9710
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
<<<<<<< .mine
        "\1\uffff\6\56\1\106\15\56\1\151\1\153\1\155\1\157\4\uffff\1\161"+
=======
        "\1\uffff\17\56\1\136\4\56\1\151\1\153\1\155\1\157\4\uffff\1\161"+
>>>>>>> .r9710
        "\1\163\1\uffff\1\165\11\uffff\1\167\1\173\3\uffff\1\174\1\uffff"+
<<<<<<< .mine
        "\5\56\1\u0084\17\56\1\uffff\40\56\27\uffff\1\u00bd\1\56\1\u00bf"+
        "\3\56\1\uffff\4\56\1\u00c9\17\56\1\u00d9\15\56\1\u00e9\1\56\1\u00eb"+
        "\16\56\1\u00fb\4\56\1\uffff\1\56\1\uffff\1\56\1\u0103\2\56\1\u0106"+
        "\4\56\1\uffff\4\56\1\u010f\3\56\1\u0115\6\56\1\uffff\17\56\1\uffff"+
        "\1\56\1\uffff\1\u012c\1\u012d\2\56\1\u0130\1\u0131\3\56\1\u0136"+
        "\2\56\1\u0139\1\u013a\1\56\1\uffff\7\56\1\uffff\2\56\1\uffff\1\u0145"+
        "\1\u0146\6\56\1\uffff\1\u014d\4\56\1\uffff\1\u0152\2\56\1\u0155"+
        "\4\56\1\u015b\12\56\1\u0167\2\56\2\uffff\1\u016b\1\u016c\2\uffff"+
        "\4\56\1\uffff\2\56\2\uffff\1\56\1\u0176\1\56\1\u0179\1\u017a\1\u017b"+
        "\4\56\2\uffff\2\56\1\u0183\3\56\1\uffff\1\56\1\u0189\2\56\1\uffff"+
        "\2\56\1\uffff\2\56\1\u0190\2\56\1\uffff\4\56\1\u0198\1\u0199\5\56"+
        "\1\uffff\3\56\2\uffff\2\56\1\u01a4\6\56\1\uffff\2\56\3\uffff\6\56"+
        "\1\u01b3\1\uffff\3\56\1\u01b7\1\56\1\uffff\5\56\1\u01be\1\uffff"+
        "\1\u01bf\1\u01c0\5\56\2\uffff\12\56\1\uffff\1\u01d0\1\u01d1\1\56"+
        "\1\u01d3\6\56\1\u01da\1\u01db\2\56\1\uffff\1\u01de\1\u01df\1\u01e0"+
        "\1\uffff\1\56\1\u01e2\1\56\1\u01e4\2\56\3\uffff\16\56\1\u01f7\2"+
        "\uffff\1\56\1\uffff\3\56\1\u01fc\2\56\2\uffff\2\56\3\uffff\1\56"+
        "\1\uffff\1\u0202\1\uffff\1\u0203\1\56\1\u0205\1\56\1\u0207\1\56"+
        "\1\u0209\1\u020a\3\56\1\u020e\1\u020f\1\56\1\u0211\1\56\1\u0213"+
        "\1\56\1\uffff\2\56\1\u0217\1\56\1\uffff\1\56\1\u021a\2\56\1\u021d"+
        "\2\uffff\1\u021e\1\uffff\1\56\1\uffff\1\56\2\uffff\1\u0221\1\u0222"+
        "\1\u0223\2\uffff\1\56\1\uffff\1\56\1\uffff\2\56\1\u0228\1\uffff"+
        "\2\56\1\uffff\1\u022b\1\u022c\2\uffff\2\56\3\uffff\4\56\1\uffff"+
        "\1\56\1\u0234\2\uffff\1\56\1\u0236\3\56\1\u023b\1\56\1\uffff\1\56"+
        "\1\uffff\1\u023e\3\56\1\uffff\1\u0242\1\56\1\uffff\2\56\1\u0246"+
        "\1\uffff\3\56\1\uffff\1\u024a\2\56\1\uffff\1\56\1\u024e\1\56\1\uffff"+
        "\1\u0250\1\uffff";
=======
        "\16\56\1\u008f\36\56\1\uffff\10\56\27\uffff\12\56\1\u00c7\3\56\1"+
        "\u00cb\2\56\1\uffff\1\u00ce\5\56\1\u00d6\1\56\1\u00d8\3\56\1\u00de"+
        "\26\56\1\u00f6\23\56\1\uffff\3\56\1\uffff\1\56\1\u010f\1\uffff\2"+
        "\56\1\u0114\4\56\1\uffff\1\56\1\uffff\1\u011a\1\u011b\3\56\1\uffff"+
        "\4\56\1\u0123\1\u0124\2\56\1\u0127\3\56\1\u012c\12\56\1\uffff\2"+
        "\56\1\u0139\2\56\1\u013c\1\u013d\13\56\1\u0149\5\56\1\uffff\1\56"+
        "\1\u0150\2\56\1\uffff\1\u0153\1\56\1\u0155\2\56\2\uffff\1\u0158"+
        "\5\56\1\u015e\2\uffff\2\56\1\uffff\4\56\1\uffff\1\56\1\u0167\6\56"+
        "\1\u0171\2\56\1\u0175\1\uffff\1\56\1\u0178\2\uffff\1\u0179\1\u017a"+
        "\2\56\1\u017d\6\56\1\uffff\3\56\1\u0188\2\56\1\uffff\2\56\1\uffff"+
        "\1\u018d\1\uffff\2\56\1\uffff\3\56\1\u0194\1\56\1\uffff\4\56\1\u019a"+
        "\3\56\1\uffff\4\56\1\u01a3\1\56\1\u01a5\2\56\1\uffff\3\56\1\uffff"+
        "\2\56\3\uffff\2\56\1\uffff\5\56\1\u01b4\1\u01b5\3\56\1\uffff\4\56"+
        "\1\uffff\2\56\1\u01bf\3\56\1\uffff\1\56\1\u01c4\3\56\1\uffff\1\u01c8"+
        "\1\u01c9\1\u01ca\5\56\1\uffff\1\u01d0\1\uffff\14\56\1\u01dd\1\u01de"+
        "\2\uffff\4\56\1\u01e5\1\56\1\u01e7\2\56\1\uffff\2\56\1\u01ec\1\u01ed"+
        "\1\uffff\2\56\1\u01f0\3\uffff\5\56\1\uffff\3\56\1\u01f9\1\u01fa"+
        "\4\56\1\u01ff\1\56\1\u0201\2\uffff\1\56\1\u0203\1\56\1\u0205\2\56"+
        "\1\uffff\1\u0208\1\uffff\1\u0209\3\56\2\uffff\2\56\1\uffff\1\u020f"+
        "\1\56\1\u0211\1\56\1\u0213\1\56\1\u0215\1\56\2\uffff\1\56\1\u0218"+
        "\1\u0219\1\u021a\1\uffff\1\56\1\uffff\1\56\1\uffff\1\u021d\1\uffff"+
        "\1\56\1\u021f\2\uffff\5\56\1\uffff\1\56\1\uffff\1\u0226\1\uffff"+
        "\1\u0227\1\uffff\1\56\1\u0229\3\uffff\2\56\1\uffff\1\56\1\uffff"+
        "\1\56\1\u022e\1\u022f\3\56\2\uffff\1\56\1\uffff\2\56\1\u0236\1\56"+
        "\2\uffff\1\u0239\1\56\1\u023b\1\56\1\u023d\1\56\1\uffff\2\56\1\uffff"+
        "\1\56\1\uffff\1\u0242\1\uffff\2\56\1\u0245\1\56\1\uffff\2\56\1\uffff"+
        "\1\56\1\u024a\2\56\1\uffff\1\56\1\u024e\1\56\1\uffff\1\u0250\1\uffff";
>>>>>>> .r9710
    static final String DFA16_eofS =
        "\u0251\uffff";
    static final String DFA16_minS =
<<<<<<< .mine
        "\1\11\1\142\1\145\1\141\1\157\1\142\1\145\1\60\1\143\1\145\1\146"+
        "\1\156\1\141\1\163\1\150\1\141\3\145\1\165\1\141\1\55\1\52\1\133"+
        "\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\55\3\uffff"+
        "\1\56\1\uffff\1\144\1\154\1\144\1\164\1\163\1\60\1\155\1\165\1\153"+
        "\1\154\1\162\1\154\1\156\1\145\1\156\1\116\1\166\1\156\1\157\1\146"+
        "\1\171\1\uffff\1\113\1\164\1\145\1\151\1\145\1\155\1\141\1\160\1"+
        "\165\1\144\1\155\1\104\1\160\1\144\1\143\1\151\1\144\1\154\1\151"+
        "\1\145\1\162\1\145\1\162\2\163\1\157\1\145\1\170\1\147\1\146\1\145"+
        "\1\154\27\uffff\1\60\1\141\1\60\1\124\1\157\1\164\1\uffff\1\160"+
        "\2\145\1\163\1\60\1\164\1\143\1\141\1\164\1\114\1\145\1\120\1\153"+
        "\1\164\1\145\1\167\1\145\1\141\1\162\1\164\1\60\1\164\1\142\2\162"+
        "\1\141\1\151\1\162\1\145\1\164\1\145\1\151\1\145\1\157\1\60\1\155"+
        "\1\60\1\156\1\145\1\164\2\156\1\144\1\155\1\146\2\164\1\141\2\160"+
        "\1\141\1\60\1\150\1\145\1\162\1\165\1\uffff\1\171\1\uffff\1\157"+
        "\1\60\1\162\1\154\1\60\1\156\2\145\1\141\1\uffff\1\145\2\164\1\145"+
        "\1\60\2\162\1\111\1\60\1\162\1\157\1\171\1\154\1\141\1\164\1\uffff"+
        "\1\141\1\157\1\164\1\145\1\162\1\141\1\143\1\162\1\141\1\156\1\163"+
        "\1\146\1\162\1\114\1\146\1\uffff\1\145\1\uffff\2\60\1\151\1\147"+
        "\2\60\1\151\1\162\1\151\1\60\1\146\1\155\2\60\1\165\1\uffff\1\164"+
        "\1\162\1\171\1\145\1\163\1\103\1\162\1\uffff\2\141\1\uffff\2\60"+
        "\1\144\1\143\1\162\1\151\1\145\1\170\1\uffff\1\60\1\151\1\156\1"+
        "\157\1\160\1\uffff\1\60\1\162\1\167\1\60\1\164\1\145\1\170\1\154"+
        "\1\60\1\117\1\141\1\154\1\145\1\164\1\156\1\164\1\163\1\151\1\164"+
        "\1\60\1\114\1\162\2\uffff\2\60\2\uffff\1\164\1\151\1\170\1\141\1"+
        "\uffff\1\151\1\142\2\uffff\1\154\1\60\1\145\3\60\1\157\1\145\1\143"+
        "\1\164\2\uffff\1\114\1\150\1\60\1\157\1\101\1\164\1\uffff\1\155"+
        "\1\60\1\156\1\141\1\uffff\1\144\1\157\1\uffff\1\157\1\144\1\60\1"+
        "\163\1\114\1\uffff\1\151\1\160\1\164\1\151\2\60\1\143\1\111\1\151"+
        "\1\156\1\103\1\uffff\1\151\1\141\1\151\2\uffff\1\151\1\164\1\60"+
        "\1\154\1\170\1\151\1\164\1\160\1\157\1\uffff\1\156\1\124\3\uffff"+
        "\1\156\1\141\1\164\1\145\1\157\1\160\1\60\1\uffff\2\156\1\163\1"+
        "\60\1\141\1\uffff\1\145\1\143\1\163\2\162\1\60\1\uffff\2\60\1\116"+
        "\1\147\1\124\1\157\1\172\2\uffff\1\145\2\156\1\145\1\157\1\156\1"+
        "\164\1\156\1\166\1\171\1\uffff\2\60\1\147\1\60\1\141\1\156\1\143"+
        "\1\157\2\164\2\60\1\167\1\160\1\uffff\3\60\1\uffff\1\162\1\60\1"+
        "\145\1\60\1\144\1\124\3\uffff\1\114\1\150\1\157\1\162\1\145\1\117"+
        "\1\143\1\147\1\144\1\156\1\145\1\151\2\145\1\60\2\uffff\1\165\1"+
        "\uffff\1\143\2\145\1\60\2\145\2\uffff\2\145\3\uffff\1\171\1\uffff"+
        "\1\60\1\uffff\1\60\1\144\1\60\1\145\1\60\1\164\2\60\1\162\1\146"+
        "\1\162\2\60\1\164\1\60\1\157\1\60\1\124\1\uffff\1\141\1\145\1\60"+
        "\1\117\1\uffff\1\170\1\60\2\162\1\60\2\uffff\1\60\1\uffff\1\155"+
        "\1\uffff\1\124\2\uffff\3\60\2\uffff\1\145\1\uffff\1\156\1\uffff"+
        "\1\145\1\164\1\60\1\uffff\1\156\1\164\1\uffff\2\60\2\uffff\1\160"+
        "\1\157\3\uffff\1\170\1\124\1\155\1\145\1\uffff\1\154\1\60\2\uffff"+
        "\1\154\1\60\1\164\1\145\1\160\1\60\1\171\1\uffff\1\141\1\uffff\1"+
        "\60\1\155\1\154\1\63\1\uffff\1\60\1\164\1\uffff\1\160\1\141\1\60"+
        "\1\uffff\1\145\1\154\1\164\1\uffff\1\60\1\141\1\145\1\uffff\1\164"+
        "\1\60\1\145\1\uffff\1\60\1\uffff";
=======
        "\1\11\1\146\1\157\1\143\1\142\1\141\1\145\1\156\1\150\1\141\2\145"+
        "\1\141\3\145\1\60\1\142\1\141\1\165\1\163\1\55\1\52\1\133\1\135"+
        "\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\55\3\uffff\1\56"+
        "\1\uffff\1\144\1\155\1\160\1\104\1\145\1\156\1\151\1\164\2\145\1"+
        "\113\1\144\1\154\1\164\1\60\1\144\1\163\1\154\1\146\1\157\1\144"+
        "\1\143\1\162\1\145\1\154\1\162\1\156\1\154\1\155\1\153\1\165\1\145"+
        "\1\163\1\157\1\145\1\162\1\163\1\141\1\160\1\155\1\165\1\147\1\146"+
        "\1\170\1\171\1\uffff\1\166\1\116\1\156\1\154\1\151\1\144\1\145\1"+
        "\151\27\uffff\1\164\2\145\1\151\1\157\1\145\1\141\2\164\1\141\1"+
        "\60\1\162\1\145\1\124\1\60\1\141\1\157\1\uffff\1\60\1\164\1\165"+
        "\1\164\1\145\1\153\1\60\1\155\1\60\1\144\1\156\1\163\1\60\1\143"+
        "\1\164\1\160\2\145\1\160\2\141\1\160\1\155\1\146\2\164\2\162\1\151"+
        "\1\141\1\164\1\142\1\162\1\150\1\145\1\60\1\167\1\145\1\114\1\120"+
        "\1\164\1\156\1\145\1\162\1\156\1\141\1\156\1\162\1\163\1\162\1\146"+
        "\1\164\1\145\1\164\1\154\1\uffff\1\141\1\171\1\157\1\uffff\1\171"+
        "\1\60\1\uffff\1\162\1\145\1\60\1\162\1\111\1\114\1\146\1\uffff\1"+
        "\145\1\uffff\2\60\1\145\1\141\1\145\1\uffff\1\164\1\145\1\154\1"+
        "\156\2\60\1\165\1\155\1\60\1\151\1\162\1\151\1\60\1\146\1\164\1"+
        "\145\1\141\1\162\1\141\1\157\1\143\1\164\1\162\1\uffff\1\157\1\162"+
        "\1\60\1\162\1\151\2\60\1\171\1\147\1\156\2\164\1\163\1\164\1\151"+
        "\1\145\1\170\1\145\1\60\1\164\1\167\1\103\1\163\1\162\1\uffff\1"+
        "\141\1\60\1\160\1\157\1\uffff\1\60\1\156\1\60\1\114\1\162\2\uffff"+
        "\1\60\1\143\1\144\1\151\1\162\1\141\1\60\2\uffff\1\154\1\142\1\uffff"+
        "\1\164\1\151\1\170\1\141\1\uffff\1\151\1\60\1\117\1\154\1\141\1"+
        "\170\1\154\1\145\1\60\1\145\1\162\1\60\1\uffff\1\151\1\60\2\uffff"+
        "\2\60\1\143\1\111\1\60\1\151\1\103\1\156\1\101\1\164\1\144\1\uffff"+
        "\3\157\1\60\1\145\1\143\1\uffff\1\141\1\156\1\uffff\1\60\1\uffff"+
        "\1\151\1\141\1\uffff\1\150\1\114\1\157\1\60\1\164\1\uffff\1\164"+
        "\2\151\1\164\1\60\1\154\1\170\1\114\1\uffff\1\151\1\160\1\151\1"+
        "\164\1\60\1\163\1\60\1\160\1\157\1\uffff\1\156\1\124\1\144\1\uffff"+
        "\1\155\1\151\3\uffff\1\145\1\156\1\uffff\1\156\1\157\1\145\1\156"+
        "\1\163\2\60\2\162\1\156\1\uffff\1\141\1\164\1\143\1\145\1\uffff"+
        "\1\156\1\164\1\60\1\157\1\160\1\156\1\uffff\1\145\1\60\1\147\1\166"+
        "\1\171\1\uffff\3\60\1\116\1\147\1\124\1\172\1\157\1\uffff\1\60\1"+
        "\uffff\1\141\1\156\1\143\1\157\1\163\1\141\1\156\1\117\1\143\1\147"+
        "\1\156\1\144\2\60\2\uffff\1\124\1\144\2\164\1\60\1\145\1\60\1\145"+
        "\1\151\1\uffff\1\167\1\160\2\60\1\uffff\1\165\1\145\1\60\3\uffff"+
        "\1\114\1\150\1\157\1\145\1\162\1\uffff\1\143\2\145\2\60\1\162\1"+
        "\145\1\146\1\162\1\60\1\164\1\60\2\uffff\1\145\1\60\1\144\1\60\2"+
        "\145\1\uffff\1\60\1\uffff\1\60\1\157\2\145\2\uffff\1\141\1\124\1"+
        "\uffff\1\60\1\164\1\60\1\162\1\60\1\145\1\60\1\117\2\uffff\1\171"+
        "\3\60\1\uffff\1\145\1\uffff\1\155\1\uffff\1\60\1\uffff\1\170\1\60"+
        "\2\uffff\1\156\2\162\1\164\1\145\1\uffff\1\124\1\uffff\1\60\1\uffff"+
        "\1\60\1\uffff\1\156\1\60\3\uffff\1\170\1\160\1\uffff\1\164\1\uffff"+
        "\1\124\2\60\1\145\1\155\1\157\2\uffff\1\154\1\uffff\1\164\1\154"+
        "\1\60\1\145\2\uffff\1\60\1\160\1\60\1\171\1\60\1\141\1\uffff\1\155"+
        "\1\63\1\uffff\1\154\1\uffff\1\60\1\uffff\1\164\1\160\1\60\1\141"+
        "\1\uffff\1\145\1\154\1\uffff\1\164\1\60\1\141\1\145\1\uffff\1\164"+
        "\1\60\1\145\1\uffff\1\60\1\uffff";
>>>>>>> .r9710
    static final String DFA16_maxS =
<<<<<<< .mine
        "\1\u00ff\1\165\1\162\1\165\1\162\2\157\1\u00ff\1\162\1\171\2\163"+
        "\1\165\1\163\1\157\2\162\1\145\1\151\1\165\1\141\1\76\1\52\1\133"+
        "\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\76\3\uffff"+
        "\1\71\1\uffff\1\144\1\167\1\144\1\164\1\163\1\u00ff\1\155\1\165"+
        "\1\153\1\154\1\162\1\154\1\156\1\145\1\156\1\116\1\166\1\156\1\157"+
        "\1\170\1\171\1\uffff\1\113\1\164\1\145\1\151\1\145\1\156\1\157\1"+
        "\162\1\165\1\166\1\155\1\104\1\160\1\165\1\143\1\151\1\144\1\154"+
        "\1\151\1\145\1\162\1\151\1\162\2\163\1\157\1\146\1\170\1\147\1\146"+
        "\1\145\1\154\27\uffff\1\u00ff\1\141\1\u00ff\1\124\1\157\1\164\1"+
        "\uffff\1\160\2\145\1\163\1\u00ff\1\164\1\143\1\141\1\164\1\114\1"+
        "\145\1\120\1\153\1\164\1\145\1\167\1\145\1\141\1\162\1\164\1\u00ff"+
        "\1\164\1\142\2\162\1\141\1\151\1\162\1\145\1\164\1\145\1\151\1\145"+
        "\1\157\1\u00ff\1\155\1\u00ff\1\156\1\145\1\164\2\156\1\144\1\157"+
        "\1\146\2\164\1\141\2\160\1\141\1\u00ff\1\150\1\145\1\162\1\165\1"+
        "\uffff\1\171\1\uffff\1\157\1\u00ff\1\162\1\154\1\u00ff\1\156\2\145"+
        "\1\141\1\uffff\1\145\2\164\1\145\1\u00ff\2\162\1\111\1\u00ff\1\162"+
        "\1\157\1\171\1\154\1\141\1\164\1\uffff\1\141\1\157\1\164\1\145\1"+
        "\162\1\141\1\143\1\162\1\141\1\156\1\163\1\146\1\162\1\114\1\146"+
        "\1\uffff\1\145\1\uffff\2\u00ff\1\151\1\147\2\u00ff\1\151\1\162\1"+
        "\151\1\u00ff\1\146\1\155\2\u00ff\1\165\1\uffff\1\164\1\162\1\171"+
        "\1\145\1\163\1\103\1\162\1\uffff\2\141\1\uffff\2\u00ff\1\144\1\143"+
        "\1\162\1\151\1\145\1\170\1\uffff\1\u00ff\1\151\1\156\1\157\1\160"+
        "\1\uffff\1\u00ff\1\162\1\167\1\u00ff\1\164\1\145\1\170\1\154\1\u00ff"+
        "\1\122\1\141\1\154\1\145\1\164\1\156\1\164\1\163\1\151\1\164\1\u00ff"+
        "\1\114\1\162\2\uffff\2\u00ff\2\uffff\1\164\1\151\1\170\1\141\1\uffff"+
        "\1\151\1\142\2\uffff\1\154\1\u00ff\1\163\3\u00ff\1\157\1\145\1\143"+
        "\1\164\2\uffff\1\125\1\150\1\u00ff\1\157\1\111\1\164\1\uffff\1\155"+
        "\1\u00ff\1\156\1\141\1\uffff\1\144\1\157\1\uffff\1\157\1\144\1\u00ff"+
        "\1\163\1\142\1\uffff\1\151\1\160\1\164\1\151\2\u00ff\1\143\1\111"+
        "\1\151\1\156\1\103\1\uffff\1\151\1\141\1\151\2\uffff\1\151\1\164"+
        "\1\u00ff\1\154\1\170\1\151\1\164\1\160\1\157\1\uffff\1\156\1\124"+
        "\3\uffff\1\156\1\141\1\164\1\145\1\157\1\160\1\u00ff\1\uffff\2\156"+
        "\1\163\1\u00ff\1\141\1\uffff\1\145\1\143\1\163\2\162\1\u00ff\1\uffff"+
        "\2\u00ff\1\116\1\147\1\124\1\157\1\172\2\uffff\1\145\2\156\1\145"+
        "\1\157\1\156\1\164\1\156\1\166\1\171\1\uffff\2\u00ff\1\147\1\u00ff"+
        "\1\141\1\156\1\143\1\157\2\164\2\u00ff\1\167\1\160\1\uffff\3\u00ff"+
        "\1\uffff\1\162\1\u00ff\1\145\1\u00ff\1\144\1\163\3\uffff\1\114\1"+
        "\150\1\157\1\162\1\145\1\117\1\143\1\147\1\144\1\156\1\145\1\151"+
        "\2\145\1\u00ff\2\uffff\1\165\1\uffff\1\143\2\145\1\u00ff\2\145\2"+
        "\uffff\2\145\3\uffff\1\171\1\uffff\1\u00ff\1\uffff\1\u00ff\1\144"+
        "\1\u00ff\1\145\1\u00ff\1\164\2\u00ff\1\162\1\146\1\162\2\u00ff\1"+
        "\164\1\u00ff\1\157\1\u00ff\1\124\1\uffff\1\141\1\145\1\u00ff\1\117"+
        "\1\uffff\1\170\1\u00ff\2\162\1\u00ff\2\uffff\1\u00ff\1\uffff\1\155"+
        "\1\uffff\1\124\2\uffff\3\u00ff\2\uffff\1\145\1\uffff\1\156\1\uffff"+
        "\1\145\1\164\1\u00ff\1\uffff\1\156\1\164\1\uffff\2\u00ff\2\uffff"+
        "\1\160\1\157\3\uffff\1\170\1\124\1\155\1\145\1\uffff\1\154\1\u00ff"+
        "\2\uffff\1\154\1\u00ff\1\164\1\145\1\160\1\u00ff\1\171\1\uffff\1"+
        "\141\1\uffff\1\u00ff\1\155\1\154\1\63\1\uffff\1\u00ff\1\164\1\uffff"+
        "\1\160\1\141\1\u00ff\1\uffff\1\145\1\154\1\164\1\uffff\1\u00ff\1"+
        "\141\1\145\1\uffff\1\164\1\u00ff\1\145\1\uffff\1\u00ff\1\uffff";
=======
        "\1\u00ff\1\163\2\162\1\165\1\141\1\157\1\163\1\157\1\165\3\162"+
        "\1\171\1\151\1\145\1\u00ff\1\157\2\165\1\163\1\76\1\52\1\133\1\135"+
        "\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\76\3\uffff\1\71"+
        "\1\uffff\1\166\1\155\1\160\1\104\1\145\1\156\1\151\1\164\2\145\1"+
        "\113\1\144\1\167\1\164\1\u00ff\1\144\1\163\1\154\1\170\1\157\1\165"+
        "\1\143\1\162\1\145\1\154\1\162\1\156\1\154\1\155\1\153\1\165\1\146"+
        "\1\163\1\157\1\151\1\162\1\163\1\157\1\162\1\156\1\165\1\147\1\146"+
        "\1\170\1\171\1\uffff\1\166\1\116\1\156\1\154\1\151\1\144\1\145\1"+
        "\151\27\uffff\1\164\2\145\1\151\1\157\1\145\1\141\2\164\1\141\1"+
        "\u00ff\1\162\1\145\1\124\1\u00ff\1\141\1\157\1\uffff\1\u00ff\1\164"+
        "\1\165\1\164\1\145\1\153\1\u00ff\1\155\1\u00ff\1\144\1\156\1\163"+
        "\1\u00ff\1\143\1\164\1\160\2\145\1\160\2\141\1\160\1\157\1\146\2"+
        "\164\2\162\1\151\1\141\1\164\1\142\1\162\1\150\1\145\1\u00ff\1\167"+
        "\1\145\1\114\1\120\1\164\1\156\1\145\1\162\1\156\1\141\1\156\1\162"+
        "\1\163\1\162\1\146\1\164\1\145\1\164\1\154\1\uffff\1\141\1\171\1"+
        "\157\1\uffff\1\171\1\u00ff\1\uffff\1\162\1\145\1\u00ff\1\162\1\111"+
        "\1\114\1\146\1\uffff\1\145\1\uffff\2\u00ff\1\145\1\141\1\145\1\uffff"+
        "\1\164\1\145\1\154\1\156\2\u00ff\1\165\1\155\1\u00ff\1\151\1\162"+
        "\1\151\1\u00ff\1\146\1\164\1\145\1\141\1\162\1\141\1\157\1\143\1"+
        "\164\1\162\1\uffff\1\157\1\162\1\u00ff\1\162\1\151\2\u00ff\1\171"+
        "\1\147\1\156\2\164\1\163\1\164\1\151\1\145\1\170\1\145\1\u00ff\1"+
        "\164\1\167\1\103\1\163\1\162\1\uffff\1\141\1\u00ff\1\160\1\157\1"+
        "\uffff\1\u00ff\1\156\1\u00ff\1\114\1\162\2\uffff\1\u00ff\1\143\1"+
        "\144\1\151\1\162\1\141\1\u00ff\2\uffff\1\154\1\142\1\uffff\1\164"+
        "\1\151\1\170\1\141\1\uffff\1\151\1\u00ff\1\122\1\154\1\141\1\170"+
        "\1\154\1\145\1\u00ff\1\163\1\162\1\u00ff\1\uffff\1\151\1\u00ff\2"+
        "\uffff\2\u00ff\1\143\1\111\1\u00ff\1\151\1\103\1\156\1\111\1\164"+
        "\1\144\1\uffff\3\157\1\u00ff\1\145\1\143\1\uffff\1\141\1\156\1\uffff"+
        "\1\u00ff\1\uffff\1\151\1\141\1\uffff\1\150\1\125\1\157\1\u00ff\1"+
        "\164\1\uffff\1\164\2\151\1\164\1\u00ff\1\154\1\170\1\142\1\uffff"+
        "\1\151\1\160\1\151\1\164\1\u00ff\1\163\1\u00ff\1\160\1\157\1\uffff"+
        "\1\156\1\124\1\144\1\uffff\1\155\1\151\3\uffff\1\145\1\156\1\uffff"+
        "\1\156\1\157\1\145\1\156\1\163\2\u00ff\2\162\1\156\1\uffff\1\141"+
        "\1\164\1\143\1\145\1\uffff\1\156\1\164\1\u00ff\1\157\1\160\1\156"+
        "\1\uffff\1\145\1\u00ff\1\147\1\166\1\171\1\uffff\3\u00ff\1\116\1"+
        "\147\1\124\1\172\1\157\1\uffff\1\u00ff\1\uffff\1\141\1\156\1\143"+
        "\1\157\1\163\1\141\1\156\1\117\1\143\1\147\1\156\1\144\2\u00ff\2"+
        "\uffff\1\163\1\144\2\164\1\u00ff\1\145\1\u00ff\1\145\1\151\1\uffff"+
        "\1\167\1\160\2\u00ff\1\uffff\1\165\1\145\1\u00ff\3\uffff\1\114\1"+
        "\150\1\157\1\145\1\162\1\uffff\1\143\2\145\2\u00ff\1\162\1\145\1"+
        "\146\1\162\1\u00ff\1\164\1\u00ff\2\uffff\1\145\1\u00ff\1\144\1\u00ff"+
        "\2\145\1\uffff\1\u00ff\1\uffff\1\u00ff\1\157\2\145\2\uffff\1\141"+
        "\1\124\1\uffff\1\u00ff\1\164\1\u00ff\1\162\1\u00ff\1\145\1\u00ff"+
        "\1\117\2\uffff\1\171\3\u00ff\1\uffff\1\145\1\uffff\1\155\1\uffff"+
        "\1\u00ff\1\uffff\1\170\1\u00ff\2\uffff\1\156\2\162\1\164\1\145\1"+
        "\uffff\1\124\1\uffff\1\u00ff\1\uffff\1\u00ff\1\uffff\1\156\1\u00ff"+
        "\3\uffff\1\170\1\160\1\uffff\1\164\1\uffff\1\124\2\u00ff\1\145\1"+
        "\155\1\157\2\uffff\1\154\1\uffff\1\164\1\154\1\u00ff\1\145\2\uffff"+
        "\1\u00ff\1\160\1\u00ff\1\171\1\u00ff\1\141\1\uffff\1\155\1\63\1"+
        "\uffff\1\154\1\uffff\1\u00ff\1\uffff\1\164\1\160\1\u00ff\1\141\1"+
        "\uffff\1\145\1\154\1\uffff\1\164\1\u00ff\1\141\1\145\1\uffff\1\164"+
        "\1\u00ff\1\145\1\uffff\1\u00ff\1\uffff";
>>>>>>> .r9710
    static final String DFA16_acceptS =
        "\31\uffff\1\134\1\135\1\136\1\137\2\uffff\1\144\1\uffff\1\147\1"+
        "\150\1\151\1\152\1\153\1\154\1\157\1\161\1\162\2\uffff\1\171\1\172"+
<<<<<<< .mine
        "\1\173\1\uffff\1\176\25\uffff\1\11\40\uffff\1\126\1\155\1\156\1"+
=======
        "\1\173\1\uffff\1\176\55\uffff\1\121\10\uffff\1\126\1\155\1\156\1"+
>>>>>>> .r9710
        "\127\1\160\1\132\1\130\1\133\1\131\1\142\1\140\1\143\1\141\1\146"+
<<<<<<< .mine
        "\1\145\1\165\1\163\1\166\1\167\1\170\1\164\1\174\1\175\6\uffff\1"+
        "\123\70\uffff\1\1\1\uffff\1\115\11\uffff\1\6\17\uffff\1\73\17\uffff"+
        "\1\23\1\uffff\1\41\17\uffff\1\44\7\uffff\1\20\2\uffff\1\4\10\uffff"+
        "\1\7\5\uffff\1\50\26\uffff\1\25\1\33\2\uffff\1\32\1\34\4\uffff\1"+
        "\37\2\uffff\1\55\1\60\12\uffff\1\31\1\3\6\uffff\1\12\4\uffff\1\124"+
        "\2\uffff\1\21\5\uffff\1\30\13\uffff\1\114\3\uffff\1\72\1\27\11\uffff"+
        "\1\101\2\uffff\1\61\1\74\1\15\7\uffff\1\51\5\uffff\1\10\6\uffff"+
        "\1\16\7\uffff\1\111\1\22\12\uffff\1\63\16\uffff\1\42\3\uffff\1\53"+
        "\6\uffff\1\66\1\45\1\57\17\uffff\1\110\1\77\1\uffff\1\75\6\uffff"+
        "\1\103\1\2\2\uffff\1\67\1\5\1\14\1\uffff\1\24\1\uffff\1\120\22\uffff"+
        "\1\106\4\uffff\1\121\5\uffff\1\116\1\13\1\uffff\1\56\1\uffff\1\71"+
        "\1\uffff\1\54\1\100\3\uffff\1\62\1\65\1\uffff\1\125\1\uffff\1\64"+
        "\3\uffff\1\70\2\uffff\1\76\2\uffff\1\40\1\43\2\uffff\1\122\1\104"+
        "\1\117\4\uffff\1\47\2\uffff\1\26\1\46\7\uffff\1\17\1\uffff\1\52"+
        "\4\uffff\1\105\2\uffff\1\113\3\uffff\1\112\3\uffff\1\36\3\uffff"+
        "\1\102\3\uffff\1\35\1\uffff\1\107";
=======
        "\1\145\1\165\1\163\1\166\1\167\1\170\1\164\1\174\1\175\21\uffff"+
        "\1\56\67\uffff\1\57\3\uffff\1\12\2\uffff\1\66\7\uffff\1\52\1\uffff"+
        "\1\124\5\uffff\1\21\27\uffff\1\33\30\uffff\1\67\4\uffff\1\6\5\uffff"+
        "\1\10\1\113\7\uffff\1\105\1\15\2\uffff\1\120\4\uffff\1\40\14\uffff"+
        "\1\46\2\uffff\1\51\1\63\13\uffff\1\43\6\uffff\1\5\2\uffff\1\30\1"+
        "\uffff\1\7\2\uffff\1\11\5\uffff\1\77\10\uffff\1\20\11\uffff\1\25"+
        "\3\uffff\1\41\2\uffff\1\114\1\74\1\101\2\uffff\1\122\12\uffff\1"+
        "\55\4\uffff\1\76\6\uffff\1\115\5\uffff\1\34\10\uffff\1\35\1\uffff"+
        "\1\102\16\uffff\1\112\1\3\11\uffff\1\44\4\uffff\1\16\3\uffff\1\47"+
        "\1\50\1\24\5\uffff\1\60\14\uffff\1\2\1\13\6\uffff\1\104\1\uffff"+
        "\1\71\4\uffff\1\72\1\14\2\uffff\1\116\10\uffff\1\100\1\37\4\uffff"+
        "\1\23\1\uffff\1\61\1\uffff\1\107\1\uffff\1\123\2\uffff\1\65\1\22"+
        "\5\uffff\1\125\1\uffff\1\111\1\uffff\1\70\1\uffff\1\53\2\uffff\1"+
        "\45\1\1\1\36\2\uffff\1\117\1\uffff\1\42\6\uffff\1\26\1\31\1\uffff"+
        "\1\106\4\uffff\1\62\1\110\6\uffff\1\4\2\uffff\1\32\1\uffff\1\64"+
        "\1\uffff\1\27\4\uffff\1\75\2\uffff\1\73\4\uffff\1\103\3\uffff\1"+
        "\17\1\uffff\1\54";
>>>>>>> .r9710
    static final String DFA16_specialS =
        "\u0251\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\31\1\60\1\42\1\44\2"+
            "\uffff\1\56\1\33\1\34\1\47\1\50\1\32\1\25\1\46\1\26\12\57\1"+
            "\40\1\37\1\53\1\51\1\52\1\43\1\45\32\56\1\27\1\uffff\1\30\1"+
<<<<<<< .mine
            "\uffff\1\56\1\uffff\1\1\1\56\1\4\1\20\1\13\1\3\1\56\1\21\1\12"+
            "\1\56\1\7\1\6\1\14\1\5\1\10\1\17\1\23\1\22\1\11\1\2\1\15\1\24"+
            "\1\16\3\56\1\35\1\41\1\36\102\uffff\27\56\1\uffff\37\56\1\uffff"+
            "\10\56",
            "\1\65\1\uffff\1\63\7\uffff\1\62\1\uffff\1\61\4\uffff\1\66"+
            "\1\uffff\1\64",
            "\1\67\11\uffff\1\71\2\uffff\1\70",
            "\1\72\7\uffff\1\74\5\uffff\1\73\5\uffff\1\75",
            "\1\77\2\uffff\1\76",
            "\1\100\2\uffff\1\101\11\uffff\1\102",
            "\1\104\11\uffff\1\103",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\105\25\56"+
=======
            "\uffff\1\56\1\uffff\1\4\1\56\1\2\1\13\1\7\1\11\1\56\1\17\1\1"+
            "\1\56\1\20\1\6\1\22\1\21\1\3\1\14\1\23\1\16\1\15\1\12\1\24\1"+
            "\5\1\10\3\56\1\35\1\41\1\36\102\uffff\27\56\1\uffff\37\56\1"+
            "\uffff\10\56",
            "\1\62\6\uffff\1\63\1\61\4\uffff\1\64",
            "\1\66\2\uffff\1\65",
            "\1\70\11\uffff\1\67\1\71\1\uffff\1\72\1\uffff\1\73",
            "\1\101\1\uffff\1\74\7\uffff\1\75\1\uffff\1\100\4\uffff\1\77"+
            "\1\uffff\1\76",
            "\1\102",
            "\1\103\11\uffff\1\104",
            "\1\105\4\uffff\1\106",
            "\1\110\6\uffff\1\107",
            "\1\111\7\uffff\1\114\5\uffff\1\112\5\uffff\1\113",
            "\1\115\11\uffff\1\116\2\uffff\1\117",
            "\1\120\3\uffff\1\121\10\uffff\1\122",
            "\1\124\15\uffff\1\125\2\uffff\1\123",
            "\1\127\11\uffff\1\131\4\uffff\1\126\4\uffff\1\130",
            "\1\133\3\uffff\1\132",
            "\1\134",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\135\25\56"+
>>>>>>> .r9710
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\110\11\uffff\1\112\1\113\1\uffff\1\111\1\uffff\1\107",
            "\1\116\11\uffff\1\117\4\uffff\1\115\4\uffff\1\114",
            "\1\121\6\uffff\1\123\1\120\4\uffff\1\122",
            "\1\124\4\uffff\1\125",
            "\1\126\15\uffff\1\127\5\uffff\1\130",
            "\1\131",
            "\1\132\6\uffff\1\133",
            "\1\135\15\uffff\1\136\2\uffff\1\134",
            "\1\141\3\uffff\1\137\10\uffff\1\140",
            "\1\142",
            "\1\144\3\uffff\1\143",
            "\1\145",
=======
            "\1\140\2\uffff\1\137\11\uffff\1\141",
            "\1\143\15\uffff\1\144\5\uffff\1\142",
            "\1\145",
>>>>>>> .r9710
            "\1\146",
            "\1\147\20\uffff\1\150",
            "\1\152",
            "\1\154",
            "\1\156",
            "",
            "",
            "",
            "",
            "\1\160",
            "\1\162",
            "",
            "\1\164",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\166",
            "\1\172\17\uffff\1\170\1\171",
            "",
            "",
            "",
            "\1\175\1\uffff\12\57",
            "",
<<<<<<< .mine
            "\1\176",
            "\1\u0080\12\uffff\1\177",
            "\1\u0081",
=======
            "\1\177\16\uffff\1\176\2\uffff\1\u0080",
            "\1\u0081",
>>>>>>> .r9710
            "\1\u0082",
            "\1\u0083",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c\12\uffff\1\u008d",
            "\1\u008e",
<<<<<<< .mine
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
=======
>>>>>>> .r9710
<<<<<<< .mine
            "\1\u0092\21\uffff\1\u0093",
            "\1\u0094",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093\21\uffff\1\u0094",
            "\1\u0095",
            "\1\u0096\20\uffff\1\u0097",
            "\1\u0098",
>>>>>>> .r9710
            "\1\u0099",
            "\1\u009b\1\u009a",
            "\1\u009c\15\uffff\1\u009d",
            "\1\u009e\1\uffff\1\u009f",
            "\1\u00a0",
<<<<<<< .mine
            "\1\u00a3\16\uffff\1\u00a2\2\uffff\1\u00a1",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7\20\uffff\1\u00a8",
=======
            "\1\u00a1",
            "\1\u00a2\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a7\3\uffff\1\u00a6",
            "\1\u00a8",
>>>>>>> .r9710
            "\1\u00a9",
<<<<<<< .mine
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b1\3\uffff\1\u00b0",
=======
            "\1\u00aa\15\uffff\1\u00ab",
            "\1\u00ad\1\uffff\1\u00ac",
            "\1\u00af\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
>>>>>>> .r9710
            "\1\u00b2",
            "\1\u00b3",
<<<<<<< .mine
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6\1\u00b7",
            "\1\u00b8",
=======
            "\1\u00b4",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
>>>>>>> .r9710
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
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
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00be",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
>>>>>>> .r9710
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\2\56\1\u00c7\1\56"+
            "\1\u00c8\25\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ca",
            "\1\u00cb",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u00cc",
            "\1\u00cd",
            "",
            "\1\u00cf",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
<<<<<<< .mine
            "\1\u00d2",
=======
            "\1\u00d2",
            "\1\u00d3",
            "\12\56\7\uffff\15\56\1\u00d4\1\u00d5\13\56\4\uffff\1\56\1"+
            "\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
<<<<<<< .mine
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
=======
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00da",
            "\1\u00db",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\2\56\1\u00dd\1\56"+
            "\1\u00dc\25\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
<<<<<<< .mine
            "\12\56\7\uffff\15\56\1\u00e7\1\u00e8\13\56\4\uffff\1\56\1"+
            "\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u00e7",
            "\1\u00e8\1\uffff\1\u00e9",
>>>>>>> .r9710
            "\1\u00ea",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2\1\uffff\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
<<<<<<< .mine
            "\1\u00ff",
            "",
=======
            "\1\u00ff",
>>>>>>> .r9710
            "\1\u0100",
            "",
            "\1\u0101",
            "\12\56\7\uffff\2\56\1\u0102\27\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0104",
            "\1\u0105",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "",
            "\1\u010a",
            "",
            "\1\u010b",
<<<<<<< .mine
            "\1\u010c",
            "\1\u010d",
=======
            "\1\u010c",
            "",
            "\1\u010d",
            "\12\56\7\uffff\2\56\1\u010e\27\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
<<<<<<< .mine
            "\1\u010e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0110",
=======
            "",
>>>>>>> .r9710
            "\1\u0110",
            "\1\u0111",
<<<<<<< .mine
            "\1\u0112",
            "\12\56\7\uffff\15\56\1\u0113\4\56\1\u0114\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\12\56\7\uffff\15\56\1\u0113\4\56\1\u0112\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0115",
>>>>>>> .r9710
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "",
            "\1\u0119",
<<<<<<< .mine
            "\1\u011a",
            "\1\u011b",
            "",
            "\1\u011c",
=======
            "",
>>>>>>> .r9710
            "\1\u011d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0125",
            "\1\u0126",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
<<<<<<< .mine
            "",
            "\1\u012b",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56\1\u012b\21"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u012d",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u012e",
            "\1\u012f",
            "\1\u0132",
            "\1\u0133",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56\1\u0135\21"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0137",
            "\1\u0138",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u0135",
            "\1\u0136",
            "",
>>>>>>> .r9710
<<<<<<< .mine
            "\1\u013b",
            "",
            "\1\u013c",
            "\1\u013d",
=======
            "\1\u0137",
            "\1\u0138",
>>>>>>> .r9710
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "",
            "\1\u0143",
            "\1\u0144",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u013a",
            "\1\u013b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u014e",
            "",
            "\1\u014f",
<<<<<<< .mine
            "\1\u0150",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u0151",
            "\1\u0152",
            "",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0153",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u0154",
<<<<<<< .mine
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0156",
            "\1\u0157",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\12\56\7\uffff\15\56\1\u015a\14\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u015d\2\uffff\1\u015c",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
=======
            "",
            "",
            "\1\u015f",
            "\1\u0160",
            "",
            "\1\u0161",
>>>>>>> .r9710
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "",
            "\1\u0165",
<<<<<<< .mine
            "\1\u0166",
=======
            "\12\56\7\uffff\15\56\1\u0166\14\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0169\2\uffff\1\u0168",
            "\1\u016a",
            "\1\u016b",
>>>>>>> .r9710
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0168",
            "\1\u0169",
=======
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
>>>>>>> .r9710
            "\12\56\7\uffff\15\56\1\u0170\4\56\1\u016f\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0172\15\uffff\1\u0173",
            "\1\u0174",
            "",
            "\12\56\7\uffff\13\56\1\u016a\16\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "",
            "\1\u0171",
            "\1\u0172",
=======
>>>>>>> .r9710
            "",
<<<<<<< .mine
            "",
            "\1\u0173",
            "\12\56\7\uffff\15\56\1\u0175\4\56\1\u0174\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0177\15\uffff\1\u0178",
=======
            "\1\u0176",
            "\12\56\7\uffff\13\56\1\u0177\16\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u017b",
>>>>>>> .r9710
            "\1\u017c",
<<<<<<< .mine
            "\1\u017d",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u017e",
            "\1\u017f",
<<<<<<< .mine
            "",
            "\1\u0180\10\uffff\1\u0181",
            "\1\u0182",
=======
            "\1\u0180",
            "\1\u0182\7\uffff\1\u0181",
>>>>>>> .r9710
<<<<<<< .mine
=======
            "\1\u0183",
            "\1\u0184",
            "",
            "\1\u0185",
>>>>>>> .r9710
            "\1\u0186",
            "\1\u0187",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u0184",
            "\1\u0186\7\uffff\1\u0185",
            "\1\u0187",
            "",
            "\1\u0188",
=======
>>>>>>> .r9710
            "",
            "\1\u018b",
            "\1\u018c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u018a",
            "\1\u018b",
            "",
            "\1\u018c",
            "\1\u018d",
=======
            "",
>>>>>>> .r9710
<<<<<<< .mine
=======
            "\1\u018e",
            "\1\u018f",
>>>>>>> .r9710
            "",
<<<<<<< .mine
            "\1\u018e",
            "\1\u018f",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0191",
            "\1\u0192\25\uffff\1\u0193",
            "",
=======
            "\1\u0190",
            "\1\u0191\10\uffff\1\u0192",
            "\1\u0193",
>>>>>>> .r9710
            "\1\u0195",
            "\1\u0195",
            "",
            "\1\u0196",
            "\1\u0197",
<<<<<<< .mine
=======
            "\1\u0198",
            "\1\u0199",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u019b",
            "\1\u019c",
            "\1\u019d\25\uffff\1\u019e",
            "",
>>>>>>> .r9710
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
<<<<<<< .mine
            "\1\u01a3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01a5",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01a4",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "",
            "\1\u01ab",
            "\1\u01ac",
            "",
            "",
            "",
            "\1\u01ad",
            "\1\u01ae",
            "",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "\1\u01b4",
            "\1\u01b5",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u01b6",
<<<<<<< .mine
=======
            "\1\u01b7",
            "\1\u01b8",
            "",
>>>>>>> .r9710
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b8",
            "",
            "\1\u01b9",
=======
            "\1\u01b9",
>>>>>>> .r9710
            "\1\u01ba",
            "\1\u01bb",
<<<<<<< .mine
=======
            "\1\u01bc",
            "",
>>>>>>> .r9710
            "\1\u01bd",
<<<<<<< .mine
=======
            "\1\u01be",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01c1",
            "\1\u01c2",
=======
>>>>>>> .r9710
            "\1\u01c3",
<<<<<<< .mine
            "\1\u01c4",
=======
>>>>>>> .r9710
            "\1\u01c5",
            "",
            "",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
<<<<<<< .mine
            "\1\u01c9",
            "\1\u01ca",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "\1\u01cf",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "",
            "\1\u01d1",
>>>>>>> .r9710
            "\1\u01d2",
            "\1\u01d4",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01dc",
<<<<<<< .mine
            "\1\u01dd",
            "",
=======
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "",
<<<<<<< .mine
            "\1\u01e1",
=======
            "",
            "\1\u01df\20\uffff\1\u01e1\15\uffff\1\u01e0",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u01e3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01e5",
            "\1\u01e8\20\uffff\1\u01e6\15\uffff\1\u01e7",
=======
            "\1\u01e6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01e8",
            "\1\u01e9",
>>>>>>> .r9710
            "",
            "",
            "\1\u01e9",
            "\1\u01ea",
            "\1\u01eb",
<<<<<<< .mine
            "\1\u01ec",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
>>>>>>> .r9710
            "\1\u01ee",
<<<<<<< .mine
            "\1\u01ef",
=======
            "\1\u01ef",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "",
            "",
            "",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "\1\u01f6",
            "\1\u01f7",
            "\1\u01f8",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "",
            "\1\u01f8",
            "",
            "\1\u01f9",
            "\1\u01fa",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u01fb",
            "\1\u01fc",
            "\1\u01fd",
<<<<<<< .mine
            "\1\u01fe",
=======
            "\1\u01fe",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
<<<<<<< .mine
            "",
            "",
            "\1\u01ff",
=======
>>>>>>> .r9710
            "\1\u0200",
            "",
            "",
            "",
            "\1\u0201",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
=======
            "",
            "",
            "\1\u0202",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0204",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0206",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u0207",
            "",
>>>>>>> .r9710
<<<<<<< .mine
            "\1\u0208",
=======
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u020b",
=======
            "\1\u020a",
            "\1\u020b",
>>>>>>> .r9710
            "\1\u020c",
<<<<<<< .mine
            "\1\u020d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
>>>>>>> .r9710
<<<<<<< .mine
=======
            "",
            "",
            "\1\u020d",
            "\1\u020e",
            "",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0210",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0212",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u0214",
=======
            "\1\u0214",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0216",
>>>>>>> .r9710
            "",
<<<<<<< .mine
            "\1\u0215",
            "\1\u0216",
=======
            "",
            "\1\u0217",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\1\u0218",
=======
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
>>>>>>> .r9710
            "\1\u0219",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "",
>>>>>>> .r9710
            "\1\u021b",
<<<<<<< .mine
=======
            "",
            "\1\u021c",
            "",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "\1\u021f",
            "",
=======
            "",
            "",
>>>>>>> .r9710
            "\1\u0220",
            "\1\u0222",
            "\1\u0223",
            "\1\u0224",
            "",
            "\1\u0225",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
>>>>>>> .r9710
            "",
<<<<<<< .mine
            "",
            "\1\u0224",
            "",
            "\1\u0225",
            "",
            "\1\u0226",
            "\1\u0227",
=======
            "\1\u0228",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u022a",
<<<<<<< .mine
=======
            "\1\u022b",
            "",
            "\1\u022c",
>>>>>>> .r9710
            "",
<<<<<<< .mine
=======
            "\1\u022d",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0230",
            "\1\u0231",
            "\1\u0232",
            "",
            "",
<<<<<<< .mine
            "\1\u022d",
            "\1\u022e",
            "",
            "",
            "",
            "\1\u022f",
            "\1\u0230",
            "\1\u0231",
            "\1\u0232",
=======
            "\1\u0233",
>>>>>>> .r9710
            "",
<<<<<<< .mine
=======
            "\1\u0234",
            "\1\u0235",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
            "",
            "\1\u0235",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
=======
            "\1\u0237",
>>>>>>> .r9710
            "\1\u0237",
            "\1\u0238",
            "\1\u0239",
            "\12\56\7\uffff\25\56\1\u023a\4\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u023c",
            "",
            "\1\u023d",
            "",
<<<<<<< .mine
=======
            "\12\56\7\uffff\25\56\1\u0238\4\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u023a",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "\1\u023c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u023e",
>>>>>>> .r9710
            "",
            "\1\u023f",
            "\1\u0240",
            "\1\u0241",
            "",
<<<<<<< .mine
=======
            "\1\u0241",
            "",
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
=======
            "",
>>>>>>> .r9710
            "\1\u0243",
            "",
            "\1\u0244",
<<<<<<< .mine
            "\1\u0245",
=======
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
<<<<<<< .mine
            "",
=======
            "\1\u0246",
            "",
>>>>>>> .r9710
            "\1\u0247",
            "\1\u0248",
            "",
            "\1\u0249",
<<<<<<< .mine
            "",
=======
>>>>>>> .r9710
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u024b",
            "\1\u024c",
<<<<<<< .mine
=======
            "",
            "\1\u024d",
>>>>>>> .r9710
            "\1\u024d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u024f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
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
            return "1:1: Tokens : ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}