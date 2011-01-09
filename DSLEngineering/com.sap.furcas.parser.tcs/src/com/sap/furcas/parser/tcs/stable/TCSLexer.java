// $ANTLR 3.1.1 /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g 2011-01-08 22:56:26

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
    public static final int RPAREN=11;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=43;
    public static final int EQ=10;
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

    public TCSLexer() {;} 
    public TCSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TCSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g"; }

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:117:7: ( 'forcedUpper' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:117:9: 'forcedUpper'
            {
            match("forcedUpper"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:118:7: ( 'filter' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:118:9: 'filter'
            {
            match("filter"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:119:7: ( 'serializer' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:119:9: 'serializer'
            {
            match("serializer"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:120:7: ( 'operatored' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:120:9: 'operatored'
            {
            match("operatored"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:121:7: ( 'disambiguate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:121:9: 'disambiguate'
            {
            match("disambiguate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:122:7: ( 'multiLine' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:122:9: 'multiLine'
            {
            match("multiLine"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:123:7: ( 'mode' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:123:9: 'mode'
            {
            match("mode"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:124:7: ( 'refersTo' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:124:9: 'refersTo'
            {
            match("refersTo"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:125:7: ( 'enumerationTemplate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:125:9: 'enumerationTemplate'
            {
            match("enumerationTemplate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:126:7: ( 'all' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:126:9: 'all'
            {
            match("all"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:127:7: ( 'invert' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:127:9: 'invert'
            {
            match("invert"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:128:7: ( 'end' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:128:9: 'end'
            {
            match("end"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:129:7: ( 'foreach' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:129:9: 'foreach'
            {
            match("foreach"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:130:7: ( 'indentIncr' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:130:9: 'indentIncr'
            {
            match("indentIncr"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:131:7: ( 'orKeyword' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:131:9: 'orKeyword'
            {
            match("orKeyword"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:132:7: ( 'leftNone' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:132:9: 'leftNone'
            {
            match("leftNone"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:133:7: ( 'never' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:133:9: 'never'
            {
            match("never"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:134:7: ( 'false' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:134:9: 'false'
            {
            match("false"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:135:7: ( 'primitiveTemplate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:135:9: 'primitiveTemplate'
            {
            match("primitiveTemplate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:136:7: ( 'template' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:136:9: 'template'
            {
            match("template"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:137:7: ( 'rightNone' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:137:9: 'rightNone'
            {
            match("rightNone"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:138:7: ( 'addToContext' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:138:9: 'addToContext'
            {
            match("addToContext"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:139:7: ( 'using' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:139:9: 'using'
            {
            match("using"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:140:7: ( 'multi' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:140:9: 'multi'
            {
            match("multi"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:141:7: ( 'one' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:141:9: 'one'
            {
            match("one"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:142:7: ( 'octal' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:142:9: 'octal'
            {
            match("octal"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:143:7: ( 'lexer' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:143:9: 'lexer'
            {
            match("lexer"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:144:7: ( 'startNL' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:144:9: 'startNL'
            {
            match("startNL"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:145:7: ( 'rightSpace' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:145:9: 'rightSpace'
            {
            match("rightSpace"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:146:7: ( 'priority' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:146:9: 'priority'
            {
            match("priority"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:147:7: ( 'hex' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:147:9: 'hex'
            {
            match("hex"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:148:7: ( 'symbols' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:148:9: 'symbols'
            {
            match("symbols"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:149:7: ( 'main' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:149:9: 'main'
            {
            match("main"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:150:7: ( 'right' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:150:9: 'right'
            {
            match("right"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:151:7: ( 'startNbNL' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:151:9: 'startNbNL'
            {
            match("startNbNL"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:152:7: ( 'nonPrimary' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:152:9: 'nonPrimary'
            {
            match("nonPrimary"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:153:7: ( 'createAs' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:153:9: 'createAs'
            {
            match("createAs"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:154:7: ( 'default' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:154:9: 'default'
            {
            match("default"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:155:7: ( 'autoCreate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:155:9: 'autoCreate'
            {
            match("autoCreate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:156:7: ( 'abstract' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:156:9: 'abstract'
            {
            match("abstract"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:157:7: ( 'for' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:157:9: 'for'
            {
            match("for"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:158:7: ( 'ifmissing' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:158:9: 'ifmissing'
            {
            match("ifmissing"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:159:7: ( 'partial' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:159:9: 'partial'
            {
            match("partial"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:160:7: ( 'query' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:160:9: 'query'
            {
            match("query"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:161:7: ( 'value' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:161:9: 'value'
            {
            match("value"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:162:7: ( 'isDefined' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:162:9: 'isDefined'
            {
            match("isDefined"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:163:7: ( 'referenceOnly' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:163:9: 'referenceOnly'
            {
            match("referenceOnly"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:164:7: ( 'operatorTemplate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:164:9: 'operatorTemplate'
            {
            match("operatorTemplate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:165:7: ( 'postfix' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:165:9: 'postfix'
            {
            match("postfix"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:166:7: ( 'deep' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:166:9: 'deep'
            {
            match("deep"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:167:7: ( 'part' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:167:9: 'part'
            {
            match("part"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:168:8: ( 'auto' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:168:10: 'auto'
            {
            match("auto"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:169:8: ( 'left' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:169:10: 'left'
            {
            match("left"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:170:8: ( 'storeOpTo' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:170:10: 'storeOpTo'
            {
            match("storeOpTo"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:171:8: ( 'endOfLine' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:171:10: 'endOfLine'
            {
            match("endOfLine"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:172:8: ( 'and' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:172:10: 'and'
            {
            match("and"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:173:8: ( 'operators' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:173:10: 'operators'
            {
            match("operators"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:174:8: ( 'drop' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:174:10: 'drop'
            {
            match("drop"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:175:8: ( 'disambiguateV3' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:175:10: 'disambiguateV3'
            {
            match("disambiguateV3"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:176:8: ( 'separator' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:176:10: 'separator'
            {
            match("separator"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:177:8: ( 'storeRightTo' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:177:10: 'storeRightTo'
            {
            match("storeRightTo"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:178:8: ( 'syntax' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:178:10: 'syntax'
            {
            match("syntax"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:179:8: ( 'semDisambiguate' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:179:10: 'semDisambiguate'
            {
            match("semDisambiguate"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:180:8: ( 'function' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:180:10: 'function'
            {
            match("function"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:181:8: ( 'esc' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:181:10: 'esc'
            {
            match("esc"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:182:8: ( 'importContext' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:182:10: 'importContext'
            {
            match("importContext"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:183:8: ( 'source' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:183:10: 'source'
            {
            match("source"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:184:8: ( 'nbNL' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:184:10: 'nbNL'
            {
            match("nbNL"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:185:8: ( 'k' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:185:10: 'k'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:186:8: ( 'start' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:186:10: 'start'
            {
            match("start"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:187:8: ( 'lookIn' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:187:10: 'lookIn'
            {
            match("lookIn"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:188:8: ( 'as' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:188:10: 'as'
            {
            match("as"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:189:8: ( 'context' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:189:10: 'context'
            {
            match("context"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:190:8: ( 'endNL' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:190:10: 'endNL'
            {
            match("endNL"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:191:8: ( 'when' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:191:10: 'when'
            {
            match("when"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:192:8: ( 'forcedLower' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:192:10: 'forcedLower'
            {
            match("forcedLower"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:193:8: ( 'omitted' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:193:10: 'omitted'
            {
            match("omitted"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:194:8: ( 'token' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:194:10: 'token'
            {
            match("token"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:195:8: ( 'leftSpace' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:195:10: 'leftSpace'
            {
            match("leftSpace"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:196:8: ( 'word' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:196:10: 'word'
            {
            match("word"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:197:8: ( 'true' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:197:10: 'true'
            {
            match("true"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:198:8: ( 'keywords' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:198:10: 'keywords'
            {
            match("keywords"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:199:8: ( 'createIn' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:199:10: 'createIn'
            {
            match("createIn"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:200:8: ( 'always' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:200:10: 'always'
            {
            match("always"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:201:8: ( 'instanceOf' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:201:10: 'instanceOf'
            {
            match("instanceOf"); 


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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2048:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); 

            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2049:15: ~ ( '\\r' | '\\n' )
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2054:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); 

            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2055:44: ( '\\n' | ~ '\\n' )
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2060:3: ( '[' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2061:3: '['
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2066:3: ( ']' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2067:3: ']'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2072:3: ( '[[' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2073:3: '[['
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2078:3: ( ']]' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2079:3: ']]'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2084:3: ( '!' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2085:3: '!'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2090:3: ( ',' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2091:3: ','
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2096:3: ( '(' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2097:3: '('
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2102:3: ( ')' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2103:3: ')'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2108:3: ( '{' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2109:3: '{'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2114:3: ( '}' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2115:3: '}'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2120:3: ( '{{' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2121:3: '{{'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2126:3: ( '}}' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2127:3: '}}'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2132:3: ( ';' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2133:3: ';'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2138:3: ( ':' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2139:3: ':'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2144:3: ( '::' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2145:3: '::'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2150:3: ( '|' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2151:3: '|'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2156:3: ( '#' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2157:3: '#'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2162:3: ( '?' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2163:3: '?'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2168:3: ( '$' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2169:3: '$'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2174:3: ( '@' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2175:3: '@'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2180:3: ( '.' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2181:3: '.'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2186:3: ( '->' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2187:3: '->'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2192:3: ( '-' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2193:3: '-'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2198:3: ( '*' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2199:3: '*'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2204:3: ( '/' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2205:3: '/'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2210:3: ( '+' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2211:3: '+'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2216:3: ( '=' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2217:3: '='
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2222:3: ( '>' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2223:3: '>'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2228:3: ( '<' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2229:3: '<'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2234:3: ( '>=' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2235:3: '>='
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2240:3: ( '<=' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2241:3: '<='
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2246:3: ( '<>' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2247:3: '<>'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2252:3: ( '<-' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2253:3: '<-'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2261:9: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2261:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2261:17: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2261:25: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2262:25: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2263:25: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2264:25: '\\n'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2270:9: ( ( ' ' | '\\t' ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2270:17: ( ' ' | '\\t' )
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2277:9: ( '0' .. '9' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2277:17: '0' .. '9'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2282:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2296:9: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2298:9: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2298:9: ( ALPHA )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2298:10: ALPHA
            {
            mALPHA(); 

            }

            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2298:17: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2316:9: ( ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2316:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2316:17: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2317:25: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2318:25: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); 
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2319:25: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2319:33: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2320:33: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2321:33: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2333:9: ( ( DIGIT )+ )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2333:17: ( DIGIT )+
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2333:17: ( DIGIT )+
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
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2333:18: DIGIT
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:9: ( ( DIGIT )+ '.' ( DIGIT )* )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:17: ( DIGIT )+ '.' ( DIGIT )*
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:17: ( DIGIT )+
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
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:17: DIGIT
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:28: ( DIGIT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2336:28: DIGIT
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2340:9: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2340:17: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2341:17: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2341:25: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2342:25: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2343:25: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2344:25: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2345:25: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2346:25: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2347:25: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2348:25: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2349:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2349:25: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2350:33: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2350:33: ( '0' .. '3' )
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2350:34: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2351:33: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2352:41: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2352:41: ( '0' .. '7' )
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2352:42: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2353:41: ( '0' .. '7' )?
                                    int alt10=2;
                                    int LA10_0 = input.LA(1);

                                    if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                        alt10=1;
                                    }
                                    switch (alt10) {
                                        case 1 :
                                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2354:49: '0' .. '7'
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
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2357:33: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2357:33: ( '4' .. '7' )
                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2357:34: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2358:33: ( ( '0' .. '7' ) )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2359:41: ( '0' .. '7' )
                                    {
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2359:41: ( '0' .. '7' )
                                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2359:42: '0' .. '7'
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
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2368:9: ( '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2368:17: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2369:17: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2369:25: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2370:25: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:2371:25: ~ ( '\\\\' | '\\\"' | '\\n' )
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
        // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt16=126;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:10: T__49
                {
                mT__49(); 

                }
                break;
            case 2 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:16: T__50
                {
                mT__50(); 

                }
                break;
            case 3 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:22: T__51
                {
                mT__51(); 

                }
                break;
            case 4 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:28: T__52
                {
                mT__52(); 

                }
                break;
            case 5 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:34: T__53
                {
                mT__53(); 

                }
                break;
            case 6 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:40: T__54
                {
                mT__54(); 

                }
                break;
            case 7 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:46: T__55
                {
                mT__55(); 

                }
                break;
            case 8 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:52: T__56
                {
                mT__56(); 

                }
                break;
            case 9 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:58: T__57
                {
                mT__57(); 

                }
                break;
            case 10 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:64: T__58
                {
                mT__58(); 

                }
                break;
            case 11 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:70: T__59
                {
                mT__59(); 

                }
                break;
            case 12 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:76: T__60
                {
                mT__60(); 

                }
                break;
            case 13 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:82: T__61
                {
                mT__61(); 

                }
                break;
            case 14 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:88: T__62
                {
                mT__62(); 

                }
                break;
            case 15 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:94: T__63
                {
                mT__63(); 

                }
                break;
            case 16 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:100: T__64
                {
                mT__64(); 

                }
                break;
            case 17 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:106: T__65
                {
                mT__65(); 

                }
                break;
            case 18 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:112: T__66
                {
                mT__66(); 

                }
                break;
            case 19 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:118: T__67
                {
                mT__67(); 

                }
                break;
            case 20 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:124: T__68
                {
                mT__68(); 

                }
                break;
            case 21 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:130: T__69
                {
                mT__69(); 

                }
                break;
            case 22 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:136: T__70
                {
                mT__70(); 

                }
                break;
            case 23 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:142: T__71
                {
                mT__71(); 

                }
                break;
            case 24 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:148: T__72
                {
                mT__72(); 

                }
                break;
            case 25 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:154: T__73
                {
                mT__73(); 

                }
                break;
            case 26 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:160: T__74
                {
                mT__74(); 

                }
                break;
            case 27 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:166: T__75
                {
                mT__75(); 

                }
                break;
            case 28 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:172: T__76
                {
                mT__76(); 

                }
                break;
            case 29 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:178: T__77
                {
                mT__77(); 

                }
                break;
            case 30 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:184: T__78
                {
                mT__78(); 

                }
                break;
            case 31 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:190: T__79
                {
                mT__79(); 

                }
                break;
            case 32 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:196: T__80
                {
                mT__80(); 

                }
                break;
            case 33 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:202: T__81
                {
                mT__81(); 

                }
                break;
            case 34 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:208: T__82
                {
                mT__82(); 

                }
                break;
            case 35 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:214: T__83
                {
                mT__83(); 

                }
                break;
            case 36 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:220: T__84
                {
                mT__84(); 

                }
                break;
            case 37 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:226: T__85
                {
                mT__85(); 

                }
                break;
            case 38 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:232: T__86
                {
                mT__86(); 

                }
                break;
            case 39 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:238: T__87
                {
                mT__87(); 

                }
                break;
            case 40 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:244: T__88
                {
                mT__88(); 

                }
                break;
            case 41 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:250: T__89
                {
                mT__89(); 

                }
                break;
            case 42 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:256: T__90
                {
                mT__90(); 

                }
                break;
            case 43 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:262: T__91
                {
                mT__91(); 

                }
                break;
            case 44 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:268: T__92
                {
                mT__92(); 

                }
                break;
            case 45 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:274: T__93
                {
                mT__93(); 

                }
                break;
            case 46 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:280: T__94
                {
                mT__94(); 

                }
                break;
            case 47 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:286: T__95
                {
                mT__95(); 

                }
                break;
            case 48 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:292: T__96
                {
                mT__96(); 

                }
                break;
            case 49 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:298: T__97
                {
                mT__97(); 

                }
                break;
            case 50 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:304: T__98
                {
                mT__98(); 

                }
                break;
            case 51 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:310: T__99
                {
                mT__99(); 

                }
                break;
            case 52 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:316: T__100
                {
                mT__100(); 

                }
                break;
            case 53 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:323: T__101
                {
                mT__101(); 

                }
                break;
            case 54 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:330: T__102
                {
                mT__102(); 

                }
                break;
            case 55 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:337: T__103
                {
                mT__103(); 

                }
                break;
            case 56 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:344: T__104
                {
                mT__104(); 

                }
                break;
            case 57 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:351: T__105
                {
                mT__105(); 

                }
                break;
            case 58 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:358: T__106
                {
                mT__106(); 

                }
                break;
            case 59 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:365: T__107
                {
                mT__107(); 

                }
                break;
            case 60 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:372: T__108
                {
                mT__108(); 

                }
                break;
            case 61 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:379: T__109
                {
                mT__109(); 

                }
                break;
            case 62 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:386: T__110
                {
                mT__110(); 

                }
                break;
            case 63 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:393: T__111
                {
                mT__111(); 

                }
                break;
            case 64 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:400: T__112
                {
                mT__112(); 

                }
                break;
            case 65 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:407: T__113
                {
                mT__113(); 

                }
                break;
            case 66 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:414: T__114
                {
                mT__114(); 

                }
                break;
            case 67 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:421: T__115
                {
                mT__115(); 

                }
                break;
            case 68 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:428: T__116
                {
                mT__116(); 

                }
                break;
            case 69 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:435: T__117
                {
                mT__117(); 

                }
                break;
            case 70 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:442: T__118
                {
                mT__118(); 

                }
                break;
            case 71 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:449: T__119
                {
                mT__119(); 

                }
                break;
            case 72 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:456: T__120
                {
                mT__120(); 

                }
                break;
            case 73 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:463: T__121
                {
                mT__121(); 

                }
                break;
            case 74 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:470: T__122
                {
                mT__122(); 

                }
                break;
            case 75 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:477: T__123
                {
                mT__123(); 

                }
                break;
            case 76 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:484: T__124
                {
                mT__124(); 

                }
                break;
            case 77 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:491: T__125
                {
                mT__125(); 

                }
                break;
            case 78 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:498: T__126
                {
                mT__126(); 

                }
                break;
            case 79 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:505: T__127
                {
                mT__127(); 

                }
                break;
            case 80 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:512: T__128
                {
                mT__128(); 

                }
                break;
            case 81 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:519: T__129
                {
                mT__129(); 

                }
                break;
            case 82 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:526: T__130
                {
                mT__130(); 

                }
                break;
            case 83 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:533: T__131
                {
                mT__131(); 

                }
                break;
            case 84 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:540: T__132
                {
                mT__132(); 

                }
                break;
            case 85 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:547: T__133
                {
                mT__133(); 

                }
                break;
            case 86 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:554: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 87 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:562: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); 

                }
                break;
            case 88 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:581: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 89 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:589: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 90 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:597: DLSQUARE
                {
                mDLSQUARE(); 

                }
                break;
            case 91 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:606: DRSQUARE
                {
                mDRSQUARE(); 

                }
                break;
            case 92 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:615: EXCL
                {
                mEXCL(); 

                }
                break;
            case 93 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:620: COMA
                {
                mCOMA(); 

                }
                break;
            case 94 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:625: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 95 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:632: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 96 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:639: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 97 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:646: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 98 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:653: DLCURLY
                {
                mDLCURLY(); 

                }
                break;
            case 99 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:661: DRCURLY
                {
                mDRCURLY(); 

                }
                break;
            case 100 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:669: SEMI
                {
                mSEMI(); 

                }
                break;
            case 101 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:674: COLON
                {
                mCOLON(); 

                }
                break;
            case 102 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:680: DLCOLON
                {
                mDLCOLON(); 

                }
                break;
            case 103 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:688: PIPE
                {
                mPIPE(); 

                }
                break;
            case 104 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:693: SHARP
                {
                mSHARP(); 

                }
                break;
            case 105 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:699: QMARK
                {
                mQMARK(); 

                }
                break;
            case 106 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:705: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 107 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:712: AROBAS
                {
                mAROBAS(); 

                }
                break;
            case 108 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:719: POINT
                {
                mPOINT(); 

                }
                break;
            case 109 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:725: RARROW
                {
                mRARROW(); 

                }
                break;
            case 110 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:732: MINUS
                {
                mMINUS(); 

                }
                break;
            case 111 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:738: STAR
                {
                mSTAR(); 

                }
                break;
            case 112 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:743: SLASH
                {
                mSLASH(); 

                }
                break;
            case 113 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:749: PLUS
                {
                mPLUS(); 

                }
                break;
            case 114 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:754: EQ
                {
                mEQ(); 

                }
                break;
            case 115 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:757: GT
                {
                mGT(); 

                }
                break;
            case 116 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:760: LT
                {
                mLT(); 

                }
                break;
            case 117 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:763: GE
                {
                mGE(); 

                }
                break;
            case 118 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:766: LE
                {
                mLE(); 

                }
                break;
            case 119 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:769: NE
                {
                mNE(); 

                }
                break;
            case 120 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:772: LARROW
                {
                mLARROW(); 

                }
                break;
            case 121 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:779: NL
                {
                mNL(); 

                }
                break;
            case 122 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:782: WS
                {
                mWS(); 

                }
                break;
            case 123 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:785: NAME
                {
                mNAME(); 

                }
                break;
            case 124 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:790: INT
                {
                mINT(); 

                }
                break;
            case 125 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:794: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 126 :
                // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.parser.tcs/./generationTemp/generated/TCS.g:1:800: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\22\56\1\144\1\56\1\151\1\153\1\155\1\157\4\uffff\1\161"+
        "\1\163\1\uffff\1\165\11\uffff\1\167\1\173\3\uffff\1\174\1\uffff"+
        "\34\56\1\u00a1\26\56\1\uffff\2\56\27\uffff\1\u00bf\15\56\1\u00cd"+
        "\14\56\1\u00dc\1\u00dd\1\u00de\4\56\1\u00e3\1\uffff\23\56\1\u00f8"+
        "\11\56\1\uffff\15\56\1\uffff\4\56\1\u0113\1\u0114\1\56\1\u0116\1"+
        "\u0117\5\56\3\uffff\2\56\1\u0120\1\56\1\uffff\6\56\1\u012a\4\56"+
        "\1\u012f\2\56\1\u0133\3\56\1\u0137\1\56\1\uffff\5\56\1\u013e\1\u013f"+
        "\3\56\1\u0143\4\56\1\u0149\6\56\1\u0151\3\56\2\uffff\1\u0156\2\uffff"+
        "\1\56\1\u015b\2\56\1\u015e\3\56\1\uffff\11\56\1\uffff\1\u016b\1"+
        "\56\1\u016d\1\56\1\uffff\3\56\1\uffff\2\56\1\u0174\1\uffff\1\u0175"+
        "\2\56\1\u0178\1\u0179\1\56\2\uffff\2\56\1\u017e\1\uffff\5\56\1\uffff"+
        "\3\56\1\u0188\1\u0189\2\56\1\uffff\4\56\1\uffff\4\56\1\uffff\2\56"+
        "\1\uffff\1\u0196\3\56\1\u019a\7\56\1\uffff\1\u01a2\1\uffff\6\56"+
        "\2\uffff\2\56\2\uffff\3\56\1\u01af\1\uffff\4\56\1\u01b4\3\56\1\u01b8"+
        "\2\uffff\2\56\1\u01bb\1\56\1\u01bd\7\56\1\uffff\3\56\1\uffff\7\56"+
        "\1\uffff\3\56\1\u01d2\1\u01d3\3\56\1\u01d7\3\56\1\uffff\1\u01db"+
        "\3\56\1\uffff\3\56\1\uffff\2\56\1\uffff\1\56\1\uffff\1\56\1\u01e8"+
        "\7\56\1\u01f0\5\56\1\u01f6\3\56\1\u01fa\2\uffff\1\u01fb\1\u01fc"+
        "\1\u01fd\1\uffff\1\u01fe\2\56\1\uffff\1\56\1\u0202\1\56\1\u0204"+
        "\1\u0205\3\56\1\u0209\1\u020a\1\56\1\u020c\1\uffff\1\56\1\u020e"+
        "\2\56\1\u0211\2\56\1\uffff\2\56\1\u0216\1\u0217\1\56\1\uffff\1\u0219"+
        "\2\56\5\uffff\2\56\1\u021e\1\uffff\1\56\2\uffff\1\56\1\u0221\1\56"+
        "\2\uffff\1\56\1\uffff\1\56\1\uffff\1\u0225\1\56\1\uffff\1\56\1\u0228"+
        "\1\u0229\1\u022a\2\uffff\1\56\1\uffff\1\u022c\1\56\1\u022e\1\u022f"+
        "\1\uffff\2\56\1\uffff\3\56\1\uffff\2\56\3\uffff\1\56\1\uffff\1\56"+
        "\2\uffff\1\56\1\u023a\1\56\1\u023d\2\56\1\u0240\3\56\1\uffff\2\56"+
        "\1\uffff\1\u0246\1\56\1\uffff\1\u0248\3\56\1\u024c\1\uffff\1\56"+
        "\1\uffff\1\56\1\u024f\1\56\1\uffff\2\56\1\uffff\1\u0253\2\56\1\uffff"+
        "\1\56\1\u0257\1\56\1\uffff\1\u0259\1\uffff";
    static final String DFA16_eofS =
        "\u025a\uffff";
    static final String DFA16_minS =
        "\1\11\1\141\1\145\1\143\1\145\1\141\1\145\1\156\1\142\1\146\1\145"+
        "\1\142\1\141\1\145\1\163\1\145\1\157\1\165\1\141\1\60\1\150\1\55"+
        "\1\52\1\133\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75"+
        "\1\55\3\uffff\1\56\1\uffff\1\162\2\154\1\156\1\155\1\141\1\155\1"+
        "\165\1\145\1\113\1\145\1\164\1\151\1\163\1\145\1\157\1\154\1\144"+
        "\1\151\1\146\1\147\1\144\1\143\1\154\1\144\1\164\1\163\1\144\1\60"+
        "\1\144\1\155\1\104\1\160\1\146\1\157\1\166\1\156\1\116\1\151\1\162"+
        "\1\163\1\155\1\153\1\165\1\151\1\170\1\145\1\156\1\145\1\154\1\171"+
        "\1\uffff\1\145\1\162\27\uffff\1\60\1\164\1\163\1\143\1\151\1\141"+
        "\1\104\2\162\1\142\1\164\2\162\1\145\1\60\1\141\1\164\2\141\2\160"+
        "\1\164\1\145\1\156\1\145\1\150\1\155\3\60\1\141\1\124\1\157\1\164"+
        "\1\60\1\uffff\2\145\1\164\1\151\1\145\1\157\1\164\1\145\1\153\1"+
        "\145\1\120\1\114\1\155\2\164\1\160\2\145\1\156\1\60\1\141\1\164"+
        "\1\162\1\165\1\167\1\156\1\144\1\145\1\141\1\uffff\2\145\1\164\1"+
        "\141\1\162\1\151\1\164\1\145\1\157\1\141\1\143\1\141\1\171\1\uffff"+
        "\1\154\1\164\1\155\1\165\2\60\1\151\2\60\1\162\1\164\1\145\1\146"+
        "\1\114\3\uffff\1\171\1\157\1\60\1\162\1\uffff\1\162\1\156\1\141"+
        "\1\163\1\146\1\162\1\60\1\162\1\111\2\162\1\60\1\151\1\162\1\60"+
        "\1\146\1\154\1\156\1\60\1\147\1\uffff\1\164\1\145\1\171\1\145\1"+
        "\157\2\60\1\144\1\143\1\162\1\60\1\151\1\154\1\141\1\163\1\60\1"+
        "\117\1\154\1\170\1\145\1\164\1\167\1\60\1\145\1\142\1\154\2\uffff"+
        "\1\60\2\uffff\1\145\1\60\1\162\1\114\1\60\1\163\1\103\1\162\1\uffff"+
        "\1\141\2\164\1\156\1\163\1\151\1\164\1\157\1\160\1\uffff\1\60\1"+
        "\156\1\60\1\151\1\uffff\1\164\1\151\1\141\1\uffff\1\151\1\141\1"+
        "\60\1\uffff\1\60\1\145\1\170\2\60\1\162\2\uffff\1\114\1\150\1\60"+
        "\1\uffff\1\157\1\151\1\164\1\141\1\114\1\uffff\1\160\1\151\1\163"+
        "\2\60\2\157\1\uffff\1\144\1\151\1\164\1\151\1\uffff\1\124\1\156"+
        "\1\157\1\160\1\uffff\1\141\1\151\1\uffff\1\60\1\157\1\145\1\143"+
        "\1\60\1\111\1\143\1\151\1\156\1\103\1\156\1\141\1\uffff\1\60\1\uffff"+
        "\1\155\1\151\1\164\1\154\1\170\1\164\2\uffff\1\101\1\164\2\uffff"+
        "\1\144\1\160\1\157\1\60\1\uffff\1\156\1\172\1\157\1\155\1\60\1\116"+
        "\1\124\1\147\1\60\2\uffff\2\162\1\60\1\147\1\60\1\156\1\157\1\143"+
        "\1\156\1\141\1\164\1\156\1\uffff\1\156\1\141\1\164\1\uffff\1\156"+
        "\1\145\1\156\1\145\1\157\1\145\1\143\1\uffff\1\141\1\166\1\171\2"+
        "\60\1\145\1\163\1\156\1\60\1\163\1\160\1\167\1\uffff\1\60\1\145"+
        "\1\162\1\142\1\uffff\1\114\1\157\1\150\1\uffff\1\124\1\144\1\uffff"+
        "\1\165\1\uffff\1\145\1\60\2\145\1\143\1\151\1\145\2\164\1\60\1\143"+
        "\1\117\1\147\1\144\1\156\1\60\1\145\1\162\1\145\1\60\2\uffff\3\60"+
        "\1\uffff\1\60\2\145\1\uffff\1\162\1\60\1\151\2\60\1\164\1\144\1"+
        "\145\2\60\1\141\1\60\1\uffff\1\117\1\60\1\145\1\157\1\60\2\145\1"+
        "\uffff\1\162\1\146\2\60\1\164\1\uffff\1\60\1\171\1\124\5\uffff\2"+
        "\162\1\60\1\uffff\1\147\2\uffff\1\124\1\60\1\155\2\uffff\1\164\1"+
        "\uffff\1\156\1\uffff\1\60\1\156\1\uffff\1\170\3\60\2\uffff\1\145"+
        "\1\uffff\1\60\1\145\2\60\1\uffff\1\165\1\157\1\uffff\1\160\1\145"+
        "\1\154\1\uffff\1\124\1\164\3\uffff\1\170\1\uffff\1\155\2\uffff\1"+
        "\141\1\60\1\154\1\60\1\171\1\145\1\60\1\164\1\160\1\164\1\uffff"+
        "\1\141\1\63\1\uffff\1\60\1\155\1\uffff\1\60\1\154\1\145\1\164\1"+
        "\60\1\uffff\1\160\1\uffff\1\141\1\60\1\145\1\uffff\1\154\1\164\1"+
        "\uffff\1\60\1\141\1\145\1\uffff\1\164\1\60\1\145\1\uffff\1\60\1"+
        "\uffff";
    static final String DFA16_maxS =
        "\1\u00ff\1\165\1\171\2\162\1\165\1\151\1\163\1\165\1\163\2\157\2"+
        "\162\1\163\1\145\1\162\1\165\1\141\1\u00ff\1\157\1\76\1\52\1\133"+
        "\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\76\3\uffff"+
        "\1\71\1\uffff\1\162\2\154\1\156\1\162\1\157\1\156\1\165\1\145\1"+
        "\113\1\145\1\164\1\151\1\163\1\146\1\157\1\154\1\144\1\151\1\146"+
        "\1\147\1\165\1\143\1\167\1\144\1\164\1\163\1\144\1\u00ff\1\166\1"+
        "\155\1\104\1\160\1\170\1\157\1\166\1\156\1\116\1\151\1\162\1\163"+
        "\1\155\1\153\1\165\1\151\1\170\1\145\1\156\1\145\1\154\1\171\1\uffff"+
        "\1\145\1\162\27\uffff\1\u00ff\1\164\1\163\1\143\1\151\1\141\1\104"+
        "\2\162\1\142\1\164\2\162\1\145\1\u00ff\1\141\1\164\2\141\2\160\1"+
        "\164\1\145\1\156\1\145\1\150\1\155\3\u00ff\1\141\1\124\1\157\1\164"+
        "\1\u00ff\1\uffff\2\145\1\164\1\151\1\145\1\157\1\164\1\145\1\153"+
        "\1\145\1\120\1\114\1\157\2\164\1\160\2\145\1\156\1\u00ff\1\141\1"+
        "\164\1\162\1\165\1\167\1\156\1\144\1\145\1\141\1\uffff\2\145\1\164"+
        "\1\141\1\162\1\151\1\164\1\145\1\157\1\141\1\143\1\141\1\171\1\uffff"+
        "\1\154\1\164\1\155\1\165\2\u00ff\1\151\2\u00ff\1\162\1\164\1\145"+
        "\1\146\1\114\3\uffff\1\171\1\157\1\u00ff\1\162\1\uffff\1\162\1\156"+
        "\1\141\1\163\1\146\1\162\1\u00ff\1\162\1\111\2\162\1\u00ff\1\151"+
        "\1\162\1\u00ff\1\146\1\154\1\156\1\u00ff\1\147\1\uffff\1\164\1\145"+
        "\1\171\1\145\1\157\2\u00ff\1\144\1\143\1\162\1\u00ff\1\151\1\154"+
        "\1\141\1\163\1\u00ff\1\122\1\154\1\170\1\145\1\164\1\167\1\u00ff"+
        "\1\145\1\142\1\154\2\uffff\1\u00ff\2\uffff\1\163\1\u00ff\1\162\1"+
        "\114\1\u00ff\1\163\1\103\1\162\1\uffff\1\141\2\164\1\156\1\163\1"+
        "\151\1\164\1\157\1\160\1\uffff\1\u00ff\1\156\1\u00ff\1\151\1\uffff"+
        "\1\164\1\151\1\141\1\uffff\1\151\1\141\1\u00ff\1\uffff\1\u00ff\1"+
        "\145\1\170\2\u00ff\1\162\2\uffff\1\125\1\150\1\u00ff\1\uffff\1\157"+
        "\1\151\1\164\1\141\1\142\1\uffff\1\160\1\151\1\163\2\u00ff\2\157"+
        "\1\uffff\1\144\1\151\1\164\1\151\1\uffff\1\124\1\156\1\157\1\160"+
        "\1\uffff\1\141\1\151\1\uffff\1\u00ff\1\157\1\145\1\143\1\u00ff\1"+
        "\111\1\143\1\151\1\156\1\103\1\156\1\141\1\uffff\1\u00ff\1\uffff"+
        "\1\155\1\151\1\164\1\154\1\170\1\164\2\uffff\1\111\1\164\2\uffff"+
        "\1\144\1\160\1\157\1\u00ff\1\uffff\1\156\1\172\1\157\1\155\1\u00ff"+
        "\1\116\1\124\1\147\1\u00ff\2\uffff\2\162\1\u00ff\1\147\1\u00ff\1"+
        "\156\1\157\1\143\1\156\1\141\1\164\1\156\1\uffff\1\156\1\141\1\164"+
        "\1\uffff\1\156\1\145\1\156\1\145\1\157\1\145\1\143\1\uffff\1\141"+
        "\1\166\1\171\2\u00ff\1\145\1\163\1\156\1\u00ff\1\163\1\160\1\167"+
        "\1\uffff\1\u00ff\1\145\1\162\1\142\1\uffff\1\114\1\157\1\150\1\uffff"+
        "\1\163\1\144\1\uffff\1\165\1\uffff\1\145\1\u00ff\2\145\1\143\1\151"+
        "\1\145\2\164\1\u00ff\1\143\1\117\1\147\1\144\1\156\1\u00ff\1\145"+
        "\1\162\1\145\1\u00ff\2\uffff\3\u00ff\1\uffff\1\u00ff\2\145\1\uffff"+
        "\1\162\1\u00ff\1\151\2\u00ff\1\164\1\144\1\145\2\u00ff\1\141\1\u00ff"+
        "\1\uffff\1\117\1\u00ff\1\145\1\157\1\u00ff\2\145\1\uffff\1\162\1"+
        "\146\2\u00ff\1\164\1\uffff\1\u00ff\1\171\1\124\5\uffff\2\162\1\u00ff"+
        "\1\uffff\1\147\2\uffff\1\124\1\u00ff\1\155\2\uffff\1\164\1\uffff"+
        "\1\156\1\uffff\1\u00ff\1\156\1\uffff\1\170\3\u00ff\2\uffff\1\145"+
        "\1\uffff\1\u00ff\1\145\2\u00ff\1\uffff\1\165\1\157\1\uffff\1\160"+
        "\1\145\1\154\1\uffff\1\124\1\164\3\uffff\1\170\1\uffff\1\155\2\uffff"+
        "\1\141\1\u00ff\1\154\1\u00ff\1\171\1\145\1\u00ff\1\164\1\160\1\164"+
        "\1\uffff\1\141\1\63\1\uffff\1\u00ff\1\155\1\uffff\1\u00ff\1\154"+
        "\1\145\1\164\1\u00ff\1\uffff\1\160\1\uffff\1\141\1\u00ff\1\145\1"+
        "\uffff\1\154\1\164\1\uffff\1\u00ff\1\141\1\145\1\uffff\1\164\1\u00ff"+
        "\1\145\1\uffff\1\u00ff\1\uffff";
    static final String DFA16_acceptS =
        "\31\uffff\1\134\1\135\1\136\1\137\2\uffff\1\144\1\uffff\1\147\1"+
        "\150\1\151\1\152\1\153\1\154\1\157\1\161\1\162\2\uffff\1\171\1\172"+
        "\1\173\1\uffff\1\176\63\uffff\1\105\2\uffff\1\126\1\155\1\156\1"+
        "\127\1\160\1\132\1\130\1\133\1\131\1\142\1\140\1\143\1\141\1\146"+
        "\1\145\1\165\1\163\1\166\1\167\1\170\1\164\1\174\1\175\43\uffff"+
        "\1\110\35\uffff\1\51\15\uffff\1\31\16\uffff\1\14\1\101\1\12\4\uffff"+
        "\1\70\24\uffff\1\37\32\uffff\1\62\1\72\1\uffff\1\7\1\41\10\uffff"+
        "\1\64\11\uffff\1\65\4\uffff\1\104\3\uffff\1\63\3\uffff\1\121\6\uffff"+
        "\1\113\1\120\3\uffff\1\22\5\uffff\1\106\7\uffff\1\32\4\uffff\1\30"+
        "\4\uffff\1\42\2\uffff\1\112\14\uffff\1\33\1\uffff\1\21\6\uffff\1"+
        "\116\1\27\2\uffff\1\54\1\55\4\uffff\1\2\11\uffff\1\76\1\103\14\uffff"+
        "\1\124\3\uffff\1\13\7\uffff\1\107\14\uffff\1\15\4\uffff\1\34\3\uffff"+
        "\1\40\2\uffff\1\115\1\uffff\1\46\24\uffff\1\53\1\61\3\uffff\1\111"+
        "\3\uffff\1\100\14\uffff\1\10\7\uffff\1\50\5\uffff\1\20\3\uffff\1"+
        "\36\1\24\1\45\1\123\1\122\3\uffff\1\74\1\uffff\1\43\1\66\3\uffff"+
        "\1\71\1\17\1\uffff\1\6\1\uffff\1\25\2\uffff\1\67\4\uffff\1\52\1"+
        "\56\1\uffff\1\117\4\uffff\1\3\2\uffff\1\4\3\uffff\1\35\2\uffff\1"+
        "\47\1\16\1\125\1\uffff\1\44\1\uffff\1\1\1\114\12\uffff\1\75\2\uffff"+
        "\1\5\2\uffff\1\26\5\uffff\1\57\1\uffff\1\102\3\uffff\1\73\2\uffff"+
        "\1\77\3\uffff\1\60\3\uffff\1\23\1\uffff\1\11";
    static final String DFA16_specialS =
        "\u025a\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\31\1\60\1\42\1\44\2"+
            "\uffff\1\56\1\33\1\34\1\47\1\50\1\32\1\25\1\46\1\26\12\57\1"+
            "\40\1\37\1\53\1\51\1\52\1\43\1\45\32\56\1\27\1\uffff\1\30\1"+
            "\uffff\1\56\1\uffff\1\10\1\56\1\20\1\4\1\7\1\1\1\56\1\17\1\11"+
            "\1\56\1\23\1\12\1\5\1\13\1\3\1\14\1\21\1\6\1\2\1\15\1\16\1\22"+
            "\1\24\3\56\1\35\1\41\1\36\102\uffff\27\56\1\uffff\37\56\1\uffff"+
            "\10\56",
            "\1\63\7\uffff\1\62\5\uffff\1\61\5\uffff\1\64",
            "\1\65\11\uffff\1\70\4\uffff\1\66\4\uffff\1\67",
            "\1\74\11\uffff\1\75\1\73\1\uffff\1\71\1\uffff\1\72",
            "\1\77\3\uffff\1\76\10\uffff\1\100",
            "\1\103\15\uffff\1\102\5\uffff\1\101",
            "\1\104\3\uffff\1\105",
            "\1\106\4\uffff\1\107",
            "\1\113\1\uffff\1\111\7\uffff\1\110\1\uffff\1\114\4\uffff\1"+
            "\115\1\uffff\1\112",
            "\1\117\6\uffff\1\121\1\116\4\uffff\1\120",
            "\1\122\11\uffff\1\123",
            "\1\126\2\uffff\1\124\11\uffff\1\125",
            "\1\130\15\uffff\1\131\2\uffff\1\127",
            "\1\132\11\uffff\1\133\2\uffff\1\134",
            "\1\135",
            "\1\136",
            "\1\140\2\uffff\1\137",
            "\1\141",
            "\1\142",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\143\25\56"+
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\145\6\uffff\1\146",
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
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0084\2\uffff\1\u0083\1\uffff\1\u0082",
            "\1\u0085\15\uffff\1\u0086",
            "\1\u0087\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0091\1\u0090",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0099\20\uffff\1\u0098",
            "\1\u009a",
            "\1\u009b\12\uffff\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a3\16\uffff\1\u00a4\2\uffff\1\u00a2",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8\21\uffff\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
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
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "",
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
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\2\56\1\u00bd\1\56"+
            "\1\u00be\25\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
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
            "\12\56\7\uffff\15\56\1\u00db\1\u00da\13\56\4\uffff\1\56\1\uffff"+
            "\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0\1\uffff\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0115",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "",
            "",
            "",
            "\1\u011d",
            "\1\u011e",
            "\12\56\7\uffff\2\56\1\u011f\27\56\4\uffff\1\56\1\uffff\32\56"+
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0121",
            "",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\12\56\7\uffff\15\56\1\u0128\4\56\1\u0129\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0130",
            "\1\u0131",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56\1\u0132\21"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0138",
            "",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\12\56\7\uffff\15\56\1\u0148\14\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u014a\2\uffff\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "",
            "",
            "\12\56\7\uffff\13\56\1\u0155\16\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u0158\15\uffff\1\u0157",
            "\12\56\7\uffff\15\56\1\u0159\4\56\1\u015a\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u015c",
            "\1\u015d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u016c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u016e",
            "",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "",
            "\1\u0172",
            "\1\u0173",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0176",
            "\1\u0177",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u017a",
            "",
            "",
            "\1\u017c\10\uffff\1\u017b",
            "\1\u017d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183\25\uffff\1\u0184",
            "",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u018a",
            "\1\u018b",
            "",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "",
            "\1\u0194",
            "\1\u0195",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "",
            "",
            "\1\u01a9\7\uffff\1\u01aa",
            "\1\u01ab",
            "",
            "",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b5",
            "\1\u01b6",
            "\1\u01b7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u01b9",
            "\1\u01ba",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01bc",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "",
            "\1\u01cf",
            "\1\u01d0",
            "\1\u01d1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "",
            "\1\u01e3\20\uffff\1\u01e2\15\uffff\1\u01e4",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "",
            "\1\u01e7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01e9",
            "\1\u01ea",
            "\1\u01eb",
            "\1\u01ec",
            "\1\u01ed",
            "\1\u01ee",
            "\1\u01ef",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u01f3",
            "\1\u01f4",
            "\1\u01f5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f7",
            "\1\u01f8",
            "\1\u01f9",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01ff",
            "\1\u0200",
            "",
            "\1\u0201",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0203",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0206",
            "\1\u0207",
            "\1\u0208",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u020b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u020d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u020f",
            "\1\u0210",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0212",
            "\1\u0213",
            "",
            "\1\u0214",
            "\1\u0215",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0218",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u021a",
            "\1\u021b",
            "",
            "",
            "",
            "",
            "",
            "\1\u021c",
            "\1\u021d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u021f",
            "",
            "",
            "\1\u0220",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0222",
            "",
            "",
            "\1\u0223",
            "",
            "\1\u0224",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0226",
            "",
            "\1\u0227",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u022b",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u022d",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0230",
            "\1\u0231",
            "",
            "\1\u0232",
            "\1\u0233",
            "\1\u0234",
            "",
            "\1\u0235",
            "\1\u0236",
            "",
            "",
            "",
            "\1\u0237",
            "",
            "\1\u0238",
            "",
            "",
            "\1\u0239",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u023b",
            "\12\56\7\uffff\25\56\1\u023c\4\56\4\uffff\1\56\1\uffff\32\56"+
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u023e",
            "\1\u023f",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0241",
            "\1\u0242",
            "\1\u0243",
            "",
            "\1\u0244",
            "\1\u0245",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0247",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0249",
            "\1\u024a",
            "\1\u024b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u024d",
            "",
            "\1\u024e",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0250",
            "",
            "\1\u0251",
            "\1\u0252",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0254",
            "\1\u0255",
            "",
            "\1\u0256",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0258",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
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