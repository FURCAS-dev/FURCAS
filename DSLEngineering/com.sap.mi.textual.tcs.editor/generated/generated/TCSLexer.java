// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g 2009-12-08 08:29:42

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
    public static final int EXCL=35;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=10;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=42;
    public static final int EQ=11;
    public static final int COMMENT=34;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int NE=41;
    public static final int GE=39;
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
    public static final int ALPHA=45;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=43;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=46;
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
    public static final int AROBAS=36;
    public static final int T__118=118;
    public static final int ESC=47;
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
    public static final int SLASH=37;
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
    public static final int PLUS=38;
    public static final int DIGIT=44;
    public static final int T__50=50;
    public static final int T__48=48;
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
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=40;
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
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g"; }

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:7: ( 'ifmissing' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:117:9: 'ifmissing'
            {
            match("ifmissing"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:7: ( 'foreach' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:118:9: 'foreach'
            {
            match("foreach"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:7: ( 'importContext' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:119:9: 'importContext'
            {
            match("importContext"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:7: ( 'left' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:120:9: 'left'
            {
            match("left"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:7: ( 'startNbNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:121:9: 'startNbNL'
            {
            match("startNbNL"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:7: ( 'never' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:122:9: 'never'
            {
            match("never"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:7: ( 'drop' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:123:9: 'drop'
            {
            match("drop"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:7: ( 'multi' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:124:9: 'multi'
            {
            match("multi"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:7: ( 'lookIn' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:125:9: 'lookIn'
            {
            match("lookIn"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:7: ( 'multiLine' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:126:9: 'multiLine'
            {
            match("multiLine"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:7: ( 'abstract' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:127:9: 'abstract'
            {
            match("abstract"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:7: ( 'true' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:128:9: 'true'
            {
            match("true"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:7: ( 'startNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:129:9: 'startNL'
            {
            match("startNL"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:7: ( 'nonPrimary' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:130:9: 'nonPrimary'
            {
            match("nonPrimary"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:7: ( 'orKeyword' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:131:9: 'orKeyword'
            {
            match("orKeyword"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:7: ( 'hex' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:132:9: 'hex'
            {
            match("hex"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:7: ( 'esc' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:133:9: 'esc'
            {
            match("esc"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:7: ( 'createAs' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:134:9: 'createAs'
            {
            match("createAs"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:7: ( 'when' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:135:9: 'when'
            {
            match("when"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:7: ( 'using' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:136:9: 'using'
            {
            match("using"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:7: ( 'autoCreate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:137:9: 'autoCreate'
            {
            match("autoCreate"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:7: ( 'context' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:138:9: 'context'
            {
            match("context"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:7: ( 'refersTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:139:9: 'refersTo'
            {
            match("refersTo"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:7: ( 'auto' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:140:9: 'auto'
            {
            match("auto"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:7: ( 'for' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:141:9: 'for'
            {
            match("for"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:7: ( 'query' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:142:9: 'query'
            {
            match("query"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:7: ( 'token' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:143:9: 'token'
            {
            match("token"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:7: ( 'deep' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:144:9: 'deep'
            {
            match("deep"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:7: ( 'part' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:145:9: 'part'
            {
            match("part"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:7: ( 'filter' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:146:9: 'filter'
            {
            match("filter"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:7: ( 'partial' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:147:9: 'partial'
            {
            match("partial"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:7: ( 'separator' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:148:9: 'separator'
            {
            match("separator"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:7: ( 'postfix' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:149:9: 'postfix'
            {
            match("postfix"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:7: ( 'leftSpace' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:150:9: 'leftSpace'
            {
            match("leftSpace"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:7: ( 'leftNone' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:151:9: 'leftNone'
            {
            match("leftNone"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:7: ( 'endOfLine' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:152:9: 'endOfLine'
            {
            match("endOfLine"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:7: ( 'template' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:153:9: 'template'
            {
            match("template"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:7: ( 'enumerationTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:154:9: 'enumerationTemplate'
            {
            match("enumerationTemplate"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:7: ( 'omitted' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:155:9: 'omitted'
            {
            match("omitted"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:7: ( 'disambiguateV3' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:156:9: 'disambiguateV3'
            {
            match("disambiguateV3"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:7: ( 'value' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:157:9: 'value'
            {
            match("value"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:7: ( 'nbNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:158:9: 'nbNL'
            {
            match("nbNL"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:7: ( 'storeRightTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:159:9: 'storeRightTo'
            {
            match("storeRightTo"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:7: ( 'createIn' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:160:9: 'createIn'
            {
            match("createIn"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:7: ( 'prefix' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:161:9: 'prefix'
            {
            match("prefix"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:7: ( 'rightNone' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:162:9: 'rightNone'
            {
            match("rightNone"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:7: ( 'and' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:163:9: 'and'
            {
            match("and"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:7: ( 'invert' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:164:9: 'invert'
            {
            match("invert"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:7: ( 'addToContext' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:165:9: 'addToContext'
            {
            match("addToContext"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:7: ( 'storeOpTo' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:166:9: 'storeOpTo'
            {
            match("storeOpTo"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:7: ( 'false' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:167:9: 'false'
            {
            match("false"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:7: ( 'disambiguate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:168:9: 'disambiguate'
            {
            match("disambiguate"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:8: ( 'priority' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:169:10: 'priority'
            {
            match("priority"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:8: ( 'operators' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:170:10: 'operators'
            {
            match("operators"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:8: ( 'rightSpace' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:171:10: 'rightSpace'
            {
            match("rightSpace"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:8: ( 'endNL' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:172:10: 'endNL'
            {
            match("endNL"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:8: ( 'isDefined' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:173:10: 'isDefined'
            {
            match("isDefined"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:8: ( 'symbols' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:174:10: 'symbols'
            {
            match("symbols"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:8: ( 'word' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:175:10: 'word'
            {
            match("word"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:8: ( 'keywords' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:176:10: 'keywords'
            {
            match("keywords"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:8: ( 'forcedLower' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:177:10: 'forcedLower'
            {
            match("forcedLower"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:8: ( 'lexer' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:178:10: 'lexer'
            {
            match("lexer"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:8: ( 'instanceOf' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:179:10: 'instanceOf'
            {
            match("instanceOf"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:8: ( 'source' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:180:10: 'source'
            {
            match("source"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:8: ( 'operatored' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:181:10: 'operatored'
            {
            match("operatored"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:8: ( 'start' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:182:10: 'start'
            {
            match("start"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:8: ( 'default' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:183:10: 'default'
            {
            match("default"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:8: ( 'always' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:184:10: 'always'
            {
            match("always"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:8: ( 'main' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:185:10: 'main'
            {
            match("main"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:8: ( 'k' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:186:10: 'k'
            {
            match('k'); 

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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:8: ( 'primitiveTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:187:10: 'primitiveTemplate'
            {
            match("primitiveTemplate"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:8: ( 'operatorTemplate' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:188:10: 'operatorTemplate'
            {
            match("operatorTemplate"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:8: ( 'octal' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:189:10: 'octal'
            {
            match("octal"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:8: ( 'indentIncr' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:190:10: 'indentIncr'
            {
            match("indentIncr"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:8: ( 'as' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:191:10: 'as'
            {
            match("as"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:8: ( 'function' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:192:10: 'function'
            {
            match("function"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:8: ( 'referenceOnly' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:193:10: 'referenceOnly'
            {
            match("referenceOnly"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:8: ( 'right' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:194:10: 'right'
            {
            match("right"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:8: ( 'syntax' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:195:10: 'syntax'
            {
            match("syntax"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:8: ( 'one' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:196:10: 'one'
            {
            match("one"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:8: ( 'mode' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:197:10: 'mode'
            {
            match("mode"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:8: ( 'forcedUpper' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:198:10: 'forcedUpper'
            {
            match("forcedUpper"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:8: ( 'serializer' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:199:10: 'serializer'
            {
            match("serializer"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:8: ( 'end' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:200:10: 'end'
            {
            match("end"); 


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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:8: ( 'all' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:201:10: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__132"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1697:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1698:15: ~ ( '\\r' | '\\n' )
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

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1703:3: ( '[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1704:3: '['
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1709:3: ( ']' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1710:3: ']'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1715:3: ( '[[' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1716:3: '[['
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1721:3: ( ']]' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1722:3: ']]'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1727:3: ( '!' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1728:3: '!'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1733:3: ( ',' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1734:3: ','
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1739:3: ( '(' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1740:3: '('
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1745:3: ( ')' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1746:3: ')'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1751:3: ( '{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1752:3: '{'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1757:3: ( '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1758:3: '}'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1763:3: ( '{{' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1764:3: '{{'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1769:3: ( '}}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1770:3: '}}'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1775:3: ( ';' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1776:3: ';'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1781:3: ( ':' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1782:3: ':'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1787:3: ( '::' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1788:3: '::'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1793:3: ( '|' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1794:3: '|'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1799:3: ( '#' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1800:3: '#'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1805:3: ( '?' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1806:3: '?'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1811:3: ( '$' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1812:3: '$'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1817:3: ( '@' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1818:3: '@'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1823:3: ( '.' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1824:3: '.'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1829:3: ( '->' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1830:3: '->'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1835:3: ( '-' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1836:3: '-'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1841:3: ( '*' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1842:3: '*'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1847:3: ( '/' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1848:3: '/'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1853:3: ( '+' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1854:3: '+'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1859:3: ( '=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1860:3: '='
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1865:3: ( '>' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1866:3: '>'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1871:3: ( '<' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1872:3: '<'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1877:3: ( '>=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1878:3: '>='
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1883:3: ( '<=' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1884:3: '<='
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1889:3: ( '<>' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1890:3: '<>'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1895:3: ( '<-' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1896:3: '<-'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1904:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1904:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1904:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1904:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1905:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1906:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1907:5: '\\n'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1913:2: ( ( ' ' | '\\t' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1913:4: ( ' ' | '\\t' )
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:2: ( '0' .. '9' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1920:4: '0' .. '9'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1925:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1939:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1939:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1939:4: ( ALPHA )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1939:5: ALPHA
            {
            mALPHA(); 

            }

            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1939:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1944:2: ( ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1944:4: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1944:4: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1945:3: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1946:5: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); 
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=3;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1947:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1948:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1949:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
                    	    break loop4;
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:2: ( ( DIGIT )+ )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:4: ( DIGIT )+
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1957:5: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:9: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:9: DIGIT
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

            match('.'); 
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:20: ( DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1960:20: DIGIT
            	    {
            	    mDIGIT(); 

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
    // $ANTLR end "FLOAT"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1964:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1964:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1965:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt13=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt13=1;
                }
                break;
            case 'r':
                {
                alt13=2;
                }
                break;
            case 't':
                {
                alt13=3;
                }
                break;
            case 'b':
                {
                alt13=4;
                }
                break;
            case 'f':
                {
                alt13=5;
                }
                break;
            case '\"':
                {
                alt13=6;
                }
                break;
            case '\'':
                {
                alt13=7;
                }
                break;
            case '\\':
                {
                alt13=8;
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
                alt13=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1965:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1966:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1967:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1968:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1969:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1970:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1971:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1972:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1973:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1973:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>='0' && LA12_0<='3')) ) {
                        alt12=1;
                    }
                    else if ( ((LA12_0>='4' && LA12_0<='7')) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1974:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1974:5: ( '0' .. '3' )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1974:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1975:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1976:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1976:7: ( '0' .. '7' )
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1976:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1977:6: ( '0' .. '7' )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1978:8: '0' .. '7'
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
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1981:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1981:6: ( '4' .. '7' )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1981:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1982:5: ( ( '0' .. '7' ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1983:7: ( '0' .. '7' )
                                    {
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1983:7: ( '0' .. '7' )
                                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1983:8: '0' .. '7'
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
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:2: ( '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1992:4: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1993:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
            loop14:
            do {
                int alt14=4;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\\') ) {
                    alt14=1;
                }
                else if ( (LA14_0=='\n') ) {
                    alt14=2;
                }
                else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                    alt14=3;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1993:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1994:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1995:5: ~ ( '\\\\' | '\\\"' | '\\n' )
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
            	    break loop14;
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
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:8: ( T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt15=125;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:10: T__48
                {
                mT__48(); 

                }
                break;
            case 2 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:16: T__49
                {
                mT__49(); 

                }
                break;
            case 3 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:22: T__50
                {
                mT__50(); 

                }
                break;
            case 4 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:28: T__51
                {
                mT__51(); 

                }
                break;
            case 5 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:34: T__52
                {
                mT__52(); 

                }
                break;
            case 6 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:40: T__53
                {
                mT__53(); 

                }
                break;
            case 7 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:46: T__54
                {
                mT__54(); 

                }
                break;
            case 8 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:52: T__55
                {
                mT__55(); 

                }
                break;
            case 9 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:58: T__56
                {
                mT__56(); 

                }
                break;
            case 10 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:64: T__57
                {
                mT__57(); 

                }
                break;
            case 11 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:70: T__58
                {
                mT__58(); 

                }
                break;
            case 12 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:76: T__59
                {
                mT__59(); 

                }
                break;
            case 13 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:82: T__60
                {
                mT__60(); 

                }
                break;
            case 14 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:88: T__61
                {
                mT__61(); 

                }
                break;
            case 15 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:94: T__62
                {
                mT__62(); 

                }
                break;
            case 16 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:100: T__63
                {
                mT__63(); 

                }
                break;
            case 17 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:106: T__64
                {
                mT__64(); 

                }
                break;
            case 18 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:112: T__65
                {
                mT__65(); 

                }
                break;
            case 19 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:118: T__66
                {
                mT__66(); 

                }
                break;
            case 20 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:124: T__67
                {
                mT__67(); 

                }
                break;
            case 21 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:130: T__68
                {
                mT__68(); 

                }
                break;
            case 22 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:136: T__69
                {
                mT__69(); 

                }
                break;
            case 23 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:142: T__70
                {
                mT__70(); 

                }
                break;
            case 24 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:148: T__71
                {
                mT__71(); 

                }
                break;
            case 25 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:154: T__72
                {
                mT__72(); 

                }
                break;
            case 26 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:160: T__73
                {
                mT__73(); 

                }
                break;
            case 27 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:166: T__74
                {
                mT__74(); 

                }
                break;
            case 28 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:172: T__75
                {
                mT__75(); 

                }
                break;
            case 29 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:178: T__76
                {
                mT__76(); 

                }
                break;
            case 30 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:184: T__77
                {
                mT__77(); 

                }
                break;
            case 31 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:190: T__78
                {
                mT__78(); 

                }
                break;
            case 32 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:196: T__79
                {
                mT__79(); 

                }
                break;
            case 33 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:202: T__80
                {
                mT__80(); 

                }
                break;
            case 34 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:208: T__81
                {
                mT__81(); 

                }
                break;
            case 35 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:214: T__82
                {
                mT__82(); 

                }
                break;
            case 36 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:220: T__83
                {
                mT__83(); 

                }
                break;
            case 37 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:226: T__84
                {
                mT__84(); 

                }
                break;
            case 38 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:232: T__85
                {
                mT__85(); 

                }
                break;
            case 39 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:238: T__86
                {
                mT__86(); 

                }
                break;
            case 40 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:244: T__87
                {
                mT__87(); 

                }
                break;
            case 41 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:250: T__88
                {
                mT__88(); 

                }
                break;
            case 42 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:256: T__89
                {
                mT__89(); 

                }
                break;
            case 43 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:262: T__90
                {
                mT__90(); 

                }
                break;
            case 44 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:268: T__91
                {
                mT__91(); 

                }
                break;
            case 45 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:274: T__92
                {
                mT__92(); 

                }
                break;
            case 46 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:280: T__93
                {
                mT__93(); 

                }
                break;
            case 47 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:286: T__94
                {
                mT__94(); 

                }
                break;
            case 48 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:292: T__95
                {
                mT__95(); 

                }
                break;
            case 49 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:298: T__96
                {
                mT__96(); 

                }
                break;
            case 50 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:304: T__97
                {
                mT__97(); 

                }
                break;
            case 51 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:310: T__98
                {
                mT__98(); 

                }
                break;
            case 52 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:316: T__99
                {
                mT__99(); 

                }
                break;
            case 53 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:322: T__100
                {
                mT__100(); 

                }
                break;
            case 54 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:329: T__101
                {
                mT__101(); 

                }
                break;
            case 55 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:336: T__102
                {
                mT__102(); 

                }
                break;
            case 56 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:343: T__103
                {
                mT__103(); 

                }
                break;
            case 57 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:350: T__104
                {
                mT__104(); 

                }
                break;
            case 58 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:357: T__105
                {
                mT__105(); 

                }
                break;
            case 59 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:364: T__106
                {
                mT__106(); 

                }
                break;
            case 60 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:371: T__107
                {
                mT__107(); 

                }
                break;
            case 61 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:378: T__108
                {
                mT__108(); 

                }
                break;
            case 62 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:385: T__109
                {
                mT__109(); 

                }
                break;
            case 63 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:392: T__110
                {
                mT__110(); 

                }
                break;
            case 64 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:399: T__111
                {
                mT__111(); 

                }
                break;
            case 65 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:406: T__112
                {
                mT__112(); 

                }
                break;
            case 66 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:413: T__113
                {
                mT__113(); 

                }
                break;
            case 67 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:420: T__114
                {
                mT__114(); 

                }
                break;
            case 68 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:427: T__115
                {
                mT__115(); 

                }
                break;
            case 69 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:434: T__116
                {
                mT__116(); 

                }
                break;
            case 70 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:441: T__117
                {
                mT__117(); 

                }
                break;
            case 71 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:448: T__118
                {
                mT__118(); 

                }
                break;
            case 72 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:455: T__119
                {
                mT__119(); 

                }
                break;
            case 73 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:462: T__120
                {
                mT__120(); 

                }
                break;
            case 74 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:469: T__121
                {
                mT__121(); 

                }
                break;
            case 75 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:476: T__122
                {
                mT__122(); 

                }
                break;
            case 76 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:483: T__123
                {
                mT__123(); 

                }
                break;
            case 77 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:490: T__124
                {
                mT__124(); 

                }
                break;
            case 78 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:497: T__125
                {
                mT__125(); 

                }
                break;
            case 79 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:504: T__126
                {
                mT__126(); 

                }
                break;
            case 80 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:511: T__127
                {
                mT__127(); 

                }
                break;
            case 81 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:518: T__128
                {
                mT__128(); 

                }
                break;
            case 82 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:525: T__129
                {
                mT__129(); 

                }
                break;
            case 83 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:532: T__130
                {
                mT__130(); 

                }
                break;
            case 84 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:539: T__131
                {
                mT__131(); 

                }
                break;
            case 85 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:546: T__132
                {
                mT__132(); 

                }
                break;
            case 86 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:553: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 87 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:561: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 88 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:569: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 89 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:577: DLSQUARE
                {
                mDLSQUARE(); 

                }
                break;
            case 90 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:586: DRSQUARE
                {
                mDRSQUARE(); 

                }
                break;
            case 91 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:595: EXCL
                {
                mEXCL(); 

                }
                break;
            case 92 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:600: COMA
                {
                mCOMA(); 

                }
                break;
            case 93 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:605: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 94 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:612: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 95 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:619: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 96 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:626: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 97 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:633: DLCURLY
                {
                mDLCURLY(); 

                }
                break;
            case 98 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:641: DRCURLY
                {
                mDRCURLY(); 

                }
                break;
            case 99 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:649: SEMI
                {
                mSEMI(); 

                }
                break;
            case 100 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:654: COLON
                {
                mCOLON(); 

                }
                break;
            case 101 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:660: DLCOLON
                {
                mDLCOLON(); 

                }
                break;
            case 102 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:668: PIPE
                {
                mPIPE(); 

                }
                break;
            case 103 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:673: SHARP
                {
                mSHARP(); 

                }
                break;
            case 104 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:679: QMARK
                {
                mQMARK(); 

                }
                break;
            case 105 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:685: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 106 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:692: AROBAS
                {
                mAROBAS(); 

                }
                break;
            case 107 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:699: POINT
                {
                mPOINT(); 

                }
                break;
            case 108 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:705: RARROW
                {
                mRARROW(); 

                }
                break;
            case 109 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:712: MINUS
                {
                mMINUS(); 

                }
                break;
            case 110 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:718: STAR
                {
                mSTAR(); 

                }
                break;
            case 111 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:723: SLASH
                {
                mSLASH(); 

                }
                break;
            case 112 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:729: PLUS
                {
                mPLUS(); 

                }
                break;
            case 113 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:734: EQ
                {
                mEQ(); 

                }
                break;
            case 114 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:737: GT
                {
                mGT(); 

                }
                break;
            case 115 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:740: LT
                {
                mLT(); 

                }
                break;
            case 116 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:743: GE
                {
                mGE(); 

                }
                break;
            case 117 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:746: LE
                {
                mLE(); 

                }
                break;
            case 118 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:749: NE
                {
                mNE(); 

                }
                break;
            case 119 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:752: LARROW
                {
                mLARROW(); 

                }
                break;
            case 120 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:759: NL
                {
                mNL(); 

                }
                break;
            case 121 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:762: WS
                {
                mWS(); 

                }
                break;
            case 122 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:765: NAME
                {
                mNAME(); 

                }
                break;
            case 123 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:770: INT
                {
                mINT(); 

                }
                break;
            case 124 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:774: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 125 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.mi.textual.tcs.editor\\generated\\generated\\TCS.g:1:780: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\23\56\1\146\1\151\1\153\1\155\4\uffff\1\157\1\161\1\uffff"+
        "\1\163\12\uffff\1\165\1\171\3\uffff\1\172\1\uffff\34\56\1\u00a0"+
        "\30\56\26\uffff\6\56\1\u00c3\31\56\1\u00dd\2\56\1\u00e0\1\uffff"+
        "\7\56\1\u00e8\1\u00e9\1\u00ea\1\u00ed\27\56\1\uffff\3\56\1\u010b"+
        "\13\56\1\u0117\1\u0118\1\u0119\3\56\1\u011d\1\u011e\1\56\1\u0121"+
        "\1\uffff\2\56\1\uffff\1\u0124\6\56\3\uffff\2\56\1\uffff\3\56\1\u0130"+
        "\1\u0131\4\56\1\u0137\17\56\1\u0147\3\56\1\uffff\1\u014b\1\56\1"+
        "\u014e\6\56\1\u0156\1\56\3\uffff\2\56\1\u015b\2\uffff\2\56\1\uffff"+
        "\2\56\1\uffff\1\u0160\4\56\1\u0165\1\56\1\u0167\3\56\2\uffff\1\u016b"+
        "\1\56\1\u0170\1\u0171\1\56\1\uffff\4\56\1\u0177\3\56\1\u017b\5\56"+
        "\1\u0182\1\uffff\3\56\1\uffff\1\u0186\1\56\1\uffff\5\56\1\u018e"+
        "\1\u018f\1\uffff\4\56\1\uffff\3\56\1\u0197\1\uffff\4\56\1\uffff"+
        "\1\56\1\uffff\3\56\1\uffff\4\56\2\uffff\2\56\1\u01a7\2\56\1\uffff"+
        "\3\56\1\uffff\3\56\1\u01b0\2\56\1\uffff\3\56\1\uffff\1\56\1\u01b7"+
        "\4\56\1\u01bc\2\uffff\1\56\1\u01be\5\56\1\uffff\2\56\1\u01c6\5\56"+
        "\1\u01cc\4\56\1\u01d1\1\u01d2\1\uffff\10\56\1\uffff\2\56\1\u01dd"+
        "\1\56\1\u01df\1\56\1\uffff\4\56\1\uffff\1\56\1\uffff\2\56\1\u01e8"+
        "\2\56\1\u01eb\1\56\1\uffff\3\56\1\u01f2\1\u01f3\1\uffff\1\u01f4"+
        "\3\56\2\uffff\1\u01f8\1\56\1\u01fa\1\u01fb\3\56\1\u01ff\2\56\1\uffff"+
        "\1\u0202\1\uffff\1\u0203\1\56\1\u0205\1\u0206\3\56\1\u020a\1\uffff"+
        "\2\56\1\uffff\1\u020d\1\u020e\2\56\1\u0211\1\56\3\uffff\1\56\1\u0214"+
        "\1\56\1\uffff\1\56\2\uffff\1\56\1\u0218\1\u0219\1\uffff\2\56\2\uffff"+
        "\1\56\2\uffff\1\u021d\1\u021e\1\56\1\uffff\1\u0220\1\56\2\uffff"+
        "\1\u0222\1\56\1\uffff\2\56\1\uffff\1\u0226\2\56\2\uffff\1\u0229"+
        "\1\u022a\1\56\2\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\2\56"+
        "\2\uffff\1\u0233\1\u0235\1\u0236\4\56\1\u023b\1\uffff\1\56\2\uffff"+
        "\2\56\1\u023f\1\56\1\uffff\1\u0241\2\56\1\uffff\1\56\1\uffff\3\56"+
        "\1\u0248\2\56\1\uffff\1\56\1\u024c\1\56\1\uffff\1\u024e\1\uffff";
    static final String DFA15_eofS =
        "\u024f\uffff";
    static final String DFA15_minS =
        "\1\11\1\146\1\141\2\145\1\142\1\145\1\141\1\142\1\145\1\143\1\145"+
        "\1\156\1\157\1\150\1\163\1\145\1\165\2\141\1\60\1\55\1\133\1\135"+
        "\4\uffff\1\173\1\175\1\uffff\1\72\12\uffff\1\75\1\55\3\uffff\1\56"+
        "\1\uffff\1\155\1\160\1\144\1\104\1\162\2\154\1\156\1\146\1\157\1"+
        "\141\1\160\1\155\1\165\1\166\1\156\1\116\1\157\1\145\1\163\1\154"+
        "\1\151\1\144\1\163\1\164\2\144\1\154\1\60\1\165\1\153\1\155\1\113"+
        "\1\151\1\145\1\164\1\145\1\170\1\143\1\144\1\145\1\156\1\145\1\162"+
        "\1\151\1\146\1\147\1\145\1\162\1\163\1\145\1\154\1\171\26\uffff"+
        "\1\151\1\157\1\145\1\164\2\145\1\60\1\164\1\163\1\143\1\164\1\145"+
        "\1\153\2\162\1\141\1\151\1\142\1\164\1\162\1\145\1\120\1\114\2\160"+
        "\2\141\1\164\1\156\1\145\1\164\1\157\1\60\1\124\1\141\1\60\1\uffff"+
        "\2\145\1\160\1\145\1\164\1\162\1\141\4\60\1\155\1\141\1\164\1\156"+
        "\1\144\1\156\1\145\1\150\1\162\2\164\1\146\1\155\1\165\1\167\1\163"+
        "\2\162\1\141\1\156\1\146\1\141\1\145\1\uffff\2\145\1\164\1\60\1"+
        "\162\1\111\1\164\1\145\1\162\1\141\1\157\1\141\1\143\2\162\3\60"+
        "\1\165\1\155\1\151\2\60\1\162\1\60\1\uffff\1\157\1\171\1\uffff\1"+
        "\60\1\156\1\154\1\171\1\164\1\141\1\154\3\uffff\1\146\1\114\1\uffff"+
        "\1\145\1\164\1\145\2\60\1\147\1\162\1\164\1\171\1\60\1\146\1\151"+
        "\1\162\1\151\1\145\1\157\1\163\2\164\1\156\1\164\1\151\1\143\1\144"+
        "\1\162\1\60\1\151\1\160\1\157\1\uffff\1\60\1\156\1\60\1\117\1\141"+
        "\2\154\1\170\1\145\1\60\1\151\3\uffff\1\154\1\142\1\60\2\uffff\1"+
        "\141\1\162\1\uffff\1\103\1\163\1\uffff\1\60\1\141\1\167\1\145\1"+
        "\164\1\60\1\114\1\60\1\162\1\145\1\170\2\uffff\1\60\1\145\2\60\1"+
        "\141\1\uffff\1\151\1\170\1\151\1\164\1\60\1\162\1\151\1\103\1\60"+
        "\1\143\1\111\1\156\1\150\1\114\1\60\1\uffff\1\157\1\141\1\156\1"+
        "\uffff\1\60\1\114\1\uffff\1\151\1\160\1\164\1\151\1\163\2\60\1\uffff"+
        "\1\155\1\164\2\151\1\uffff\1\143\1\145\1\157\1\60\1\uffff\1\164"+
        "\1\157\1\144\1\157\1\uffff\1\151\1\uffff\1\141\1\101\1\164\1\uffff"+
        "\1\124\1\156\1\157\1\160\2\uffff\1\154\1\170\1\60\1\164\1\151\1"+
        "\uffff\1\144\1\156\1\157\1\uffff\1\145\1\156\1\145\1\60\1\157\1"+
        "\160\1\uffff\1\156\1\143\1\145\1\uffff\1\116\1\60\1\147\1\124\1"+
        "\157\1\172\1\60\2\uffff\1\141\1\60\1\147\1\156\1\164\1\141\1\156"+
        "\1\uffff\1\145\1\162\1\60\1\162\1\156\1\164\1\163\1\156\1\60\1\157"+
        "\1\143\1\156\1\141\2\60\1\uffff\1\171\1\166\1\163\1\147\1\156\1"+
        "\117\1\143\1\144\1\uffff\1\167\1\160\1\60\1\145\1\60\1\114\1\uffff"+
        "\1\150\1\157\1\162\1\145\1\uffff\1\162\1\uffff\1\165\1\145\1\60"+
        "\2\164\1\60\1\144\1\uffff\1\124\1\145\1\151\2\60\1\uffff\1\60\2"+
        "\145\1\143\2\uffff\1\60\1\145\2\60\1\164\1\146\1\162\1\60\2\145"+
        "\1\uffff\1\60\1\uffff\1\60\1\164\2\60\1\162\1\171\1\141\1\60\1\uffff"+
        "\2\145\1\uffff\2\60\1\144\1\145\1\60\1\157\3\uffff\1\117\1\60\1"+
        "\145\1\uffff\1\124\2\uffff\1\145\2\60\1\uffff\2\162\2\uffff\1\124"+
        "\2\uffff\2\60\1\164\1\uffff\1\60\1\170\2\uffff\1\60\1\155\1\uffff"+
        "\2\156\1\uffff\1\60\1\145\1\170\2\uffff\2\60\1\157\2\uffff\1\145"+
        "\1\uffff\1\164\1\uffff\1\160\1\124\1\154\1\uffff\1\155\1\164\2\uffff"+
        "\3\60\1\154\1\145\1\171\1\160\1\60\1\uffff\1\63\2\uffff\1\141\1"+
        "\155\1\60\1\154\1\uffff\1\60\1\164\1\160\1\uffff\1\141\1\uffff\1"+
        "\145\1\154\1\164\1\60\1\141\1\145\1\uffff\1\164\1\60\1\145\1\uffff"+
        "\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\u00ff\1\163\1\165\1\157\1\171\1\157\1\162\2\165\2\162\1\145"+
        "\1\163\1\162\1\157\1\163\1\151\1\165\1\162\1\141\1\u00ff\1\76\1"+
        "\133\1\135\4\uffff\1\173\1\175\1\uffff\1\72\12\uffff\1\75\1\76\3"+
        "\uffff\1\71\1\uffff\1\155\1\160\1\166\1\104\1\162\2\154\1\156\1"+
        "\170\2\157\1\162\1\156\1\165\1\166\1\156\1\116\1\157\1\146\1\163"+
        "\1\154\1\151\1\144\1\163\1\164\2\144\1\167\1\u00ff\1\165\1\153\1"+
        "\155\1\113\1\151\1\145\1\164\1\145\1\170\1\143\1\165\1\145\1\156"+
        "\1\145\1\162\1\151\1\146\1\147\1\145\1\162\1\163\1\151\1\154\1\171"+
        "\26\uffff\1\151\1\157\1\145\1\164\2\145\1\u00ff\1\164\1\163\1\143"+
        "\1\164\1\145\1\153\2\162\1\141\1\151\1\142\1\164\1\162\1\145\1\120"+
        "\1\114\2\160\2\141\1\164\1\156\1\145\1\164\1\157\1\u00ff\1\124\1"+
        "\141\1\u00ff\1\uffff\2\145\1\160\1\145\1\164\1\162\1\141\4\u00ff"+
        "\1\155\1\141\1\164\1\156\1\144\1\156\1\145\1\150\1\162\2\164\1\146"+
        "\1\157\1\165\1\167\1\163\2\162\1\141\1\156\1\146\1\141\1\145\1\uffff"+
        "\2\145\1\164\1\u00ff\1\162\1\111\1\164\1\145\1\162\1\141\1\157\1"+
        "\141\1\143\2\162\3\u00ff\1\165\1\155\1\151\2\u00ff\1\162\1\u00ff"+
        "\1\uffff\1\157\1\171\1\uffff\1\u00ff\1\156\1\154\1\171\1\164\1\141"+
        "\1\154\3\uffff\1\146\1\114\1\uffff\1\145\1\164\1\145\2\u00ff\1\147"+
        "\1\162\1\164\1\171\1\u00ff\1\146\1\151\1\162\1\151\1\145\1\157\1"+
        "\163\2\164\1\156\1\164\1\151\1\143\1\144\1\162\1\u00ff\1\151\1\160"+
        "\1\157\1\uffff\1\u00ff\1\156\1\u00ff\1\122\1\141\2\154\1\170\1\145"+
        "\1\u00ff\1\151\3\uffff\1\154\1\142\1\u00ff\2\uffff\1\141\1\162\1"+
        "\uffff\1\103\1\163\1\uffff\1\u00ff\1\141\1\167\1\145\1\164\1\u00ff"+
        "\1\114\1\u00ff\1\162\1\145\1\170\2\uffff\1\u00ff\1\163\2\u00ff\1"+
        "\141\1\uffff\1\151\1\170\1\151\1\164\1\u00ff\1\162\1\151\1\103\1"+
        "\u00ff\1\143\1\111\1\156\1\150\1\125\1\u00ff\1\uffff\1\157\1\141"+
        "\1\156\1\uffff\1\u00ff\1\142\1\uffff\1\151\1\160\1\164\1\151\1\163"+
        "\2\u00ff\1\uffff\1\155\1\164\2\151\1\uffff\1\143\1\145\1\157\1\u00ff"+
        "\1\uffff\1\164\1\157\1\144\1\157\1\uffff\1\151\1\uffff\1\141\1\111"+
        "\1\164\1\uffff\1\124\1\156\1\157\1\160\2\uffff\1\154\1\170\1\u00ff"+
        "\1\164\1\151\1\uffff\1\144\1\156\1\157\1\uffff\1\145\1\156\1\145"+
        "\1\u00ff\1\157\1\160\1\uffff\1\156\1\143\1\145\1\uffff\1\116\1\u00ff"+
        "\1\147\1\124\1\157\1\172\1\u00ff\2\uffff\1\141\1\u00ff\1\147\1\156"+
        "\1\164\1\141\1\156\1\uffff\1\145\1\162\1\u00ff\1\162\1\156\1\164"+
        "\1\163\1\156\1\u00ff\1\157\1\143\1\156\1\141\2\u00ff\1\uffff\1\171"+
        "\1\166\1\163\1\147\1\156\1\117\1\143\1\144\1\uffff\1\167\1\160\1"+
        "\u00ff\1\145\1\u00ff\1\114\1\uffff\1\150\1\157\1\162\1\145\1\uffff"+
        "\1\162\1\uffff\1\165\1\145\1\u00ff\2\164\1\u00ff\1\144\1\uffff\1"+
        "\163\1\145\1\151\2\u00ff\1\uffff\1\u00ff\2\145\1\143\2\uffff\1\u00ff"+
        "\1\145\2\u00ff\1\164\1\146\1\162\1\u00ff\2\145\1\uffff\1\u00ff\1"+
        "\uffff\1\u00ff\1\164\2\u00ff\1\162\1\171\1\141\1\u00ff\1\uffff\2"+
        "\145\1\uffff\2\u00ff\1\144\1\145\1\u00ff\1\157\3\uffff\1\117\1\u00ff"+
        "\1\145\1\uffff\1\124\2\uffff\1\145\2\u00ff\1\uffff\2\162\2\uffff"+
        "\1\124\2\uffff\2\u00ff\1\164\1\uffff\1\u00ff\1\170\2\uffff\1\u00ff"+
        "\1\155\1\uffff\2\156\1\uffff\1\u00ff\1\145\1\170\2\uffff\2\u00ff"+
        "\1\157\2\uffff\1\145\1\uffff\1\164\1\uffff\1\160\1\124\1\154\1\uffff"+
        "\1\155\1\164\2\uffff\3\u00ff\1\154\1\145\1\171\1\160\1\u00ff\1\uffff"+
        "\1\63\2\uffff\1\141\1\155\1\u00ff\1\154\1\uffff\1\u00ff\1\164\1"+
        "\160\1\uffff\1\141\1\uffff\1\145\1\154\1\164\1\u00ff\1\141\1\145"+
        "\1\uffff\1\164\1\u00ff\1\145\1\uffff\1\u00ff\1\uffff";
    static final String DFA15_acceptS =
        "\30\uffff\1\133\1\134\1\135\1\136\2\uffff\1\143\1\uffff\1\146\1"+
        "\147\1\150\1\151\1\152\1\153\1\156\1\157\1\160\1\161\2\uffff\1\170"+
        "\1\171\1\172\1\uffff\1\175\65\uffff\1\106\1\126\1\154\1\155\1\131"+
        "\1\127\1\132\1\130\1\141\1\137\1\142\1\140\1\145\1\144\1\164\1\162"+
        "\1\165\1\166\1\167\1\163\1\173\1\174\44\uffff\1\113\42\uffff\1\31"+
        "\31\uffff\1\57\2\uffff\1\125\7\uffff\1\120\1\20\1\21\2\uffff\1\124"+
        "\35\uffff\1\4\13\uffff\1\52\1\7\1\34\3\uffff\1\105\1\121\2\uffff"+
        "\1\30\2\uffff\1\14\13\uffff\1\23\1\73\5\uffff\1\35\17\uffff\1\63"+
        "\3\uffff\1\76\2\uffff\1\102\7\uffff\1\6\4\uffff\1\10\4\uffff\1\33"+
        "\4\uffff\1\111\1\uffff\1\70\3\uffff\1\24\4\uffff\1\116\1\32\5\uffff"+
        "\1\51\3\uffff\1\60\6\uffff\1\36\3\uffff\1\11\7\uffff\1\117\1\100"+
        "\7\uffff\1\104\17\uffff\1\55\10\uffff\1\2\6\uffff\1\15\4\uffff\1"+
        "\72\1\uffff\1\103\7\uffff\1\47\5\uffff\1\26\4\uffff\1\37\1\41\12"+
        "\uffff\1\114\1\uffff\1\43\10\uffff\1\13\2\uffff\1\45\6\uffff\1\22"+
        "\1\54\1\27\3\uffff\1\65\1\uffff\1\74\1\1\3\uffff\1\71\2\uffff\1"+
        "\42\1\5\1\uffff\1\62\1\40\3\uffff\1\12\2\uffff\1\17\1\66\2\uffff"+
        "\1\44\2\uffff\1\56\3\uffff\1\77\1\112\3\uffff\1\123\1\16\1\uffff"+
        "\1\25\1\uffff\1\101\3\uffff\1\67\2\uffff\1\75\1\122\10\uffff\1\53"+
        "\1\uffff\1\64\1\61\4\uffff\1\3\3\uffff\1\115\1\uffff\1\50\6\uffff"+
        "\1\110\3\uffff\1\107\1\uffff\1\46";
    static final String DFA15_specialS =
        "\u024f\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\30\1\60\1\41\1\43\2"+
            "\uffff\1\56\1\32\1\33\1\46\1\50\1\31\1\25\1\45\1\47\12\57\1"+
            "\37\1\36\1\53\1\51\1\52\1\42\1\44\32\56\1\26\1\uffff\1\27\1"+
            "\uffff\1\56\1\uffff\1\10\1\56\1\15\1\6\1\14\1\2\1\56\1\13\1"+
            "\1\1\56\1\24\1\3\1\7\1\5\1\12\1\22\1\21\1\20\1\4\1\11\1\17\1"+
            "\23\1\16\3\56\1\34\1\40\1\35\102\uffff\27\56\1\uffff\37\56\1"+
            "\uffff\10\56",
            "\1\61\6\uffff\1\62\1\63\4\uffff\1\64",
            "\1\67\7\uffff\1\66\5\uffff\1\65\5\uffff\1\70",
            "\1\71\11\uffff\1\72",
            "\1\74\11\uffff\1\76\4\uffff\1\73\4\uffff\1\75",
            "\1\101\2\uffff\1\77\11\uffff\1\100",
            "\1\103\3\uffff\1\104\10\uffff\1\102",
            "\1\106\15\uffff\1\107\5\uffff\1\105",
            "\1\110\1\uffff\1\113\7\uffff\1\114\1\uffff\1\112\4\uffff\1"+
            "\115\1\uffff\1\111",
            "\1\120\11\uffff\1\117\2\uffff\1\116",
            "\1\124\11\uffff\1\122\1\125\1\uffff\1\123\1\uffff\1\121",
            "\1\126",
            "\1\130\4\uffff\1\127",
            "\1\132\2\uffff\1\131",
            "\1\133\6\uffff\1\134",
            "\1\135",
            "\1\136\3\uffff\1\137",
            "\1\140",
            "\1\141\15\uffff\1\142\2\uffff\1\143",
            "\1\144",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\145\25\56"+
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\147\20\uffff\1\150",
            "\1\152",
            "\1\154",
            "",
            "",
            "",
            "",
            "\1\156",
            "\1\160",
            "",
            "\1\162",
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
            "\1\164",
            "\1\170\17\uffff\1\166\1\167",
            "",
            "",
            "",
            "\1\173\1\uffff\12\57",
            "",
            "\1\174",
            "\1\175",
            "\1\u0080\16\uffff\1\177\2\uffff\1\176",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086\21\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089\15\uffff\1\u008a",
            "\1\u008b\1\uffff\1\u008c",
            "\1\u008d\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009f\12\uffff\1\u009e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab\20\uffff\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7\3\uffff\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
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
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\2\56\1\u00c2\1\56"+
            "\1\u00c1\25\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00de",
            "\1\u00df",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\15\56\1\u00ec\1\u00eb\13\56\4\uffff\1\56\1"+
            "\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fb\1\uffff\1\u00fa",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\12\56\7\uffff\15\56\1\u010a\4\56\1\u0109\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011f",
            "\12\56\7\uffff\2\56\1\u0120\27\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0122",
            "\1\u0123",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "",
            "",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56\1\u0136\21"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u014c",
            "\12\56\7\uffff\15\56\1\u014d\14\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0150\2\uffff\1\u014f",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0157",
            "",
            "",
            "",
            "\1\u0158",
            "\1\u0159",
            "\12\56\7\uffff\13\56\1\u015a\16\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u015c",
            "\1\u015d",
            "",
            "\1\u015e",
            "\1\u015f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0166",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u016d\15\uffff\1\u016c",
            "\12\56\7\uffff\15\56\1\u016e\4\56\1\u016f\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0172",
            "",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180\10\uffff\1\u0181",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0188\25\uffff\1\u0187",
            "",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "",
            "\1\u0194",
            "\1\u0195",
            "\1\u0196",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "",
            "\1\u019c",
            "",
            "\1\u019d",
            "\1\u019e\7\uffff\1\u019f",
            "\1\u01a0",
            "",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "\1\u01a4",
            "",
            "",
            "\1\u01a5",
            "\1\u01a6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01a8",
            "\1\u01a9",
            "",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b1",
            "\1\u01b2",
            "",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "",
            "\1\u01b6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b8",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u01bd",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "\1\u01c3",
            "",
            "\1\u01c4",
            "\1\u01c5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01cd",
            "\1\u01ce",
            "\1\u01cf",
            "\1\u01d0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "",
            "\1\u01db",
            "\1\u01dc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01de",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01e0",
            "",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "\1\u01e7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01e9",
            "\1\u01ea",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01ec",
            "",
            "\1\u01ef\20\uffff\1\u01ee\15\uffff\1\u01ed",
            "\1\u01f0",
            "\1\u01f1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f5",
            "\1\u01f6",
            "\1\u01f7",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f9",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01fc",
            "\1\u01fd",
            "\1\u01fe",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0200",
            "\1\u0201",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0204",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0207",
            "\1\u0208",
            "\1\u0209",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u020b",
            "\1\u020c",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u020f",
            "\1\u0210",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0212",
            "",
            "",
            "",
            "\1\u0213",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0215",
            "",
            "\1\u0216",
            "",
            "",
            "\1\u0217",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u021a",
            "\1\u021b",
            "",
            "",
            "\1\u021c",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u021f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0221",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0223",
            "",
            "\1\u0224",
            "\1\u0225",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0227",
            "\1\u0228",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u022b",
            "",
            "",
            "\1\u022c",
            "",
            "\1\u022d",
            "",
            "\1\u022e",
            "\1\u022f",
            "\1\u0230",
            "",
            "\1\u0231",
            "\1\u0232",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\25\56\1\u0234\4\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0237",
            "\1\u0238",
            "\1\u0239",
            "\1\u023a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u023c",
            "",
            "",
            "\1\u023d",
            "\1\u023e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0240",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0242",
            "\1\u0243",
            "",
            "\1\u0244",
            "",
            "\1\u0245",
            "\1\u0246",
            "\1\u0247",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0249",
            "\1\u024a",
            "",
            "\1\u024b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u024d",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}