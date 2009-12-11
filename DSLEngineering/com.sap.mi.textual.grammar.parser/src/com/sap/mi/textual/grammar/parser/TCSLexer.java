// $ANTLR 3.1.1 parser/TCS.g 2009-12-11 15:51:45

package com.sap.mi.textual.grammar.parser;
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
public class TCSLexer extends Lexer {
    public static final int LT=19;
    public static final int DLCURLY=29;
    public static final int STAR=27;
    public static final int LSQUARE=21;
    public static final int ORKEYWORD=48;
    public static final int DRCURLY=30;
    public static final int EXCL=37;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=11;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=44;
    public static final int EQ=10;
    public static final int COMMENT=35;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int NE=43;
    public static final int GE=41;
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
    public static final int ALPHA=47;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=45;
    public static final int QNAME=8;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=49;
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
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
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
    public static final int AROBAS=38;
    public static final int T__118=118;
    public static final int ESC=51;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int DLCOLON=33;
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
    public static final int SLASH=39;
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
    public static final int PLUS=40;
    public static final int DIGIT=46;
    public static final int QNAME_OR_NAME=50;
    public static final int DLSQUARE=24;
    public static final int RARROW=15;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RSQUARE=22;
    public static final int MINUS=34;
    public static final int COMA=17;
    public static final int SEMI=14;
    public static final int MULTI_LINE_COMMENT=36;
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=42;
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
    public String getGrammarFileName() { return "parser/TCS.g"; }

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:117:7: ( 'instanceOf' )
            // parser/TCS.g:117:9: 'instanceOf'
            {
            match("instanceOf"); if (state.failed) return ;


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
            // parser/TCS.g:118:7: ( 'k' )
            // parser/TCS.g:118:9: 'k'
            {
            match('k'); if (state.failed) return ;

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
            // parser/TCS.g:119:7: ( 'template' )
            // parser/TCS.g:119:9: 'template'
            {
            match("template"); if (state.failed) return ;


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
            // parser/TCS.g:120:7: ( 'isDefined' )
            // parser/TCS.g:120:9: 'isDefined'
            {
            match("isDefined"); if (state.failed) return ;


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
            // parser/TCS.g:121:7: ( 'one' )
            // parser/TCS.g:121:9: 'one'
            {
            match("one"); if (state.failed) return ;


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
            // parser/TCS.g:122:7: ( 'endNL' )
            // parser/TCS.g:122:9: 'endNL'
            {
            match("endNL"); if (state.failed) return ;


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
            // parser/TCS.g:123:7: ( 'disambiguate' )
            // parser/TCS.g:123:9: 'disambiguate'
            {
            match("disambiguate"); if (state.failed) return ;


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
            // parser/TCS.g:124:7: ( 'createIn' )
            // parser/TCS.g:124:9: 'createIn'
            {
            match("createIn"); if (state.failed) return ;


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
            // parser/TCS.g:125:7: ( 'start' )
            // parser/TCS.g:125:9: 'start'
            {
            match("start"); if (state.failed) return ;


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
            // parser/TCS.g:126:7: ( 'syntax' )
            // parser/TCS.g:126:9: 'syntax'
            {
            match("syntax"); if (state.failed) return ;


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
            // parser/TCS.g:127:7: ( 'storeOpTo' )
            // parser/TCS.g:127:9: 'storeOpTo'
            {
            match("storeOpTo"); if (state.failed) return ;


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
            // parser/TCS.g:128:7: ( 'nonPrimary' )
            // parser/TCS.g:128:9: 'nonPrimary'
            {
            match("nonPrimary"); if (state.failed) return ;


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
            // parser/TCS.g:129:7: ( 'omitted' )
            // parser/TCS.g:129:9: 'omitted'
            {
            match("omitted"); if (state.failed) return ;


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
            // parser/TCS.g:130:7: ( 'main' )
            // parser/TCS.g:130:9: 'main'
            {
            match("main"); if (state.failed) return ;


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
            // parser/TCS.g:131:7: ( 'esc' )
            // parser/TCS.g:131:9: 'esc'
            {
            match("esc"); if (state.failed) return ;


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
            // parser/TCS.g:132:7: ( 'auto' )
            // parser/TCS.g:132:9: 'auto'
            {
            match("auto"); if (state.failed) return ;


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
            // parser/TCS.g:133:7: ( 'enumerationTemplate' )
            // parser/TCS.g:133:9: 'enumerationTemplate'
            {
            match("enumerationTemplate"); if (state.failed) return ;


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
            // parser/TCS.g:134:7: ( 'indentIncr' )
            // parser/TCS.g:134:9: 'indentIncr'
            {
            match("indentIncr"); if (state.failed) return ;


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
            // parser/TCS.g:135:7: ( 'storeRightTo' )
            // parser/TCS.g:135:9: 'storeRightTo'
            {
            match("storeRightTo"); if (state.failed) return ;


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
            // parser/TCS.g:136:7: ( 'source' )
            // parser/TCS.g:136:9: 'source'
            {
            match("source"); if (state.failed) return ;


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
            // parser/TCS.g:137:7: ( 'foreach' )
            // parser/TCS.g:137:9: 'foreach'
            {
            match("foreach"); if (state.failed) return ;


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
            // parser/TCS.g:138:7: ( 'rightSpace' )
            // parser/TCS.g:138:9: 'rightSpace'
            {
            match("rightSpace"); if (state.failed) return ;


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
            // parser/TCS.g:139:7: ( 'keywords' )
            // parser/TCS.g:139:9: 'keywords'
            {
            match("keywords"); if (state.failed) return ;


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
            // parser/TCS.g:140:7: ( 'priority' )
            // parser/TCS.g:140:9: 'priority'
            {
            match("priority"); if (state.failed) return ;


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
            // parser/TCS.g:141:7: ( 'drop' )
            // parser/TCS.g:141:9: 'drop'
            {
            match("drop"); if (state.failed) return ;


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
            // parser/TCS.g:142:7: ( 'addToContext' )
            // parser/TCS.g:142:9: 'addToContext'
            {
            match("addToContext"); if (state.failed) return ;


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
            // parser/TCS.g:143:7: ( 'context' )
            // parser/TCS.g:143:9: 'context'
            {
            match("context"); if (state.failed) return ;


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
            // parser/TCS.g:144:7: ( 'disambiguateV3' )
            // parser/TCS.g:144:9: 'disambiguateV3'
            {
            match("disambiguateV3"); if (state.failed) return ;


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
            // parser/TCS.g:145:7: ( 'and' )
            // parser/TCS.g:145:9: 'and'
            {
            match("and"); if (state.failed) return ;


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
            // parser/TCS.g:146:7: ( 'rightNone' )
            // parser/TCS.g:146:9: 'rightNone'
            {
            match("rightNone"); if (state.failed) return ;


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
            // parser/TCS.g:147:7: ( 'token' )
            // parser/TCS.g:147:9: 'token'
            {
            match("token"); if (state.failed) return ;


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
            // parser/TCS.g:148:7: ( 'prefix' )
            // parser/TCS.g:148:9: 'prefix'
            {
            match("prefix"); if (state.failed) return ;


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
            // parser/TCS.g:149:7: ( 'word' )
            // parser/TCS.g:149:9: 'word'
            {
            match("word"); if (state.failed) return ;


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
            // parser/TCS.g:150:7: ( 'as' )
            // parser/TCS.g:150:9: 'as'
            {
            match("as"); if (state.failed) return ;


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
            // parser/TCS.g:151:7: ( 'endOfLine' )
            // parser/TCS.g:151:9: 'endOfLine'
            {
            match("endOfLine"); if (state.failed) return ;


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
            // parser/TCS.g:152:7: ( 'right' )
            // parser/TCS.g:152:9: 'right'
            {
            match("right"); if (state.failed) return ;


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
            // parser/TCS.g:153:7: ( 'nbNL' )
            // parser/TCS.g:153:9: 'nbNL'
            {
            match("nbNL"); if (state.failed) return ;


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
            // parser/TCS.g:154:7: ( 'postfix' )
            // parser/TCS.g:154:9: 'postfix'
            {
            match("postfix"); if (state.failed) return ;


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
            // parser/TCS.g:155:7: ( 'query' )
            // parser/TCS.g:155:9: 'query'
            {
            match("query"); if (state.failed) return ;


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
            // parser/TCS.g:156:7: ( 'value' )
            // parser/TCS.g:156:9: 'value'
            {
            match("value"); if (state.failed) return ;


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
            // parser/TCS.g:157:7: ( 'createAs' )
            // parser/TCS.g:157:9: 'createAs'
            {
            match("createAs"); if (state.failed) return ;


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
            // parser/TCS.g:158:7: ( 'importContext' )
            // parser/TCS.g:158:9: 'importContext'
            {
            match("importContext"); if (state.failed) return ;


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
            // parser/TCS.g:159:7: ( 'operators' )
            // parser/TCS.g:159:9: 'operators'
            {
            match("operators"); if (state.failed) return ;


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
            // parser/TCS.g:160:7: ( 'multi' )
            // parser/TCS.g:160:9: 'multi'
            {
            match("multi"); if (state.failed) return ;


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
            // parser/TCS.g:161:7: ( 'always' )
            // parser/TCS.g:161:9: 'always'
            {
            match("always"); if (state.failed) return ;


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
            // parser/TCS.g:162:7: ( 'referenceOnly' )
            // parser/TCS.g:162:9: 'referenceOnly'
            {
            match("referenceOnly"); if (state.failed) return ;


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
            // parser/TCS.g:163:7: ( 'false' )
            // parser/TCS.g:163:9: 'false'
            {
            match("false"); if (state.failed) return ;


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
            // parser/TCS.g:164:7: ( 'serializer' )
            // parser/TCS.g:164:9: 'serializer'
            {
            match("serializer"); if (state.failed) return ;


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
            // parser/TCS.g:165:8: ( 'separator' )
            // parser/TCS.g:165:10: 'separator'
            {
            match("separator"); if (state.failed) return ;


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
            // parser/TCS.g:166:8: ( 'for' )
            // parser/TCS.g:166:10: 'for'
            {
            match("for"); if (state.failed) return ;


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
            // parser/TCS.g:167:8: ( 'end' )
            // parser/TCS.g:167:10: 'end'
            {
            match("end"); if (state.failed) return ;


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
            // parser/TCS.g:168:8: ( 'lookIn' )
            // parser/TCS.g:168:10: 'lookIn'
            {
            match("lookIn"); if (state.failed) return ;


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
            // parser/TCS.g:169:8: ( 'leftNone' )
            // parser/TCS.g:169:10: 'leftNone'
            {
            match("leftNone"); if (state.failed) return ;


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
            // parser/TCS.g:170:8: ( 'all' )
            // parser/TCS.g:170:10: 'all'
            {
            match("all"); if (state.failed) return ;


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
            // parser/TCS.g:171:8: ( 'filter' )
            // parser/TCS.g:171:10: 'filter'
            {
            match("filter"); if (state.failed) return ;


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
            // parser/TCS.g:172:8: ( 'function' )
            // parser/TCS.g:172:10: 'function'
            {
            match("function"); if (state.failed) return ;


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
            // parser/TCS.g:173:8: ( 'forcedUpper' )
            // parser/TCS.g:173:10: 'forcedUpper'
            {
            match("forcedUpper"); if (state.failed) return ;


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
            // parser/TCS.g:174:8: ( 'default' )
            // parser/TCS.g:174:10: 'default'
            {
            match("default"); if (state.failed) return ;


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
            // parser/TCS.g:175:8: ( 'multiLine' )
            // parser/TCS.g:175:10: 'multiLine'
            {
            match("multiLine"); if (state.failed) return ;


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
            // parser/TCS.g:176:8: ( 'when' )
            // parser/TCS.g:176:10: 'when'
            {
            match("when"); if (state.failed) return ;


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
            // parser/TCS.g:177:8: ( 'startNbNL' )
            // parser/TCS.g:177:10: 'startNbNL'
            {
            match("startNbNL"); if (state.failed) return ;


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
            // parser/TCS.g:178:8: ( 'invert' )
            // parser/TCS.g:178:10: 'invert'
            {
            match("invert"); if (state.failed) return ;


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
            // parser/TCS.g:179:8: ( 'ifmissing' )
            // parser/TCS.g:179:10: 'ifmissing'
            {
            match("ifmissing"); if (state.failed) return ;


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
            // parser/TCS.g:180:8: ( 'mode' )
            // parser/TCS.g:180:10: 'mode'
            {
            match("mode"); if (state.failed) return ;


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
            // parser/TCS.g:181:8: ( 'deep' )
            // parser/TCS.g:181:10: 'deep'
            {
            match("deep"); if (state.failed) return ;


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
            // parser/TCS.g:182:8: ( 'octal' )
            // parser/TCS.g:182:10: 'octal'
            {
            match("octal"); if (state.failed) return ;


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
            // parser/TCS.g:183:8: ( 'hex' )
            // parser/TCS.g:183:10: 'hex'
            {
            match("hex"); if (state.failed) return ;


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
            // parser/TCS.g:184:8: ( 'operatorTemplate' )
            // parser/TCS.g:184:10: 'operatorTemplate'
            {
            match("operatorTemplate"); if (state.failed) return ;


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
            // parser/TCS.g:185:8: ( 'symbols' )
            // parser/TCS.g:185:10: 'symbols'
            {
            match("symbols"); if (state.failed) return ;


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
            // parser/TCS.g:186:8: ( 'abstract' )
            // parser/TCS.g:186:10: 'abstract'
            {
            match("abstract"); if (state.failed) return ;


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
            // parser/TCS.g:187:8: ( 'part' )
            // parser/TCS.g:187:10: 'part'
            {
            match("part"); if (state.failed) return ;


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
            // parser/TCS.g:188:8: ( 'partial' )
            // parser/TCS.g:188:10: 'partial'
            {
            match("partial"); if (state.failed) return ;


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
            // parser/TCS.g:189:8: ( 'refersTo' )
            // parser/TCS.g:189:10: 'refersTo'
            {
            match("refersTo"); if (state.failed) return ;


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
            // parser/TCS.g:190:8: ( 'using' )
            // parser/TCS.g:190:10: 'using'
            {
            match("using"); if (state.failed) return ;


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
            // parser/TCS.g:191:8: ( 'left' )
            // parser/TCS.g:191:10: 'left'
            {
            match("left"); if (state.failed) return ;


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
            // parser/TCS.g:192:8: ( 'operatored' )
            // parser/TCS.g:192:10: 'operatored'
            {
            match("operatored"); if (state.failed) return ;


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
            // parser/TCS.g:193:8: ( 'primitiveTemplate' )
            // parser/TCS.g:193:10: 'primitiveTemplate'
            {
            match("primitiveTemplate"); if (state.failed) return ;


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
            // parser/TCS.g:194:8: ( 'startNL' )
            // parser/TCS.g:194:10: 'startNL'
            {
            match("startNL"); if (state.failed) return ;


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
            // parser/TCS.g:195:8: ( 'autoCreate' )
            // parser/TCS.g:195:10: 'autoCreate'
            {
            match("autoCreate"); if (state.failed) return ;


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
            // parser/TCS.g:196:8: ( 'never' )
            // parser/TCS.g:196:10: 'never'
            {
            match("never"); if (state.failed) return ;


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
            // parser/TCS.g:197:8: ( 'lexer' )
            // parser/TCS.g:197:10: 'lexer'
            {
            match("lexer"); if (state.failed) return ;


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
            // parser/TCS.g:198:8: ( 'true' )
            // parser/TCS.g:198:10: 'true'
            {
            match("true"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__133"

    // $ANTLR start "T__134"
    public final void mT__134() throws RecognitionException {
        try {
            int _type = T__134;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:199:8: ( 'forcedLower' )
            // parser/TCS.g:199:10: 'forcedLower'
            {
            match("forcedLower"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__134"

    // $ANTLR start "T__135"
    public final void mT__135() throws RecognitionException {
        try {
            int _type = T__135;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:200:8: ( 'leftSpace' )
            // parser/TCS.g:200:10: 'leftSpace'
            {
            match("leftSpace"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__135"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1648:3: ( ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // parser/TCS.g:1649:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // parser/TCS.g:1649:6: ( ( ( '--' (~ ( '\\r' | '\\n' ) )* ) ) )
            // parser/TCS.g:1649:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // parser/TCS.g:1649:7: ( ( '--' (~ ( '\\r' | '\\n' ) )* ) )
            // parser/TCS.g:1649:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            {
            // parser/TCS.g:1649:8: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // parser/TCS.g:1649:9: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;

            // parser/TCS.g:1649:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // parser/TCS.g:1649:15: ~ ( '\\r' | '\\n' )
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
            // parser/TCS.g:1654:3: ( ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // parser/TCS.g:1655:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // parser/TCS.g:1655:6: ( ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // parser/TCS.g:1655:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // parser/TCS.g:1655:7: ( ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // parser/TCS.g:1655:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // parser/TCS.g:1655:8: ( '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // parser/TCS.g:1655:9: '/**' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/**"); if (state.failed) return ;

            // parser/TCS.g:1655:15: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // parser/TCS.g:1655:44: ( '\\n' | ~ '\\n' )
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

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1660:3: ( '[' )
            // parser/TCS.g:1661:3: '['
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

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1666:3: ( ']' )
            // parser/TCS.g:1667:3: ']'
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

    // $ANTLR start "DLSQUARE"
    public final void mDLSQUARE() throws RecognitionException {
        try {
            int _type = DLSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1672:3: ( '[[' )
            // parser/TCS.g:1673:3: '[['
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

    // $ANTLR start "DRSQUARE"
    public final void mDRSQUARE() throws RecognitionException {
        try {
            int _type = DRSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1678:3: ( ']]' )
            // parser/TCS.g:1679:3: ']]'
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

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1684:3: ( '!' )
            // parser/TCS.g:1685:3: '!'
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

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1690:3: ( ',' )
            // parser/TCS.g:1691:3: ','
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1696:3: ( '(' )
            // parser/TCS.g:1697:3: '('
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
            // parser/TCS.g:1702:3: ( ')' )
            // parser/TCS.g:1703:3: ')'
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

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1708:3: ( '{' )
            // parser/TCS.g:1709:3: '{'
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

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1714:3: ( '}' )
            // parser/TCS.g:1715:3: '}'
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

    // $ANTLR start "DLCURLY"
    public final void mDLCURLY() throws RecognitionException {
        try {
            int _type = DLCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1720:3: ( '{{' )
            // parser/TCS.g:1721:3: '{{'
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

    // $ANTLR start "DRCURLY"
    public final void mDRCURLY() throws RecognitionException {
        try {
            int _type = DRCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1726:3: ( '}}' )
            // parser/TCS.g:1727:3: '}}'
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

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1732:3: ( ';' )
            // parser/TCS.g:1733:3: ';'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1738:3: ( ':' )
            // parser/TCS.g:1739:3: ':'
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

    // $ANTLR start "DLCOLON"
    public final void mDLCOLON() throws RecognitionException {
        try {
            int _type = DLCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1744:3: ( '::' )
            // parser/TCS.g:1745:3: '::'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1750:3: ( '|' )
            // parser/TCS.g:1751:3: '|'
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

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1756:3: ( '#' )
            // parser/TCS.g:1757:3: '#'
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

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1762:3: ( '?' )
            // parser/TCS.g:1763:3: '?'
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

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1768:3: ( '$' )
            // parser/TCS.g:1769:3: '$'
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

    // $ANTLR start "AROBAS"
    public final void mAROBAS() throws RecognitionException {
        try {
            int _type = AROBAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1774:3: ( '@' )
            // parser/TCS.g:1775:3: '@'
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

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1780:3: ( '.' )
            // parser/TCS.g:1781:3: '.'
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

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1786:3: ( '->' )
            // parser/TCS.g:1787:3: '->'
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

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1792:3: ( '-' )
            // parser/TCS.g:1793:3: '-'
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1798:3: ( '*' )
            // parser/TCS.g:1799:3: '*'
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
            // parser/TCS.g:1804:3: ( '/' )
            // parser/TCS.g:1805:3: '/'
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

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1810:3: ( '+' )
            // parser/TCS.g:1811:3: '+'
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

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1816:3: ( '=' )
            // parser/TCS.g:1817:3: '='
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

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1822:3: ( '>' )
            // parser/TCS.g:1823:3: '>'
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

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1828:3: ( '<' )
            // parser/TCS.g:1829:3: '<'
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

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1834:3: ( '>=' )
            // parser/TCS.g:1835:3: '>='
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

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1840:3: ( '<=' )
            // parser/TCS.g:1841:3: '<='
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

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1846:3: ( '<>' )
            // parser/TCS.g:1847:3: '<>'
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

    // $ANTLR start "LARROW"
    public final void mLARROW() throws RecognitionException {
        try {
            int _type = LARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1852:3: ( '<-' )
            // parser/TCS.g:1853:3: '<-'
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

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1861:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // parser/TCS.g:1861:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // parser/TCS.g:1861:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // parser/TCS.g:1861:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1862:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1863:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1864:5: '\\n'
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
            // parser/TCS.g:1870:2: ( ( ' ' | '\\t' ) )
            // parser/TCS.g:1870:4: ( ' ' | '\\t' )
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
            // parser/TCS.g:1877:2: ( '0' .. '9' )
            // parser/TCS.g:1877:4: '0' .. '9'
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
            // parser/TCS.g:1882:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // parser/TCS.g:
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
            // parser/TCS.g:1896:2: ( (~ ORKEYWORD )=> ( ALPHA ) ( ALPHA | DIGIT )* )
            // parser/TCS.g:1896:4: (~ ORKEYWORD )=> ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // parser/TCS.g:1896:19: ( ALPHA )
            // parser/TCS.g:1896:20: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // parser/TCS.g:1896:27: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // parser/TCS.g:
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

    // $ANTLR start "QNAME_OR_NAME"
    public final void mQNAME_OR_NAME() throws RecognitionException {
        try {
            int _type = QNAME_OR_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1899:15: ( ( ORKEYWORD COLON )=> ORKEYWORD | ( SNAME DLCOLON SNAME )=> QNAME | (~ ORKEYWORD COLON | SNAME COLON ~ ( COLON ) )=> NAME | (~ ORKEYWORD | SNAME ~ COLON )=> NAME | ( '\\'' SNAME )=> NAME )
            int alt5=5;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // parser/TCS.g:1900:5: ( ORKEYWORD COLON )=> ORKEYWORD
                    {
                    mORKEYWORD(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = ORKEYWORD; 
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1901:10: ( SNAME DLCOLON SNAME )=> QNAME
                    {
                    mQNAME(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = QNAME; 
                    }

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1902:8: (~ ORKEYWORD COLON | SNAME COLON ~ ( COLON ) )=> NAME
                    {
                    mNAME(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = NAME; 
                    }

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1903:11: (~ ORKEYWORD | SNAME ~ COLON )=> NAME
                    {
                    mNAME(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = NAME; 
                    }

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1904:11: ( '\\'' SNAME )=> NAME
                    {
                    mNAME(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = NAME; 
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
    // $ANTLR end "QNAME_OR_NAME"

    // $ANTLR start "ORKEYWORD"
    public final void mORKEYWORD() throws RecognitionException {
        try {
            // parser/TCS.g:1908:11: ( 'orKeyword' )
            // parser/TCS.g:1909:2: 'orKeyword'
            {
            match("orKeyword"); if (state.failed) return ;


            }

        }
        finally {
        }
    }
    // $ANTLR end "ORKEYWORD"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            // parser/TCS.g:1914:2: ( ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // parser/TCS.g:1914:4: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // parser/TCS.g:1914:4: ( SNAME | '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // parser/TCS.g:1915:10: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1916:5: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // parser/TCS.g:1917:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                        else if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=3;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // parser/TCS.g:1917:6: ESC
                    	    {
                    	    mESC(); if (state.failed) return ;

                    	    }
                    	    break;
                    	case 2 :
                    	    // parser/TCS.g:1918:6: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // parser/TCS.g:1919:6: ~ ( '\\\\' | '\\'' | '\\n' )
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

        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "QNAME"
    public final void mQNAME() throws RecognitionException {
        try {
            // parser/TCS.g:1927:9: ( SNAME DLCOLON SNAME ( DLCOLON SNAME )* )
            // parser/TCS.g:1927:11: SNAME DLCOLON SNAME ( DLCOLON SNAME )*
            {
            mSNAME(); if (state.failed) return ;
            mDLCOLON(); if (state.failed) return ;
            mSNAME(); if (state.failed) return ;
            // parser/TCS.g:1927:31: ( DLCOLON SNAME )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==':') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // parser/TCS.g:1927:32: DLCOLON SNAME
            	    {
            	    mDLCOLON(); if (state.failed) return ;
            	    mSNAME(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

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
            // parser/TCS.g:1931:2: ( ( DIGIT )+ )
            // parser/TCS.g:1931:4: ( DIGIT )+
            {
            // parser/TCS.g:1931:4: ( DIGIT )+
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
            	    // parser/TCS.g:1931:5: DIGIT
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
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // parser/TCS.g:1934:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // parser/TCS.g:1934:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // parser/TCS.g:1934:9: ( DIGIT )+
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
            	    // parser/TCS.g:1934:9: DIGIT
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
            // parser/TCS.g:1934:20: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // parser/TCS.g:1934:20: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // parser/TCS.g:1938:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // parser/TCS.g:1938:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); if (state.failed) return ;
            // parser/TCS.g:1939:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            int alt16=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt16=1;
                }
                break;
            case 'r':
                {
                alt16=2;
                }
                break;
            case 't':
                {
                alt16=3;
                }
                break;
            case 'b':
                {
                alt16=4;
                }
                break;
            case 'f':
                {
                alt16=5;
                }
                break;
            case '\"':
                {
                alt16=6;
                }
                break;
            case '\'':
                {
                alt16=7;
                }
                break;
            case '\\':
                {
                alt16=8;
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
                alt16=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // parser/TCS.g:1939:5: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1940:5: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1941:5: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1942:5: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1943:5: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:1944:5: '\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:1945:5: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:1946:5: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // parser/TCS.g:1947:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // parser/TCS.g:1947:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( ((LA15_0>='0' && LA15_0<='3')) ) {
                        alt15=1;
                    }
                    else if ( ((LA15_0>='4' && LA15_0<='7')) ) {
                        alt15=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // parser/TCS.g:1948:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // parser/TCS.g:1948:5: ( '0' .. '3' )
                            // parser/TCS.g:1948:6: '0' .. '3'
                            {
                            matchRange('0','3'); if (state.failed) return ;

                            }

                            // parser/TCS.g:1949:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( ((LA13_0>='0' && LA13_0<='7')) ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // parser/TCS.g:1950:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // parser/TCS.g:1950:7: ( '0' .. '7' )
                                    // parser/TCS.g:1950:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); if (state.failed) return ;

                                    }

                                    // parser/TCS.g:1951:6: ( '0' .. '7' )?
                                    int alt12=2;
                                    int LA12_0 = input.LA(1);

                                    if ( ((LA12_0>='0' && LA12_0<='7')) ) {
                                        alt12=1;
                                    }
                                    switch (alt12) {
                                        case 1 :
                                            // parser/TCS.g:1952:8: '0' .. '7'
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
                            // parser/TCS.g:1955:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // parser/TCS.g:1955:6: ( '4' .. '7' )
                            // parser/TCS.g:1955:7: '4' .. '7'
                            {
                            matchRange('4','7'); if (state.failed) return ;

                            }

                            // parser/TCS.g:1956:5: ( ( '0' .. '7' ) )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( ((LA14_0>='0' && LA14_0<='7')) ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // parser/TCS.g:1957:7: ( '0' .. '7' )
                                    {
                                    // parser/TCS.g:1957:7: ( '0' .. '7' )
                                    // parser/TCS.g:1957:8: '0' .. '7'
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
            // parser/TCS.g:1966:2: ( '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            // parser/TCS.g:1966:4: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // parser/TCS.g:1967:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
            loop17:
            do {
                int alt17=4;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\\') ) {
                    alt17=1;
                }
                else if ( (LA17_0=='\n') ) {
                    alt17=2;
                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                    alt17=3;
                }


                switch (alt17) {
            	case 1 :
            	    // parser/TCS.g:1967:5: ESC
            	    {
            	    mESC(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // parser/TCS.g:1968:5: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 3 :
            	    // parser/TCS.g:1969:5: ~ ( '\\\\' | '\\\"' | '\\n' )
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
        // parser/TCS.g:1:8: ( T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | QNAME_OR_NAME | INT | FLOAT | STRING )
        int alt18=125;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // parser/TCS.g:1:10: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 2 :
                // parser/TCS.g:1:16: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 3 :
                // parser/TCS.g:1:22: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 4 :
                // parser/TCS.g:1:28: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 5 :
                // parser/TCS.g:1:34: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 6 :
                // parser/TCS.g:1:40: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 7 :
                // parser/TCS.g:1:46: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 8 :
                // parser/TCS.g:1:52: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 9 :
                // parser/TCS.g:1:58: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 10 :
                // parser/TCS.g:1:64: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 11 :
                // parser/TCS.g:1:70: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 12 :
                // parser/TCS.g:1:76: T__63
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 13 :
                // parser/TCS.g:1:82: T__64
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 14 :
                // parser/TCS.g:1:88: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 15 :
                // parser/TCS.g:1:94: T__66
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 16 :
                // parser/TCS.g:1:100: T__67
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 17 :
                // parser/TCS.g:1:106: T__68
                {
                mT__68(); if (state.failed) return ;

                }
                break;
            case 18 :
                // parser/TCS.g:1:112: T__69
                {
                mT__69(); if (state.failed) return ;

                }
                break;
            case 19 :
                // parser/TCS.g:1:118: T__70
                {
                mT__70(); if (state.failed) return ;

                }
                break;
            case 20 :
                // parser/TCS.g:1:124: T__71
                {
                mT__71(); if (state.failed) return ;

                }
                break;
            case 21 :
                // parser/TCS.g:1:130: T__72
                {
                mT__72(); if (state.failed) return ;

                }
                break;
            case 22 :
                // parser/TCS.g:1:136: T__73
                {
                mT__73(); if (state.failed) return ;

                }
                break;
            case 23 :
                // parser/TCS.g:1:142: T__74
                {
                mT__74(); if (state.failed) return ;

                }
                break;
            case 24 :
                // parser/TCS.g:1:148: T__75
                {
                mT__75(); if (state.failed) return ;

                }
                break;
            case 25 :
                // parser/TCS.g:1:154: T__76
                {
                mT__76(); if (state.failed) return ;

                }
                break;
            case 26 :
                // parser/TCS.g:1:160: T__77
                {
                mT__77(); if (state.failed) return ;

                }
                break;
            case 27 :
                // parser/TCS.g:1:166: T__78
                {
                mT__78(); if (state.failed) return ;

                }
                break;
            case 28 :
                // parser/TCS.g:1:172: T__79
                {
                mT__79(); if (state.failed) return ;

                }
                break;
            case 29 :
                // parser/TCS.g:1:178: T__80
                {
                mT__80(); if (state.failed) return ;

                }
                break;
            case 30 :
                // parser/TCS.g:1:184: T__81
                {
                mT__81(); if (state.failed) return ;

                }
                break;
            case 31 :
                // parser/TCS.g:1:190: T__82
                {
                mT__82(); if (state.failed) return ;

                }
                break;
            case 32 :
                // parser/TCS.g:1:196: T__83
                {
                mT__83(); if (state.failed) return ;

                }
                break;
            case 33 :
                // parser/TCS.g:1:202: T__84
                {
                mT__84(); if (state.failed) return ;

                }
                break;
            case 34 :
                // parser/TCS.g:1:208: T__85
                {
                mT__85(); if (state.failed) return ;

                }
                break;
            case 35 :
                // parser/TCS.g:1:214: T__86
                {
                mT__86(); if (state.failed) return ;

                }
                break;
            case 36 :
                // parser/TCS.g:1:220: T__87
                {
                mT__87(); if (state.failed) return ;

                }
                break;
            case 37 :
                // parser/TCS.g:1:226: T__88
                {
                mT__88(); if (state.failed) return ;

                }
                break;
            case 38 :
                // parser/TCS.g:1:232: T__89
                {
                mT__89(); if (state.failed) return ;

                }
                break;
            case 39 :
                // parser/TCS.g:1:238: T__90
                {
                mT__90(); if (state.failed) return ;

                }
                break;
            case 40 :
                // parser/TCS.g:1:244: T__91
                {
                mT__91(); if (state.failed) return ;

                }
                break;
            case 41 :
                // parser/TCS.g:1:250: T__92
                {
                mT__92(); if (state.failed) return ;

                }
                break;
            case 42 :
                // parser/TCS.g:1:256: T__93
                {
                mT__93(); if (state.failed) return ;

                }
                break;
            case 43 :
                // parser/TCS.g:1:262: T__94
                {
                mT__94(); if (state.failed) return ;

                }
                break;
            case 44 :
                // parser/TCS.g:1:268: T__95
                {
                mT__95(); if (state.failed) return ;

                }
                break;
            case 45 :
                // parser/TCS.g:1:274: T__96
                {
                mT__96(); if (state.failed) return ;

                }
                break;
            case 46 :
                // parser/TCS.g:1:280: T__97
                {
                mT__97(); if (state.failed) return ;

                }
                break;
            case 47 :
                // parser/TCS.g:1:286: T__98
                {
                mT__98(); if (state.failed) return ;

                }
                break;
            case 48 :
                // parser/TCS.g:1:292: T__99
                {
                mT__99(); if (state.failed) return ;

                }
                break;
            case 49 :
                // parser/TCS.g:1:298: T__100
                {
                mT__100(); if (state.failed) return ;

                }
                break;
            case 50 :
                // parser/TCS.g:1:305: T__101
                {
                mT__101(); if (state.failed) return ;

                }
                break;
            case 51 :
                // parser/TCS.g:1:312: T__102
                {
                mT__102(); if (state.failed) return ;

                }
                break;
            case 52 :
                // parser/TCS.g:1:319: T__103
                {
                mT__103(); if (state.failed) return ;

                }
                break;
            case 53 :
                // parser/TCS.g:1:326: T__104
                {
                mT__104(); if (state.failed) return ;

                }
                break;
            case 54 :
                // parser/TCS.g:1:333: T__105
                {
                mT__105(); if (state.failed) return ;

                }
                break;
            case 55 :
                // parser/TCS.g:1:340: T__106
                {
                mT__106(); if (state.failed) return ;

                }
                break;
            case 56 :
                // parser/TCS.g:1:347: T__107
                {
                mT__107(); if (state.failed) return ;

                }
                break;
            case 57 :
                // parser/TCS.g:1:354: T__108
                {
                mT__108(); if (state.failed) return ;

                }
                break;
            case 58 :
                // parser/TCS.g:1:361: T__109
                {
                mT__109(); if (state.failed) return ;

                }
                break;
            case 59 :
                // parser/TCS.g:1:368: T__110
                {
                mT__110(); if (state.failed) return ;

                }
                break;
            case 60 :
                // parser/TCS.g:1:375: T__111
                {
                mT__111(); if (state.failed) return ;

                }
                break;
            case 61 :
                // parser/TCS.g:1:382: T__112
                {
                mT__112(); if (state.failed) return ;

                }
                break;
            case 62 :
                // parser/TCS.g:1:389: T__113
                {
                mT__113(); if (state.failed) return ;

                }
                break;
            case 63 :
                // parser/TCS.g:1:396: T__114
                {
                mT__114(); if (state.failed) return ;

                }
                break;
            case 64 :
                // parser/TCS.g:1:403: T__115
                {
                mT__115(); if (state.failed) return ;

                }
                break;
            case 65 :
                // parser/TCS.g:1:410: T__116
                {
                mT__116(); if (state.failed) return ;

                }
                break;
            case 66 :
                // parser/TCS.g:1:417: T__117
                {
                mT__117(); if (state.failed) return ;

                }
                break;
            case 67 :
                // parser/TCS.g:1:424: T__118
                {
                mT__118(); if (state.failed) return ;

                }
                break;
            case 68 :
                // parser/TCS.g:1:431: T__119
                {
                mT__119(); if (state.failed) return ;

                }
                break;
            case 69 :
                // parser/TCS.g:1:438: T__120
                {
                mT__120(); if (state.failed) return ;

                }
                break;
            case 70 :
                // parser/TCS.g:1:445: T__121
                {
                mT__121(); if (state.failed) return ;

                }
                break;
            case 71 :
                // parser/TCS.g:1:452: T__122
                {
                mT__122(); if (state.failed) return ;

                }
                break;
            case 72 :
                // parser/TCS.g:1:459: T__123
                {
                mT__123(); if (state.failed) return ;

                }
                break;
            case 73 :
                // parser/TCS.g:1:466: T__124
                {
                mT__124(); if (state.failed) return ;

                }
                break;
            case 74 :
                // parser/TCS.g:1:473: T__125
                {
                mT__125(); if (state.failed) return ;

                }
                break;
            case 75 :
                // parser/TCS.g:1:480: T__126
                {
                mT__126(); if (state.failed) return ;

                }
                break;
            case 76 :
                // parser/TCS.g:1:487: T__127
                {
                mT__127(); if (state.failed) return ;

                }
                break;
            case 77 :
                // parser/TCS.g:1:494: T__128
                {
                mT__128(); if (state.failed) return ;

                }
                break;
            case 78 :
                // parser/TCS.g:1:501: T__129
                {
                mT__129(); if (state.failed) return ;

                }
                break;
            case 79 :
                // parser/TCS.g:1:508: T__130
                {
                mT__130(); if (state.failed) return ;

                }
                break;
            case 80 :
                // parser/TCS.g:1:515: T__131
                {
                mT__131(); if (state.failed) return ;

                }
                break;
            case 81 :
                // parser/TCS.g:1:522: T__132
                {
                mT__132(); if (state.failed) return ;

                }
                break;
            case 82 :
                // parser/TCS.g:1:529: T__133
                {
                mT__133(); if (state.failed) return ;

                }
                break;
            case 83 :
                // parser/TCS.g:1:536: T__134
                {
                mT__134(); if (state.failed) return ;

                }
                break;
            case 84 :
                // parser/TCS.g:1:543: T__135
                {
                mT__135(); if (state.failed) return ;

                }
                break;
            case 85 :
                // parser/TCS.g:1:550: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 86 :
                // parser/TCS.g:1:558: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 87 :
                // parser/TCS.g:1:577: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 88 :
                // parser/TCS.g:1:585: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 89 :
                // parser/TCS.g:1:593: DLSQUARE
                {
                mDLSQUARE(); if (state.failed) return ;

                }
                break;
            case 90 :
                // parser/TCS.g:1:602: DRSQUARE
                {
                mDRSQUARE(); if (state.failed) return ;

                }
                break;
            case 91 :
                // parser/TCS.g:1:611: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 92 :
                // parser/TCS.g:1:616: COMA
                {
                mCOMA(); if (state.failed) return ;

                }
                break;
            case 93 :
                // parser/TCS.g:1:621: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 94 :
                // parser/TCS.g:1:628: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 95 :
                // parser/TCS.g:1:635: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 96 :
                // parser/TCS.g:1:642: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 97 :
                // parser/TCS.g:1:649: DLCURLY
                {
                mDLCURLY(); if (state.failed) return ;

                }
                break;
            case 98 :
                // parser/TCS.g:1:657: DRCURLY
                {
                mDRCURLY(); if (state.failed) return ;

                }
                break;
            case 99 :
                // parser/TCS.g:1:665: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 100 :
                // parser/TCS.g:1:670: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 101 :
                // parser/TCS.g:1:676: DLCOLON
                {
                mDLCOLON(); if (state.failed) return ;

                }
                break;
            case 102 :
                // parser/TCS.g:1:684: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 103 :
                // parser/TCS.g:1:689: SHARP
                {
                mSHARP(); if (state.failed) return ;

                }
                break;
            case 104 :
                // parser/TCS.g:1:695: QMARK
                {
                mQMARK(); if (state.failed) return ;

                }
                break;
            case 105 :
                // parser/TCS.g:1:701: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;

                }
                break;
            case 106 :
                // parser/TCS.g:1:708: AROBAS
                {
                mAROBAS(); if (state.failed) return ;

                }
                break;
            case 107 :
                // parser/TCS.g:1:715: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 108 :
                // parser/TCS.g:1:721: RARROW
                {
                mRARROW(); if (state.failed) return ;

                }
                break;
            case 109 :
                // parser/TCS.g:1:728: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 110 :
                // parser/TCS.g:1:734: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 111 :
                // parser/TCS.g:1:739: SLASH
                {
                mSLASH(); if (state.failed) return ;

                }
                break;
            case 112 :
                // parser/TCS.g:1:745: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 113 :
                // parser/TCS.g:1:750: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 114 :
                // parser/TCS.g:1:753: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 115 :
                // parser/TCS.g:1:756: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 116 :
                // parser/TCS.g:1:759: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 117 :
                // parser/TCS.g:1:762: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 118 :
                // parser/TCS.g:1:765: NE
                {
                mNE(); if (state.failed) return ;

                }
                break;
            case 119 :
                // parser/TCS.g:1:768: LARROW
                {
                mLARROW(); if (state.failed) return ;

                }
                break;
            case 120 :
                // parser/TCS.g:1:775: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 121 :
                // parser/TCS.g:1:778: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 122 :
                // parser/TCS.g:1:781: QNAME_OR_NAME
                {
                mQNAME_OR_NAME(); if (state.failed) return ;

                }
                break;
            case 123 :
                // parser/TCS.g:1:795: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 124 :
                // parser/TCS.g:1:799: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 125 :
                // parser/TCS.g:1:805: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred2_TCS
    public final void synpred2_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:1900:5: ( ORKEYWORD COLON )
        // parser/TCS.g:1900:7: ORKEYWORD COLON
        {
        mORKEYWORD(); if (state.failed) return ;
        mCOLON(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_TCS

    // $ANTLR start synpred3_TCS
    public final void synpred3_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:1901:10: ( SNAME DLCOLON SNAME )
        // parser/TCS.g:1901:12: SNAME DLCOLON SNAME
        {
        mSNAME(); if (state.failed) return ;
        mDLCOLON(); if (state.failed) return ;
        mSNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_TCS

    // $ANTLR start synpred4_TCS
    public final void synpred4_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:1902:8: (~ ORKEYWORD COLON | SNAME COLON ~ ( COLON ) )
        int alt19=2;
        int LA19_0 = input.LA(1);

        if ( ((LA19_0>='A' && LA19_0<='Z')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='z')||(LA19_0>='\u00C0' && LA19_0<='\u00D6')||(LA19_0>='\u00D8' && LA19_0<='\u00F6')||(LA19_0>='\u00F8' && LA19_0<='\u00FF')) ) {
            int LA19_1 = input.LA(2);

            if ( (LA19_1==':') ) {
                int LA19_3 = input.LA(3);

                if ( ((LA19_3>='\u0000' && LA19_3<='9')||(LA19_3>=';' && LA19_3<='\uFFFF')) ) {
                    alt19=2;
                }
                else {
                    alt19=1;}
            }
            else if ( ((LA19_1>='0' && LA19_1<='9')||(LA19_1>='A' && LA19_1<='Z')||LA19_1=='_'||(LA19_1>='a' && LA19_1<='z')||(LA19_1>='\u00C0' && LA19_1<='\u00D6')||(LA19_1>='\u00D8' && LA19_1<='\u00F6')||(LA19_1>='\u00F8' && LA19_1<='\u00FF')) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 1, input);

                throw nvae;
            }
        }
        else if ( ((LA19_0>='\u0000' && LA19_0<='@')||(LA19_0>='[' && LA19_0<='^')||LA19_0=='`'||(LA19_0>='{' && LA19_0<='\u00BF')||LA19_0=='\u00D7'||LA19_0=='\u00F7'||(LA19_0>='\u0100' && LA19_0<='\uFFFF')) ) {
            alt19=1;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 19, 0, input);

            throw nvae;
        }
        switch (alt19) {
            case 1 :
                // parser/TCS.g:1902:9: ~ ORKEYWORD COLON
                {
                if ( (input.LA(1)>='\u0000' && input.LA(1)<='/')||(input.LA(1)>='1' && input.LA(1)<='\uFFFF') ) {
                    input.consume();
                state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    recover(mse);
                    throw mse;}

                mCOLON(); if (state.failed) return ;

                }
                break;
            case 2 :
                // parser/TCS.g:1902:28: SNAME COLON ~ ( COLON )
                {
                mSNAME(); if (state.failed) return ;
                mCOLON(); if (state.failed) return ;
                if ( (input.LA(1)>='\u0000' && input.LA(1)<='9')||(input.LA(1)>=';' && input.LA(1)<='\uFFFF') ) {
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

        }}
    // $ANTLR end synpred4_TCS

    // $ANTLR start synpred5_TCS
    public final void synpred5_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:1903:11: (~ ORKEYWORD | SNAME ~ COLON )
        int alt20=2;
        int LA20_0 = input.LA(1);

        if ( ((LA20_0>='A' && LA20_0<='Z')||LA20_0=='_'||(LA20_0>='a' && LA20_0<='z')||(LA20_0>='\u00C0' && LA20_0<='\u00D6')||(LA20_0>='\u00D8' && LA20_0<='\u00F6')||(LA20_0>='\u00F8' && LA20_0<='\u00FF')) ) {
            int LA20_1 = input.LA(2);

            if ( ((LA20_1>='\u0000' && LA20_1<='9')||(LA20_1>=';' && LA20_1<='\uFFFF')) ) {
                alt20=2;
            }
            else {
                alt20=1;}
        }
        else if ( ((LA20_0>='\u0000' && LA20_0<='@')||(LA20_0>='[' && LA20_0<='^')||LA20_0=='`'||(LA20_0>='{' && LA20_0<='\u00BF')||LA20_0=='\u00D7'||LA20_0=='\u00F7'||(LA20_0>='\u0100' && LA20_0<='\uFFFF')) ) {
            alt20=1;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 20, 0, input);

            throw nvae;
        }
        switch (alt20) {
            case 1 :
                // parser/TCS.g:1903:13: ~ ORKEYWORD
                {
                if ( (input.LA(1)>='\u0000' && input.LA(1)<='/')||(input.LA(1)>='1' && input.LA(1)<='\uFFFF') ) {
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
            case 2 :
                // parser/TCS.g:1903:26: SNAME ~ COLON
                {
                mSNAME(); if (state.failed) return ;
                if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u000F')||(input.LA(1)>='\u0011' && input.LA(1)<='\uFFFF') ) {
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

        }}
    // $ANTLR end synpred5_TCS

    // $ANTLR start synpred6_TCS
    public final void synpred6_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:1904:11: ( '\\'' SNAME )
        // parser/TCS.g:1904:13: '\\'' SNAME
        {
        match('\''); if (state.failed) return ;
        mSNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_TCS

    public final boolean synpred6_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA5_eotS =
        "\41\uffff\1\42\1\uffff";
    static final String DFA5_eofS =
        "\43\uffff";
    static final String DFA5_minS =
        "\1\47\2\60\1\0\1\60\5\uffff\1\42\3\0\1\60\12\0\1\60\2\0\1\60\1"+
        "\0\4\60\1\uffff";
    static final String DFA5_maxS =
        "\3\u00ff\1\uffff\1\u00ff\5\uffff\1\164\2\uffff\1\0\1\u00ff\12\uffff"+
        "\1\u00ff\2\uffff\1\u00ff\1\uffff\4\u00ff\1\uffff";
    static final String DFA5_acceptS =
        "\5\uffff\2\2\1\3\1\4\1\5\30\uffff\1\1";
    static final String DFA5_specialS =
        "\1\uffff\1\5\1\7\1\26\1\31\6\uffff\1\3\1\2\1\6\1\32\1\30\1\27\1"+
        "\1\1\10\1\13\1\12\1\15\1\22\1\25\1\11\1\20\1\4\1\0\1\17\1\14\1\23"+
        "\1\21\1\24\1\16\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\3\31\uffff\32\2\4\uffff\1\2\1\uffff\16\2\1\1\13\2\105\uffff"+
            "\27\2\1\uffff\37\2\1\uffff\10\2",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\21\5\1\4\10\5\105"+
            "\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\32\5\105\uffff"+
            "\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\5\1\6\6\uffff\12\5\1\16\17\5\4\uffff\1\5\1\uffff\32\5"+
            "\105\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "",
            "",
            "",
            "",
            "",
            "\1\24\4\uffff\1\25\10\uffff\4\27\4\30\44\uffff\1\26\5\uffff"+
            "\1\22\3\uffff\1\23\7\uffff\1\17\3\uffff\1\20\1\uffff\1\21",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\1\uffff",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\4\5\1\31\25\5\105"+
            "\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\10\14\10\32\44\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\10\14\10\33\44\14\1\12\uffa3\14",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\30\5\1\34\1\5\105"+
            "\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\14\1\13\34\14\1\15\10\14\10\35\44\14\1\12\uffa3\14",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\26\5\1\36\3\5\105"+
            "\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\14\1\13\34\14\1\15\64\14\1\12\uffa3\14",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\16\5\1\37\13\5"+
            "\105\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\21\5\1\40\10\5"+
            "\105\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\3\5\1\41\26\5\105"+
            "\uffff\27\5\1\uffff\37\5\1\uffff\10\5",
            "\12\5\1\6\6\uffff\32\5\4\uffff\1\5\1\uffff\32\5\105\uffff"+
            "\27\5\1\uffff\37\5\1\uffff\10\5",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1899:1: QNAME_OR_NAME : ( ( ORKEYWORD COLON )=> ORKEYWORD | ( SNAME DLCOLON SNAME )=> QNAME | (~ ORKEYWORD COLON | SNAME COLON ~ ( COLON ) )=> NAME | (~ ORKEYWORD | SNAME ~ COLON )=> NAME | ( '\\'' SNAME )=> NAME );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_27 = input.LA(1);

                        s = -1;
                        if ( (LA5_27=='\'') ) {s = 13;}

                        else if ( (LA5_27=='\\') ) {s = 10;}

                        else if ( (LA5_27=='\n') ) {s = 11;}

                        else if ( ((LA5_27>='\u0000' && LA5_27<='\t')||(LA5_27>='\u000B' && LA5_27<='&')||(LA5_27>='(' && LA5_27<='[')||(LA5_27>=']' && LA5_27<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_17 = input.LA(1);

                        s = -1;
                        if ( (LA5_17=='\'') ) {s = 13;}

                        else if ( (LA5_17=='\\') ) {s = 10;}

                        else if ( (LA5_17=='\n') ) {s = 11;}

                        else if ( ((LA5_17>='\u0000' && LA5_17<='\t')||(LA5_17>='\u000B' && LA5_17<='&')||(LA5_17>='(' && LA5_17<='[')||(LA5_17>=']' && LA5_17<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_12 = input.LA(1);

                        s = -1;
                        if ( (LA5_12=='\'') ) {s = 13;}

                        else if ( (LA5_12=='\\') ) {s = 10;}

                        else if ( (LA5_12=='\n') ) {s = 11;}

                        else if ( ((LA5_12>='\u0000' && LA5_12<='\t')||(LA5_12>='\u000B' && LA5_12<='&')||(LA5_12>='(' && LA5_12<='[')||(LA5_12>=']' && LA5_12<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_11 = input.LA(1);

                        s = -1;
                        if ( (LA5_11=='\'') ) {s = 13;}

                        else if ( (LA5_11=='\\') ) {s = 10;}

                        else if ( (LA5_11=='\n') ) {s = 11;}

                        else if ( ((LA5_11>='\u0000' && LA5_11<='\t')||(LA5_11>='\u000B' && LA5_11<='&')||(LA5_11>='(' && LA5_11<='[')||(LA5_11>=']' && LA5_11<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_26 = input.LA(1);

                        s = -1;
                        if ( ((LA5_26>='0' && LA5_26<='7')) ) {s = 29;}

                        else if ( (LA5_26=='\'') ) {s = 13;}

                        else if ( (LA5_26=='\\') ) {s = 10;}

                        else if ( (LA5_26=='\n') ) {s = 11;}

                        else if ( ((LA5_26>='\u0000' && LA5_26<='\t')||(LA5_26>='\u000B' && LA5_26<='&')||(LA5_26>='(' && LA5_26<='/')||(LA5_26>='8' && LA5_26<='[')||(LA5_26>=']' && LA5_26<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_1 = input.LA(1);

                         
                        int index5_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_1=='r') ) {s = 4;}

                        else if ( ((LA5_1>='0' && LA5_1<='9')||(LA5_1>='A' && LA5_1<='Z')||LA5_1=='_'||(LA5_1>='a' && LA5_1<='q')||(LA5_1>='s' && LA5_1<='z')||(LA5_1>='\u00C0' && LA5_1<='\u00D6')||(LA5_1>='\u00D8' && LA5_1<='\u00F6')||(LA5_1>='\u00F8' && LA5_1<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                        else if ( (LA5_1==':') && (synpred3_TCS())) {s = 6;}

                        else if ( (synpred4_TCS()) ) {s = 7;}

                        else if ( (synpred5_TCS()) ) {s = 8;}

                        else if ( (synpred6_TCS()) ) {s = 9;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_13 = input.LA(1);

                         
                        int index5_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_TCS()) ) {s = 7;}

                        else if ( (synpred5_TCS()) ) {s = 8;}

                        else if ( (synpred6_TCS()) ) {s = 9;}

                         
                        input.seek(index5_13);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA5_2 = input.LA(1);

                         
                        int index5_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA5_2>='0' && LA5_2<='9')||(LA5_2>='A' && LA5_2<='Z')||LA5_2=='_'||(LA5_2>='a' && LA5_2<='z')||(LA5_2>='\u00C0' && LA5_2<='\u00D6')||(LA5_2>='\u00D8' && LA5_2<='\u00F6')||(LA5_2>='\u00F8' && LA5_2<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                        else if ( (LA5_2==':') && (synpred3_TCS())) {s = 6;}

                        else if ( (synpred4_TCS()) ) {s = 7;}

                        else if ( (synpred5_TCS()) ) {s = 8;}

                        else if ( (synpred6_TCS()) ) {s = 9;}

                         
                        input.seek(index5_2);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA5_18 = input.LA(1);

                        s = -1;
                        if ( (LA5_18=='\'') ) {s = 13;}

                        else if ( (LA5_18=='\\') ) {s = 10;}

                        else if ( (LA5_18=='\n') ) {s = 11;}

                        else if ( ((LA5_18>='\u0000' && LA5_18<='\t')||(LA5_18>='\u000B' && LA5_18<='&')||(LA5_18>='(' && LA5_18<='[')||(LA5_18>=']' && LA5_18<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA5_24 = input.LA(1);

                        s = -1;
                        if ( ((LA5_24>='0' && LA5_24<='7')) ) {s = 27;}

                        else if ( (LA5_24=='\'') ) {s = 13;}

                        else if ( (LA5_24=='\\') ) {s = 10;}

                        else if ( (LA5_24=='\n') ) {s = 11;}

                        else if ( ((LA5_24>='\u0000' && LA5_24<='\t')||(LA5_24>='\u000B' && LA5_24<='&')||(LA5_24>='(' && LA5_24<='/')||(LA5_24>='8' && LA5_24<='[')||(LA5_24>=']' && LA5_24<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA5_20 = input.LA(1);

                        s = -1;
                        if ( (LA5_20=='\'') ) {s = 13;}

                        else if ( (LA5_20=='\\') ) {s = 10;}

                        else if ( (LA5_20=='\n') ) {s = 11;}

                        else if ( ((LA5_20>='\u0000' && LA5_20<='\t')||(LA5_20>='\u000B' && LA5_20<='&')||(LA5_20>='(' && LA5_20<='[')||(LA5_20>=']' && LA5_20<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA5_19 = input.LA(1);

                        s = -1;
                        if ( (LA5_19=='\'') ) {s = 13;}

                        else if ( (LA5_19=='\\') ) {s = 10;}

                        else if ( (LA5_19=='\n') ) {s = 11;}

                        else if ( ((LA5_19>='\u0000' && LA5_19<='\t')||(LA5_19>='\u000B' && LA5_19<='&')||(LA5_19>='(' && LA5_19<='[')||(LA5_19>=']' && LA5_19<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA5_29 = input.LA(1);

                        s = -1;
                        if ( (LA5_29=='\'') ) {s = 13;}

                        else if ( (LA5_29=='\\') ) {s = 10;}

                        else if ( (LA5_29=='\n') ) {s = 11;}

                        else if ( ((LA5_29>='\u0000' && LA5_29<='\t')||(LA5_29>='\u000B' && LA5_29<='&')||(LA5_29>='(' && LA5_29<='[')||(LA5_29>=']' && LA5_29<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA5_21 = input.LA(1);

                        s = -1;
                        if ( (LA5_21=='\'') ) {s = 13;}

                        else if ( (LA5_21=='\\') ) {s = 10;}

                        else if ( (LA5_21=='\n') ) {s = 11;}

                        else if ( ((LA5_21>='\u0000' && LA5_21<='\t')||(LA5_21>='\u000B' && LA5_21<='&')||(LA5_21>='(' && LA5_21<='[')||(LA5_21>=']' && LA5_21<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA5_33 = input.LA(1);

                         
                        int index5_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_33==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_33>='0' && LA5_33<='9')||(LA5_33>='A' && LA5_33<='Z')||LA5_33=='_'||(LA5_33>='a' && LA5_33<='z')||(LA5_33>='\u00C0' && LA5_33<='\u00D6')||(LA5_33>='\u00D8' && LA5_33<='\u00F6')||(LA5_33>='\u00F8' && LA5_33<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                        else s = 34;

                         
                        input.seek(index5_33);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA5_28 = input.LA(1);

                         
                        int index5_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_28=='w') ) {s = 30;}

                        else if ( (LA5_28==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_28>='0' && LA5_28<='9')||(LA5_28>='A' && LA5_28<='Z')||LA5_28=='_'||(LA5_28>='a' && LA5_28<='v')||(LA5_28>='x' && LA5_28<='z')||(LA5_28>='\u00C0' && LA5_28<='\u00D6')||(LA5_28>='\u00D8' && LA5_28<='\u00F6')||(LA5_28>='\u00F8' && LA5_28<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_28);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA5_25 = input.LA(1);

                         
                        int index5_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_25=='y') ) {s = 28;}

                        else if ( (LA5_25==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_25>='0' && LA5_25<='9')||(LA5_25>='A' && LA5_25<='Z')||LA5_25=='_'||(LA5_25>='a' && LA5_25<='x')||LA5_25=='z'||(LA5_25>='\u00C0' && LA5_25<='\u00D6')||(LA5_25>='\u00D8' && LA5_25<='\u00F6')||(LA5_25>='\u00F8' && LA5_25<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA5_31 = input.LA(1);

                         
                        int index5_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_31=='r') ) {s = 32;}

                        else if ( (LA5_31==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_31>='0' && LA5_31<='9')||(LA5_31>='A' && LA5_31<='Z')||LA5_31=='_'||(LA5_31>='a' && LA5_31<='q')||(LA5_31>='s' && LA5_31<='z')||(LA5_31>='\u00C0' && LA5_31<='\u00D6')||(LA5_31>='\u00D8' && LA5_31<='\u00F6')||(LA5_31>='\u00F8' && LA5_31<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_31);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA5_22 = input.LA(1);

                        s = -1;
                        if ( (LA5_22=='\'') ) {s = 13;}

                        else if ( (LA5_22=='\\') ) {s = 10;}

                        else if ( (LA5_22=='\n') ) {s = 11;}

                        else if ( ((LA5_22>='\u0000' && LA5_22<='\t')||(LA5_22>='\u000B' && LA5_22<='&')||(LA5_22>='(' && LA5_22<='[')||(LA5_22>=']' && LA5_22<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA5_30 = input.LA(1);

                         
                        int index5_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_30=='o') ) {s = 31;}

                        else if ( (LA5_30==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_30>='0' && LA5_30<='9')||(LA5_30>='A' && LA5_30<='Z')||LA5_30=='_'||(LA5_30>='a' && LA5_30<='n')||(LA5_30>='p' && LA5_30<='z')||(LA5_30>='\u00C0' && LA5_30<='\u00D6')||(LA5_30>='\u00D8' && LA5_30<='\u00F6')||(LA5_30>='\u00F8' && LA5_30<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_30);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA5_32 = input.LA(1);

                         
                        int index5_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_32=='d') ) {s = 33;}

                        else if ( (LA5_32==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_32>='0' && LA5_32<='9')||(LA5_32>='A' && LA5_32<='Z')||LA5_32=='_'||(LA5_32>='a' && LA5_32<='c')||(LA5_32>='e' && LA5_32<='z')||(LA5_32>='\u00C0' && LA5_32<='\u00D6')||(LA5_32>='\u00D8' && LA5_32<='\u00F6')||(LA5_32>='\u00F8' && LA5_32<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_32);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA5_23 = input.LA(1);

                        s = -1;
                        if ( ((LA5_23>='0' && LA5_23<='7')) ) {s = 26;}

                        else if ( (LA5_23=='\'') ) {s = 13;}

                        else if ( (LA5_23=='\\') ) {s = 10;}

                        else if ( (LA5_23=='\n') ) {s = 11;}

                        else if ( ((LA5_23>='\u0000' && LA5_23<='\t')||(LA5_23>='\u000B' && LA5_23<='&')||(LA5_23>='(' && LA5_23<='/')||(LA5_23>='8' && LA5_23<='[')||(LA5_23>=']' && LA5_23<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA5_3 = input.LA(1);

                        s = -1;
                        if ( (LA5_3=='\\') ) {s = 10;}

                        else if ( (LA5_3=='\n') ) {s = 11;}

                        else if ( ((LA5_3>='\u0000' && LA5_3<='\t')||(LA5_3>='\u000B' && LA5_3<='&')||(LA5_3>='(' && LA5_3<='[')||(LA5_3>=']' && LA5_3<='\uFFFF')) ) {s = 12;}

                        else if ( (LA5_3=='\'') ) {s = 13;}

                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA5_16 = input.LA(1);

                        s = -1;
                        if ( (LA5_16=='\'') ) {s = 13;}

                        else if ( (LA5_16=='\\') ) {s = 10;}

                        else if ( (LA5_16=='\n') ) {s = 11;}

                        else if ( ((LA5_16>='\u0000' && LA5_16<='\t')||(LA5_16>='\u000B' && LA5_16<='&')||(LA5_16>='(' && LA5_16<='[')||(LA5_16>=']' && LA5_16<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA5_15 = input.LA(1);

                        s = -1;
                        if ( (LA5_15=='\'') ) {s = 13;}

                        else if ( (LA5_15=='\\') ) {s = 10;}

                        else if ( (LA5_15=='\n') ) {s = 11;}

                        else if ( ((LA5_15>='\u0000' && LA5_15<='\t')||(LA5_15>='\u000B' && LA5_15<='&')||(LA5_15>='(' && LA5_15<='[')||(LA5_15>=']' && LA5_15<='\uFFFF')) ) {s = 12;}

                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA5_4 = input.LA(1);

                         
                        int index5_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_4=='K') ) {s = 14;}

                        else if ( (LA5_4==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_4>='0' && LA5_4<='9')||(LA5_4>='A' && LA5_4<='J')||(LA5_4>='L' && LA5_4<='Z')||LA5_4=='_'||(LA5_4>='a' && LA5_4<='z')||(LA5_4>='\u00C0' && LA5_4<='\u00D6')||(LA5_4>='\u00D8' && LA5_4<='\u00F6')||(LA5_4>='\u00F8' && LA5_4<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_4);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA5_14 = input.LA(1);

                         
                        int index5_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_14=='e') ) {s = 25;}

                        else if ( (LA5_14==':') && (synpred3_TCS())) {s = 6;}

                        else if ( ((LA5_14>='0' && LA5_14<='9')||(LA5_14>='A' && LA5_14<='Z')||LA5_14=='_'||(LA5_14>='a' && LA5_14<='d')||(LA5_14>='f' && LA5_14<='z')||(LA5_14>='\u00C0' && LA5_14<='\u00D6')||(LA5_14>='\u00D8' && LA5_14<='\u00F6')||(LA5_14>='\u00F8' && LA5_14<='\u00FF')) && (synpred3_TCS())) {s = 5;}

                         
                        input.seek(index5_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\1\56\1\66\22\56\1\150\1\152\1\154\1\156\4\uffff\1\160"+
        "\1\162\1\uffff\1\164\11\uffff\1\166\1\172\3\uffff\1\173\1\uffff"+
        "\5\56\1\uffff\33\56\1\u00a4\23\56\27\uffff\12\56\1\u00c5\3\56\1"+
        "\u00cb\1\56\1\u00cd\25\56\1\u00e3\1\uffff\1\56\1\u00e5\1\56\1\u00e9"+
        "\20\56\1\u00fb\12\56\1\u0106\1\uffff\5\56\1\uffff\1\56\1\uffff\1"+
        "\56\1\u010e\1\56\1\u0110\12\56\1\u011b\1\56\1\u011d\1\56\1\u011f"+
        "\1\u0121\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\11\56\1\u0131\1"+
        "\u0132\1\u0133\3\56\1\u0139\1\56\1\uffff\11\56\1\u0144\1\uffff\2"+
        "\56\1\u0147\1\u0148\3\56\1\uffff\1\56\1\uffff\2\56\1\u0150\7\56"+
        "\1\uffff\1\u0159\1\uffff\1\u015b\1\uffff\1\56\1\uffff\5\56\1\u0162"+
        "\2\56\1\u0167\6\56\3\uffff\1\u016f\1\u0170\3\56\1\uffff\1\u0174"+
        "\1\u0175\2\56\1\u0178\5\56\1\uffff\2\56\2\uffff\7\56\1\uffff\2\56"+
        "\1\u018b\1\56\1\u018d\3\56\1\uffff\1\56\1\uffff\2\56\1\u0194\3\56"+
        "\1\uffff\1\u0199\3\56\1\uffff\4\56\1\u01a1\2\56\2\uffff\1\u01a4"+
        "\2\56\2\uffff\2\56\1\uffff\5\56\1\u01ae\4\56\1\u01b3\2\56\1\u01b6"+
        "\1\56\1\u01b8\2\56\1\uffff\1\u01bb\1\uffff\6\56\1\uffff\1\56\1\u01c3"+
        "\2\56\1\uffff\7\56\1\uffff\1\u01cd\1\u01ce\1\uffff\7\56\1\u01d6"+
        "\1\u01d7\1\uffff\4\56\1\uffff\1\u01de\1\u01df\1\uffff\1\56\1\uffff"+
        "\2\56\1\uffff\6\56\1\u01e9\1\uffff\2\56\1\u01ec\3\56\1\u01f0\1\u01f1"+
        "\1\56\2\uffff\1\u01f3\3\56\1\u01f7\1\56\1\u01f9\2\uffff\1\u01fa"+
        "\2\56\1\u01fd\2\56\2\uffff\1\u0200\1\u0201\2\56\1\u0204\1\56\1\u0206"+
        "\2\56\1\uffff\2\56\1\uffff\1\56\1\u020c\1\56\2\uffff\1\56\1\uffff"+
        "\1\u020f\1\u0210\1\u0211\1\uffff\1\56\2\uffff\1\56\1\u0214\1\uffff"+
        "\2\56\2\uffff\1\56\1\u0218\1\uffff\1\u0219\1\uffff\1\u021a\3\56"+
        "\1\u021e\1\uffff\2\56\3\uffff\2\56\1\uffff\3\56\3\uffff\1\56\1\u0227"+
        "\1\u0228\1\uffff\5\56\1\u022f\1\u0230\1\u0231\2\uffff\2\56\1\u0234"+
        "\3\56\3\uffff\1\u0238\1\56\1\uffff\2\56\1\u023c\1\uffff\3\56\1\uffff"+
        "\1\56\1\u0241\2\56\1\uffff\1\56\1\u0245\1\56\1\uffff\1\u0247\1\uffff";
    static final String DFA18_eofS =
        "\u0248\uffff";
    static final String DFA18_minS =
        "\1\11\1\146\1\60\1\145\1\143\1\156\1\145\1\157\1\145\1\142\1\141"+
        "\1\142\1\141\1\145\1\141\1\150\1\165\1\141\2\145\1\163\1\55\1\52"+
        "\1\133\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\55"+
        "\3\uffff\1\56\1\uffff\1\144\1\104\1\160\1\155\1\171\1\uffff\1\155"+
        "\1\153\1\165\1\145\1\151\1\145\1\164\1\144\1\143\1\163\1\157\2\145"+
        "\1\156\1\141\1\155\1\165\1\160\1\156\1\116\1\166\1\151\1\154\1\144"+
        "\1\164\2\144\1\60\1\154\1\163\1\162\2\154\1\156\1\147\1\146\1\145"+
        "\1\163\2\162\2\145\1\154\1\157\1\146\1\170\1\151\27\uffff\1\164"+
        "\3\145\1\157\1\151\1\167\1\160\2\145\1\60\1\164\1\162\1\141\1\60"+
        "\1\155\1\60\1\141\1\160\1\141\1\160\1\141\1\164\2\162\1\164\1\142"+
        "\1\162\1\151\1\141\1\120\1\114\1\145\1\156\1\164\1\145\1\157\1\124"+
        "\1\60\1\uffff\1\141\1\60\1\164\1\60\1\163\1\164\1\143\1\150\1\145"+
        "\1\155\1\146\2\164\1\144\1\156\1\162\1\165\1\153\1\164\1\145\1\60"+
        "\1\156\1\141\1\156\1\162\1\146\1\162\1\163\1\157\1\154\1\156\1\60"+
        "\1\uffff\1\164\1\141\1\154\1\114\1\146\1\uffff\1\145\1\uffff\1\155"+
        "\1\60\1\165\1\60\1\164\1\145\1\164\1\145\1\141\1\157\1\143\1\141"+
        "\2\162\1\60\1\162\1\60\1\151\2\60\1\157\1\uffff\1\171\1\uffff\1"+
        "\162\1\141\1\145\1\uffff\2\145\2\164\2\162\2\151\1\146\3\60\1\171"+
        "\1\145\1\111\1\60\1\162\1\uffff\1\147\1\156\2\164\1\151\1\164\1"+
        "\163\1\162\1\141\1\60\1\uffff\1\145\1\164\2\60\1\114\1\162\1\142"+
        "\1\uffff\1\154\1\uffff\1\145\1\170\1\60\1\117\1\170\1\154\1\145"+
        "\1\154\1\141\1\151\1\uffff\1\60\1\uffff\1\60\1\uffff\1\162\1\uffff"+
        "\1\103\1\163\1\141\1\143\1\144\1\60\1\162\1\151\1\60\1\145\1\151"+
        "\1\164\1\170\1\151\1\141\3\uffff\2\60\1\156\1\157\1\160\1\uffff"+
        "\2\60\1\143\1\111\1\60\1\156\1\103\1\151\1\144\1\164\1\uffff\1\144"+
        "\1\157\2\uffff\1\151\1\141\1\151\1\164\1\101\1\164\1\114\1\uffff"+
        "\1\160\1\151\1\60\1\163\1\60\1\151\1\164\1\155\1\uffff\1\151\1\uffff"+
        "\1\145\1\157\1\60\1\143\1\150\1\114\1\uffff\1\60\1\157\1\160\1\157"+
        "\1\uffff\1\156\1\124\1\164\1\151\1\60\1\170\1\154\2\uffff\1\60\1"+
        "\156\1\141\2\uffff\1\145\1\156\1\uffff\1\145\1\157\1\156\1\163\1"+
        "\145\1\60\1\162\1\156\1\164\1\147\1\60\1\156\1\163\1\60\1\116\1"+
        "\60\1\124\1\147\1\uffff\1\60\1\uffff\1\172\1\157\1\141\1\156\1\141"+
        "\1\156\1\uffff\1\164\1\60\1\160\1\157\1\uffff\1\156\1\141\1\156"+
        "\1\143\1\157\1\171\1\166\1\uffff\2\60\1\uffff\1\145\1\143\1\117"+
        "\1\143\1\144\1\156\1\147\2\60\1\uffff\1\124\1\145\1\151\1\165\1"+
        "\uffff\2\60\1\uffff\1\114\1\uffff\1\157\1\150\1\uffff\1\145\2\162"+
        "\1\145\2\164\1\60\1\uffff\1\160\1\167\1\60\1\143\2\145\2\60\1\145"+
        "\2\uffff\1\60\1\145\1\146\1\162\1\60\1\164\1\60\2\uffff\1\60\1\145"+
        "\1\144\1\60\1\157\1\141\2\uffff\2\60\1\164\1\162\1\60\1\171\1\60"+
        "\2\145\1\uffff\2\145\1\uffff\1\145\1\60\1\117\2\uffff\1\124\1\uffff"+
        "\3\60\1\uffff\1\145\2\uffff\1\155\1\60\1\uffff\1\156\1\164\2\uffff"+
        "\1\124\1\60\1\uffff\1\60\1\uffff\1\60\1\170\2\162\1\60\1\uffff\1"+
        "\156\1\145\3\uffff\1\170\1\160\1\uffff\1\124\1\145\1\157\3\uffff"+
        "\1\164\2\60\1\uffff\1\154\1\155\1\164\1\154\1\145\3\60\2\uffff\1"+
        "\171\1\160\1\60\1\141\1\155\1\63\3\uffff\1\60\1\154\1\uffff\1\164"+
        "\1\160\1\60\1\uffff\1\141\1\145\1\154\1\uffff\1\164\1\60\1\141\1"+
        "\145\1\uffff\1\164\1\60\1\145\1\uffff\1\60\1\uffff";
    static final String DFA18_maxS =
        "\1\u00ff\1\163\1\u00ff\1\162\1\160\1\163\2\162\1\171\1\157\3\165"+
        "\1\151\1\162\1\157\1\165\1\141\1\157\1\145\1\163\1\76\1\52\1\133"+
        "\1\135\4\uffff\1\173\1\175\1\uffff\1\72\11\uffff\1\75\1\76\3\uffff"+
        "\1\71\1\uffff\1\166\1\104\1\160\1\155\1\171\1\uffff\1\155\1\153"+
        "\1\165\1\145\1\151\1\145\1\164\1\165\1\143\1\163\1\157\1\146\1\145"+
        "\1\156\1\157\1\156\1\165\1\162\1\156\1\116\1\166\1\151\1\154\1\144"+
        "\1\164\2\144\1\u00ff\1\167\1\163\1\162\2\154\1\156\1\147\1\146\1"+
        "\151\1\163\2\162\2\145\1\154\1\157\2\170\1\151\27\uffff\1\164\3"+
        "\145\1\157\1\151\1\167\1\160\2\145\1\u00ff\1\164\1\162\1\141\1\u00ff"+
        "\1\155\1\u00ff\1\141\1\160\1\141\1\160\1\141\1\164\2\162\1\164\1"+
        "\142\1\162\1\151\1\141\1\120\1\114\1\145\1\156\1\164\1\145\1\157"+
        "\1\124\1\u00ff\1\uffff\1\141\1\u00ff\1\164\1\u00ff\1\163\1\164\1"+
        "\143\1\150\1\145\1\157\1\146\2\164\1\144\1\156\1\162\1\165\1\153"+
        "\1\164\1\145\1\u00ff\1\156\1\141\1\156\1\162\1\146\1\162\1\163\1"+
        "\157\1\154\1\156\1\u00ff\1\uffff\1\164\1\141\1\154\1\114\1\146\1"+
        "\uffff\1\145\1\uffff\1\155\1\u00ff\1\165\1\u00ff\1\164\1\145\1\164"+
        "\1\145\1\141\1\157\1\143\1\141\2\162\1\u00ff\1\162\1\u00ff\1\151"+
        "\2\u00ff\1\157\1\uffff\1\171\1\uffff\1\162\1\141\1\145\1\uffff\2"+
        "\145\2\164\2\162\2\151\1\146\3\u00ff\1\171\1\145\1\111\1\u00ff\1"+
        "\162\1\uffff\1\147\1\156\2\164\1\151\1\164\1\163\1\162\1\141\1\u00ff"+
        "\1\uffff\1\145\1\164\2\u00ff\1\114\1\162\1\142\1\uffff\1\154\1\uffff"+
        "\1\145\1\170\1\u00ff\1\122\1\170\1\154\1\145\1\154\1\141\1\151\1"+
        "\uffff\1\u00ff\1\uffff\1\u00ff\1\uffff\1\162\1\uffff\1\103\1\163"+
        "\1\141\1\143\1\144\1\u00ff\1\162\1\151\1\u00ff\1\163\1\151\1\164"+
        "\1\170\1\151\1\141\3\uffff\2\u00ff\1\156\1\157\1\160\1\uffff\2\u00ff"+
        "\1\143\1\111\1\u00ff\1\156\1\103\1\151\1\144\1\164\1\uffff\1\144"+
        "\1\157\2\uffff\1\151\1\141\1\151\1\164\1\111\1\164\1\142\1\uffff"+
        "\1\160\1\151\1\u00ff\1\163\1\u00ff\1\151\1\164\1\155\1\uffff\1\151"+
        "\1\uffff\1\145\1\157\1\u00ff\1\143\1\150\1\125\1\uffff\1\u00ff\1"+
        "\157\1\160\1\157\1\uffff\1\156\1\124\1\164\1\151\1\u00ff\1\170\1"+
        "\154\2\uffff\1\u00ff\1\156\1\141\2\uffff\1\145\1\156\1\uffff\1\145"+
        "\1\157\1\156\1\163\1\145\1\u00ff\1\162\1\156\1\164\1\147\1\u00ff"+
        "\1\156\1\163\1\u00ff\1\116\1\u00ff\1\124\1\147\1\uffff\1\u00ff\1"+
        "\uffff\1\172\1\157\1\141\1\156\1\141\1\156\1\uffff\1\164\1\u00ff"+
        "\1\160\1\157\1\uffff\1\156\1\141\1\156\1\143\1\157\1\171\1\166\1"+
        "\uffff\2\u00ff\1\uffff\1\145\1\143\1\117\1\143\1\144\1\156\1\147"+
        "\2\u00ff\1\uffff\1\163\1\145\1\151\1\165\1\uffff\2\u00ff\1\uffff"+
        "\1\114\1\uffff\1\157\1\150\1\uffff\1\145\2\162\1\145\2\164\1\u00ff"+
        "\1\uffff\1\160\1\167\1\u00ff\1\143\2\145\2\u00ff\1\145\2\uffff\1"+
        "\u00ff\1\145\1\146\1\162\1\u00ff\1\164\1\u00ff\2\uffff\1\u00ff\1"+
        "\145\1\144\1\u00ff\1\157\1\141\2\uffff\2\u00ff\1\164\1\162\1\u00ff"+
        "\1\171\1\u00ff\2\145\1\uffff\2\145\1\uffff\1\145\1\u00ff\1\117\2"+
        "\uffff\1\124\1\uffff\3\u00ff\1\uffff\1\145\2\uffff\1\155\1\u00ff"+
        "\1\uffff\1\156\1\164\2\uffff\1\124\1\u00ff\1\uffff\1\u00ff\1\uffff"+
        "\1\u00ff\1\170\2\162\1\u00ff\1\uffff\1\156\1\145\3\uffff\1\170\1"+
        "\160\1\uffff\1\124\1\145\1\157\3\uffff\1\164\2\u00ff\1\uffff\1\154"+
        "\1\155\1\164\1\154\1\145\3\u00ff\2\uffff\1\171\1\160\1\u00ff\1\141"+
        "\1\155\1\63\3\uffff\1\u00ff\1\154\1\uffff\1\164\1\160\1\u00ff\1"+
        "\uffff\1\141\1\145\1\154\1\uffff\1\164\1\u00ff\1\141\1\145\1\uffff"+
        "\1\164\1\u00ff\1\145\1\uffff\1\u00ff\1\uffff";
    static final String DFA18_acceptS =
        "\31\uffff\1\133\1\134\1\135\1\136\2\uffff\1\143\1\uffff\1\146\1"+
        "\147\1\150\1\151\1\152\1\153\1\156\1\160\1\161\2\uffff\1\170\1\171"+
        "\1\172\1\uffff\1\175\5\uffff\1\2\57\uffff\1\125\1\154\1\155\1\126"+
        "\1\157\1\131\1\127\1\132\1\130\1\141\1\137\1\142\1\140\1\145\1\144"+
        "\1\164\1\162\1\165\1\166\1\167\1\163\1\173\1\174\47\uffff\1\42\40"+
        "\uffff\1\5\5\uffff\1\63\1\uffff\1\17\25\uffff\1\35\1\uffff\1\66"+
        "\3\uffff\1\62\21\uffff\1\103\12\uffff\1\122\7\uffff\1\31\1\uffff"+
        "\1\101\12\uffff\1\45\1\uffff\1\16\1\uffff\1\100\1\uffff\1\20\17"+
        "\uffff\1\107\1\41\1\74\5\uffff\1\113\12\uffff\1\37\2\uffff\1\102"+
        "\1\6\7\uffff\1\11\10\uffff\1\120\1\uffff\1\54\6\uffff\1\57\4\uffff"+
        "\1\44\7\uffff\1\47\1\50\3\uffff\1\121\1\112\2\uffff\1\76\22\uffff"+
        "\1\12\1\uffff\1\24\6\uffff\1\55\4\uffff\1\67\7\uffff\1\40\2\uffff"+
        "\1\64\11\uffff\1\15\4\uffff\1\72\2\uffff\1\33\1\uffff\1\116\2\uffff"+
        "\1\105\7\uffff\1\25\11\uffff\1\46\1\110\7\uffff\1\27\1\3\6\uffff"+
        "\1\10\1\51\11\uffff\1\106\2\uffff\1\70\3\uffff\1\111\1\30\1\uffff"+
        "\1\65\3\uffff\1\4\1\uffff\1\77\1\53\2\uffff\1\43\2\uffff\1\75\1"+
        "\13\2\uffff\1\61\1\uffff\1\73\5\uffff\1\36\2\uffff\1\124\1\1\1\22"+
        "\2\uffff\1\114\3\uffff\1\60\1\14\1\117\3\uffff\1\26\10\uffff\1\71"+
        "\1\123\6\uffff\1\7\1\23\1\32\2\uffff\1\52\3\uffff\1\56\3\uffff\1"+
        "\34\4\uffff\1\104\3\uffff\1\115\1\uffff\1\21";
    static final String DFA18_specialS =
        "\u0248\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\31\1\60\1\42\1\44\2"+
            "\uffff\1\56\1\33\1\34\1\47\1\50\1\32\1\25\1\46\1\26\12\57\1"+
            "\40\1\37\1\53\1\51\1\52\1\43\1\45\32\56\1\27\1\uffff\1\30\1"+
            "\uffff\1\56\1\uffff\1\13\1\56\1\7\1\6\1\5\1\14\1\56\1\23\1\1"+
            "\1\56\1\2\1\22\1\12\1\11\1\4\1\16\1\20\1\15\1\10\1\3\1\24\1"+
            "\21\1\17\3\56\1\35\1\41\1\36\102\uffff\27\56\1\uffff\37\56\1"+
            "\uffff\10\56",
            "\1\64\6\uffff\1\63\1\61\4\uffff\1\62",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\4\56\1\65\25\56"+
            "\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\67\11\uffff\1\70\2\uffff\1\71",
            "\1\75\11\uffff\1\73\1\72\1\uffff\1\74",
            "\1\76\4\uffff\1\77",
            "\1\102\3\uffff\1\100\10\uffff\1\101",
            "\1\104\2\uffff\1\103",
            "\1\110\11\uffff\1\107\4\uffff\1\105\4\uffff\1\106",
            "\1\112\2\uffff\1\113\11\uffff\1\111",
            "\1\114\15\uffff\1\116\5\uffff\1\115",
            "\1\124\1\uffff\1\120\7\uffff\1\123\1\uffff\1\121\4\uffff\1"+
            "\122\1\uffff\1\117",
            "\1\126\7\uffff\1\127\5\uffff\1\125\5\uffff\1\130",
            "\1\132\3\uffff\1\131",
            "\1\135\15\uffff\1\134\2\uffff\1\133",
            "\1\137\6\uffff\1\136",
            "\1\140",
            "\1\141",
            "\1\143\11\uffff\1\142",
            "\1\144",
            "\1\145",
            "\1\146\20\uffff\1\147",
            "\1\151",
            "\1\153",
            "\1\155",
            "",
            "",
            "",
            "",
            "\1\157",
            "\1\161",
            "",
            "\1\163",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\165",
            "\1\171\17\uffff\1\167\1\170",
            "",
            "",
            "",
            "\1\174\1\uffff\12\57",
            "",
            "\1\176\16\uffff\1\175\2\uffff\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b\20\uffff\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0091\1\u0090",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094\15\uffff\1\u0095",
            "\1\u0097\1\u0096",
            "\1\u0098",
            "\1\u009a\1\uffff\1\u0099",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a6\12\uffff\1\u00a5",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00af\3\uffff\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7\21\uffff\1\u00b8",
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
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\13\56\6\uffff\15\56\1\u00c9\1\u00ca\13\56\4\uffff\1\56\1"+
            "\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00cc",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
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
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00e4",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e6",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\2\56\1\u00e8\1\56"+
            "\1\u00e7\25\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00f0\1\uffff\1\u00ef",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
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
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "",
            "\1\u010d",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u010f",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011c",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011e",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\2\56\1\u0120\27\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0122",
            "",
            "\1\u0123",
            "",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\10\56\1\u0130\21"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\13\56\6\uffff\15\56\1\u0137\4\56\1\u0138\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u013a",
            "",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0145",
            "\1\u0146",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "",
            "\1\u014c",
            "",
            "\1\u014d",
            "\1\u014e",
            "\13\56\6\uffff\15\56\1\u014f\14\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0151\2\uffff\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\13\56\6\uffff\13\56\1\u015a\16\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u015c",
            "",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0163",
            "\1\u0164",
            "\13\56\6\uffff\15\56\1\u0166\4\56\1\u0165\7\56\4\uffff\1\56"+
            "\1\uffff\32\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0168\15\uffff\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0176",
            "\1\u0177",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "",
            "\1\u017e",
            "\1\u017f",
            "",
            "",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0185\7\uffff\1\u0184",
            "\1\u0186",
            "\1\u0188\25\uffff\1\u0187",
            "",
            "\1\u0189",
            "\1\u018a",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u018c",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "",
            "\1\u0191",
            "",
            "\1\u0192",
            "\1\u0193",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0195",
            "\1\u0196",
            "\1\u0198\10\uffff\1\u0197",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01a2",
            "\1\u01a3",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01a5",
            "\1\u01a6",
            "",
            "",
            "\1\u01a7",
            "\1\u01a8",
            "",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b4",
            "\1\u01b5",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b7",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01b9",
            "\1\u01ba",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01bc",
            "\1\u01bd",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "",
            "\1\u01c2",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01c4",
            "\1\u01c5",
            "",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01cf",
            "\1\u01d0",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01d9\20\uffff\1\u01da\15\uffff\1\u01d8",
            "\1\u01db",
            "\1\u01dc",
            "\1\u01dd",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01e0",
            "",
            "\1\u01e1",
            "\1\u01e2",
            "",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\1\u01e8",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u01ea",
            "\1\u01eb",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01ed",
            "\1\u01ee",
            "\1\u01ef",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f2",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01f8",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01fb",
            "\1\u01fc",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u01fe",
            "\1\u01ff",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0202",
            "\1\u0203",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0205",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0207",
            "\1\u0208",
            "",
            "\1\u0209",
            "\1\u020a",
            "",
            "\1\u020b",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u020d",
            "",
            "",
            "\1\u020e",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0212",
            "",
            "",
            "\1\u0213",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0215",
            "\1\u0216",
            "",
            "",
            "\1\u0217",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u021b",
            "\1\u021c",
            "\1\u021d",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u021f",
            "\1\u0220",
            "",
            "",
            "",
            "\1\u0221",
            "\1\u0222",
            "",
            "\1\u0223",
            "\1\u0224",
            "\1\u0225",
            "",
            "",
            "",
            "\1\u0226",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0229",
            "\1\u022a",
            "\1\u022b",
            "\1\u022c",
            "\1\u022d",
            "\13\56\6\uffff\25\56\1\u022e\4\56\4\uffff\1\56\1\uffff\32"+
            "\56\105\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u0232",
            "\1\u0233",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0235",
            "\1\u0236",
            "\1\u0237",
            "",
            "",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0239",
            "",
            "\1\u023a",
            "\1\u023b",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u023d",
            "\1\u023e",
            "\1\u023f",
            "",
            "\1\u0240",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0242",
            "\1\u0243",
            "",
            "\1\u0244",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0246",
            "",
            "\13\56\6\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff"+
            "\27\56\1\uffff\37\56\1\uffff\10\56",
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
            return "1:1: Tokens : ( T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | T__131 | T__132 | T__133 | T__134 | T__135 | COMMENT | MULTI_LINE_COMMENT | LSQUARE | RSQUARE | DLSQUARE | DRSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | DLCURLY | DRCURLY | SEMI | COLON | DLCOLON | PIPE | SHARP | QMARK | DOLLAR | AROBAS | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | QNAME_OR_NAME | INT | FLOAT | STRING );";
        }
    }
 

}